package ru.nsu.g.akononov.Arkanoid.model;

import ru.nsu.g.akononov.Arkanoid.model.components.Ball;
import ru.nsu.g.akononov.Arkanoid.model.components.Board;
import ru.nsu.g.akononov.Arkanoid.model.components.Brick;
import ru.nsu.g.akononov.Arkanoid.model.components.Wall;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;

public class Model implements IModel {

    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            ball.move();
            notifyObserver();
        }
    };

    public Ball ball;
    public Board board;
    public Wall wall;

    public Model(int boardHeight, int boardWidth, int ballRadius) {

        board = new Board(boardHeight, boardWidth);
        ball = new Ball(boardWidth / 2, boardHeight / 2, ballRadius , board);
        wall = new Wall();
    }

    public void startGame(int ballSpeedX, int ballSpeedY) {
        ball.setSpeedX(ballSpeedX);
        ball.setSpeedY(ballSpeedY);

        timer.schedule(task, 0, 10);
    }


    private ArrayList<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        if (observer == null) {
            throw new NullPointerException();
        }
        if (observers.contains(observer)) {
            throw new IllegalArgumentException("Repeated observer:" + observer);
        }

        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if (observer == null) {
            throw new NullPointerException();
        }
        if (observers.contains(observer)) {
            throw new IllegalArgumentException("Repeated observer:" + observer);
        }
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer obser : observers) {
            obser.updateField();
        }
    }
}
