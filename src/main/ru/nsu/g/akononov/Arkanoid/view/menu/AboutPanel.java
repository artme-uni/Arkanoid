package ru.nsu.g.akononov.Arkanoid.view.menu;

import javax.swing.*;
import java.awt.*;

public class AboutPanel extends JPanel {

    private static String aboutMessage = "<html><p align=\"center\">Добро пожаловать в ARKANOID!<br>" +
            "<br>Передвигай платформу<br>с помощью клавиш LEFT/RIGHT.<br>" +
            "<br>Чтобы запустить мячик,<br>щелкни в выбранном направления.<br>" +
            "<br>У тебя есть три жизни,<br>чтобы разбить все блоки.<br>" +
            "<br>Удачи!<br>" +
            "<br>ESC - ВЫХОД В МЕНЮ<br>" +
            "<p align=\"center\"></html>";

    final private JLabel about;


    public AboutPanel(int width, int height) {
        setLayout(null);
        setBounds(0, 0, width, height);
        setOpaque(false);

        this.about = new JLabel(aboutMessage);
        about.setVerticalAlignment(JLabel.CENTER);
        about.setHorizontalAlignment(JLabel.CENTER);
        about.setFont(new Font("Comic Sans MS", Font.TRUETYPE_FONT, height / 18 / 2));
        about.setPreferredSize(new Dimension(width, height));
        about.setBounds(0, 0, width, height);

        add(about);
        setVisible(true);
    }
}
