package org.vplants.tags;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import org.vplants.datahandler.DataBean;
import java.util.ArrayList;

public class SynonymsTag extends TagSupport 
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
      ArrayList synGenusList = new ArrayList();
      ArrayList synSpeciesList = new ArrayList();
      ArrayList synAuthorList = new ArrayList();
      ArrayList synSubSpecList = new ArrayList();
      ArrayList synSubSpecAuth = new ArrayList();
      ArrayList synVarList = new ArrayList();
      ArrayList synVarAuthor = new ArrayList();
      ArrayList synFormaList = new ArrayList();
      ArrayList synFormaAuth = new ArrayList();
      
      //Call the DataBean for the data
      DataBean data = (DataBean)pageContext.getAttribute("myBean");
      //Grab the tag specific data
      synGenusList = data.getSynGenus();
      synSpeciesList = data.getSynSpecies();
      synAuthorList = data.getSynAuthor();
      synSubSpecList = data.getSynSubSpec();
      synSubSpecAuth = data.getSynSubSpecAuthor();
      synVarList = data.getSynVar();
      synVarAuthor = data.getSynVarAuthor();
      synFormaList = data.getSynForma();
      synFormaAuth = data.getSynFormaAuthor();


      if (synGenusList.size() > 0){ 
        if (synGenusList.size() > 1){
          for (int x = 0; x < synGenusList.size(); x++)
          {
            if(x == (synGenusList.size()-1))
            {
              output.append("<span>");
              if (synAuthorList.get(x) != null)
              {
                output.append("<em>"+synGenusList.get(x).toString()+" "+synSpeciesList.get(x).toString()+"</em> "+synAuthorList.get(x).toString());
              }
              else
              {
                output.append("<em>"+synGenusList.get(x).toString()+" "+synSpeciesList.get(x).toString()+"</em>");
              
              }
              if (synSubSpecList != null && synSubSpecList.get(x) != null)
              {
                output.append(" subsp. <em>"+synSubSpecList.get(x).toString()+"</em>");
              }
              if (synSubSpecAuth != null && synSubSpecAuth.get(x) != null)
              {
                output.append(" "+synSubSpecAuth.get(x).toString() );
              }
              if (synVarList != null && synVarList.get(x) != null)
              {
                output.append(" var. <em>"+synVarList.get(x).toString()+"</em>");
              }
              if (synVarAuthor != null && synVarAuthor.get(x) != null)
              {
                output.append(" "+synVarAuthor.get(x).toString());
              }
              if (synFormaList != null && synFormaList.get(x) != null)
              {
                output.append(" f. <em>"+synFormaList.get(x).toString()+"</em>");
              }
              if (synFormaAuth != null && synFormaAuth.get(x) != null)
              {
                output.append(" "+synFormaAuth.get(x).toString() );
              }
              output.append("</span>");
              output.append("</dd>");
            }
            else if(x == 0)
            {
               if (synAuthorList.get(x) != null)
               {
                output.append("<dt id='synonym'>Synonyms:</dt><dd><span><em>"+synGenusList.get(x).toString()+" "+synSpeciesList.get(x).toString()+"</em> "+synAuthorList.get(x).toString());
               }
               else
               {
                 output.append("<dt id='synonym'>Synonyms:</dt><dd><span><em>"+synGenusList.get(x).toString()+" "+synSpeciesList.get(x).toString()+"</em>");
               
               }
              if (synSubSpecList != null && synSubSpecList.get(x) != null)
              {
                output.append(" subsp. <em>"+synSubSpecList.get(x).toString()+"</em>");
              }
              if (synSubSpecAuth != null && synSubSpecAuth.get(x) != null)
              {
                output.append(" "+synSubSpecAuth.get(x).toString() );
              }
              if (synVarList != null && synVarList.get(x) != null)
              {
                output.append(" var. <em>"+synVarList.get(x).toString()+"</em>");
              }
              if (synVarAuthor != null && synVarAuthor.get(x) != null)
              {
                output.append(" "+synVarAuthor.get(x).toString());
              }
              if (synFormaList != null && synFormaList.get(x) != null)
              {
                output.append(" f. <em>"+synFormaList.get(x).toString()+"</em>");
              }
              if (synFormaAuth != null && synFormaAuth.get(x) != null)
              {
                output.append(" "+synFormaAuth.get(x).toString() );
              }
              output.append("</span>");            
              output.append("; ");
            }
            else
            {
              output.append("<span>");
              if (synAuthorList.get(x) != null)
               {
                output.append("<em>"+synGenusList.get(x).toString()+" "+synSpeciesList.get(x).toString()+"</em> "+synAuthorList.get(x).toString());
               }
              else
               {
                output.append("<em>"+synGenusList.get(x).toString()+" "+synSpeciesList.get(x).toString()+"</em>");
               }
              if (synSubSpecList != null && synSubSpecList.get(x) != null)
              {
                output.append(" subsp. <em>"+synSubSpecList.get(x).toString()+"</em>");
              }
              if (synSubSpecAuth != null && synSubSpecAuth.get(x) != null)
              {
                output.append(" "+synSubSpecAuth.get(x).toString() );
              }
              if (synVarList != null && synVarList.get(x) != null)
              {
                output.append(" var. <em>"+synVarList.get(x).toString()+"</em>");
              }
              if (synVarAuthor != null && synVarAuthor.get(x) != null)
              {
                output.append(" "+synVarAuthor.get(x).toString());
              }
              if (synFormaList != null && synFormaList.get(x) != null)
              {
                output.append(" f. <em>"+synFormaList.get(x).toString()+"</em>");
              }
              if (synFormaAuth != null && synFormaAuth.get(x) != null)
              {
                output.append(" "+synFormaAuth.get(x).toString() );
              }
              output.append("</span>");            
              output.append("; ");
  
            }
          }
        }
        else
        {
             if (synAuthorList.get(0) != null)
             {
              output.append("<dt id='synonym'>Synonyms:</dt><dd><span><em>"+synGenusList.get(0).toString()+" "+synSpeciesList.get(0).toString()+"</em> "+synAuthorList.get(0).toString());
             }
             else
             {
               output.append("<dt id='synonym'>Synonyms:</dt><dd><span><em>"+synGenusList.get(0).toString()+" "+synSpeciesList.get(0).toString()+"</em>");
             
             }
            if (synSubSpecList != null && synSubSpecList.get(0) != null)
            {
              output.append(" subsp. <em>"+synSubSpecList.get(0).toString()+"</em>");
            }
            if (synSubSpecAuth != null && synSubSpecAuth.get(0) != null)
            {
              output.append(" "+synSubSpecAuth.get(0).toString() );
            }
            if (synVarList != null && synVarList.get(0) != null)
            {
              output.append(" var. <em>"+synVarList.get(0).toString()+"</em>");
            }
            if (synVarAuthor != null && synVarAuthor.get(0) != null)
            {
              output.append(" "+synVarAuthor.get(0).toString());
            }
            if (synFormaList != null && synFormaList.get(0) != null)
            {
              output.append(" f. <em>"+synFormaList.get(0).toString()+"</em>");
            }
            if (synFormaAuth != null && synFormaAuth.get(0) != null)
            {
              output.append(" "+synFormaAuth.get(0).toString() );
            }
            output.append("</span>");
            output.append("</dd>");          
        }
          
      }

      
