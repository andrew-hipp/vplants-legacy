package org.vplants.tags;
import java.util.ArrayList;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import org.vplants.datahandler.DataBean;

public class DescTag extends TagSupport 
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
      subDescList = data.getSubDescription();
      partList = data.getPart();
      
      //Grab the tag specific data
//      if (partList.size() > 0 || (data.getDesc() != null && !data.getDesc().equalsIgnoreCase("") && !data.getDesc().equalsIgnoreCase("null")))
      if (partList != null || (data.getDesc() != null && !data.getDesc().equalsIgnoreCase("") && !data.getDesc().equalsIgnoreCase("null")))
      {
        output.append("<dt id=\"desc\">Description:</dt><dd><dl id=\"descdef\"><dt class=\"growth\">Growth form:</dt><dd class=\"growth\">"+data.getGrowthForm()+", </dd><dt class=\"size\">Size:</dt><dd class=\"size\">"+data.getSize()+".</dd>");
        for (int x = 0; x < partList.size(); x++)
        {
          output.append("<dt class=\"part\">"+partList.get(x).toString()+"</dt><dd class=\"part\">"+subDescList.get(x).toString()+"</dd>");
        }
        output.append("</dl></dd>");
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