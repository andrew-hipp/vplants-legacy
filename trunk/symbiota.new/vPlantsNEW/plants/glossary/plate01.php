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
        <!-- This is inner text! -->
		<!-- start of inner text and right side content -->
		<div  id="innertext">
			<div id="bodywrap">
				<div id="wrapper1"><!-- for navigation and content -->

					<!-- PAGE CONTENT STARTS -->

					<div id="content1wrap"><!--  for content1 only -->

					<div id="content1"><!-- start of primary content --><a id="pagecontent" name="pagecontent"></a>
						<h1></h1>

						<div style="margin:20px;">
							<p>
							<a href="index.php">Glossary List</a> | 
							<strong>Stem and Root Types</strong> |
							<a href="plate02.php">Leaf Composition, Parts, and Types</a> |
							<a href="plate03.php">Leaf Shapes</a> |
							<a href="plate04.php">Leaf Margins</a> |
							<a href="plate05.php">Leaf Apices, Venation, and Bases</a> |
							<a href="plate06.php">Surface Features</a> |
							<a href="plate07.php">Stem and Leaf Parts, and Variations</a> |
							<a href="plate08.php">Inflorescence Types</a> |
							<a href="plate09.php">Floral Morpholog</a> |
							<a href="plate10.php">Corolla Types</a> |
							<a href="plate11.php">Fruit Types</a> |
							<a href="plate12.php">Sedges, Grasses, and Composites</a> |
							<a href="plate_all.php">All Plates</a> 
							</p>

							<div class="plate">
							<img src="<?php echo $clientRoot; ?>/images/vplants/plants/glossary/plate01.jpg" width="712" height="1055" 
							alt="Line drawings of plant features." 
							title="Plate 1: Stem and Root Types.">

							<h2>Plate 1: Stem and Root Types</h2>
							</div>
						</div>
					</div><!-- end of #content1 -->
					</div><!-- end of #content1wrap -->
				</div><!-- end of #wrapper1 -->
			</div><!-- end of #bodywrap -->
		</div><!-- end of #innertext -->

	<?php
	include($serverRoot."/footer.php");
	?> 

</body>
</html>