/* NO SPACES
      if (synGenusList.size() > 0){ 
        for (int x = 0; x < synGenusList.size(); x++)
        {
          if(x == (synGenusList.size()-1))
          {
            output.append("<span>");
            if (synAuthorList.get(x) != null)
            {
              output.append("<em>"+synGenusList.get(x).toString()+synSpeciesList.get(x).toString()+"</em>"+synAuthorList.get(x).toString());
            }
            else
            {
              output.append("<em>"+synGenusList.get(x).toString()+synSpeciesList.get(x).toString()+"</em>");
            
            }
            if (synSubSpecList != null && synSubSpecList.get(x) != null)
            {
              output.append("subsp.<em>"+synSubSpecList.get(x).toString()+"</em>");
            }
            if (synSubSpecAuth != null && synSubSpecAuth.get(x) != null)
            {
              output.append(synSubSpecAuth.get(x).toString() );
            }
            if (synVarList != null && synVarList.get(x) != null)
            {
              output.append("var.<em>"+synVarList.get(x).toString()+"</em>");
            }
            if (synVarAuthor != null && synVarAuthor.get(x) != null)
            {
              output.append(synVarAuthor.get(x).toString());
            }
            if (synFormaList != null && synFormaList.get(x) != null)
            {
              output.append("f.<em>"+synFormaList.get(x).toString()+"</em>");
            }
            if (synFormaAuth != null && synFormaAuth.get(x) != null)
            {
              output.append(synFormaAuth.get(x).toString() );
            }
            output.append("</span>");
            output.append("</dd>");
          }
          else if(x == 0)
          {
             if (synAuthorList.get(x) != null)
             {
              output.append("<dt id='synonym'>Synonyms:</dt><dd><span><em>"+synGenusList.get(x).toString()+synSpeciesList.get(x).toString()+"</em>"+synAuthorList.get(x).toString());
             }
             else
             {
               output.append("<dt id='synonym'>Synonyms:</dt><dd><span><em>"+synGenusList.get(x).toString()+synSpeciesList.get(x).toString()+"</em>");
             
             }
            if (synSubSpecList != null && synSubSpecList.get(x) != null)
            {
              output.append("subsp.<em>"+synSubSpecList.get(x).toString()+"</em>");
            }
            if (synSubSpecAuth != null && synSubSpecAuth.get(x) != null)
            {
              output.append(synSubSpecAuth.get(x).toString() );
            }
            if (synVarList != null && synVarList.get(x) != null)
            {
              output.append("var.<em>"+synVarList.get(x).toString()+"</em>");
            }
            if (synVarAuthor != null && synVarAuthor.get(x) != null)
            {
              output.append(synVarAuthor.get(x).toString());
            }
            if (synFormaList != null && synFormaList.get(x) != null)
            {
              output.append("f.<em>"+synFormaList.get(x).toString()+"</em>");
            }
            if (synFormaAuth != null && synFormaAuth.get(x) != null)
            {
              output.append(synFormaAuth.get(x).toString() );
            }
            output.append("</span>");            
            output.append(";");
          }
          else
          {
            output.append("<span>");
            if (synAuthorList.get(x) != null)
             {
              output.append("<em>"+synGenusList.get(x).toString()+synSpeciesList.get(x).toString()+"</em>"+synAuthorList.get(x).toString());
             }
            else
             {
              output.append("<em>"+synGenusList.get(x).toString()+synSpeciesList.get(x).toString()+"</em>");
             }
            if (synSubSpecList != null && synSubSpecList.get(x) != null)
            {
              output.append("subsp.<em>"+synSubSpecList.get(x).toString()+"</em>");
            }
            if (synSubSpecAuth != null && synSubSpecAuth.get(x) != null)
            {
              output.append(synSubSpecAuth.get(x).toString() );
            }
            if (synVarList != null && synVarList.get(x) != null)
            {
              output.append("var.<em>"+synVarList.get(x).toString()+"</em>");
            }
            if (synVarAuthor != null && synVarAuthor.get(x) != null)
            {
              output.append(synVarAuthor.get(x).toString());
            }
            if (synFormaList != null && synFormaList.get(x) != null)
            {
              output.append("f.<em>"+synFormaList.get(x).toString()+"</em>");
            }
            if (synFormaAuth != null && synFormaAuth.get(x) != null)
            {
              output.append(synFormaAuth.get(x).toString() );
            }
            output.append("</span>");            
            output.append(";");

          }
        }
      }
*/  
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