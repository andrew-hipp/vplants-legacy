package org.vplants.tags;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import org.vplants.datahandler.DataBean;

public class NativityTag extends TagSupport 
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
      //Grab the tag specific data
      if (data.getNativity() != null && !data.getNativity().equalsIgnoreCase("")){
        output.append("<dt id='native'>Regional occurrence:</dt><dd><a href=\"/plants/invasive.html\" title='Read about native, non-native and invasive plants.'>"+data.getNativity().toString()+"</a> </dd>");
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