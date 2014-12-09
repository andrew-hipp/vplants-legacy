<?php
//error_reporting(E_ALL);
include_once($serverRoot."/config/symbini.php");
header("Content-Type: text/html; charset=".$charset);
?>
<html>
<head>
	<title><?php echo $defaultTitle?> vPlants - Plants<</title>
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
            <h1>Plants of the Chicago Region</h1>

            <div style="margin:20px;">
            	<p>
				Nearly 2,700 different species of <a href="/plants/guide/index.html" title="Guide to plants.">vascular plants</a> are recorded in the
				 <a href="/map_county.html" title="See County Map for Chicago Region.">24 counties</a>
				of the 
				 <a href="/chicago.html" title="Why the Chicago Region?">Chicago Region</a>. There are an additional 300 subspecies, varieties, or forms.  Within these 
				 <a href="/plants/diversity.html" title="How many plants.">3,000 taxa</a>, approximately 1650 taxa (55% of flora) are native.  Considering the relatively small physical area of the Region, this is a surprisingly large number of species of vascular plants.
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
        </div>

	<?php
	include($serverRoot."/footer.php");
	?> 

</body>
</html>