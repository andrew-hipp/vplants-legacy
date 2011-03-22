<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
 xmlns="http://www.w3.org/1999/xhtml">
<xsl:import href="html_templates_f4.xsl"/>
 <xsl:output 
  method="xhtml"
  omit-xml-declaration="yes"
  media-type="text/html"
  doctype-public="-//W3C//DTD XHTML 1.0 Strict//EN" 
  doctype-system="DTD/xhtml1-strict.dtd"
  cdata-section-elements="script style"
  indent="yes"
  encoding="utf-8"/>

 <xsl:template match="TAXON">
<!-- PARAMs must come before VARIABLES or else the PARAMs are not defined -->
<xsl:param name="genName" select="GENUS"/>
<xsl:param name="guideFile" select="concat('../../../htdocs/fungi/guide/xml/', GENUS, '.xml')"/>


<!-- the following concat will generate the correct path -->
<!-- example: ../../fungi/species/xml/AGAR.xml  -->
<xsl:param name="speciesFile" select="concat('../../fungi/species/xml/', NAME_CD, '.xml')"/>
<!-- The following retrieves the contents of the taxon description xml -->
<xsl:variable name="speciesXml" select="document($speciesFile)"/>

<xsl:variable name="guideXml" select="document($guideFile)"/>
<xsl:variable name="generaXml" select="document('../../../htdocs/fungi/guide/xml/genera.xml')"/>

<!-- Get lookup information from related xml file. -->
<xsl:variable name="morphID" 
 select="$generaXml//gengroup[genID=$genName]/morph"/>
<xsl:variable name="morphIDText" 
 select="$generaXml//gengroup[genID=$genName]/morphText"/>


 <html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">

<head>
<title>vPlants - <xsl:value-of select="GENUS"/> Guide</title>
<xsl:call-template name="html_head_tags"/>
</head>

<body id="vplants-org" class="fungi guide" ><div id="bodywrap">
<!-- Body ID "CSS signature" allows the user site-wide styling of vPlants pages. 
Body CLASS allows author styling of that page. -->

<div id="sitehead">
<a id="pagetop" name="pagetop"></a>

<div id="breadcrumbs">
You are here:
<a href="/" title="Home Page.">Home</a> &#187;
<a href="/fungi/guide/" title="Fungi.">Fungus Guide</a> &#187;
<a href="/xsql/fungi/keymorph.xsql?morph={$morphID}" 
title="Go to guide for this group."><xsl:value-of select="$morphIDText"/></a> &#187;
<a href="/xsql/fungi/keyfam.xsql?fam={FAMILY_NAME}" 
title="Go to guide for this family."><xsl:value-of select="FAMILY_NAME"/></a> &#187;
 <strong><xsl:value-of select="GENUS"/></strong>
</div>

<xsl:call-template name="html_sitehead"/>

</div><!-- End of #sitehead -->
<div id="wrapper1"><!-- for navigation and content -->

<!-- PAGE CONTENT STARTS -->
<div id="content"><!-- start of primary content -->
<a id="pagecontent" name="pagecontent"></a>

<h1>Guide to 
 <span class="taxon">
  <em class="genus"><xsl:value-of select="GENUS"/></em>
   <xsl:text> </xsl:text>
  <span class="author"><xsl:value-of select="AUTHOR"/></span>
 </span></h1>


<!-- show variable contents 

<xsl:apply-templates/>

<xsl:value-of select="$speciesXml"/>
<xsl:value-of select="$guideXml"/>
 -->

 <!-- Use copy-of because content includes html elements such as <p> -->
 
 <div id="gentext">
 <xsl:copy-of select="$guideXml//gentext"/>
</div>
 
 
 <xsl:copy-of select="$guideXml//simgens"/>
 
<dl>
 <dt>Habitat and ecology:</dt>
 <dd><xsl:value-of select="$speciesXml//habitatEcology"/></dd>
 <dt>Fruiting:</dt>
 <dd><xsl:value-of select="$speciesXml//fruiting"/></dd>
 
 <dt>Similar Species:</dt>
 <dd><xsl:value-of select="$speciesXml//similarSpecies/comments" 
  disable-output-escaping="yes" /></dd>
 
</dl>

</div><!-- end of #content -->

<xsl:call-template name="html_sitemenu"/>

<div id="pagemenu"><a id="menu2" name="menu2"></a>
<!-- each of the following either is a link or has
  <li class="thispage"><span 
  title="You are here: page title.">page title</span></li>   -->
<h5 class="access">Secondary Menu <a href="#menu4" title="Skip this menu.">[Skip]</a></h5>
<ul id="pageset1"><li><a href="/fungi/guide/" title="Fungi.">Fungus Guide</a></li><li>
<a href="/xsql/fungi/keymorph.xsql?morph={$morphID}" 
 title="Go to guide for this group."><xsl:value-of select="$generaXml//gengroup[genID=$genName]/morphText"/></a></li><li>
<a href="/xsql/fungi/keyfam.xsql?fam={FAMILY_NAME}" 
title="Go to guide for this family."><xsl:value-of select="FAMILY_NAME"/></a></li><li class="thispage"><span 
  title="You are here: {GENUS} Guide."><xsl:value-of select="GENUS"/></span></li></ul>

<span class="filler">&#xa0;</span>

</div><!-- End of #pagemenu -->

</div><!-- end of #wrapper1 -->

<xsl:call-template name="html_footer"/>

</div><!-- End of #bodywrap -->
</body>
</html>

</xsl:template>



<xsl:template match="gen"/>


  



</xsl:stylesheet>