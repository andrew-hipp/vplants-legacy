<?php
//error_reporting(E_ALL);
include_once('../config/symbini.php');
header("Content-Type: text/html; charset=".$charset);
?>
<html>
<head>
	<title><?php echo $defaultTitle?> Search</title>
	<link href="../css/base.css" type="text/css" rel="stylesheet" />
	<link href="../css/main.css" type="text/css" rel="stylesheet" />
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
            <h1>Search</h1>
			<div style="margin:20px;">
				<!-- add in chicago region search link using search tool but with pre-chosen parameters
				<div class="indexheading"><a href="<?php echo $clientRoot; ?>/collections/index.php" >Search Chicago Region</a></div>
            	<div class="indexdescription"><p>Search only the Chicago region.</p></div> -->
			
				<div class="indexheading"><a href="<?php echo $clientRoot; ?>/collections/index.php" >Search Collections</a></div>
            	<div class="indexdescription"><p>Search all collections.</p></div>
				
				<div class="indexheading"><a href="<?php echo $clientRoot; ?>/collections/map/mapinterface.php" target="_blank" >Map Search</a></div>
				<div class="indexdescription"><p>Search with a map.</p></div>
				
				<div class="indexheading"><a href="<?php echo $clientRoot; ?>/imagelib/imgsearch.php" >Image Search</a></div>
				<div class="indexdescription"><p>Search the images.</p></div>
            </div>
        </div>
		<!-- End of inner text -->

	<?php
	include($serverRoot."/footer.php");
	?> 

</body>
</html>