
// Copyright (c) 2001 The Morton Arboretum
package org.vplants.bot.query;

import java.sql.*;
import java.util.Vector;
import org.vplants.bot.*;

/**
  * Query bean for the JOB_DTL table.  This table stores run options
  * based on unique job ids.
  * <P>
  * @author Matthew Schaub
  */
public class JobDtlSelQuery extends QueryObject {
  static final int COL_COUNT = 8;
  static final String SEL_QUERY = "SELECT " +
                                  "URI, " +
                                  "THREADS, " +
                                  "COMMIT_FREQ, " +
                                  "MAX_ERRORS, " +
                                  "UPDTTM_MODE_IND, " +
                                  "SMART_MODE_IND, " +
                                  "RUN_IND, " +
                                  "TO_CHAR(LAST_VISIT_DTTM, \'MMDDYYYYHH24\') " +
                                  "FROM " +
                                  "JOB_DTL " +
                                  "WHERE " +
                                  "JOB_ID = ?"
                                          ;

  static final int URI_I = 1;
  static final int THREADS_I = 2;
  static final int COMMIT_FREQ_I = 3;
  static final int MAX_ERRORS_I = 4;
  static final int UPDTTM_MODE_IND_I = 5;
  static final int SMART_MODE_IND_I = 6;
  static final int RUN_IND_I = 7;
  static final int LAST_VISIT_DTTM_I = 8;

/**
  * Bean constructor.
  * @param conn Database connection object
  */
  public JobDtlSelQuery(Connection conn)
      throws SQLException {
      super(conn, SEL_QUERY);
  }

/**
  * Executes the query, returning the options object
  * @param jobId Unique job identifier
  * @return OptionsObject Object w/ option information
  */
  public OptionsObject executeQuery(String jobId)
    throws SQLException {

    OptionsObject options = null;

    PreparedStatement statement = this.getStatement();

    statement.setString(1, jobId);

    ResultSet rs = statement.executeQuery();
    if (rs.next()) {
      options = new OptionsObject(jobId,
        rs.getString(this.URI_I),
        rs.getInt(this.THREADS_I),
        rs.getInt(this.COMMIT_FREQ_I),
        rs.getInt(this.MAX_ERRORS_I),
        toBoolean(rs.getString(this.UPDTTM_MODE_IND_I)),
        toBoolean(rs.getString(this.SMART_MODE_IND_I)),
        toBoolean(rs.getString(this.RUN_IND_I)),
        rs.getString(this.LAST_VISIT_DTTM_I)
      );
    }

    return options;
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
