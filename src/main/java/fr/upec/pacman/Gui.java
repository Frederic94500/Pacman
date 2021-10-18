package fr.upec.pacman;

import javax.swing.*;

public class Gui {
    public Gui() {
        JFrame frame = new JFrame();
        GameView game = new GameView();

        frame.setSize(375, 435);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Pacman");
        frame.add(game);
        frame.addKeyListener(new PacMove(game));
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
