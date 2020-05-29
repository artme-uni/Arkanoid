package ru.nsu.g.akononov.arkanoid.model.components;

import static org.junit.Assert.*;

public class BoardTest {
    @org.junit.Test
    public void floorInit() {
        Board board = new Board(100, 100);
        assertEquals(0,(int)board.floor.getX());
        assertEquals(100,(int)board.floor.getY());
        assertEquals(100,(int)board.floor.getWidth());
    }

}