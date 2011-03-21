//preload
var preloadImages = new Array();
if (document.images){
preloadImages[1] = new Image();
preloadImages[1].src = "/img/about.gif";
preloadImages[2] = new Image();
preloadImages[2].src = "/img/about2.gif";
preloadImages[3] = new Image();
preloadImages[3].src = "/img/browse.gif";
preloadImages[4] = new Image();
preloadImages[4].src = "/img/browse2.gif";
preloadImages[5] = new Image();
preloadImages[5].src = "/img/home.gif";
preloadImages[6] = new Image();
preloadImages[6].src = "/img/home2.gif";
preloadImages[7] = new Image();
preloadImages[7].src = "/img/search.gif";
preloadImages[8] = new Image();
preloadImages[8].src = "/img/search2.gif";
preloadImages[9] = new Image();
preloadImages[9].src = "/img/what.gif";
preloadImages[10] = new Image();
preloadImages[10].src = "/img/what2.gif";
preloadImages[11] = new Image();
preloadImages[11].src = "/img/top.gif";
preloadImages[12] = new Image();
preloadImages[12].src = "/img/side.gif";
preloadImages[13] = new Image();
preloadImages[13].src = "/img/logo.gif";
preloadImages[14] = new Image();
preloadImages[14].src = "/img/herb.gif";
preloadImages[15] = new Image();
preloadImages[15].src = "/img/bghome.gif";
preloadImages[16] = new Image();
preloadImages[16].src = "/img/bg.gif";
}


//for demo
//   if (document.images) {
//image1on = new Image();
//image1on.src = "/img/demo_but2.gif"; 
// 
//image1off = new Image();
//image1off.src = "/img/demo_but.gif";
//     } 
	 
function imgon(imgName) { 
if (document.images) { 
document[imgName].src = eval(imgName + "on.src");
     }
     } 

function imgoff(imgName) { 
if (document.images) { 
document[imgName].src = eval(imgName + "off.src");
     }
     } 
	 
	 
	 
	 
	 
// Netscape fix resize bug Ns4
function WM_netscapeCssFix() {
  if (document.WM.WM_netscapeCssFix.initWindowWidth != window.innerWidth ||
        document.WM.WM_netscapeCssFix.initWindowHeight != window.innerHeight) {
     document.location = document.location;
    }
}

function WM_netscapeCssFixCheckIn() {
  if ((navigator.appName == 'Netscape') && (parseInt(navigator.appVersion) == 4)) {
    if (typeof document.WM == 'undefined'){
       document.WM = new Object;
       }
    if (typeof document.WM.WM_scaleFont == 'undefined') {
       document.WM.WM_netscapeCssFix = new Object;
       document.WM.WM_netscapeCssFix.initWindowWidth = window.innerWidth;
       document.WM.WM_netscapeCssFix.initWindowHeight = window.innerHeight;
       }
    window.onresize = WM_netscapeCssFix;
  }
}

WM_netscapeCssFixCheckIn();

// catch all errors...
function stopError() {return true;}
window.onerror=stopError;

 
