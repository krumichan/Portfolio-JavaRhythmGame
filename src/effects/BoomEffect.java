package effects;

import java.awt.Graphics2D;

import javax.swing.ImageIcon;

import common.Position;
import dynamic_beat.Main;
import factor.Effect;
import manager.EffectManager;

public class BoomEffect extends Effect {
	public BoomEffect(Position pos) {
		frame = 0;
		maxFrame = 21;
		frameDelay = 0.02f;
		isLoop = false;
		icons = new ImageIcon[maxFrame];
		this.pos = pos;
		for (int i = 0; i < icons.length; i++) {
			icons[i] = new ImageIcon(Main.class.getResource(path + "/effect00/boom" + i +".png"));
		}
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				if (frame < maxFrame) {
					Thread.sleep(Main.SLEEP_TIME);
					frame++;
				} else {
					EffectManager.effectManager().removeEffect(this);
					interrupt();
					break;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void screenDraw(Graphics2D g) {
		if (frame >= maxFrame) return;
		g.drawImage(icons[frame].getImage(), pos.x, pos.y, null);
	}
}
