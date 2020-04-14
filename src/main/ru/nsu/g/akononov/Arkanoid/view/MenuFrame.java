package ru.nsu.g.akononov.Arkanoid.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame extends JFrame implements ActionListener {

    /**
     * Соотношение сторон
     * Направление мячика
     * Уровен сложности
     */

    private int height = 0;
    private int width = 0;
    private int buttonSize = 0;


    MenuFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        width = screenSize.width / 2;
        height = screenSize.height / 2;
        buttonSize = height / 9;

        setTitle("Setting");
        setSize(width, height + 25);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.GRAY);

        setResizable(false);
        setFocusable(true);

        setVisible(true);

        addButtons();
    }

    private void addButtons()
    {
        var resolutionWidth = new JSpinner(new SpinnerNumberModel());
        //var resolutionHeight = new JSpinner(new SpinnerNumberModel());
        //var directionX = new JSpinner(new SpinnerNumberModel());
        //var directionY = new JSpinner(new SpinnerNumberModel());
        //var level = new JSpinner(new SpinnerNumberModel());

        resolutionWidth.setBounds(width /2, buttonSize, buttonSize, buttonSize);
        //resolutionHeight.setBounds(width /2 + 2*buttonSize, buttonSize, buttonSize, buttonSize);
        //directionX.setBounds(width /2, buttonSize, 4*buttonSize, buttonSize);
        //directionY.setBounds(width /2 + 2*buttonSize, 4*buttonSize, buttonSize, buttonSize);
        //directionX.setBounds(width /2, buttonSize, 7*buttonSize, buttonSize);

        //add(resolutionHeight);
        add(resolutionWidth);
        //add(directionX);
        //add(directionY);
        //add(level);

        /*var b = new JButton("Multiply (*)");//create button
        b.setBounds(130,200,100, 40);

        add(b);*/

    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
