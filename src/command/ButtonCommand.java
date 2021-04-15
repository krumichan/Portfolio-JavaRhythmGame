package command;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public abstract class ButtonCommand extends MouseAdapter {
	protected JButton button = null;
	
	public void setButton(JButton button) {
		this.button = button;
	}
	
	public abstract void entered(MouseEvent e);
	public abstract void exited(MouseEvent e);
	public abstract void pressed(MouseEvent e);
	
	@Override
	public void mouseEntered(MouseEvent e) {
		entered(e);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		exited(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		pressed(e);
	}
	
}
