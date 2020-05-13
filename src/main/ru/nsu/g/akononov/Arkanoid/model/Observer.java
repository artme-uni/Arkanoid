package ru.nsu.g.akononov.Arkanoid.model;

public interface Observer {
    void updateBall();
    void updateBrick(int index);
    void updatePlank();
    void updateWall();
    void updateLife(int count);
    void updatePause();
}