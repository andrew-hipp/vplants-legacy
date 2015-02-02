<?php
//error_reporting(E_ALL);
include_once('../config/symbini.php');
header("Content-Type: text/html; charset=".$charset);
?>
<html>
<head>
	<title><?php echo $defaultTitle; ?>vPlants - vPlants Documents</title>
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
						<h1>Plant Documents</h1>

						<div style="margin:20px;">
							<p>Links to web pages for each document. These are reference documents used by the vPlants partners, but may also be of use to the public.</p>

							<h2>Web page with download:</h2>

							<ol>
							<li>
							<h3><a href="plant_checklist.php" 
							title="Scientific Name Checklist.">Taxon Checklist</a></h3>
							<p>
							 vPlants Scientific Name Checklist of all plant species, subspecies and varieties included in vPlants.
							</p>
							</li><li>
							<h3><a href="plant_concern.php" 
							title="Chicago Region Plants of Concern.">Plants of Concern</a></h3>
							<p>
							 All Chicago Region vascular plants currently listed as endangered, threatened, rare, etc.
							</p>
							</li><li>
							<h3><a href="plant_invasive.php" 
							title="Chicago Region Invasive Plants.">Invasive Plants</a></h3>
							<p>
							 All non-native (alien) vascular plants that are considered invasive in the Chicago Region.
							</p>
							</li><li>
							<h3><a href="plant_terms.php" 
							title="vPlants Accepted Plant Terms.">Accepted Plant Terms</a></h3>
							<p>
							 A list of the plant terms that are acceptable for use in the vPlants species descriptions.
							</p>
							</li>
							</ol>

							<!-- 
							<h2>Other Documents for Plants</h2>

							<p>...</p>
							-->
						</div>
					</div><!-- end of #content1 -->
					</div><!-- end of #content1wrap -->
		
					<div id="content2">
						
						<div class="box">
							<h3>Plant Documents</h3>
							<ul>
								<li><strong>Plant Documents Main</strong></li>
								<li><a href="plant_checklist.php">Taxon Checklist</a></li>
								<li><a href="plant_concern.php">Plants of Concern</a></li>
								<li><a href="plant_invasive.php">Invasive Plants</a></li>
								<li><a href="plant_terms.php">Accepted Plant Terms</a></li>
							</ul>
						</div>

						<div class="box external">
							<h3>Related Web Sites</h3>
							<ul><li><a href="http://geo.usace.army.mil/wetland_plants/index.html" 
							title="External link.">Entry page for the National Wetland Plant List</a></li>
							</ul>
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