package fr.upec.pacman;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PacMove extends KeyAdapter {
	@Override
	public void keyTyped(KeyEvent e) {
		 GameView mapevent = (GameView) e.getSource() ; // recuperer la map en cours 
		 System.out.print("ee");
		 mapevent.setStart(true); 
		 mapevent.repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
