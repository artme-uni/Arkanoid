package ru.nsu.g.akononov.arkanoid.model.components;

import java.awt.*;

import static org.junit.Assert.*;

public class BallTest {

    @org.junit.Test
    public void getRadius() {
        Ball ball = new Ball(0, 0, 500);
        assertEquals(500, ball.getRadius());
    }

    @org.junit.Test
    public void move() {
        Ball ball = new Ball(0, 0, 10);
        ball.move();
        assertEquals(-9, ball.getX());
    }

    @org.junit.Test
    public void setSpeedX() {
        Ball ball = new Ball(0, 0, 10);
        ball.setSpeedX(40, 0.5);
        ball.move();
        assertEquals(10, ball.getX());
    }

    @org.junit.Test
    public void setSpeedY() {
        Ball ball = new Ball(0, 0, 10);
        ball.setSpeedY(40, 0.5);
        ball.move();
        assertEquals(-30, ball.getY());
    }

    @org.junit.Test
    public void moveBack() {
        Ball ball = new Ball(0, 0, 10);
        ball.move();
        ball.moveBack();
        assertEquals(-10, ball.getY());
    }

    @org.junit.Test
    public void shift() {
        Ball ball = new Ball(0, 0, 10);
        ball.shift(true, 500);
        assertEquals(15, ball.getX());
    }

    @org.junit.Test
    public void setShift() {
        Ball ball = new Ball(0, 0, 10);
        ball.setShift(50);
        ball.shift(true, 500);
        assertEquals(40, ball.getX());
    }

    @org.junit.Test
    public void reflection() {
        Ball ball = new Ball(0, 0, 10);
        ball.reflection(new Rectangle(5, -20, 40, 40));
        ball.move();
        assertEquals(-11, ball.getX());
    }

    @org.junit.Test
    public void setDefaultDirection() {
        Ball ball = new Ball(0, 0, 10);
        ball.reflection(new Rectangle(5, -20, 40, 40));
        ball.setDefaultDirection();
        ball.move();
        assertEquals(-9, ball.getX());
    }

}