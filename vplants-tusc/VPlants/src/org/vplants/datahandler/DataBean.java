package org.vplants.datahandler;

import java.util.ArrayList;
import org.vplants.utils.DBSupportBean;
import org.vplants.utils.XMLSupportBean;

public class DataBean
{

  //xml data variables
  String gid               ="";
  String speciesPage       ="";
  String group             ="";
  String desc              ="";
  String similarSpecies    ="";
  String flowering         ="";
  String fruiting          ="";
  String habitatEcology    ="";
  String nativity          ="";
  String notes             ="";
  String etymology         ="";
  String furtherInfo       ="";
  String imageGallery      ="";
  String otherRecords      ="";
  //String commonNames       ="";
  String regionalOccurence ="";
  String genus             ="";
  String author            ="";
  String species           ="";
  String var               ="";  
  String nameCd            ="";
  String family            ="";
  String subSpecies        ="";
  String varAuthor         ="";
  String subSpAuthor       ="";
  String fAuthor           ="";
  String forma             ="";
  private String growthForm        ="";
  private String size              ="";
  private String USDA              =null;
  
  
  //URL data variables
  ArrayList map;
  ArrayList similarSpeciesLinks;
  ArrayList similarSpeciesLinksUri;
  ArrayList similarSpeciesLinksTxt;
  ArrayList notesLinks;
  ArrayList notesLinksTxt;
  ArrayList etymologyLinks;
  ArrayList etymologyLinksTxt;
  ArrayList furtherInfoLinks;
  ArrayList furtherInfoLinksTxt;
  ArrayList referencesLinks;
  ArrayList referencesLinksTxt;
  ArrayList countyIL;
  ArrayList countyMI;
  ArrayList countyIN;
  ArrayList countyWI;
  ArrayList subDescription;
  ArrayList part;
  ArrayList references;
  ArrayList synonyms;
  ArrayList synGenus;
  ArrayList synSpecies;
  ArrayList synAuthor;
  ArrayList simSpeciesGID;
  ArrayList synVar;
  ArrayList synVarAuthor;
  ArrayList synSubSpec;
  ArrayList synSubSpecAuthor;
  ArrayList synForma;
  ArrayList synFormaAuthor;
  private ArrayList commonNames = null;
  
  
  private DBSupportBean dbBean = null;
  private XMLSupportBean xmlBean = null;
  
  
   public DataBean()
  {  
    
  }
  
  private void populateBean()
  {
    dbBean = new DBSupportBean();
    dbBean.getAcceptedName(this);
    dbBean.populateMe(this);
    xmlBean = new XMLSupportBean(this);
    xmlBean.populateSelf();
    xmlBean.populateXmlBean();
    
  }
  
  
  
  

  public void setSpeciesPage(String speciesPage)
  {
    this.speciesPage = speciesPage;
  }


  public String getSpeciesPage()
  {
    return speciesPage;
  }


  public void setGroup(String group)
  {
    this.group = group;
  }


  public String getGroup()
  {
    return group;
  }


  public void setDesc(String desc)
  {
    this.desc = desc;
  }


  public String getDesc()
  {
    return desc;
  }


  public void setSimilarSpecies(String similarSpecies)
  {
    this.similarSpecies = similarSpecies;
  }


  public String getSimilarSpecies()
  {
    return similarSpecies;
  }


  public void setFlowering(String flowering)
  {
    this.flowering = flowering;
  }


  public String getFlowering()
  {
    return flowering;
  }


  public void setFruiting(String fruiting)
  {
    this.fruiting = fruiting;
  }


  public String getFruiting()
  {
    return fruiting;
  }


  public void setHabitatEcology(String habitatEcology)
  {
    this.habitatEcology = habitatEcology;
  }


  public String getHabitatEcology()
  {
    return habitatEcology;
  }


  public void setNativity(String nativity)
  {
    this.nativity = nativity;
  }


  public String getNativity()
  {
    return nativity;
  }


  public void setNotes(String notes)
  {
    this.notes = notes;
  }


  public String getNotes()
  {
    return notes;
  }


  public void setEtymology(String etymology)
  {
    this.etymology = etymology;
  }


  public String getEtymology()
  {
    return etymology;
  }


  public void setFurtherInfo(String furtherInfo)
  {
    this.furtherInfo = furtherInfo;
  }


  public String getFurtherInfo()
  {
    return furtherInfo;
  }

  public void setImageGallery(String imageGallery)
  {
    this.imageGallery = imageGallery;
  }


  public String getImageGallery()
  {
    return imageGallery;
  }


  public void setOtherRecords(String otherRecords)
  {
    this.otherRecords = otherRecords;
  }


