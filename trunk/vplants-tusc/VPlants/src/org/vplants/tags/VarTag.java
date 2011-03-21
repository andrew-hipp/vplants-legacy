package org.vplants.tags;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import org.vplants.datahandler.DataBean;

public class VarTag extends TagSupport 
{

  private boolean format = true;
  private boolean label = true;
  private boolean showAuthor = true;

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
      String variant = null;
      String author = null;
      
      //Call the DataBean for the data
      DataBean data = (DataBean)pageContext.getAttribute("myBean");
      //Grab the tag specific data
      variant = data.getVar();
      author  = data.getVarAuthor();
      
      if (variant != null && !variant.equalsIgnoreCase("null") && !variant.equalsIgnoreCase("")){
        if (author != null && !variant.equalsIgnoreCase("null") && !variant.equalsIgnoreCase(""))
        {
          if (format){
            output.append("<span class='infra'>var. <em class='epithet'>"+variant.toString()+"</em> <span class='author'>"+author.toString()+"</span></span>");
          }
          else
          {
            if (label){
              if (showAuthor)
              {
                output.append("var. "+variant.toString()+" "+author.toString());                            
              }
              else
              {
                output.append("var. "+variant.toString());                                            
              }
            }
            else
            {
              output.append(variant.toString());            
            }
          }
        }
        else
        {
          if (format)
          {
            output.append("<span class='infra'>var. <em class='epithet'>"+variant.toString()+"</em></span>");          
          }
          else
          {
            if (label){
              output.append("var. "+variant.toString());            
            }
            else
            {
              output.append(variant.toString());            
            }
          }
        }
        
        out.print(output.toString());      
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }

    return SKIP_BODY;
  }

  public void setFormat(boolean var)
  {
    format = var;
  }
  public void setLabel(boolean var)
  {
    label = var;
  }

  /**
   * Method called at end of tag.
   * @return EVAL_PAGE
   */
  public int doEndTag()
  {
    return EVAL_PAGE;
  }


  public void setShowAuthor(boolean showAuthor)
  {
    this.showAuthor = showAuthor;
  }


  public boolean isShowAuthor()
  {
    return showAuthor;
  }
}