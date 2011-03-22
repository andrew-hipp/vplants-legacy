package org.vplants.bot;

import java.io.IOException;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
import java.util.Vector;
import java.util.Properties;
import java.lang.Integer;
import java.io.*;
import java.sql.*;
import org.vplants.arch.*;
import org.vplants.bot.query.*;

/**
  * Main class for the vPlants Spider.  This class connects to the database
  * then parses the index xml page, dispatching each taxon link to the TaxonWorker
  * class for further processing.  In the future, if we decide to implement
  * multithreading, this is the place to insert the necessary functionality.
  */
public class vPlantsSpider {
/** Database connection */
  private static Connection conn = null;

/** sax parsing object for the index page */
  private static XMLPipeline indexPipeline;
/** sax handler object for the index page */
  private static IndexHandler indexHandler;

/** parameter ini file */
  final static String INI_FILE = "vPlantsSpider.ini";
/** database connect string */
  private static String dbConnectString = "";
/** database username */
  private static String username = "";
/** database password */
  private static String password = "";

/** taxon counter */
  private static int taxonCount = 0;

/**
  * Main class
  */
  public static void main (String argv [])
  {
    // input parameter
    String jobId = "";
    int logLevel = Log.LOG_LEVEL_NORMAL;
    OptionsObject options = null;

    String startDttm = "";

    TaxonWorker taxonWorker = null;

    long t0 = System.currentTimeMillis();

    Log.setLevel(Log.LOG_LEVEL_ERROR);

    // grab the input parameters
    if (!((argv.length == 2) || (argv.length == 3))) {
      Log.log(Log.LOG_LEVEL_ERROR, "Usage: <job ID> <log level> <optional: log file>");
      System.exit(1);
    }

    // set the job identifier
    jobId = argv[0];

    // set the log level
    logLevel = new Integer(argv[1]).intValue();
    Log.setLevel(logLevel);

    if (argv.length == 3) {
      Log.setConsole(false);
      Log.setFile(true);
      Log.setPath(argv[2]);
    }

    Log.log(Log.LOG_LEVEL_NORMAL, "START: " + jobId);

    // grab properties from the property file
    try {
      Properties properties = new Properties();
      properties.load(new FileInputStream(INI_FILE));

      dbConnectString = properties.getProperty("DB_CONNECT_STRING");
      username = properties.getProperty("USERNAME");
      password = properties.getProperty("PASSWORD");

     } catch(FileNotFoundException e) {
      Log.logException("Opening parameter file: ", e);
      System.exit(1);
     } catch(IOException e) {
      Log.logException("Opening parameter file: ", e);
      System.exit(1);
     }

    // connect to the database
    if (!(databaseConnect())) {
      System.exit(1);
    }

    // grab the job specific parameters from the JOB_DTL table,
    // placing them into an options object.
    try {
      JobDtlSelQuery jobDtlSel = new JobDtlSelQuery(conn);
      options = jobDtlSel.executeQuery(jobId);
    } catch(SQLException e) {
      Log.logException("Selecting Job Details: ", e);
      System.exit(1);
    }

    if (options == null) {
      Log.log(Log.LOG_LEVEL_ERROR, "Select Job Details: No Parameters found for the given JOBID.");
      System.exit(1);
    }

    // if the run option is true, proceed...
    if (!options.isRun()) {
      Log.log(Log.LOG_LEVEL_NORMAL, "Run option set to false in JOB_DTL table.");
      System.exit(1);
    }

    // what options are we running with?
    Log.log(Log.LOG_LEVEL_TRACE, options.toString());

    // grab the current date and time to the hour for audit trail
    try {
      SysdateSelQuery sysdateSel = new SysdateSelQuery(conn);
      startDttm = sysdateSel.executeQuery("0.1");
      Log.log(Log.LOG_LEVEL_TRACE, "START_DTTM: " + startDttm);
    } catch(SQLException e) {
      Log.logException("Selecting Sysdate: ", e);
      System.exit(1);
      return;
    }

    // create an index pipeline w/ handler
	  try {
      indexHandler = new IndexHandler();
      indexPipeline = new XMLPipeline(indexHandler);

  	} catch (SAXException e) {
      Log.logException("Creating IndexHandler: ", e);
      System.exit(1);
	  }

    // Start Parsing!!!

    // start with the index page
    String uri = options.getUri();

    // if we are in smart mode, append the last visit dttm
    // to the index uri - this will query the server for
    // every record since our last visit
    if (options.isSmartMode())
      uri += "?last_visit=" + options.getLastVisitDttm();

    Log.log(Log.LOG_LEVEL_TRACE, "Starting with index uri: [" + uri + "]");

    // PARSE the index page
    try {
      indexPipeline.parse(uri);
    } catch (SAXException e) {
      Log.logException("Parsing Index Page [" + uri + "]: ", e);
      System.exit(1);
    } catch (IOException e) {
      Log.logException("Parsing Index Page [" + uri + "]: ", e);
      System.exit(1);
    }

    // Create the Taxon parser
    taxonWorker = new TaxonWorker(
                        options,                        // command options
                        indexHandler.getHerbCd(),       // herbarium code
                        conn);                          // database connection
    try {
      taxonWorker.initialize();
    } catch (SAXException e) {
      Log.logException("Creating Taxon Parser: ", e);
      System.exit(1);
    } catch (SQLException e) {
      Log.logException("Creating Taxon Parser: ", e);
      System.exit(1);
    }

    // loop through all the taxon pages, dispatching each to the
    // taxon processor.
    boolean proceed;
    Vector taxonVector = indexHandler.getTaxonVector();
    while (!taxonVector.isEmpty()) {
      taxonCount++;

      Log.log(Log.LOG_LEVEL_TRACE, "TAXON: " + taxonCount + " [" +
        taxonVector.firstElement().toString() + "]");

      proceed = taxonWorker.processTaxonLink(taxonVector.firstElement().toString());

      if (!proceed) {
        Log.log(Log.LOG_LEVEL_ERROR, "Max Errors exceeded!");
        System.exit(1);
      }

      taxonVector.removeElementAt(0);
    }

    try {
      taxonWorker.closeWorker();
    } catch(SQLException e) {
      Log.logException("Closing out Taxon Worker: ", e);
      System.exit(1);
    }

    // update the JOB_DTL table, indicating when this session started
    try {
      JobDtlUpdQuery jobDtlUpd = new JobDtlUpdQuery(conn);
      jobDtlUpd.executeQuery(startDttm, jobId);
      conn.commit();
    } catch(SQLException e) {
      Log.logException("Updating Job Details: ", e);
      System.exit(1);
    }

    long t1 = System.currentTimeMillis();

    long runTime = t1 - t0;
    Log.log(Log.LOG_LEVEL_NORMAL, "FINISH: " + jobId);
    Log.log(Log.LOG_LEVEL_NORMAL, "*************************************************************************");
    Log.log(Log.LOG_LEVEL_NORMAL, "Total Run Time= \t\t\t" + msToSecs(runTime));
    Log.log(Log.LOG_LEVEL_NORMAL, "Total Run Time= \t\t\t" + msToMins(runTime));
    Log.log(Log.LOG_LEVEL_NORMAL, "Taxon Pages Processed = \t\t" + taxonCount);
    Log.log(Log.LOG_LEVEL_NORMAL, "Specimen Pages Processed = \t\t" + taxonWorker.getSpmCount());
    Log.log(Log.LOG_LEVEL_NORMAL, "Specimen Page Inserts = \t\t" + taxonWorker.getInsertCount());
    Log.log(Log.LOG_LEVEL_NORMAL, "Specimen Page Updates = \t\t" + taxonWorker.getUpdateCount());
    Log.log(Log.LOG_LEVEL_NORMAL, "Total Errors = \t\t\t" + taxonWorker.getErrorCount());
    Log.log(Log.LOG_LEVEL_NORMAL, "*************************************************************************");

    if (taxonWorker.getErrorCount() > 0)
      System.exit(1);
    else
      System.exit(0);
  }

/** Method used to convert milliseconds to seconds.
  * @return String representation of the seconds.
  */
	private static String msToSecs(long t) {
		return t/1000 + "." + t%1000 + " seconds";
	}

/** Method used to convert milliseconds to minutes/seconds.
  * @return String representation of the minutes and seconds.
  */
	private static String msToMins(long t) {
		return (t/1000)/60 + " minutes, " + (t/1000)%60 + " seconds";
	}

/**
  * Connect to database - loads conn object with necessary information.
  * @return boolean Did the connect work? T/F
  */
  private static boolean databaseConnect()
  {
    boolean ret = false;

    try {
       Class.forName("oracle.jdbc.driver.OracleDriver");
       conn = DriverManager.getConnection(dbConnectString, username, password);
       conn.setAutoCommit(false);
       ret = true;
     } catch(java.lang.ClassNotFoundException e) {
       Log.logException("Database Connect: ", e);
       conn = null;
     } catch(SQLException e) {
       Log.logException("Database Connect: ", e);
       conn = null;
     }

     return ret;
  }

/**
  * Converts string "Y" to boolean true, everything else to false.
  * @param in String value
  * @return boolean "Y" = true, else false
  */
  private static boolean toBoolean(String in) {
    return "Y".equals(in);
  }
}
