package org.vplants.tags;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import org.vplants.datahandler.DataBean;
import java.util.Iterator;

public class CommonNamesTag extends TagSupport 
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
      if (data.getCommonNames() != null && data.getCommonNames().size() > 0){
        output.append("<dt id='comname'>Common names:</dt>");
        
        Iterator I = data.getCommonNames().iterator();
        
        output.append("<dd>"+I.next());
        
        while (I.hasNext()){
          output.append(", "+I.next());
        }
        
        output.append("</dd>");
        
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