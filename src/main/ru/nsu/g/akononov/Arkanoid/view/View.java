package ru.nsu.g.akononov.Arkanoid.view;

import ru.nsu.g.akononov.Arkanoid.controller.Controller;
import ru.nsu.g.akononov.Arkanoid.model.Model;
import ru.nsu.g.akononov.Arkanoid.model.Observer;
import ru.nsu.g.akononov.Arkanoid.view.game.GameFrame;
import ru.nsu.g.akononov.Arkanoid.view.game.GamePanel;
import ru.nsu.g.akononov.Arkanoid.view.menu.MenuFrame;
import ru.nsu.g.akononov.Arkanoid.view.util.ImageLoader;
import ru.nsu.g.akononov.Arkanoid.view.util.ButtonsPanel;
import ru.nsu.g.akononov.Arkanoid.view.util.PrintableObject;

import java.awt.*;
import java.util.ArrayList;

public class View implements Observer {

    public Model model;
    public Controller controller;
<<<<<<< HEAD

    public GameFrame gameFrame;
    public GamePanel gamePanel;
    public ButtonsPanel pausePanel;

    public MenuFrame menuFrame;

    private ImageLoader images = new ImageLoader();
=======
    public MainFrame mainFrame;

    private PrintableObject ball;
    private PrintableObject plank;
    private ArrayList<PrintableObject> wall;
>>>>>>> 66a8622efd91e835c15a2916400a7cb338155e70

    private PrintableObject ball;
    private PrintableObject plank;
    private PrintableObject background;
    private ArrayList<PrintableObject> wall;

    public View(Model model) {
        this.model = model;
<<<<<<< HEAD
        menuFrame = new MenuFrame(images.foregroundMenu, images.backgroundGame);
=======
        initGameFrame();
        mainFrame = new MainFrame(model.board.getWidth(), model.board.getHeight(), ball, plank,wall);
>>>>>>> 66a8622efd91e835c15a2916400a7cb338155e70

        this.controller = new Controller(this);
    }

<<<<<<< HEAD
    public void initGameFrame() {
        ball = new PrintableObject(images.ball3, model.ball.getRadius() * 2, model.ball.getRadius() * 2);
        plank = new PrintableObject(images.plank, model.plank.getHeight(), model.plank.getWidth());
        background = new PrintableObject(images.backgroundGame, model.board.getHeight(), model.board.getWidth());
        wall = new ArrayList<>();
        initCoords();

        Rectangle area = new Rectangle(model.board.getWidth()/2 - model.board.getHeight()/6,
                model.board.getHeight()/4, model.board.getHeight()/3, model.board.getHeight()/2);


        String[] pauseButtons = {"RESUME", "NEW GAME", "MENU", "EXIT"};
        pausePanel = new ButtonsPanel(images.backgroundPause, area, pauseButtons);

        gamePanel = new GamePanel(model.board.getWidth(), model.board.getHeight(), ball, plank, background, wall);
        gameFrame = new GameFrame(gamePanel, pausePanel);
        gameFrame.setVisible(true);
        gameFrame.setFocusable(true);

        controller.addGameListener();
=======
    private void initGameFrame() {
        ball = new PrintableObject("/ball.png", model.ball.getRadius() * 2, model.ball.getRadius() * 2);
        plank = new PrintableObject("/plank.png", model.plank.getHeight(), model.plank.getWidth());
        wall = new ArrayList<>();
        initCoords();
>>>>>>> 66a8622efd91e835c15a2916400a7cb338155e70
    }

    private void initCoords() {
        for (int i = 0; i < model.wall.bricks.size(); i++) {
<<<<<<< HEAD
            wall.add(new PrintableObject(images.brick, model.wall.getBrickHeight(), model.wall.getBrickWidth()));
=======
            wall.add(new PrintableObject("/brick.png", model.wall.getBrickHeight(), model.wall.getBrickWidth()));
>>>>>>> 66a8622efd91e835c15a2916400a7cb338155e70
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
        ball.setX(model.ball.getX());
        ball.setY(model.ball.getY());

        mainFrame.repaint();
    }

    @Override
    public void updateBrick(int index) {
        wall.get(index).setVisible(false);
    }

    @Override
    public void updatePlank() {
        plank.setX(model.plank.getX());
        plank.setY(model.plank.getY());

        mainFrame.repaint();
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
