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
							<a href="<?php echo $clientRoot; ?>/collections/index.php" >Search Collections</a>
						</li>
						<li>
							<a href="<?php echo $clientRoot; ?>/collections/map/mapinterface.php" target="_blank" >Map Search</a>
						</li>
						<li>
							<a href="<?php echo $clientRoot; ?>/imagelib/imgsearch.php" >Image Search</a>
						</li>
						<li>
							<a href="<?php echo $clientRoot; ?>/imagelib/index.php" >Browse Images</a>
						</li>
						<li>
							<a href="<?php echo $clientRoot; ?>/projects/index.php?" >Inventories</a>
							<!-- <ul>
								<li>
									<a href="<?php echo $clientRoot; ?>/projects/index.php?proj=1" >Amphibians of Panama</a>
								</li>
								<li>
									<a href="<?php echo $clientRoot; ?>/projects/index.php?proj=2" >Reptiles of Panama</a>
								</li>
								<li>
									<a href="<?php echo $clientRoot; ?>/projects/index.php?proj=3" >Birds of Panama</a>
								</li>
								<li>
									<a href="<?php echo $clientRoot; ?>/projects/index.php?proj=4" >Fishes of Panama</a>
								</li>
							</ul> -->
						</li>
						<li>
							<a href="#" >Interactive Tools</a>
							<!-- <ul>
								<li>
									<a href="<?php echo $clientRoot; ?>/checklists/dynamicmap.php?interface=checklist&tid=56" >Dynamic Bird Checklist</a>
								</li>
								<li>
									<a href="<?php echo $clientRoot; ?>/checklists/dynamicmap.php?interface=checklist&tid=4773" >Dynamic Fish Checklist</a>
								</li>
								<li>
									<a href="<?php echo $clientRoot; ?>/checklists/dynamicmap.php?interface=checklist&tid=10349" >Dynamic Amphibian Checklist</a>
								</li>
								<li>
									<a href="<?php echo $clientRoot; ?>/checklists/dynamicmap.php?interface=checklist&tid=10350" >Dynamic Reptile Checklist</a>
								</li>
							</ul> -->
						</li>
					</ul>
				</div>
			</div>
		</td>
	</tr>
    <tr>
	<td class='middlecenter'  colspan="3">

		