<?php
//error_reporting(E_ALL);
include_once($serverRoot."/config/symbini.php");
header("Content-Type: text/html; charset=".$charset);
?>
<html>
<head>
	<title><?php echo $defaultTitle?> Contact</title>
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
            <h1>Contact Us</h1>
			<div style="margin:20px;">

			<h2>Under construction</h2>

            <div style="margin:20px;">
            	<p>Excuse the dust.  We are moving and adding new content.</p>
				
				<p>The primary contact is <a href="http://systematics.mortonarb.org/lab">Andrew Hipp</a>, The Morton Arboretum.</p>

				<p>We welcome suggestions on how to improve this site and to 
					correct errors! And, we are always looking for new partners, volunteers, 
					and supporters!</p>

				<p>&nbsp;</p>
				<p>&nbsp;</p>
            </div>
        </div>

	<?php
	include($serverRoot."/footer.php");
	?> 

</body>
</html>