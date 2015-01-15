<?php
//error_reporting(E_ALL);
include_once($serverRoot."/config/symbini.php");
header("Content-Type: text/html; charset=".$charset);
?>
<html>
<head>
	<title><?php echo $defaultTitle?> vPlants - Plate 2 - Leaf Composition, Parts, and Types</title>
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
            <h1></h1>

            <div style="margin:20px;">
            	<p>
				<a href="index.html">Glossary List</a> | 
				<a href="plate01.html">Previous Plate</a> | 
				<a href="plate03.html">Next Plate</a>
				</p>

				<div class="plate">
				<img src="<?php echo $clientRoot; ?>/images.vplants/plants/glossary/plate02.jpg" width="712" height="1055" 
				alt="Line drawings of plant features." 
				title="Plate 2: Leaf Composition, Parts, and Types.">
				<h2>Plate 2: Leaf Composition, Parts, and Types</h2>
				</div>
            </div>
        </div>

	<?php
	include($serverRoot."/footer.php");
	?> 

</body>
</html>