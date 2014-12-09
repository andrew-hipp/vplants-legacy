<?php
<?php
//error_reporting(E_ALL);
include_once($serverRoot."/config/symbini.php");
header("Content-Type: text/html; charset=".$charset);
?>
<html>
<head>
	<title><?php echo $defaultTitle?> Credits</title>
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
            <h1>Credits</h1>
			<div style="margin:20px;">
            	<h2>The Morton Arboretum</h2>
				<h3>Staff</h3>
				<dl>
				<dt><!-- http://www.mortonarb.org/main.taf?p=5,6,3 -->
				 <a href="http://systematics.mortonarb.org/lab">Andrew Hipp</a></dt><dd>&#151; project administrator; website administrator (2004&#150;present)</dd>
				<dt>Christopher Dunn</dt><dd>&#151; project administrator (2001&#150;2004, then Chic.Bot.Gard.)</dd>
				<dt>Matthew Schaub</dt><dd>&#151; technical lead, system designer and administrator; webmaster (2001&#150;2004)</dd>
				<dt>Nathan Schroeder</dt><dd>&#151; data entry, and image preparation (plants, 2002&#150;2003)</dd>
				<dt>Jason Sturner</a><!-- previously Schlismann --></dt><dd>— species description writing, data entry, and image preparation (plants, 2002&#150;2010)</dd>
				<dt>Jaime Weber</a></dt><dd>&#151; species description writing, and image preparation (plants, 2004&#150;2009)</dd>
				<!-- 
				<dt></dt><dd>&#151; </dd>
				<dt></dt><dd>&#151; </dd>
				-->
				</dl>

				<h2>Field Museum of Natural History</h2>
				<h3>Staff</h3>
				<dl>

				<dt>Becky Schillo</dt><dd>&#151; project contact (late 2010&#150;present)</dd>
				<dt><a href="http://fm1.fieldmuseum.org/aa/staff_page.cgi?staff=alverson">Bil Alverson</a></dt><dd>&#151; project administrator (2010), technical advisor, education outreach, and specimen verification and identification (2001&#150;present)</dd>
				<dt>Wendy Biggs</dt><dd>&#151; data quality control, image preparation, and editing (plants, 2005&#150;2007)</dd>
				<dt>Paul Bollinger</dt><dd>&#151; specimen identification (plants, 2010&#150;present)</dd>
				<dt>Odile Dumbleton</dt><dd>&#151; species description writing, image preparation, data quality control, and editing (plants, 2005&#150;2006)</dd>
				<dt>Wyatt Gaswick</dt><dd>&#151; specimen verification and identification, species description writing, data quality control (fungi, 2004&#150;present)</dd>
				<dt><a href="http://fm1.fieldmuseum.org/aa/staff_page.cgi?staff=leacock">Patrick Leacock</a></dt><dd>&#151; lead coordinator for fungi; web development and design; content development, education outreach, specimen verification and identification, data quality control, data editing, species description writing, image preparation, and checklist management (fungi, 2004&#150;present)</dd>
				<dt>Greg Mueller</dt><dd>&#151; project administrator (2001&#150;2008, then Chic.Bot.Gard.)</dd>
				<dt>Lindsey Muscavitch</dt><dd>&#151; image preparation, and data quality control (plants, 2010&#150;2011)</dd>
				<dt>Jim Pulizzi</dt><dd>&#151; data entry, and image preparation (plants, 2001&#150;2003)</dd>
				<dt><a href="http://fm1.fieldmuseum.org/aa/staff_page.cgi?staff=lross">Laurel Ross</a></dt><dd>&#151; outreach, liaison with Chicago Wilderness and others (2005&#150;present)</dd>
				<dt>Audrey Sica</dt><dd>&#151; data entry, and image preparation (plants, 2002&#150;2003); species description writing, and content development (fungi, 2004&#150;2005)</dd>
				<dt>Sarah Thompson</dt><dd>&#151; data entry, and image preparation (plants, 2001&#150;2003)</dd>
				<dt>Gayle Tonkovich</dt><dd>&#151;  lead coordinator for plants; system coordinator; content development, education outreach, specimen verification and identification, data quality control, data editing, species description writing, image preparation, and checklist management (plants, 2001&#150;present)</dd>

				<!-- 
				<dt></dt><dd>&#151; </dd>
				<dt></dt><dd>&#151; </dd>
				-->
				</dl>


				<h2>Chicago Botanic Garden</h2>
				<h3>Staff</h3>
				<dl>
				<dt><a href="http://www.chicagobotanic.org/research/staff/mueller.php">Greg Mueller</a></dt><dd>&#151; (previously FMNH) project administrator (2009&#150;present)</dd>
				<dt><a href="http://www.chicagobotanic.org/research/staff/zerega.php">Nyree Zerega</a></dt><dd>&#151; project contact (2007&#150;present)</dd>
				<dt>Christopher Dunn</dt><dd>&#151; (previously Mort.Arb.) project administrator (2004&#150;2006)</dd>
				<dt><a href="http://www.chicagobotanic.org/research/staff/havens.php">Kay Havens</a></dt><dd>&#151; project administrator (2001&#150;2004)</dd>
				<dt>Jennifer Ison</dt><dd>&#151; species description writing <!-- , and image preparation -->  (plants, 2004&#150;2005)</dd>
				</dl>

				<hr>

				<h3>Collaborators</h3>
				<dl>
				<dt>Merel Black</dt><dd>&#151; (University of Wisconsin) technical assistance</dd>
				</dl>

				<h3>Identification Assistance and Taxonomic Expertise</h3>
				<dl>
				<dt>Ihsan Al-Shehbaz</dt><dd> (Missouri Botanical Garden) &#151; Brassicaceae</dd>
				<dt>Lawrence Alice</dt><dd> (Western Kentucky University) &#151; <i>Rubus</i> (Rosaceae)</dd>
				<dt>Harvey Ballard</dt><dd> (Ohio University) &#151; Violaceae</dd>
				<dt>Robert Freckmann</dt><dd> (University of Wisconsin - Stevens Point) &#151; Poaceae</dd>
				<dt>Hugh Iltis</dt><dd> (University of Wisconsin - Madison) &#151; Brassicaceae</dd>
				<dt>Richard Jensen</dt><dd> (St. Mary's College) &#151; Fagaceae</dd>
				<dt>Emmet Judziewicz</dt><dd> (University of Wisconsin - Stevens Point) &#151; Poaceae</dd>
				<dt>Elias Landolt</dt><dd> (Geobotanisches Institut) &#151; Lemnaceae</dd>
				<dt>Laura Rericha</dt><dd> (Forest Preserve District of Cook County) &#151; Salicaceae, Rosaceae</dd>
				<dt>Tony Reznicek</dt><dd> (University of Michigan) &#151; Cyperaceae</dd>
				<dt>Ken Robertson</dt><dd> (Illinois Natural History Survey) &#151; Amaranthaceae</dd>
				<dt>Stanley Welsh</dt><dd> (Brigham Young University) &#151; <i>Atriplex</i> (Chenopodiaceae)</dd>
				<dt>Gerould Wilhelm</dt><dd> (Conservation Design Forum) &#151; Salicaceae, Rosaceae</dd>
				</dl>
            </div>
        </div>

	<?php
	include($serverRoot."/footer.php");
	?> 

</body>
</html>