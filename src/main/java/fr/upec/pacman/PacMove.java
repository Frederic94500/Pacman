package fr.upec.pacman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class PacMove implements KeyListener {
    private GameView view;

    public PacMove(GameView view) {
        this.view = view;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                makeMove(-1, 0);
                break;
            case KeyEvent.VK_RIGHT:
                makeMove(1, 0);
                break;
            case KeyEvent.VK_DOWN:
                makeMove(0, 1);
                break;
            case KeyEvent.VK_UP:
                makeMove(0, -1);
                break;
        }

        view.repaint();
        /*try {
            Pacman player = p.getGame().getPacman();
            Thread.sleep(100);
            Type[][] map = p.getGame().getMap().getMap();

            int k = e.getKeyCode();

            if (k == KeyEvent.VK_LEFT) {
                Thread.sleep(300);
                for (int i = 0; i < map.length; i++) {

                    for (int j = 0; j < map[i].length; j++) {
                        // On cherche la place du pacman.
                        if (map[i][j] == Type.P) {
                            if (j != 0) {
                                if (map[i][j - 1] != Type.W) {
                                    if (map[i][j - 1] == Type.C) {
                                        player.setScore(player.getScore() + 10);
                                    }
                                    map[i][j] = Type.N;
                                    map[i][j - 1] = Type.P;
                                    p.repaint();
                                    break;
                                }

                                player.setX(player.getX() - 36);
                            } else {
                                map[i][j] = Type.N;
                                map[i][map[i].length - 1] = Type.P;
                                if (map[i][0] == Type.C) {
                                    player.setScore(player.getScore() + 10);
                                }
                                player.setX(36 * 9);
                            }
                        }
                    }
                }
            }


            // Right
            if (k == KeyEvent.VK_RIGHT) {
                Thread.sleep(300);
                for (int i = 0; i < map.length; i++) {
                    for (int j = 0; j < map[i].length; j++) {
                        if (map[i][j] == Type.P) {
                            if (j != map[i].length - 1) {
                                if (map[i][j + 1] != Type.W) {
                                    if (map[i][j + 1] == Type.C) {
                                        player.setScore(player.getScore() + 10);
                                    }
                                    map[i][j] = Type.N;
                                    map[i][j + 1] = Type.P;
                                    player.setY(player.getX() + 36);
                                    j = 100;
                                    i = 100; // stop boucle
                                }
                            } else {
                                if (map[i][0] == Type.C) {
                                    player.setScore(player.getScore() + 10);
                                }
                                map[i][j] = Type.N;
                                map[i][0] = Type.P;
                                player.setY(0);
                                j = 100;
                                i = 100;
                            }
                        }
                    }
                }
            }

            // Up

            if (k == KeyEvent.VK_DOWN) {
                Thread.sleep(300);
                for (int i = 0; i < map.length; i++) {
                    for (int j = 0; j < map[i].length; j++) {
                        if (map[i][j] == Type.P) {
                            if (map[i + 1][j] != Type.W) {
                                if (map[i + 1][j] == Type.C) {
                                    player.setScore(player.getScore() + 10);
                                }
                                map[i][j] = Type.N;
                                map[i + 1][j] = Type.P;
                                player.setY(player.getY() - 36);
                                j = 100;
                                i = 100; // stop boucle
                            }
                        }
                    }
                }
            }
            // Down
            if (k == KeyEvent.VK_UP) {
                Thread.sleep(300);

                for (int i = 0; i < map.length; i++) {
                    for (int j = 0; j < map[i].length; j++) {
                        if (map[i][j] == Type.P) {
                            if (i != 0) {
                                if (map[i - 1][j] != Type.W) {
                                    if (map[i - 1][j] == Type.C) {
                                        player.setScore(player.getScore() + 10);
                                    }
                                    map[i][j] = Type.N;
                                    map[i - 1][j] = Type.P;
                                    player.setY(player.getY() + 36);
                                }
                            }
                        }
                    }
                }
            }
            Thread.sleep(300);
            p.repaint();
        } catch (Exception em) {
        }*/
    }

    public void makeMove(int dx, int dy) {
        int[] pacmanCoordsMap = view.getGame().getMap().getPacmanCoords();
        //int[] pacmanCoords = p.getGame().getPacman().getCoords(); //Je suis pas sûr si c'est utile étant donné qu'on connait déjà les coords de Pacman
        Type[][] map = view.getGame().getMap().getMap();

        //WarpAround à réimplémenter!!!

        if (map[pacmanCoordsMap[0] + dx][pacmanCoordsMap[1] + dy] != Type.W) {
            switch (map[pacmanCoordsMap[0] + dx][pacmanCoordsMap[1] + dy]) {
                case C:
                    view.getGame().getPacman().addScore(100);
                    break;
                case I:
                    view.getGame().getPacman().addScore(300);
                    break;
                case S:
                    view.getGame().getPacman().addScore(500);
                    break;
                case M:
                    view.getGame().getPacman().addScore(1000);
                    break;
            }

            map[pacmanCoordsMap[0]][pacmanCoordsMap[1]] = Type.N;
            map[pacmanCoordsMap[0] + dx][pacmanCoordsMap[1] + dy] = Type.P;
            //p.getGame().getPacman().setCoords();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
