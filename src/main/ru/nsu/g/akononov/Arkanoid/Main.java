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
            Model model = new Model(900, 900);
            View view = new View(model);

            model.registerObserver(view);
        });
    }
}
