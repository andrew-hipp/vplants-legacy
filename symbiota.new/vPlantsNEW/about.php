<?php
//error_reporting(E_ALL);
include_once($serverRoot."/config/symbini.php");
header("Content-Type: text/html; charset=".$charset);
?>
<html>
<head>
	<title><?php echo $defaultTitle?>vPlants - About Us</title>
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
            <h1>About Us: The vPlants Project</h1>

            <div style="margin:20px;">
            	<p>
				Three major botanical institutions, the Field Museum of Natural History, The Morton Arboretum, and the Chicago Botanic Garden have developed an online, searchable database (vPlants or "virtual Plants") that provides free plant specimen data and digital images of specimens to anyone with Internet access.
				</p>
				<p>The project began in January 2001. Users can search data from 80,000 plant specimens from the greater Chicago Region, which are housed in the herbaria of each of the partner institutions. In addition to the collection data, there are digital images for almost 50,000 of the specimens available for viewing from the website. We are now in the process of adding about 12,000 fungus specimen records. By adding specimens from new partner institutions we will expand the total to over 120,000 records. New features of the site include descriptive information about the vascular plants and fungi of the Chicago Region. This project is a first step towards building a larger online database for plants and fungi that occur in the Great Lakes area and beyond.</p>

				<h3>Specimen Pages</h3>

				<p>
				Information from specimen labels entered at the three institutions is assembled, using XML, into a single web-searchable database at the vPlants portal.  This allows each institution to keep their data in any format they wish and then export text with the appropriate XML tags to the portal.
				</p>
				<p>
				The data, provided by collectors on specimen labels, are very useful and yet are rarely available for viewing or searching by the public or even other scientists.  Two key pieces of collection information that are recorded in our database include locality and habitat data.  Archiving the location where the plant or fungus grew (locality) will allow us to generate electronic maps of historical and present distributions of plant and fungal taxa in the Chicago Region.  Likewise, the habitat data provide users with information about the ecology of the species.  Trends and changes through time in the natural communities of the Chicago Region can be examined using this information.
				</p>
				<p>
				Aside from label text, we also capture high-resolution digital images of the specimens so that users can examine the details of flowers, leaves, or fruits using standard Web-browser software from their home or office.
				</p>


				<h3>Species Description Pages</h3>

				<p>
				We are in the process of adding species description pages to the website.  Rather than provide details about a single specimen, these pages present information about a species, subspecies, or variety that exists in the Chicago Region.  Using the same XML technology as the Specimen Pages, we enter data for a number of fields into our individual databases and then those data are pooled at the vPlants portal and the HTML pages are created.
				</p>
				<p>
				Users can learn about the plant and fungal diversity of the area from these new pages.  We have included descriptions, details about similar species, habitat and ecology data, etymology of the scientific names, photographs, and county distribution data based on our specimen collections.  As with the specimen pages, users will be able to browse or search by family, genus, or species.  Alternately, users can search by a common name.
				</p>
				<p>
				When complete, there will be pages for about 3,000 vascular plant taxa and 1,000 fungal taxa.  In the future we hope to add the technology of online visual keys or guides to aid users with identification of a particular plant or fungus based on physical features and attributes.
				</p>
            </div>
        </div>
		
		<div id="content2"><!-- start of side content -->
			<p class="hide">
			<a id="secondary" name="secondary"></a>
			<a href="#sitemenu">Skip to site menu.</a>
			</p>

			<!-- image width is 250 pixels -->

			<img src="<?php echo $clientRoot; ?>/images.vplants/feature/south_herb.jpg" width="250" height="225" alt="Older gray metal herbarium cabinets, placed end to end in rows." />
			<div class="box">
			<p>
			Cabinets in the old south herbarium of the Field Museum.
			</p>
			</div>

			<div class="box">
			<h3>Related Pages</h3>

			<p>
			<a href="/pr/species/" 
			 title="See prototype description pages and more.">Features in production</a>
			</p>

			<p><!-- Link to acknowledgements, page authors -->

			</p>

			<p>
			<a href="/pr/species/" 
			 title="See prototype description pages and more."><img src="<?php echo $clientRoot; ?>/images.vplants/feature/prototype_210.jpg" width="210" height="291" alt="Thumbnail image of prototype description page." /></a>
			</p>
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