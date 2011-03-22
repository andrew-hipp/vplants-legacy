
// Copyright (c) 2001 The Morton Arboretum
package org.vplants.bot.query;

import java.sql.*;
import org.vplants.bot.*;
import java.lang.Integer;

/**
  * Insert query bean for the SPM_PAGE table.
  * <P>
  * @author Matthew Schaub
  */
public class SpmPageInsQuery extends QueryObject {
    static final String INS_QUERY = "INSERT INTO SPM_PAGE " +
"( " +
"SPM_ID, " +
"HERB_CD, " +
"URI, " +
"MORE_LOC, " +
"MORE_HAB, " +
"MORE_DESC, " +
"MORE_ASSOC, " +
"MORE_ANNOT, " +
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
    static final int URI_I = 3;
    static final int MORE_LOC_I = 4;
    static final int MORE_HAB_I = 5;
    static final int MORE_DESC_I = 6;
    static final int MORE_ASSOC_I = 7;
    static final int MORE_ANNOT_I = 8;

/**
  * Creates an insert query object ready to access the database. The
  * insert statement is prepared in the constructor but not executed
  * until the executeQuery method is called.
  * @param conn Database connection object
  */
  public SpmPageInsQuery(Connection conn)
      throws SQLException {
      super(conn, INS_QUERY);
  }

/**
  * Runs the insert query, inserting the given object data into the
  * database.
  * @param herbCd Herbarium code
  * @param spmId Specimen identifier
  * @param uri URI for the specimen homepage
  * @param moreLoc Is there more location data?
  * @param moreHab Is there more habitat data?
  * @param moreDesc Is there more descriptive data?
  * @param moreAssoc Is there more association data?
  * @param moreAnnot Is there more annotation data?
  */
  public void executeQuery(String herbCd, String spmId,
                          String uri, String moreLoc,
                          String moreHab, String moreDesc,
                          String moreAssoc, String moreAnnot)
      throws SQLException  {

      PreparedStatement statement = this.getStatement();

      try {
          statement.setString(HERB_CD_I, herbCd);
          statement.setString(SPM_ID_I, spmId);
          statement.setString(URI_I, uri);
          statement.setString(MORE_LOC_I, moreLoc);
          statement.setString(MORE_HAB_I, moreHab);
          statement.setString(MORE_DESC_I, moreDesc);
          statement.setString(MORE_ASSOC_I, moreAssoc);
          statement.setString(MORE_ANNOT_I, moreAnnot);

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
