package effects;

import java.awt.Graphics2D;

import javax.swing.ImageIcon;

import common.Position;
import dynamic_beat.Main;
import factor.Effect;
import manager.EffectManager;

public class BEffect extends Effect {
	public BEffect(Position pos) {
		frame = 0;
		maxFrame = 25;
		frameDelay = 0.02f;
		isLoop = false;
		icons = new ImageIcon[maxFrame];
		this.pos = pos;
		this.pos.x -= 40;
		this.pos.y -= 75;
		for (int i = 0; i < icons.length; i++) {
			icons[i] = new ImageIcon(Main.class.getResource(String.format(path + "/effect02/effectB_%02d.png", i)));
		}
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				if (frame < maxFrame) {
					Thread.sleep(Main.SLEEP_TIME);
					frame++;
				} else {
					EffectManager.effectManager().removeEffect(this);
					interrupt();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void screenDraw(Graphics2D g) {
		if (frame >= maxFrame) {
			return;
		}
		g.drawImage(icons[frame].getImage(), pos.x, pos.y, null);
	}
}
