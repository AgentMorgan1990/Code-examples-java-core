package ru.examples.swing;

import javax.swing.*;
import java.awt.*;

public class SimpleCounter extends JFrame {

    int counter = 0;

    public SimpleCounter() {
        setBounds(200, 200, 400, 120);
        setTitle("Simple counter");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Font font = new Font("Arial", Font.ITALIC, 32);

        JLabel label = new JLabel(String.valueOf(counter));
        label.setFont(font);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);

        Button decrementButton = new Button("-");
        decrementButton.setFont(font);
        decrementButton.setBackground(Color.LIGHT_GRAY);
        add(decrementButton, BorderLayout.WEST);

        Button incrementButton = new Button("+");
        incrementButton.setFont(font);
        incrementButton.setBackground(Color.LIGHT_GRAY);
        add(incrementButton, BorderLayout.EAST);

        decrementButton.addActionListener(e -> {
            counter--;
            label.setText(String.valueOf(counter));
        });

        incrementButton.addActionListener(e -> {
            counter++;
            label.setText(String.valueOf(counter));
        });

        setVisible(true);
    }
}
