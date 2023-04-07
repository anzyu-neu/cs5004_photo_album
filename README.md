# cs5004_hw8
Photo Album MVC

Model implementation: 
The model focuses on proper design and implementation of the shapes and their associated attributes:
color, size, location. The shape interface makes use of Point2D and Color class respectively 
to represent the center/starting corner and the RGB color scale of the shape. Shapes are incorporated 
into the pages class. On the page, users can add/remove shapes, assign colors, set shape locations, 
change the name/description of shapes, and move shapes around. Each modification on the page 
creates a snapshot of the page. Snapshots contain the timestamp, a snap ID, a description of what 
changed between the previous snapshot and the new one, and the shapes on the page at the moment of 
the snapshot. Each page has a snapshot history. Individual pages are stored in the photo album. 
