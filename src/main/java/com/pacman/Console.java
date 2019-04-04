package com.pacman;

import com.pacman.exception.PacmanSimulatorException;
import com.pacman.helper.Command;
import com.pacman.helper.Direction;
import com.pacman.helper.Grid;
import com.pacman.helper.Pacman;
import com.pacman.helper.Position;

public class Console {
	
	Grid grid;
	Pacman pacman;
	
	public Console(Grid grid, Pacman pacman) {
		this.grid = grid;
		this.pacman = pacman;
	}
	
	/**
	 * This methods sets the position of the Pacman according to the user' inputs
	 * @param Position object
	 * @return if valid inputs and successful return true else false
	 * @throws PacmanSimulatorException
	 */
	 public boolean setPacmanPosition(Position position) throws PacmanSimulatorException {

	        if (grid == null)
	            throw new PacmanSimulatorException("Invalid grid object");

	        if (position == null)
	            throw new PacmanSimulatorException("Invalid position");

	        if (position.getDirection() == null)
	            throw new PacmanSimulatorException("Invalid direction");

	        // validate the position
	        if (!grid.isPositionValid(position))
	        	throw new PacmanSimulatorException("Invalid co-ordinates entered");

	        // if position is valid then assign values to fields
	        pacman.setPosition(position);
	        return true;
	    }
	 
	 
		 /**
		  * This method evaluates the user inputs and based on user inputs return necessary output string
		  * @param userInput
		  * @return output string
		  * @throws PacmanSimulatorException
		  */
	    public String process(String userInput) throws PacmanSimulatorException {
	        String[] args = userInput.split(" ");

	        Command command;
	        try {
	            command = Command.valueOf(args[0]);
	        } catch (IllegalArgumentException e) {
	            throw new PacmanSimulatorException("Invalid command");
	        }
	        if (command == Command.PLACE && args.length < 2) {
	            throw new PacmanSimulatorException("Invalid command");
	        }

	        String[] params;
	        int x = 0;
	        int y = 0;
	        Direction commandDirection = null;
	        if (command == Command.PLACE) {
	            params = args[1].split(",");
	            try {
	                x = Integer.parseInt(params[0]);
	                y = Integer.parseInt(params[1]);
	                commandDirection = Direction.valueOf(params[2]);
	            } catch (Exception e) {
	                throw new PacmanSimulatorException("Invalid command");
	            }
	        }

	        String output;

	        switch (command) {
	            case PLACE:
	                output = String.valueOf(setPacmanPosition(new Position(x, y, commandDirection)));
	                break;
	            case MOVE:
	                Position newPosition = pacman.getPosition().getNextPosition();
	                if (!grid.isPositionValid(newPosition))
	                    output = String.valueOf(false);
	                else
	                    output = String.valueOf(pacman.move(newPosition));
	                break;
	            case LEFT:
	                output = String.valueOf(pacman.rotateLeft());
	                break;
	            case RIGHT:
	                output = String.valueOf(pacman.rotateRight());
	                break;
	            case REPORT:
	                output = report();
	                break;
	            default:
	                throw new PacmanSimulatorException("Invalid command");
	        }

	        return output;
	    }
	    
	    /**
	     * This method return the x and y co-rdinates along with the current direction of the Pacman
	     * @return
	     */
	    public String report() {
	        if (pacman.getPosition() == null)
	            return null;

	        return pacman.getPosition().getX() + "," + pacman.getPosition().getY() + "," + pacman.getPosition().getDirection().toString();
	    }
	

}
