package ru.nsu.g.akononov.arkanoid.model;

public interface IModel {
    void registerObserver(Observer observer);
    void notifyObserver(operation operation, int attribute);
}