<?php
//error_reporting(E_ALL);
include_once($serverRoot."/config/symbini.php");
header("Content-Type: text/html; charset=".$charset);
?>
<html>
<head>
	<title><?php echo $defaultTitle?> vPlants - Plant Diversity</title>
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
            <h1>Plant Diversity in the Chicago Region</h1>

            <div style="margin:20px;">
            	<p>
				Despite the skyscrapers, expanses of concrete, heavy industry, and large population centers, the <strong>Chicago Region has a very diverse composition of plants</strong> (flora). See <a href="#table1" title="Table 1: Facts about the Chicago Region vascular flora.">Table 1</a> below. There are almost <strong>2,700 individual species of vascular plants</strong> found within this <strong>area of 30,557 square kilometers</strong> (11,798 square miles).  Compare that to the only 1,400 species that occur in the similarly sized country of Belgium (30,510 sq. km).  For a closer-to-home comparison, the state of West Virginia is about two times the size of the Chicago Region (62,361 sq. km) and there are only 2,344 vascular plant species recorded in that state. Of the nearly 3,000 taxa of vascular plants found in the Chicago Region, 55% of those plants are native. 
				</p>
				<p>Considering the land area and number of species in the Chicago Region, the area's diversity of vascular plant species (represented as the number of species per unit of area) is much higher than for many other temperate areas (<a href="diversity2.html" title="Table 2: Chicago Region flora compared to other temperate areas.">Table 2</a>).  In fact, the species diversity of the Chicago Region is closer to values found in the tropics where diversity tends to be at its highest (<a href="diversity2.html#table3" title="Table 3: Chicago Region flora compared to tropical areas.">Table 3</a>).
				</p>

				<p>
				Part of the reason the Chicago Region's flora is so diverse has to do with <a href="/chicago.html" title="Why the Chicago Region?">the geographic and geologic features</a> of the area.  
				</p>

				<p>
				<a id="table1" name="table1"></a>
				<table cellpadding="3" cellspacing="0" border="1">
				<caption>Table 1. Facts about the Chicago Region vascular flora.</caption>
				<thead>
				<tr ><th >Chicago Region vascular plants</th><th >Number</th><th >Comment</th></tr>
				</thead>
				<tbody>
				<tr><td><a href="index.html" title="Plant Directory">Vascular plant taxa</a> (species, subspecies, varieties)</td>
					<td align="center">approximately 3000</td>
					<td>almost 2700 species</td></tr>
				<tr><td><a href="/xsql/plants/famlist.xsql" title="Family Index">Families</a> represented</td>
					<td align="center">164</td>
					<td>&nbsp;</td></tr>
				<tr><td><a href="/xsql/plants/genlist.xsql" title="Genus Index">Genera</a> represented</td>
					<td align="center">895</td>
					<td>&nbsp;</td></tr>
				<tr><td><a href="/topics/origin.html" 
				title="Native plants.">Native plant taxa</a></td>
					<td align="center">approximately 1650</td>
					<td>55% of flora</td></tr>
				<tr><td><a href="/topics/distribution2.html" 
				title="Endemic plants of the Chicago Region.">Species endemic</a> to Chicago Region (grow nowhere else in world)</td>
					<td align="center">2</td>
					<td>plus 5 Great Lakes endemic taxa</td></tr>
				<tr><td><a href="/topics/concern.html" 
				title="Plants of Concern in the Chicago Region.">Threatened or endangered taxa</a></td>
					<td align="center">700</td>
					<td>23 % of flora, but 42 % of native taxa</td></tr>
				<tr><td><a href="/topics/origin2.html" 
				title="Alien plants.">Non-native (alien) taxa</a></td>
					<td align="center">approximately 1350</td>
					<td>45 % of flora</td></tr>
				<tr><td><a href="/topics/origin3.html" 
				title="Invasive plants.">Invasive taxa</a></td>
					<td align="center">approximately 150</td>
					<td>5 % of flora, 11% of all non-native taxa</td></tr>
				<tr ><td colspan="3" >
				Also read about 
				<a href="/topics/distribution3.html" 
				title="Disjunct plants of the Chicago Region.">disjunct plants</a>, 
				<a href="/topics/habitats.html" 
				title="Plant communities.">habitats</a>, or 
				 <a href="/plants/biology.html" 
				title="How plants grow.">biology</a>.
				</td></tr>
				</tbody>
				</table></p>
            </div>
        </div>
		
		<div id="content2"><!-- start of side content -->
		<!-- any image width should be 250 pixels -->
 
			<img src="../feature/panne.jpg" width="250" height="177" alt="">
			<div class="box imgtext">
			<p>A panne is a wet depression between dunes. It is one of many habitats that contribute to the diversity of life in the Chicago Region.</p>
			</div>

			<a href="/map.html" title="See State Map for Chicago Region."><img class="border"
			 src="../img/map_grtlakes_250.jpg" width="250" height="212"
			alt="The vPlants Region is located within four states at the south end of Lake Michigan." /></a>

			<div class="box">
			<h3>Related Pages</h3>
			<p>
			<a href="diversity2.html" title="Table 2: Chicago Region flora compared to other temperate areas.">Table 2: Flora compared to other temperate areas</a>
			</p><p>
			<a href="diversity2.html#table3" title="Table 3: Chicago Region flora compared to tropical areas.">Table 3: Flora compared to tropical areas</a>
			</p><p>
			<a href="index.html" title="Plant Directory.">What kinds of plants are included?</a>
			</p><p>
			<a href="/xsql/plants/famlist.xsql" title="List of Plant Families.">Family Index</a>
			</p><p>
			<a href="/xsql/plants/genidx.xsql" title="List of Plant Genera.">Genus Index</a>
			</p><p>
			<a href="/chicago.html" title="Why the Chicago Region?">Why focus on the Chicago Region?</a>
			</p><p>
			<a href="/map.html" title="See State Map for Chicago Region.">Map of Chicago Region</a>
			</p>
			</div>

			<p class="small">Information provided on this page applies to the Chicago Region and may not be relevant or complete for other regions.</p><p class="small noprint"><a href="/disclaimer.html" title="Read Disclaimer.">Disclaimer</a></p>

		</div>

	<?php
	include($serverRoot."/footer.php");
	?> 

</body>
</html>