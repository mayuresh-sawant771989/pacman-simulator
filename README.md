# Pacman Simulator Application

## Description

- The application is a simulation of Pacman moving on in a grid, of dimensions 5 units x 5 units.
- There are no other obstructions on the grid.
- Pacman is free to roam around the surface of the grid, but must be prevented from moving off the grid. Any movement that would result in Pacman moving off the grid must be prevented, however further valid movement commands must still be allowed.
 
The application that can read in commands of the following form

    PLACE X,Y,F
    MOVE
    LEFT
    RIGHT
    REPORT

- PLACE will put the Pacman on the grid in positon X,Y and facing NORTH,SOUTH, EAST or WEST.
- The origin (0,0) can be considered the SOUTH WEST most corner.
- The first valid command to the Pacman is a PLACE command, after that,
  any sequence of commands may be issued, in any order, including another
  PLACE command. The application should discard all commands in the
  sequence until a valid PLACE command has been executed.
- MOVE will move Pacman one unit forward in the direction it is currently facing.
- LEFT and RIGHT will rotate Pacman 90 degrees in the specified direction without changing the position of Pacman.
- REPORT will announce the X,Y and F of Pacman.
- Pacman that is not on the grid can choose the ignore the MOVE, LEFT, RIGHT and REPORT commands.

## Test Data:
    
a)

	PLACE 0,0,NORTH
    MOVE
    REPORT

	Output: 0,1,NORTH

b)

	PLACE 0,0,NORTH
	LEFT
	REPORT
	
	Output: 0,0,WEST

c)

	PLACE 1,2,EAST
	MOVE
	MOVE
	LEFT
	MOVE
	REPORT

	Output: 3,3,NORTH


## Application Requirements

- This application is built in Java 8 

- Dependencies are managed by Maven

- JUnit and Mockito testing frameworks have been used

- IDE used : Eclipse( Maven in-built )


## Steps to run the application

- Clone the project from the repository 
- Import the project as 'Existing Maven Projects'
- Configure project buildpath for JDK if necessary
- In Run Configuration, add maven goals 'clean compile test exec:java'
- Check console when all the goals are completed successfully

Alternatively, if you do not want to use eclipse for maven, download maven from https://maven.apache.org/download.cgi and use below commands:

- Clean: mvn clean
- Compile: mvn compile
- Test: mvn test
- Run: mvn exec:java
