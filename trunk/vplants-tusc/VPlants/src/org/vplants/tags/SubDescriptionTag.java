package org.vplants.tags;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import org.vplants.datahandler.DataBean;
import java.util.ArrayList;

public class SubDescriptionTag extends TagSupport 
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
      ArrayList subDescList = new ArrayList();
      ArrayList partList = new ArrayList();
      
      //Call the DataBean for the data
      DataBean data = (DataBean)pageContext.getAttribute("myBean");
      //Grab the tag specific data
      subDescList = data.getSubDescription();
      partList = data.getPart();
      
      for (int x = 0; x < partList.size(); x++)
      {
        output.append("<dt class='part'>"+partList.get(x).toString()+"</dt><dd class='part'>"+subDescList.get(x).toString()+"</dd><BR>");
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