package scene;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JFrame;

import common.Data;
import dynamic_beat.Main;

public abstract class Scene {
	protected JFrame frame;
	protected Image screenImage;
	protected Graphics screenGraphic;
	public Data data;
	
	public Scene(JFrame frame) {
		this.frame = frame;
	}

	public abstract void create();
	public abstract void already();
	public abstract void load();
	public abstract void load(Data data);
	public abstract void close();
	
	public void paint(Graphics g) {
		screenImage = frame.createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D)screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}
	
	public void screenDraw(Graphics2D g) {
		frame.paintComponents(g);
//		try {
//			Thread.sleep(5);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		frame.repaint();
	}
}
