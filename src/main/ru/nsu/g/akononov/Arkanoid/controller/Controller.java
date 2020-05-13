package ru.nsu.g.akononov.Arkanoid.controller;

import ru.nsu.g.akononov.Arkanoid.view.View;

import java.awt.event.*;

public class Controller {

    View view;

    public Controller(View view) {

<<<<<<< HEAD
        this.view = view;

        view.menuFrame.menu.buttons.get("START").addActionListener(e -> {
            view.model.initModel();
            view.initGameFrame();
            view.menuFrame.setVisible(false);
        });

        view.menuFrame.menu.buttons.get("ABOUT").addActionListener(e -> {
            view.menuFrame.menu.setVisibleButtons(false);
            view.menuFrame.about.setVisible(true);
        });

        view.menuFrame.menu.buttons.get("EXIT").addActionListener(e -> System.exit(0));

        view.menuFrame.addKeyListener(new KeyAdapter() {
                                          @Override
                                          public void keyPressed(KeyEvent e) {
                                              if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                                                  view.menuFrame.menu.setVisibleButtons(true);
                                                  saveSettings();
                                                  view.menuFrame.setting.setVisible(false);
                                                  view.menuFrame.about.setVisible(false);
                                              }
                                          }
                                      }
        );

        view.menuFrame.menu.buttons.get("SETTING").addActionListener(e -> {
            view.menuFrame.menu.setVisibleButtons(false);
            view.menuFrame.setting.setVisible(true);
        });

        view.menuFrame.setting.menuButton.addActionListener(e -> {
            saveSettings();
            view.menuFrame.menu.setVisibleButtons(true);
            view.menuFrame.setting.setVisible(false);
        });
    }

    public void saveSettings() {
        view.model.setBoardSize((int) view.menuFrame.setting.frameHeight.getModel().getValue(),
                (int) view.menuFrame.setting.frameWidth.getModel().getValue());

        view.model.setWallSize((int) view.menuFrame.setting.wallHeight.getModel().getValue(),
                (int) view.menuFrame.setting.wallWidth.getModel().getValue());

        view.model.setSpeedLevel((int) view.menuFrame.setting.speed.getModel().getValue());
    }

    public void addGameListener() {
        view.gameFrame.addKeyListener(new KeyAdapter() {
=======
        view.mainFrame.addKeyListener(new KeyAdapter() {
>>>>>>> 66a8622efd91e835c15a2916400a7cb338155e70
            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    view.model.shiftRight(false);
                }

                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    view.model.shiftRight(true);
                }

                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    view.model.playPause();
                }
            }
        });

        view.mainFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                view.model.setDirection(e.getX(), e.getY());
                view.model.startGame();
            }
        });

<<<<<<< HEAD
        view.pausePanel.buttons.get("EXIT").addActionListener(e -> System.exit(0));

        view.pausePanel.buttons.get("MENU").addActionListener(e -> {
            view.model.restartGame();
            view.model.playPause();
            view.gameFrame.dispose();
            view.menuFrame.setVisible(true);
        });

        view.pausePanel.buttons.get("NEW GAME").addActionListener(e -> {
            view.model.restartGame();
            view.model.playPause();
        });
=======
/*        view.menuFrame.
    //.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                view.menuFrame.setVisible(false);
                view.gameFrame.setVisible(true);
                view.gameFrame.setFocusable(true);
            }
        });*/
>>>>>>> 66a8622efd91e835c15a2916400a7cb338155e70

        view.pausePanel.buttons.get("RESUME").addActionListener(e ->
                view.model.playPause());
    }
}
