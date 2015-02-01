<?php
//error_reporting(E_ALL);
include_once('../../config/symbini.php');
header("Content-Type: text/html; charset=".$charset);
?>
<html>
<head>
	<title><?php echo $defaultTitle?>vPlants - Plate 7 - Stem and Leaf Parts, and Variations</title>
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
				<a href="plate06.php">Previous Plate</a> | 
				<a href="plate08.php">Next Plate</a>
				</p>

				<div class="plate">
				<img src="<?php echo $clientRoot; ?>/images/vplants/plants/glossary/plate07.jpg" width="733" height="1055" 
				alt="Line drawings of plant features." 
				title="Plate 7: Stem and Leaf Parts, and Variations.">
				<h2>Plate 7: Stem and Leaf Parts, and Variations</h2>
				</div>
            </div>
        </div>

	<?php
	include($serverRoot."/footer.php");
	?> 

</body>
</html>