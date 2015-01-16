<?php
//error_reporting(E_ALL);
include_once('../../config/symbini.php');
header("Content-Type: text/html; charset=".$charset);
?>
<html>
<head>
	<title><?php echo $defaultTitle?> Home</title>
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
        <div id="innertext">
            <h1></h1>

            <div style="margin:20px;">
            	<p>
				<a href="index.php">Back to Glossary List</a> | 
				<a href="plate02.php">Next Plate</a>
				</p>

				<div class="plate">
				<img src="<?php echo $clientRoot; ?>/images/vplants/plants/glossary/plate01.jpg" width="700" height="1055" 
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