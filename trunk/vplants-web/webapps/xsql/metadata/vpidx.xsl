<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="xml"/>

<xsl:template match="/VPINDEX">
<index xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="http://www.vplants.org/metadata/vpindex.xsd">
<xsl:apply-templates />
</index>
</xsl:template>

<xsl:template match="HERBCD">
<herbcd><xsl:value-of select="."/></herbcd>
</xsl:template>

<xsl:template match="TAXON">
<taxon>
<xsl:apply-templates />
</taxon>
</xsl:template>

<xsl:template match="SCINAME_ID">
<link>
<xsl:text>
http://redwood.mortonarb.org/xsql/metadata/vphdr.xsql?id=</xsl:text><xsl:value-of select="."/>
</link>
</xsl:template>

</xsl:stylesheet>
