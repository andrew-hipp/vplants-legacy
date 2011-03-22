<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template name="html_head_tags">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="Content-Language" content="en-us" />
<meta name="keywords" content="vplants, vplants.org, plant, plants, herbarium, herbaria, collections, specimens, museum, arboretum, botanic garden, natural history, ecology, distribution" />
<meta name="description" content="vPlants offers thousands of plant and fungus specimens for the Chicago Region, USA, with images and descriptions." />
<meta name="rating" content="General" />
<meta name="doc-class" content="Living Document" />
<meta name="author" content="The vPlants Project" />
<meta name="Copyright" content="Copyright (c) 2001-2005 The vPlants Project" />

<meta name="robots" content="all" />
<meta http-equiv="window-target" content="_top" />
<meta name="MSSmartTagsPreventParsing" content="true" />
<meta http-equiv="imagetoolbar" content="false" />

<link rel="Shortcut Icon" href="/favicon.ico" type="image/x-icon" />

<link rel="start" title="Home page" href="http://www.vplants.org/" />
<link rel="search" title="Search this site" href="http://www.vplants.org/search.html" />
<link rel="help" title="Access features of this site" href="http://www.vplants.org/access.html" />
<link rel="glossary" title="Plant glossary" href="http://www.vplants.org/plants/glossary/" />

 <link rel="stylesheet" href="/css/master.css" type="text/css" media="screen, projection" />
<link rel="stylesheet" href="/css/print.css"  type="text/css" media="print" />
<!-- CSS for Internet Explorer Windows browsers 7.1 and below are handled in separate file -->
<!--[if lte IE 7.1]>
 <link href="/css/iewin_lte_71.css" rel="stylesheet" type="text/css" media="screen, projection" />
<![endif]-->
 <script language="JavaScript" type="text/javascript" src="/js/basic.js">&#xa0;</script>

</xsl:template>

<!-- ==================================================== -->


<xsl:template name="html_sitehead">

<p class="access"><a href="#pagecontent" accesskey="2" title="Skip to page content.">[Skip to page content]</a></p>
<p class="access"><a href="#menu1" title="Skip to menu one.">[Skip to primary menu]</a></p>

<div id="partners"><ul><li><a 
 href="/partner_mor.html" 
 title="Read about this partner.">The Morton Arboretum</a></li><li><a 
 href="/partner_f.html" 
 title="Read about this partner.">The Field Museum</a></li><li><a 
 href="/partner_chic.html" 
 title="Read about this partner.">Chicago Botanic Garden</a></li><li><a 
 href="/partners_other.html" 
 title="Read about other partners.">Additional Partners</a></li></ul></div>

<div id="logo"><a 
 href="/"
 title="vPlants.org Home."><img 
 src="/img/logo2h_f.gif"  
 alt="vPlants.org Home." /></a></div>

 <p id="tagline"><strong>vPlants.org</strong> 
  <a href="/about_herbarium.html" 
  title="What is a Herbarium?">A Virtual Herbarium of the Chicago Region</a></p>

</xsl:template>

<!-- ==================================================== -->

 <xsl:template name="html_sitehead_form">

  
 </xsl:template>
<!-- ==================================================== -->

<xsl:template name="html_sitemenu">

<div id="sitemenu"><a id="menu1" name="menu1"></a>
<!--
 For current page, index of that directory use, example:
	<li 
	class="plant diversity"><span
	title="You are here: Plant diversity.">Diversity</span></li>

-->

<h5 class="access">Primary Menu <a href="#menu2" title="Skip this menu.">[Skip]</a></h5>

<ul class="fungus"><li><a 
class="start" href="/fungi/" 
title="Fungus start page.">Fungi</a></li><li><a 
class="guide" href="/fungi/guide/" 
title="Fungus guide.">Guide</a></li><li><a 
class="topics" href="/fungi/topics/" 
title="All about fungi of the region.">Topics</a></li><li><a 
class="glossary" href="/fungi/glossary/" 
title="Definitions of terms for fungi.">Glossary</a></li><li><a 
class="documents" href="/fungi/documents/" 
title="View or download documents.">Documents</a></li><li><a 
class="resources" href="/fungi/resources/" 
title="Web links and book list.">Resources</a></li></ul>

<ul><li><a class="search" accesskey="5" href="/search.html" title="Advanced search for plants or fungi.">Search</a></li></ul>

<ul class="plant"><li><a 
class="start" href="/plants/" 
title="Plants start page.">Plants</a></li></ul>

</div><!-- end of #sitemenu -->

</xsl:template>

<!-- ==================================================== -->

<xsl:template name="html_footer">

<div id="sitefoot"><a id="menu4" name="menu4"></a>
<h5 class="access">Footer Menu</h5>
<ul id="footmenu"><li><a 
 href="/" accesskey="1" 
 title="Home Page.">Home</a></li><li><a 
 href="/help/" accesskey="6" 
 title="Help and User Guide.">Help Guide</a></li><li><a 
 href="/sitemap.html" accesskey="7" 
 title="Table of contents for this web site.">Site Map</a></li><li><a 
 href="/contact.html" accesskey="8" 
 title="Contact information.">Contact Us</a></li><li><a 
 href="/feedback.html" accesskey="9" 
 title="Please provide feedback!">Feedback</a></li><li><a 
 href="/access.html" accesskey="0" 
 title="Accessibility features of this site.">Accessibility Statement</a></li></ul>

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
<xsl:text disable-output-escaping="yes">Copyright &amp;copy; 2001 - </xsl:text>
<script type="text/javascript" language="JavaScript">
document.write(thisYear())
</script>
 The vPlants Project, All Rights Reserved.
</p>
<p>
<a 
 href="/partner_mor.html" 
 title="Read about this partner.">The Morton Arboretum</a>, 
<a 
 href="/partner_f.html" 
 title="Read about this partner.">The Field Museum</a>, 
<a 
 href="/partner_chic.html" 
 title="Read about this partner.">Chicago Botanic Garden</a>, 
<a 
 href="/partners_other.html" 
 title="Read about other partners.">Additional Partners</a>
</p>

</div><!-- End #sitefoot -->


<p class="access"><a href="#pagetop" accesskey="3" title="Back to top of page.">[Back to top of page]</a></p>

</xsl:template>

<!-- ==================================================== -->

</xsl:stylesheet>
