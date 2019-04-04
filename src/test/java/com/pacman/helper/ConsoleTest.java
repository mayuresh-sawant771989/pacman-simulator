package com.pacman.helper;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.pacman.Console;
import com.pacman.exception.PacmanSimulatorException;

public class ConsoleTest {
	
	final int GRID_ROWS = 5;
    final int GRID_COLUMNS = 5;
    
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    
    @Test
    public void testPacmanPlacing() throws PacmanSimulatorException {

        GridSurface gridSurface = new GridSurface(GRID_ROWS, GRID_COLUMNS);
        Pacman pacman = new Pacman();
        Console console = new Console(gridSurface, pacman);

        Assert.assertTrue(console.setPacmanPosition(new Position(0, 1, Direction.NORTH)));
        Assert.assertTrue(console.setPacmanPosition(new Position(2, 2, Direction.SOUTH)));
        exceptionRule.expect(PacmanSimulatorException.class);
        exceptionRule.expectMessage("Invalid co-ordinates entered");
        console.setPacmanPosition(new Position(6, 6, Direction.WEST));
        console.setPacmanPosition(new Position(-1, 5, Direction.EAST));
    }

}
