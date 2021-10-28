package fr.upec.pacman;

import javax.swing.*;

public class Gui {
    public Gui() {
        JFrame frame = new JFrame();
        Game game = new Game();
        GameView gameView = new GameView(frame, game);

        frame.setSize(590, 435);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Pacman");
        frame.add(gameView);
        frame.addKeyListener(new PacMove(gameView, game.getPacman()));
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
