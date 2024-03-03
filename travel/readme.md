# Steps to run the code
1. Make sure Java 17 is installed
2. Make sure apache-maven-3.9.0 is installed
3. You can use editor of your choice but intelliJ is preferable
4. Run 'mvn clean install' to install all the maven dependencies
5. Post that, go to 'TravelDriver.java' class. It contains main() function. You can run it to execute the code.

-----------

# About this application
1. This is a travel application which helps travel agency to manage the travel packages, their itinerary and passengers inside it
2. It contains TravelDriver.java class which is the entry point for the application
3. Currently, a sample TravelPackage is initialised ( values inside it are hard coded ) for testing the application
4. Going forward, travel package fields would be input by the user from a user interface and then input data would get saved in the database
5. All the classes of the application have 100% unit coverage
6. PlantUML platform was used to make High and Low level Diagrams

------------

# Future enhancements
1. Using database for saving all the travel package related data
2. Using id field inside the entities to uniquely identify them
3. Building rest controller and exposing the APIs
4. Using dependency injection for injecting the objects
5. Giving the user interface to created destination, activity etc. along with travel package creation interface

------------

# Whom to contact if any issue is faced while setting / running the application
adityaagarwaludi@gmail.com