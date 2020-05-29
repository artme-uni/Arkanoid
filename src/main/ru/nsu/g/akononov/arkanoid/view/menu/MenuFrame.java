package ru.nsu.g.akononov.arkanoid.view.menu;

import ru.nsu.g.akononov.arkanoid.view.util.ButtonsPanel;
import ru.nsu.g.akononov.arkanoid.view.util.PrintableObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame extends JFrame implements ActionListener {

    final private JPanel frame = new JPanel();
    public ButtonsPanel menu;
    public JPanel background;

    public SettingPanel setting;
    public JPanel about;

    int width;
    int height;

    public MenuFrame(Image foregroundImage, Image backgroundImage) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        width = screenSize.width / 3;
        height = screenSize.height * 2 / 3;
        Rectangle area = new Rectangle(0,0,width, height);

        initFrameSettings();

        frame.setPreferredSize(new Dimension(width, height));
        frame.setLayout(null);

        about = new AboutPanel(width, height);
        about.setVisible(false);
        frame.add(about);

        setting = new SettingPanel(area);
        frame.add(setting);

        String[] buttonsNames = {"START", "SETTING", "ABOUT", "EXIT"};
        menu = new ButtonsPanel(foregroundImage, area, buttonsNames);
        menu.setVisible(true);

        frame.add(menu);

        background = new PrintableObject(backgroundImage, height, width);
        frame.add(background);

        add(frame);
        pack();

        setLocationRelativeTo(null);
        setVisible(true);
    }


    private void initFrameSettings() {
        setTitle("Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.GRAY);
        setResizable(false);
        setFocusable(true);
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
