package ru.nsu.g.akononov.Arkanoid.view.menu;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SettingPanel extends JPanel{

    private Font Font;

    private ArrayList<JComponent> components = new ArrayList<>();

    private JLabel frameSize;
    public JSpinner frameWidth;
    public JSpinner frameHeight;

    private JLabel wallSize;
    public JSpinner wallWidth;
    public JSpinner wallHeight;

    private JLabel speedLevel;
    public JSpinner speed;

    public JButton menuButton;

    int buttonHeight;
    int buttonWidth;
    int buttonOffsetX;

    public SettingPanel(Rectangle area) {
        Font = new Font("Comic Sans MS", Font.TRUETYPE_FONT, area.height / 18);
        setLayout(null);
        setBounds(0, 0, area.width, area.height);
        setOpaque(false);

        buttonHeight = (int) area.getHeight() / 14;
        buttonWidth = (int) area.getWidth() * 3 / 5;
        buttonOffsetX = (int) area.getWidth() / 5;

        initComponents();

        addFrameSizeButtons();
        addMenuButton();
        addSpeedLevelButtons();
        addWallSizeButtons();

        for(var comp : components)
        {
            add(comp);
            setVisible(true);
        }

        setVisible(false);
    }

    private void addFrameSizeButtons() {
        frameSize.setBounds(buttonOffsetX, 2 * buttonHeight, buttonWidth, buttonHeight);
        frameSize.setHorizontalAlignment(JLabel.CENTER);
        frameSize.setFont(Font);
        frameHeight.setBounds(buttonOffsetX + buttonWidth / 2, 3 * buttonHeight, buttonWidth / 2, buttonHeight);
        frameHeight.setFont(Font);
        frameWidth.setBounds(buttonOffsetX, 3 * buttonHeight, buttonWidth / 2, buttonHeight);
        frameWidth.setFont(Font);
    }

    private void addWallSizeButtons() {
        wallSize.setBounds(buttonOffsetX, 5 * buttonHeight, buttonWidth, buttonHeight);
        wallSize.setHorizontalAlignment(JLabel.CENTER);
        wallSize.setFont(Font);
        wallWidth.setBounds(buttonOffsetX + buttonWidth / 2, 6 * buttonHeight, buttonWidth / 2, buttonHeight);
        wallWidth.setFont(Font);
        wallHeight.setBounds(buttonOffsetX, 6 * buttonHeight, buttonWidth / 2, buttonHeight);
        wallHeight.setFont(Font);
    }

    private void addSpeedLevelButtons() {
        speedLevel.setBounds(buttonOffsetX, 8 * buttonHeight, buttonWidth, buttonHeight);
        speedLevel.setHorizontalAlignment(JLabel.CENTER);
        speedLevel.setFont(Font);
        speed.setBounds(buttonOffsetX, 9 * buttonHeight, buttonWidth, buttonHeight);
        speed.setFont(Font);
    }

    private void addMenuButton() {
        menuButton.setBounds(buttonOffsetX, (int) (10.5 * buttonHeight), buttonWidth, buttonHeight);
        menuButton.setFont(Font);
        menuButton.setOpaque(false);
        menuButton.setContentAreaFilled(false);
        menuButton.setBorderPainted(false);
    }

    private void initComponents() {
        frameSize = new JLabel("Window size");
        components.add(frameSize);

        SpinnerNumberModel frameWidthRange = new SpinnerNumberModel(900, 100, 2000, 1);
        frameWidth = new JSpinner(frameWidthRange);
        components.add(frameWidth);

        SpinnerNumberModel frameHeightRange = new SpinnerNumberModel(900, 100, 2000, 1);
        frameHeight = new JSpinner(frameHeightRange);
        components.add(frameHeight);

        wallSize = new JLabel("Wall size");
        components.add(wallSize);

        SpinnerNumberModel wallWidthRange = new SpinnerNumberModel(6, 2, 50, 1);
        wallWidth = new JSpinner(wallWidthRange);
        components.add(wallWidth);

        SpinnerNumberModel wallHeightRange = new SpinnerNumberModel(5, 2, 50, 1);
        wallHeight = new JSpinner(wallHeightRange);
        components.add(wallHeight);

        speedLevel = new JLabel("Ball speed");
        components.add(speedLevel);

        SpinnerNumberModel speedRange = new SpinnerNumberModel(3, 1, 10, 1);
        speed = new JSpinner(speedRange);
        components.add(speed);

        menuButton = new JButton("MENU");
        components.add(menuButton);
    }

}
