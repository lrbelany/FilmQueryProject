# FilmQueryProject

#Description
This program is a basic search engine, however it is limited to a fun Learned
fictitious cinema database that was designed for instructional purposes.
In this Film Query app the User can search by key word, film ID or exit the program. More options to be implemented soon.

The Film Query app consists of a main app, three objects; databaseAccessorObject,
Film Object, and Actor object, and an interface. The Film and Actor objects
act as templates for data to be populated when requested. The databaseAccessorObject
communicates with the SQL sever pulling data and distributing that data where requested i.e to the classes. An interface is some what of a conduit or a go between similar to a remote control, where each method in the interface would be a button that in theory would perform a function.



#Technologies Used
Eclipse,
MySQL,
MAMP,
Maven,
Atom,
Java,
Drivers,
XML dependencies,
Scanner

#Lessons Learned

I haven't fully mastered the try catch but I had to make myself more comfortable with using them as during this project I had no choice in the matter. As frustrating as it
was I feel like I have improved at trouble shooting java and MySQL statements, I still have a lot more room for improvement. My break through over the weekend had to be the realizing that when I'm troubleshooting I can make solutions make sense when I talk out loud what is wrong, what it is a problem and from there I can work towards solutions.

#Imperfections
I was not able to handle all of the invalid prompts at at the same time. I had
a triple catch initially nullpointer, mismatch, and general exception which would
stop the program. I removed the general exception and it only ind of handles things
while continuing to run. I tried adding the startUserInterface method in the mismatch catch block, and that seems to be working so I'll leave it as is for the time being.
