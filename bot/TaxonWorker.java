// Copyright (c) 2000 The Morton Arboretum
package org.vplants.bot;

import java.util.Vector;
import java.util.HashMap;
import java.util.Iterator;
import org.xml.sax.*;
import java.io.IOException;
import java.sql.*;
import org.vplants.bot.query.*;
import org.vplants.arch.*;

/**
 * This object processes a taxon page, parsing xml data and potentially
 * visiting specimen level pages.
 * <P>
 * @author Matthew Schaub
 */
public class TaxonWorker extends Object {
/** current herbarium code */
  private String herbCd;
/** database connection */
  private Connection conn;

/** taxon level xml pipeline - parsing framework for xml */
  private static XMLPipeline taxonPipeline;
/** taxon level handler - packages xml data */
  private static TaxonHandler taxonHandler;

/** specimen level xml pipeline - parsing framework for xml */
  private static XMLPipeline spmPipeline;
/** specimen level handler - packages xml data */
  private static SpmHandler spmHandler;

/** Specimen insert query */
  private static SpmInsQuery spmIns;
/** Specimen delete query */
  private static SpmDelQuery spmDel;
/** Collector insert query */
  private static CollInsQuery collIns;
/** Location insert query */
  private static LocInsQuery locIns;
/** Habitat insert query */
  private static HabInsQuery habIns;
/** Geography insert query */
  private static GeoInsQuery geoIns;
/** Global Coordinates insert query */
  private static GlobalInsQuery globalIns;
/** Site Survey insert query */
  private static SurveyInsQuery surveyIns;
/** Specimen Homepage insert query */
  private static SpmPageInsQuery spmPageIns;
/** Specimen Image insert query */
  private static SpmImageInsQuery spmImageIns;
/** Specimen header information select query */
  private static SpmHdrSelQuery spmHdrSel;

/** execution options object */
  private static OptionsObject options;

/** Specimen count */
  private static int spmCount = 0;
/** Error count */
  private static int errorCount = 0;
/** Insert count */
  private static int insertCount = 0;
/** Update count */
  private static int updateCount = 0;

/**
  * Constructor.
  * @param option Options object
  * @param herbCd Herbarium code
  * @param conn Database connection
  */
  public TaxonWorker(
      OptionsObject options,
      String herbCd,
      Connection conn)
  {
    this.options = options;
    this.herbCd = herbCd;
    this.conn = conn;
  }

/**
  * Default Constructor - creates empty object.
  */
  public TaxonWorker()
  {
    this(null, "", null);
  }

/**
  * Initialize all objects and database queries
  */
  public void initialize()
  throws SAXException, SQLException
  {
    taxonHandler = new TaxonHandler();
    taxonPipeline = new XMLPipeline(taxonHandler);

    spmHandler = new SpmHandler();
    spmPipeline = new XMLPipeline(spmHandler);

    spmIns = new SpmInsQuery(conn);
    spmDel = new SpmDelQuery(conn);
    spmHdrSel = new SpmHdrSelQuery(conn);
    collIns = new CollInsQuery(conn);
    locIns = new LocInsQuery(conn);
    habIns = new HabInsQuery(conn);
    geoIns = new GeoInsQuery(conn);
    globalIns = new GlobalInsQuery(conn);
    surveyIns = new SurveyInsQuery(conn);
    spmPageIns = new SpmPageInsQuery(conn);
    spmImageIns = new SpmImageInsQuery(conn);
  }

/**
  * Parse the given taxon uri, extracting the specimen header records and
  * processing them accordingly.
  * @param taxonLink URI for taxon page
  */
  public boolean processTaxonLink(String taxonLink)
  {

    // parse the supplied taxon page
    try {
      taxonPipeline.parse(taxonLink);
    } catch (Exception e) {
      Log.logBriefException("Taxon Parse [" + taxonLink + "]: ", e);
      errorCount++;
      if (isMaxErrors())
        return false;
      else
        return true;
    }

    TaxonObject taxonObject = taxonHandler.getTaxonObject();

    // grab the XML specimen headers
    Vector spmHdrs = taxonObject.getSpmHdrs();

    // process each specimen header object...
    while (!(spmHdrs.isEmpty())) {

        //  grab the specimen object
        SpmHdrObject spmHdr = (SpmHdrObject)spmHdrs.firstElement();
        spmHdrs.removeElementAt(0);
        Log.log(Log.LOG_LEVEL_TRACE, spmHdr.getSpmId() + " [" +spmHdr.getUpdttm().getTime().toString() + "]" + "...");

        try {

          // check and see if the current specimen is already in the database...
          spmHdr.setDBUpdttm(spmHdrSel.executeQuery(herbCd, spmHdr.getSpmId()));

          // the big question...do we need to visit the specimen page?

/* We are dealing with 2 different processing modes for the spider,
   distinguished by updttmMode:

TRUE  - in this mode, the bot will compare the updttm of the XML data and the
        record currently stored in the database.  If they differ, the record
        will be updated in the database.

FALSE - in this mode, the bot doesn't analyze any timestamps.  It processes
        every record regardless of the timestamp
*/
// we do inserts regardless of the mode...
          if (spmHdr.isInsert())
            processInsert(taxonObject.getNameCode(), spmHdr);
          else {

// if we are in UpdttmMode...
            if (options.isUpdttmMode()) {

// check to see if this is an update based on a date comparison
              if (spmHdr.isUpdate())
// if the dates differ, do an update
                processUpdate(taxonObject.getNameCode(), spmHdr);
              else
// else, don't do anything
                Log.log(Log.LOG_LEVEL_DUMP, "SPM: NO CHANGE");
            }
            else {
// if we are in dumb mode, process the update
              processUpdate(taxonObject.getNameCode(), spmHdr);

            }

          }

          spmCount++;
          if ((spmCount % options.getCommitFreq()) == 0) {
            Log.log(Log.LOG_LEVEL_DUMP, "COMMIT: FREQUENCY");
            conn.commit();
          }
        } catch (Exception e) {
          Log.logBriefException("Spm Parse [" + spmHdr.getLink() + "]: ", e);
          errorCount++;
          if (isMaxErrors())
            return false;
        }

      }

      try {
        Log.log(Log.LOG_LEVEL_DUMP, "COMMIT: CLOSEOUT TAXON");
        conn.commit();
      } catch (Exception e) {
        Log.logException("Commit - Closeout Taxon: ", e);
        errorCount++;
        return isMaxErrors();
      }

    return true;
  }

/**
  * Have we reached the maximum error count? T/F
  * @return boolean Maximum error count reached? T/F
  */
  private boolean isMaxErrors() {
    if (errorCount >= options.getMaxErrors())
      return true;
    else
      return false;
  }

/**
  * Parse a specimen page, inserting it's data into the database.
  * @param nameCode Current checklist name code
  * @param spmHdr Specimen header object
  */
  private void processInsert(String nameCode, SpmHdrObject spmHdr)
  throws SAXException, IOException, SQLException {
    Log.log(Log.LOG_LEVEL_DUMP, "SPM: INSERT");
    spmPipeline.parse(spmHdr.getLink());

    insert(nameCode, spmHdr);
    insertCount++;
  }

/**
  * Parse a specimen page, updating it's data in the database.
  * @param nameCode Current checklist name code
  * @param spmHdr Specimen header object
  */
  private void processUpdate(String nameCode, SpmHdrObject spmHdr)
  throws SAXException, IOException, SQLException {
    Log.log(Log.LOG_LEVEL_DUMP, "SPM: UPDATE");
    spmPipeline.parse(spmHdr.getLink());

// Design Decision - instead of creating complex update functionality, I'm
// going to treat an update like a delete/insert.  Updates should be
// infrequent as the data does not change a lot therefore I prefer the simple solution.
// If it causes problems, like fragmented indexes, we can certainly
// change this to more elaborate processing that compares the actual XML data
// to the database and only updates the pieces that have changed. - mcs 08/02/2002
    spmDel.executeQuery(herbCd, spmHdr.getSpmId());

    insert(nameCode, spmHdr);
    updateCount++;
  }

/**
  * Insert specimen details into the specimen tables.
  * @param nameCode Current checklist name code
  * @param spmHdr Specimen header object
  */
  private void insert(String nameCode, SpmHdrObject spmHdr)
  throws SQLException
  {
    SpmObject spm = spmHandler.getSpmObject();
    String spmId = spmHdr.getSpmId();

    // insert specimen table
    spmIns.executeQuery(this.herbCd, nameCode, spmHdr, spm);

    // insert primary collector
    if (spm.hasPrimaryColl())
      collIns.executeQuery(this.herbCd, spmId, spm.getPColl(), "Y");

    // insert any secondary collectors
    if (spm.getSColl().size() > 0) {
      Vector scollV = spm.getSColl();
      while (!(scollV.isEmpty())) {
        collIns.executeQuery(this.herbCd, spmId,
          (CollectorObject)scollV.firstElement(), "N");
        scollV.removeElementAt(0);
      }
    }

    // insert locality
    if (spm.hasLocality())
      locIns.executeQuery(this.herbCd, spmId, spm.getLocality());

    // insert habitat
    if (spm.hasHabitat())
      habIns.executeQuery(this.herbCd, spmId, spm.getHabitat());

    // insert site_geo
    if (spm.hasSiteGeo())
      geoIns.executeQuery(this.herbCd, spmId, spm.getState(), spm.getCounty(),
          spm.getTownship(), spm.getCity());

    // insert site_global
    if (spm.hasSiteGlobal())
      globalIns.executeQuery(this.herbCd, spmId, spm.getLatDD(), spm.getLatDir(),
          spm.getLongDD(), spm.getLongDir());

    // insert site_survey
    if (spm.hasSiteSurvey())
      surveyIns.executeQuery(this.herbCd, spmId,
        spm.getTwpNum(), spm.getTwpDir(),
        spm.getRngNum(), spm.getRngDir(),
        spm.getSecNum(), spm.getSecDtl());

    // insert spm_page
    if (spm.hasSpmPage())
      spmPageIns.executeQuery(this.herbCd, spmId, spm.getHpURI(),
        spm.getHpLoc(), spm.getHpHab(), spm.getHpDesc(), spm.getHpAssoc(),
        spm.getHpAnnot());

    // insert any spm_images
    if (spm.getImages().size() > 0) {
      Vector imagesV = spm.getImages();
      while (!(imagesV.isEmpty())) {
        spmImageIns.executeQuery(this.herbCd, spmId,
          (ImageObject)imagesV.firstElement());
        imagesV.removeElementAt(0);
      }
    }
  }

/*
        System.err.println("***************************************************");

        System.err.println("COLL DATE: " + spmHandler.getSpmObject().getCollDate());
        System.err.println("COLL DATE MASK: " + spmHandler.getSpmObject().getCollDateMask());
        System.err.println("PCOLL: " + spmHandler.getSpmObject().getPColl().toString());
        System.err.println("SCOLL: " + spmHandler.getSpmObject().getSColl().toString());
        System.err.println("COLL_NBR: " + spmHandler.getSpmObject().getCollNbr());
        System.err.println("STATE: " + spmHandler.getSpmObject().getState());
        System.err.println("COUNTY: " + spmHandler.getSpmObject().getCounty());
        System.err.println("CITY: " + spmHandler.getSpmObject().getCity());
        System.err.println("TOWNSHIP: " + spmHandler.getSpmObject().getTownship());
        System.err.println("TWPNUM: " + spmHandler.getSpmObject().getTwpNum());
        System.err.println("TWPDIR: " + spmHandler.getSpmObject().getTwpDir());
        System.err.println("RNGNUM: " + spmHandler.getSpmObject().getRngNum());
        System.err.println("RNGDIR: " + spmHandler.getSpmObject().getRngDir());
        System.err.println("SECNUM: " + spmHandler.getSpmObject().getSecNum());
        System.err.println("SECDTL: " + spmHandler.getSpmObject().getSecDtl());
        System.err.println("LATDIR: " + spmHandler.getSpmObject().getLatDir());
        System.err.println("LATDD: " + spmHandler.getSpmObject().getLatDD());
        System.err.println("LONGDIR: " + spmHandler.getSpmObject().getLongDir());
        System.err.println("LONGDD: " + spmHandler.getSpmObject().getLongDD());
        System.err.println("LOCALITY: " + spmHandler.getSpmObject().getLocality());
        System.err.println("HABITAT: " + spmHandler.getSpmObject().getHabitat());
        System.err.println("TYPESPM: " + spmHandler.getSpmObject().isTypeSpm());
        System.err.println("CRDATE: " + spmHandler.getSpmObject().getCrDate());
        System.err.println("HPURI: " + spmHandler.getSpmObject().getHpURI());
        System.err.println("HPLOC: " + spmHandler.getSpmObject().getHpLoc());
        System.err.println("HPHAB: " + spmHandler.getSpmObject().getHpHab());
        System.err.println("HPDESC: " + spmHandler.getSpmObject().getHpDesc());
        System.err.println("HPASSOC: " + spmHandler.getSpmObject().getHpAssoc());
        System.err.println("HPANNOT: " + spmHandler.getSpmObject().getHpAnnot());
        System.err.println("IMAGES: " + spmHandler.getSpmObject().getImages());

        System.err.println("***************************************************");
*/

/**
  * Close the worker class, closing all database statements.
  */
  public void closeWorker()
  throws SQLException {

    spmIns.closeStatement();
    spmDel.closeStatement();
    spmHdrSel.closeStatement();
    collIns.closeStatement();
    locIns.closeStatement();
    habIns.closeStatement();
    geoIns.closeStatement();
    globalIns.closeStatement();
    surveyIns.closeStatement();
    spmPageIns.closeStatement();
    spmImageIns.closeStatement();

    conn.commit();
  }

/**
  * Get the specimen count.
  * @return int Specimen count
  */
  public int getSpmCount() {
    return this.spmCount;
  }

/**
  * Get the error count.
  * @return int Error count
  */
  public int getErrorCount() {
    return errorCount;
  }

/**
  * Get the insert count.
  * @return int Insert count
  */
  public int getInsertCount() {
    return insertCount;
  }

/**
  * Get the update count.
  * @return int Update count
  */
  public int getUpdateCount() {
    return updateCount;
  }
}
