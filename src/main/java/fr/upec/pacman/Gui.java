package fr.upec.pacman;

import javax.swing.*;

public class Gui {
    public Gui() {
        JFrame frame = new JFrame();
        frame.setSize(720, 720);
        frame.setTitle("Pacman");
        frame.setContentPane(new GamePanel());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
