
// Copyright (c) 2001 The Morton Arboretum
package org.vplants.bot.query;

import java.sql.*;
import org.vplants.bot.*;
import java.lang.Integer;

/**
  * Insert query bean for the SITE_GLOBAL table.
  * <P>
  * @author Matthew Schaub
  */
public class GlobalInsQuery extends QueryObject {
    static final String INS_QUERY = "INSERT INTO SITE_GLOBAL " +
"( " +
"SPM_ID, " +
"HERB_CD, " +
"LAT_DD, " +
"LAT_DIR, " +
"LONG_DD, " +
"LONG_DIR, " +
"CREATE_DTTM, " +
"UPDATE_DTTM " +
") " +
"VALUES " +
"( " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"?, " +
"SYSDATE, " +
"SYSDATE " +
")"
;

    static final int SPM_ID_I = 1;
    static final int HERB_CD_I = 2;
    static final int LAT_DD_I = 3;
    static final int LAT_DIR_I = 4;
    static final int LONG_DD_I = 5;
    static final int LONG_DIR_I = 6;

/**
  * Creates an insert query object ready to access the database. The
  * insert statement is prepared in the constructor but not executed
  * until the executeQuery method is called.
  * @param conn Database connection object
  */
  public GlobalInsQuery(Connection conn)
      throws SQLException {
      super(conn, INS_QUERY);
  }

/**
  * Runs the insert query, inserting the given object data into the
  * database.
  * @param herbCd Herbarium code
  * @param spmId Specimen identifier
  * @param latDD Latitude decimal degrees
  * @param latDir Latitude direction
  * @param longDD Longitude decimal degrees
  * @param longDir Longitude direction
  */
  public void executeQuery(String herbCd, String spmId,
                          String latDD, String latDir, String longDD, String longDir)
      throws SQLException  {

      PreparedStatement statement = this.getStatement();

      try {
          statement.setString(HERB_CD_I, herbCd);
          statement.setString(SPM_ID_I, spmId);
          statement.setString(LAT_DD_I, latDD);
          statement.setString(LAT_DIR_I, latDir);
          statement.setString(LONG_DD_I, longDD);
          statement.setString(LONG_DIR_I, longDir);

          // execute the query
          statement.executeUpdate();

      } catch (SQLException e) {
          // propagate the exception to the caller
          throw e;
      }
      finally {

          if (statement != null) {

              // reset the database parameters in statement
              statement.clearParameters();
          }
      }
  }
}
