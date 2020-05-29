package ru.nsu.g.akononov.arkanoid.model.components;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlankTest {

    @Test
    public void move() {
        Plank plank = new Plank(0, 0, 50, 50, 200);
        plank.move(true);
        assertEquals(25, plank.getX());
    }

    @Test
    public void setSpeedX() {
        Plank plank = new Plank(0, 0, 50, 50, 200);
        plank.setSpeedX(50);
        plank.move(true);
        assertEquals(50, plank.getX());
    }

    @Test
    public void moveOutOfBoard() {
        Plank plank = new Plank(0, 0, 50, 50, 200);
        plank.setSpeedX(200);
        plank.move(true);
        assertEquals(0, plank.getX());
    }
}