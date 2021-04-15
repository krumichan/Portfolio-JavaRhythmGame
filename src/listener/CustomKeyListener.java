package listener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import factor.Game;
import scene.GameScene;

public class CustomKeyListener extends KeyAdapter {
	private Game game;
	public CustomKeyListener(Game game) {
		this.game = game;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (game == null) {
			return;
		}
		switch(e.getKeyCode()) {
		case KeyEvent.VK_S: {
			game.pressS();
			break;
		}
		case KeyEvent.VK_D: {
			game.pressD();
			break;
		}
		case KeyEvent.VK_F: {
			game.pressF();
			break;
		}
		case KeyEvent.VK_SPACE: {
			game.pressSpace();
			break;
		}
		case KeyEvent.VK_J: {
			game.pressJ();
			break;
		}
		case KeyEvent.VK_K: {
			game.pressK();
			break;
		}
		case KeyEvent.VK_L: {
			game.pressL();
			break;
		}
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if (game == null) {
			return;
		}
		
		switch(e.getKeyCode()) {
		case KeyEvent.VK_S: {
			game.releaseS();
			break;
		}
		case KeyEvent.VK_D: {
			game.releaseD();
			break;
		}
		case KeyEvent.VK_F: {
			game.releaseF();
			break;
		}
		case KeyEvent.VK_SPACE: {
			game.releaseSpace();
			break;
		}
		case KeyEvent.VK_J: {
			game.releaseJ();
			break;
		}
		case KeyEvent.VK_K: {
			game.releaseK();
			break;
		}
		case KeyEvent.VK_L: {
			game.releaseL();
			break;
		}
		}
	}
}
