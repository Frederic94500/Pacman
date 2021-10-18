package fr.upec.pacman;

import javax.swing.*;

public class Gui {
    public Gui() {
        JFrame frame = new JFrame();
        GameView gameView = new GameView();

        frame.setSize(375, 435);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Pacman");
        frame.add(gameView);
        frame.addKeyListener(new PacMove(gameView));
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
