package ru.nsu.g.akononov.Arkanoid.view;

import ru.nsu.g.akononov.Arkanoid.controller.Controller;
import ru.nsu.g.akononov.Arkanoid.model.Model;
import ru.nsu.g.akononov.Arkanoid.model.Observer;

import java.util.ArrayList;

public class View implements Observer {

    public Model model;
    public Controller controller;
    public MainFrame gameFrame;
    public MenuFrame menuFrame;

    private printableObject ball;
    private printableObject plank;
    private printableObject background;
    private ArrayList<printableObject> wall;


    public View(Model model) {

        this.model = model;

        initGameFrame();
        menuFrame = new MenuFrame();

        this.controller = new Controller(this);
    }

    private void initGameFrame() {
        ball = new printableObject("/ball.png", model.ball.getRadius() * 2, model.ball.getRadius() * 2);
        plank = new printableObject("/plank.png", model.plank.getHeight(), model.plank.getWidth());
        background = new printableObject("/background.png", model.board.getHeight(), model.board.getWidth());
        wall = new ArrayList<>();
        initCoords();

        gameFrame = new MainFrame(model.board.getWidth(), model.board.getHeight(), ball, plank, background, wall);
        gameFrame.setVisible(false);
    }

    private void initCoords() {
        for (int i = 0; i < model.wall.bricks.size(); i++) {
            wall.add(new printableObject("/brick.png", model.wall.getBrickHeight(), model.wall.getBrickWidth()));
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

        gameFrame.repaint();
    }

    @Override
    public void updateBrick(int index) {
        wall.get(index).setVisible(false);
    }

    @Override
    public void updatePlank() {
        plank.setX(model.plank.getX());
        plank.setY(model.plank.getY());

        gameFrame.repaint();
    }

    @Override
    public void updateWall() {
        for (int i = 0; i < model.wall.bricks.size(); i++) {
            wall.get(i).setVisible(true);
        }
    }
}
