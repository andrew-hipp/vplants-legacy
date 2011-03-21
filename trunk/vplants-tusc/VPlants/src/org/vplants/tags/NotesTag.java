package org.vplants.tags;
import java.util.ArrayList;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import org.vplants.datahandler.DataBean;

public class NotesTag extends TagSupport 
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
      ArrayList notesLinksUri = data.getNotesLinks();
      ArrayList notesLinksTxt = data.getNotesLinksTxt();
      
      //Grab the tag specific data
      
      if (notesLinksUri != null || (data.getNotes() != null && !data.getNotes().equalsIgnoreCase("") && !data.getNotes().equalsIgnoreCase("null")))
      {
        output.append("<dt id='notes'>Notes:</dt><dd>"+data.getNotes()+"</dd>");
        
        for (int j = 0; j < notesLinksUri.size(); j++)
        { 
          output.append("<dd class='links'><a href='"+notesLinksUri.get(j).toString()+"'>"+notesLinksTxt.get(j).toString()+"</a></dd>"); 
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