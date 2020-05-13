package ru.nsu.g.akononov.Arkanoid.view.util;

import ru.nsu.g.akononov.Arkanoid.view.util.PrintableObject;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class ButtonsPanel extends JPanel{

    private int currentButtonCount = 1;
    private int maxButtonCount;

    private int buttonHeight;
    private int buttonWidth;

    public Map<String, JButton> buttons;
    public PrintableObject background;
    public Font Font;

    public ButtonsPanel(Image backgroundImage, Rectangle area, String[] buttonsNames) {

        setBounds(area.x, area.y, area.width, area.height);
        setBackground(backgroundImage, area);
        setLayout(null);

        Font = new Font("Comic Sans MS", Font.TRUETYPE_FONT, area.height / 18);

        maxButtonCount = buttonsNames.length;

        buttonHeight = background.getHeight() / (maxButtonCount * 2 + 3);
        buttonWidth = background.getWidth() * 2 / 3;

        buttons = new LinkedHashMap<>();

        for (var name : buttonsNames) {
            buttons.put(name, new JButton(name));
        }
        addAllButtons();
        add(background);

        setVisible(false);
    }

    private void setBackground(Image backgroundImage, Rectangle area) {
        background = new PrintableObject(backgroundImage, area.height, area.width);
    }

    private void addAllButtons() {
        for (var currentButton : buttons.values()) {
            addButton(currentButton);
            add(currentButton);
        }
    }

    public void setVisibleButtons(boolean isVisible)
    {
        for (var currentButton : buttons.values()) {
            currentButton.setVisible(isVisible);
        }
    }

    private void addButton(JButton button) {
        int buttonOffsetX = buttonWidth / 4 + background.getX();
        int buttonOffsetY = (currentButtonCount * 2) * buttonHeight + background.getY();

        button.setBounds(buttonOffsetX, buttonOffsetY, buttonWidth, buttonHeight);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFont(Font);

        currentButtonCount++;
    }
}