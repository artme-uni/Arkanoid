package ru.nsu.g.akononov.Arkanoid.controller;

import ru.nsu.g.akononov.Arkanoid.model.Model;
import ru.nsu.g.akononov.Arkanoid.view.View;

import javax.swing.*;
import java.awt.event.*;

public class Controller {

    public Controller(View view) {

        view.gameFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                final boolean right = true;

                if(e.getKeyCode() == KeyEvent.VK_LEFT)
                {
                    view.model.shift(!right);
                }

                if(e.getKeyCode() == KeyEvent.VK_RIGHT)
                {
                    view.model.shift(right);
                }

                if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
                {
                    view.model.playPause();
                }
            }
        });

        view.gameFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                view.model.setDirection(e.getX(), e.getY());
                view.model.startGame();
            }
        });

        view.menuFrame.start.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                view.menuFrame.setVisible(false);
                view.gameFrame.setVisible(true);
                view.gameFrame.setFocusable(true);
            }
        });

    }
}
