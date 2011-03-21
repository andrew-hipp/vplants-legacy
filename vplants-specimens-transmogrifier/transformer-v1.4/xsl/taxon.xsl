<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
 <xsl:output method="xml" encoding="UTF-8"/>
 <xsl:template match="/ROOT">
<taxon xsi:noNamespaceSchemaLocation="http://www.vplants.org/metadata/vptaxon.xsd" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
<namecd>
  <xsl:value-of select="NAME_CD"/>
</namecd>
<xsl:apply-templates>
  <xsl:with-param name="namecd" select="NAME_CD"/>
  <xsl:with-param name="uribase" select="URI_BASE"/>
</xsl:apply-templates>
</taxon>
 </xsl:template>

<xsl:template match="NAME_CD">
</xsl:template>

<xsl:template match="URI_BASE">
</xsl:template>

<xsl:template match="SPM_HDR">
 <xsl:param name="namecd"/>
 <xsl:param name="uribase"/>
<spm>
<spmid>
  <xsl:value-of select="SPM_ID"/>
</spmid>
<updttm>
<month>
  <xsl:value-of select="MONTH"/>
</month>
<day>
  <xsl:value-of select="DAY"/>
</day>
<year>
  <xsl:value-of select="YEAR"/>
</year>
<hour>
  <xsl:value-of select="HOUR"/>
</hour>
<min>
  <xsl:value-of select="MIN"/>
</min>
</updttm>
<link>
<xsl:value-of select="$uribase"/>
<xsl:text>/</xsl:text>
<xsl:value-of select="substring($namecd,1,1)"/>
<xsl:text>/</xsl:text>
<xsl:value-of select="$namecd"/>
<xsl:text>/</xsl:text>
<xsl:value-of select="SPM_ID"/>
<xsl:text>.xml</xsl:text>
</link>
</spm>
 </xsl:template>
</xsl:stylesheet>
