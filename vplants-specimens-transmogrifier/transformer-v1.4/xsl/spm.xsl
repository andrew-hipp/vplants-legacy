<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
 <xsl:output method="xml" encoding="UTF-8"/>
 <xsl:template match="/SPM/NAME_CD">
 </xsl:template>
 <xsl:template match="/SPM/SPM_HDR">
 </xsl:template>
 <xsl:template match="/SPM/SPM_DTL">
<spm xsi:noNamespaceSchemaLocation="http://www.vplants.org/metadata/vpspm.xsd" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
<xsl:if test="COLL_YEAR != ''">
  <colldate>
<xsl:if test="COLL_MONTH != ''">
    <month>
      <xsl:value-of select="COLL_MONTH"/>
    </month>
</xsl:if>
<xsl:if test="COLL_DAY != ''">
    <day>
      <xsl:value-of select="COLL_DAY"/>
    </day>
</xsl:if>
    <year>
      <xsl:value-of select="COLL_YEAR"/>
    </year>
  </colldate>
</xsl:if>

<xsl:if test="C1_LNAME != ''">
<collectors>

  <pcoll>
<xsl:if test="C1_FNAME != ''">
    <fname>
      <xsl:value-of select="C1_FNAME"/>
    </fname>
</xsl:if>
<xsl:if test="C1_MNAME != ''">
    <mname>
      <xsl:value-of select="C1_MNAME"/>
    </mname>
</xsl:if>
    <lname>
      <xsl:value-of select="C1_LNAME"/>
    </lname>
  </pcoll>

<xsl:if test="C2_LNAME != ''">
  <scoll>
<xsl:if test="C2_FNAME != ''">
    <fname>
      <xsl:value-of select="C2_FNAME"/>
    </fname>
</xsl:if>
<xsl:if test="C2_MNAME != ''">
    <mname>
      <xsl:value-of select="C2_MNAME"/>
    </mname>
</xsl:if>
    <lname>
      <xsl:value-of select="C2_LNAME"/>
    </lname>
  </scoll>
</xsl:if>

<xsl:if test="C3_LNAME != ''">
  <scoll>
<xsl:if test="C3_FNAME != ''">
    <fname>
      <xsl:value-of select="C3_FNAME"/>
    </fname>
</xsl:if>
<xsl:if test="C3_MNAME != ''">
    <mname>
      <xsl:value-of select="C3_MNAME"/>
    </mname>
</xsl:if>
    <lname>
      <xsl:value-of select="C3_LNAME"/>
    </lname>
  </scoll>
</xsl:if>

<xsl:if test="C4_LNAME != ''">
  <scoll>
<xsl:if test="C4_FNAME != ''">
    <fname>
      <xsl:value-of select="C4_FNAME"/>
    </fname>
</xsl:if>
<xsl:if test="C4_MNAME != ''">
    <mname>
      <xsl:value-of select="C4_MNAME"/>
    </mname>
</xsl:if>
    <lname>
      <xsl:value-of select="C4_LNAME"/>
    </lname>
  </scoll>
</xsl:if>

<xsl:if test="C5_LNAME != ''">
  <scoll>
<xsl:if test="C5_FNAME != ''">
    <fname>
      <xsl:value-of select="C5_FNAME"/>
    </fname>
</xsl:if>
<xsl:if test="C5_MNAME != ''">
    <mname>
      <xsl:value-of select="C5_MNAME"/>
    </mname>
</xsl:if>
    <lname>
      <xsl:value-of select="C5_LNAME"/>
    </lname>
  </scoll>
</xsl:if>

</collectors>
</xsl:if>

<xsl:if test="COLL_NBR != ''">
<collnbr>
  <xsl:value-of select="COLL_NBR"/>
</collnbr>
</xsl:if>

<xsl:if test="STATE != ''">
<sitegeo>
  <state>
    <xsl:value-of select="STATE"/>
  </state>
<xsl:if test="COUNTY != ''">
  <county>
    <xsl:value-of select="COUNTY"/>
  </county>
</xsl:if>
<xsl:if test="TOWNSHIP != ''">
  <township>
    <xsl:value-of select="TOWNSHIP"/>
  </township>
</xsl:if>
<xsl:if test="CITY != ''">
  <city>
    <xsl:value-of select="CITY"/>
  </city>
</xsl:if>
</sitegeo>
</xsl:if>

<xsl:if test="TWP_NBR != ''">
<sitesurvey>
  <twp>
    <twpnum>
      <xsl:value-of select="TWP_NBR"/>
    </twpnum>
    <twpdir>
      <xsl:value-of select="TWP_DIR"/>
    </twpdir>
  </twp>
<xsl:if test="RNG_NBR != ''">
  <rng>
    <rngnum>
      <xsl:value-of select="RNG_NBR"/>
    </rngnum>
    <rngdir>
      <xsl:value-of select="RNG_DIR"/>
    </rngdir>
  </rng>
</xsl:if>
<xsl:if test="SEC_NBR != ''">
  <sec>
    <secnum>
      <xsl:value-of select="SEC_NBR"/>
    </secnum>
    <secdtl>
      <xsl:value-of select="SEC_DTL"/>
    </secdtl>
  </sec>
</xsl:if>
</sitesurvey>
</xsl:if>

<xsl:if test="LAT_DD != ''">
<sitegps>
  <lat>
    <latdir>
      <xsl:value-of select="LAT_DIR"/>
    </latdir>
    <latdd>
      <xsl:value-of select="LAT_DD"/>
    </latdd>
  </lat>
<xsl:if test="LONG_DD != ''">
  <long>
    <longdir>
      <xsl:value-of select="LONG_DIR"/>
    </longdir>
    <longdd>
      <xsl:value-of select="LONG_DD"/>
    </longdd>
  </long>
</xsl:if>
</sitegps>
</xsl:if>

<xsl:if test="LOCALITY != ''">
<locality>
  <xsl:value-of select="LOCALITY"/>
</locality>
</xsl:if>

<xsl:if test="HABITAT != ''">
<habitat>
  <xsl:value-of select="HABITAT"/>
</habitat>
</xsl:if>

<xsl:if test="TYPE = 'Y'">
<typespm/>
</xsl:if>

<homepg>
<xsl:if test="HOMEPAGE_LINK != ''">
<link>
  <xsl:value-of select="HOMEPAGE_LINK"/>
</link>
</xsl:if>

<xsl:if test="MORE_LOC != ''">
<loc data="{MORE_LOC}"/>
</xsl:if>

<xsl:if test="MORE_HAB != ''">
<hab data="{MORE_HAB}"/>
</xsl:if>

<xsl:if test="MORE_DESC != ''">
<desc data="{MORE_DESC}"/>
</xsl:if>

<xsl:if test="MORE_ASSOC != ''">
<assoc data="{MORE_ASSOC}"/>
</xsl:if>

<xsl:if test="MORE_ANNOT != ''">
<annot data="{MORE_ANNOT}"/>
</xsl:if>

<xsl:if test="IMAGE_PREVIEW != ''">
<image type="preview"><xsl:value-of select="IMAGE_PREVIEW"/></image>
</xsl:if>

<xsl:if test="IMAGE_FULL != ''">
<image type="full"><xsl:value-of select="IMAGE_FULL"/></image>
</xsl:if>

</homepg>

<crdate>
  <month>
    <xsl:value-of select="CREATE_MONTH"/>
  </month>
  <day>
    <xsl:value-of select="CREATE_DAY"/>
  </day>
  <year>
    <xsl:value-of select="CREATE_YEAR"/>
  </year>
</crdate>
</spm>
 </xsl:template>
</xsl:stylesheet>
