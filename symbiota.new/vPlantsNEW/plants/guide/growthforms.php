<?php
//error_reporting(E_ALL);
include_once($serverRoot."/config/symbini.php");
header("Content-Type: text/html; charset=".$charset);
?>
<html>
<head>
	<title><?php echo $defaultTitle?>vPlants - Guide to Plants, Growth Form</title>
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
            <h1>Key to Vascular Plants</h1>

            <div style="margin:20px;">
            	<p class="small">This guide applies to the Chicago Region and is not complete for other regions. <span class="noprint"><a href="/disclaimer.html" title="Read Disclaimer.">Disclaimer</a></span></p>

				<table class="key blocks" cellpadding="0" cellspacing="10" border="0">
				<caption>Step 1: Growth Form.</caption>
				<tbody>

				<tr>
				<td>
				<p>
				Trees and shrubs.
				</p>
				<img src="<?php echo $clientRoot; ?>/images.vplants/plants/guide/temp/tree.jpg" width="190" height="258" alt="">
				</td><td>
				<p>
				Herbs and wildflowers.
				</p>
				<img src="<?php echo $clientRoot; ?>/images.vplants/plants/guide/temp/herb.jpg" width="190" height="258" alt="">
				</td><td>
				<p>
				Grass-like plants.
				</p>
				<img src="<?php echo $clientRoot; ?>/images.vplants/plants/guide/temp/grass.jpg" width="190" height="258" alt="">
				</td>
				</tr>

				<tr>
				<td>
				<p>
				Ferns and horsetails.
				</p>
				<img src="<?php echo $clientRoot; ?>/images.vplants/plants/guide/temp/fern.jpg" width="190" height="258" alt="">
				</td><td>
				<p>
				Aquatic plants.
				</p>
				<img src="<?php echo $clientRoot; ?>/images.vplants/plants/guide/temp/aquatic.jpg" width="190" height="258" alt="">
				</td><td>
				<p>
				Vines and climbing plants.
				</p>
				<img src="<?php echo $clientRoot; ?>/images.vplants/plants/guide/temp/vine.jpg" width="190" height="258" alt="">
				</td>
				</tr>

				</tbody>
				</table>
            </div>
        </div>

	<?php
	include($serverRoot."/footer.php");
	?> 

</body>
</html>