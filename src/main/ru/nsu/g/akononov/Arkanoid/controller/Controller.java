package ru.nsu.g.akononov.Arkanoid.controller;

import ru.nsu.g.akononov.Arkanoid.model.Model;
import ru.nsu.g.akononov.Arkanoid.model.Observer;
import ru.nsu.g.akononov.Arkanoid.view.View;

public class Controller implements Observer {
    private Model model;
    private View view;

    private int x;
    private int y;

    public Controller(Model model) {
        this.model = model;
        //view = new View();
    }

    @Override
    public void updateField() {
        System.out.println(x + " " + y);
    }
}
