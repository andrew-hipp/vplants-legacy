<?php
//error_reporting(E_ALL);
include_once($serverRoot."/config/symbini.php");
header("Content-Type: text/html; charset=".$charset);
?>
<html>
<head>
	<title><?php echo $defaultTitle?>vPlants - Topics - The Listing of Plants</title>
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
            <h1>The Listing of Plants</h1>

            <div style="margin:20px;">
            	<p>Certain species of plants (and animals) that experience decreases in frequency, population size, or number of populations have been assigned special status by state and federal governments.  Depending on the listing agency, ranks of Endangered, Threatened, Rare, Special Concern, Watch List or Extirpated are assigned to particular taxa (species, subspecies, or variety).  Typically, the taxa at highest risk for becoming extinct are listed as endangered, with the risk decreasing down to threatened, rare, etc.  Ideally, by protecting populations of species that are ranked on these lists, the extirpation (local extinction) of species in particular areas can be avoided.  Each state usually has their own ranking system and different protection laws or methods associated with those ranks.</p>
            </div>
        </div>
		
		<div id="content2">

			<img src="<?php echo $clientRoot; ?>/images.vplants/feature/CIPI.jpg" width="250" height="337" alt="thistle growing in sand." title="Cirsium pitcheri" />
			<div class="box imgtext">
			<p>Pitcher's thistle, <i>Cirsium pitcheri</i>, is Federally listed as Threatened.  Its required habitat of open dune faces has become rarer through loss to development. <a href="/plants/species/species.jsp?gid=9488"><i>C. pitcheri</i> description </a></p>
			</div>

			<div class="box">
			<h3>Related Pages</h3>
			<ul><li>
			<a href="concern.html">Regional Lists</a>
			</li></ul>
			</div>

			<p class="small">Information provided on this page applies to the Chicago Region and may not be relevant or complete for other regions.</p><p class="small noprint"><a href="/disclaimer.html" title="Read Disclaimer.">Disclaimer</a></p>

		</div><!-- end of #content2 -->

	<?php
	include($serverRoot."/footer.php");
	?> 

</body>
</html>