package org.vplants.tags;
import java.io.File;
import java.util.ResourceBundle;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import org.vplants.datahandler.DataBean;

public class ImagesTag extends TagSupport 
{

  /**
   * Method called at start of tag.
   * @return SKIP_BODY
   */
   
  private static String filePathPrefix = null; 
  
 public int doStartTag() throws JspException
  {

    try
    {
      //ResourceBundle props = ResourceBundle.getBundle("Images");
      setFilePathPrefix("http://www.vplants.org/speciesqa/img/");

      JspWriter out = pageContext.getOut();

      DataBean data = (DataBean)pageContext.getAttribute("myBean");
      
      StringBuffer nameCD = new StringBuffer(data.getNameCd());
      //nameCD.append(nameCD);
      nameCD.append(".po.jpg");
      
      File imageFile = new File("/var/www/vplants/webapps/speciesqa/img/"+nameCD.toString());      
      StringBuffer fullPath = new StringBuffer();
      fullPath.append(getFilePathPrefix());
      
      if (imageFile.exists()){
        fullPath.append(nameCD);
      }
      else
      {
        fullPath.append("NOIMAGE.po.jpg");
      }

      out.print("<img src='"+fullPath.toString()+"'");
      
      
      
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


  public void setFilePathPrefix(String filePathPrefix)
  {
    this.filePathPrefix = filePathPrefix;
  }


  public String getFilePathPrefix()
  {
    return filePathPrefix;
  }
}