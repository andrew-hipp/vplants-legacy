 package org.vplants.utils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.vplants.datahandler.DataBean;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.ArrayList;


public class DBSupportBean
{  
   
  String dbGid;
  Connection con = GetConnection.connect();
  
  public DBSupportBean()
  {
  
  }  
  
   public void getAcceptedName(DataBean data)
  {
    
    setDbGid(data.getGid());
    String gid                    = getDbGid();
    PreparedStatement primaryStmt = null;
    StringBuffer sql              = new StringBuffer();
    ResultSet rs                  = null;
    
    try{
     sql.append("select name_cd ");
     sql.append("from CHECKLIST_VP ");
     sql.append("where group_id = "+ gid);
     sql.append("and accepted_ind = 'N' ");
     primaryStmt = con.prepareStatement(sql.toString());
     rs = primaryStmt.executeQuery();   
     
     if (rs.next()){   
       data.setNameCd(rs.getString("name_cd"));
     }
    
    }catch (Throwable ex) {
      ex.printStackTrace();
                  
    }finally{
      try {
        primaryStmt.close();
             
      }catch(Throwable ex) {
          // do nothing
      }
    }// finally
  }
  
  public String getSimilarSpecLinks(String incomingName)
  {
    
      StringBuffer sql6              = new StringBuffer();
      PreparedStatement primaryStmt1 = null;
      ResultSet rs1                  = null;
      String name                    = null;      
     
      //Query to grab the proper names after getting the name code array from the data bean 
        try{
          sql6.append("select genus , species , var ");
          sql6.append("from CHECKLIST_VP ");
          sql6.append("where name_cd = '"+ incomingName +"'");
          primaryStmt1 = con.prepareStatement(sql6.toString());
          rs1 = primaryStmt1.executeQuery();   
          
          
          while (rs1.next())
          {
            if (rs1.getString(3) == null)
            {
                name = (rs1.getString(1)+" "+rs1.getString(2));    
            }
            else{
                name = (rs1.getString(1)+" "+rs1.getString(2)+" var. "+rs1.getString(3));
            }
          }
      
          
        }catch (Throwable ex) {
                  ex.printStackTrace();
                  
          }finally{
            try {
             primaryStmt1.close();
             
            }catch(Throwable ex) {
               // do nothing
            }
          }/// finally
  
      return name;
  }
  
  public String getSimilarSpecLinksGID(String incomingName)
  {
    
      StringBuffer sql6              = new StringBuffer();
      PreparedStatement primaryStmt1 = null;
      ResultSet rs1                  = null;
      String name                    = null;     
      
     
      //Query to grab the proper names after getting the name code array from the data bean 
        try{
          sql6.append("select group_id ");
          sql6.append("from CHECKLIST_VP ");
          sql6.append("where name_cd = '"+ incomingName +"'");
          primaryStmt1 = con.prepareStatement(sql6.toString());
          rs1 = primaryStmt1.executeQuery();   
          
          
          while (rs1.next())
          {
            name = (rs1.getString(1));
          }
      
          
        }catch (Throwable ex) {
                  ex.printStackTrace();
                  
          }finally{
            try {
             primaryStmt1.close();
             
            }catch(Throwable ex) {
               // do nothing
            }
          }/// finally
  
      return name;
  }
  
