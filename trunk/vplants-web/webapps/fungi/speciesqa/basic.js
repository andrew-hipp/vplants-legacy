function MM_reloadPage(init) {  //reloads the window if Nav4 resized
  if (init==true) with (navigator) {if ((appName=="Netscape")&&(parseInt(appVersion)==4)) {
    document.MM_pgW=innerWidth; document.MM_pgH=innerHeight; onresize=MM_reloadPage; }}
  else if (innerWidth!=document.MM_pgW || innerHeight!=document.MM_pgH) history.go(0);
}
MM_reloadPage(true);


function thisYear() {
thisDate = new Date() //creates object with current GMT date
theYear = thisDate.getYear() //compatible function for Netscape 4
if(theYear<2000) theYear+=1900; //add 1900 to make full year.
return theYear; //have function return the year value so we can use it.
}