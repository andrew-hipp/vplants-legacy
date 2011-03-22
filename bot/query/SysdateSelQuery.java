
// Copyright (c) 2001 The Morton Arboretum
package org.vplants.bot.query;

import java.sql.*;
import java.util.Vector;
import org.vplants.bot.*;

/**
  * Query bean that grabs the sysdate from the database minus a supplied offset
  * (in days) in MMDDYYYYHH24 format.  The spider uses this query to log it's
  * start time.  The offset allows us to build a little cushion and ensure the
  * spider grabs any last second changes.  So, when selecting the current time,
  * the spider actually selects the current time minus 2.5 hours just to be safe.
  * <P>
  * @author Matthew Schaub
  */
public class SysdateSelQuery extends QueryObject {
  static final String SEL_QUERY = "SELECT " +
                                  "TO_CHAR(SYSDATE - ?, \'MMDDYYYYHH24\') " +
                                  "FROM " +
                                  "DUAL"
                                          ;

/**
  * Query bean constructor.
  * @param conn Database connection object
  */
  public SysdateSelQuery(Connection conn)
      throws SQLException {
      super(conn, SEL_QUERY);
  }

/**
  * Executes the sysdate select, returning the date minus the offset in String
  * format.
  * @param offset String offset value
  * @return String Sysdate - offset
  */
  public String executeQuery(String offset)
    throws SQLException {

    String sysdate = "0101000100";

    PreparedStatement statement = this.getStatement();

    statement.setString(1, offset);

    ResultSet rs = statement.executeQuery();
    if (rs.next()) {
      sysdate = rs.getString(1);
    }

    return sysdate;
  }

/**
  * Convert an indicator value (Y/N) to a boolean value (T/F).
  * @param in Indicator value (Y/N)
  * @return Boolean Y = True, N = False
  */
  private static boolean toBoolean(String in) {
    return "Y".equals(in);
  }
}
