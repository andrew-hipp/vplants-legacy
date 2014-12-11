<?php
//error_reporting(E_ALL);
include_once($serverRoot."/config/symbini.php");
header("Content-Type: text/html; charset=".$charset);
?>
<html>
<head>
	<title><?php echo $defaultTitle?>vPlants  - a Virtual Herbarium of the Chicago Region</title>
	<link href="<?php echo $serverRoot?>/css/base.css" type="text/css" rel="stylesheet" />
	<link href="<?php echo $serverRoot?>/css/main.css" type="text/css" rel="stylesheet" />
	<meta name='keywords' content='' />
	<script type="text/javascript">
		<?php include_once($serverRoot.'/config/googleanalytics.php'); ?>
	</script>
</head>
<body>
	<?php
	$displayLeftMenu = "true";
	include($serverRoot."/header.php");
	?> 
        <!-- This is inner text! -->
        <div  id="innertext">
            <h1><a href="/about/" title="About vPlants and its partners.">vPlants</a>: a Virtual Herbarium of the Chicago Region.</h1>

            <div style="margin:20px;">
            	<p class="large">The online resource for <a href="/plants/" title="Plant directory."><strong>Plants</strong></a> and <a href="/fungi/" title="Fungus directory."><strong>Fungi</strong></a> offering:</p>
				<ul class="large">
				  <li>Specimen data and images</li>
				  <li>Species descriptions *</li>
				  <li>Distribution by county</li>
				  <li>Photo galleries *</li>
				</ul>
 
				<p>* <a href="/news/" title="See new content.">Description Pages, Features in production</a> / <a href="/news/keys.html">Keys</a></p>
 

				<div id="floatimg"><img src="feature/home_170_250.jpg" width="170" height="250" alt="meadow of flowers along edge of lake." title="DeKalb County, west of Chicago."></div><p class="large">Currently the site contains data for 80,000 plant specimens from three institutions with rich Chicago Region collections: the Field Museum of Natural History, The Morton Arboretum, and the Chicago Botanic Garden. Species descriptions and other content are added on a continual basis.</p>
				<p>Specimen data from additional institutions such as the Chicago Academy of Sciences and the Illinois Natural History Survey will be added.  We have also been in contact with other herbaria in the Great Lakes area such as the University of Wisconsin and University of Michigan regarding the possibility of adding or linking their Chicago Region specimen data through vPlants. This project is a first step towards building a larger online database for plants and fungi that occur in the Great Lakes area and beyond.</p>
            </div>
        </div>
		
		<div id="content2"><!-- start of side content -->
			<!-- any image width should be 250 pixels -->

			<div class="maps">
			<a href="chicago.html" title="Why the Chicago Region?"><img src="img/map_na_65.gif" width="65" height="65" alt="Map of North America showing location of Chicago Region."></a>
			<a href="map.html" title="See State Map for Chicago Region."><img src="img/map_grtlakes_65.gif" width="65" height="65" alt="The vPlants Region is located within four states at the south end of Lake Michigan."></a>
			<a href="map_county.html" title="See County Map for Chicago Region."><img src="img/map_vplants_65.gif" width="65" height="65" alt="The vPlants Region includes 24 counties."></a>
			</div>
			 
			<p><a href="chicago.html" title="Why the Chicago Region?">Why focus on the Chicago Region?</a></p>
			<p><a href="/topics/" title="What is a herbarium?">What is a herbarium?</a></p>

			<div id="simpleform">
			  <form name="simple" method="post" action="/xsql/common/findtaxa.xsql">
			   <fieldset><legend title="Enter name of plant or fungus in one or more of the search fields.">Name Search</legend>
				<p class="radios"><strong title="Select Plant or Fungus.">Group:</strong>
				 <input id="plant" name="db" type="radio" checked="checked" 
				  tabindex="101" value="plants">
				 <label for="plant" title="Select Plant Collections.">Plants</label>
				 <input id="fungus" name="db" type="radio" 
				  tabindex="102" value="fungi">
				 <label for="fungus" title="Select Fungus Collections.">Fungi</label>
				</p>
			   <p><label for="family" accesskey="4" 
				title="Example: Ulmaceae.">Family:</label>
				<input class="texts" id="family" name="family" type="text" maxlength="30" 
				 title="Enter name of a family [one word, can use first several letters]." 
				 value=""></p>
			   <p><label for="genus"  
				title="Example: Ulmus.">Genus:</label> 
				<input class="texts" id="genus" name="genus" type="text" maxlength="30" 
				 title="Enter name of a genus [one word, can use first several letters]." 
				 value=""></p>
			   <p><label for="species" 
				title="Example: americana.">Species Epithet:</label> 
				<input class="texts" id="species" name="species" type="text" maxlength="30" 
				 title="Enter the species epithet, or subspecies, or variety [one word]."
				 value=""></p>
			   <p><label for="common" 
				title="Example: american elm.">Common Name:</label> 
				<input class="texts" id="common" name="common" type="text" maxlength="50" 
				 title="Enter a common name [can use more than one word]." 
				 value=""></p>
				<p><input class="actions" id="submit" name="submit" type="submit" 
				  value="Go" title="Perform Search."></p>
			   </fieldset>
			  </form>
			</div>

			<p class="large"><a href="/search.html" title="Search by Location, Collector, and more.">Go to Advanced Search</a></p>

			<p class="small">Information provided on this page applies to the Chicago Region and may not be relevant or complete for other regions.</p>
			<p class="small noprint"><a href="/disclaimer.html" title="Read Disclaimer.">Disclaimer</a></p>

		</div><!-- end of #content2 -->

	<?php
	include($serverRoot."/footer.php");
	?> 

</body>
</html>