
// Copyright (c) 2001 The Morton Arboretum
package org.vplants.bot.query;

import java.sql.*;
import org.vplants.bot.*;
import java.lang.Integer;

/**
  * Insert query bean for the SITE_GEO table.
  * <P>
  * @author Matthew Schaub
  */
public class GeoInsQuery extends QueryObject {
    static final String INS_QUERY = "INSERT INTO SITE_GEO " +
"( " +
"SPM_ID, " +
"HERB_CD, " +
"STATE, " +
"COUNTY, " +
"TOWNSHIP, " +
"CITY, " +
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
    static final int STATE_I = 3;
    static final int COUNTY_I = 4;
    static final int TOWNSHIP_I = 5;
    static final int CITY_I = 6;

/**
  * Creates an insert query object ready to access the database. The
  * insert statement is prepared in the constructor but not executed
  * until the executeQuery method is called.
  * @param conn Database connection object
  */
  public GeoInsQuery(Connection conn)
      throws SQLException {
      super(conn, INS_QUERY);
  }

/**
  * Runs the insert query, inserting the given object data into the
  * database.
  * @param herbCd Herbarium code
  * @param spmId Specimen identifier
  * @param state State
  * @param county County
  * @param township Township
  * @param city City
  */
  public void executeQuery(String herbCd, String spmId,
                          String state, String county, String township, String city)
      throws SQLException  {

      PreparedStatement statement = this.getStatement();

      try {
          statement.setString(HERB_CD_I, herbCd);
          statement.setString(SPM_ID_I, spmId);
          statement.setString(STATE_I, state);
          statement.setString(COUNTY_I, county);
          statement.setString(TOWNSHIP_I, township);
          statement.setString(CITY_I, city);

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
