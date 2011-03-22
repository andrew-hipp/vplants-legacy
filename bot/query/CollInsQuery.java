
// Copyright (c) 2001 The Morton Arboretum
package org.vplants.bot.query;

import java.sql.*;
import org.vplants.bot.*;
import java.lang.Integer;

/**
  * Insert query bean for the COLLECTOR table.
  * <P>
  * @author Matthew Schaub
  */
public class CollInsQuery extends QueryObject {
    static final String INS_QUERY = "INSERT INTO COLLECTOR " +
"( " +
"SPM_ID, " +
"HERB_CD, " +
"L_NAME, " +
"F_NAME, " +
"M_NAME, " +
"PRIMARY_IND, " +
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
    static final int L_NAME_I = 3;
    static final int F_NAME_I = 4;
    static final int M_NAME_I = 5;
    static final int PRIMARY_IND_I = 6;

/**
  * Creates an insert query object ready to access the database. The
  * insert statement is prepared in the constructor but not executed
  * until the executeQuery method is called.
  * @param conn Database connection object
  */
  public CollInsQuery(Connection conn)
      throws SQLException {
      super(conn, INS_QUERY);
  }

/**
  * Runs the insert query, inserting the given object data into the
  * database.
  * @param herbCd Herbarium code
  * @param spmId Specimen identifier
  * @param coll Collector object
  * @param primaryInd Primary indicator
  */
  public void executeQuery(String herbCd, String spmId,
                          CollectorObject coll, String primaryInd)
      throws SQLException  {

      PreparedStatement statement = this.getStatement();

      try {
          statement.setString(HERB_CD_I, herbCd);
          statement.setString(SPM_ID_I, spmId);
          statement.setString(L_NAME_I, coll.getLname());
          statement.setString(F_NAME_I, coll.getFname());
          statement.setString(M_NAME_I, coll.getMname());
          statement.setString(PRIMARY_IND_I, primaryInd);

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
