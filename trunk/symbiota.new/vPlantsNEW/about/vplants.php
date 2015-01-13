<?php
//error_reporting(E_ALL);
include_once('../config/symbini.php');
header("Content-Type: text/html; charset=".$charset);
?>
<html>
<head>
	<title><?php echo $defaultTitle?> About Us - The vPlants Project</title>
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
            <h1>About Us: The vPlants Project</h1>
			<div style="margin:20px;">
            	<p>Three major botanical institutions, <a href="partner_mor.html">The Morton Arboretum</a>, the <a href="partner_f.html">Field Museum of Natural History</a>, and the <a href="partner_chic.html">Chicago Botanic Garden</a>, have developed the online, searchable database vPlants (&#8220;virtual Plants&#8221;) that provides free plant specimen data and digital images of specimens to anyone with internet access. The project began in January 2001. </p>
				<p>Users can <a href="../search.html">search</a> data from 80,000 plant specimens from the greater <a href="../chicago.html">Chicago Region</a>, which are housed in the <a href="../topics/index.html">herbaria</a> of each of the partner institutions.  In addition to the collection data, there are digital images for almost 50,000 of the specimens available for viewing from the website.  We are now in the process of adding about 12,000 fungus specimen records.  By adding specimens from new partner institutions we will expand the total to over 120,000 records.  New features of the site include descriptive information about the vascular plants and fungi of the Chicago Region.  This project is a first step towards building a larger online database for plants and fungi that occur in the Great Lakes area and beyond.</p>
 
				<h2>Specimen Pages</h2>
 
				<p>Information from specimen labels entered at the three institutions is transferred, using XML, into a single web-searchable database at the vPlants portal.  This allows each institution to keep their data in any format they wish and then export XML text for the vPlants system.</p>
				<p>The data, provided by collectors on specimen labels, are very useful and yet are rarely available for viewing or searching by the public or even other scientists.  Two key pieces of collection information that are recorded in our database include locality and habitat data.  Archiving the location where the plant or fungus grew (locality) will allow us to generate electronic maps of historical and present distributions of plant and fungal taxa in the Chicago Region.  Likewise, the habitat data provide users with information about the ecology of the species.  Trends and changes through time in the natural communities of the Chicago Region can be examined using this information.</p>
				<p>Aside from label text, we also capture high-resolution digital images of the specimens so that users can examine the details of flowers, leaves, or fruits using standard Web-browser software from their home or office. This convenience allows scientists and other herbarium users to view specimens without traveling to each institution or requesting specimen loans.</p>
				 
				<h2>Species Description Pages</h2>
				 
				<p>We are continuing to write species description pages for the website. Rather than provide details about a single specimen, these pages present information about a species, subspecies, or variety that exists in the Chicago Region. Page writers compile descriptive data in databases at the three institutions, then export the descriptions as XML files to the vPlants portal where the XML is combined with database queries to generate live description pages.</p>
				<p>Users can learn about the plant and fungal diversity of the area from these new pages.  We have included visual appearance, details about similar species, habitat and ecology data, etymology of the scientific names, and photographs. The county distribution data are based on our specimen collections.  As with the specimen pages, users will be able to browse or search by family, genus, species, or common name.</p>
				<p>When complete, there will be pages for about 3,000 vascular plant taxa and 1,000 fungal taxa.  In the future we hope to add the technology of online visual keys or guides to aid users with identification of a particular plant or fungus found in the Chicago Region.</p>
            </div>
        </div>

	<?php
	include($serverRoot."/footer.php");
	?> 

</body>
</html>