<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib prefix="vplants" uri="/webapp/vplants"%> 

<% String gid = request.getParameter("gid").toString(); %>

<jsp:useBean  id="myBean" class="org.vplants.datahandler.DataBean" scope="page" >
  <jsp:setProperty name="myBean" property="gid" />
</jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">

  <head>
    
    
    <title>vPlants - <vplants:Genus /> <vplants:Species /> <vplants:SubSpecies format="false" /> <vplants:Var format="false" /> <vplants:Forma format="false" /> - Description</title>
    
    <meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
    <meta name="keywords" content="vplants, vplants.org, plant, plants, herbarium, herbaria, collections, specimens, museum, arboretum, botanic garden, natural history, ecology, distribution" />
    <meta name="description" content="vPlants offers thousands of plant and fungus specimens for the Chicago Region, USA, with images and descriptions." />
    <meta name="author" content="The vPlants Project" />
    <meta http-equiv="content-language" content="en-us" />
    <meta content="General" name="rating" />
    <meta content="Living Document" name="doc-class" />
    <meta content="Copyright (c) 2001-2005 The vPlants Project" name="copyright" />
    
    <link rel="Shortcut Icon" type="image/x-icon" href="/favicon.ico" />
    <link rel="start" title="Home page" href="http://www.vplants.org/" />
    <link rel="search" title="Search this site" href="http://www.vplants.org/search.html" />
    <link rel="help" title="Access features of this site" href="http://www.vplants.org/access.html" />
    

    <link href="basic.css" rel="stylesheet" type="text/css" media="screen"  />
    <style type="text/css" media="screen, print">@import "vp.css";</style>
    <link href="/css/print.css" rel="stylesheet" type="text/css"  media="print"  />
    <script src="basic.js" type="text/javascript"></script>


<!--
    <link href="/css/basic.css" rel="stylesheet" type="text/css" media="screen"  />
    <style type="text/css" media="screen, print">@import "/css/vp.css";</style>
    <link href="/print.css" rel="stylesheet" type="text/css"  media="print"  />
    <script src="/js/basic.js" type="text/javascript"></script>
