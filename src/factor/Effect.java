package factor;

import java.awt.Graphics2D;

import javax.swing.ImageIcon;

import common.Position;

public abstract class Effect extends Thread {
	protected int frame;
	protected int maxFrame;
	protected float frameDelay;
	protected ImageIcon[] icons;
	protected boolean isLoop;
	protected Position pos;
	protected String path;
	
	public Effect() {
		path = "../animation images";
	}
	public abstract void screenDraw(Graphics2D g);
}
