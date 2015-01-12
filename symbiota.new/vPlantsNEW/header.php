<table id="maintable" cellspacing="0">
	<tr style="" >
		<td class="header" colspan="3">
			<!-- <div style="height:110px;background-image:url(<?php //echo $clientRoot; ?>/images/layout/defaultheader.jpg);background-repeat:no-repeat;position:relative;"> -->
			<div id="sitehead"><a id="pagetop" name="pagetop"></a>
				<div id="logo" style="float:left;"><img src="<?php echo $clientRoot; ?>/images/vplants/img/logo.gif" alt="vPlants.org Home."></div>
				<div id="partners">
					<ul>
						<li><a href="<?php echo $clientRoot; ?>/about/partner_mor.php" title="Read about this partner.">The Morton Arboretum</a></li>
						<li><a href="<?php echo $clientRoot; ?>/about/partner_f.php" title="Read about this partner.">The Field Museum</a></li>
						<li><a href="<?php echo $clientRoot; ?>/about/partner_chic.php" title="Read about this partner.">Chicago Botanic Garden</a></li>
						<li><a href="<?php echo $clientRoot; ?>/about/partner_other.php" title="Read about other partners.">Additional Partners</a></li>
					</ul>
				</div>
				<div style="float:right;margin-right:15px;margin-top:10px;">
					<img src="<?php echo $clientRoot; ?>/images/vplants/feature/40tt.jpg" style="width:40px;height:40px;margin-left:2.5px;margin-right:2.5px;" alt=" " title="Thalictrum thalictroides">
					<img src="<?php echo $clientRoot; ?>/images/vplants/feature/40hm.jpg" style="width:27px;height:40px;margin-left:2.5px;margin-right:2.5px;" alt=" " title="Hibiscus moscheutos">
					<img src="<?php echo $clientRoot; ?>/images/vplants/feature/40ug.jpg" style="width:40px;height:40px;margin-left:2.5px;margin-right:2.5px;" alt=" " title="Uvularia grandiflora">
					<img src="<?php echo $clientRoot; ?>/images/vplants/feature/40cp.jpg" style="width:26px;height:40px;margin-left:2.5px;margin-right:2.5px;" alt=" " title="Cirsium pitcheri">
					<img src="<?php echo $clientRoot; ?>/images/vplants/feature/40ac.jpg" style="width:40px;height:40px;margin-left:2.5px;margin-right:2.5px;" alt=" " title="Agaricus campestris">
				</div>
			</div><!-- End of #sitehead -->
			<div style="clear:both;height:24px;">
				<div style="clear:both;float:right;color:#000000;margin-top:8px;"
					<?php
					if($userDisplayName){
					?>
						<span style="">
							Welcome <?php echo $userDisplayName; ?>!
						</span>
						<span style="margin-left:8px;">
							<a href="<?php echo $clientRoot; ?>/profile/viewprofile.php">My Profile</a>
						</span>
						<span style="margin-left:8px;">
							<a href="<?php echo $clientRoot; ?>/profile/index.php?submit=logout">Logout</a>
						</span>
					<?php
					}
					else{
					?>
						<span style="">
							<a href="<?php echo $clientRoot."/profile/index.php?refurl=".$_SERVER['PHP_SELF']."?".$_SERVER['QUERY_STRING']; ?>">
								Log In
							</a>
						</span>
						<span style="margin-left:8px;">
							<a href="<?php echo $clientRoot; ?>/profile/newprofile.php">
								New Account
							</a>
						</span>
					<?php
					}
					?>
					<span style="margin-left:8px;margin-right:8px;">
						<a href='<?php echo $clientRoot; ?>/sitemap.php'>Sitemap</a>
					</span>
					
				</div>
				<div style="height:24px;">
					<ul id="hor_dropdown">
						<li>
							<a href="<?php echo $clientRoot; ?>/index.php" >Home</a>
						</li>
						<li>
							<a href="<?php echo $clientRoot; ?>/about/index.php" >About Us</a>
							<ul>
								<li>
									<a href="<?php echo $clientRoot; ?>/about/chicago.php" >Chicago Region</a>
								</li>
								<li>
									<a href="<?php echo $clientRoot; ?>/about/partnership.php" >vPlants Partnership</a>
								</li>
								<li>
									<a href="<?php echo $clientRoot; ?>/about/contact.php" >Contact Us</a>
								</li>
								<li>
									<a href="<?php echo $clientRoot; ?>/about/credits.php" >Credits</a>
								</li>
							</ul>
						</li>
						<li>
							<a href="<?php echo $clientRoot; ?>/plants/index.php" >About Plants</a>
							<ul>
								<li>
									<a href="<?php echo $clientRoot; ?>/plants/guide/index.php" >Guide</a>
								</li>
								<li>
									<a href="<?php echo $clientRoot; ?>/plants/glossary/index.php" >Glossary</a>
								</li>
								<li>
									<a href="<?php echo $clientRoot; ?>/plants/biology.php" >Biology</a>
								</li>
								<li>
									<a href="<?php echo $clientRoot; ?>/plants/diversity.php" >Diversity</a>
								</li>
								<li>
									<a href="<?php echo $clientRoot; ?>/plants/habitats.php" >Habitats</a>
								</li>
								<li>
									<a href="<?php echo $clientRoot; ?>/plants/origin.php" >Origin</a>
								</li>
								<li>
									<a href="<?php echo $clientRoot; ?>/plants/distribution.php" >Distribution</a>
								</li>
								<li>
									<a href="<?php echo $clientRoot; ?>/plants/names.php" >Naming</a>
								</li>
								<li>
									<a href="<?php echo $clientRoot; ?>/plants/collections.php" >Collections</a>
								</li>
								<li>
									<a href="<?php echo $clientRoot; ?>/plants/concern.php" >Special Concern</a>
								</li>
							</ul>
						</li>
						<li>
							<a href="<?php echo $clientRoot; ?>/search/index.php" >Search</a>
							<ul>
								<li>
									<a href="<?php echo $clientRoot; ?>/collections/index.php" >Search Collections</a>
								</li>
								<li>
									<a href="<?php echo $clientRoot; ?>/collections/map/mapinterface.php" target="_blank" >Map Search</a>
								</li>
								<li>
									<a href="<?php echo $clientRoot; ?>/imagelib/imgsearch.php" >Image Search</a>
								</li>
							</ul>
						</li>
						<li>
							<a href="<?php echo $clientRoot; ?>/imagelib/index.php" >Browse Images</a>
						</li>
						<li>
							<a href="<?php echo $clientRoot; ?>/projects/index.php?" >Inventories</a>
							<!-- <ul>
								<li>
									<a href="<?php echo $clientRoot; ?>/projects/index.php?proj=1" >add Western Great Lakes Herbaria Projects list???</a>
								</li>
								<li>
									<a href="<?php echo $clientRoot; ?>/projects/index.php?proj=2" >Project 2</a>
								</li>
								<li>
									<a href="<?php echo $clientRoot; ?>/projects/index.php?proj=3" >Project 3</a>
								</li>
								<li>
									<a href="<?php echo $clientRoot; ?>/projects/index.php?proj=4" >Project 4</a>
								</li>
							</ul> -->
						</li>
						<li>
							<a href="#" >Interactive Tools</a>
							<!-- <ul>
								<li>
									<a href="<?php echo $clientRoot; ?>/checklists/dynamicmap.php?interface=checklist&tid=56" >Dynamic Checklist</a>
								</li>
								<li>
									<a href="<?php echo $clientRoot; ?>/checklists/dynamicmap.php?interface=checklist&tid=4773" >Dynamic Key</a>
								</li>
							</ul> -->
						</li>
						<li>
							<a href="<?php echo $clientRoot; ?>/resources/index.php" >Resources</a>
							<ul>
								<li>
									<a href="<?php echo $clientRoot; ?>/resources/regionherbaria.php" >Region Herbaria</a>
								</li>
								<li>
									<a href="<?php echo $clientRoot; ?>/resources/docs.php" >Documents</a>
								</li>
								<li>
									<a href="<?php echo $clientRoot; ?>/resources/biblio.php" >References</a>
								</li>
								<li>
									<a href="<?php echo $clientRoot; ?>/resources/links.php" >Links</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</td>
	</tr>
    <tr>
	<td class='middlecenter'  colspan="3">

		