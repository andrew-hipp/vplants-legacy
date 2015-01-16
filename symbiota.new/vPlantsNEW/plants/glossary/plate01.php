<?php
//error_reporting(E_ALL);
include_once('../../config/symbini.php');
header("Content-Type: text/html; charset=".$charset);
?>
<html>
<head>
	<title><?php echo $defaultTitle?> vPlants - Plate 1 - Stem and Root Types</title>
	<link href="../../css/base.css" type="text/css" rel="stylesheet" />
	<link href="../../css/main.css" type="text/css" rel="stylesheet" />
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
		<!-- Left menu begins -->
		<div class="menu">
			<div class="menuheader">
				<a href="<?php echo $clientRoot; ?>/plants/index.php">About Plants</a>
			</div>
			<div class="menuitem">
				<a href="<?php echo $clientRoot; ?>/plants/chicagoplants.php">Chicago Plants</a>
			</div>
			<div class="menuitem">
				<a href="<?php echo $clientRoot; ?>/plants/guide/index.php">Guide</a>
			</div>
			<div class="menuitem">
				<a href="<?php echo $clientRoot; ?>/plants/glossary/index.php">Glossary</a>
			</div>
				<div class="submenuitem">
					Family Glossaries
				</div>
				<div class="submenuitem">
					<a href="<?php echo $clientRoot; ?>/plants/glossary/asteraceae.php">Asteraceae</a>
				</div>
				<div class="submenuitem">
					<a href="<?php echo $clientRoot; ?>/plants/glossary/cyperaceae.php">Cyperaceae</a>
				</div>
				<div class="submenuitem">
					<a href="<?php echo $clientRoot; ?>/plants/glossary/poaceae.php">Poaceae</a>
				</div>
				<div class="submenuitem">
					Plates
				</div>
				<div class="submenuitem">
					<strong>Stem and Root Types</strong>
				</div>
				<div class="submenuitem">
					<a href="<?php echo $clientRoot; ?>/plants/glossary/plate02.php">Leaf Composition, Parts, and Types</a>
				</div>
				<div class="submenuitem">
					<a href="<?php echo $clientRoot; ?>/plants/glossary/plate03.php">Leaf Shapes</a>
				</div>
				<div class="submenuitem">
					<a href="<?php echo $clientRoot; ?>/plants/glossary/plate04.php">Leaf Margins</a>
				</div>
				<div class="submenuitem">
					<a href="<?php echo $clientRoot; ?>/plants/glossary/plate05.php">Leaf Apices, Venation, and Bases</a>
				</div>
				<div class="submenuitem">
					<a href="<?php echo $clientRoot; ?>/plants/glossary/plate06.php">Surface Features</a>
				</div>
				<div class="submenuitem">
					<a href="<?php echo $clientRoot; ?>/plants/glossary/plate07.php">Stem and Leaf Parts, and Variations</a>
				</div>
				<div class="submenuitem">
					<a href="<?php echo $clientRoot; ?>/plants/glossary/plate08.php">Inflorescence Types</a>
				</div>
				<div class="submenuitem">
					<a href="<?php echo $clientRoot; ?>/plants/glossary/plate09.php">Floral Morphology</a>
				</div>
				<div class="submenuitem">
					<a href="<?php echo $clientRoot; ?>/plants/glossary/plate10.php">Corolla Types</a>
				</div>
				<div class="submenuitem">
					<a href="<?php echo $clientRoot; ?>/plants/glossary/plate11.php">Fruit Types</a>
				</div>
				<div class="submenuitem">
					<a href="<?php echo $clientRoot; ?>/plants/glossary/plate12.php">Sedges, Grasses, and Composites</a>
				</div>
				<div class="submenuitem">
					<a href="<?php echo $clientRoot; ?>/plants/glossary/plate_all.php">All</a>
				</div>
			<div class="menuitem">
				<a href="<?php echo $clientRoot; ?>/plants/biology.php">Biology</a>
			</div>
			<div class="menuitem">
				<a href="<?php echo $clientRoot; ?>/plants/biology.php">Diversity</a>
			</div>
			<div class="menuitem">
				<a href="<?php echo $clientRoot; ?>/plants/habitats.php">Habitats</a>
			</div>
			<div class="menuitem">
				<a href="<?php echo $clientRoot; ?>/plants/origin.php">Origin</a>
			</div>
			<div class="menuitem">
				<a href="<?php echo $clientRoot; ?>/plants/distribution.php">Distribution</a>
			</div>
			<div class="menuitem">
				<a href="<?php echo $clientRoot; ?>/plants/names.php">Naming</a>
			</div>
			<div class="menuitem">
				<a href="<?php echo $clientRoot; ?>/plants/collections.php">Collections</a>
			</div>
			<div class="menuitem">
				<a href="<?php echo $clientRoot; ?>/plants/concern.php">Special Concern</a>
			</div>
		</div>
		<!-- Left menu ends -->
		
        <!-- This is inner text! -->
        <div id="innertext">
            <h1></h1>

            <div style="margin:20px;">
            	<p>
				<a href="index.php">Back to Glossary List</a> | 
				<a href="plate02.php">Next Plate</a>
				</p>

				<div class="plate">
				<img src="<?php echo $clientRoot; ?>/images/vplants/plants/glossary/plate01.jpg" width="525" height="791" 
				alt="Line drawings of plant features." 
				title="Plate 1: Stem and Root Types.">

				<h2>Plate 1: Stem and Root Types</h2>
				</div>
            </div>
        </div>

	<?php
	include($serverRoot."/footer.php");
	?> 

</body>
</html>