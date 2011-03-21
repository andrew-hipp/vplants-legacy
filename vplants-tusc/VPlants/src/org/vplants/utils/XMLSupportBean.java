package org.vplants.utils;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import org.vplants.utils.jaxb.DescType;
import org.vplants.utils.jaxb.PartsType;
import org.vplants.utils.jaxb.SpeciesPage;
import org.vplants.datahandler.DataBean;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.vplants.utils.jaxb.*;
import java.util.ArrayList;



public class XMLSupportBean 
{

  private SpeciesPage pageData = null;
  private DataBean dataBean = null;
  private static String filePathPrefix = null;
  private String controlFilePackageName = null;
  private ArrayList partName = null;
  private ArrayList partDesc = null;
  private ArrayList refer = null;
  private ArrayList nameCode = null;
  private ArrayList similarSpecies = null;
  private ArrayList gidList = null;
  private ArrayList referLinkTxt = null;
  private ArrayList referLinkUri = null;
  private ArrayList simSpecLinkTxt = null;
  private ArrayList simSpecLinkUri = null;
  private ArrayList notesLinkUri = null;
  private ArrayList notesLinkTxt = null;
  private ArrayList etymologyLinkTxt = null;
  private ArrayList etymologyLinkUri = null;
  private ArrayList infoLinkTxt = null;
  private ArrayList infoLinkUri = null;
  
 
    
  public XMLSupportBean()
  {
    //ResourceBundle props = ResourceBundle.getBundle("XMLSupportBean");
    setFilePathPrefix("/var/www/vplants/webapps/species/xml/");
    //setFilePathPrefix("C:\\oracle\\jdev1012\\jdev\\mywork\\MortonVPlants\\VPlants\\src\\");
    setControlFilePackageName("org.vplants.utils.jaxb");
  }
  
  public XMLSupportBean(DataBean parent)
  {
    this();
    setDataBean(parent);
    
  }
  
  public void populateSelf()
  {
    try{
      JAXBContext jc = JAXBContext.newInstance(getControlFilePackageName());
      Unmarshaller um = jc.createUnmarshaller();
      SpeciesPage page = (SpeciesPage)um.unmarshal(locateInputFile());
      setPageData(page);
      
    }
    catch(JAXBException jbe)
    {
      System.out.println(jbe.toString());
    }
        
  }///populateSelf
  
