package org.vplants.utils;
import java.sql.*;
import java.util.*;

public class GetConnection 
{
  private static String url = " jdbc:oracle:thin:@192.168.0.4:1521:vplants";
                             
  private static String loginId = "vplants";
  private static String password = "lop13sy";
  
  public GetConnection()
  {
  }
  
  public static Connection connect()
  {
  
    Connection con= null;
    try{
      Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
      con = DriverManager.getConnection(url, loginId, password); 
    
    } catch (SQLException se) {
        System.out.println("(Processor) SQL Exception:" + "\n URL: " + url + "\n Error message: " + se.getMessage());
        se.printStackTrace();
    } catch (Exception e) {
        System.out.println("(Processor) Unable to log into database. Please check the log data:" 
                          + "\n\tuser= " + loginId + "\n\tpassword= " + password + "\n Error message: " + e.getMessage());
        e.printStackTrace();
    }    
    
    return con;
  }
  
  public static Connection connect(String pUrl, String pLoginId, String pPassword)
  {
  
    Connection con= null;
    try{
      Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
      con = DriverManager.getConnection(pUrl, pLoginId, pPassword); 
    
    } catch (SQLException se) {
        System.out.println("(Processor) SQL Exception:" + "\n URL: " + url + "\n Error message: " + se.getMessage());
        se.printStackTrace();
    } catch (Exception e) {
        System.out.println("(Processor) Unable to log into database. Please check the log data:" 
                          + "\n\tuser= " + loginId + "\n\tpassword= " + password + "\n Error message: " + e.getMessage());
        e.printStackTrace();
    }    
    
    return con;
  }
  
  
}