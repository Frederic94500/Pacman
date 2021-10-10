package fr.upec.pacman;

import javax.swing.*;

public class Gui {
    public Gui() {
        JFrame frame = new JFrame();
        var game = new Game();

        frame.setSize(720, 720);
        frame.setTitle("Pacman");
        frame.setContentPane(game.getGamePanel());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
