package ru.nsu.g.akononov.Arkanoid.view;

import ru.nsu.g.akononov.Arkanoid.model.Model;
import ru.nsu.g.akononov.Arkanoid.model.Observer;
import ru.nsu.g.akononov.Arkanoid.model.components.Ball;
import ru.nsu.g.akononov.Arkanoid.model.components.Plank;

import javax.swing.*;

public class View implements Observer {

    private Model model;
    public BallGUI ball;
    public PlankGUI plank;

    private AppFrame frame;

    public View(Model model){

        this.model = model;

        ball = new BallGUI();
        plank = new PlankGUI();

        frame = new AppFrame(ball, plank);
    }

    @Override
    public void updateField() {
        ball.setX(model.ball.getX());
        ball.setY(model.ball.getY());

        //System.out.println(model.ball.getX() + " " + model.ball.getY());

        frame.validate();
        frame.repaint();
    }
}
