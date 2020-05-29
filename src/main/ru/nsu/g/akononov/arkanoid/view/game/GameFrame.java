package ru.nsu.g.akononov.arkanoid.view.game;

import ru.nsu.g.akononov.arkanoid.view.util.ButtonsPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame implements ActionListener {

    final private JPanel frame = new JPanel();

    public GameFrame(GamePanel gamePanel, ButtonsPanel pausePanel) {

        initFrameSettings();

        frame.setPreferredSize(new Dimension(gamePanel.getWidth(), gamePanel.getHeight()));
        frame.setLayout(null);

        frame.add(pausePanel);
        frame.add(gamePanel);

        add(frame);

        pack();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initFrameSettings() {
        setTitle("Arkanoid");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.GRAY);
        setResizable(false);
        setFocusable(true);
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}