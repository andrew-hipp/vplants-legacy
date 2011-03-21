
/*
 Milonic DHTML Menu
 Written by Andy Woolley
 Copyright 2003 (c) Milonic Solutions. All Rights Reserved.
*/

//The following line is critical for menu operation, and MUST APPEAR ONLY ONCE.
menunum=0;menus=new Array();_d=document;function addmenu(){menunum++;menus[menunum]=menu;}function dumpmenus(){mt="<scr"+"ipt language=JavaScript>";for(a=1;a<menus.length;a++){mt+=" menu"+a+"=menus["+a+"];"}mt+="<\/scr"+"ipt>";_d.write(mt)}
//Please leave the above line intact. The above also needs to be enabled if it not already enabled unless you have more than one _array.js file

//Licensing Information
//190219
//vplants.org

////////////////////////////////////
// Editable properties START here //
////////////////////////////////////

timegap=500                   // The time delay for menus to remain visible
followspeed=5                 // Follow Scrolling speed
followrate=50                 // Follow Scrolling Rate
suboffset_top=0               // Sub menu offset Top position
suboffset_left=0          // Sub menu offset Left position



ImageMenu=[              // AllImagesStyle is an array of properties. You can have as many property arrays as you need
"",                           // Mouse Off Font Color
"",                           // Mouse Off Background Color (use zero for transparent in Netscape 6)
"",                           // Mouse On Font Color
"",                           // Mouse On Background Color
"",                           // Menu Border Color
,                             // Font Size (default is px but you can specify mm, pt or a percentage)
"",                     // Font Style (italic or normal)
"",                     // Font Weight (bold or normal)
,                             // Font Name
,                             // Menu Item Padding or spacing
,                             // Sub Menu Image (Leave this blank if not needed)
0,                            // 3D Border & Separator bar
,                             // 3D High Color
,                             // 3D Low Color
,                             // Current Page Item Font Color (leave this blank to disable)
,                             // Current Page Item Background Color (leave this blank to disable)
,                             // Top Bar image (Leave this blank to disable)
,                             // Menu Header Font Color (Leave blank if headers are not needed)
,                             // Menu Header Background Color (Leave blank if headers are not needed)
,                             // Menu Item Separator Color
]

SubMenu=[                    // SubMenu is an array of properties. You can have as many property arrays as you need
"#336600",                     // Mouse Off Font Color
"#ffff99",                     // Mouse Off Background Color (use zero for transparent in Netscape 6)
"#ffffff",                     // Mouse On Font Color
"#336600",                     // Mouse On Background Color
"#336600",                     // Menu Border Color
"11",                         // Font Size (default is px but you can specify mm, pt or a percentage)
"normal",                     // Font Style (italic or normal)
"bold",                     // Font Weight (bold or normal)
"arial,helvitica,sans-serif",                             // Font Name
4,                            // Menu Item Padding or spacing
,                             // Sub Menu Image (Leave this blank if not needed)
0,                            // 3D Border & Separator bar
,                             // 3D High Color
,                             // 3D Low Color
,                             // Current Page Item Font Color (leave this blank to disable)
,                             // Current Page Item Background Color (leave this blank to disable)
,                             // Top Bar image (Leave this blank to disable)
,                             // Menu Header Font Color (Leave blank if headers are not needed)
,                             // Menu Header Background Color (Leave blank if headers are not needed)
"#336600",                             // Menu Item Separator Color
]



addmenu(menu=[
"allmain",                    // Menu Name - This is needed in order for this menu to be called
78,                          // Menu Top - The Top position of this menu in pixels
0,                           // Menu Left - The Left position of this menu in pixels
90,                          // Menu Width - Menus width in pixels
0,                            // Menu Border Width
,                             // Screen Position - here you can use "center;left;right;middle;top;bottom" or a combination of "center:middle"
ImageMenu,               // Properties Array - this array is declared higher up as you can see above
1,                            // Always Visible - allows this menu item to be visible at all time (1=on or 0=off)
,                             // Alignment - sets this menu elements text alignment, values valid here are: left, right or center
,// Filter - Text variable for setting transitional effects on menu activation - see above for more info
0,                            // Follow Scrolling Top Position - Tells this menu to follow the user down the screen on scroll placing the menu at the value specified.
0,                            // Horizontal Menu - Tells this menu to display horizontaly instead of top to bottom style (1=on or 0=off)
0,                            // Keep Alive - Keeps the menu visible until the user moves over another menu or clicks elsewhere on the page (1=on or 0=off)
,                             // Position of TOP sub image left:center:right
,                             // Set the Overall Width of Horizontal Menu to specified width or 100% and height to a specified amount
0,                            // Right To Left - Used in Hebrew for example. (1=on or 0=off)
0,                            // Open the Menus OnClick - leave blank for OnMouseover (1=on or 0=off)
,                             // ID of the div you want to hide on MouseOver (useful for hiding form elements)
,                             // Background image for menu Color must be set to transparent for this to work
0,                            // Scrollable Menu
,                             // Miscellaneous Menu Properties
,"<img src=/img/home.gif width=90 height=20 border=0>","/index.html swapimage=/img/home2.gif;",,,0
,"<img src=/img/about.gif width=90 height=20 border=0>","show-menu=about", "/about/index.html swapimage=/img/about2.gif;",,0
,"<img src=/img/what.gif width=90 height=37 border=0>","/topics/index.html swapimage=/img/what2.gif;",,,0
,"<img src=/img/browse.gif width=90 height=37 border=0>","show-menu=browse","/xsql/plants/genlist.xsql swapimage=/img/browse2.gif;",,0
,"<img src=/img/search.gif width=90 height=20 border=0>","/search.html swapimage=/img/search2.gif;",,,0
])

addmenu(menu=["about",,,100,1,"",SubMenu,,"left",,,,,,,,,,,,,
	,"Partners","/about/partner_mor.html",,,1
	,"Project Resources","/resources/docs2.html",,,1
	,"Other Links","/resources/links.html",,,1
	])

addmenu(menu=["browse",,,100,1,"",SubMenu,,"left",,,,,,,,,,,,,
	,"Genus List","/xsql/plants/genlist.xsql",,,1
	,"Family List","/xsql/plants/famlist.xsql",,,1
	])


dumpmenus();
	
