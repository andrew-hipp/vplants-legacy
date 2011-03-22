
// Copyright (c) 2001 The Morton Arboretum
package org.vplants.bot.query;

import java.sql.*;

/**
  * A generic bean class for the spider.  All query beans will extend
  * this parent class.
  * <P>
  * @author Matthew Schaub
  */
public class QueryObject extends Object {
/** database connection */
  Connection conn = null;
/** database username */
  String userID = null;
/** prepared sql statement */
  PreparedStatement statement = null;

/**
  * Constructor - initializes object and prepares sql statement.
  * @param conn Database connection
  * @param query Quert string
  */
  public QueryObject(Connection conn, String query)
  throws SQLException
  {
    this.conn = conn;
    this.statement = conn.prepareStatement(query);
  }

/**
  * Default constructor - sets object to null.
  */
  public QueryObject()
  throws SQLException {
    this(null, null);
  }

/**
  * Get the sql statement object.
  * @return PreparedStatement Prepared statment object
  */
  public PreparedStatement getStatement() {
    return this.statement;
  }

/**
  * Get the database connection object.
  * @return Connection Database connection object
  */
  public Connection getConnection() {
    return this.conn;
  }

/**
  * Close the sql statement.
  */
  public void closeStatement()
  throws SQLException {
    statement.close();
  }

/**
  * Issue a database commit.
  */
  public void commit()
  throws SQLException {
    conn.commit();
  }

/**
  * Convert a boolean value (T/F) to an indicator value (Y/N).
  * @param val Boolean value (T/F)
  * @return String Indicator value (Y/N)
  */
  public String getInd(boolean val) {
    if (val)
      return "Y";
    else
      return "N";
  }
}
