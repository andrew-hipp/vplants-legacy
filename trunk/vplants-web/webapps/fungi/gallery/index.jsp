<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib prefix="vplants" uri="/webapp/vplants"%> 

<%
String gid = request.getParameter("gid").toString();
// find the path of this directory
String path = getServletContext().getRealPath(request.getRequestURI()).replace('\\', '/');
path = path.substring(0,path.indexOf("/index.jsp"));
path = path.substring(0,path.lastIndexOf("fungi")) +
  path.substring(path.lastIndexOf("/",path.length())+1) + "/";

String image = request.getParameter("image");
%>

<jsp:useBean  id="myBean" class="org.vplants.datahandler.DataBean" scope="page" >
  <jsp:setProperty name="myBean" property="path" value="<%= path+"../species/" %>"/>
  <jsp:setProperty name="myBean" property="gid" />
</jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">

  <head>

    <title>vPlants - <vplants:Genus /> <vplants:Species /> <vplants:SubSpecies format="false" /> <vplants:Var format="false" /> <vplants:Forma format="false" /> - Description</title>

    <meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
    <meta http-equiv="content-language" content="en-us" />
    <meta name="keywords" content="vplants, vplants.org, fungus, fungi, herbarium, herbaria, collections, specimens, museum, arboretum, botanic garden, natural history, ecology, distribution" />
    <meta name="description" content="vPlants offers thousands of plant and fungus specimens for the Chicago Region, USA, with images and descriptions." />
    <meta name="author" content="The vPlants Project" />
    <meta name="rating" content="General" />
    <meta name="doc-class" content="Living Document" />
    <meta name="copyright" content="2001-2006, The vPlants Project" />
    
    <link rel="Shortcut Icon" type="image/x-icon" href="/favicon.ico" />
    <link rel="start" title="Home page" href="http://www.vplants.org/" />
    <link rel="search" title="Search this site" href="http://www.vplants.org/search.html" />
    <link rel="help" title="Access features of this site" href="http://www.vplants.org/access.html" />

    <link href="../species/basic.css" rel="stylesheet" type="text/css" media="screen"  />
    <style type="text/css" media="screen, print">@import "../species/vp.css";</style>
    <link href="../species/print.css" rel="stylesheet" type="text/css"  media="print"  />
    <script src="../species/basic.js" type="text/javascript"></script>

  </head>

  <body id="vplants" class="fungus gallery" >
    <!-- Body ID allows user styling of vPlants pages. 
    Body CLASS allows author styling of that page. -->
    <a class="zero" id="top" name="top"></a>
    
    <div id="header" class="clearfix">
    <div id="logo"><a tabindex="2" 
     href="/"
     title="vPlants.org Home."><img src="/img/logo_f.gif" 
     width="240" height="60" alt="vPlants" /></a></div>
    <p class="hide">
    <a href="#tabmenu">Skip to local menu.</a>
    </p>
    <div id="headerform">
    <div id="simpleform">
    <form
     name="simple"
     method="post"
     action="/xsql/fungi/findtaxa.xsql">
    
    <p><input id="submit" name="submit" type="submit" value="Search"
     tabindex="107" title="Perform Search." />
     <label for="genus" accesskey="4" 
     title="Example: Agaricus.">Genus: 
    <input class="texts" id="genus" name="genus" type="text" maxlength="30" 
     tabindex="104" title="Enter name of a genus [one word, can use first several letters]." value="" /></label>
    </p>
    <p><label for="species" 
     title="Example: campestris.">Species Epithet: 
    <input class="texts" id="species" name="species" type="text" maxlength="30" 
     tabindex="105" title="Enter the species epithet, or subspecies, or variety [one word]." value="" /></label>
    </p>
    <p><label for="common" 
     title="Example: field mushroom.">Common Name: 
    <input class="texts" id="common" name="common" type="text" maxlength="50" 
     tabindex="106" title="Enter a common name [can use more than one word]." value="" /></label></p></form></div></div>
    
    
    <div id="tagline"><h1>vPlants.org</h1>
     <p><a href="/about_herbarium.html" 
     title="What is a Herbarium?">A Virtual Herbarium of the Chicago Region</a></p></div>
    </div><!-- End of #header -->
    
    
    <div id="tabs" class="clearfix">
    <p class="hide">
    <a id="tabmenu" name="tabmenu" ></a>
    <a href="#primary">Skip to gallery thumbnails.</a>
    </p>
  
    <ul id="taxtabs"><li><a tabindex="200" 
     href="/xsql/fungi/famtaxa.xsql?fam=<vplants:Family />" 
     title="Go to listing for this Family.">Fungus Family:  
     <strong><vplants:Family /></strong></a></li><li><a 
     href="/xsql/fungi/gentaxa.xsql?gen=<vplants:Genus />" 
     title="Go to listing for this Genus.">Genus:  
    <strong><vplants:Genus /></strong></a></li></ul>
    
    <ul id="viewtabs"><li><a 
     href="/xsql/fungi/taxon.xsql?gid=<vplants:GID />"
     title="All Specimens for this fungus.">Specimens</a></li><li><a 
     href="/fungi/species/species.jsp?gid=<vplants:GID />"
     title="Description for this fungus.">Description</a></li><li
     class="thispage"><span 
     title="You are here: Photo Gallery for this fungus.">Photos</span></li></ul>
    </div><!-- End of #tabs -->
    
    <div id="main1" class="clearfix"><div id="main2" class="clearfix">
    <!-- PAGE CONTENT STARTS --><a class="zero" id="content" name="content"></a>
    <div id="content1"><!-- start of primary content -->
    <p class="hide">
    <a id="primary" name="primary"></a>
    <a href="#sitemenu">Skip to site menu.</a>
    </p>

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
    
    <p><a href="/xsql/fungi/taxon.xsql?gid=<vplants:GID />">See herbarium specimen records</a>
     | 
    <a href="/fungi/species/species.jsp?gid=<vplants:GID />">See fungus description</a>
    </p>

<!-- Start Gallery Thumbnails -->

	<%@ include file="gallery.jsp" %>

<!-- End Gallery Thumbnails -->  

    </div><!-- end of #content1 -->
    </div><!-- end of #main1 -->
    
    <div id="menu"><!-- start of #menu -->
    <p class="hide">
    <a id="sitemenu" name="sitemenu"></a>
    <a href="#footmenu">Skip to footer and access key menu.</a>
    </p>
    <ul><li 
     class="search"><a tabindex="500"
     href="search.html"
     title="Advanced Search.">Search</a></li><li 
     class="home"><a 
     href="/"
     title="Home Page.">Home</a></li><li><a 
     href="/about.html" 
     title="About vPlants and its partners.">About Us</a></li><li 
     class="plant head"><a 
     href="/plants/"
     title="Plant directory.">Plants</a></li><li 
     class="fungus head thismenu"><a 
     href="/fungi/"
     title="Fungus directory.">Fungi</a></li>
	 
	 <li 
     class="fungus item"><a 
     href="/fungi/diversity.html"
     title="All about fungi of the region.">Diversity</a></li><li 
     class="fungus item"><a 
     href="/fungi/glossary/"
     title="Definitions of terms for fungi.">Glossary</a></li><li 
     class="fungus item"><a 
     href="/documents/f_docs.html"
     title="View or download files and working documents.">Documents</a></li><li 
     class="fungus item"><a 
     href="/biblio_fungus.html"
     title="List of Books and other literature.">References</a></li><li 
     class="fungus item"><a 
     href="/links_fungus.html"
     title="Links to related web sites.">Links</a></li>

	 <li><a 
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
  
      
   

