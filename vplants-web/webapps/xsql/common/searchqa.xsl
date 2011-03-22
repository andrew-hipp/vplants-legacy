<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:import href="FormatSciname.xsl"/>
<xsl:output version="1.0" encoding="iso-8859-1" indent="no"/>

<!-- Developed by Patrick R. Leacock, using files of Matthew Schaub as reference. -->
<!-- Created 2005-10-15; Last modified 2005-10-16 -->
<!-- This serves as utility to review description pages in SPECIESQA folder. -->

<xsl:template match="/">

<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<title>vPlants - QA Links for Plants</title>

<meta name="keywords" content="vplants, vplants.org, plant, plants, herbarium, herbaria, collections, specimens, museum, arboretum, botanic garden, natural history, ecology, distribution" />
<meta name="description" content="vPlants offers thousands of plant and fungus specimens for the Chicago Region, USA, with images and descriptions." />
<meta name="author" content="The vPlants Project" />
<meta http-equiv="content-language" content="en-us" />
<meta content="General" name="rating" />
<meta content="Living Document" name="doc-class" />
<meta content="Copyright (c) 2001-2005 The vPlants Project" name="copyright" />

<link rel="Shortcut Icon" type="/image/x-icon" href="favicon.ico" />
<link rel="start" title="Home page" href="/" />
<link rel="search" title="Search this site" href="/search.html" />
<link rel="help" title="Access features of this site" href="/access.html" />

<link href="/css/basic.css" rel="stylesheet" type="text/css" media="screen"  />
<style type="text/css" media="screen, print">@import "/css/vp.css";</style>
<link href="/css/print.css" rel="stylesheet" type="text/css"  media="print"  />
<script src="/js/basic.js" type="text/javascript"></script>

<style type="text/css" media="screen, print">

#results h3.taxon {
	margin-top: 10px;
	}
#results h3.taxon .author {
	font-size: 0.8em; 
	font-style: normal; 
	font-weight: normal;
	}
div.syntaxon {
	margin: 0;
	padding-left: 2em;
	}

</style>

</head>

<body id="vplants" class="search" ><xsl:text> </xsl:text>
<xsl:comment>Body ID allows user styling of vPlants pages. 
Body CLASS allows author styling of that page.</xsl:comment>
<a class="zero" id="top" name="top"></a>


<div id="header" class="clearfix">
<div id="logo"><a tabindex="2" 
 href="/"
 title="vPlants.org Home."><img src="/img/logo.gif" 
 width="240" height="60" alt="vPlants" /></a></div>
<p class="hide">
<a href="#tabmenu">Skip to tab menu.</a>
</p>
<div id="partners"><ul><li><a tabindex="50"
 href="/about_partners.html#morton" 
 title="Read about this partner.">The Morton Arboretum</a></li><li><a 
 href="/about_partners.html#field" 
 title="Read about this partner.">The Field Museum</a></li><li><a 
 href="/about_partners.html#botanic" 
 title="Read about this partner.">Chicago Botanic Garden</a></li><li><a 
 href="/about_partners.html#additional" 
 title="Read about other partners.">Additional Partners</a></li></ul></div>


<div id="tagline"><h1>vPlants.org</h1>
 <p><a href="/about_herbarium.html" 
 title="What is a Herbarium?">A Virtual Herbarium of the Chicago Region</a></p></div>
</div><!-- End of #header -->

<div id="tabs" class="clearfix">
<p class="hide">
<a id="tabmenu" name="tabmenu" ></a>
<a href="#primary">Skip to page content.</a>
</p>
<!-- each of the following either is a link or has
  <li class="thispage"><span title="You are here: page title.">page title</span></li>   -->
<ul id="tabsleft">
<li class="thispage">
<span title="You are here: Plant QA.">Plant QA Links</span></li>
<li>
<span title="Fungus Search.">Fungus QA Links (not yet available)</span></li>
</ul>
</div><!-- End of #tabs -->

<div id="main1" class="clearfix"><div id="main2" class="clearfix">
<!-- PAGE CONTENT STARTS --><a class="zero" id="content" name="content"></a>
<div id="content1"><!-- start of primary content -->
<p class="hide">
<a id="primary" name="primary"></a>
<a href="#secondary">Skip to related pages links.</a>
</p>

<h2 >QA Links for Plants</h2>
<h3>Provides access to check Description Pages in QA folder.</h3>
<p>
The <strong>Check QA</strong> link shows the temporary page in the QA folder. The <strong>Check Public</strong> link shows the page in the public folder.  Pages that are being tested are put in the QA folder. Pages that pass inspection are put in the Public folder. Portrait images may not be loaded for many of the test pages.
</p>

<div id="results">


<xsl:apply-templates/><!-- Insert SCINAMES/ROWSET -->


</div>

<p>&nbsp;</p>
<p>&nbsp;</p>

</div><!-- end of #content1 -->


<div id="content2"><!-- start of side content -->
<p class="hide">
<a id="secondary" name="secondary"></a>
<a href="#sitemenu">Skip to site menu.</a>
</p>

<div id="simpleform">
<form
 name="simple"
 method="post"
 action="searchqa.xsql">

<fieldset><legend title="Enter name of plant in one or more of the search fields.">
QA Name Search</legend>

<div class="texts">
<p><label for="family" accesskey="4" 
 title="Example: Ulmaceae.">Family: 
<input id="family" name="family" type="text" maxlength="40" 
 tabindex="103" title="Enter name of a family [one word, can use first several letters]." value="" /></label>
</p>
<p><label for="genus"  
 title="Example: Ulmus.">Genus: 
