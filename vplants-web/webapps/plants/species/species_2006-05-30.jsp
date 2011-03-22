<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib prefix="vplants" uri="/webapp/vplants"%> 

<%
  String gid = request.getParameter("gid").toString();
  // find the path of this directory
  String path = getServletContext().getRealPath(request.getRequestURI()).replace('\\', '/');
  path = path.substring(0,path.indexOf("/species.jsp"));
  path = path.substring(0,path.lastIndexOf("plants")) + 
    path.substring(path.lastIndexOf("/",path.length())+1) + "/";
%>

<jsp:useBean  id="myBean" class="org.vplants.datahandler.DataBean" scope="page" >
  <jsp:setProperty name="myBean" property="path" value="<%= path %>"/>
  <jsp:setProperty name="myBean" property="gid" />
</jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">

  <head>

    <title>vPlants - <vplants:Genus /> <vplants:Species /> <vplants:SubSpecies format="false" /> <vplants:Var format="false" /> <vplants:Forma format="false" /> - Description</title>
    
<%-- **Insert ModificationDate from XML here** --%>
    <meta name="date" content="<vplants:ModificationDate />" />

    <meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
    <meta http-equiv="content-language" content="en-us" />
    <meta name="keywords" content="vplants, vplants.org, plant, plants, herbarium, herbaria, collections, specimens, museum, arboretum, botanic garden, natural history, ecology, distribution" />
    <meta name="description" content="vPlants offers thousands of plant and fungus specimens for the Chicago Region, USA, with images and descriptions." />
    <meta name="author" content="The vPlants Project" />
    <meta name="rating" content="General" />
    <meta name="doc-class" content="Living Document" />
    <meta name="copyright" content="2001-2006, The vPlants Project" />
    
    <link rel="Shortcut Icon" type="image/x-icon" href="/favicon.ico" />
    <link rel="start" title="Home page" href="http://www.vplants.org/" />
    <link rel="search" title="Search this site" href="http://www.vplants.org/search.html" />
    <link rel="help" title="Access features of this site" href="http://www.vplants.org/access.html" />
    
<%-- 
<!-- Local testing links. Because this template works with CSS in this folder. -->
 --%> 
    <link href="basic.css" rel="stylesheet" type="text/css" media="screen"  />
    <style type="text/css" media="screen, print">@import "vp.css";</style>
    <link href="print.css" rel="stylesheet" type="text/css"  media="print"  />
    <script src="basic.js" type="text/javascript"></script>

<%-- 
<!-- Relative website links.
Not to be used until Patrick finishes reworking CSS for the vPlants site.
And then making any needed HTML changes to this JSP template to work with new CSS. -->
    <link href="/css/basic.css" rel="stylesheet" type="text/css" media="screen"  />
    <style type="text/css" media="screen, print">@import "/css/vp.css";</style>
    <link href="/css/print.css" rel="stylesheet" type="text/css"  media="print"  />
    <script src="/js/basic.js" type="text/javascript"></script>
--%>

<%-- 
<!-- Absolute website links. -->
    <link href="http://www.vplants.org/css/basic.css" rel="stylesheet" type="text/css" media="screen"  />
    <style type="text/css" media="screen, print">@import "http://www.vplants.org/css/vp.css";</style>
    <link href="http://www.vplants.org/css/print.css" rel="stylesheet" type="text/css"  media="print"  />
    <script src="http://www.vplants.org/js/basic.js" type="text/javascript"></script>
