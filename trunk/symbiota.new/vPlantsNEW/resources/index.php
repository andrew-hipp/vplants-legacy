<?php
//error_reporting(E_ALL);
include_once('../config/symbini.php');
header("Content-Type: text/html; charset=".$charset);
?>
<html>
<head>
	<title><?php echo $defaultTitle?>vPlants - Resources</title>
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
            <h1>Resources</h1>

            <div style="margin:20px;">
            	<h3><a href="<?php echo $clientRoot; ?>/resources/regionherbaria.php">Region Herbaria</a></h3>
				<p>List of herbaria in the Chicago area and the upper Midwest.</p>
				
				<h3><a href="<?php echo $clientRoot; ?>/resources/docs.php">Documents</a></h3>
				<p>Links to web pages and documents. These are reference documents used by the vPlants partners, but may also be of use to the public.</p>
				
				<h3><a href="<?php echo $clientRoot; ?>/resources/biblio.php">References</a></h3>
				<p>This is a partial list of published bibliographic references that are commonly used and cited on the vPlants website.</p>
				
				<h3><a href="<?php echo $clientRoot; ?>/resources/links.php">Links</a></h3>
				<p>External links relating to plants and natural history education.</p>

            </div>
        </div>
		
		<div id="content2">


			<p class="small">Information provided on this page applies to the Chicago Region and may not be relevant or complete for other regions.</p><p class="small noprint"><a href="/disclaimer.html" title="Read Disclaimer.">Disclaimer</a></p>

		</div><!-- end of #content2 -->

	<?php
	include($serverRoot."/footer.php");
	?> 

</body>
</html>