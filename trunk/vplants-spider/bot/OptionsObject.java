
// Copyright (c) 2000 The Morton Arboretum
package org.vplants.bot;

/**
 * An object for storing execution parameters for the spider.
 * <P>
 * @author Matthew Schaub
 */
public class OptionsObject extends Object {
/** Job identifier - used to select parameters from a job database table */
  private String jobId = "";
/** Starting point URI for the index xml page */
  private String uri = "";
/** How many threads should execute? Multi-threading is currently not supported */
  private int threads = 1;
/** How often should a database commit be executed */
  private int commitFreq = 1;
/** Maximum error count before terminating the spider's execution */
  private int maxErrors = 50;
/** Should the spider utilize the update dttm present in the taxon layer */
  private boolean updttmMode = true;
/** Should the spider provide the date of it's last visit to the index page -
  * if implemented at the client node, this additional parameter would allow
  * the client to supply only the changes that have happenend since the spiders
  * last visit.
  */
  private boolean smartMode = false;
/** Should the spider run? */
  private boolean run = false;
/** Last visit for the spider - MMDDYYYYHH24 */
  private String lastVisitDttm = "";

/**
  * Constructor
  * @param jobId Unique job identifier
  * @param uri Index URI
  * @param threads How many threads?
  * @param commitFreq What is the commit frequency?
  * @param maxErrors Maximum errors before terminating execution?
  * @param updttmMode Should we use the taxon layers updttm?
  * @param smartMode Should we include the last visit dttm in the taxon uri?
  * @param run Should the spider execute?
  * @param lastVisitDttm When was the spider's last visit?
  */
  public OptionsObject(
    String jobId,
    String uri,
    int threads,
    int commitFreq,
    int maxErrors,
    boolean updttmMode,
    boolean smartMode,
    boolean run,
    String lastVisitDttm
  ) {
    this.jobId = jobId;
    this.uri = uri;
    this.threads = threads;
    this.commitFreq = commitFreq;
    this.maxErrors = maxErrors;
    this.updttmMode = updttmMode;
    this.smartMode = smartMode;
    this.run = run;
    this.lastVisitDttm = lastVisitDttm;
  }

/**
  * Default Constructor - creates an empty options object.
  */
  public OptionsObject() {
    this("","",1,1,50,false,false,false,"");
  }

/**
  * Get the job identifier.
  * @return String job identifier
  */
  public String getJobId() {
    return jobId;
  }

/**
  * Get the index uri
  * @return String Index URI
  */
  public String getUri() {
    return uri;
  }

/**
  * Get the thread count.
  * @return int Thread count
  */
  public int getThreads() {
    return threads;
  }

/**
  * Get the commit frequency.
  * @return int Commit frequency
  */
  public int getCommitFreq() {
    return commitFreq;
  }

/**
  * Get the maximum error count.
  * @return int Maximum error count
  */
  public int getMaxErrors() {
    return maxErrors;
  }

/**
  * Are we using the updttm in the taxon layer.  If yes, the spider will
  * compare the date to it's last visit before processing the taxon's specimen
  * pages (if nothing has changed since the last visit, it won't visit the
  * specimen pages).  If no, the spider will simply visit every single specimen
  * page regardless if it's been modified.
  * @return boolean Using updttm in taxon layer? T/F
  */
  public boolean isUpdttmMode() {
    return updttmMode;
  }

/**
  * Are we using smart mode for the spider.  In smart mode, the spider will
  * provide the last visit dttm (?last_visit=MMDDYYYYHH24) in the url as a parameter to
  * the taxon page.  If implemented at the client node, the parameter can then
  * be used to supply the spider with incremental changes to the metadata.
  * This would save the spider the time of visiting each taxon page however it
  * does require more "heavyweight plumbing" to respond to the query.
  * @return boolean In smart mode? T/F
  */
  public boolean isSmartMode() {
    return smartMode;
  }

/**
  * Should the spider run for the current job id?  This allows us to stop a job
  * run without having to modify the servers crontab file (it's easier to simply
  * flip this switch in the database).
  * @return boolean Should this job id run? T/F
  */
  public boolean isRun() {
    return run;
  }

/**
  * Get the last time the spider visit the current site (MMDDYYYYHH24).
  * @return String MMDDYYYYHH24
  */
  public String getLastVisitDttm() {
    return lastVisitDttm;
  }

/**
  * Convert the options object into a human readable string format.
  * @return String Summary of options in readable format
  */
  public String toString() {
    return
      "\n\tJOB_ID: " + jobId + "\n" +
      "\tURI: " + uri + "\n" +
      "\tTHREADS: " + threads + "\n" +
      "\tCOMMIT_FREQ: " + commitFreq + "\n" +
      "\tMAX_ERRORS: " + maxErrors + "\n" +
      "\tUPDTTM_MODE: " + updttmMode + "\n" +
      "\tSMART_MODE: " + smartMode + "\n" +
      "\tRUN: " + run + "\n" +
      "\tLAST_VISIT_DTTM: " + lastVisitDttm + "\n";      
  }
}
