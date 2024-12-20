package com.joevno.swing;

import lombok.val;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SimpleSwingUI extends JFrame {
    private final JLabel label;
    private final JButton button;

    private SimpleSwingUI() {
        label = new JLabel("Hello, World!");
        button = new JButton("Click Me");
    }

    public static SimpleSwingUI newInstance() {
        val ui = new SimpleSwingUI();
        ui.createUI();
        return ui;
    }

    private void createUI() {
        val panel = new JPanel();
        panel.add(label);
        panel.add(button);

        button.addActionListener(e -> label.setText("Button Clicked"));

        add(panel);
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            SimpleSwingUI ui = SimpleSwingUI.newInstance();
            ui.setVisible(true);
        });
    }
}
