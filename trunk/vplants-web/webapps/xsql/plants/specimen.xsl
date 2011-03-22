<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:import href="../common/FormatSciname.xsl"/>
<xsl:output version="1.0" encoding="UTF-8" indent="no"/>
<xsl:template match="/">
<html>
<head>
<title>vPlants | Specimen Detail</title>

<link rel="stylesheet" type="text/css" media="screen" href="/css/vstyles_low.css"/>
<link rel="stylesheet" type="text/css" media="screen" href="/css/screen.css"/>
<script language="JavaScript" src="/js/scripts.js" type="text/javascript"></script>
</head>

<body background="/img/bg.gif" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<script language="JavaScript" src="/js/menu_array.js" type="text/javascript"></script>
<script language="JavaScript" src="/js/mmenu.js" type="text/javascript"></script>

<table width="750" border="0" cellspacing="0" cellpadding="0">
  <tr>
<td width="490" class="bgmdgr"><img src="/img/logo.gif" width="240" height="60"/></td>
    <td width="260" id="top">
      <table background="/img/spacer.gif" width="260" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="240" align="right">
      <a href="http://www.mortonarb.org/" class="creditlink">The Morton Arboretum</a><br/>
      <a href="http://www.fmnh.org/" class="creditlink">The Field Museum</a><br/>
      <a href="http://www.chicagobotanic.org/" class="creditlink">Chicago Botanic Garden</a><br/>
      <a href="http://www.imls.gov/" class="creditlink">Funded by IMLS</a><br/>
        </td>
        <td width="20"><img src="/img/spacer.gif" width="20" height="1" alt=""/></td>
      </tr>
    </table>
    </td>
  </tr>
</table>

<table width="750" border="0" cellpadding="0" cellspacing="0" class="bgdkgr">
  <tr>
    <td width="90"><img src="/img/spacer.gif" width="90" height="8" alt=""/></td>
    <td width="400"><img src="/img/herb.gif" width="250" height="18" alt="A Virtual Herbarium of the Chicago Region"/></td>
<td width="190" align="right" class="topnav">
<a href="mailto:ahipp@mortonarb.org" class="topnav">Contact Us</a>
</td>
<!--
    <td width="260"><table width="260" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="20" class="topnav"><img src="/img/spacer.gif" width="20" height="1" alt=""/></td>
            <td width="240" class="topnav"><a href="#" class="topnav">Contacts</a>
              | <a href="#" class="topnav">Site Map </a> | <a href="#" class="topnav">Other
              Links</a></td>
          </tr>
        </table></td>
-->
  </tr>
</table>

<table width="720" height="350" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td width="90" valign="top" class="bgdkgr"><img src="/img/spacer.gif" width="90" height="1" alt=""/></td>
      <td width="20" valign="top"><img src="/img/spacer.gif" width="20" height="1" alt=""/></td>
      <td width="610" valign="top">
        <table width="800" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td><h1>Specimen Detail</h1></td>
          </tr>
          <tr>
            <td valign="top">

<xsl:apply-templates/>

            </td>
          </tr>
        </table>
      </td>
    </tr>
<!--
    <tr>
      <td valign="top" class="bgdkgr">&nbsp;</td>
      <td valign="top">&nbsp;</td>
      <td align="center" class="footer">
        <a href="index.html" class="footlink">Home</a> |
        <a href="about_partners.html" class="footlink">About Us</a> |
        <a href="whatis.html" class="footlink">What's An Herbarium</a> |
        <a href="browse_genus.html" class="footlink">Browse Plant List</a> |
        <a href="search.html" class="footlink">Search</a>
      </td>
    </tr>
-->
  </table>
<br></br>
<br></br>
<br></br>
</body>
</html>
</xsl:template>

<xsl:template match="SPM">
<xsl:choose>
<xsl:when test="TEXT/SCINAMES/EXTRAS/FAMILY">
  <table border="0" width="80%">
    <tr>
      <xsl:apply-templates/>
    </tr>
  </table>
