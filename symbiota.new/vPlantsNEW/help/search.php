<?php
//error_reporting(E_ALL);
include_once($serverRoot."/config/symbini.php");
header("Content-Type: text/html; charset=".$charset);
?>
<html>
<head>
	<title><?php echo $defaultTitle?> vPlants - Help with Searching</title>
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
        <div  id="innervplantstext">
            <h1>Help with Searching</h1>

            <div style="margin:20px;">
            	<p>Choose whether you are looking for plants or fungi. The plant and fungus data are treated separately on this website.</p> 
				<p>Search words can be entered in lowercase or uppercase. Search terms will match the beginnings of words, and is useful for shorthand or uncertain spelling. Fungus Family: <kbd>hygro</kbd> will find <i>Hygrophoraceae</i>, but Fungus Genus: <kbd>hygro</kbd> will find <i>Hygrocybe</i>, <i>Hygrophorus</i>, and <i>Hygrophoropsis</i>. This is also helpful with Latin endings; use Epithet: <kbd>tomentos</kbd> to match <i>tomentosa</i>, <i>tomentosum</i>, and <i>tomentosus</i>.</p>

				<h2>Using simple Name Search</h2>

				<p>Use the Name Search form, such as on this page or on the home page, to look up the name or family of a plant or fungus.</p>

				<p>If you enter a genus name, you do not need a family name.</p>
				<p>Some species may or may not have hyphenated epithets, for example: <i>Aster novae-angliae</i> and <i>Carex laevivaginata</i>.
				In this case one may have to search twice: with and without a hyphen.
				But it is simpler to just search on the first part of the epithet (i.e., search <kbd>novae</kbd> for <i>novae-angliae</i>; or <kbd>laevi</kbd> for <i>laevivaginata</i>).</p>
				<p>The <a href="/search.html">Advanced Search</a> can be used if you are looking for a particular subspecies, variety or form.</P.

				<p>Searching by Common Name is less reliable because not all common names are included and some are used for multiple species. Multiple word common names must match each word you enter. It is simpler to use <kbd>elm</kbd> to find american elm, rock elm, etc.</p>

				<h2>Using Advanced Search</h2>

				<p>Use the <a href="/search.html">Advanced Search</a> to find specimens by particular collectors, dates, or locations.
				Many records, especially older ones, do not have complete collection data. For example, old records may only have the year indicated, or very little locality information, such as only the state.</p>

				<p>If searching by county, you do not need a state, except for Lake County, Illinois and Lake County, Indiana. Note that all county names are one word (DuPage, LaPorte) except for St. Joseph.</p>

				<p>When searching collector names, the suffixes (Sr., Jr., III, etc.) are best left off.</p>
				<p>Collection Day needs to be two digits; use <kbd>04</kbd> instead of <kbd>4</kbd>.</p>

				<p>The results page shows the names for those plants or fungi that have specimens that match your search values. Selecting the Specimens link on the search results page for a name will list the specimens that match your search. It does not show all specimens for that name.</p>
            </div>
        </div>

	<?php
	include($serverRoot."/footer.php");
	?> 

</body>
</html>