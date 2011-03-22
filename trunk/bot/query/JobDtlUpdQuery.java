
// Copyright (c) 2001 The Morton Arboretum
package org.vplants.bot.query;

import java.sql.*;
import org.vplants.bot.*;
import java.lang.Integer;

/**
  * Update query bean for the JOB_DTL table.  Sets the last visit
  * date-timestamp.
  * <P>
  * @author Matthew Schaub
  */
public class JobDtlUpdQuery extends QueryObject {
    static final String UPD_QUERY =
"UPDATE JOB_DTL SET LAST_VISIT_DTTM = TO_DATE(?, 'MMDDYYYYHH24') " +
"WHERE JOB_ID = ?";

/**
  * Update bean constructor.
  * @param conn Database connection
  */
  public JobDtlUpdQuery(Connection conn)
      throws SQLException {
      super(conn, UPD_QUERY);
  }

/**
  * Runs the update query, updating the given jobId's last visit
  * date-timestamp.
  * @param lastVisitDttm MMDDYYYYHH24
  * @param jobId Unique job identifier
  */
  public void executeQuery(String lastVisitDttm, String jobId)
      throws SQLException  {

      PreparedStatement statement = this.getStatement();

      try {
          statement.setString(1, lastVisitDttm);
          statement.setString(2, jobId);

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
