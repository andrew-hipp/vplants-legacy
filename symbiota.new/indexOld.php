<?php
//error_reporting(E_ALL);
include_once("config/symbini.php");
header("Content-Type: text/html; charset=".$charset);
?>
<html>
<head>
	<title><?php echo $defaultTitle?> Home</title>
	<link href="css/base.css" type="text/css" rel="stylesheet" />
	<link href="css/main.css" type="text/css" rel="stylesheet" />
	<meta name='keywords' content='' />
	<script type="text/javascript">
		<?php include_once('config/googleanalytics.php'); ?>
	</script>
</head>
<body>
	<?php
	$displayLeftMenu = "true";
	include($serverRoot."/header.php");
	?> 
        <!-- This is inner text! -->
        <div  id="innertext">
            <h1><a href="/about/" title="About vPlants and its partners.">vPlants</a>: a Virtual Herbarium of the Chicago Region.</h1>
			<p class="large">The online resource for <a href="/plants/" title="Plant directory."><strong>Plants</strong></a> and <a href="/fungi/" title="Fungus directory."><strong>Fungi</strong></a> offering:</p>
<ul class="large">
  <li>Specimen data and images</li>
  <li>Species descriptions *</li>
  <li>Distribution by county</li>
  <li>Photo galleries *</li>
</ul>
 
<p>* <a href="/news/" title="See new content.">Description Pages, Features in production</a> / <a href="/news/keys.html">Keys</a></p>
 

<div id="floatimg"><img src="feature/home_170_250.jpg" width="170" height="250" alt="meadow of flowers along edge of lake." title="DeKalb County, west of Chicago."></div><p class="large">Currently the site contains data for 80,000 plant specimens from three institutions with rich Chicago Region collections: the Field Museum of Natural History, The Morton Arboretum, and the Chicago Botanic Garden. Species descriptions and other content are added on a continual basis.</p>
<p>Specimen data from additional institutions such as the Chicago Academy of Sciences and the Illinois Natural History Survey will be added.  We have also been in contact with other herbaria in the Great Lakes area such as the University of Wisconsin and University of Michigan regarding the possibility of adding or linking their Chicago Region specimen data through vPlants. This project is a first step towards building a larger online database for plants and fungi that occur in the Great Lakes area and beyond.</p>

            <div style="margin:20px;">
            	Description and introduction of project
            </div>
        </div>

	<?php
	include($serverRoot."/footer.php");
	?> 

</body>
</html>