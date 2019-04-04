package com.pacman.helper;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.pacman.exception.PacmanSimulatorException;

public class PacmanTest {

	@Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testMovement() throws PacmanSimulatorException {

        Pacman pacman = new Pacman(new Position(0, 0, Direction.NORTH));

        Assert.assertTrue(pacman.move());
        Assert.assertEquals(0, pacman.getPosition().getX());
        Assert.assertEquals(1, pacman.getPosition().getY());
        Assert.assertEquals(Direction.NORTH, pacman.getPosition().getDirection());


        pacman.setPosition(new Position(1, 2, Direction.EAST));
        pacman.move();
        pacman.move();
        pacman.rotateLeft();
        pacman.move();

        Assert.assertEquals(3, pacman.getPosition().getX());
        Assert.assertEquals(3, pacman.getPosition().getY());
        Assert.assertEquals(Direction.NORTH, pacman.getPosition().getDirection());

        pacman.setPosition(new Position(0, 0, Direction.NORTH));
        pacman.rotateRight();
        Assert.assertEquals(Direction.EAST, pacman.getPosition().getDirection());
        pacman.rotateRight();
        Assert.assertEquals(Direction.SOUTH, pacman.getPosition().getDirection());
        pacman.rotateRight();
        Assert.assertEquals(Direction.WEST, pacman.getPosition().getDirection());
        pacman.rotateRight();
        Assert.assertEquals(Direction.NORTH, pacman.getPosition().getDirection());
        pacman.rotateRight();
        Assert.assertEquals(Direction.EAST, pacman.getPosition().getDirection());
    }



}
