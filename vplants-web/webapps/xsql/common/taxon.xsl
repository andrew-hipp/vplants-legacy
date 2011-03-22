<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:import href="FormatSciname.xsl"/>
<xsl:output version="1.0" encoding="UTF-8" indent="no"/>
<xsl:template match="/">
<html>
<head>
<title>vPlants | Taxon Summary</title>
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
        <table width="600" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td><h1>Taxon Summary</h1></td>
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

<xsl:template match="SCINAME">
  <center>
  <table width="100%" cellpadding="2" cellspacing="0" border="0">
    <tr>
      <th align="left">
      <h2>
      <xsl:apply-templates/>
      </h2>
      </th>
    </tr>
  </table>
  </center>
</xsl:template>

<xsl:template match="SCINAME_DTL">
  <center>
  <table width="100%" cellpadding="2" cellspacing="0" border="0">
    <tr>
      <th align="left">
      <xsl:apply-templates/>
      </th>
    </tr>
  </table>
  </center>
</xsl:template>

<xsl:template match="FAMILY">
<tr><td class="text">
&nbsp;Family: <xsl:value-of select="."/>
</td></tr>
</xsl:template>

<xsl:template match="COMMON_NAME">
<tr><td class="text">
&nbsp;Common Name(s): <xsl:value-of select="."/>
</td></tr>
</xsl:template>

<xsl:template match="RE_STATUS">
<tr><td class="text">
&nbsp;Rarity: <xsl:value-of select="."/>
</td></tr>
</xsl:template>
<xsl:template match="INVASIVE">
<tr><td class="text">
&nbsp;Invasive Plant.
</td></tr>
</xsl:template>

<xsl:template match="DTLS">
<br></br>
<left>
<table border="0" cellspacing="4" cellpadding="0" width="100%">
<tr>
<th></th>
<th align="center" class="text">Images?</th>
<th align="right" class="text">State</th>
<th align="right" class="text">County</th>
<th align="right" class="text">Collection Date</th>
<th align="right" class="text">Primary Collector</th>
<th align="right" class="text">Herbarium</th>
</tr>
<tr>
<td height="0" colspan="7" class="bgmdgr"><img src="/img/spacer.gif" width="30" height="1" alt=""/></td>
</tr>
    <xsl:apply-templates/>
</table>
</left>
</xsl:template>

<xsl:template match="DTL">
<tr>
 <td align="right" height="30">
  <a href="specimen.xsql?spmid={SPM_ID}&amp;herb={HERB_CD}">
     <xsl:value-of select="position()"/>.
  </a>
 </td>
 <td align="center">
 <xsl:if test="IMAGE = 'Y'">
  <a href="specimen.xsql?spmid={SPM_ID}&amp;herb={HERB_CD}">
<img src="../common/cam.gif" border="0" title="Click for Images!"></img>
  </a>
 </xsl:if>
 </td>
 <td align="right">
  <a href="specimen.xsql?spmid={SPM_ID}&amp;herb={HERB_CD}">
   <xsl:value-of select="STATE"/>
  </a>
 </td>
 <td align="right">
  <a href="specimen.xsql?spmid={SPM_ID}&amp;herb={HERB_CD}">
   <xsl:value-of select="COUNTY"/>
  </a>
 </td>
 <td align="right">
  <a href="specimen.xsql?spmid={SPM_ID}&amp;herb={HERB_CD}">
   <xsl:value-of select="FMT_COLL_DATE"/>
  </a>
 </td>
 <td align="right">
  <a href="specimen.xsql?spmid={SPM_ID}&amp;herb={HERB_CD}">
   <xsl:if test="F_NAME">
     <xsl:value-of select="F_NAME"/><xsl:text> </xsl:text>
   </xsl:if>
   <xsl:if test="M_NAME">
     <xsl:value-of select="M_NAME"/><xsl:text> </xsl:text>
   </xsl:if>
   <xsl:if test="L_NAME">
     <xsl:value-of select="L_NAME"/>
   </xsl:if>
  </a>
 </td>
 <td align="right">
  <a href="specimen.xsql?spmid={SPM_ID}&amp;herb={HERB_CD}">
   <xsl:value-of select="HERB"/>
  </a>
 </td>
</tr>
<tr>
<td height="0" colspan="7" class="bgmdgr"><img src="/img/spacer.gif" width="30" height="1" alt=""/></td>
</tr>
</xsl:template>

</xsl:stylesheet>
