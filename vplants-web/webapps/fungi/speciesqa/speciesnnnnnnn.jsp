<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="vplants" uri="/webapp/vplants"%> 

<%
  String gid = request.getParameter("gid").toString();
  // find the path of this directory
  String path = getServletContext().getRealPath(request.getRequestURI()).replace('\\', '/');
  path = path.substring(0,path.indexOf("/species.jsp"));
  path = path.substring(0,path.lastIndexOf("fungi")) + 
    path.substring(path.lastIndexOf("/",path.length())+1) + "/";
%>

<jsp:useBean  id="myBean" class="org.vplants.datahandler.DataBean" scope="page" >
  <jsp:setProperty name="myBean" property="path" value="<%= path %>"/>
  <jsp:setProperty name="myBean" property="gid" />
</jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="en-us">

  <head>

    <title>vPlants - <vplants:Genus /> <vplants:Species /> <vplants:SubSpecies format="false" /> <vplants:Var format="false" /> <vplants:Forma format="false" /> - Description</title>
    
<%-- **Insert ModificationDate from XML here** --%>
    <meta name="date" content="<vplants:ModificationDate />" >

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="content-language" content="en-us" >
    <meta name="keywords" content="vplants, vplants.org, fungus, fungi, herbarium, herbaria, collections, specimens, museum, arboretum, botanic garden, natural history, ecology, distribution">
    <meta name="description" content="vPlants offers thousands of plant and fungus specimens for the Chicago Region, USA, with images and descriptions.">
    <meta name="author" content="The vPlants Project" >
    <meta name="rating" content="General" >
    <meta name="doc-class" content="Living Document" >
    <meta name="copyright" content="2001-2007, The vPlants Project" >
    
    <link rel="Shortcut Icon" type="image/x-icon" href="/favicon.ico" >
    <link rel="start" title="Home page" href="http://www.vplants.org/" >
    <link rel="search" title="Search this site" href="http://www.vplants.org/search.html" >
    <link rel="help" title="Access features of this site" href="http://www.vplants.org/access.html" >
    
<link rel="stylesheet" href="/css/master.css" type="text/css" media="screen, projection">
<!--[if lte IE 7.1]><link href="/css/iewin_lte_71.css" rel="stylesheet" type="text/css" media="screen, projection"><![endif]-->
<link rel="stylesheet" href="/css/print.css"  type="text/css" media="print"> 

  </head>
<body id="vplants-org" class="fungi guide descrip" >
<div id="bodywrap">

<div id="sitehead">
<a id="pagetop" name="pagetop"></a>

<div id="breadcrumbs">
You are here:
<a href="/">Home</a> &#187;
<a href="/fungi/guide/">Fungus Guide</a> &#187;
<strong><vplants:Genus /> <vplants:Species /> <vplants:SubSpecies format="false" /> <vplants:Var format="false" /> <vplants:Forma format="false" /> - Description</strong>
</div>

<p class="access"><a href="#pagecontent" accesskey="2" title="Skip to page content.">[Skip to page content]</a></p>
<p class="access"><a href="#menu1" title="Skip to menu one.">[Skip to primary menu]</a></p>
 <div id="headform">
  <form name="simple" method="post" action="/xsql/fungi/findtaxa.xsql">
   <h5>Fungus <br>Search</h5>
   <p><label for="family" accesskey="4" 
    title="Example: Agaricaceae.">Family:</label>
    <input class="texts" id="family" name="family" type="text" maxlength="30" 
     title="Enter name of a family [one word, can use first several letters]." 
     value=""></p>
   <p><label for="genus"  
    title="Example: Agaricus.">Genus:</label> 
    <input class="texts" id="genus" name="genus" type="text" maxlength="30" 
     title="Enter name of a genus [one word, can use first several letters]." 
     value=""></p>
   <p><label for="species" 
    title="Example: campestris.">Species Epithet:</label> 
    <input class="texts" id="species" name="species" type="text" maxlength="30" 
     title="Enter the species epithet, or subspecies, or variety [one word]."
     value=""></p>
   <p><label for="common" 
    title="Example: field mushroom.">Common Name:</label> 
    <input class="texts" id="common" name="common" type="text" maxlength="50" 
     title="Enter a common name [can use more than one word]." 
     value=""><input class="actions" id="submit" name="submit" type="submit" 
      value="Go" title="Perform Search."></p></form>
 </div>
