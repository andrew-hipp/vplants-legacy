<?php
//error_reporting(E_ALL);
include_once($serverRoot."/config/symbini.php");
header("Content-Type: text/html; charset=".$charset);
?>
<html>
<head>
	<title><?php echo $defaultTitle?>vPlants - Guide to Pluteus</title>
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
            <h1>Guide to Pluteus</h1>

            <div style="margin:20px;">
            	<div class="floatimg"><img src="<?php echo $clientRoot; ?>/images.vplants/fungi/guide/PLUT/PLUTCERV.po.jpg" width="250" height="336" alt=""></div>

				<p class="small">This guide applies to the Chicago Region and is not complete for other regions. <span class="noprint"><a href="/disclaimer.html" title="Read Disclaimer.">Disclaimer</a></span></p>

				<p>...</p>
            </div>
        </div>

	<?php
	include($serverRoot."/footer.php");
	?> 

</body>
</html>