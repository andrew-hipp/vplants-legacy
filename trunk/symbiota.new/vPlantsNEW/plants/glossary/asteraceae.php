<?php
//error_reporting(E_ALL);
include_once($serverRoot."/config/symbini.php");
header("Content-Type: text/html; charset=".$charset);
?>
<html>
<head>
	<title><?php echo $defaultTitle?> vPlants - Glossary Asteraceae</title>
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
            <h1>Glossary for Asteraceae</h1>

            <div style="margin:20px;">
            	<p>For terms not listed here, see the <a href="index.html" title="Go to main glossary.">Plant Glossary</a>.</p>

				<div class="plate">
				<img src="<?php echo $clientRoot; ?>/images.vplants/plants/glossary/plate12_comp.jpg" width="703" height="424"
				alt="Line drawings of plant features." 
				title="Plate 12: Composites.">
				</div>

				<dl id="glossdefs">

				<dt id="achene">Achene</dt>
				<dd>&#151; A hard, one-seeded, <a href="index.html#indehiscent">indehiscent</a> <a href="index.html#nutlet">nutlet</a> with a tight <a href="index.html#pericarp">pericarp</a>. An example is the sunflower seed in the shell (pericarp).</dd>

				<dt id="biseriate">Biseriate</dt>
				<dd>&#151; Having two series, or rows, of parts; having two rows or sets of <a href="#phyllary">phyllaries</a> (bracts) on the involucre.</dd>

				<dt id="claw">Claw</dt>
				<dd>&#151; The narrowed base of the <a href="index.html#corolla">corolla</a> of a <a href="#rayflower">ray flower</a>.</dd>

				<dt id="crown">Crown</dt>
				<dd>&#151; In the Asteraceae family, <a href="index.html#scale">scales</a> or <a href="index.html#awn">awns</a> at the summit of an <a href="#achene">achene</a>.</dd>

				<dt id="disk">Disk or disc</dt>
				<dd>&#151; The central portion of a <a href="index.html#capitate">capitate</a> <a href="#inflorescence">inflorescence</a>, or the <a href="#receptacle">receptacle</a> of such an <a href="#inflorescence">inflorescence</a>.</dd>

				<dt id="diskflower">Disk flowers</dt>
				<dd>&#151; The central, <a href="index.html#tubular">tubular</a> flowers of the <a href="#head">head</a>. Compare <a href="#rayflower">ray flower</a>.</dd>

				<dt id="floret">Floret</dt>
				<dd>&#151; A single small flower, usually a member of a cluster, such as a <a href="#head">head</a>; see <a href="#diskflower">disk flower</a> and <a href="#rayflower">ray flower</a>.</dd>

				<dt id="head">Head</dt>
				<dd>&#151; A dense, compact cluster of mostly <a href="index.html#sessile">sessile</a> flowers, used to describe the inflorescence in the Asteraceae family.</dd></dd>

				<dt id="imbricate">Imbricate</dt>
				<dd>&#151; Having <a href="#phyllary">phyllaries</a> (bracts) on the involucre that overlap each other like roof shingles.</dd>

				<dt id="inflorescence">Inflorescence</dt>
				<dd>&#151; The discrete flowering portion or portions of a plant; a flower cluster.</dd>

				<dt id="involucre">Involucre</dt>
				<dd>&#151; A <a href="index.html#whorl">whorl</a> or <a href="#imbricate">imbricated</a> series of <a href="index.html#bract">bracts</a>, often appearing somewhat <a href="index.html#calyx">calyx</a>-like, typically <a href="index.html#subtend">subtending</a> the <a href="#head">head</a>.</dd>

				<dt id="ligulate">Ligulate</dt>
				<dd>&#151; Bearing a <a href="#ligule">ligule</a>.</dd>

				<dt id="ligule">Ligule</dt>
				<dd>&#151; The <a href="index.html#dilated">dilated</a> or flattened, spreading <a href="#limb">limb</a> of the composite <a href="#ray">ray flower</a>.</dd>

				<dt id="limb">Limb</dt>
				<dd>&#151; The expanded portion of a <a href="index.html#corolla">corolla</a> above the throat; the expanded portion of any petal.</dd>

				<dt id="pappus">Pappus</dt>
				<dd>&#151; A modification of the <a href="index.html#calyx">calyx</a>, usually in the Asteraceae family, such that the <a href="index.html#segment">segments</a> appear as a low <a href="#crown">crown</a>, a ring of <a href="index.html#scale">scales</a>, or fine hairs.</dd>

				<dt id="peduncle">Peduncle</dt>
				<dd>&#151; The stalk which supports a <a href="#head">head</a>.</dd>

				<dt id="phyllary">Phyllary</dt>
				<dd>&#151; A <a href="index.html#bract">bract</a> of the <a href="#involucre">involucre</a>.</dd>

				<dt id="ray">Ray</dt>
				<dd>&#151; A strap-shaped, <a href="#ligulate">ligulate</a>, typically <a href="index.html#margin">marginal</a>, flower in the <a href="#head">head</a> of a composite <a href="#inflorescence">inflorescence</a>.</dd>

				<dt id="rayflower">Ray flower</dt>
				<dd>&#151; A strap-shaped, <a href="#ligulate">ligulate</a>, typically <a href="index.html#margin">marginal</a>, flower in the head of a composite <a href="#inflorescence">inflorescence</a>. Also called <a href="#ligulate">ligulate</a> flower. Compare to <a href="#diskflower">disk flower</a>.</dd>

				<dt id="receptacle">Receptacle</dt>
				<dd>&#151; An enlarged or <a href="index.html#elongate">elongated</a> base of a <a href="#head">head</a> on which the flowers are borne.</dd>

				<dt id="staminaltube">Staminal tube</dt>
				<dd>&#151; The <a href="index.html#stamen">stamens</a> of a composite flower united into a ring.</dd>

				<dt id="uniseriate">Uniseriate</dt>
				<dd>&#151; Having only one series, or row, of parts; having only one row of <a href="#phyllary">phyllaries</a> (bracts) on the involucre.</dd>
            </div>
        </div>

	<?php
	include($serverRoot."/footer.php");
	?> 

</body>
</html>