--%>

  </head>

  <body id="vplants" class="plant descrip" >
    <!-- Body ID allows user styling of vPlants pages. 
    Body CLASS allows author styling of that page. -->
    <a class="zero" id="top" name="top"></a>
    
    <div id="header" class="clearfix">
    <div id="logo"><a tabindex="2" 
     href="/"
     title="vPlants.org Home."><img src="/img/logo.gif" 
     width="240" height="60" alt="vPlants" /></a></div>
    <p class="hide">
    <a href="#tabmenu">Skip to local menu.</a>
    </p>
    <div id="headerform">
    <div id="simpleform">
    <form
     name="simple"
     method="post"
     action="/xsql/plants/findtaxa.xsql">
    
    <p><input id="submit" name="submit" type="submit" value="Search"
     tabindex="107" title="Perform Search." />
     <label for="genus" accesskey="4" 
     title="Example: Ulmus.">Genus: 
    <input class="texts" id="genus" name="genus" type="text" maxlength="30" 
     tabindex="104" title="Enter name of a genus [one word, can use first several letters]." value="" /></label>
    </p>
    <p><label for="species" 
     title="Example: americana.">Species Epithet: 
    <input class="texts" id="species" name="species" type="text" maxlength="30" 
     tabindex="105" title="Enter the species epithet, or subspecies, or variety [one word]." value="" /></label>
    </p>
    <p><label for="common" 
     title="Example: american elm.">Common Name: 
    <input class="texts" id="common" name="common" type="text" maxlength="50" 
     tabindex="106" title="Enter a common name [can use more than one word]." value="" /></label></p></form></div></div>
    
    
    <div id="tagline"><h1>vPlants.org</h1>
     <p><a href="/about_herbarium.html" 
     title="What is a Herbarium?">A Virtual Herbarium of the Chicago Region</a></p></div>
    </div><!-- End of #header -->
    
    
    <div id="tabs" class="clearfix">
    <p class="hide">
    <a id="tabmenu" name="tabmenu" ></a>
    <a href="#primary">Skip to plant description.</a>
    </p>
  
    <ul id="taxtabs"><li><a tabindex="200" 
     href="/xsql/plants/famtaxa.xsql?fam=<vplants:Family />" 
     title="Go to listing for this Family.">Plant Family:  
     <strong><vplants:Family /></strong></a></li><li><a 
     href="/xsql/plants/gentaxa.xsql?gen=<vplants:Genus />" 
     title="Go to listing for this Genus.">Genus:  
    <strong><vplants:Genus /></strong></a></li></ul>
    
    <ul id="viewtabs"><li><a 
     href="/xsql/plants/taxon.xsql?gid=<vplants:GID />"
     title="All Specimens for this plant.">Specimens</a></li><li
     class="thispage"><span 
     title="You are here: Description for this plant.">Description</span></li>

     <li><a 
     href="../gallery/index.jsp?gid=<vplants:GID />"
     title="Photo Gallery for this plant.">Photos</a></li>

    </ul>
    </div><!-- End of #tabs -->
    
    <div id="main1" class="clearfix"><div id="main2" class="clearfix">
    <!-- PAGE CONTENT STARTS --><a class="zero" id="content" name="content"></a>
    <div id="content1"><!-- start of primary content -->
    <p class="hide">
    <a id="primary" name="primary"></a>
    <a href="#xlinks">Skip to links and references.</a>
    </p>

<%-- Concern or Invasive StatusTag(s) would go here, 
to produce one or the other of the following when required:--%>
<% if(myBean.getConcernList() != null && myBean.getConcernList().size() > 0) { %>
  <p class="concern">Plant of Concern</p>
<%}%>
<% if(!myBean.getInvasive().equals("")) { %>
  <p class="rating">Invasive Plant</p>
<%}%>

    <h2 class="taxon">
     <span class="sp">
      <em class="genus"><vplants:Genus /></em> 
      <em class="epithet"><vplants:Species /></em> 
      <span class="author"><vplants:Author /></span>
     </span>
     <vplants:SubSpecies />
     <vplants:Var />
     <vplants:Forma />
    </h2>
    
    <p><a href="/xsql/plants/taxon.xsql?gid=<vplants:GID />">See herbarium specimen records</a>
     | 
    <a href="../gallery/index.jsp?gid=<vplants:GID />">See photo gallery</a>
    </p>
    
    <dl id="deflist"><!-- Start main definition list 
    Each definition pair has a matching class -->
    
    <vplants:CommonNames />
    
    <vplants:Synonyms />    
    
    <vplants:Desc />


<dt class="help"><a href="/help_description.html" 
    title="Help with descriptions">Help</a>:</dt>
<dd>

    <% if (myBean.getFamily().equalsIgnoreCase("asteraceae")){ %>
      <a href="/plants/glossary/asteraceae.html" 
         title="Definitions for this family.">Asteraceae Glossary</a>, 
    <% } %>

    <% if (myBean.getFamily().equalsIgnoreCase("cyperaceae")){ %>
      <a href="/plants/glossary/cyperaceae.html" 
         title="Definitions for this family.">Cyperaceae Glossary</a>, 
    <% } %>

    <% if (myBean.getFamily().equalsIgnoreCase("poaceae")){ %>
      <a href="/plants/glossary/poaceae.html" 
         title="Definitions for this family.">Poaceae Glossary</a>, 
    <% } %>

