
// Copyright (c) 2001 The Morton Arboretum
package org.vplants.bot.query;

import java.sql.*;
import org.vplants.bot.*;
import java.lang.Integer;

/**
  * Insert query bean for the SPM_IMAGE table.
  * <P>
  * @author Matthew Schaub
  */
public class SpmImageInsQuery extends QueryObject {
    static final String INS_QUERY = "INSERT INTO SPM_IMAGE " +
"( " +
"SPM_ID, " +
"HERB_CD, " +
"URI, " +
"TYPE_CD, " +
"FORMAT_CD, " +
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
"SYSDATE, " +
"SYSDATE " +
")"
;

    static final int SPM_ID_I = 1;
    static final int HERB_CD_I = 2;
    static final int URI_I = 3;
    static final int TYPE_CD_I = 4;
    static final int FORMAT_CD_I = 5;

/**
  * Creates an insert query object ready to access the database. The
  * insert statement is prepared in the constructor but not executed
  * until the executeQuery method is called.
  * @param conn Database connection object
  */
  public SpmImageInsQuery(Connection conn)
      throws SQLException {
      super(conn, INS_QUERY);
  }

/**
  * Runs the insert query, inserting the given object data into the
  * database.
  * @param herbCd Herbarium code
  * @param spmId Specimen identifier
  * @param image Image Object
  */
  public void executeQuery(String herbCd, String spmId, ImageObject image)
      throws SQLException  {

      PreparedStatement statement = this.getStatement();

      try {
          statement.setString(HERB_CD_I, herbCd);
          statement.setString(SPM_ID_I, spmId);
          statement.setString(URI_I, image.getURI());
          statement.setString(TYPE_CD_I, image.getTypeCd());
          statement.setString(FORMAT_CD_I, image.getFormatCd());

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
