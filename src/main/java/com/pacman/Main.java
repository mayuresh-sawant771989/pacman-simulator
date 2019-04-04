package com.pacman;

import java.util.Scanner;

import com.pacman.exception.PacmanSimulatorException;
import com.pacman.helper.GridSurface;
import com.pacman.helper.Pacman;

public class Main {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		GridSurface gridSurface = new GridSurface(5,5);
		Pacman pacman = new Pacman();
		Console console = new Console(gridSurface, pacman);
		
		System.out.println("*** Pacman Simulator Console ***\n");
        System.out.println("Enter below command\n");
        
        System.out.println("\'PLACE X,Y,EAST|WEST|NORTH|SOUTH\'\n");
        System.out.println(" (X) - x co-ordinate on the square table top (0-5)");
        System.out.println(" (Y) - y co-ordinate on the square table top (0-5)");
        System.out.println(" EAST|WEST|NORTH|SOUTH - Select any one direction for the pacman to start with");
        System.out.println(" MOVE|LEFT|RIGHT - use these commands to move and change directions ");
        System.out.println(" REPORT - use this command to display current postion and direction ");
        System.out.println(" EXIT - use this to stop the application ");
        
        boolean applicationRunning = true;
        while (applicationRunning) {
        	 String userInput = keyboard.nextLine();
            if ("EXIT".equals(userInput)) {
            	keyboard.close();
            	applicationRunning = false;
            	System.out.println("You are now out of the application...");
            } else {
                try {
                    String outputMessage = console.process(userInput);
                    if(!outputMessage.equals("true")){
                    	 System.out.println(outputMessage);
                    }
                   
                } catch (PacmanSimulatorException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

	}

}
