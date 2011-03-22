<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="xml"/>
<xsl:template match="/VPHDR">
<taxon xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="http://www.vplants.org/metadata/vptaxon.xsd">
<xsl:apply-templates/>
</taxon>
</xsl:template>

<xsl:template match="NAMECD">
<namecd><xsl:value-of select="."/></namecd>
</xsl:template>

<xsl:template match="NAME">
<common><xsl:value-of select="."/></common>
</xsl:template>

<xsl:template match="SPECIMEN">
<spm>
<spmid><xsl:value-of select="HERB_NBR"/></spmid>
<updttm>
<month><xsl:value-of select="MONTH"/></month>
<day><xsl:value-of select="DAY"/></day>
<year><xsl:value-of select="YEAR"/></year>
<hour><xsl:value-of select="HOUR"/></hour>
<min><xsl:value-of select="MIN"/></min>
</updttm>
<link>
<xsl:text>
http://redwood.mortonarb.org/xsql/metadata/vpdtl.xsql?id=</xsl:text><xsl:value-of select="HERB_NBR"/>
</link>
</spm>
</xsl:template>

</xsl:stylesheet>
