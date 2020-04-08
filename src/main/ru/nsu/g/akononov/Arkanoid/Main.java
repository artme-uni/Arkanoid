package ru.nsu.g.akononov.Arkanoid;

import ru.nsu.g.akononov.Arkanoid.controller.Controller;
import ru.nsu.g.akononov.Arkanoid.model.Model;
import ru.nsu.g.akononov.Arkanoid.model.components.Ball;
import ru.nsu.g.akononov.Arkanoid.view.View;

import javax.sound.midi.Soundbank;
import java.awt.*;

public class  Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(()-> {
            Model model = new Model(800, 800, 40);
            View view = new View(model);
            model.registerObserver(view);
            model.startGame(1, 5);
        });
    }
}

/*
public class Main {
    public static void main(String[] args) {

        Rectangle r = new Rectangle(100, 100, 200, 200);

        Ball b = new Ball(10, 10, 100, 0 , 0);

        System.out.println(b.contains(r));
    }
}
*/
