<?php
//error_reporting(E_ALL);
include_once('../config/symbini.php');
header("Content-Type: text/html; charset=".$charset);
?>
<html>
<head>
	<title><?php echo $defaultTitle?> vPlants - Chicago Region Plants<</title>
	<link href="../css/base.css" type="text/css" rel="stylesheet" />
	<link href="../css/main.css" type="text/css" rel="stylesheet" />
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
		<!-- start of inner text and right side content -->
		<div  id="innertext">
			<div id="bodywrap">
				<div id="wrapper1"><!-- for navigation and content -->

					<!-- PAGE CONTENT STARTS -->

					<div id="content1wrap"><!--  for content1 only -->

					<div id="content1"><!-- start of primary content --><a id="pagecontent" name="pagecontent"></a>
					<h1>Plants of the Chicago Region</h1>

					<div style="margin:20px;">
						<p>
						Nearly 2,700 different species of <a href="<?php echo $clientRoot; ?>/plants/guide/index.php" title="Guide to plants.">vascular plants</a> are recorded in the
						 <a href="<?php echo $clientRoot; ?>/about/map_county.php" title="See County Map for Chicago Region.">24 counties</a>
						of the 
						 <a href="<?php echo $clientRoot; ?>/about/chicago.php" title="Why the Chicago Region?">Chicago Region</a>. There are an additional 300 subspecies, varieties, or forms.  Within these 
						 <a href="<?php echo $clientRoot; ?>/plants/diversity.php" title="How many plants.">3,000 taxa</a>, approximately 1650 taxa (55% of flora) are native.  Considering the relatively small physical area of the Region, this is a surprisingly large number of species of vascular plants.
						</p>

						<div id="floatimg"><img src="<?php echo $clientRoot; ?>/images/vplants/feature/plant_170_250.jpg" width="170" height="250" alt="detail view of spore cases on leaf." title="Dryopteris marginalis (Photo by W. C. Burger)."></div>

						<p>
						Vascular Plants are the majority of plants we see: wildflowers, grasses, trees, shrubs, vines, and ferns. Many plants are perennial, living for several years to hundreds of years. Other plants are annual or biennial, growing from seed and living one or two seasons.  Identification of plants is based on the whole organism, the reproductive structures (flowers, cones, or sporangia), the leaves, stems, and even the form of the roots.
						</p>

						<p>The <a href="http://www.tolweb.org/Green_plants/">Kingdom Plantae [external link]</a> is comprised of several major groups.
						Most plants treated here are angiosperms, the flowering plants. The conifers and other gymnosperms lack flowers. The ferns, horsetails, clubmosses, and spikemosses are vascular plants that lack seeds.
						</p>

						<h3>Plants not included in vPlants at the present time</h3>

						<p>
						The bryophytes, that is the mosses, liverworts, and hornworts, are not yet included in vPlants.
						Also absent are the various groups of green algae, the basal members of the plant kingdom.
						</p>
					</div>
					</div><!-- end of #content1 -->
					</div><!-- end of #content1wrap -->
		
					<div id="content2"><!-- start of side content -->
					<!-- any image width should be 250 pixels -->
			 
						<div class="box">
							<h3>Directory and Guides</h3>
							<ul><li><a href="guide/"
							 title="Identification guide">Guide to Plants</a></li>
							<li><a href="/xsql/plants/famlist.xsql" 
							 title="Index of families">Family Index</a></li>
							<li><a href="/xsql/plants/genlist.xsql" 
							 title="Index of genera">Genus Index</a></li>
							<li><a href="<?php echo $clientRoot; ?>/resources/biblio.php" 
							 title="Guides for Chicago Region">Plant References</a></li>
							<li><a href="<?php echo $clientRoot; ?>/resources/links.php" 
							 title="Links to websites">Plant Links</a></li></ul>
						</div>

						<div id="simpleform">
							  <form name="simple" method="post" action="/xsql/plants/findtaxa.xsql">
							   <fieldset><legend title="Enter name of plant in one or more of the search fields.">Plant Search</legend>
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

						<p class="large">
							  <a href="/search.html" 
							   title="Search by Location, Collector, and more.">Go to Advanced Search</a>
						</p>

						<p class="small">Information provided on this page applies to the Chicago Region and may not be relevant or complete for other regions.</p><p class="small noprint"><a href="/disclaimer.php" title="Read Disclaimer.">Disclaimer</a></p>

					</div><!-- end of #content2 -->
				</div><!-- end of #wrapper1 -->
			</div><!-- end of #bodywrap -->
		</div><!-- end of #innertext -->

	<?php
	include($serverRoot."/footer.php");
	?> 

</body>
</html>