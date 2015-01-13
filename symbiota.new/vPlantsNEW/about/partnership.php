<?php
//error_reporting(E_ALL);
include_once('../config/symbini.php');
header("Content-Type: text/html; charset=".$charset);
?>
<html>
<head>
	<title><?php echo $defaultTitle?> About Us - vPlants Partnership</title>
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
            <h1>vPlants Partnership</h1>
			<div style="margin:20px;">
				<p>Under construction. Describe collaboration.</p>

            	<h2><a href="http://www.mortonarb.org/">The Morton Arboretum</a></h2>
				<p> The Morton Arboretum, a 1,700-acre botanical garden of trees and other plants, displays more than 3,300 kinds of plants from throughout the north temperate zone. These living collections are combined with 700 acres of oak woodland, reconstructed prairie, rare species habitat, and wetlands, presenting a showcase of horticultural and native plant diversity. The Arboretum and its staff are actively involved in regional, national and international conservation efforts.
				</p>
				<p>The Morton Arboretum, 
				  4100 IL Route 53, 
				  Lisle, IL   60532-4293, 
				  (630) 968-0074, 
				  www.mortonarb.org
				</p>
				
				<h2><a href="http://www.fieldmuseum.org/">The Field Museum</a></h2>
				<p>Using collections-based research and self-directed learning through exhibits and education programs, The Field Museum promotes greater public understanding and appreciation of the world in which we live. The Museum's expanding programs on the region's biological diversity help integrate natural riches into everyday life and culture. Regional inventory and population monitoring programs focus on species of conservation concern, or those that serve as sensitive indicators of the health of an ecological community.
				</p>
				<p>
				  The Field Museum of Natural History, 
				  1400 S. Lake Shore Drive, 
				  Chicago, IL   60605, 
				  (312) 922-9410, 
				  www.fieldmuseum.org 
				</p>
				
				<h2><a href="http://www.chicagobotanic.org/">Chicago Botanic Garden</a></h2>
				<p>Since its founding more than 30 years ago, the Chicago Botanic Garden has become a world-class cultural landmark. Owned by the Forest Preserve District of Cook County and managed by the Chicago Horticultural Society, the Garden spans 385 acres, features 23 garden areas, and serves over 700,000 visitors each year. The Garden's Skokie River restoration project is a permanent study site for streambank stabilization techniques, and Mary Mix McDonald Woods, a wet savanna and open oak woodland, is a nearly 100-acre restoration management project.
				</p>
				<p>
				  Chicago Botanic Garden, 
				  1000 Lake-Cook Road, 
				  P.O. Box 400, 
				  Glencoe, IL   60022, 
				  (847) 835-5440, 
				  www.chicagobotanic.org
				</p>
				
				<h2><a href="<?php echo $clientRoot; ?>/about/partner_other.php">Additional Partners and Affiliates</a></h2>
            </div>
        </div>

	<?php
	include($serverRoot."/footer.php");
	?> 

</body>
</html>