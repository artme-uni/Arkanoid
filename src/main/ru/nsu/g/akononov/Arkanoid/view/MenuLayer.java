package ru.nsu.g.akononov.Arkanoid.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class MenuLayer extends JPanel {

    private int height = 0;
    private int width = 0;
    private int buttonSize = 0;

    public JButton start;

    @Override
    public void paintComponents(Graphics g) {
        System.out.println("sdfbadfjokbva;sfnijvbadskfv");
        super.paintComponents(g);
    }



    MenuLayer() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        width = screenSize.width / 4;
        height = screenSize.height / 2;
        buttonSize = height / 9;

        setSize(width, height + 25);

        Dimension size = new Dimension(width, height);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);

        //setBackground(Color.GRAY);
        setBackground(Color.cyan);
        //setOpaque(false);

        //add(new PrintableObject("/ball.png", 900, 900));
        //setLayout(null);
        //setVisible(true);

        addButtons();

        add(new PrintableObject("/ball.png", 900, 900));

        setFocusable(true);
        setVisible(true);

        //revalidate();
        //repaint();
    }

    private void addButtons() {

        start = new JButton("START");
        start.setBounds(width/6, height/8, width*2/3,height/9);
/*        try {
            Image img = ImageIO.read(getClass().getResourceAsStream("/button1.png"));
            start.setIcon(new ImageIcon(img.getScaledInstance(width*2/3,height/9, Image.SCALE_DEFAULT )));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }*/

        add(start);
        setVisible(true);

        JButton button = new JButton("SETTING");
        button.setBounds(width/6, height*3/9, width*2/3,height/9);
        add(button);
        //setLayout(null);
        setVisible(true);

        JButton about = new JButton("ABOUT");
        about.setBounds(width/6, height*5/9, width*2/3,height/9);
        add(about);
        //setLayout(null);
        setVisible(true);

        JButton exit = new JButton("EXIT");
        exit.setBounds(width/6, height*7/9, width*2/3,height/9);
        add(exit);
        //setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
