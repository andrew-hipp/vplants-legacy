<?php
//error_reporting(E_ALL);
include_once($serverRoot."/config/symbini.php");
header("Content-Type: text/html; charset=".$charset);
?>
<html>
<head>
	<title><?php echo $defaultTitle?>vPlants - Resources - Related Links</title>
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
            <h1>Related Links</h1>

            <div style="margin:20px;">
            	<h2>Natural History Education</h2>

				<h3>Illinois</h3>
				<ul>
				 <li><a href="http://www.mortonarb.org/main.taf?p=4,2,5,2">Naturalist Certificate Program</a></li>
				 <li><a href="http://www.mortonarb.org/main.taf?p=4">The Morton Arboretum</a></li>
				 <li><a href="http://www.fieldmuseum.org/education/">The Field Museum</a></li>
				 <li><a href="http://www.chicagobotanic.org/education/">Chicago Botanic Garden</a></li>
				</ul>

				<h3>Indiana</h3>
				<ul>
				 <li><a href="http://www.in.gov/dnr/masternaturalist/">Indiana Master Naturalist Program</a></li>
				</ul>
            </div>
        </div>
		
	<div id="content2">

		<div class="box external">
		<h3>vPlants Partners</h3>
		<ul><li><a href="http://www.mortonarb.org">The Morton Arboretum</a></li>
		<li><a href="http://www.fieldmuseum.org">The Field Museum</a></li>
		<li><a href="http://www.chicagobotanic.org">Chicago Botanic Garden</a></li>
		 <li><a href="http://www.chias.org/">Chicago Academy of Sciences [Notebaert Nature Museum]</a></li>
		<li><a href="http://www.inhs.uiuc.edu">Illinois Natural History Survey</a></li>
		</ul>
		</div>

		<div class="box external">
		<h3>vPlants Affiliates</h3>
		<ul><li><a href="http://www.chicagowilderness.org/">Chicago Wilderness</a></li>
		</ul>
		</div>

		<div class="box">
		<h3>vPlants funded by</h3>
		<ul><li><a href="http://www.imls.gov">Institute of Museum and Library Service</a></li>
		</ul>
		</div>

		<p class="small">Information provided on this page applies to the Chicago Region and may not be relevant or complete for other regions.</p><p class="small noprint"><a href="/disclaimer.html" title="Read Disclaimer.">Disclaimer</a></p>

	</div><!-- end of #content2 -->

	<?php
	include($serverRoot."/footer.php");
	?> 

</body>
</html>