  public void populateMe(DataBean data)
  {  
     ArrayList alist1 = new ArrayList();   
     ArrayList alist2 = new ArrayList();
     ArrayList alist3 = new ArrayList();
     ArrayList alist4 = new ArrayList();
     ArrayList alist5 = new ArrayList();
     ArrayList alist6 = new ArrayList();
     ArrayList alist7 = new ArrayList();
     ArrayList alist8 = new ArrayList();
     ArrayList alist9 = new ArrayList();
     ArrayList alist10 = new ArrayList();
     ArrayList alist11 = new ArrayList();
     ArrayList alist12 = new ArrayList();
     ArrayList alist13 = new ArrayList();
     ArrayList alist14 = new ArrayList();
     ArrayList alist15 = new ArrayList();
     ArrayList alist16 = new ArrayList();
     setDbGid(data.getGid());
     String gid                    = getDbGid();
     PreparedStatement primaryStmt = null;
     StringBuffer sql              = new StringBuffer();
     StringBuffer sql2             = new StringBuffer();
     StringBuffer sql3             = new StringBuffer();
     StringBuffer sql4             = new StringBuffer();
     StringBuffer sql5             = new StringBuffer();
     StringBuffer sql8             = new StringBuffer();
     StringBuffer sql9             = new StringBuffer();
     StringBuffer sql10            = new StringBuffer();
     ResultSet rs                  = null;
     String nameCode               = null;
     
      try {    
            
            //Query to retrieve the Genus, Species, Author, and Var based on the GID
            sql.append("select genus, species, author, var, family_name, var_author, ssp, ssp_author, f, f_author, name_cd, name_cd_usda ");
            sql.append("from CHECKLIST_VP ");
            sql.append("where group_id = "+ gid);
            sql.append("and accepted_ind = 'Y' ");
            primaryStmt = con.prepareStatement(sql.toString());
            rs = primaryStmt.executeQuery();
            
            while (rs.next())
            {
              data.setGenus(rs.getString(1));
              data.setSpecies(rs.getString(2));
              data.setAuthor(rs.getString(3));
              data.setVar(rs.getString(4));
              data.setFamily(rs.getString(5));
              data.setVarAuthor(rs.getString(6));
              data.setSubSpecies(rs.getString(7));
              data.setSubSpAuthor(rs.getString(8));
              data.setForma(rs.getString(9));
              data.setFAuthor(rs.getString(10));
              nameCode = rs.getString(11);
              data.setNameCd(nameCode);
              data.setUSDA(rs.getString("name_cd_usda"));
              
            }
            
            //Query to retrieve the Synonyms names
            sql5.append("select genus, species, author, var, var_author, ssp, ssp_author, f, f_author ");
            sql5.append("from CHECKLIST_VP ");
            sql5.append("where group_id = "+ gid);
            sql5.append("and accepted_ind = 'N' ");
            sql5.append("order by genus,species,ssp,var,f ");
            primaryStmt = con.prepareStatement(sql5.toString());
            rs = primaryStmt.executeQuery();
            
            while (rs.next())
            {
              alist4.add(rs.getString(1));
              alist5.add(rs.getString(2));
              alist6.add(rs.getString(3));
              alist10.add(rs.getString(4));
              alist11.add(rs.getString(5));
              alist12.add(rs.getString(6));
              alist13.add(rs.getString(7));
              alist14.add(rs.getString(8));
              alist15.add(rs.getString(9));
            }
            data.setSynGenus(alist4);
            data.setSynSpecies(alist5);
            data.setSynAuthor(alist6);
            data.setSynVar(alist10);
            data.setSynVarAuthor(alist11);
            data.setSynSubSpec(alist12);
            data.setSynSubSpecAuthor(alist13);
            data.setSynForma(alist14);
            data.setSynFormaAuthor(alist15);
            
                               
            
            //Query to retrieve the common names
/*            sql2.append("select cname.name, cname.name_cd ");
            sql2.append("from common_name cname, ");
            sql2.append("checklist_vp checkvp ");
            sql2.append("where cname.name_cd = checkvp.name_cd ");
            sql2.append("and checkvp.group_id = "+gid);
            primaryStmt = con.prepareStatement(sql2.toString());
            rs = primaryStmt.executeQuery();
*/
            sql2.append("select name ");
            sql2.append("from common_name ");
            sql2.append("where name_cd = ?");
            primaryStmt = con.prepareStatement(sql2.toString());
            primaryStmt.setString(1, nameCode);
            rs = primaryStmt.executeQuery();

            while (rs.next())
            {
              alist16.add(rs.getString("name"));
            }
              data.setCommonNames(alist16);
            
            //Query to retrieve state info for the map
            
            sql3.append("select distinct geo.state ");
            sql3.append("from site_geo geo, specimen spec ");
            sql3.append("where spec.spm_id = geo.spm_id ");
            sql3.append("and spec.herb_cd = geo.herb_cd ");
            sql3.append("and geo.county is not NULL " );
            sql3.append("and spec.name_cd in ");
            sql3.append("(select name_cd ");
            sql3.append("from CHECKLIST_VP ");
            sql3.append("where group_id = "+ gid +")");           
            sql3.append("order by geo.state");
            primaryStmt = con.prepareStatement(sql3.toString());
            rs = primaryStmt.executeQuery();
            
            while (rs.next())
            {
              alist1.add(rs.getString(1)); 
            }
            data.setMap(alist1);
            
            //Query to retrieve county info for the IL map
            
            sql4.append("select distinct geo.county ");
            sql4.append("from site_geo geo, specimen spec ");
            sql4.append("where spec.spm_id = geo.spm_id ");
            sql4.append("and spec.herb_cd = geo.herb_cd ");
            sql4.append("and geo.county is not NULL " );
            sql4.append("and geo.state = 'IL' ");
            sql4.append("and spec.name_cd in ");
            sql4.append("(select name_cd ");
            sql4.append("from CHECKLIST_VP ");
            sql4.append("where group_id = "+ gid +")");
            sql4.append("order by geo.county");
            primaryStmt = con.prepareStatement(sql4.toString());
            rs = primaryStmt.executeQuery();
            
            while (rs.next())
            {
              alist3.add(rs.getString(1)); 
            }
            data.setCountyIL(alist3);
            
            //Query to retrieve county info for the MI map
            
            sql8.append("select distinct geo.county ");
            sql8.append("from site_geo geo, specimen spec ");
            sql8.append("where spec.spm_id = geo.spm_id ");
            sql8.append("and spec.herb_cd = geo.herb_cd ");
            sql8.append("and geo.county is not NULL " );
            sql8.append("and geo.state = 'MI' ");
            sql8.append("and spec.name_cd in ");
            sql8.append("(select name_cd ");
            sql8.append("from CHECKLIST_VP ");
            sql8.append("where group_id = "+ gid +")");           
            sql8.append("order by geo.county");
            primaryStmt = con.prepareStatement(sql8.toString());
            rs = primaryStmt.executeQuery();
            
            while (rs.next())
            {
              alist7.add(rs.getString(1)); 
            }
            data.setCountyMI(alist7);
            
            //Query to retrieve county info for the IN map
            
            sql9.append("select distinct geo.county ");
            sql9.append("from site_geo geo, specimen spec ");
            sql9.append("where spec.spm_id = geo.spm_id ");
            sql9.append("and spec.herb_cd = geo.herb_cd ");
            sql9.append("and geo.county is not NULL " );
            sql9.append("and geo.state = 'IN' ");
            sql9.append("and spec.name_cd in ");
            sql9.append("(select name_cd ");
            sql9.append("from CHECKLIST_VP ");
            sql9.append("where group_id = "+ gid +" )");           
            sql9.append("order by geo.county");
            primaryStmt = con.prepareStatement(sql9.toString());
            rs = primaryStmt.executeQuery();
            
            while (rs.next())
            {
              alist8.add(rs.getString(1)); 
            }
            data.setCountyIN(alist8);
            
            //Query to retrieve county info for the WI map
            sql10.append("select distinct geo.county ");
            sql10.append("from site_geo geo, specimen spec ");
            sql10.append("where spec.spm_id = geo.spm_id ");
            sql10.append("and spec.herb_cd = geo.herb_cd ");
            sql10.append("and geo.county is not NULL " );
            sql10.append("and geo.state = 'WI' ");
            sql10.append("and spec.name_cd in ");
            sql10.append("(select name_cd ");
            sql10.append("from CHECKLIST_VP ");
            sql10.append("where group_id = "+ gid +")");
            sql10.append("order by geo.county");
            primaryStmt = con.prepareStatement(sql10.toString());
            rs = primaryStmt.executeQuery();
            
            while (rs.next())
            {
              alist9.add(rs.getString(1)); 
            }
            data.setCountyWI(alist9);
            
           
          }catch (Throwable ex) {
                  ex.printStackTrace();
                  
          }finally{
            try {
             primaryStmt.close();
             
            }catch(Throwable ex) {
               // do nothing
            }
          }/// finally  
    }


  public void setDbGid(String dbGid)
  {
    this.dbGid = dbGid;
  }


  public String getDbGid()
  {
    return dbGid;
  }


  
  
  
  
  
}