  public String getOtherRecords()
  {
    return otherRecords;
  }


  public void setSimilarSpeciesLinks(ArrayList similarSpeciesLinks)
  {
    this.similarSpeciesLinks = similarSpeciesLinks;
  }


  public ArrayList getSimilarSpeciesLinks()
  {
    return similarSpeciesLinks;
  }


  public void setNotesLinks(ArrayList notesLinks)
  {
    this.notesLinks = notesLinks;
  }


  public ArrayList getNotesLinks()
  {
    return notesLinks;
  }


  public void setEtymologyLinks(ArrayList etymologyLinks)
  {
    this.etymologyLinks = etymologyLinks;
  }


  public ArrayList getEtymologyLinks()
  {
    return etymologyLinks;
  }


  public void setFurtherInfoLinks(ArrayList furtherInfoLinks)
  {
    this.furtherInfoLinks = furtherInfoLinks;
  }


  public ArrayList getFurtherInfoLinks()
  {
    return furtherInfoLinks;
  }


  public void setReferencesLinks(ArrayList referencesLinks)
  {
    this.referencesLinks = referencesLinks;
  }


  public ArrayList getReferencesLinks()
  {
    return referencesLinks;
  }


  public void setGid(String gid)
  {
    this.gid = gid;
    populateBean();
  }


  public String getGid()
  {
    return gid;
  }


  public void setCommonNames(ArrayList commonNames)
  {
    this.commonNames = commonNames;
  }


  public ArrayList getCommonNames()
  {
    return commonNames;
  }


  public void setRegionalOccurence(String regionalOccurence)
  {
    this.regionalOccurence = regionalOccurence;
  }


  public String getRegionalOccurence()
  {
    return regionalOccurence;
  }


  public void setGenus(String genus)
  {
    this.genus = genus;
  }


  public String getGenus()
  {
    return genus;
  }


  public void setAuthor(String author)
  {
    this.author = author;
  }


  public String getAuthor()
  {
    return author;
  }


  public void setSpecies(String species)
  {
    this.species = species;
  }


  public String getSpecies()
  {
    return species;
  }


  public void setVar(String var)
  {
    this.var = var;
  }


  public String getVar()
  {
    return var;
  }


  public void setNameCd(String nameCd)
  {
    this.nameCd = nameCd;
  }


  public String getNameCd()
  {
    return nameCd;
  }


  public void setMap(ArrayList map)
  {
    this.map = map;
  }


  public ArrayList getMap()
  {
    return map;
  }
  
  public void setDbBean(DBSupportBean dbBean)
  {
    this.dbBean = dbBean;
  }


  public DBSupportBean getDbBean()
  {
    return dbBean;
  }


  public void setXmlBean(XMLSupportBean xmlBean)
  {
    this.xmlBean = xmlBean;
  }


  public XMLSupportBean getXmlBean()
  {
    return xmlBean;
  }


  public void setSubDescription(ArrayList subDescription)
  {
    this.subDescription = subDescription;
  }


  public ArrayList getSubDescription()
  {
    return subDescription;
  }


  public void setPart(ArrayList part)
  {
    this.part = part;
  }


  public ArrayList getPart()
  {
    return part;
  }


  public void setReferences(ArrayList references)
  {
    this.references = references;
  }


  public ArrayList getReferences()
  {
    return references;
  }


  public void setSynonyms(ArrayList synonyms)
  {
    this.synonyms = synonyms;
  }


  public ArrayList getSynonyms()
  {
    return synonyms;
  }


  public void setSynGenus(ArrayList synGenus)
  {
    this.synGenus = synGenus;
  }


  public ArrayList getSynGenus()
  {
    return synGenus;
  }


  public void setSynSpecies(ArrayList synSpecies)
  {
    this.synSpecies = synSpecies;
  }


  public ArrayList getSynSpecies()
  {
    return synSpecies;
  }


  public void setSynAuthor(ArrayList synAuthor)
  {
    this.synAuthor = synAuthor;
  }


  public ArrayList getSynAuthor()
  {
    return synAuthor;
  }


  public void setCountyIL(ArrayList countyIL)
  {
    this.countyIL = countyIL;
  }


  public ArrayList getCountyIL()
  {
    return countyIL;
  }


  public void setCountyMI(ArrayList countyMI)
  {
    this.countyMI = countyMI;
  }


  public ArrayList getCountyMI()
  {
    return countyMI;
  }


  public void setCountyIN(ArrayList countyIN)
  {
    this.countyIN = countyIN;
  }


  public ArrayList getCountyIN()
  {
    return countyIN;
  }


  public void setCountyWI(ArrayList countyWI)
  {
    this.countyWI = countyWI;
  }


