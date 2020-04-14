package ru.nsu.g.akononov.Arkanoid.model;

public interface Observer {
    void updateBall();
    void updateWall(int index);
    void updatePlank();
}