<a href="/plants/glossary/">Plant Glossary</a>
</dd>

    <vplants:SimilarSpecies /> 
    
    <vplants:Flowering />
    
    <vplants:HabitatEcology /> 
    
    <vplants:Nativity />
    
    <vplants:ConcernList />
    
    <vplants:Notes />
     
    <vplants:Etymology />
    
<%-- **Insert Author and ModificationDate from XML here** --%>
	<dt class="namecode">vPlants</dt>
	<dd class="namecode">
	name code: <vplants:NameCD /> 
	<%= (myBean.getXmlAuthor() != null && !myBean.getXmlAuthor().equals("") ? "; page author: " : "" ) %><vplants:XmlAuthor />
	<%= (myBean.getModificationDate() != null && !myBean.getModificationDate().equals("") ? "; page date: " : "" ) %><vplants:ModificationDate />
	</dd>
	

    <dd class="hide">
    <a id="xlinks" name="xlinks" ></a>
    <a href="#secondary">Skip to photo and distribution.</a>
    </dd>
    
    <dt id="further">Further information (external links):</dt>
    <vplants:FurtherInfo />
    <% if (myBean.getUSDA() != null && !myBean.getUSDA().equalsIgnoreCase("")){ %>
      <dd class="links">
        <a href="http://plants.usda.gov/java/profile?symbol=<%= myBean.getUSDA() %>">
        USDA PLANTS Profile</a>, Includes USA map, state map links
      </dd>
    <% } %> 
    <dd class="google">Google: 
      <a href="http://www.google.com/search?hl=en&amp;ie=UTF-8&amp;oe=UTF-8&amp;q=<vplants:Genus /> <vplants:Species /> <vplants:SubSpecies format="false" label="false"/> <vplants:Var format="false" label="false"/> <vplants:Forma format="false" label="false"/>&amp;btnG=Google+Search" >Text Search</a>
     
      <a href="http://images.google.com/images?q=<vplants:Genus /> <vplants:Species /> <vplants:SubSpecies format="false" label="false"/> <vplants:Var format="false" label="false"/> <vplants:Forma format="false" label="false"/>&amp;ie=UTF-8&amp;oe=UTF-8&amp;hl=en&amp;btnG=Google+Search" >Image Search</a>
    </dd>
    <dd>
    [ We can not vouch for content of other websites ]
    </dd>
    
    
    <vplants:References />
    
    </dl><!-- End main definition list -->
    
    </div><!-- end of #content1 -->
    
    <div id="content2"><!-- start of side content -->
    <p class="hide">
    <a id="secondary" name="secondary"></a>
    <a href="#sitemenu">Skip to site menu.</a>
    </p>
    <div id="portrait">
    <a tabindex="400" href="../gallery/index.jsp?gid=<vplants:GID />" 
     title="Go to Photo Gallery.">
     <vplants:Images /> alt="<vplants:Genus /> <vplants:Species /> <vplants:SubSpecies format="false" showAuthor="false"/> <vplants:Var format="false" showAuthor="false"/> <vplants:Forma format="false" showAuthor="false"/>" /></a>

     </div>
            
    <div class="box map">
    
    <h3>Specimens by county</h3>
    <p class="taxon">
     <span class="sp">
      <em class="genus"><vplants:Genus /></em> 
      <em class="epithet"><vplants:Species /></em>
     </span>
     <vplants:SubSpecies />
     <vplants:Var />
     <vplants:Forma />
    </p>
    
