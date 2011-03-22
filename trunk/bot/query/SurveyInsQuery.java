
// Copyright (c) 2001 The Morton Arboretum
package org.vplants.bot.query;

import java.sql.*;
import org.vplants.bot.*;
import java.lang.Integer;

/**
  * Insert query bean for the SITE_SURVEY table.
  * <P>
  * @author Matthew Schaub
  */
public class SurveyInsQuery extends QueryObject {
    static final String INS_QUERY = "INSERT INTO SITE_SURVEY " +
"( " +
"SPM_ID, " +
"HERB_CD, " +
"TWP, " +
"TWP_DIR, " +
"RNG, " +
"RNG_DIR, " +
"SECT, " +
"SECT_CMTS, " +
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
"?, " +
"?, " +
"SYSDATE, " +
"SYSDATE " +
")"
;

    static final int SPM_ID_I = 1;
    static final int HERB_CD_I = 2;
    static final int TWP_I = 3;
    static final int TWP_DIR_I = 4;
    static final int RNG_I = 5;
    static final int RNG_DIR_I = 6;
    static final int SECT_I = 7;
    static final int SECT_CMTS_I = 8;

/**
  * Creates an insert query object ready to access the database. The
  * insert statement is prepared in the constructor but not executed
  * until the executeQuery method is called.
  * @param conn Database connection object
  */
  public SurveyInsQuery(Connection conn)
      throws SQLException {
      super(conn, INS_QUERY);
  }

/**
  * Runs the insert query, inserting the given object data into the
  * database.
  * @param herbCd Herbarium code
  * @param spmId Specimen identifier
  * @param twp Township value
  * @param twpDir Township direction
  * @param rng Range value
  * @param rngDir Range direction
  * @param sect Section value
  * @param sectCmts Section Comments
  */
  public void executeQuery(String herbCd, String spmId,
                          String twp, String twpDir,
                          String rng, String rngDir,
                          String sect, String sectCmts)
      throws SQLException  {

      PreparedStatement statement = this.getStatement();

      try {
          statement.setString(HERB_CD_I, herbCd);
          statement.setString(SPM_ID_I, spmId);
          statement.setString(TWP_I, twp);
          statement.setString(TWP_DIR_I, twpDir);
          statement.setString(RNG_I, rng);
          statement.setString(RNG_DIR_I, rngDir);
          statement.setString(SECT_I, sect);
          statement.setString(SECT_CMTS_I, sectCmts);

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
