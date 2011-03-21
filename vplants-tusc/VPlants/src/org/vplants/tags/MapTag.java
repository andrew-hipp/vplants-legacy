package org.vplants.tags;
import java.util.HashSet;
import java.util.Iterator;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import org.vplants.datahandler.DataBean;
import java.util.ArrayList;

public class MapTag extends TagSupport 
{

  /**
   * Method called at start of tag.
   * @return SKIP_BODY
   */
  public int doStartTag() throws JspException
  {
    try
    {
      StringBuffer output = new StringBuffer();      
      JspWriter out = pageContext.getOut();
      String ilState = "IL";
      String wiState = "WI";
      String inState = "IN";
      String miState = "MI";    
      
      //Call the DataBean for the data
      DataBean data = (DataBean)pageContext.getAttribute("myBean");
      //Grab the tag specific data
      //output.append("<BR>States: "+data.getMap());
      ArrayList dbList = data.getMap();
      ArrayList ILList = data.getCountyIL();
      ArrayList INList = data.getCountyIN();
      ArrayList MIList = data.getCountyMI();
      ArrayList WIList = data.getCountyWI();
      String finalString = null;
      String gid = data.getGid();
      
      Iterator I;
      
      
      for (int x = 0; x < dbList.size(); x++)
      {
        if ( ilState.equalsIgnoreCase(dbList.get(x).toString()) && ILList != null && ILList.size() > 0 )
        {
          output.append("<ul><li><a href='/xsql/vplants/advtaxon.xsql?gid="+gid+"&amp;state=IL'><strong>Illinois</strong></a><ul>");
          I = ILList.iterator();
            
            while (I.hasNext())
            {
              String county = I.next().toString();
              output.append("<li><a href='/xsql/vplants/advtaxon.xsql?gid="+gid+"&amp;state=IL&amp;county="+county+"'>"+county+"</a></li>");
            }
            
          output.append("</ul></li></ul>");
        }
        else if ( wiState.equalsIgnoreCase(dbList.get(x).toString()) && WIList != null && WIList.size() > 0  )
        {
          output.append("<ul><li><a href='/xsql/vplants/advtaxon.xsql?gid="+gid+"&amp;state=WI'><strong>Wisconsin</strong></a><ul>");
          I = WIList.iterator();
            
            while (I.hasNext())
            {
              String county = I.next().toString();
              output.append("<li><a href='/xsql/vplants/advtaxon.xsql?gid="+gid+"&amp;state=WI&amp;county="+county+"'>"+county+"</a></li>");
            }
            
          output.append("</ul></li></ul>");
        }
        else if ( inState.equalsIgnoreCase(dbList.get(x).toString()) && INList != null && INList.size() > 0 )
        {
          output.append("<ul><li><a href='/xsql/vplants/advtaxon.xsql?gid="+gid+"&amp;state=IN'><strong>Indiana</strong></a><ul>");
         
          I = INList.iterator();
            
            while (I.hasNext())
            {
              String county = I.next().toString();
              output.append("<li><a href='/xsql/vplants/advtaxon.xsql?gid="+gid+"&amp;state=IN&amp;county="+county+"'>"+county+"</a></li>");
            }
            
          output.append("</ul></li></ul>");
        }
        else 
        {
          if ( MIList != null && MIList.size() > 0 ){
            output.append("<ul><li><a href='/xsql/vplants/advtaxon.xsql?gid="+gid+"&amp;state=MI'><strong>Michigan</strong></a><ul>");
            I = MIList.iterator();
              
              while (I.hasNext())
              {
                String county = I.next().toString();
                output.append("<li><a href='/xsql/vplants/advtaxon.xsql?gid="+gid+"&amp;state=MI&amp;county="+county+"'>"+county+"</a></li>");
              }
              
            output.append("</ul></li></ul>");
          }
        }
      }
        
     
      out.print(output.toString());      
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }

    return SKIP_BODY;
  }


  /**
   * Method called at end of tag.
   * @return EVAL_PAGE
   */
  public int doEndTag()
  {
    return EVAL_PAGE;
  }
}