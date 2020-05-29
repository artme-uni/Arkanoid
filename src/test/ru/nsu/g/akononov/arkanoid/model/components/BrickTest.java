package ru.nsu.g.akononov.arkanoid.model.components;

import static org.junit.Assert.*;

public class BrickTest {
    @org.junit.Test
    public void brickInit() {
        Brick brick = new Brick(0, 0, 200, 100);
        assertEquals(0, brick.getY());
    }

    @org.junit.Test
    public void isDestroyed() {
        Brick brick = new Brick(0, 0, 200, 100);
        assertEquals(false, brick.isDestroyed());
    }

    @org.junit.Test
    public void setDestroyed() {
        Brick brick = new Brick(0, 0, 200, 100);
        brick.setDestroyed();
        assertEquals(true, brick.isDestroyed());
    }

}