<div id="logo"><a href="/" title="vPlants.org Home."><img src="/img/logo2h_f.gif" alt="vPlants.org Home."></a></div>
<p id="tagline"><strong>vPlants.org</strong>
<a href="/topics/" title="What is a Herbarium?">A Virtual Herbarium of the Chicago Region</a></p>
</div><!-- End of #sitehead -->

<div id="wrapper1">

<div id="content1wrap">

<div id="content1"><a id="pagecontent" name="pagecontent"></a>  


    <h1 class="taxon">
     <span class="sp">
      <em class="genus"><vplants:Genus /></em> 
      <em class="epithet"><vplants:Species /></em> 
      <span class="author"><vplants:Author /></span>
     </span>
     <vplants:SubSpecies />
     <vplants:Var />
     <vplants:Forma />
    </h1>
    
    <p><a href="/xsql/fungi/taxon.xsql?gid=<vplants:GID />">See herbarium specimen records</a>
     | 
    <a href="../gallery/index.jsp?gid=<vplants:GID />">See photo gallery</a>
    </p>
    
    <dl id="deflist"><!-- Start main definition list 
    Each definition pair has a matching class -->
    
    <vplants:CommonNames />
    
    <vplants:Synonyms />    
    
    <vplants:Desc />

<dt class="help"><a href="/help/description.html" 
    title="Help with descriptions">Help</a>:</dt>
<dd>
<a href="/fungi/glossary/">Fungus Glossary</a>
</dd>

    <vplants:SimilarSpecies /> 
    
    <vplants:Fruiting />
    
    <vplants:HabitatEcology /> 
    
    <vplants:Notes />
     
    <vplants:Etymology />
    
