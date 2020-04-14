package ru.nsu.g.akononov.Arkanoid.model;

import ru.nsu.g.akononov.Arkanoid.model.components.*;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Model implements IModel {

    public Ball ball;
    public Board board;
    public Wall wall;
    public Plank plank;

    private boolean inGame = false;

    private int bricksCountWidth = 6;
    private int bricksCountHeight = 5;

    private int refreshRate = 30;
    private int ballSpeedX = 10;
    private int ballSpeedY = 10;
    private int plankSpeed = 50;


    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            for (int i = 0; i < wall.bricks.size(); i++) {

                if(!wall.bricks.get(i).isDestroyed() && ball.reflectBrick(wall.bricks.get(i))) {
                    notifyObserver(operation.WALL, i);
                }
            }

            ball.move();
            notifyObserver(operation.BALL, 0);

            for (var r : board.barriers) {
                ball.reflection(r);
            }

            ball.reflection(plank.getArea());
        }
    };

    public Model(int boardHeight, int boardWidth) {

        int ballRadius = boardHeight / 20;

        board = new Board(boardHeight, boardWidth);
        ball = new Ball(boardWidth / 2, boardHeight - 2* ballRadius, ballRadius);
        plank = new Plank((int) ( boardWidth / 2 - 2*ballRadius), boardHeight - ballRadius, ballRadius*4, ballRadius, boardWidth);
        wall = new Wall(bricksCountWidth, bricksCountHeight, board);
    }

    public void startGame() {

        if (inGame)
        {
            return;
        }

        ball.setSpeedX(ballSpeedX);
        ball.setSpeedY(ballSpeedY);

        plank.setSpeedX(plankSpeed);

        timer.schedule(task, 0, refreshRate);
        inGame = true;
    }

    public void movePlank(boolean isRight)
    {
        plank.move(isRight);
        notifyObserver(operation.PLANK, 0);
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
    public void notifyObserver(operation operation, int attribute) {

        switch (operation) {
            case BALL: {
                for (Observer observer : observers) {
                    observer.updateBall();
                }
                break;
            }

            case WALL: {
                for (Observer observer : observers) {
                    observer.updateWall(attribute);
                }
                break;
            }
            case PLANK:
                for (Observer observer : observers) {
                    observer.updatePlank();
                }
                break;
        }
    }
}