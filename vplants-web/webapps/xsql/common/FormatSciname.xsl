<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="GEN_HYB_CD">
<xsl:choose>
  <xsl:when test=". != 'NV'">
    <b>
    <xsl:text>x</xsl:text>
    </b>
    <xsl:text> </xsl:text>
  </xsl:when>
</xsl:choose>
</xsl:template>

<xsl:template match="QUALIFIER">
    <b>
    <xsl:value-of select="."/>
    </b>
    <xsl:text> </xsl:text>
</xsl:template>

<xsl:template match="GENUS">
    <b>
<xsl:value-of select="."/>
    </b>
    <xsl:text> </xsl:text>
</xsl:template>

<xsl:template match="SPEC_HYB_CD">
<xsl:choose>
  <xsl:when test=". != 'NV'">
    <b>
    <xsl:text>x</xsl:text>
    </b>
    <xsl:text> </xsl:text>
  </xsl:when>
</xsl:choose>
</xsl:template>

<xsl:template match="SPECIES">
    <b>
    <xsl:value-of select="."/>
    </b>
    <xsl:text> </xsl:text>
</xsl:template>

<xsl:template match="AUTHOR">
<xsl:choose>
  <xsl:when test=". != ''">
    <xsl:value-of select="."/><xsl:text> </xsl:text>
  </xsl:when>
</xsl:choose>
</xsl:template>

<xsl:template match="SSP">
<xsl:choose>
  <xsl:when test=". != ''">
    <b>ssp.&nbsp;<xsl:value-of select="."/></b><xsl:text> </xsl:text>
  </xsl:when>
</xsl:choose>
</xsl:template>

<xsl:template match="SSP_AUTHOR">
<xsl:choose>
  <xsl:when test=". != ''">
    <xsl:value-of select="."/><xsl:text> </xsl:text>
  </xsl:when>
</xsl:choose>
</xsl:template>

<xsl:template match="VAR">
<xsl:choose>
  <xsl:when test=". != ''">
    <b>var.&nbsp;<xsl:value-of select="."/></b><xsl:text> </xsl:text>
  </xsl:when>
</xsl:choose>
</xsl:template>

<xsl:template match="VAR_AUTHOR">
<xsl:choose>
  <xsl:when test=". != ''">
    <xsl:value-of select="."/><xsl:text> </xsl:text>
  </xsl:when>
</xsl:choose>
</xsl:template>

<xsl:template match="FMA">
<xsl:choose>
  <xsl:when test=". != ''">
    <b>f.&nbsp;<xsl:value-of select="."/></b><xsl:text> </xsl:text>
  </xsl:when>
</xsl:choose>
</xsl:template>

<xsl:template match="FMA_AUTHOR">
<xsl:choose>
  <xsl:when test=". != ''">
    <xsl:value-of select="."/><xsl:text> </xsl:text>
  </xsl:when>
</xsl:choose>
</xsl:template>

<xsl:template match="CULTIVAR">
<xsl:choose>
  <xsl:when test=". != ''">
    <b>
    <xsl:text>'</xsl:text>
	<xsl:value-of select="."/><xsl:text> </xsl:text>
    <xsl:text>'</xsl:text>
    </b>
  </xsl:when>
</xsl:choose>
</xsl:template>

<xsl:template match="ACCEPTED_IND">
<xsl:choose>
  <xsl:when test=". = 'Y'">
    <b>
      <font size="1">
    <xsl:text>*</xsl:text>
      </font>
    </b>
  </xsl:when>
</xsl:choose>
</xsl:template>

<xsl:template match="DTL_ID">
<xsl:choose>
  <xsl:when test=". != ''">
    <b>
      <font size="1">
        <a href="sndtl.xsql?id={.}">
	 <xsl:text>(details)</xsl:text>
        </a>
      </font>
    </b>
  </xsl:when>
</xsl:choose>
</xsl:template>

</xsl:stylesheet>
