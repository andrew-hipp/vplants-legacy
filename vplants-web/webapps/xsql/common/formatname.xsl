<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">

  <span class="sp">
    <em class="genus">
      <xsl:if test="GEN_HYB_CD != 'NV'">
        <!-- hybrid genus -->
        <xsl:text>x </xsl:text>
      </xsl:if>
      <xsl:value-of select="GENUS"/>
	  <xsl:text> </xsl:text>
    </em>
    <xsl:if test="SPECIES != ''">
      <em class="epithet">
        <xsl:if test="SPEC_HYB_CD != 'NV'">
          <!-- hybrid genus -->
          <xsl:text>x </xsl:text>
        </xsl:if>
        <xsl:value-of select="SPECIES"/>
	    <xsl:text> </xsl:text>
	  </em> 
    </xsl:if>
    <xsl:if test="AUTHOR != ''">
      <span class="author">
        <xsl:value-of select="AUTHOR"/>
	    <xsl:text> </xsl:text>  
	  </span>
    </xsl:if>
  </span>

  <xsl:if test="SSP != ''">
    <span class="infra">
      <xsl:text>subsp. </xsl:text>
      <em class="epithet">
        <xsl:value-of select="SSP"/>
	    <xsl:text> </xsl:text>
	  </em>
      <xsl:if test="SSP_AUTHOR != ''">
        <span class="author">
          <xsl:value-of select="SSP_AUTHOR"/>
	      <xsl:text> </xsl:text>  
	    </span>
      </xsl:if>
    </span>
  </xsl:if>

  <xsl:if test="VAR != ''">
    <span class="infra">
      <xsl:text>var. </xsl:text>
      <em class="epithet">
        <xsl:value-of select="VAR"/>
	    <xsl:text> </xsl:text>
	  </em>
      <xsl:if test="VAR_AUTHOR != ''">
        <span class="author">
          <xsl:value-of select="VAR_AUTHOR"/>
	      <xsl:text> </xsl:text>  
	    </span>
      </xsl:if>
    </span>
  </xsl:if>

  <xsl:if test="FMA != ''">
    <span class="infra">
      <xsl:text>f. </xsl:text>
      <em class="epithet">
        <xsl:value-of select="FMA"/>
	    <xsl:text> </xsl:text>
	  </em>
      <xsl:if test="FMA_AUTHOR != ''">
        <span class="author">
          <xsl:value-of select="FMA_AUTHOR"/>
	      <xsl:text> </xsl:text>  
	    </span>
      </xsl:if>
    </span>
  </xsl:if>

  <xsl:if test="CULTIVAR != ''">
    <span class="cultivar">
      <strong>
	    <xsl:text>'</xsl:text>
        <xsl:value-of select="CULTIVAR"/>
	    <xsl:text>'</xsl:text>		
	  </strong>
	  <xsl:text> </xsl:text>
    </span>
  </xsl:if>

</xsl:template>

<xsl:template match="GEN_HYB_CD">
</xsl:template>

<xsl:template match="GENUS">
</xsl:template>

<xsl:template match="SPEC_HYB_CD">
</xsl:template>

<xsl:template match="SPECIES">
</xsl:template>

<xsl:template match="AUTHOR">
</xsl:template>

<xsl:template match="SSP">
</xsl:template>

<xsl:template match="SSP_AUTHOR">
</xsl:template>

<xsl:template match="VAR">
</xsl:template>

<xsl:template match="VAR_AUTHOR">
</xsl:template>

<xsl:template match="FMA">
</xsl:template>

<xsl:template match="FMA_AUTHOR">
</xsl:template>

<xsl:template match="CULTIVAR">
</xsl:template>

<xsl:template match="ACCEPTED_IND">
</xsl:template>

<xsl:template match="DTL_ID">
</xsl:template>

</xsl:stylesheet>
