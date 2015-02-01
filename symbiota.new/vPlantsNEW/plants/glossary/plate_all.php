<?php
//error_reporting(E_ALL);
include_once('../../config/symbini.php');
header("Content-Type: text/html; charset=".$charset);
?>
<html>
<head>
	<title><?php echo $defaultTitle?>vPlants - Plant Glossary All Plates</title>
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
        <!-- This is inner text! -->
        <div  id="innervplantstext">
            <h1></h1>

            <div style="margin:20px;">
            	<p>
				<a href="index.php">Glossary List</a> | 
				<a href="plate12.php">Previous Plate</a>
				</p>

				<div class="plate">
				<img src="<?php echo $clientRoot; ?>/images/vplants/plants/glossary/plate01.jpg" width="700" height="1055" 
				alt="Line drawings of plant features." 
				title="Plate 1: Stem and Root Types.">
				<h2>Plate 1: Stem and Root Types</h2>
				</div>

				<div class="plate">
				<img src="<?php echo $clientRoot; ?>/images/vplants/plants/glossary/plate02.jpg" width="712" height="1055" 
				alt="Line drawings of plant features." 
				title="Plate 2: Leaf Composition, Parts, and Types.">
				<h2>Plate 2: Leaf Composition, Parts, and Types</h2>
				</div>

				<div class="plate">
				<img src="<?php echo $clientRoot; ?>/images/vplants/plants/glossary/plate03.jpg" width="725" height="1055" 
				alt="Line drawings of plant features." 
				title="Plate 3: Leaf Shapes.">
				<h2>Plate 3: Leaf Shapes</h2>
				</div>

				<div class="plate">
				<img src="<?php echo $clientRoot; ?>/images/vplants/plants/glossary/plate04.jpg" width="710" height="1055" 
				alt="Line drawings of plant features." 
				title="Plate 4: Leaf Margins.">
				<h2>Plate 4: Leaf Margins</h2>
				</div>

				<div class="plate">
				<img src="<?php echo $clientRoot; ?>/images/vplants/plants/glossary/plate05.jpg" width="718" height="1055" 
				alt="Line drawings of plant features." 
				title="Plate 5: Leaf Apices, Venation, and Bases.">
				<h2>Plate 5: Leaf Apices, Venation, and Bases</h2>
				</div>

				<div class="plate">
				<img src="<?php echo $clientRoot; ?>/images/vplants/plants/glossary/plate06.jpg" width="706" height="1055" 
				alt="Line drawings of plant features." 
				title="Plate 6: Surface Features.">
				<h2>Plate 6: Surface Features</h2>
				</div>

				<div class="plate">
				<img src="<?php echo $clientRoot; ?>/images/vplants/plants/glossary/plate07.jpg" width="733" height="1055" 
				alt="Line drawings of plant features." 
				title="Plate 7: Stem and Leaf Parts, and Variations.">
				<h2>Plate 7: Stem and Leaf Parts, and Variations</h2>
				</div>

				<div class="plate">
				<img src="<?php echo $clientRoot; ?>/images/vplants/plants/glossary/plate08.jpg" width="750" height="1055" 
				alt="Line drawings of plant features." 
				title="Plate 8: Inflorescence Types.">
				<h2>Plate 8: Inflorescence Types</h2>
				</div>

				<div class="plate">
				<img src="<?php echo $clientRoot; ?>/images/vplants/plants/glossary/plate09.jpg" width="724" height="1055" 
				alt="Line drawings of plant features." 
				title="Plate 9: Floral Morphology.">
				<h2>Plate 9: Floral Morphology</h2>
				</div>

				<div class="plate">
				<img src="<?php echo $clientRoot; ?>/images/vplants/plants/glossary/plate10.jpg" width="750" height="1055" 
				alt="Line drawings of plant features." 
				title="Plate 10: Corolla Types.">
				<h2>Plate 10: Corolla Types</h2>
				</div>

				<div class="plate">
				<img src="<?php echo $clientRoot; ?>/images/vplants/plants/glossary/plate11.jpg" width="743" height="1055" 
				alt="Line drawings of plant features." 
				title="Plate 11: Fruit Types.">
				<h2>Plate 11: Fruit Types</h2>
				</div>

				<div class="plate">
				<img src="<?php echo $clientRoot; ?>/images/vplants/plants/glossary/plate12.jpg" width="703" height="1055" 
				alt="Line drawings of plant features." 
				title="Plate 12: Sedges, Grasses, and Composites.">
				<h2>Plate 12: Sedges, Grasses, and Composites</h2>
				</div>

            </div>
        </div>

	<?php
	include($serverRoot."/footer.php");
	?> 

</body>
</html>