  //populate Xml Bean is the main portion that returns the xml data to the DataBean for use by the custom tags
   public void populateXmlBean()
  { 
    partDesc = new ArrayList();
    partName = new ArrayList();
    nameCode = new ArrayList();
    gidList  = new ArrayList();
    similarSpecies = new ArrayList();
    refer = new ArrayList();
    referLinkTxt = new ArrayList();
    referLinkUri = new ArrayList(); 
    simSpecLinkTxt = new ArrayList(); 
    simSpecLinkUri = new ArrayList(); 
    notesLinkUri = new ArrayList(); 
    notesLinkTxt = new ArrayList(); 
    etymologyLinkTxt = new ArrayList(); 
    etymologyLinkUri = new ArrayList(); 
    infoLinkTxt = new ArrayList(); 
    infoLinkUri = new ArrayList(); 
    
    SpeciesPage page = getPageData();
    if (page != null)
    {
    
        if (page.getNAMECD() != null)
        dataBean.setNameCd(page.getNAMECD());
        
        DescType desc = page.getDesc();
               
        
        if ((desc.getGrowthForm() != null && !desc.getGrowthForm().equalsIgnoreCase("null") && !desc.getGrowthForm().equalsIgnoreCase("")) && (desc.getSize() != null && !desc.getSize().equalsIgnoreCase("null") && !desc.getSize().equalsIgnoreCase("")))
        {
          dataBean.setDesc(desc.getGrowthForm()+", "+desc.getSize());
          dataBean.setGrowthForm(desc.getGrowthForm());
          dataBean.setSize(desc.getSize());
        }
        else if (desc.getGrowthForm() != null && !desc.getGrowthForm().equalsIgnoreCase("null") && !desc.getGrowthForm().equalsIgnoreCase(""))
        {
          dataBean.setDesc(desc.getGrowthForm());
        }
        else if (desc.getSize() != null && !desc.getSize().equalsIgnoreCase("null") && !desc.getSize().equalsIgnoreCase(""))
        {
           dataBean.setDesc(desc.getSize());
        }
        
        
        
        //Setting Parts-------------------------------------------------------------------
        PartsType parts = desc.getParts();
        List partsList = parts.getPart();
        
        Iterator I = partsList.iterator();
        while (I.hasNext())
        {
          Part tempPt = (Part)(I.next());
          if (!tempPt.getPartText().equalsIgnoreCase("")){
            partDesc.add(tempPt.getPartText());
          }
          if (!tempPt.getPartName().equalsIgnoreCase("")){
            partName.add(tempPt.getPartName());
          }
        }
        dataBean.setSubDescription(partDesc);
        dataBean.setPart(partName);
        //End Setting Parts---------------------------------------------------------------
        
        //Setting Similar Species + Links-------------------------------------------------
        SimilarSpeciesType similarSpecies = page.getSimilarSpecies();
        dataBean.setSimilarSpecies(similarSpecies.getComments());
        NameCdsType nameCds = similarSpecies.getNameCds();
        List nameCdList = nameCds.getSimNmCd();
        
        Iterator K = nameCdList.iterator();
        while (K.hasNext())
        { 
          String nextOne = K.next().toString();
          if (!nextOne.equalsIgnoreCase("")){
            String nameGetter = getDataBean().getDbBean().getSimilarSpecLinks(nextOne);
            nameCode.add(nameGetter);  
          }      
        }
        
        Iterator X = nameCdList.iterator();
        while (X.hasNext())
        { 
           String nextOne = X.next().toString();
           if (!nextOne.equalsIgnoreCase("")){
              String gidGetter = getDataBean().getDbBean().getSimilarSpecLinksGID(nextOne);
              gidList.add(gidGetter);
           }
        }
        
        LinksType links = similarSpecies.getLinks();
        List linkList = links.getLink();
        
        Iterator Z = linkList.iterator();
        while (Z.hasNext())
        {
          Link tempLink = (Link)(Z.next());
          if (!tempLink.getLinkUri().toString().equalsIgnoreCase("") )
          { 
            simSpecLinkTxt.add(tempLink.getLinkText());
            simSpecLinkUri.add(tempLink.getLinkUri());
          }
          
        }
        
        dataBean.setSimilarSpeciesLinksUri(simSpecLinkUri);
        dataBean.setSimilarSpeciesLinksTxt(simSpecLinkTxt);
        dataBean.setSimilarSpeciesLinks(nameCode);   
        dataBean.setSimSpeciesGID(gidList);
        //End setting Similare Species + Links--------------------------------------------
        
        String nativity = page.getNativity();
        dataBean.setNativity(nativity);    
        
        String flowering = page.getFlowering();
        dataBean.setFlowering(flowering);
        
        String habitatEcology = page.getHabitatEcology();
        dataBean.setHabitatEcology(habitatEcology);
        
        //Start Notes comments and links---------------------------------------------------
        NotesType notes = page.getNotes();
        dataBean.setNotes(notes.getComments());    
        
        LinksType noteslinks = notes.getLinks();
        List notesList =  noteslinks.getLink();
        
        Iterator N = notesList.iterator();
        while (N.hasNext())
        {
          Link tempLink = (Link)(N.next());
          if (!tempLink.getLinkUri().toString().equalsIgnoreCase("") )
          { 
            notesLinkTxt.add(tempLink.getLinkText());
            notesLinkUri.add(tempLink.getLinkUri());
            
          }
          
        }
        
        dataBean.setNotesLinks(notesLinkUri);
        dataBean.setNotesLinksTxt(notesLinkTxt);
        
        
        //End Notes comments and links-----------------------------------------------------
        
        //Start Etymology comments and links-----------------------------------------------
        EtymologyType etymology = page.getEtymology();
        dataBean.setEtymology(etymology.getComments());
        
        LinksType etymlinks = etymology.getLinks();
        List etymList =  etymlinks.getLink();
        
        Iterator E = etymList.iterator();
        while (E.hasNext())
        {
          Link tempLink = (Link)(E.next());
          if (!tempLink.getLinkUri().toString().equalsIgnoreCase("") )
          { 
            etymologyLinkTxt.add(tempLink.getLinkText());
            etymologyLinkUri.add(tempLink.getLinkUri());
            
          }
          
        }
        
        dataBean.setEtymologyLinks(etymologyLinkUri);
        dataBean.setEtymologyLinksTxt(etymologyLinkTxt);
        //End Etymology comments and links-------------------------------------------------
        
        //Start Further Info comments and links--------------------------------------------
        FurtherInfoType furtherInfo = page.getFurtherInfo();
        if (!furtherInfo.getComments().toString().equalsIgnoreCase("")){
          dataBean.setFurtherInfo(furtherInfo.getComments());
        }
        
        LinksType infolinks = furtherInfo.getLinks();
        List infoList =  infolinks.getLink();
        
        Iterator FI = infoList.iterator();
        while (FI.hasNext())
        {
          Link tempLink = (Link)(FI.next());
          infoLinkTxt.add(tempLink.getLinkText());
          infoLinkUri.add(tempLink.getLinkUri());
        }
        
        dataBean.setFurtherInfoLinks(infoLinkUri);
        dataBean.setFurtherInfoLinksTxt(infoLinkTxt);
        
        
        //End Further Info comments and links----------------------------------------------
        
        //Setting References citations and links-------------------------------------------
        ReferencesType references = page.getReferences();
        List referenceList = references.getReference();
        
        Iterator J = referenceList.iterator();
        while (J.hasNext())
        {
          Reference tempRef = (Reference)(J.next());
          //If the citation is indeed a citation tag, and not a link tag, proceed.
          if (tempRef.getCitation()!= null )
          {
            //If the citation is not a blank citation, proceed.  Otherwise it is a link tag.
            if (!tempRef.getCitation().toString().equalsIgnoreCase("") ){
              refer.add(tempRef.getCitation());  
            }
          }
          //If the link is indeed a link tag, and not a citation tag and it is not blank, proceed.
          else if (!tempRef.getLink().getLinkUri().toString().equalsIgnoreCase("") )
          { 
            referLinkTxt.add(tempRef.getLink().getLinkText());
            referLinkUri.add(tempRef.getLink().getLinkUri());
          }
        }
        dataBean.setReferences(refer);
        dataBean.setReferencesLinks(referLinkUri);
        dataBean.setReferencesLinksTxt(referLinkTxt);
        //End setting References citations and links---------------------------------------
        
        
    }
  }
  
