<?php
//error_reporting(E_ALL);
include_once('../../config/symbini.php');
header("Content-Type: text/html; charset=".$charset);
?>
<html>
<head>
	<title><?php echo $defaultTitle?>vPlants - Glossary Poaceae</title>
	<link href="../../css/base.css" type="text/css" rel="stylesheet" />
	<link href="../../css/main.css" type="text/css" rel="stylesheet" />
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
            <h1>Glossary for Poaceae</h1>

            <div style="margin:20px;">
            	<p>For terms not listed here, see the <a href="index.php" title="Go to main glossary.">Plant Glossary</a>.</p>

				<div class="plate">
				<img src="<?php echo $clientRoot; ?>/images/vplants/plants/glossary/plate12_grass.jpg" width="703" height="367"
				alt="Line drawings of plant features." 
				title="Plate 12: Grasses.">
				</div>


				<dl id="glossdefs">

				<dt id="awn">Awn</dt>
				<dd>&#151; A stiff bristle situated at the tip of a glume or lemma.</dd>

				<dt id="caryopsis">Caryopsis</dt>
				<dd>&#151; A seed-like fruit with a thin outer wall; a grain.</dd>

				<dt id="collar">Collar</dt>
				<dd>&#151; The junction of the leaf sheath and blade.</dd>

				<dt id="culm">Culm</dt>
				<dd>&#151; The stem of a grass.</dd>

				<dt id="floret">Floret</dt>
				<dd>&#151; A single small flower, usually a member of a cluster, such as a spikelet or a head.</dd>

				<dt id="glume">Glume</dt>
				<dd>&#151; The lowest two (sometimes one) empty scales subtending the usually fertile scales in grass spikelets.</dd>

				<dt id="lemma">Lemma</dt>
				<dd>&#151; The lowermost of the two scales forming the floret in a grass spikelet -- the uppermost, less easily seen, is called the palea.</dd>

				<dt id="ligule">Ligule</dt>
				<dd>&#151; An extension, often scarious (papery), of the summit of the leaf sheath.</dd>

				<dt id="">Nerve</dt>
				<dd>&#151; Same as a vein. The central vein running lengthwise on a scale</dd>

				<dt id="">Node</dt>
				<dd>&#151; The point along a stem which gives rise to leaves, branches, or inflorescences.</dd>

				<dt id="palea">Palea</dt>
				<dd>&#151; The uppermost of the two scales forming the floret in a grass spikelet (often obscure or hidden).</dd>

				<dt id="">Rachilla</dt>
				<dd>&#151; A secondary rachis. The axis of a spikelet.</dd>

				<dt id="">Sheath</dt>
				<dd>&#151; A tubular structure effected by the formation of leaf margins around the stem. The base of a grass leaf that runs from the node up to the blade.</dd>

				<dt id="">Spikelet</dt>
				<dd>&#151; A secondary or small spike; specifically, in the Poaceae family, the unit composed or one or two glumes subtending one to several sets of lemma and palea combinations.</dd>

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