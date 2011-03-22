<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:import href="../common/FormatSciname.xsl"/>
<xsl:output version="1.0" encoding="UTF-8" indent="no"/>

<xsl:variable name="searchType">
  <xsl:choose>
    <xsl:when test="/SEARCH/TYPE = 'Advanced'">
      <xsl:text>1</xsl:text>
    </xsl:when>
    <xsl:otherwise>
      <xsl:text>0</xsl:text>
      </xsl:otherwise>
  </xsl:choose>
</xsl:variable>

<xsl:variable name="db">
<xsl:value-of select="/CONNECT/DATABASE"/>
</xsl:variable>

<xsl:variable name="lname">
<xsl:value-of select="/SEARCH/PARAMETERS/lname"/>
</xsl:variable>

<xsl:variable name="fname">
<xsl:value-of select="/SEARCH/PARAMETERS/fname"/>
</xsl:variable>

<xsl:variable name="year">
<xsl:value-of select="/SEARCH/PARAMETERS/year"/>
</xsl:variable>

<xsl:variable name="month">
<xsl:value-of select="/SEARCH/PARAMETERS/month"/>
</xsl:variable>

<xsl:variable name="day">
<xsl:value-of select="/SEARCH/PARAMETERS/day"/>
</xsl:variable>

<xsl:variable name="state">
<xsl:value-of select="/SEARCH/PARAMETERS/state"/>
</xsl:variable>

<xsl:variable name="county">
<xsl:value-of select="/SEARCH/PARAMETERS/county"/>
</xsl:variable>

<xsl:variable name="city">
<xsl:value-of select="/SEARCH/PARAMETERS/city"/>
</xsl:variable>

<xsl:variable name="twp">
<xsl:value-of select="/SEARCH/PARAMETERS/twp"/>
</xsl:variable>

<xsl:variable name="range">
<xsl:value-of select="/SEARCH/PARAMETERS/range"/>
</xsl:variable>

<xsl:variable name="section">
<xsl:value-of select="/SEARCH/PARAMETERS/section"/>
</xsl:variable>

<xsl:variable name="filter">
<xsl:value-of select="/SEARCH/PARAMETERS/filter"/>
</xsl:variable>

<xsl:variable name="infrasp">
<xsl:value-of select="/SEARCH/PARAMETERS/infrasp"/>
</xsl:variable>

<xsl:variable name="locality">
<xsl:value-of select="/SEARCH/PARAMETERS/locality"/>
</xsl:variable>

<xsl:variable name="habitat">
<xsl:value-of select="/SEARCH/PARAMETERS/habitat"/>
</xsl:variable>

<xsl:variable name="substratum">
<xsl:value-of select="/SEARCH/PARAMETERS/substratum"/>
</xsl:variable>

<xsl:template match="/">
<html>
<head>
<title>vPlants | <xsl:value-of select="SEARCH/TYPE"/> Search Results</title>
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
            <td><h1>
<xsl:value-of select="SEARCH/TYPE"/> Search Results
            </h1></td>
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

<xsl:template match="db">
</xsl:template>

<xsl:template match="lname">
</xsl:template>

<xsl:template match="fname">
</xsl:template>

<xsl:template match="year">
</xsl:template>

<xsl:template match="month">
</xsl:template>

<xsl:template match="day">
</xsl:template>

<xsl:template match="state">
</xsl:template>

<xsl:template match="county">
</xsl:template>

<xsl:template match="city">
</xsl:template>

<xsl:template match="twp">
</xsl:template>

<xsl:template match="range">
</xsl:template>

<xsl:template match="section">
</xsl:template>

<xsl:template match="filter">
</xsl:template>

<xsl:template match="infrasp">
</xsl:template>

<xsl:template match="locality">
</xsl:template>

<xsl:template match="habitat">
</xsl:template>

<xsl:template match="substratum">
</xsl:template>

<xsl:template match="FAMILY_NAME">
</xsl:template>

<xsl:template match="COMMON_NAME">
</xsl:template>

<xsl:template match="RE_STATUS">
</xsl:template>

<xsl:template match="TYPE">
</xsl:template>

<xsl:template match="SCINAMES/ROWSET">
<table width="100%" cellpadding="2" cellspacing="0" border="0">

  <xsl:choose>
    <xsl:when test="ROW"> 
    </xsl:when>
    <xsl:otherwise>
        <tr>
	  <td width="4%"></td>
          <td colspan="2">
