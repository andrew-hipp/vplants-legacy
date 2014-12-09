<?php
//error_reporting(E_ALL);
include_once($serverRoot."/config/symbini.php");
header("Content-Type: text/html; charset=".$charset);
?>
<html>
<head>
	<title><?php echo $defaultTitle?> vPlants - Glossary Cyperaceae</title>
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
            <h1>Glossary for Cyperaceae</h1>

            <div style="margin:20px;">
            	<p>For terms not listed here, see the <a href="index.html" title="Go to main glossary.">Plant Glossary</a>.</p>

				<div class="plate">
				<img src="plate12_sedge.jpg" width="703" height="385" 
				alt="Line drawings of plant features." 
				title="Plate 12: Sedges.">
				</div>

				<dl id="glossdefs">

				<dt id="achene">Achene</dt>
				<dd>&#151; A hard, one-seeded, <a href="index.html#indehiscent">indehiscent</a> <a href="index.html#nutlet">nutlet</a> with a tight <a href="index.html#pericarp">pericarp</a>.</dd>

				<dt id="bract">Bract</dt>
				<dd>&#151; A reduced leaf or <a href="#scale">scale</a>, typically one which <a href="index.html#subtend">subtends</a> a <a href="index.html#pedicel">pedicel</a> or <a href="#inflorescence">inflorescence</a>, but it also can refer to minute leaves on a stem.</dd>

				<dt id="bristle">Bristle</dt>
				<dd>&#151; A stiff hair.</dd>

				<dt id="culm">Culm</dt>
				<dd>&#151; The stem of grasses, sedges, and rushes.</dd>

				<dt id="inflorescence">Inflorescence</dt>
				<dd>&#151; The discrete flowering portion or portions of a plant; a flower cluster.</dd>

				<dt id="perianth">Perianth</dt>
				<dd>&#151; Pertaining to the floral series of <a href="index.html#sepal">sepals</a>, <a href="index.html#petal">petals</a>, or both, spoken of collectively.</dd>

				<dt id="perianthbristle">Perianth bristles</dt>
				<dd>&#151; Pertaining to <a href="#perianth">perianth</a> parts (petals, sepals) that are reduced to a set of bristles.</dd>

				<dt id="perigynium">Perigynium</dt>
				<dd>&#151; Referring specifically to the often <a href="index.html#inflated">inflated</a> <a href="index.html#sac">sac</a> which encloses the <a href="index.html#ovary">ovary</a>, and later the <a href="#achene">achene</a> in the genus <i>Carex</i>.</dd>

				<dt id="pistillate">Pistillate</dt>
				<dd>&#151; Referring to flowers or <a href="#spikelet">spikelets</a> which bear <a href="index.html#pistil">pistils</a> but not <a href="index.html#stamen">stamens</a>.</dd>

				<dt id="scale">Scale</dt>
				<dd>&#151; Generally a thin, sometimes papery, much reduced, leaf, <a href="#bract">bract</a>, or <a href="#perianth">perianth</a> part.</dd>

				<dt id="spikelet">Spikelet</dt>
				<dd>&#151; A <a href="index.html#secondary">secondary</a> or small <a href="index.html#spike">spike</a> of flowers.</dd>

				<dt id="staminate">Staminate</dt>
				<dd>&#151; Referring unisexual flowers or <a href="#spikelet">spikelets</a> which bear <a href="index.html#stamen">stamens</a> but not <a href="index.html#pistil">pistils</a>.</dd>

				<!-- <dt id=""></dt>
				<dd>&#151; </dd> -->
				</dl>
            </div>
        </div>

	<?php
	include($serverRoot."/footer.php");
	?> 

</body>
</html>