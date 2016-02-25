-----------------------------------
          PRIZY-PRICER
-----------------------------------

GENERAL USAGE NOTES
-------------------
* To install this application you will need
	- Grails 2.0.3 (https://grails.org/download.html)
	- PostgreSQL 9.5.0 (http://www.postgresql.org/download/)

* Also you need to have properly installed a java SDK (1.6 or 1.7)
* In order to execute the commands contained into this document you have to
set the JAVA_HOME, GRAILS_HOME and the bin folders of java sdk, postgre sql 
and grails you install.

Note: if you have any issues with the dependecies you could delete the ivy-cache
folder content on the folowing path:
Windows: C:\Users\[Username]\.grails\ivy-cache
Linux: ~\.grails\ivy-cache

INSTALL THE APPLICATION
-----------------------
You have to create the database, an user and password in postgreSQL
The user name is set as 'grails' and the password is '123456'.
if you want to use another credentials go to DataSource.groovy file and change it

Run the command "createdb -U postgres grails"
user=grails
password=123456
Unzip the prizy-price.zip file

RUN THE APPLICATION
-------------------
In a terminal console go to the 'thePrizyPricer' folder and run
grails run-app -Dgrails.server.port.http=8080
then in a browser go to
http://localhost:8080/thePrizyPricer

RUN THE TESTS
-------------
In a terminal console go to the thePrizyPricer folder and run
grails test-app

VIEW THE TESTS REPORT
---------------------
In a terminal console go to the folder and run
grails
Now you are in the grails interactive mode, to open the results run
grails> open test-report