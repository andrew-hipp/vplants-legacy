*********************************************************
***vPlants Metadata Transformer***
*********************************************************
vPlantsTransformer.jar is the main executable.  All additional
jars are required components.  The XSL directory contains
the stylesheets necessary for creating the 3 vPlants Metadata
layers.

On the main screen, the input fields are described as follows:

Select XML File To Transform:  input file in CSV format (double quotes optional),
   sorted by the NAME_CD field.

Destination Directory: path where the metadata document structure will be build.

Select The XSLT File For Your Data: XSL file used to convert the site fields to the
   program specific fields.  Instead of listing the fields in this document, I've
   included a sample file, blueprint.xsl and a sample input csv file, small.csv.

Herbarium Code: herbarium code for the site - this will be placed in the index.xml file.

URI Base: where the metadata document structure is published on the web affects the
   internal linkage between the layers of the structure.  Since these links are build
   by the application, it needs to know the base URI to ensure the linkages are built
   correctly.

This was developed using JDK1.3.1

*********************************************************
07/26/2002 - Matthew Schaub, The Morton Arboretum
V1.0, Intial Release
*********************************************************
08/05/2002 - Matthew Schaub, The Morton Arboretum
V1.1
- Added support for an INI file.
- Enabled the file and directory fields, allowing the user to
  type in the values instead of using the select button.
*********************************************************
08/26/2002 - Matthew Schaub, The Morton Arboretum
V1.2
- Modified the XSL files to properly reflect the vPlants metadata structure.
  I just simply had some incorrect tag names (eg. coll_date instead of colldate)
*********************************************************
09/05/2002 - Matthew Schaub, The Morton Arboretum
V1.3
- Recompiled with some updated architecture components (fixing a bug whereby the parsers character
  buffer was not cleared after a non-fatal parsing error).
- Added a new abstract method to reset all tag booleans to false each time a consumer class is
  used.
*********************************************************
10/18/2002 - Matthew Schaub, The Morton Arboretum
V1.4
- Fixed a bug in the spm.xsl stylesheet that prevented the first initial of the collector from
  being displayed.
*********************************************************