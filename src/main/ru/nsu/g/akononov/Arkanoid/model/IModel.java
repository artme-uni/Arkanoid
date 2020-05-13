package ru.nsu.g.akononov.Arkanoid.model;

public interface IModel {
    void registerObserver(Observer observer);
    void notifyObserver(operation operation, int attribute);
}