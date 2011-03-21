<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
 <xsl:output method="xml" encoding="UTF-8"/>
 <xsl:template match="/ROOT">
<index xsi:noNamespaceSchemaLocation="http://www.vplants.org/metadata/vpindex.xsd" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
<herbcd>
  <xsl:value-of select="HERB_CD"/>
</herbcd>
<taxon>
<xsl:apply-templates>
  <xsl:with-param name="uribase" select="URI_BASE"/>
</xsl:apply-templates>
</taxon>
</index>
 </xsl:template>

<xsl:template match="HERB_CD">
</xsl:template>

<xsl:template match="URI_BASE">
</xsl:template>

<xsl:template match="NAME_CD">
 <xsl:param name="uribase"/>
<link>
<xsl:value-of select="$uribase"/>
<xsl:text>/</xsl:text>
<xsl:value-of select="substring(.,1,1)"/>
<xsl:text>/</xsl:text>
<xsl:value-of select="."/>
<xsl:text>.xml</xsl:text>
</link>
</xsl:template>
</xsl:stylesheet>
