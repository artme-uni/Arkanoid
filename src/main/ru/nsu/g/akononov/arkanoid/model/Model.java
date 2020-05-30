package ru.nsu.g.akononov.arkanoid.model;

import ru.nsu.g.akononov.arkanoid.model.components.*;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Model implements IModel {
    public Ball ball;
    public Board board;
    public Wall wall;
    public Plank plank;

    private boolean inGame = false;
    public boolean onPause = false;

    private int lifeCount = 3;

    private int bricksCountWidth = 6;
    private int bricksCountHeight = 5;

    private int boardHeight = 900;
    private int boardWidth = 900;

    private int refreshRate = 30;
    private int ballSpeedX;
    private int ballSpeedY;
    private int plankSpeed;

    double speedLevel = 1;

    Timer timer = new Timer();
    private boolean taskIsScheduled = false;
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            if (plank.move()) {
                notifyObserver(operation.PLANK, 0);
                if (!inGame && !onPause) {
                    ball.shift(plank.isMovingRight(), board.getWidth());
                    notifyObserver(operation.BALL, 0);
                }
            }

            if (!onPause && inGame) {
                ball.move();

                for (var r : board.barriers) {
                    ball.reflection(r);
                }

                if (ball.reflection(board.floor)) {
                    if (lifeCount == 1)
                        restartGame();
                    else
                        respawn();
                }

                ball.reflection(plank.getArea());

                for (int i = 0; i < wall.bricks.size(); i++) {

                    if (!wall.bricks.get(i).isDestroyed() && ball.reflectBrick(wall.bricks.get(i))) {
                        notifyObserver(operation.BRICK, i);
                        wall.currentBrickCount--;
                    }

                    if (wall.currentBrickCount == 0)
                        restartGame();
                }

                notifyObserver(operation.BALL, 0);
            }
        }
    };


    public void setBoardSize(int boardHeight, int boardWidth) {
        this.boardHeight = boardHeight;
        this.boardWidth = boardWidth;
    }

    public void setWallSize(int bricksCountHeight, int bricksCountWidth) {
        this.bricksCountHeight = bricksCountHeight;
        this.bricksCountWidth = bricksCountWidth;
    }

    public void setSpeedLevel(int speed) {
        speedLevel = (double) speed / 3;
    }

    public Model() {
    }

    public void initModel() {
        board = new Board(boardHeight, boardWidth);
        int ballRadius = board.getHeight() / 20;
        ball = new Ball(board.getWidth() / 2, board.getHeight() - 2 * ballRadius, ballRadius);
        plank = new Plank((int) (board.getWidth() / 2 - 2 * ballRadius), board.getHeight() - ballRadius, ballRadius * 4, ballRadius, board.getWidth());
        wall = new Wall(bricksCountWidth, bricksCountHeight, board);

        plankSpeed = (int) (boardWidth / 100 * speedLevel);
        plank.setSpeedX(plankSpeed);
        ball.setShift(plankSpeed);

        if (!taskIsScheduled) {
            timer.schedule(task, 0, refreshRate);
            taskIsScheduled = true;
        }
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
            ball.setSpeedX(ballSpeedX, (double) boardHeight / 900 * speedLevel);
            ball.setSpeedY(ballSpeedY, (double) boardHeight / 900 * speedLevel);

            inGame = true;
        }
    }

    public void restartGame() {
        inGame = false;
        wall.restoreBricks();
        lifeCount = 3;

        initModel();
        notifyObserver(operation.BALL, 0);
        notifyObserver(operation.WALL, 0);
        notifyObserver(operation.PLANK, 0);
        notifyObserver(operation.LIFE, lifeCount);
    }

    public void respawn() {
        inGame = false;
        ball.setDefaultDirection();
        lifeCount--;

        ball.getArea().x = board.getWidth() / 2 - ball.getHeight() / 2;
        ball.getArea().y = board.getHeight() - ball.getHeight() * 3 / 2;
        plank.getArea().x = board.getWidth() / 2 - 2 * ball.getHeight() / 2;
        plank.getArea().y = board.getHeight() - ball.getHeight() / 2;

        notifyObserver(operation.PLANK, 0);
        notifyObserver(operation.BALL, 0);
        notifyObserver(operation.LIFE, lifeCount);
    }

    public void playPause() {
        onPause = !onPause;
        plank.setMoving(false);
        notifyObserver(operation.PAUSE, 0);
    }

    public void startPlankShifting(boolean isRight) {

        if (!onPause) {
                plank.setMoving(true);
                plank.setMovingRight(isRight);
            }
    }

    public void stopPlankShifting(boolean isRight) {
        if (plank.isMoving() && (plank.isMovingRight() == isRight)) {
            plank.setMoving(false);
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
            case LIFE: {
                for (Observer observer : observers) {
                    observer.updateLife(attribute);
                }
            }
            case PAUSE: {
                for (Observer observer : observers) {
                    observer.updatePause();
                }
            }
        }
    }
}