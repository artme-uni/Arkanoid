package ru.nsu.g.akononov.arkanoid;

import ru.nsu.g.akononov.arkanoid.model.Model;
import ru.nsu.g.akononov.arkanoid.view.View;

import java.awt.*;

public class  Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(()-> {
            Model model = new Model();
            View view = new View(model);

            model.registerObserver(view);
        });
    }
}