</xsl:when>
<xsl:otherwise>
<div align="left">
<BR></BR>
Sorry no results were found matching your query.
<BR></BR>
<BR></BR>
<a href="javascript:window.history.back()">Go back</a>
</div>
</xsl:otherwise>
</xsl:choose>
</xsl:template>

<xsl:template match="TEXT">
<td valign="top" align="left">
<table border="0" width="100%" cellpadding="0" cellspacing="0">
<xsl:apply-templates/>
</table>
</td>
</xsl:template>

<xsl:template match="IMAGES">
<xsl:if test="PREVIEW/URI">
<td width="324" valign="top" align="center">
<xsl:apply-templates/>
</td>
</xsl:if>
</xsl:template>

<xsl:template match="PREVIEW">
<xsl:if test="URI">
<img alt="Preview Image: Full size images available on bottom left-hand side." border="1" src="{URI}"></img>
</xsl:if>
</xsl:template>

<xsl:template match="GALLERY">
<xsl:if test="IMAGE">
<tr>
 <td>
<table width="100%" border="0">
<tr>
<td colspan="3" class="text">
<strong>Full size images:</strong>
</td>
</tr>
<tr>
 <td>
 </td>
 <td class="text">
<strong>Type</strong>
 </td>
 <td class="text">
<strong>Estimated Download Time (56K Modem)</strong>
 </td>
</tr>
<xsl:apply-templates/>
</table>
 </td>
</tr>
</xsl:if>
</xsl:template>

<xsl:template match="IMAGE">
<tr>
  <td width="4%"></td>
  <td>
    <a href="{URI}">(<xsl:value-of select="FORMAT"/>)</a><br></br>
  </td>

  <xsl:choose>
    <xsl:when test="FORMAT = 'MrSID'">
    <td class="text">
5-6 minutes [&lt;2MB]
    </td>
    </xsl:when>
    <xsl:when test="FORMAT = 'JPG'">
    <td class="text">
1-2 minutes [&lt;500KB]
    </td>
    </xsl:when>
  </xsl:choose>

</tr>

<xsl:if test="FORMAT = 'MrSID'">
<tr>
  <td></td>
  <td align="center" colspan="2" class="text">
        <i><strong>***
            <a href="http://www.lizardtech.com/download/?x=2&amp;p=15&amp;o=1">
MrSID Browser Plugin Required
            </a>
        </strong></i>
  </td>
</tr>
</xsl:if>

</xsl:template>

<xsl:template match="SCINAMES">
<xsl:apply-templates/>
</xsl:template>

<xsl:template match="ACCEPTED">
<tr>
  <td height="0" class="bgmdgr"><img src="/img/spacer.gif" height="1" alt=""/></td>
</tr>
<tr>
  <td><img src="/img/spacer.gif" width="1" height="5" alt=""/></td>
</tr>
<tr height="40">
 <td valign="top" class="smtxt">
<u>vPlants accepted name:</u><br />
<span class="specimenhead">
<xsl:apply-templates/>
</span>
 </td>
</tr>
</xsl:template>

<xsl:template match="STORED">
<tr height="40">
 <td valign="top" class="smtxt">
<u>Stored at <xsl:value-of select="HERB"/> as:</u><br />
<span class="specimenhead">
<xsl:apply-templates/>
</span>
 </td>
</tr>
<tr>
  <td height="0" class="bgmdgr"><img src="/img/spacer.gif" height="1" alt=""/></td>
</tr>
<tr>
  <td><img src="/img/spacer.gif" width="1" height="5" alt=""/></td>
</tr>
</xsl:template>

<xsl:template match="EXTRAS">
<tr>
 <td class="text">
<strong>Family:</strong>&nbsp;<xsl:value-of select="FAMILY"/><br />
 </td>
</tr>
<tr>
 <td class="text">
<strong>Common Name(s):</strong>&nbsp;<xsl:value-of select="COMMON_NAME"/><br />
 </td>
</tr>
<xsl:if test="RE_STATUS">
<tr>
 <td class="text">