  private File locateInputFile()
  {
//    String speciesName = "CIHI";//getDataBean().getNameCd();
    String speciesName = getDataBean().getNameCd();
    StringBuffer filePath = new StringBuffer();
    filePath.append(getFilePathPrefix());
    filePath.append(speciesName);
    filePath.append(".xml");
    
    File xmlFile= new File(filePath.toString());
    
      return xmlFile; 
    
    
  }///createFilePath
  
  //the xml support bean will take the GID as a parameter from the databean.
  //It will then lookup on a properties file the name of the xml doc to fetch.
  //It will then make use of an xml parser to parse the xml
  //finally it will use getters/setters to populate the databean for jsp usage.

  public SpeciesPage getPageData()
  {
    return pageData;    
  }
  
  public DataBean getDataBean()
  {
    return dataBean;
  }
  public String getFilePathPrefix()
  {
    return filePathPrefix;
  }
  private String getControlFilePackageName()
  {
    return controlFilePackageName;
  }


  /// SETTERS
  private void setPageData(SpeciesPage var)
  {
    pageData = var;
  }  
  private void setDataBean(DataBean var)
  {
    dataBean = var;
  }
  private void setFilePathPrefix(String var)
  {
    filePathPrefix = var;
  }
  private void setControlFilePackageName(String var)
  {
    controlFilePackageName = var;
  }







}