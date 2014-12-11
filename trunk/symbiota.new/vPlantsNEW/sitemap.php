<?php
//error_reporting(E_ALL);
include_once($serverRoot."/config/symbini.php");
header("Content-Type: text/html; charset=".$charset);
?>
<html>
<head>
	<title><?php echo $defaultTitle?>vPlants - Site Map</title>
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
            <h1>Site Map</h1>

            <div style="margin:20px;">
            	<p>This table of contents shows the organization structure of the vPlants website. For the static content (HTML pages) we list the top three levels of the site hierarchy but do not show all of the fourth level accessory pages.  For the live or interactive content (specimen data, species descriptions, galleries, guides) we list the start pages for accessing that scripted content.
				</p>

				<table class="sitemap" summary="Advanced search form."><tr ><td >
				 <h2 class="home">Home</h2>
				 <ul>
				  <li><a href="index.html"
				   title="Home page">Welcome</a></li><!-- change 90,000 to 72,000 -->
				  <li><a href="chicago.html"
				   title="Why the Chicago Region?">Chicago Region</a></li>
				  <li><a href="map.html"  
				   title="See State Map for Chicago Region.">State Map</a></li>
				  <li><a href="map_county.html" 
				   title="See County Map for Chicago Region.">County Map</a></li>
				 </ul>
				 
				 <h3>About Us</h3>
				 <ul>
				  <li><a href="about/index.html"
				   title="About this site.">vPlants</a></li><!-- IMLS, Chicago Wilderness, site history, development, goals, products -->
				  <li><a href="about/system.html"
				   title="How vPlants operates.">System Overview</a></li><!-- intro, methods, results, discuss, refs -->
				  <li><h4>Partners</h4>
				   <ul>
					<li><a href="about/partner_mor.html" 
					 title="Read about this partner.">The Morton Arboretum</a></li>
					<!-- about institution and importance of their collections -->
					<li><a href="about/partner_f.html" 
					 title="Read about this partner.">The Field Museum</a></li>
					<li><a href="about/partner_chic.html" 
					 title="Read about this partner.">Chicago Botanic Garden</a></li>
					<li><a href="about/partner_other.html" 
					 title="Read about other partners.">Additional Partners</a></li>
				   </ul>
				  </li>
				  <li><a href="about/contact.html" 
				   title="Contact information.">Contact Us</a></li><!-- 3 contacts -->
				  <li><a href="about/feedback.html" 
				   title="Please provide feedback!">Feedback</a></li>
				  <!-- when form submitted users are taken to thanks.html -->
				  <li><a href="about/credits.html" 
				   title="The people of vPlants.">Credits</a></li>
				  <!-- data entry, page writing, content development, web development, project administrator, photography, Bil = technical advisor -->
				 </ul>

				 
				 <h3>Site Map</h3>
				 <ul >
				  <li><a href="sitemap.html"
				   title="Table of contents.">Site Map</a> (You are here.)</li>
				  <li><a href="access.html" 
				   title="Accessibility features of this site.">Accessibility Statement</a></li>
				  <li><a href="copyright.html" 
				   title="Copyright policy.">Copyright Policy</a></li>
				  <li><a href="disclaimer.html" 
				   title="Disclaimer statement.">Disclaimer</a></li>
				 </ul>


				 <h3>Search</h3>
				 <ul>
				  <li><a href="search.html"
				   title="Advanced search for plants or fungi.">Advanced Search for Specimens</a></li>
				  <li><a href="gid.html"
				   title="GID quick find.">GID Quick Find</a></li>
				 </ul>
				 
				 <h3>Help Guide</h3>
				 <ul>
				  <li><a class="help" href="help/index.html" 
				   title="Help and user guide.">Help Guide</a></li>
				  <li><a href="help/search.html" 
				   title="Help with searching.">Help with Searching</a></li>
				  <li><a href="help/specimen.html" 
				  title="Help with specimen pages.">Help with Specimens</a></li>
				  <li><a href="help/description.html" 
				  title="Help with description pages.">Help with Descriptions</a></li>
				  <li><a href="help/gallery.html" 
				  title="Help with photo galleries.">Help with Photo Galleries</a></li>
				  <li><a href="help/glossary.html" 
				  title="Help with the glossaries.">Help with the Glossaries</a></li>
				 </ul>
				 
				 <h3>Topics</h3>
				 <ul><li><a href="topics/index.html" 
				   title="What is a Herbarium?">Herbarium Collections</a></li>
				  <li><h4>Names</h4>
				   <ul>
					<li><a href="topics/names.html" 
					 title="What's in a name?">Taxonomy</a></li>
						<li><a href="topics/names2.html"
						 title="Official names.">Scientific Names</a></li>
					<li><a href="topics/names3.html" 
					 title="Multiple names.">Synonyms</a></li>
					<li><a href="topics/names4.html" 
					 title="Unofficial names.">Common Names</a></li>
				   </ul>
				   </li>
				  <li><h4>Habitats of the Chicago Region</h4>
				   <ul>
					<li><a href="topics/habitats.html" 
					 title="Plant communities.">Habitats</a></li>
					<li><a href="topics/habitats2.html" 
					 title="Woodlands of the Chicago Region.">Woodlands</a></li>
					<li><a href="topics/habitats3.html" 
					 title="Grasslands of the Chicago Region.">Grasslands</a></li>
					<li><a href="topics/habitats4.html" 
					 title="Wetlands of the Chicago Region.">Wetlands</a></li>
					<li><a href="topics/habitats5.html" 
					 title="Living in the city.">Urban Areas</a></li>
				   </ul>
				   </li>
				  <li><h4>Distribution</h4>
				   <ul>
					<li><a href="topics/distribution.html" 
					 title="Biogeography.">Distribution</a></li>
					<li><a href="topics/distribution2.html" 
					 title="Endemics of the Chicago Region.">Endemics</a></li>
					<li><a href="topics/distribution3.html" 
					 title="Disjuncts of the Chicago Region.">Disjuncts</a></li>
				   </ul>
				  </li>
				  <li><h4>Origin</h4>
				   <ul>
					<li><a href="topics/origin.html" 
					 title="Original plants.">Native Plants</a></li>
					<li><a href="topics/origin2.html" 
					 title="Alien plants.">Non-native Plants</a></li>
					<li><a href="topics/origin3.html" 
					 title="Harmful plants.">Invasive Plants</a></li>
				   </ul>
				  </li>
				  <li><h4>Special Concern</h4>
				   <ul><li><a href="topics/concern.html"
					title="State and Federal.">Regional Lists</a></li>
				   <li><a href="topics/concern2.html"
					title="Why plants are at risk.">Causes for Concern</a></li>
				   <li><a href="topics/concern3.html"
					title="Threatened and endangered.">The Listing of Plants</a></li>
				   <li><a href="topics/concern4.html"
					title="Laws and preserves.">Protection</a></li>
				   </ul>
				  </li>
				 </ul>
				 
				 <h3>Resources</h3>
				 <ul>
				  <li><a href="resources/index.html"
				   title="Links to herbarium sites.">Herbaria</a></li>
				  <li>Documents<ul title="View or download files and working documents."><li><a 
					   href="resources/docs.html">vPlants Documents</a></li><li><a 
					href="resources/docs2.html">Plant Documents</a></li><li><a 
					href="resources/docs3.html">Fungus Documents</a></li></ul></li>
				  <li>References<ul title="List of Books and other literature."><li><a 
					href="resources/biblio.html">General References</a></li><li><a 
					href="resources/biblio2.html">Plant References</a></li><li><a 
					href="resources/biblio3.html">Fungus References</a></li><li><a 
					href="resources/biblio4.html">Chicago References</a></li></ul></li>
				  <li>Links<ul title="Links to related web sites."><li><a href="resources/links.html"
					>Related Links</a></li><li><a 
					href="resources/links2.html">Plant Links</a></li><li><a 
					href="resources/links3.html">Fungus Links</a></li></ul></li>
				 </ul>

				 <h3>News</h3>
				 <ul>
				  <li><a href="news/index.html" 
				   title="New content.">Features in Production: Descriptions</a></li>
				  <li><a href="news/keys.html" 
				   title="Planned content.">Features in Development: Keys to Nature</a></li>
				  <li><a href="news/reviews.html" 
				   title="Site Reviews.">Reviews and Awards</a></li>
				 </ul>
				 

				 
				 
				</td><td class="rightcol">
				 
				 <h2 class="plant">Plants</h2>
				 <ul>
				  <li><a href="plants/index.html"
				   title="Plants start page.">Plants of the Chicago Region</a></li>
				  <li><a href="plants/biology.html" 
				   title="How plants grow.">Biology</a></li>
				  <li><a href="plants/diversity.html" 
				   title="How many plants.">Diversity</a></li>
				  <!-- also table 2 and 3. -->
				 </ul>
				 
				 <h3>Guide</h3>
				 <ul>
				  <li><a href="plants/guide/index.html"
				   title="Guide to plants.">Guide to Plants</a></li>
				  <li><a href="/xsql/plants/famlist.xsql" 
				   title="Index of families.">Family Index</a></li>
				  <li><a href="/xsql/plants/genlist.xsql" 
				   title="Index of genera.">Genus Index</a></li>
				 </ul>
				 
				 <h3>Glossary</h3>
				 <ul>
				  <li><a href="plants/glossary/index.html"
				   title="Definitions of terms for plants">Plant Glossary</a> Alphabetical list of terms.</li>
				  <li><a href="plants/glossary/asteraceae.html" 
				   title="Glossary for Asteraceae">Asteraceae</a> Composites.</li>
				  <li><a href="plants/glossary/cyperaceae.html" 
					title="Glossary for Cyperaceae">Cyperaceae</a> Sedges.</li>
				  <li><a href="plants/glossary/poaceae.html" 
					title="Glossary for Poaceae">Poaceae</a> Grasses.</li>
				  <li><a href="plants/glossary/plate01.html" 
				   title="See images">Plate 1</a> Stem and Root Types.</li>
				  <li><a href="plants/glossary/plate02.html" 
				   title="See images">Plate 2</a> Leaf Composition, Parts, and Types.</li>
				  <li><a href="plants/glossary/plate03.html" 
				   title="See images">Plate 3</a> Leaf Shapes.</li>
				  <li><a href="plants/glossary/plate04.html" 
				   title="See images">Plate 4</a> Leaf Margins.</li>
				  <li><a href="plants/glossary/plate05.html" 
				   title="See images">Plate 5</a> Leaf Apices, Venation, and Bases.</li>
				  <li><a href="plants/glossary/plate06.html" 
				   title="See images">Plate 6</a> Surface Features.</li>
				  <li><a href="plants/glossary/plate07.html" 
				   title="See images">Plate 7</a> Stem and Leaf Parts, and Variations.</li>
				  <li><a href="plants/glossary/plate08.html" 
				   title="See images">Plate 8</a> Inflorescence Types.</li>
				  <li><a href="plants/glossary/plate09.html" 
				   title="See images">Plate 9</a> Floral Morphology.</li>
				  <li><a href="plants/glossary/plate10.html" 
				   title="See images">Plate 10</a> Corolla Types.</li>
				  <li><a href="plants/glossary/plate11.html" 
				   title="See images">Plate 11</a> Fruit Types.</li>
				  <li><a href="plants/glossary/plate12.html" 
				   title="See images">Plate 12</a> Sedges, Grasses, and Composites.</li>
				  <li><a href="plants/glossary/plate_all.html" 
				   title="See all images">All 12 plates</a></li>
				 </ul>
				 
				 
				 <h2 class="fungus">Fungi</h2>
				 <ul>
				  <li><a href="fungi/index.html"
				   title="Fungi start page.">Fungi of the Chicago Region</a></li>
				  <li><a href="fungi/biology.html" 
				   title="How fungi grow.">Biology</a></li>
				  <li><a href="fungi/diversity.html" 
				   title="How many fungi.">Diversity</a></li>
				 </ul>


				 <h3>Guide</h3>
				 <ul>
				  <li><a href="fungi/guide/index.html"
				   title="Guide to fungi.">Guide to Fungi</a></li><!-- how to make spore print -->
				  <li><a href="xsql/fungi/famlist.xsql" 
				   title="Index of families.">Family Index</a></li>
				  <li><a href="xsql/fungi/genlist.xsql" 
				   title="Index of genera.">Genus Index</a></li>
				 </ul>
				 
				 <h3>Glossary</h3>
				 <ul>
				  <li><a href="fungi/glossary/index.html"
				   title="Definitions of terms for fungi">Fungus Glossary</a> Alphabetical list of terms.</li>
				 </ul>
				 
				</td></tr></table>
				  
				 <!-- 
				 Old pages and their replacments
				  
				  about_herbarium => about/index
				  about_notes => null
				  about_others => about/partner_other
				  about_partners => about/partner.....3 files
				  about_system => about/system
				  about_thanks => about/credits
				  
				  robots.txt
				 Turn off indexing to the following: move some to archive folder
				  cgi-bin
				  metadata
				  pr (species, gallery, metadata) - move some parts to prototypes
				  sample
				  xml
				 
				  miscellaneous files
				  xsql_test.html
				  test.html (old ahipp plant clinic garden question)
				  
				  Need admin access page for
				  searchqa
				  vppadmin
				  accession number search, etc.
				  
				 
				 -->
            </div>
        </div>

	<?php
	include($serverRoot."/footer.php");
	?> 

</body>
</html>