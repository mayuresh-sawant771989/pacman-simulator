package com.pacman.helper;

public class GridSurface implements Grid{

	 int tabelRows;
	 int tablecColumns;
	 
	public GridSurface(int tabelRows, int tablecColumns){
		this.tabelRows = tabelRows;
       this.tablecColumns = tablecColumns;
	}

	public boolean isPositionValid(Position position) {
		 return !(
	                position.getX() > this.tablecColumns || position.getX() < 0 ||
	                        position.getY() > this.tabelRows || position.getY() < 0
	        );
	}
}
