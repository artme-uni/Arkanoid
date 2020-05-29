package ru.nsu.g.akononov.arkanoid.view.game;

import ru.nsu.g.akononov.arkanoid.view.util.PrintableObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GamePanel extends JPanel implements ActionListener {

    public GamePanel(int width, int height, PrintableObject ball, PrintableObject plank,
                     PrintableObject background, ArrayList<PrintableObject> wall) {

        setBounds(0,0, width, height);
        setPreferredSize(new Dimension(width, height));
        addComponents(ball, plank, wall);

        add(background);
        setVisible(true);
    }

    private void addComponents(PrintableObject ball, PrintableObject plank, ArrayList<PrintableObject> wall) {
        add(plank);
        setVisible(true);

        add(ball);
        setVisible(true);

        for (var brick : wall) {
            add(brick);
            setVisible(true);
        }
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}