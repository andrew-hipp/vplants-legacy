<?php
//error_reporting(E_ALL);
include_once($serverRoot."/config/symbini.php");
header("Content-Type: text/html; charset=".$charset);
?>
<html>
<head>
	<title><?php echo $defaultTitle?>vPlants - Help with Searching</title>
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
            <h1>Help with Searching</h1>

            <div style="margin:20px;">
            	<p>
				&nbsp;
				</p>
				<h3>In preparation</h3>

				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
            </div>
        </div>
		
		<div id="content2"><!-- start of side content -->
			<p class="hide">
			<a id="secondary" name="secondary"></a>
			<a href="#sitemenu">Skip to site menu.</a>
			</p>

			<!-- image width is 250 pixels -->
			<div class="box">

			<h3>Related Pages</h3>

			<p>
			<a href="/search.html" 
			 title="Search by Location, Collector, and more.">Go to Advanced Search</a>
			</p>
			</div>

			<div id="simpleform">
			<form
			 name="simple"
			 method="post"
			 action="/xsql/plants/findtaxa.xsql">

			<fieldset><legend title="Enter name of plant in one or more of the search fields.">Name Search</legend>

			<!--
			<label class="radios" for="plant" title="Only Plant data is currently available.">Plant</label>
			-->

			<!-- 
			<p class="radios"><span title="Select Plant or Fungus.">Group:</span>
			<input id="plant" name="group" type="radio" checked="checked" 
			 tabindex="101" value="plant" />
			<label for="plant" title="Select Plant Collections.">Plant</label>
			<input id="fungus" name="group" type="radio" 
			 tabindex="102" value="fungus" />
			<label for="fungus" title="Select Fungus Collections.">Fungus</label>
			</p>
			 -->

			<div class="texts">
			<p><label for="family" accesskey="4" 
			 title="Example: Ulmaceae.">Family: 
			<input id="family" name="family" type="text" maxlength="40" 
			 tabindex="103" title="Enter name of a family [one word, can use first several letters]." value="" /></label>
			</p>
			<p><label for="genus"  
			 title="Example: Ulmus.">Genus: 
			<input id="genus" name="genus" type="text" maxlength="30" 
			 tabindex="104" title="Enter name of a genus [one word, can use first several letters]." value="" /></label>
			</p>
			<p><label for="species" 
			 title="Example: americana.">Species Epithet: 
			<input id="species" name="species" type="text" maxlength="30" 
			 tabindex="105" title="Enter the species epithet, or subspecies, or variety [one word]." value="" /></label>
			</p>
			<p><label for="common" 
			 title="Example: american elm.">Common Name: 
			<input id="common" name="common" type="text" maxlength="50" 
			 tabindex="106" title="Enter a common name [can use more than one word]." value="" /></label>
			</p>
			</div>

			<p class="actions">
			<input id="submit" name="submit" type="submit" value="Search"
			 tabindex="107" title="Perform Search." />
			</p>
			<p>
			[ Fungus data not yet available. ]
			</p>
			</fieldset>

			</form>
			</div>


			<p class="small">
			Information provided on this page applies to the Chicago Region and may not be relevant or complete for other regions.</p>
			<p class="small">
			<a class="popup" href="/disclaimer.html" 
			title="Read Disclaimer [opens new window]." 
			onclick="window.open(this.href, 'disclaimer', 
			'width=500,height=350,resizable,top=100,left=100');
			return false;" 
			onkeypress="window.open(this.href, 'disclaimer', 
			'width=500,height=350,resizable,top=100,left=100');
			return false;">Disclaimer</a>
			</p>

		</div><!-- end of #content2 -->

	<?php
	include($serverRoot."/footer.php");
	?> 

</body>
</html>