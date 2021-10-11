package fr.upec.pacman;

import javax.swing.*;

public class Gui {
    public Gui() {
        JFrame frame = new JFrame();
        frame.setSize(375, 435);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Pacman");
        frame.add(new GameView());
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
