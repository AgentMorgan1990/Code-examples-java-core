package ru.examples.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWindow extends JFrame {
    int randomNumber;

    public MyWindow() {
        randomNumber = (int) (Math.random() * 10) + 1; // 1 - 10 Math.random() - возвращает число от 0 до 9.99
        setTitle("Игра");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 400);

        Font font = new Font("Arial", Font.BOLD, 32);

        JTextField textField = new JTextField();
        add(textField,BorderLayout.CENTER);
        textField.setFont(font);
        textField.addActionListener(e -> System.out.println(textField.getText()));

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Окно закрывается");
            }
        });

        JButton button = new JButton("Кнопка");
        add(button, BorderLayout.BEFORE_FIRST_LINE);
        button.addActionListener(e -> button.setText("Нажал"));

        setVisible(true);
    }

}
