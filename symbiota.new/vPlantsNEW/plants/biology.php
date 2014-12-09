<?php
//error_reporting(E_ALL);
include_once($serverRoot."/config/symbini.php");
header("Content-Type: text/html; charset=".$charset);
?>
<html>
<head>
	<title><?php echo $defaultTitle?> vPlants - Plant Biology</title>
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
            <h1>Plant Biology</h1>

            <div style="margin:20px;">
            	<p>Plants exhibit tremendous diversity. Most plants are green and use the sun's energy to produce their own food; others lack chlorophyll and feed off of other organisms. Some plants grow in the water and many grow on the land. Land plants and green algae make up the
				<a href="http://tolweb.org/tree?group=Green_plants&contgroup=Eukaryotes">Kingdom Plantae [external link]</a> or Green Plants.</p>

				<h2>Plants are producers</h2>

				<p>Producers, or autotrophs (self-feeding), are organisms that are capable of creating their own food from inorganic (non-living) substances using light or chemical energy that is available in the environment surrounding them.  Typically, they are able to make their own life-sustaining organic compounds from simple and readily-available gases such as carbon dioxide and inorganic nitrogen, together with water. In certain environments other compounds such as sulfur or methane are used. In most environments on earth (both on land and in water), plants are the major producers. Through photosynthesis, plants trap light energy and use carbon dioxide and water to form life-sustaining sugars, which are converted to downstream building blocks (like carbohydrates and proteins), that allow plants to grow and thrive.</p>

				<p>Luckily for oxygen-consuming organisms (like humans), plants release oxygen as a byproduct from photosynthesis (when water is split).  Without plants, our planet would not have the hospitable atmosphere that exists, and life as we know it today would not have been able to evolve.  Normally, producers act as food sources for other organisms, namely consumers.</p>

				<p>Plants are called primary producers because they form a foundation in food webs and act as starting points in the energy and carbon cycles of an ecosystem.  Some microorganisms, such as cyanobacteria are also producers, but animals and fungi are primary consumers (herbivores) or secondary consumers (carnivores) that rely on plants for food and chemical energy. Omnivores (such as many humans) eat both plants and animals.</p>
            </div>
        </div>

	<?php
	include($serverRoot."/footer.php");
	?> 

</body>
</html>