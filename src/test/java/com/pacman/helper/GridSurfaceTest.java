package com.pacman.helper;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;

public class GridSurfaceTest {
	
	@Test
    public void testIsPositionValid() throws Exception {
        Position mockPosition = mock(Position.class);
        when(mockPosition.getX()).thenReturn(6);
        when(mockPosition.getY()).thenReturn(7);

        GridSurface gridSurface = new GridSurface(5, 5);
        Assert.assertFalse(gridSurface.isPositionValid(mockPosition));


        when(mockPosition.getX()).thenReturn(1);
        when(mockPosition.getY()).thenReturn(1);
        Assert.assertTrue(gridSurface.isPositionValid(mockPosition));


        when(mockPosition.getX()).thenReturn(-1);
        when(mockPosition.getY()).thenReturn(-1);
        Assert.assertFalse(gridSurface.isPositionValid(mockPosition));
    }

}
