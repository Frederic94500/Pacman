package fr.upec.pacman;

import javax.swing.*;

public class Gui {
    public Gui() {
        JFrame frame = new JFrame();
        Game game = new Game();

        frame.setSize(375, 435);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Pacman");
        frame.add(game.getView());
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
