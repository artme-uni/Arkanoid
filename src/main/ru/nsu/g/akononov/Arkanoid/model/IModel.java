package ru.nsu.g.akononov.Arkanoid.model;

public interface IModel {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver();
}