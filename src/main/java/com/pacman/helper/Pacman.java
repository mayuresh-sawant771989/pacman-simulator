package com.pacman.helper;

import com.pacman.exception.PacmanSimulatorException;

public class Pacman {
	
	 private Position position;
	 
	 public Pacman() {}
	 
	 public Pacman(Position position) {
		 this.position = position;
	 }
	
	 public boolean setPosition(Position position) {
	    if (position == null){
	    	return false;
	    }
	
	    this.position = position;
	    return true;
	 }
	 
	 public boolean move() throws PacmanSimulatorException {
       return move(position.getNextPosition());
	 }
	 
	
	 /**
		 * Moves the pacman one unit forward in the direction it is currently facing
		 * @param newPosition
		 * @return true if successful
		 */
	 public boolean move(Position newPosition) {
       if (newPosition == null)
           return false;

       this.position = newPosition;
       return true;
	 }

   public Position getPosition() {
       return this.position;
   }
   
   /**
    * Rotates the pacman to LEFT
    *
    * @return true if rotated successfully
    */
   public boolean rotateLeft() {
       if (this.position.direction == null)
           return false;

       this.position.direction = this.position.direction.leftDirection();
       return true;
   }

   /**
    * Rotates the pacman to RIGHT
    *
    * @return true if rotated successfully
    */
   public boolean rotateRight() {
       if (this.position.direction == null)
           return false;

       this.position.direction = this.position.direction.rightDirection();
       return true;
   }
}