<strong>Rarity:</strong>&nbsp;<xsl:value-of select="RE_STATUS"/><br />
 </td>
</tr>
</xsl:if>
<xsl:if test="INVASIVE">
<tr>
 <td class="text">
<strong>Invasive Plant.</strong><br />
 </td>
</tr>
</xsl:if>
<tr>
  <td><img src="/img/spacer.gif" height="10" alt=""/></td>
</tr>
</xsl:template>

<xsl:template match="HERB">
</xsl:template>

<xsl:template match="FAMILY">
</xsl:template>

<xsl:template match="DTL">
<tr><td width="100%"><img src="line.jpg" height="1" width="100%"/></td></tr>
 <tr>
  <td class="text">
 <xsl:if test="STATE">
  <strong><xsl:value-of select="STATE"/></strong><xsl:if test="COUNTY">: <xsl:value-of select="COUNTY"/> County</xsl:if>
 </xsl:if>
  </td>
 </tr>
 <tr>
  <td class="text">
 <xsl:if test="CITY">
 <strong>City:</strong> <xsl:value-of select="CITY"/>
 </xsl:if>
  </td>
 </tr>
 <tr>
  <td class="text">
 <xsl:if test="TOWNSHIP">
 <strong>Township:</strong> <xsl:value-of select="TOWNSHIP"/>
 </xsl:if>
  </td>
 </tr>
 <tr>
  <td class="text">
 <xsl:if test="LOCALITY">
  <xsl:value-of select="LOCALITY"/>
 </xsl:if>
  </td>
 </tr>
 <tr>
  <td class="text">
 <xsl:if test="TRS/TRS_ROW">
   <xsl:apply-templates select="TRS"/>
 </xsl:if>
  </td>
 </tr>
 <tr>
  <td class="text">
 <xsl:if test="GPS/GPS_ROW">
   <xsl:apply-templates select="GPS"/>
 </xsl:if>
  </td>
 </tr>
<tr>
 <td class="text">
<xsl:if test="HABITAT">
<strong>Habitat:</strong> <xsl:value-of select="HABITAT"/>
</xsl:if>
 </td>
</tr>
<tr>
  <td height="0" class="bgmdgr"><img src="/img/spacer.gif" height="1" alt=""/></td>
</tr>
<tr>
  <td><img src="/img/spacer.gif" width="1" height="5" alt=""/></td>
</tr>
<tr>
 <td class="text">
<xsl:if test="COLLS/COLLS_ROW">
<strong>Collected by: </strong>
  <xsl:apply-templates select="COLLS"/>
</xsl:if>
 </td>
</tr>
<tr>
 <td class="text">
<xsl:if test="COLL_NBR">
<strong>Collector #: </strong>
  <xsl:value-of select="COLL_NBR"/>
</xsl:if>
 </td>
</tr>
<tr>
 <td class="text">
<xsl:if test="FMT_COLL_DATE">
<strong>Collection date: </strong>
  <xsl:value-of select="FMT_COLL_DATE"/>
</xsl:if>
 </td>
</tr>
<tr><td><br/></td></tr>
<tr>
 <td class="text">
<strong>Specimen at: </strong>
  <xsl:value-of select="HERB_TEXT"/>
 </td>
</tr>
<tr>
 <td class="text">
<strong>Accession #: </strong>
  <xsl:value-of select="SPM_ID"/>
 </td>
</tr>
<tr><td width="100%"><img src="line.jpg" height="1" width="100%"/></td></tr>
<xsl:if test="HOMEPAGE">
<tr>
 <td class="text">
   <strong><a href="{HOMEPAGE}">Specimen homepage</a></strong>
 </td>
</tr>
</xsl:if>
<tr>
  <td><img src="/img/spacer.gif" width="1" height="5" alt=""/></td>
</tr>
<tr>
  <td height="0" class="bgmdgr"><img src="/img/spacer.gif" height="1" alt=""/></td>
</tr>
<tr>
  <td><img src="/img/spacer.gif" width="1" height="5" alt=""/></td>
