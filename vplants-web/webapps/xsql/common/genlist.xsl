<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output version="1.0" encoding="UTF-8" indent="no"/>

<xsl:template match="/">
<html>
<head>
<title>vPlants | Browse Genus List</title>
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
        <table width="450" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td><h1>Browse Genus List</h1></td>
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
<br></br><br></br><br></br>
</body>
</html>
</xsl:template>

<xsl:template match="GENERA">
      <xsl:apply-templates/>
</xsl:template>

<xsl:template match="idx">
</xsl:template>

<xsl:template match="HDR">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td align="left" class="browse">
      <xsl:apply-templates/>
    </td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
</table>
</xsl:template>

<xsl:template match="LETTER">
<xsl:choose>
  <xsl:when test=". = ../../idx">
    <span class="browseOn"><xsl:value-of select="."/>&nbsp;|&nbsp;</span>
  </xsl:when>
  <xsl:otherwise>
    <span><a href="genlist.xsql?idx={.}" class="browse"><xsl:value-of select="."/></a>&nbsp;|&nbsp;</span>
  </xsl:otherwise>
</xsl:choose>
</xsl:template>

<xsl:template match="DTL">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <th></th>
    <th align="left">Genus</th>
    <th align="left">Family</th>
      <xsl:apply-templates/>
  </table>
</xsl:template>

<xsl:template match="GENERA">
  <xsl:apply-templates/>
</xsl:template>

<xsl:template match="GENUS">
  <tr>
    <td width="1%" align="right" class="browseListText"> 
        <xsl:number value="position()"/>.
    </td>
    <td width="50%" class="browseListText">
      <a href="gentaxa.xsql?gen={GENUS}">
        <xsl:value-of select="GENUS"/>
      </a>
    </td>
    <td width="49%" class="browseListText">
      <a href="famgen.xsql?fam={FAMILY_NAME}">
        <xsl:value-of select="FAMILY_NAME"/>
      </a>
    </td>
  </tr>
</xsl:template>

</xsl:stylesheet>
