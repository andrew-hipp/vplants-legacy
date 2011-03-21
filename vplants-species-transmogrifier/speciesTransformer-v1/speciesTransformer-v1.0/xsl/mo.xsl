<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="xml" encoding="UTF-8"/>
  <xsl:template match="/ROOT">

    <xsl:variable name="lcletters">abcdefghijklmnopqrstuvwxyz</xsl:variable>
    <xsl:variable name="ucletters">ABCDEFGHIJKLMNOPQRSTUVWXYZ</xsl:variable>
    <speciesPage>
      <NAME_CD>
        <xsl:value-of select="translate(nameCd,$lcletters,$ucletters)"/>
      </NAME_CD>
      <group>
        <xsl:value-of select="group"/>
      </group>      
      <desc>
      	<growthForm>
      	  <xsl:value-of select="growthForm"/>
      	</growthForm>
      	<size>
      	  <xsl:value-of select="size"/>
      	</size>
      	<parts>
      	  <part>
      	    <partName>
      	      <xsl:value-of select="part_Name1"/>
      	    </partName>
      	    <partText>
      	      <xsl:value-of select="part_Text1"/>
      	    </partText>
      	  </part>      	
      	  <part>
      	    <partName>
      	      <xsl:value-of select="part_Name2"/>
      	    </partName>
      	    <partText>
      	      <xsl:value-of select="part_Text2"/>
      	    </partText>
      	  </part>      	
      	  <part>
      	    <partName>
      	      <xsl:value-of select="part_Name3"/>
      	    </partName>
      	    <partText>
      	      <xsl:value-of select="part_Text3"/>
      	    </partText>
      	  </part>      	
      	  <part>
      	    <partName>
      	      <xsl:value-of select="part_Name4"/>
      	    </partName>
      	    <partText>
      	      <xsl:value-of select="part_Text4"/>
      	    </partText>
      	  </part>      	
      	  <part>
      	    <partName>
      	      <xsl:value-of select="part_Name5"/>
      	    </partName>
      	    <partText>
      	      <xsl:value-of select="part_Text5"/>
      	    </partText>
      	  </part>      	
      	  <part>
      	    <partName>
      	      <xsl:value-of select="part_Name6"/>
      	    </partName>
      	    <partText>
      	      <xsl:value-of select="part_Text6"/>
      	    </partText>
      	  </part>      	
      	  <part>
      	    <partName>
      	      <xsl:value-of select="part_Name7"/>
      	    </partName>
      	    <partText>
      	      <xsl:value-of select="part_Text7"/>
      	    </partText>
      	  </part>      	
      	  <part>
      	    <partName>
      	      <xsl:value-of select="part_Name8"/>
      	    </partName>
      	    <partText>
      	      <xsl:value-of select="part_Text8"/>
      	    </partText>
      	  </part>      	
      	  <part>
      	    <partName>
      	      <xsl:value-of select="part_Name9"/>
      	    </partName>
      	    <partText>
      	      <xsl:value-of select="part_Text9"/>
      	    </partText>
      	  </part>      	
      	  <part>
      	    <partName>
      	      <xsl:value-of select="part_Name10"/>
      	    </partName>
      	    <partText>
      	      <xsl:value-of select="part_Text10"/>
      	    </partText>
      	  </part>      	
      	</parts>
      </desc>      
      <similarSpecies>
      	<comments>
      	  <xsl:value-of select="simSp_comments"/>
      	</comments>
        <nameCds>
          <simNmCd>
            <xsl:value-of select="simSp_nameCd1"/>
          </simNmCd>
          <simNmCd>
            <xsl:value-of select="simSp_nameCd2"/>
          </simNmCd>
          <simNmCd>
            <xsl:value-of select="simSp_nameCd3"/>
          </simNmCd>
          <simNmCd>
            <xsl:value-of select="simSp_nameCd4"/>
          </simNmCd>
          <simNmCd>
            <xsl:value-of select="simSp_nameCd5"/>
          </simNmCd>
          <simNmCd>
            <xsl:value-of select="simSp_nameCd6"/>
          </simNmCd>
        </nameCds>
        <links>
          <link>
            <linkUri>
              <xsl:value-of select="simSp_linkUri1"/>
            </linkUri>
            <linkText>
              <xsl:value-of select="simSp_linkText1"/>
            </linkText>
          </link>
          <link>
            <linkUri>
              <xsl:value-of select="simSp_linkUri2"/>
            </linkUri>
            <linkText>
              <xsl:value-of select="simSp_linkText2"/>
            </linkText>
          </link>
        </links>      
      </similarSpecies>      
      <flowering>
        <xsl:value-of select="flowering"/>
      </flowering>            
      <habitatEcology>
        <xsl:value-of select="habitatEcology"/>      
      </habitatEcology>
      <nativity>
        <xsl:value-of select="nativity"/>            
      </nativity>     
      <notes>
        <comments>
          <xsl:value-of select="notes_comments"/>
        </comments>
        <links>
          <link>
            <linkUri>
              <xsl:value-of select="notes_linkUri1"/>
            </linkUri>
            <linkText>
              <xsl:value-of select="notes_linkText1"/>
            </linkText>
          </link>
          <link>
            <linkUri>
              <xsl:value-of select="notes_linkUri2"/>
            </linkUri>
            <linkText>
              <xsl:value-of select="notes_linkText2"/>
            </linkText>
          </link>
          <link>
            <linkUri>
              <xsl:value-of select="notes_linkUri3"/>
            </linkUri>
            <linkText>
              <xsl:value-of select="notes_linkText3"/>
            </linkText>
          </link>
        </links>            
      </notes>
      <etymology>
        <comments>
          <xsl:value-of select="etymology_comments"/>
        </comments>
        <links>
          <link>
            <linkUri>
              <xsl:value-of select="etymology_linkUri1"/>
            </linkUri>
            <linkText>
              <xsl:value-of select="etymology_linkText1"/>
            </linkText>
          </link>
          <link>
            <linkUri>
              <xsl:value-of select="etymology_linkUri2"/>
            </linkUri>
            <linkText>
              <xsl:value-of select="etymology_linkText2"/>
            </linkText>
          </link>
          <link>
            <linkUri>
              <xsl:value-of select="etymology_linkUri3"/>
            </linkUri>
            <linkText>
              <xsl:value-of select="etymology_linkText3"/>
            </linkText>
          </link>
        </links>            
      </etymology>     
      <furtherInfo>
        <comments>
          <xsl:value-of select="furtherInfo_comments"/>
        </comments>
        <links>
          <link>
            <linkUri>
              <xsl:value-of select="furtherInfo_linkUri1"/>
            </linkUri>
            <linkText>
              <xsl:value-of select="furtherInfo_linkText1"/>
            </linkText>
          </link>
          <link>
            <linkUri>
              <xsl:value-of select="furtherInfo_linkUri2"/>
            </linkUri>
            <linkText>
              <xsl:value-of select="furtherInfo_linkText2"/>
            </linkText>
          </link>
          <link>
            <linkUri>
              <xsl:value-of select="furtherInfo_linkUri3"/>
            </linkUri>
            <linkText>
              <xsl:value-of select="furtherInfo_linkText3"/>
            </linkText>
          </link>
          <link>
            <linkUri>
              <xsl:value-of select="furtherInfo_linkUri4"/>
            </linkUri>
            <linkText>
              <xsl:value-of select="furtherInfo_linkText4"/>
            </linkText>
          </link>
          <link>
            <linkUri>
              <xsl:value-of select="furtherInfo_linkUri5"/>
            </linkUri>
            <linkText>
              <xsl:value-of select="furtherInfo_linkText5"/>
            </linkText>
          </link>
          <link>
            <linkUri>
              <xsl:value-of select="furtherInfo_linkUri6"/>
            </linkUri>
            <linkText>
              <xsl:value-of select="furtherInfo_linkText6"/>
            </linkText>
          </link>
          <link>
            <linkUri>
              <xsl:value-of select="furtherInfo_linkUri7"/>
            </linkUri>
            <linkText>
              <xsl:value-of select="furtherInfo_linkText7"/>
            </linkText>
          </link>
          <link>
            <linkUri>
              <xsl:value-of select="furtherInfo_linkUri8"/>
            </linkUri>
            <linkText>
              <xsl:value-of select="furtherInfo_linkText8"/>
            </linkText>
          </link>
          <link>
            <linkUri>
              <xsl:value-of select="furtherInfo_linkUri9"/>
            </linkUri>
            <linkText>
              <xsl:value-of select="furtherInfo_linkText9"/>
            </linkText>
          </link>
          <link>
            <linkUri>
              <xsl:value-of select="furtherInfo_linkUri10"/>
            </linkUri>
            <linkText>
              <xsl:value-of select="furtherInfo_linkText10"/>
            </linkText>
          </link>
        </links>            
      </furtherInfo>
      <references>
        <reference>
          <citation>
            <xsl:value-of select="references_citation1"/>
          </citation>
        </reference>
        <reference>
          <citation>
            <xsl:value-of select="references_citation2"/>
          </citation>
        </reference>
        <reference>
          <citation>
            <xsl:value-of select="references_citation3"/>
          </citation>
        </reference>
        <reference>
          <citation>
            <xsl:value-of select="references_citation4"/>
          </citation>
        </reference>
        <reference>
          <citation>
            <xsl:value-of select="references_citation5"/>
          </citation>
        </reference>
        <reference>
          <citation>
            <xsl:value-of select="references_citation6"/>
          </citation>
        </reference>
        <reference>
          <citation>
            <xsl:value-of select="references_citation7"/>
          </citation>
        </reference>
        <reference>
          <citation>
            <xsl:value-of select="references_citation8"/>
          </citation>
        </reference>
        <reference>
          <citation>
            <xsl:value-of select="references_citation9"/>
          </citation>
        </reference>
        <reference>
          <citation>
            <xsl:value-of select="references_citation10"/>
          </citation>
        </reference>
        <reference>
          <link>
            <linkUri>
              <xsl:value-of select="references_linkUri1"/>
            </linkUri>
            <linkText>
              <xsl:value-of select="references_linkText1"/>
            </linkText>
          </link>        
        </reference>
        <reference>
          <link>
            <linkUri>
              <xsl:value-of select="references_linkUri2"/>
            </linkUri>
            <linkText>
              <xsl:value-of select="references_linkText2"/>
            </linkText>
          </link>        
        </reference>
        <reference>
          <link>
            <linkUri>
              <xsl:value-of select="references_linkUri3"/>
            </linkUri>
            <linkText>
              <xsl:value-of select="references_linkText3"/>
            </linkText>
          </link>        
        </reference>
        <reference>
          <link>
            <linkUri>
              <xsl:value-of select="references_linkUri4"/>
            </linkUri>
            <linkText>
              <xsl:value-of select="references_linkText4"/>
            </linkText>
          </link>        
        </reference>
        <reference>
          <link>
            <linkUri>
              <xsl:value-of select="references_linkUri5"/>
            </linkUri>
            <linkText>
              <xsl:value-of select="references_linkText5"/>
            </linkText>
          </link>        
        </reference>
        <reference>
          <link>
            <linkUri>
              <xsl:value-of select="references_linkUri6"/>
            </linkUri>
            <linkText>
              <xsl:value-of select="references_linkText6"/>
            </linkText>
          </link>        
        </reference>
        <reference>
          <link>
            <linkUri>
              <xsl:value-of select="references_linkUri7"/>
            </linkUri>
            <linkText>
              <xsl:value-of select="references_linkText7"/>
            </linkText>
          </link>        
        </reference>
        <reference>
          <link>
            <linkUri>
              <xsl:value-of select="references_linkUri8"/>
            </linkUri>
            <linkText>
              <xsl:value-of select="references_linkText8"/>
            </linkText>
          </link>        
        </reference>
        <reference>
          <link>
            <linkUri>
              <xsl:value-of select="references_linkUri9"/>
            </linkUri>
            <linkText>
              <xsl:value-of select="references_linkText9"/>
            </linkText>
          </link>        
        </reference>
        <reference>
          <link>
            <linkUri>
              <xsl:value-of select="references_linkUri10"/>
            </linkUri>
            <linkText>
              <xsl:value-of select="references_linkText10"/>
            </linkText>
          </link>        
        </reference>
      </references>      
      <otherRecords>
        <ilBn>
          <xsl:value-of select="ilBn"/>
        </ilBn>
        <ilCk>
           <xsl:value-of select="ilCk"/>       
        </ilCk>
        <ilDk>
           <xsl:value-of select="ilDk"/>
        </ilDk>
        <ilDp>
           <xsl:value-of select="ilDp"/>
        </ilDp>
        <ilGd>
           <xsl:value-of select="ilGd"/>
        </ilGd>
        <ilKd>
           <xsl:value-of select="ilKd"/>
        </ilKd>
        <ilKk>
           <xsl:value-of select="lKk"/>
        </ilKk>
        <ilKn>
           <xsl:value-of select="ilKn"/>
        </ilKn>
        <ilLk>
           <xsl:value-of select="ilLk"/>
        </ilLk>
        <ilMh>
           <xsl:value-of select="ilMh"/>
        </ilMh>
        <ilWl>
           <xsl:value-of select="ilWl"/>
        </ilWl>
        <inJs>
           <xsl:value-of select="inJs"/>
        </inJs>
        <inLk>
           <xsl:value-of select="inLk"/>
        </inLk>
        <inLp>
           <xsl:value-of select="inLp"/>
        </inLp>
        <inNt>
           <xsl:value-of select="inNt"/>
        </inNt>
        <inPt>
           <xsl:value-of select="inPt"/>
        </inPt>
        <inSj>
           <xsl:value-of select="inSj"/>
        </inSj>
        <inSk>
           <xsl:value-of select="inSk"/>
        </inSk>
        <miBr>
           <xsl:value-of select="miBr"/>
        </miBr>
        <wiKs>
           <xsl:value-of select="wiKs"/>
        </wiKs>
        <wiMw>
           <xsl:value-of select="wiMw"/>
        </wiMw>
        <wiRc>
           <xsl:value-of select="wiRc"/>
        </wiRc>
        <wiWk>
           <xsl:value-of select="wiWk"/>
        </wiWk>
        <wiWw>
           <xsl:value-of select="wiWw"/>
        </wiWw>
      </otherRecords>
    </speciesPage>
  </xsl:template>
</xsl:stylesheet>
  