<%-- **Insert Author and ModificationDate from XML here** --%>
	<dt class="namecode">vPlants</dt>
	<dd class="namecode">
	name code: <vplants:NameCD />
	<%= (myBean.getXmlAuthor() != null && !myBean.getXmlAuthor().equals("") ? "; page author: " : "" ) %><vplants:XmlAuthor />
	<%= (myBean.getModificationDate() != null && !myBean.getModificationDate().equals("") ? "; page date: " : "" ) %><vplants:ModificationDate />
	</dd>
	
    <dt id="further">Further information (external links):</dt>
    <vplants:FurtherInfo />
    <% if (myBean.getIFUN() != null && !myBean.getIFUN().equalsIgnoreCase("")){ %>
      <dd class="links">
        <a href="http://www.indexfungorum.org/Names/NamesRecord.asp?RecordID=<%= myBean.getIFUN() %>">Index Fungorum names record</a> and <a href="http://www.indexfungorum.org/Names/SynSpecies.asp?RecordID=<%= myBean.getIFUN() %>">Synonymy</a> information.</dd>
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
</div><!-- end of #content1wrap -->

<div id="content2"><!-- start of side content -->
<!-- any image width should be 250 pixels -->

    <div id="portrait">
    <a tabindex="400" href="../gallery/index.jsp?gid=<vplants:GID />" 
     title="Go to Photo Gallery.">
     <vplants:Images /> alt="<vplants:Genus /> <vplants:Species /> <vplants:SubSpecies format="false" showAuthor="false"/> <vplants:Var format="false" showAuthor="false"/> <vplants:Forma format="false" showAuthor="false"/>" width="250" /></a>

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
    <a href="/xsql/fungi/taxon.xsql?gid=<vplants:GID />">
    Or click here for specimen records from all counties.</a>
    </p>
    </div><!-- End box map -->
    

<p class="small">Information provided on this page applies to the Chicago Region and may not be relevant or complete for other regions.</p><p class="small noprint"><a href="/disclaimer.html" title="Read Disclaimer.">Disclaimer</a></p>

</div><!-- end of #content2 -->


<div id="sitemenu"><a id="menu1" name="menu1"></a>
<h5 class="access">Primary Menu <a href="#menu2" title="Skip this menu.">[Skip]</a></h5>
<ul class="home"><li><a 
 class="start" href="/" 
 title="Home page.">Home</a></li></ul>
<ul class="plant"><li><a 
 class="start" href="/plants/" 
 title="Plants start page.">Plants</a></li></ul>
<ul class="fungus"><li><a 
 class="start" href="/fungi/" 
 title="Fungi start page.">Fungi</a></li><li><a 
 class="guide" href="/fungi/guide/" 
 title="Guide to fungi.">Guide</a></li><li><a 
 class="glossary" href="/fungi/glossary/" 
 title="Definitions of terms for fungi.">Glossary</a></li></ul>
<ul class="tools"><li><a accesskey="5" 
 class="search" href="/search.html" 
 title="Advanced search for plants or fungi.">Search</a></li><li><a 
 class="help" href="/help/" 
 title="Help and user guide.">Help Guide</a></li><li><a 
 class="topics" href="/topics/" 
 title="Collections, habitats, and more.">Topics</a></li><li><a 
 class="resources" href="/resources/" 
 title="Documents, books, and links.">Resources</a></li></ul>
</div><!-- end of #sitemenu -->

<div id="pagemenu"><a id="menu2" name="menu2"></a>
<h5 class="access">Secondary Menu <a href="#menu3" title="Skip this menu.">[Skip]</a></h5>
 <ul id="pageset1"><li><a 
  href="/xsql/fungi/famtaxa.xsql?fam=<vplants:Family />" 
  title="Go to listing for this Family.">Family: 
  <strong><vplants:Family /></strong></a></li><li><a 
  href="/xsql/fungi/gentaxa.xsql?gen=<vplants:Genus />" 
  title="Go to listing for this Genus.">Genus:  
  <strong><vplants:Genus /></strong></a></li></ul>

 <ul id="pageset2"><li><a 
  href="/xsql/fungi/taxon.xsql?gid=<vplants:GID />"
  title="All Specimens for this fungus.">Specimens</a></li><li
  class="thispage"><span 
  title="You are here: Description for this fungus.">Description</span></li>

  <li><a 
  href="/fungi/gallery/index.jsp?gid=<vplants:GID />"
  title="Photo Gallery for this fungus.">Photos</a></li>
 </ul>
<span class="filler">&nbsp;</span>
</div><!-- End of #pagemenu -->
	
</div><!-- end of #wrapper1 -->

<div id="sitefoot"><a id="menu4" name="menu4"></a>
<h5 class="access">Footer Menu</h5>
<ul id="footmenu"><li><a href="/" accesskey="1" title="Home page.">Home</a></li><li><a href="/help/" accesskey="6" title="Help and user guide.">Help Guide</a></li><li><a href="/sitemap.html" accesskey="7" title="Table of contents.">Site Map</a></li><li><a href="/about/contact.html" accesskey="8" title="Contact information.">Contact Us</a></li><li><a href="/about/feedback.html" accesskey="9" title="Please provide feedback!">Feedback</a></li><li><a href="/access.html" accesskey="0" title="Accessibility features of this site.">Accessibility Statement</a></li></ul>
<p id="funds">Funded by <a href="http://www.imls.gov" title="Go to IMLS web site.">Institute of Museum and Library Services (IMLS)</a></p>
<p id="citation">Citation: <span class="helptext" title="This is how you list this web site as a reference.">The vPlants Project. vPlants: A Virtual Herbarium of the Chicago Region. http://www.vplants.org</span></p>
<p id="copyright">Copyright &#169; 2001&#8211;2006 The vPlants Project, All Rights Reserved.</p>
<p><a href="/about/partner_mor.html" title="Read about this partner.">The Morton Arboretum</a>, <a href="/about/partner_f.html" title="Read about this partner.">The Field Museum</a>, <a href="/about/partner_chic.html" title="Read about this partner.">Chicago Botanic Garden</a>, <a href="/about/partner_other.html" title="Read about other partners.">Additional Partners</a></p>
<p class="access"><a href="#pagetop" accesskey="3" title="Back to top of page.">[Back to top of page]</a></p>
</div><!-- End #sitefoot -->

</div><!-- End of #bodywrap -->
</body>
</html>

