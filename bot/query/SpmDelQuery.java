
// Copyright (c) 2001 The Morton Arboretum
package org.vplants.bot.query;

import java.sql.*;
import org.vplants.bot.*;
import java.lang.Integer;

/**
  * Delete query bean for the SPECIMEN table.  Thanks to foriegn keys, all
  * rows corresponding to the deleted specimen in other tables are also
  * deleted via a CASCADING DELETE.
  * <P>
  * @author Matthew Schaub
  */
public class SpmDelQuery extends QueryObject {
    static final String DEL_QUERY = "DELETE FROM SPECIMEN " +
                                    "WHERE HERB_CD = ? AND SPM_ID = ? "
;

    static final int HERB_CD_I = 1;
    static final int SPM_ID_I = 2;

/**
  * Delete constructor.
  * @param conn Database connection object
  */
  public SpmDelQuery(Connection conn)
      throws SQLException {
      super(conn, DEL_QUERY);
  }

/**
  * Runs the delete query, deleting the given specimen from the database.
  * @param herbCd Herbarium code
  * @param spmId Specimen identifier
  */
  public void executeQuery(String herbCd, String spmId)
      throws SQLException  {

      PreparedStatement statement = this.getStatement();

      try {
          statement.setString(HERB_CD_I, herbCd);
          statement.setString(SPM_ID_I, spmId);

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
