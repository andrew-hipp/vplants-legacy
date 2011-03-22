#!/usr/bin/perl -w

print "Content-type: text/html";
   print "<tt>\n";
   foreach $key (sort keys(%ENV)) {
      print "$key = $ENV{$key}<p>";

  }