<input id="genus" name="genus" type="text" maxlength="30" 
 tabindex="104" title="Enter name of a genus [one word, can use first several letters]." value="" /></label>
</p>
<p><label for="species" 
 title="Example: americana.">Species Epithet: 
<input id="species" name="species" type="text" maxlength="30" 
 tabindex="105" title="Enter the species epithet, or subspecies, or variety [one word]." value="" /></label>
</p>
<p><label for="common" 
 title="Example: american elm.">Common Name: 
<input id="common" name="common" type="text" maxlength="50" 
 tabindex="106" title="Enter a common name [can use more than one word]." value="" /></label>
</p>
</div>

<p class="actions">
<input id="submit" name="submit" type="submit" value="Search"
 tabindex="107" title="Perform Search." />
</p>
<p>
[ Fungus data not yet available. ]
</p>
</fieldset>

</form>
</div>

<div class="box">
<h3>vPlants funded by</h3>
<p>
Institute of Museum and Library Services - 
<a href="http://www.imls.gov">www.imls.gov</a>
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

<!--
 For current directory use, example:
<li 
 class="plant head thismenu"><a  
 href="/plants/index.html"
 title="Plant directory.">Plants</a></li>
 
 For current page, index of that directory use, example:
 <li
 class="home thismenu thispage"><span
 title="You are here: Home Page.">Home</span></li>
-->
<ul><li 
 class="search"><a tabindex="500"
 href="/search.html"
 title="Advanced Search.">Search</a></li><li 
 class="home"><a  
 href="/"
 title="Home Page.">Home</a></li><li><a 
 href="/about.html" 
 title="About vPlants and its partners.">About Us</a></li><li 
 class="plant head"><a 
 href="/plants/index.html"
 title="Plant directory.">Plants</a></li><li 
 class="fungus head"><a 
 href="/fungi/index.html"
 title="Fungus directory.">Fungi</a></li><li><a 
 href="/documents/index.html"
 title="View or download files and working documents.">Documents</a></li><li><a 
 href="/biblio.html"
 title="List of Books and other literature.">References</a></li><li><a 
 href="/links.html"
 title="Links to related web sites.">Links</a></li><li><a 
 href="/help.html" 
 title="Help and Frequently Asked Questions.">Help FAQ</a></li><li><a 
 href="/feedback.html"
 title="Please provide feedback!">Feedback</a></li><li><a 
 href="/contact.html"
 title="Contact information.">Contact Us</a></li><li><a 
 href="/sitemap.html"
 title="List of pages on this website.">Site Map</a></li><li><a 
 href="/access.html" 
 title="Accessibility features of this site." accesskey="0">Accessibility Statement</a></li></ul>

</div><!-- end of #menu --></div><!-- end of #main1 -->

</body>
</html>
</xsl:template>

<!-- Search results from the parent file: searchqa.xsql -->
<xsl:template match="SCINAMES/ROWSET">
  <xsl:choose>
    <xsl:when test="ROW">
			    <!-- Start the ordered list with first taxon -->
                <xsl:text> <br /> </xsl:text>
	  <xsl:for-each select="ROW">
        <xsl:choose>
          <xsl:when test="USDA_ACCEPTED_IND = 'Y'"><!-- Accepted Name -->

            <xsl:if test="@num != 1">
			    <!-- close previous and start next taxon in list -->
                <xsl:text> <br /> </xsl:text>
            </xsl:if>

            <h3 class="taxon">
              <xsl:apply-templates/><!-- Scientific Name -->
            </h3>
            <strong>
			  <xsl:value-of select="GROUP_ID"/>
			  <xsl:text> - </xsl:text>
              <xsl:value-of select="NAME_CD"/>
			</strong>
			<xsl:text> - </xsl:text>
            <a href="/speciesqa/species.jsp?gid={GROUP_ID}">Check QA Page</a>
            <xsl:text> | </xsl:text>
            <a href="/species/species.jsp?gid={GROUP_ID}">Check Public Page</a>
            <h4><xsl:value-of select="FAMILY_NAME"/></h4>

            <xsl:if test="COMMON_NAME">
              <div><xsl:text>Common names: </xsl:text> 
                <xsl:value-of select="COMMON_NAME"/>
              </div>
            </xsl:if>

          </xsl:when>
          <xsl:otherwise><!-- This is for synonyms -->
            <div class="syntaxon">
              <xsl:apply-templates/><!-- Scientific Name -->
            </div>
          </xsl:otherwise>
        </xsl:choose>
	  </xsl:for-each>
			    <!-- close last taxon and close list -->
                <xsl:text> <br /> </xsl:text>
    </xsl:when>

    <xsl:otherwise>
		<p>Sorry, no results were found matching your query.</p>
		<p><a href="javascript:window.history.back()">Go back</a>.</p>
    </xsl:otherwise>

  </xsl:choose>
</xsl:template>


<!-- Supply empty templates to prevent elements from displaying by default. -->
<!-- This is not necessary when xsl:apply-templates is not used. -->
<xsl:template match="FAMILY_NAME"/>

<xsl:template match="COMMON_NAME"/>

<xsl:template match="RE_STATUS"/>

<xsl:template match="NAME_CD"/>

<xsl:template match="GROUP_ID"/>

<xsl:template match="SN_SORT"/><!-- Does this sort the Scientific Names? -->

<xsl:template match="USDA_ACCEPTED_IND"/>

<xsl:template match="ACCEPTED_IND"/>

<xsl:template match="HD_COUNT"/>

</xsl:stylesheet>
