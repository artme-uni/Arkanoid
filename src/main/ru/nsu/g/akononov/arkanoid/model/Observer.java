package ru.nsu.g.akononov.arkanoid.model;

public interface Observer {
    void updateBall();
    void updateBrick(int index);
    void updatePlank();
    void updateWall();
    void updateLife(int count);
    void updatePause();
}