</tr>
<xsl:if test="MORE_DATA/MORE_DATA_ROW">
  <xsl:apply-templates select="MORE_DATA"/>
</xsl:if>
</xsl:template>

<xsl:template match="COLLS">
  <xsl:apply-templates/>
</xsl:template>

<xsl:template match="GPS_ROW">
<xsl:if test="LAT_DD">
 Lat: <xsl:value-of select="LAT_DD"/>&#176;<xsl:value-of select="LAT_DIR"/>,
</xsl:if>
<xsl:if test="LONG_DD">
 Long: <xsl:value-of select="LONG_DD"/>&#176;<xsl:value-of select="LONG_DIR"/>
</xsl:if>
</xsl:template>

<xsl:template match="TRS_ROW">
<xsl:if test="TWP">
 T<xsl:value-of select="TWP"/><xsl:value-of select="TWP_DIR"/><xsl:if test="RNG">,</xsl:if>
</xsl:if>
<xsl:if test="RNG">
 R<xsl:value-of select="RNG"/><xsl:value-of select="RNG_DIR"/><xsl:if test="SECT">,</xsl:if>
</xsl:if>
<xsl:if test="SECT">
 Sec. <xsl:value-of select="SECT"/><xsl:if test="SECT_CMTS"> - <xsl:value-of select="SECT_CMTS"/></xsl:if>
</xsl:if>
</xsl:template>

<xsl:template match="COLLS_ROW">
  <xsl:if test="F_NAME">
   <xsl:value-of select="F_NAME"/>.
  </xsl:if>
  <xsl:if test="M_NAME">
   <xsl:value-of select="M_NAME"/>.
  </xsl:if>
  <xsl:if test="L_NAME">
   <xsl:value-of select="L_NAME"/>
  </xsl:if>,
</xsl:template>

<xsl:template match="COLLS_ROW[last()]">
  <xsl:if test="F_NAME">
   <xsl:value-of select="F_NAME"/>.
  </xsl:if>
  <xsl:if test="M_NAME">
   <xsl:value-of select="M_NAME"/>.
  </xsl:if>
  <xsl:if test="L_NAME">
   <xsl:value-of select="L_NAME"/>
  </xsl:if>
</xsl:template>

<xsl:template match="MORE_DATA_ROW">
<tr>
 <td class="text">
   <strong>Additional data: </strong><br></br>
<xsl:if test="MORE_LOC = 'H'">
&nbsp;&nbsp;Locality data on specimen homepage<br></br>
</xsl:if>
<xsl:if test="MORE_LOC = 'S'">
&nbsp;&nbsp;Locality data on herbarium sheet<br></br>
</xsl:if>
<xsl:if test="MORE_HAB = 'H'">
&nbsp;&nbsp;Habitat data on specimen homepage<br></br>
</xsl:if>
<xsl:if test="MORE_HAB = 'S'">
&nbsp;&nbsp;Habitat data on herbarium sheet<br></br>
</xsl:if>
<xsl:if test="MORE_DESC = 'H'">
&nbsp;&nbsp;Descriptive data on specimen homepage<br></br>
</xsl:if>
<xsl:if test="MORE_DESC = 'S'">
&nbsp;&nbsp;Descriptive data on herbarium sheet<br></br>
</xsl:if>
<xsl:if test="MORE_ASSOC = 'H'">
&nbsp;&nbsp;Associations on specimen homepage<br></br>
</xsl:if>
<xsl:if test="MORE_ASSOC = 'S'">
&nbsp;&nbsp;Associations on herbarium sheet<br></br>
</xsl:if>
<xsl:if test="MORE_ANNOT = 'H'">
&nbsp;&nbsp;Annotations on specimen homepage<br></br>
</xsl:if>
<xsl:if test="MORE_ANNOT = 'S'">
&nbsp;&nbsp;Annotations on herbarium sheet<br></br>
</xsl:if>
 </td>
</tr>
</xsl:template>

</xsl:stylesheet>