<%-- Dynamic Distribution map image would go here.
--%>

    <div id="colinks">
      <vplants:Map />
    </div>

    <p>
    Click any county or state for specimens from that area.
    </p>

    <p>
    <a href="/xsql/plants/taxon.xsql?gid=<vplants:GID />">
    Or click here for specimen records from all counties.</a>
    </p>
    </div>
    
    <p class="small">
    Information provided on this page applies to the Chicago Region and may not be relevant or complete for other regions.</p>
    <p class="small">
    <a class="popup" href="/disclaimer.html" 
    title="Read Disclaimer [opens new window]." 
    onclick="window.open(this.href, 'disclaimer', 
    'width=500,height=350,resizable,top=100,left=100');
    return false;" 
    onkeypress="window.open(this.href, 'disclaimer', 
    'width=500,height=350,resizable,top=100,left=100');
    return false;">Disclaimer</a>
    </p>
    
    </div><!-- end of #content2 -->
    </div><!-- end of #main2 -->
    
    <div id="menu"><!-- start of #menu -->
    <p class="hide">
    <a id="sitemenu" name="sitemenu"></a>
    <a href="#footmenu">Skip to footer and access key menu.</a>
    </p>
    <ul><li 
     class="search"><a tabindex="500"
     href="/search.html"
     title="Advanced Search.">Search</a></li><li 
     class="home"><a 
     href="/"
     title="Home Page.">Home</a></li><li><a 
     href="/about.html" 
     title="About vPlants and its partners.">About Us</a></li><li 
     class="plant head thismenu"><a 
     href="/plants/index.html"
     title="Plant directory.">Plants</a></li><li 
     class="plant item"><a 
     href="/plants/diversity.html"
     title="All about plants of the region.">Diversity</a></li><li 
     class="plant item"><a 
     href="/plants/glossary/index.html"
     title="Definitions of terms for plants.">Glossary</a></li><li 
     class="plant item"><a 
     href="/documents/p_docs.html"
     title="View or download files and working documents.">Documents</a></li><li 
     class="plant item"><a 
     href="/biblio_plant.html"
     title="List of Books and other literature.">References</a></li><li 
     class="plant item"><a 
     href="/links_plant.html"
     title="Links to related web sites.">Links</a></li><li 
     class="fungus head"><a 
     href="/fungi/index.html"
     title="Fungus directory.">Fungi</a></li><li><a 
     href="/help.html" 
     title="Help and Frequently Asked Questions.">Help FAQ</a></li><li><a 
     href="/feedback.html"
     title="Please provide feedback!">Feedback</a></li></ul>   
    
    </div><!-- end of #menu --></div><!-- end of #main1 -->
    
    
    <div id="footer">
    <p class="hide">
    <a id="footmenu" name="footmenu"></a>
    <a href="#accessmenu">Skip to access key menu.</a>
    </p>
    <p id="funds">
    Funded by <a href="http://www.imls.gov" title="Go to IMLS web site." 
     >Institute of Museum and Library Services (IMLS)</a>
    </p>
    <p id="citation">
    Citation: <span class="helptext" title="This is how you list this web site as a reference.">
    The vPlants Project. 
    vPlants: A Virtual Herbarium of the Chicago Region. 
    http://www.vplants.org</span>
    </p>
    <p id="copyright">
    Copyright &copy; 2001 - 
    <script type="text/javascript" language="JavaScript">
    document.write(thisYear())
    </script>
     The vPlants Project 
    <br />
    <a tabindex="600" 
     href="/about_partners.html#morton" 
     title="Read about this partner.">The Morton Arboretum</a>, 
    <a 
     href="/about_partners.html#field" 
     title="Read about this partner.">The Field Museum</a>, 
    <a 
     href="/about_partners.html#botanic" 
     title="Read about this partner.">Chicago Botanic Garden</a>, 
    <a 
     href="/about_partners.html#additional" 
     title="Read about other partners.">Additional Partners</a>
    </p>
    <div id="footlinks">
    <p class="hide">
    <a id="accessmenu" name="accessmenu"></a>
    <a href="#top">Skip back to top of page.</a>
    </p>
    <p><a href="/access.html" title="Accessibility Statement">Keyboard shortcuts:</a> 
    Press number key (Windows, Alt plus key) (Mac, Control plus key).</p>
     <ul><li><a tabindex="900" href="/" accesskey="1">1: Home</a></li>
     <li><a href="#content" accesskey="2">2: Page Content</a></li>
     <li><a href="#top" accesskey="3">3: Page Top</a></li>
     <li><a href="#genus">4: Search</a></li>
     <!-- accesskey 4 is attached to first label in search form. -->
     <li><a href="/search.html" accesskey="5">5: Advanced Search</a></li>
     </ul>
     <ul>
     <li><a href="/sitemap.html" accesskey="7">7: Site Map</a></li>
     <li><a href="/contact.html" accesskey="8">8: Contact Us</a></li>
     <li><a href="/feedback.html" accesskey="9">9: Feedback</a></li>
     <li><a href="/access.html" accesskey="0">0: Accessibility Statement</a></li>
     </ul>
     </div>
    </div><!-- End #footer -->

  </body>
</html>
  
      
   

