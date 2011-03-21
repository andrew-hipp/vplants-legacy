package org.vplants.tags;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import org.vplants.datahandler.DataBean;
import java.util.ArrayList;

public class ReferencesTag extends TagSupport 
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
      ArrayList referList = new ArrayList();
      ArrayList referListLink = new ArrayList();
      ArrayList referListTxt = new ArrayList();
      
      //Call the DataBean for the data
      DataBean data = (DataBean)pageContext.getAttribute("myBean");
      //Grab the tag specific data
      referList = data.getReferences();
      referListLink = data.getReferencesLinks();
      referListTxt = data.getReferencesLinksTxt();      
      
      if ((referList != null && referList.size() > 0 && referList.get(0) != null) || (referListLink != null && referListLink.size() > 0 && referListLink.get(0) != null)){
        output.append("<dt class='refer'>References:</dt>");
        for (int x = 0; x < referList.size(); x++)
        {
          output.append("<dd class='refer'>"+referList.get(x).toString()+"</dd>");          
        }
        
        for (int j = 0; j < referListLink.size(); j++)
        {
          output.append("<dd class='refer'><a href='"+referListLink.get(j).toString()+"'>"+referListTxt.get(j).toString()+"</a></dd>"); 
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