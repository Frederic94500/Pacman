package fr.upec.pacman;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel{
    private GameMap map;

    public GamePanel(GameMap map) {
        this.map = map;
    }

    @Override
    public void paint(Graphics g) {
        int x = 0; int y = 0; int size = 20;

        for (var i: map.getMap().entrySet()) {
            x = 0;
            for (var j: i.getValue().entrySet()) {
                switch (j.getValue()){
                    case W:
                        g.setColor(Color.BLACK);
                        g.fillRect(x, y, size, size);
                        break;
                    case C:
                        g.setColor(Color.decode("#2020d4"));
                        g.fillRect(x+7, y+7, size-7*2, size-7*2);
                        break;
                    case I:
                        g.setColor(Color.decode("#9f40ff"));
                        g.fillRect(x+4, y+4, size-4*2, size-4*2);
                        break;
                    case S:
                        g.setColor(Color.decode("#FFA500"));
                        g.fillRect(x+4, y+4, size-4*2, size-4*2);
                        break;
                    case M:
                        g.setColor(Color.decode("#2ed12e"));
                        g.fillRect(x+4, y+4, size-4*2, size-4*2);
                        break;
                    case N:
                        g.setColor(Color.WHITE);
                        g.fillRect(x, y, size, size);
                }
                x += size;
            }
            y += size;
        }
    }
}