<br></br>Sorry no results were found matching your query.<br></br>
<br></br><a href="javascript:window.history.back()">Go back</a>
          </td> 
        </tr> 
    </xsl:otherwise>
  </xsl:choose>

  <xsl:for-each select="ROW">
    <xsl:choose>
      <xsl:when test="ACCEPTED_IND = 'Y'">
        <xsl:if test="@num != 1">
        <tr>
          <td colspan="3">
            <img src="/img/spacer.gif" height="20" width="100%"></img>
          </td>
        </tr>
        </xsl:if>
        <tr>
          <td valign="top" class="specimenhead" width="4%">
            <xsl:variable name="hdcount">
	      <xsl:number count="HD_COUNT" from="SNIDX" level="any"/>
            </xsl:variable>
            <xsl:value-of select="$hdcount+1"/>.
	  </td>
          <td valign="top" class="specimenhead" colspan="2">
<xsl:choose>
  <xsl:when test='$searchType = "0"'>

	<xsl:apply-templates/>
<div class="choices">
	<a href="taxon.xsql?gid={GROUP_ID}">All Specimens.</a>
<span> | </span>
	<a href="/{$db}/species/species.jsp?gid={GROUP_ID}">Description.</a>
<span> |  </span> 
	<a href="/{$db}/gallery/index.jsp?gid={GROUP_ID}">Photo Gallery.</a>
</div>

  </xsl:when>
  <xsl:when test='$searchType = "1"'>
    <form name="frm{GROUP_ID}" 
	style="margin-bottom:0"
	method="post" 
	action="/xsql/{$db}/searchtaxon.xsql">
      <input type="hidden" name="db" value="{$db}"/>
      <input type="hidden" name="gid" value="{GROUP_ID}"/>
      <input type="hidden" name="lname" value="{$lname}"/>
      <input type="hidden" name="fname" value="{$fname}"/>
      <input type="hidden" name="year" value="{$year}"/>
      <input type="hidden" name="month" value="{$month}"/>
      <input type="hidden" name="day" value="{$day}"/>
      <input type="hidden" name="state" value="{$state}"/>
      <input type="hidden" name="county" value="{$county}"/>
      <input type="hidden" name="city" value="{$city}"/>
      <input type="hidden" name="twp" value="{$twp}"/>
      <input type="hidden" name="range" value="{$range}"/>
      <input type="hidden" name="section" value="{$section}"/>
      <input type="hidden" name="filter" value="{$filter}"/>
      <input type="hidden" name="infrasp" value="{$infrasp}"/>
      <input type="hidden" name="habitat" value="{$habitat}"/>
      <input type="hidden" name="locality" value="{$locality}"/>
      <input type="hidden" name="substratum" value="{$substratum}"/>

	<xsl:apply-templates/>
<div class="choices">
	<a href="javascript:document.frm{GROUP_ID}.submit();">Specimens matching your search.</a>
<span> | </span>
	<a href="/{$db}/species/species.jsp?gid={GROUP_ID}">Description.</a>
<span> | </span>
	<a href="/{$db}/gallery/index.jsp?gid={GROUP_ID}">Photo Gallery.</a>
</div>

    </form>
  </xsl:when>
</xsl:choose>
          </td>
        </tr>
  	<tr>
          <td></td>
          <td class="text" colspan="2">
	    Family: <xsl:value-of select="FAMILY_NAME"/>
          </td>
        </tr>
<xsl:if test="COMMON_NAME">
  	<tr>
          <td></td>
          <td class="text" colspan="2">
	    Common Name(s): <xsl:value-of select="COMMON_NAME"/>
          </td>
        </tr>
</xsl:if>
<xsl:if test="RE_STATUS">
  	<tr>
          <td></td>
          <td class="text" colspan="2">
	    Rarity: <xsl:value-of select="RE_STATUS"/>
          </td>
        </tr>
</xsl:if>
      </xsl:when>
      <xsl:otherwise>
        <tr>
         <td></td>
         <td width="5%"></td>
         <td class="text">
              <xsl:apply-templates/>
         </td>
        </tr>
      </xsl:otherwise>
    </xsl:choose>
  </xsl:for-each>
</table>
</xsl:template>

<xsl:template match="NAME_CD">
</xsl:template>

<xsl:template match="GROUP_ID">
</xsl:template>

<xsl:template match="SN_SORT">
</xsl:template>

<xsl:template match="ACCEPTED_IND">
</xsl:template>

<xsl:template match="HD_COUNT">
</xsl:template>

<xsl:template match="/CONNECT/DATABASE">
</xsl:template>

</xsl:stylesheet>
