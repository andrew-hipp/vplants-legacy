<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
 <xsl:output method="xml" encoding="UTF-8"/>
 <xsl:template match="/ROOT">

<xsl:variable name="lcletters">abcdefghijklmnopqrstuvwxyz</xsl:variable>
<xsl:variable name="ucletters">ABCDEFGHIJKLMNOPQRSTUVWXYZ</xsl:variable>
<SPM>
<NAME_CD>
  <xsl:value-of select="translate(NAME_CD,$lcletters,$ucletters)"/>
</NAME_CD>

<SPM_HDR>
<SPM_ID>
  <xsl:value-of select="ACC_NBR"/>
</SPM_ID>
<UPDTTM>
<YEAR>
  <xsl:value-of select="substring(UPDATE_DATE,7,4)"/>
</YEAR>
<MONTH>
  <xsl:value-of select="substring(UPDATE_DATE,1,2)"/>
</MONTH>
<DAY>
  <xsl:value-of select="substring(UPDATE_DATE,4,2)"/>
</DAY>
<HOUR>
  <xsl:value-of select="substring(UPDATE_TIME,1,2)"/>
</HOUR>
<MIN>
  <xsl:value-of select="substring(UPDATE_TIME,4,2)"/>
</MIN>
</UPDTTM>
</SPM_HDR>

<SPM_DTL>

<COLL_MONTH>
  <xsl:value-of select="COLL_MONTH"/>
</COLL_MONTH>

<COLL_DAY>
  <xsl:value-of select="COLL_DAY"/>
</COLL_DAY>

<COLL_YEAR>
  <xsl:value-of select="COLL_YEAR"/>
</COLL_YEAR>

<C1_FNAME>
  <xsl:value-of select="substring(C1_FNAME,1,1)"/>
</C1_FNAME>
<C1_MNAME>
  <xsl:value-of select="substring(C1_MNAME,1,1)"/>
</C1_MNAME>
<C1_LNAME>
  <xsl:value-of select="C1_LNAME"/>
</C1_LNAME>

<C2_FNAME>
  <xsl:value-of select="substring(C2_FNAME,1,1)"/>
</C2_FNAME>
<C2_MNAME>
  <xsl:value-of select="substring(C2_MNAME,1,1)"/>
</C2_MNAME>
<C2_LNAME>
  <xsl:value-of select="C2_LNAME"/>
</C2_LNAME>

<C3_FNAME>
  <xsl:value-of select="substring(C3_FNAME,1,1)"/>
</C3_FNAME>
<C3_MNAME>
  <xsl:value-of select="substring(C3_MNAME,1,1)"/>
</C3_MNAME>
<C3_LNAME>
  <xsl:value-of select="C3_LNAME"/>
</C3_LNAME>

<C4_FNAME>
  <xsl:value-of select="substring(C4_FNAME,1,1)"/>
</C4_FNAME>
<C4_MNAME>
  <xsl:value-of select="substring(C4_MNAME,1,1)"/>
</C4_MNAME>
<C4_LNAME>
  <xsl:value-of select="C4_LNAME"/>
</C4_LNAME>

<C5_FNAME>
  <xsl:value-of select="substring(C5_FNAME,1,1)"/>
</C5_FNAME>
<C5_MNAME>
  <xsl:value-of select="substring(C5_MNAME,1,1)"/>
</C5_MNAME>
<C5_LNAME>
  <xsl:value-of select="C5_LNAME"/>
</C5_LNAME>

<COLL_NBR>
  <xsl:value-of select="COLL_NBR"/>
</COLL_NBR>

<STATE>
  <xsl:value-of select="STATE"/>
</STATE>
<COUNTY>
  <xsl:value-of select="COUNTY"/>
</COUNTY>
<TOWNSHIP>
  <xsl:value-of select="TOWNSHIP"/>
</TOWNSHIP>
<CITY>
  <xsl:value-of select="CITY_TOWN"/>
</CITY>

<TWP_NBR>
  <xsl:value-of select="TWP_NBR"/>
</TWP_NBR>
<TWP_DIR>
  <xsl:value-of select="TWP_DIR"/>
</TWP_DIR>

<RNG_NBR>
  <xsl:value-of select="RANGE_NBR"/>
</RNG_NBR>
<RNG_DIR>
  <xsl:value-of select="RANGE_DIR"/>
</RNG_DIR>

<SEC_NBR>
  <xsl:value-of select="SEC_NBR"/>
</SEC_NBR>

<LOCALITY>
  <xsl:value-of select="LOCALITY"/>
</LOCALITY>

<HABITAT>
  <xsl:value-of select="HABITAT"/>
</HABITAT>

<TYPE>
<xsl:choose>
  <xsl:when test="TYPE = 'Y'">
    <xsl:text>Y</xsl:text>
  </xsl:when>
  <xsl:otherwise>
    <xsl:text>N</xsl:text>
  </xsl:otherwise>
</xsl:choose>
</TYPE>

<HOMEPAGE_LINK>
  <xsl:value-of select="ACC_HOMEPAGE"/>
</HOMEPAGE_LINK>

<MORE_LOC>
<xsl:choose>
  <xsl:when test="MORE_LOC = 'H'">
    <xsl:text>S</xsl:text>
  </xsl:when>
  <xsl:otherwise>
  </xsl:otherwise>
</xsl:choose>
</MORE_LOC>

<MORE_HAB>
<xsl:choose>
  <xsl:when test="MORE_HAB = 'H'">
    <xsl:text>S</xsl:text>
  </xsl:when>
  <xsl:otherwise>
  </xsl:otherwise>
</xsl:choose>
</MORE_HAB>

<MORE_DESC>
<xsl:choose>
  <xsl:when test="MORE_DESC = 'H'">
    <xsl:text>S</xsl:text>
  </xsl:when>
  <xsl:otherwise>
  </xsl:otherwise>
</xsl:choose>
</MORE_DESC>

<MORE_ASSOC>
<xsl:choose>
  <xsl:when test="MORE_ASSOC = 'H'">
    <xsl:text>S</xsl:text>
  </xsl:when>
  <xsl:otherwise>
  </xsl:otherwise>
</xsl:choose>
</MORE_ASSOC>

<MORE_ANNOT>
<xsl:choose>
  <xsl:when test="MORE_ANNOT = 'H'">
    <xsl:text>S</xsl:text>
  </xsl:when>
  <xsl:otherwise>
  </xsl:otherwise>
</xsl:choose>
</MORE_ANNOT>

<IMAGE_PREVIEW>
  <xsl:text>http://fm2.fmnh.org/vplants/images/small/</xsl:text><xsl:value-of select="BARCODE_SMALL"/>
</IMAGE_PREVIEW>

<IMAGE_FULL>
  <xsl:text>http://fm2.fmnh.org/vplants/images/big/</xsl:text><xsl:value-of select="BARCODE_BIG"/>
</IMAGE_FULL>

<CREATE_MONTH>
  <xsl:value-of select="substring(CREATE_DATE,1,2)"/>
</CREATE_MONTH>
<CREATE_DAY>
  <xsl:value-of select="substring(CREATE_DATE,4,2)"/>
</CREATE_DAY>
<CREATE_YEAR>
  <xsl:value-of select="substring(CREATE_DATE,7,4)"/>
</CREATE_YEAR>

</SPM_DTL>

</SPM>
 </xsl:template>
</xsl:stylesheet>
  