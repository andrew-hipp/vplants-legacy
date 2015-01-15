<?php
//error_reporting(E_ALL);
include_once('../config/symbini.php');
header("Content-Type: text/html; charset=".$charset);
?>
<html>
<head>
	<title><?php echo $defaultTitle?> About Us - Chicago Region - State Map</title>
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
				<div class="submenuitem">
					<strong>State Map</strong>
				</div>
				<div class="submenuitem">
					<a href="<?php echo $clientRoot; ?>/about/map_county.php">County Map</a>
				</div>
			<div class="menuitem">
				<a href="<?php echo $clientRoot; ?>/about/partnership.php">
					vPlants Partnership
				</a>
			</div>
			<div class="menuitem">
				<a href="<?php echo $clientRoot; ?>/about/contact.php">
					Contact Us
				</a>
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
            <h1>State Map for Chicago Region</h1>

            <div style="margin:20px;">
            	<p>
				vPlants is centered on the Chicago Region at the southern end of Lake Michigan. The area covers southeastern Wisconsin, northeastern Illinois, northwestern Indiana, and the southwest corner of Michigan. 
				</p>
 
				<p><img src="<?php echo $clientRoot; ?>/images/vplants/img/map_grtlakes.jpg" width="550" height="608" alt="Map of the vPlants Region and western Great Lakes"></p>
            </div>
        </div>

	<?php
	include($serverRoot."/footer.php");
	?> 

</body>
</html>