
// Copyright (c) 2001 The Morton Arboretum
package org.vplants.bot.query;

import java.sql.*;
import java.util.Vector;
import org.vplants.bot.*;

/**
  * Select query bean for the SPECIMEN table - this bean selects only
  * summary information used to compare the database with the xml
  * documents as they are parsed.  Specifically, this bean grabs the
  * update dttm to see if the data has changed since the spider's last visit.
  * <P>
  * @author Matthew Schaub
  */
public class SpmHdrSelQuery extends QueryObject {
  static final int COL_COUNT = 1;
  static final String SEL_QUERY = "SELECT " +
                                  "TO_CHAR(REC_UPDATE_DTTM, \'YYYYMMDDHH24MI\') " +
                                  "FROM " +
                                  "SPECIMEN " +
                                  "WHERE HERB_CD = ? AND " +
                                  "SPM_ID = ?"
                                          ;

/**
  * Creates a select query object ready to access the database.
  * @param conn Database connection object
  */
  public SpmHdrSelQuery(Connection conn)
      throws SQLException {
      super(conn, SEL_QUERY);
  }

/**
  * Runs the specimen header select query, returning the update dttm.
  * @param herbCd Herbarium code
  * @param spmId Specimen identifier
  * @param String Update dttm YYYYMMDDHH24MI
  */
  public String executeQuery(String herbCd, String spmId)
    throws SQLException {

    String updttm = "";
    Vector rcache = new Vector();

    PreparedStatement statement = this.getStatement();

    statement.setString(1, herbCd);
    statement.setString(2, spmId);

    ResultSet rs = statement.executeQuery();
    if (rs.next())
      updttm = rs.getString(1);

    return updttm;
  }
}

