<?php
//error_reporting(E_ALL);
include_once($serverRoot."/config/symbini.php");
header("Content-Type: text/html; charset=".$charset);
?>
<html>
<head>
	<title><?php echo $defaultTitle?> vPlants - About Plants<</title>
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
            <h1>About Plants</h1>

            <div style="margin:20px;">
				<div class="indexheading"><a href="<?php echo $clientRoot; ?>/plants/chicagoplants.php">Chicago Plants</a></div>
				<div class="indexdescription"><p>Nearly 2,700 different species of vascular plants are recorded in the 24 counties of the Chicago Region. There are an additional 300 subspecies, varieties, or forms. Within these 3,000 taxa, approximately 1650 taxa (55% of flora) are native. Considering the relatively small physical area of the Region, this is a surprisingly large number of species of vascular plants.<a href="<?php echo $clientRoot; ?>/plants/chicagoplants.php">Learn more.</a></p></div>

				<div class="indexheading"><a href="<?php echo $clientRoot; ?>/plants/guide/index.php">Guide</a></div>
				<div class="indexdescription"><p>This is text below it<a href="<?php echo $clientRoot; ?>/plants/guide/index.php">Learn more.</a></p></div>
				
				<div class="indexheading"><a href="<?php echo $clientRoot; ?>/plants/glossary/index.php">Glossary</a></div>
				<div class="indexdescription"><p>This is text below it</p></div>
				
				<div class="indexheading"><a href="<?php echo $clientRoot; ?>/plants/biology.php">Biology</a></div>
				<div class="indexdescription"><p>This is text below it</p></div>
				
				<div class="indexheading"><a href="<?php echo $clientRoot; ?>/plants/diversity.php">Diversity</a></div>
				<div class="indexdescription"><p>This is text below it</p></div>
				
				<div class="indexheading"><a href="<?php echo $clientRoot; ?>/plants/habitats.php">Habitats</a></div>
				<div class="indexdescription"><p>This is text below it</p></div>
				
				<div class="indexheading"><a href="<?php echo $clientRoot; ?>/plants/origin.php">Origin</a></div>
				<div class="indexdescription"><p>This is text below it</p></div>
				
				<div class="indexheading"><a href="<?php echo $clientRoot; ?>/plants/distribution.php">Distribution</a></div>
				<div class="indexdescription"><p>This is text below it</p></div>
				
				<div class="indexheading"><a href="<?php echo $clientRoot; ?>/plants/names.php">Naming</a></div>
				<div class="indexdescription"><p>This is text below it</p></div>
				
				<div class="indexheading"><a href="<?php echo $clientRoot; ?>/plants/collections.php">Collections</a></div>
				<div class="indexdescription"><p>This is text below it</p></div>
				
				<div class="indexheading"><<a href="<?php echo $clientRoot; ?>/plants/concern.php">Plants of Special Concern</a></div>
				<div class="indexdescription"><p>This is text below it</p></div>
            </div>
        </div>

	<?php
	include($serverRoot."/footer.php");
	?> 

</body>
</html>