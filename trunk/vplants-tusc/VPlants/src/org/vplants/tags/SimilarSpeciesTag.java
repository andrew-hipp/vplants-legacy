package org.vplants.tags;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import org.vplants.datahandler.DataBean;
import java.util.ArrayList;

public class SimilarSpeciesTag extends TagSupport 
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
     
      ArrayList dbList = data.getSimilarSpeciesLinks();
      ArrayList gidList = data.getSimSpeciesGID();
      ArrayList linkUri = data.getSimilarSpeciesLinksUri();
      ArrayList linkTxt = data.getSimilarSpeciesLinksTxt();
      
//      if ((data.getSimilarSpecies() != null && !data.getSimilarSpecies().equalsIgnoreCase("") && !data.getSimilarSpecies().equalsIgnoreCase("null")) || (dbList.get(0) != null) || ((linkUri.size()>0) && (linkUri.get(0) != null) && (gidList.size()>0) && (gidList.get(0)!= null )) )
      if (((dbList != null) && (linkUri != null) && (gidList != null)) || (data.getSimilarSpecies() != null && !data.getSimilarSpecies().equalsIgnoreCase("") && !data.getSimilarSpecies().equalsIgnoreCase("null")))
      {
        output.append("<dt id='simsp'>Similar species:</dt>");
        
        if (data.getSimilarSpecies() != null && !data.getSimilarSpecies().equalsIgnoreCase("") && !data.getSimilarSpecies().equalsIgnoreCase("null"))
        {
          output.append("<dd>"+data.getSimilarSpecies()+"</dd>");
        }
        
        if (dbList.size() > 0 && dbList.get(0) != null){
          for (int i = 0; i < dbList.size(); i++)
          {
            String gid = gidList.get(i).toString();
            output.append("<dd class='simlink'><a href='species.jsp?gid="+gid+"'>"+dbList.get(i).toString()+"</a></dd>");
          }
        }
        for (int j = 0; j < linkUri.size(); j++)
        {
          output.append("<dd class='simlink'><a href='"+linkUri.get(j).toString()+"'>"+linkTxt.get(j).toString()+"</a></dd>");
        }
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