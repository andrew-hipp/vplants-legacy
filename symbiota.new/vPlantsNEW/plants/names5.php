<?php
//error_reporting(E_ALL);
include_once('../config/symbini.php');
header("Content-Type: text/html; charset=".$charset);
?>
<html>
<head>
	<title><?php echo $defaultTitle?>About Plants - Names - Taxonomy</title>
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
            <h1>Taxonomy</h1>

            <div style="margin:20px;">
            	<p>Taxonomy is the classification of organisms into categories based on shared characteristics. It is closely tied to nomenclature, the practice of naming things.  Scientific names for plants and fungi follow the rules of the International Code of Botanical Nomenclature. For animals, the International Code of Zoological Nomenclature is used. There is also the International Code of Nomenclature of Bacteria. When a new species or organism is discovered, it is named based upon the rules of these codes.  Because these two sets of rules are independent there are occasionally the same names used for both animals and plants or fungi. For example, <i>Lactarius</i> is a genus of milk mushrooms, but <i>Lactarius</i> is also an economically important milkfish in the Indian Ocean.</p>
            </div>
        </div>
		
		<div id="content2">

			<div class="box document">
			<h3>....</h3>
			<ul><li>
			<!-- put blurb here about Carolus Linnaeus, father of binomial nomenclature -->
			</li></ul>
			</div>

			<div class="box external">
			<h3>....</h3>
			<ul>
			<li>
			<!-- link to standard author abbreviations -->

			</li>
			</ul>
			</div>

			<p class="small">Information provided on this page applies to the Chicago Region and may not be relevant or complete for other regions.</p><p class="small noprint"><a href="../disclaimer.php" title="Read Disclaimer.">Disclaimer</a></p>

		</div><!-- end of #content2 -->

	<?php
	include($serverRoot."/footer.php");
	?> 

</body>
</html>