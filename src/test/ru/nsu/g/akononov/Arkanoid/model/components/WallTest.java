package ru.nsu.g.akononov.Arkanoid.model.components;

import org.junit.Test;

import static org.junit.Assert.*;

public class WallTest {

    @Test
    public void initWall() {
        Wall wall = new Wall(5, 5, new Board(100, 100));
        assertEquals(25, wall.bricks.size());
    }

    @Test
    public void setWall() {
        Wall wall = new Wall(5, 5, new Board(100, 100));
        wall.setWall(7, 7, new Board(100, 100));
        assertEquals(49, wall.bricks.size());
    }

    @Test
    public void getBrickHeight() {
        Wall wall = new Wall(5, 5, new Board(100, 100));
        assertEquals(5, wall.getBrickHeight());
    }

    @Test
    public void getBrickWidth() {
        Wall wall = new Wall(5, 5, new Board(100, 100));
        assertEquals(16, wall.getBrickWidth());
    }
}