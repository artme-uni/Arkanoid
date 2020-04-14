package ru.nsu.g.akononov.Arkanoid.controller;

import ru.nsu.g.akononov.Arkanoid.model.Model;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller {
    Model model;
    JFrame gameFrame;

    public Controller(Model model, JFrame gameFrame) {
        this.model = model;
        this.gameFrame = gameFrame;

        gameFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                final boolean right = true;

                if(e.getKeyCode() == KeyEvent.VK_LEFT)
                {
                    model.movePlank(!right);
                }

                if(e.getKeyCode() == KeyEvent.VK_RIGHT)
                {
                    model.movePlank(right);
                }

                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    model.startGame();
                }
            }
        });
    }
}
