
// Copyright (c) 2001 The Morton Arboretum
package org.vplants.bot.query;

import java.sql.*;
import org.vplants.bot.*;
import java.lang.Integer;

/**
  * Insert query bean for the SPECIMEN table.
  * <P>
  * @author Matthew Schaub
  */
public class SpmInsQuery extends QueryObject {
    static final String INS_QUERY = "INSERT INTO SPECIMEN " +
"( " +
"SPM_ID, " +
"HERB_CD, " +
"KINGDOM_CD, " +
"NAME_CD, " +
"COLL_DATE, " +
"COLL_DATE_MASK, " +
"COLL_NBR, " +
"TYPE_IND, " +
"REC_CREATE_DTTM, " +
"REC_UPDATE_DTTM, " +
"CREATE_DTTM, " +
"UPDATE_DTTM " +
") " +
"VALUES " +
"( " +
"?, " +
"?, " +
"?, " +
"?, " +
"TO_DATE(?, 'MM/DD/YYYY'), " +
"?, " +
"?, " +
"?, " +
"TO_DATE(?, 'MM/DD/YYYY'), " +
"TO_DATE(?, 'MM/DD/YYYY HH24:MI'), " +
"SYSDATE, " +
"SYSDATE " +
")"
;

    static final int SPM_ID_I = 1;
    static final int HERB_CD_I = 2;
    static final int KINGDOM_CD_I = 3;
    static final int NAME_CD_I = 4;
    static final int COLL_DATE_I = 5;
    static final int COLL_DATE_MASK_I = 6;
    static final int COLL_NBR_I = 7;
    static final int TYPE_IND_I = 8;
    static final int REC_CREATE_DTTM_I = 9;
    static final int REC_UPDATE_DTTM_I = 10;

/**
  * Creates an insert query object ready to access the database. The
  * insert statement is prepared in the constructor but not executed
  * until the executeQuery method is called.
  * @param conn Database connection object
  */
  public SpmInsQuery(Connection conn)
      throws SQLException {
      super(conn, INS_QUERY);
  }

/**
  * Runs the insert query, inserting the given object data into the
  * database.
  * @param herbCd Herbarium code
  * @param nameCd Checklist name code
  * @param hdr Specimen Header object
  * @param dtl Specimen Detail object
  */
  public void executeQuery(String herbCd, String nameCode, SpmHdrObject hdr, SpmObject dtl)
      throws SQLException  {

      PreparedStatement statement = this.getStatement();

      try {
          statement.setString(SPM_ID_I, hdr.getSpmId());
          statement.setString(HERB_CD_I, herbCd);
          statement.setString(KINGDOM_CD_I, "PL");
          statement.setString(NAME_CD_I, nameCode);
          statement.setString(COLL_DATE_I, dtl.getCollDate());
          statement.setInt(COLL_DATE_MASK_I, dtl.getCollDateMask());
          statement.setString(COLL_NBR_I, dtl.getCollNbr());
          statement.setString(TYPE_IND_I, getInd(dtl.isTypeSpm()));
          statement.setString(REC_CREATE_DTTM_I, dtl.getCrDate());
          statement.setString(REC_UPDATE_DTTM_I, hdr.getXMLUpdttmString());

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
