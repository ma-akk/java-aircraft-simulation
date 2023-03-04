# avaj-launcher
study project

Project implements an aircraft simulation program based on the UML class diagram, using design patterns - Observer, Singleton and Factory.

To compile the project running the commands bellow in the root of project folder.\
$find * -name "*.java" > sources.txt
$javac @sources.txt

To execute the program\
$java -cp ./src school21.project.avaj_launcher.Application scenario.txt

Directory test/ consists of unit tests for project, uses external library JUnit5.8.1
