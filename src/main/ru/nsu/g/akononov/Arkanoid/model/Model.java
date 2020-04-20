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
    private boolean onPause = false;

    private int bricksCountWidth = 6;
    private int bricksCountHeight = 5;

    private int refreshRate = 30;
    private int ballSpeedX = 15;
    private int ballSpeedY = 15;
    private int plankSpeed = 50;


    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            if (!onPause && inGame) {
                ball.move();

                for (var r : board.barriers) {
                    ball.reflection(r);
                }

                if (ball.reflection(board.floor)) {
                    restartGame();
                }

                ball.reflection(plank.getArea());

                for (int i = 0; i < wall.bricks.size(); i++) {

                    if (!wall.bricks.get(i).isDestroyed() && ball.reflectBrick(wall.bricks.get(i))) {
                        notifyObserver(operation.BRICK, i);
                        wall.currentBrickCount --;
                    }

                    if(wall.currentBrickCount == 0)
                        restartGame();
                }

                notifyObserver(operation.BALL, 0);
            }
        }
    };

    public Model(int boardHeight, int boardWidth) {

        timer.schedule(task, 0, refreshRate);
        initModel(boardHeight, boardWidth);
    }

    public void initModel(int boardHeight, int boardWidth) {
        int ballRadius = boardHeight / 20;

        board = new Board(boardHeight, boardWidth);
        ball = new Ball(boardWidth / 2, boardHeight - 2 * ballRadius, ballRadius);
        plank = new Plank((int) (boardWidth / 2 - 2 * ballRadius), boardHeight - ballRadius, ballRadius * 4, ballRadius, boardWidth);
        wall = new Wall(bricksCountWidth, bricksCountHeight, board);
    }

    public void setDirection(int pointX, int pointY) {
        if (!inGame) {
            int legX = pointX - ball.getX() - ball.getWidth() / 2;
            int legY = ball.getY() - pointY + ball.getHeight() / 2;

            if (legY < 0) {
                ballSpeedY = 1;
                if (legX < 0)
                    ballSpeedX = -15;
                else
                    ballSpeedX = 15;
                return;
            }

            while (Math.sqrt(legX * legX + legY * legY) > 15) {
                legX /= 1.2;
                legY /= 1.2;
            }

            ballSpeedX = legX != 0 ? legX : 1;
            ballSpeedY = legY != 0 ? legY : 1;
        }
    }

    public void startGame() {

        if (!inGame) {
            ball.setSpeedX(ballSpeedX);
            ball.setSpeedY(ballSpeedY);

            inGame = true;
        }
    }

    public void restartGame() {
        inGame = false;
        wall.restoreBricks();

        initModel(board.getHeight(), board.getWidth());
        notifyObserver(operation.BALL, 0);
        notifyObserver(operation.WALL, 0);
        notifyObserver(operation.PLANK, 0);
    }

    public void playPause() {
        onPause = !onPause;
    }

    public void shift(boolean isRight) {
        if (!inGame) {
            plank.setSpeedX(plankSpeed);
            ball.setShift(plankSpeed);

            ball.shift(isRight, board.getWidth());
            notifyObserver(operation.BALL, 0);
        }

        if (!onPause) {
            plank.move(isRight);
            notifyObserver(operation.PLANK, 0);
        }
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

            case BRICK: {
                for (Observer observer : observers) {
                    observer.updateBrick(attribute);
                }
                break;
            }

            case WALL: {
                for (Observer observer : observers) {
                    observer.updateWall();
                }
                break;
            }

            case PLANK: {
                for (Observer observer : observers) {
                    observer.updatePlank();
                }
                break;
            }
        }
    }
}