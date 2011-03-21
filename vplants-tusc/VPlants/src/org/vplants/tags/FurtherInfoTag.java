package org.vplants.tags;
import java.util.ArrayList;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import org.vplants.datahandler.DataBean;

public class FurtherInfoTag extends TagSupport 
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
      boolean containsData = false;
      
      //Call the DataBean for the data
      DataBean data = (DataBean)pageContext.getAttribute("myBean");
      ArrayList infoLinksUri = data.getFurtherInfoLinks();
      ArrayList infoLinksTxt = data.getFurtherInfoLinksTxt();
      
      //Grab the tag specific data
      
      if (data.getFurtherInfo() != null && !data.getFurtherInfo().equalsIgnoreCase("") && !data.getFurtherInfo().equalsIgnoreCase("null"))
      {
        output.append("<dd>"+data.getFurtherInfo()+"</dd>");
        containsData = true;
      }
        
      if (infoLinksUri != null){  
        for (int j = 0; j < infoLinksUri.size(); j++)
        {
          if (!infoLinksUri.get(j).toString().equalsIgnoreCase("") && !infoLinksUri.get(j).toString().equalsIgnoreCase("null") && infoLinksUri.get(j) != null)
          {
            output.append("<dd class='links'><a href='"+infoLinksUri.get(j).toString()+"'>"+infoLinksTxt.get(j).toString()+"</a></dd>"); 
            containsData = true;
          }
        }
      }
        
        if (containsData){
          out.print(output.toString());      
        }
      
      
      
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