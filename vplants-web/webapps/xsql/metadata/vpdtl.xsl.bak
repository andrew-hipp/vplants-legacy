<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="xml"/>
<xsl:template match="/VPDTL">
<spm xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="http://www.vplants.org/metadata/vpspm.xsd">
<xsl:apply-templates/>
</spm>
</xsl:template>

<xsl:template match="ASSOC_IND">
 <xsl:if test=". = 'Y'">
   <assoc data="H"/>
 </xsl:if>
</xsl:template>

<xsl:template match="SOURCE_IND">
 <xsl:if test=". = 'Y'">
   <desc data="H"/>
 </xsl:if>
</xsl:template>

<xsl:template match="ANNOT_IND">
 <xsl:if test=". = 'Y'">
   <annot data="H"/>
 </xsl:if>
</xsl:template>

<xsl:template match="SPMPG">
 <homepg>
  <xsl:apply-templates/>
 </homepg>
</xsl:template>

<xsl:template match="IMAGES">
  <xsl:apply-templates/>
</xsl:template>

<xsl:template match="IMAGE">
  <image type="{TYPE}">
  <xsl:apply-templates/>
  </image>
</xsl:template>

<xsl:template match="URI">
<xsl:value-of select="."/>
</xsl:template>

<xsl:template match="TYPE">
</xsl:template>

<xsl:template match="HERB_NBR">
<link>
<xsl:text>
http://redwood.mortonarb.org/xsql/reports/acc/accdtl.xsql?acc=</xsl:text>
<xsl:value-of select="."/>
</link>
</xsl:template>

<xsl:template match="TYPE_SPEC_IND">
<xsl:if test=". = 'Y'">
 <typespm/>
</xsl:if>
</xsl:template>

<xsl:template match="SITE">
<xsl:choose>
 <xsl:when test="SITE_SENSITIVE_IND = 'N'">
  <xsl:apply-templates/>
 </xsl:when>
</xsl:choose>
</xsl:template>

<xsl:template match="SITE_DTL">
  <xsl:apply-templates/>
</xsl:template>

<xsl:template match="SITE_GPS">
<xsl:if test="LAT_DD">
 <sitegps>
  <lat>
   <latdir>
    <xsl:value-of select="LAT_DIR"/>
   </latdir>
   <latdd>
    <xsl:value-of select="LAT_DD"/>
   </latdd>
  </lat>
  <long>
   <longdir>
    <xsl:value-of select="LONG_DIR"/>
   </longdir>
   <longdd>
    <xsl:value-of select="LONG_DD"/>
   </longdd>
  </long>
 </sitegps>
</xsl:if>
</xsl:template>

<xsl:template match="SITE_TRS">
 <sitesurvey>
<xsl:if test="TOWNSHIP">
  <twp>
    <twpnum>
     <xsl:value-of select="TOWNSHIP"/>
    </twpnum>
    <twpdir>
     <xsl:value-of select="TOWNSHIP_BEARING"/>
    </twpdir>
  </twp>
</xsl:if>
<xsl:if test="RANGE">
  <rng>
    <rngnum>
   <xsl:value-of select="RANGE"/>
    </rngnum>
    <rngdir>
   <xsl:value-of select="RANGE_BEARING"/>
    </rngdir>
  </rng>
</xsl:if>
<xsl:if test="SECTION">
  <sec>
    <secnum>
   <xsl:value-of select="SECTION"/>
    </secnum>
    <secdtl>
   <xsl:value-of select="SECTION_COMMENTS"/>
    </secdtl>
  </sec>
</xsl:if>
 </sitesurvey>
</xsl:template>

<xsl:template match="SITE_GEO_ROW">
<xsl:choose>
 <xsl:when test="GEO_CD = 'ST'">
    <state>
      <xsl:value-of select="GEO_NAME"/>
    </state>
 </xsl:when>
 <xsl:when test="GEO_CD = 'CO'">
    <county>
      <xsl:value-of select="GEO_NAME"/>
    </county>
 </xsl:when>
</xsl:choose>
</xsl:template>

<xsl:template match="SITE_SENSITIVE_IND">
</xsl:template>

<xsl:template match="SITE_GEO">
<xsl:if test="SITE_GEO_ROW[1]">
<sitegeo>
  <xsl:apply-templates/>
</sitegeo>
</xsl:if>
</xsl:template>

<xsl:template match="LOCALITY">
<locality>
  <xsl:value-of select="."/>
</locality>
</xsl:template>

<xsl:template match="COLL_ACC_NBR">
<collnbr>
  <xsl:value-of select="."/>
</collnbr>
</xsl:template>

<xsl:template match="COLLECTORS">
<collectors>
  <xsl:apply-templates/>
</collectors>
</xsl:template>

<xsl:template match="COLL">
<xsl:choose>
 <xsl:when test="PRIMARY_IND = 'Y'">
    <pcoll>
      <xsl:apply-templates/>
    </pcoll>
 </xsl:when>
 <xsl:otherwise>
    <scoll>
      <xsl:apply-templates/>
    </scoll>
 </xsl:otherwise>
</xsl:choose>
</xsl:template>

<xsl:template match="PRIMARY_IND">
</xsl:template>

<xsl:template match="MIDDLE_NAME">
<mname>
  <xsl:value-of select="."/>
</mname>
</xsl:template>

<xsl:template match="FIRST_NAME">
<fname>
  <xsl:value-of select="."/>
</fname>
</xsl:template>

<xsl:template match="LAST_NAME">
<lname>
  <xsl:value-of select="."/>
</lname>
</xsl:template>

<xsl:template match="COLL_DATE">
<xsl:if test="YEAR">
<colldate>
  <xsl:apply-templates/>
</colldate>
</xsl:if>
</xsl:template>

<xsl:template match="CRDATE">
<crdate>
  <xsl:apply-templates/>
</crdate>
</xsl:template>

<xsl:template match="MONTH">
<month><xsl:value-of select="."/></month>
</xsl:template>

<xsl:template match="DAY">
<day><xsl:value-of select="."/></day>
</xsl:template>

<xsl:template match="YEAR">
<year><xsl:value-of select="."/></year>
</xsl:template>

</xsl:stylesheet>
