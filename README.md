# irrigationsystem
irrigationsystem to automatic irrigate plot of land
Irrigation System

Requirement for  make task work smoothly:
•	Java 8
•	Eclipse 
•	My SQl workbench V.8
•	Import Compress file (irrigationsystem) in eclipse java EE from file >> import >> Maven >> Exists Maven Project
•	After doing that open script apply (createuser.sql)
•	After that open src/main/java
•	In package com.nsag.irrigationsystem open it 
•	In class IrrigationsystemApplication right click >>run as Java Application
•	The table will generate automatically
•	Then open script apply (irrigationsys3table) to get some ready insert data

Api Details
All Api start with 
http://localhost:8080/api/

1.	For LandPlotRestController (/landPlots)
2.	For LandTimeandWateramountController(/timewateramnt)
3.	For IrrigationSensorRestController(/irregsesnors)

Three operation (get/update/add)
All sql and main project attached