  public ArrayList getCountyWI()
  {
    return countyWI;
  }


  public void setFamily(String family)
  {
    this.family = family;
  }


  public String getFamily()
  {
    return family;
  }


  public void setSimSpeciesGID(ArrayList simSpeciesGID)
  {
    this.simSpeciesGID = simSpeciesGID;
  }


  public ArrayList getSimSpeciesGID()
  {
    return simSpeciesGID;
  }


  public void setReferencesLinksTxt(ArrayList referencesLinksTxt)
  {
    this.referencesLinksTxt = referencesLinksTxt;
  }


  public ArrayList getReferencesLinksTxt()
  {
    return referencesLinksTxt;
  }


  public void setSimilarSpeciesLinksTxt(ArrayList similarSpeciesLinksTxt)
  {
    this.similarSpeciesLinksTxt = similarSpeciesLinksTxt;
  }


  public ArrayList getSimilarSpeciesLinksTxt()
  {
    return similarSpeciesLinksTxt;
  }


  public void setSimilarSpeciesLinksUri(ArrayList similarSpeciesLinksUri)
  {
    this.similarSpeciesLinksUri = similarSpeciesLinksUri;
  }


  public ArrayList getSimilarSpeciesLinksUri()
  {
    return similarSpeciesLinksUri;
  }


  public void setNotesLinksTxt(ArrayList notesLinksTxt)
  {
    this.notesLinksTxt = notesLinksTxt;
  }


  public ArrayList getNotesLinksTxt()
  {
    return notesLinksTxt;
  }


  public void setEtymologyLinksTxt(ArrayList etymologyLinksTxt)
  {
    this.etymologyLinksTxt = etymologyLinksTxt;
  }


  public ArrayList getEtymologyLinksTxt()
  {
    return etymologyLinksTxt;
  }


  public void setFurtherInfoLinksTxt(ArrayList furtherInfoLinksTxt)
  {
    this.furtherInfoLinksTxt = furtherInfoLinksTxt;
  }


  public ArrayList getFurtherInfoLinksTxt()
  {
    return furtherInfoLinksTxt;
  }


  public void setSubSpecies(String subSpecies)
  {
    this.subSpecies = subSpecies;
  }


  public String getSubSpecies()
  {
    return subSpecies;
  }


  public void setVarAuthor(String varAuthor)
  {
    this.varAuthor = varAuthor;
  }


  public String getVarAuthor()
  {
    return varAuthor;
  }


  public void setSubSpAuthor(String subSpAuthor)
  {
    this.subSpAuthor = subSpAuthor;
  }


  public String getSubSpAuthor()
  {
    return subSpAuthor;
  }


  public void setFAuthor(String fAuthor)
  {
    this.fAuthor = fAuthor;
  }


  public String getFAuthor()
  {
    return fAuthor;
  }


  public void setForma(String forma)
  {
    this.forma = forma;
  }


  public String getForma()
  {
    return forma;
  }


  public void setSynVar(ArrayList synVar)
  {
    this.synVar = synVar;
  }


  public ArrayList getSynVar()
  {
    return synVar;
  }


  public void setSynVarAuthor(ArrayList synVarAuthor)
  {
    this.synVarAuthor = synVarAuthor;
  }


  public ArrayList getSynVarAuthor()
  {
    return synVarAuthor;
  }


  public void setSynSubSpec(ArrayList synSubSpec)
  {
    this.synSubSpec = synSubSpec;
  }


  public ArrayList getSynSubSpec()
  {
    return synSubSpec;
  }


  public void setSynSubSpecAuthor(ArrayList synSubSpecAuthor)
  {
    this.synSubSpecAuthor = synSubSpecAuthor;
  }


  public ArrayList getSynSubSpecAuthor()
  {
    return synSubSpecAuthor;
  }


  public void setSynForma(ArrayList synForma)
  {
    this.synForma = synForma;
  }


  public ArrayList getSynForma()
  {
    return synForma;
  }


  public void setSynFormaAuthor(ArrayList synFormaAuthor)
  {
    this.synFormaAuthor = synFormaAuthor;
  }


  public ArrayList getSynFormaAuthor()
  {
    return synFormaAuthor;
  }


  public void setGrowthForm(String growthForm)
  {
    this.growthForm = growthForm;
  }


  public String getGrowthForm()
  {
    return growthForm;
  }


  public void setSize(String size)
  {
    this.size = size;
  }


  public String getSize()
  {
    return size;
  }


  public void setUSDA(String USDA)
  {
    this.USDA = USDA;
  }


  public String getUSDA()
  {
    return USDA;
  }
  
  
  
  
}