<?php
//error_reporting(E_ALL);
include_once('../config/symbini.php');
header("Content-Type: text/html; charset=".$charset);
?>
<html>
<head>
	<title><?php echo $defaultTitle; ?>Plants - Origin - Invasive Plants</title>
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
		<!-- start of inner text and right side content -->
		<div  id="innervplantstext">
			<div id="bodywrap">
				<div id="wrapper1"><!-- for navigation and content -->

					<!-- PAGE CONTENT STARTS -->

					<div id="content1wrap"><!--  for content1 only -->

					<div id="content1"><!-- start of primary content --><a id="pagecontent" name="pagecontent"></a>
						<h1>Invasive Plants</h1>

						<div style="margin:20px;">
							<p>In North America many invasive plant species were introduced purposely as either ornamental garden plants, or for use as land stabilizers (i.e. along steep slopes, riverbanks, or floodplains).  Others were accidentally introduced with seeds of agricultural or horticultural crops. Invasive plant species are incredibly threatening to natural communities because they spread very quickly, alter the natural balance of habitats to change plant and animal communities, lead to a decrease in plant diversity, and deplete natural resources. It is often very difficult to eradicate invasive species.</p>

							<p>The spread of invasives is an immense threat throughout the world.  In the United States, invasive species are the top threat to the preservation of natural ecosystems in the National Park System.  In the Chicago Region, about 11% of the approximately 1350 non-native plant species are considered invasive.  The description pages for all taxa we consider invasive are marked at the top, as well as in the regional occurrence section.</p>
						</div>
					</div><!-- end of #content1 -->
					</div><!-- end of #content1wrap -->
		
					<div id="content2">
						
						<div class="box">
							<h3>Plants Origin</h3>
							<ul>
								<li><a href="origin.php">Origin Main</a></li>
								<li><a href="origin4.php">Native species</a></li>
								<li><a href="origin2.php">Non-native species</a></li>
								<li><strong>Invasive species</strong></li>
							</ul>
						</div>

						<img src="<?php echo $clientRoot; ?>/images/vplants/feature/LYSA2.jpg" width="250" height="366" alt="purple flowered plant in wetland" title="Lythrum salicaria">
						<div class="box imgtext">
						<p>Purple loosestrife, <a href="../taxa/index.php?taxon=Lythrum%20salicaria"><i>Lythrum salicaria</i></a>, is an incredibly harmful invasive plant that was introduced to North America from Eurasia and has spread into wetlands across the continent.</p>
						</div>

						<div class="box document">
						<h3>Related Documents</h3>
						<ul><li>
						<a href="../resources/plant_invasive.php">Chicago Region Invasive Plant List</a>
						</li></ul>
						</div>

						<p class="small">Information provided on this page applies to the Chicago Region and may not be relevant or complete for other regions.</p><p class="small noprint"><a href="<?php echo $clientRoot; ?>/disclaimer.php" title="Read Disclaimer.">Disclaimer</a></p>

					</div><!-- end of #content2 -->
				</div><!-- end of #wrapper1 -->
			</div><!-- end of #bodywrap -->
		</div><!-- end of #innervplantstext -->

	<?php
	include($serverRoot."/footer.php");
	?> 

</body>
</html>