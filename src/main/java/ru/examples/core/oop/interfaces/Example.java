package ru.examples.core.oop.interfaces;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Example {


    public static void main(String[] args) {

        /**
         * Создание объекта анонимного класса с переопределением метода интерфейса
         * */
        JButton button = new JButton();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hello!");
            }
        });

        /**
         * Та же запись свёрнутая в лямбду
         * */
        JButton button1 = new JButton();
        button.addActionListener(e -> System.out.println("Hello!"));

    }
}
