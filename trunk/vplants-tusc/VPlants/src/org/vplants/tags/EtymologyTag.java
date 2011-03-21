package org.vplants.tags;
import java.util.ArrayList;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import org.vplants.datahandler.DataBean;

public class EtymologyTag extends TagSupport 
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
      
      //Call the DataBean for the data
      DataBean data = (DataBean)pageContext.getAttribute("myBean");
      ArrayList etymLinksUri = data.getEtymologyLinks();
      ArrayList etymLinksTxt = data.getEtymologyLinksTxt();
      
      //Grab the tag specific data
      
      
      if (etymLinksUri != null || (data.getEtymology() != null && !data.getEtymology().equalsIgnoreCase("") && !data.getEtymology().equalsIgnoreCase("null")))
      {
        output.append("<dt id='etym'>Etymology:</dt><dd>"+data.getEtymology()+"</dd>");
        
        for (int j = 0; j < etymLinksUri.size(); j++)
        { 
          output.append("<dd class='links'><a href='"+etymLinksUri.get(j).toString()+"'>"+etymLinksTxt.get(j).toString()+"</a></dd>"); 
        }
      }
      else
      {
        
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