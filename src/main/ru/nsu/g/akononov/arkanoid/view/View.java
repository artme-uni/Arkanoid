package ru.nsu.g.akononov.arkanoid.view;

import ru.nsu.g.akononov.arkanoid.controller.Controller;
import ru.nsu.g.akononov.arkanoid.model.Model;
import ru.nsu.g.akononov.arkanoid.model.Observer;
import ru.nsu.g.akononov.arkanoid.view.game.GameFrame;
import ru.nsu.g.akononov.arkanoid.view.game.GamePanel;
import ru.nsu.g.akononov.arkanoid.view.menu.MenuFrame;
import ru.nsu.g.akononov.arkanoid.view.util.ImageLoader;
import ru.nsu.g.akononov.arkanoid.view.util.ButtonsPanel;
import ru.nsu.g.akononov.arkanoid.view.util.PrintableObject;

import java.awt.*;
import java.util.ArrayList;

public class View implements Observer {

    public Model model;
    public Controller controller;

    public GameFrame gameFrame;
    public GamePanel gamePanel;
    public ButtonsPanel pausePanel;

    public MenuFrame menuFrame;

    private ImageLoader images = new ImageLoader();

    private PrintableObject ball;
    private int ballSpeedX;
    private int ballSpeedY;

    private PrintableObject plank;
    private PrintableObject background;
    private ArrayList<PrintableObject> wall;

    public View(Model model) {
        this.model = model;
        menuFrame = new MenuFrame(images.foregroundMenu, images.backgroundGame);

        this.controller = new Controller(this);
    }

    public void initGameFrame() {
        ball = new PrintableObject(images.ball3, model.ball.getRadius() * 2, model.ball.getRadius() * 2);
        ballSpeedX = model.ball.getSpeedX();
        ballSpeedY = model.ball.getSpeedY();

        plank = new PrintableObject(images.plank, model.plank.getHeight(), model.plank.getWidth());
        background = new PrintableObject(images.backgroundGame, model.board.getHeight(), model.board.getWidth());
        wall = new ArrayList<>();
        initCoords();

        Rectangle area = new Rectangle(model.board.getWidth() / 2 - model.board.getHeight() / 6,
                model.board.getHeight() / 4, model.board.getHeight() / 3, model.board.getHeight() / 2);


        String[] pauseButtons = {"RESUME", "NEW GAME", "MENU", "EXIT"};
        pausePanel = new ButtonsPanel(images.backgroundPause, area, pauseButtons);

        gamePanel = new GamePanel(model.board.getWidth(), model.board.getHeight(), ball, plank, background, wall);
        gameFrame = new GameFrame(gamePanel, pausePanel);
        gameFrame.setVisible(true);
        gameFrame.setFocusable(true);

        controller.addGameListener();
    }

    private void initCoords() {
        for (int i = 0; i < model.wall.bricks.size(); i++) {
            wall.add(new PrintableObject(images.brick, model.wall.getBrickHeight(), model.wall.getBrickWidth()));
            wall.get(i).setX(model.wall.bricks.get(i).getX());
            wall.get(i).setY(model.wall.bricks.get(i).getY());
        }

        plank.setX(model.plank.getX());
        plank.setY(model.plank.getY());

        ball.setX(model.ball.getX());
        ball.setY(model.ball.getY());
    }

    @Override
    public void updateBall() {
        int oldX = ball.getX();
        int oldY = ball.getY();

        ball.setX(model.ball.getX());
        ball.setY(model.ball.getY());

        gameFrame.repaint(oldX, oldY, ball.getWidth(), ball.getHeight()*3/2);
        gameFrame.repaint(ball.getX() - ballSpeedX, ball.getY() - ballSpeedY,
                ball.getWidth() + 2*ballSpeedX, ball.getHeight()*3/2 + 2*ballSpeedY);
    }

    @Override
    public void updateBrick(int index) {
        PrintableObject brick = wall.get(index);
        brick.setVisible(false);

        gameFrame.repaint();
    }

    @Override
    public void updatePlank() {
        int oldX = plank.getX();
        int oldY = plank.getY();

        plank.setX(model.plank.getX());
        plank.setY(model.plank.getY());

        gameFrame.repaint(plank.getX(), plank.getY()+plank.getHeight()/2, plank.getWidth(), plank.getHeight());
        gameFrame.repaint(oldX, oldY, plank.getWidth()+plank.getHeight()/2, plank.getHeight());
    }

    @Override
    public void updateWall() {
        for (int i = 0; i < model.wall.bricks.size(); i++) {
            wall.get(i).setVisible(true);
        }
    }

    @Override
    public void updateLife(int lifeCount) {

        switch (lifeCount) {
            case 3:
                ball.editImage(images.ball3);
                break;
            case 2:
                ball.editImage(images.ball2);
                break;
            case 1:
                ball.editImage(images.ball1);
                break;
        }
    }

    @Override
    public void updatePause() {
        pausePanel.setVisible(model.onPause);
    }
}
