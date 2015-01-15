<?php
//error_reporting(E_ALL);
include_once('../config/symbini.php');
header("Content-Type: text/html; charset=".$charset);
?>
<html>
<head>
	<title><?php echo $defaultTitle?> About Us - Contact</title>
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
		<!-- Left menu begins -->
		<div class="menu">
			<div class="menuheader">
				<a href="<?php echo $clientRoot; ?>/about/index.php">
					About Us
				</a>
			</div>
			<div class="menuitem">
				<a href="<?php echo $clientRoot; ?>/about/vplants.php">
					vPlants Project
				</a>
			</div>
			<div class="menuitem">
				<a href="<?php echo $clientRoot; ?>/about/chicago.php">
					Chicago Region
				</a>
			</div>
			<div class="menuitem">
				<a href="<?php echo $clientRoot; ?>/about/partnership.php">
					vPlants Partnership
				</a>
			</div>
			<div class="menuitem">
				<strong>
					Contact Us
				</strong>
			</div>
			<div class="menuitem">
				<a href="<?php echo $clientRoot; ?>/about/credits.php">
					Credits
				</a>
			</div>
		</div>
		<!-- Left menu ends -->
		
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
		
		<!-- start of side content -->
		<div id="content2">
			<!-- any image width should be 250 pixels -->

			<div class="box">
			<h3>vPlants is growing</h3>
			<p ><img src="../feature/250_prairie.jpg" width="210" height="291" alt="Prairie near Chicago."></p>
			</div>

			<p class="small">Information provided on this page applies to the Chicago Region and may not be relevant or complete for other regions.</p><p class="small noprint"><a href="/disclaimer.html" title="Read Disclaimer.">Disclaimer</a></p>

		</div><!-- end of #content2 -->

	<?php
	include($serverRoot."/footer.php");
	?> 

</body>
</html>