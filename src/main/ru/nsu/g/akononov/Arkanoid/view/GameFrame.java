package ru.nsu.g.akononov.Arkanoid.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.util.ArrayList;

public class GameFrame extends JFrame implements ActionListener {

    public GameFrame(int width, int height,
                     printableObject ball,
                     printableObject plank,
                     printableObject background,
                     ArrayList<printableObject> wall)
    {
        setTitle("Arkanoid");
        setSize( width, height+25);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.GRAY);

        setResizable(false);
        setFocusable(true);

        //add(background);
        setVisible(true);

        add(plank);
        setVisible(true);

        add(ball);
        setVisible(true);

        for (var brick : wall)
        {
            getContentPane().add(brick);
            setVisible(true);
        }

        revalidate();
        repaint();
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}