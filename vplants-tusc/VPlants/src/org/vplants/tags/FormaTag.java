package org.vplants.tags;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import org.vplants.datahandler.DataBean;

public class FormaTag extends TagSupport 
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
      String forma = null;
      String author  = null;
      
      //Call the DataBean for the data
      DataBean data = (DataBean)pageContext.getAttribute("myBean");
      //Grab the tag specific data
      forma = data.getForma();
      author = data.getFAuthor();
      
      if (forma != null && !forma.equalsIgnoreCase("null") && !forma.equalsIgnoreCase("")){
        if (author!= null && !author.equalsIgnoreCase("null") && !author.equalsIgnoreCase(""))
        {
          if (format)
          {
            output.append("<span class='ssp'>f.<em class='epithet'> "+forma.toString()+" </em><span class='author'>"+author.toString()+"</span></span>");          
          }
          else
          {
            if (label){
              if (showAuthor){
                output.append("f. "+forma.toString()+" "+author.toString());          
              }
              else
              {
                output.append("f. "+forma.toString());                          
              }
            }
            else
            {
              output.append(forma.toString());          
            }
          }
        }
        else
        {
          if (format)
          {
            output.append("<span class='ssp'>f.<em class='epithet'> "+forma.toString()+"</em></span>");          
          }
          else
          {
            if (label){
              output.append("f. "+forma.toString());            
            }
            else
            {
              output.append(forma.toString());            
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