-->

  </head>

  <body id="vplants" class="plant descrip" >
    <!-- Body ID allows user styling of vPlants pages. 
    Body CLASS allows author styling of that page. -->
    <a class="zero" id="top" name="top"></a>
    
    <div id="header" class="clearfix">
    <div id="logo"><a tabindex="2" 
     href="http://www.vplants.org/"
     title="vPlants.org Home."><img src="/img/logo.gif" 
     width="240" height="60" alt="vPlants" /></a></div>
    <p class="hide">
    <a href="#tabmenu">Skip to tab menu.</a>
    </p>
    <div id="headerform">
    <div id="simpleform">
    <form
     name="simple"
     method="post"
     action="http://www.vplants.org/xsql/vplants/simple.xsql">
    
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
     href="/xsql/vplants/snidx.xsql?fam=<vplants:Family />" 
     title="Go to listing for this Family.">Plant<!-- insert GROUP --> Family:  
     <strong><vplants:Family /></strong></a></li><li><a 
     href="/xsql/vplants/gensn.xsql?gen=<vplants:Genus />" 
     title="Go to listing for this Genus.">Genus:  
    <strong><vplants:Genus /></strong></a></li></ul>
    
    <ul id="viewtabs"><li><a 
     href="/xsql/vplants/taxon.xsql?gid=<vplants:GID />"
     title="All Specimens for this plant.">Specimens</a></li><li
     class="thispage"><span 
     title="You are here: Description for this plant.">Description</span></li>
     <!--<li><a 
     href="#"
     title="Photo Gallery for this plant.">Photos</a></li>
     -->
     </ul>
    </div><!-- End of #tabs -->
    
    <div id="main1" class="clearfix"><div id="main2" class="clearfix">
    <!-- PAGE CONTENT STARTS --><a class="zero" id="content" name="content"></a>
    <div id="content1"><!-- start of primary content -->
    <p class="hide">
    <a id="primary" name="primary"></a>
    <a href="#xlinks">Skip to links and references.</a>
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
    
    <dl id="deflist"><!-- Start main definition list 
    Each definition pair has a matching class -->
    
    <vplants:CommonNames />
    
    <vplants:Synonyms />    
    
    <vplants:Desc />
      
    <vplants:SimilarSpecies /> 
    
    <vplants:Flowering />
    
    <vplants:HabitatEcology /> 
    
    <vplants:Nativity />
    
    <vplants:Notes />
     
    <vplants:Etymology />
    
    <dt class="namecode">vPlants name code:</dt>
    <dd class="namecode">
      <vplants:NameCD />
    </dd>
    <dd class="hide">
    <a id="xlinks" name="xlinks" ></a>
    <a href="#secondary">Skip to photo and distribution map.</a>
    </dd>
    
    <dt id="further">Further information (external links):</dt>
    <vplants:FurtherInfo />
    <% if (myBean.getUSDA() != null && !myBean.getUSDA().equalsIgnoreCase("")){ %>
      <dd class="links">
        <a href="http://plants.usda.gov/cgi_bin/plant_profile.cgi?symbol=<%= myBean.getUSDA() %>">
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
    
    <!-- start of side content -->
    <div id="content2">
    <p class="hide">
    <a id="secondary" name="secondary"></a>
    <a href="#sitemenu">Skip to site menu.</a>
    </p>
    <div id="portrait">
    <!--
    <a tabindex="400" href="#" 
     title="Go to Photo Gallery.">
    -->
     <vplants:Images /> alt="<vplants:Genus /> <vplants:Species /> <vplants:SubSpecies format="false" showAuthor="false"/> <vplants:Var format="false" showAuthor="false"/> <vplants:Forma format="false" showAuthor="false"/>" />
     <!--
     </a>
     -->
     </div>
            
    <div class="box map">
    
    <h3>Specimens by county*</h3>
    <p class="taxon">
     <span class="sp">
      <em class="genus"><vplants:Genus /></em> 
      <em class="epithet"><vplants:Species /></em>
     </span>
     <vplants:SubSpecies />
     <vplants:Var />
     <vplants:Forma />
    </p>
    
<!--    <img id="map"
     usemap="#map_205x225" 
     src="geana.gif" 
     width="205" height="225" 
     alt="Chicago Region Distribution Map." />

    
    <img id="legend"
     src="legend.gif" border="0" 
     width="205" height="40"
     alt="Color Symbols used on map."
     title="Color Symbols for Specimens and Other Records." />


    <p>
    Click any county or state for specimens from that area.
    </p>

-->
    
    <div id="colinks">
      <vplants:Map />
    </div>
    <%--<div id="colinks">
    <ul>
      <li><a href="/xsql/vplants/advtaxon.xsql?gid=17578&amp;state=WI"><strong>Wisconsin</strong></a>
        <ul>
          <li><a href="/xsql/vplants/advtaxon.xsql?gid=17578&amp;state=WI&amp;county=walworth">Walworth</a></li>
          <li><a href="/xsql/vplants/advtaxon.xsql?gid=17578&amp;state=WI&amp;county=waukesha">Waukesha</a></li>
        </ul>
      </li>
      <li><a href="/xsql/vplants/advtaxon.xsql?gid=17578&amp;state=IL"><strong>Illinois</strong></a>
        <ul>
          <li><a href="/xsql/vplants/advtaxon.xsql?gid=17578&amp;state=IL&amp;county=cook">Cook</a></li>
          <li><a href="/xsql/vplants/advtaxon.xsql?gid=17578&amp;state=IL&amp;county=dupage">DuPage</a></li>
          <li><a href="/xsql/vplants/advtaxon.xsql?gid=17578&amp;state=IL&amp;county=kane">Kane</a></li>
          <li><a href="/xsql/vplants/advtaxon.xsql?gid=17578&amp;state=IL&amp;county=kankakee">Kankakee</a></li>
          <li><a href="/xsql/vplants/advtaxon.xsql?gid=17578&amp;state=IL&amp;county=lake">Lake</a></li>
          <li><a href="/xsql/vplants/advtaxon.xsql?gid=17578&amp;state=IL&amp;county=mchenry">McHenry</a></li>
        </ul>
      </li>
    
      <li><a href="/xsql/vplants/advtaxon.xsql?gid=17578&amp;state=IN"><strong>Indiana</strong></a>
        <ul>
          <li><a href="/xsql/vplants/advtaxon.xsql?gid=17578&amp;state=IN&amp;county=lake">Lake</a></li>
        </ul>
      </li>
    
    <!-- no Michigan records in this example. -->
    </ul></div> --%>
    
    <p class="small">*Counties listed in brackets represent specimens lacking that exact data on their labels.</p>
    
    <p>
    <a href="/xsql/vplants/taxon.xsql?gid=<vplants:GID />">
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
     href="http://www.vplants.org/search.html"
     title="Advanced Search.">Search</a></li><li 
     class="home"><a 
     href="http://www.vplants.org/"
     title="Home Page.">Home</a></li><li 
     class="plant head"><a class="thismenu" 
     href="/plants/"
     title="Plant directory.">Plants</a></li><li 
     class="plant item"><a 
     href="/plants/diversity.html"
     title="All about plants of the region.">Diversity</a></li><li 
     class="plant item"><a 
     href="/plants/glossary/"
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
     href="/fungi/"
     title="Fungus directory.">Fungi</a></li><li><a href="/help.html" 
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
     <p><a class="helptext" href="/access.html" title="Access Keys: press number key (Windows, Alt plus number) (Mac, Control plus number).">Keyboard shortcuts:</a> Press number key (Windows, Alt plus key) (Mac, Control plus key).</p>
     <ul><li><a tabindex="900" href="http://www.vplants.org/" accesskey="1">1: Home</a></li>
     <li><a href="#content" accesskey="2">2: Page Content</a></li>
     <li><a href="#top" accesskey="3">3: Page Top</a></li>
     <li>4: Search</li><!-- accesskey 4 is attached to first label in search form. -->
     <li><a href="http://www.vplants.org/search.html" accesskey="5">5: Advanced Search</a></li>
     </ul>
     <ul>
     <li><a href="/sitemap.html" accesskey="7">7: Site Map</a></li>
     <li><a href="/contact.html" accesskey="8">8: Contact Us</a></li>
     <li><a href="/feedback.html" accesskey="9">9: Feedback</a></li>
     <li><a href="/access.html" accesskey="0">0: Accessibility Statement</a></li>
     </ul>
     </div>
    </div><!-- End #footer -->
    
    
    
    <div>
    <map id="map_205x225" name="map_205x225">
    
    <area shape="rect" alt="Wisconsin (5 counties)" title="Wisconsin (5 counties), see specimens" 
     coords="3,9,36,33" 
     href="/xsql/vplants/advtaxon.xsql?gid=<vplants:GID />&amp;state=WI" 
      />
    <area shape="rect" alt="Illinois (11 counties)" title="Illinois (11 counties), see specimens" 
     coords="2,144,29,171" 
     href="/xsql/vplants/advtaxon.xsql?gid=<vplants:GID />&amp;state=IL" 
      />
    <area shape="rect" alt="Indiana (7 counties)" title="Indiana (7 counties), see specimens" 
     coords="171,157,201,183" 
     href="/xsql/vplants/advtaxon.xsql?gid=<vplants:GID />&amp;state=IN" 
      />
    <area shape="rect" alt="Michigan (1 county)" title="Michigan (1 county), no records" 
     coords="180,60,204,86" 
      />
    
    <area shape="rect" alt="Kenosha County, Wisconsin"  title="Kenosha County, Wisconsin, has other records" 
     coords="54,53,82,63" 
      />
    <area shape="rect" alt="Milwaukee County, Wisconsin" title="Milwaukee County, Wisconsin, has other records" 
     coords="69,8,81,37" 
      />
    <area shape="rect" alt="Racine County, Wisconsin" title="Racine County, Wisconsin, has other records" 
     coords="54,39,83,50" 
      />
    <area shape="rect" alt="Walworth County, Wisconsin" title="Walworth County, Wisconsin, see specimens" 
     coords="26,39,52,64" 
     href="/xsql/vplants/advtaxon.xsql?gid=<vplants:GID />&amp;state=WI&amp;county=walworth" 
      />
    <area shape="rect" alt="Waukesha County, Wisconsin" title="Waukesha County, Wisconsin, see specimens" 
     coords="41,9,66,36" 
     href="/xsql/vplants/advtaxon.xsql?gid=<vplants:GID />&amp;state=WI&amp;county=waukesha" 
      />
    
    <area shape="rect" alt="Boone County, Illinois" title="Boone County, Illinois, no records" 
     coords="14,68,27,94" 
      />
    <area shape="poly" alt="Cook County, Illinois" title="Cook County, Illinois, see specimens" 
     coords="58,96,58,108,77,109,77,146,85,146,85,153,98,153,98,130,85,95" 
     href="/xsql/vplants/advtaxon.xsql?gid=<vplants:GID />&amp;state=IL&amp;county=cook" 
      />
    <area shape="rect" alt="DeKalb County, Illinois" title="DeKalb County, Illinois, no records" 
     coords="14,96,32,138" 
      />
    <area shape="rect" alt="DuPage County, Illinois" title="DuPage County, Illinois, see specimens" 
     coords="57,111,75,131" 
     href="/xsql/vplants/advtaxon.xsql?gid=<vplants:GID />&amp;state=IL&amp;county=dupage" 
      />
    <area shape="rect" alt="Grundy County, Illinois" title="Grundy County, Illinois, no records" 
     coords="36,155,55,183" 
      />
    <area shape="rect" alt="Kane County, Illinois" title="Kane County, Illinois, see specimens" 
     coords="35,96,54,131" 
     href="/xsql/vplants/advtaxon.xsql?gid=<vplants:GID />&amp;state=IL&amp;county=kane" 
      />
    <area shape="poly" alt="Kankakee County, Illinois" title="Kankakee County, Illinois, see specimens" 
     coords="98,191,57,191,58,177,71,177,71,169,98,169" 
     href="/xsql/vplants/advtaxon.xsql?gid=<vplants:GID />&amp;state=IL&amp;county=kankakee" 
      />
    <area shape="rect" alt="Kendall County, Illinois" title="Kendall County, Illinois, no records" 
     coords="35,134,54,152" 
      />
    <area shape="rect" alt="Lake County, Illinois" title="Lake County, Illinois, see specimens" 
     coords="62,67,84,93" 
     href="/xsql/vplants/advtaxon.xsql?gid=<vplants:GID />&amp;state=IL&amp;county=lake" 
      />
    <area shape="rect" alt="McHenry County, Illinois" title="McHenry County, Illinois, see specimens"
     coords="29,68,59,93" 
     href="/xsql/vplants/advtaxon.xsql?gid=<vplants:GID />&amp;state=IL&amp;county=mchenry" 
      /> 
    <area shape="poly" alt="Will County, Illinois" title="Will County, Illinois, no records" 
     coords="57,133,58,174,69,174,69,167,98,166,98,155,84,155,83,148,75,148,75,141,68,141,67,133" 
      />
    
    <area shape="poly" alt="Jasper County, Indiana" title="Jasper County, Indiana, no records"
     coords="117,176,118,213,126,213,126,205,133,205,133,200,136,200,136,176,131,175,127,171,122,171" 
      />
    <area shape="poly" alt="Lake County, Indiana"  title="Lake County, Indiana, see specimens"  
     coords="101,136,101,178,113,177,119,172,119,142,110,141" 
     href="/xsql/vplants/advtaxon.xsql?gid=<vplants:GID />&amp;state=IN&amp;county=lake" 
      />
    <area shape="poly" alt="LaPorte County, Indiana" title="LaPorte County, Indiana, no records" 
     coords="139,133,139,172,149,165,153,155,163,155,163,129,143,129" 
      />
    <area shape="rect" alt="Newton County, Indiana" title="Newton County, Indiana, no records"
     coords="101,180,115,213" 
      />
    <area shape="poly" alt="Porter County, Indiana" title="Porter County, Indiana, no records"
     coords="121,140,121,169,129,169,136,174,136,134"
      />
    <area shape="rect" alt="St. Joseph County, Indiana" title="St. Joseph County, Indiana, no records"
     coords="164,128,190,152"
      />
    <area shape="poly" alt="Starke County, Indiana" title="Starke County, Indiana, no records" 
     coords="138,173,138,179,166,179,166,157,155,157,149,168"
      />
    
    <area shape="poly" alt="Berrien County, Michigan" title="Berrien County, Michigan, no records"
     coords="171,89,150,125,180,125,180,89"
      />
    
    <area shape="default" nohref="nohref" alt=" " />
    </map>
    </div>
  
  </body>
</html>
  
      
   

