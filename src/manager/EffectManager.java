package manager;

import java.awt.Graphics2D;
import java.util.ArrayList;

import common.Position;
import effects.AEffect;
import effects.BEffect;
import effects.BoomEffect;
import factor.Effect;
import id.EFFECT_ID;

public class EffectManager {
	private ArrayList<Effect> effects = new ArrayList<Effect>();
	private EffectManager() {};
	private static EffectManager instance;
	public static EffectManager effectManager() {
		if (instance == null) {
			instance = new EffectManager();
		}
		
		return instance;
	}

	public void createEffect(EFFECT_ID id, Position pos) {
		Effect ef = null;
		switch(id) {
			case BOOM_EFFECT:
				ef = new BoomEffect(pos);
				effects.add(ef);
				ef.start();
				break;
				
			case A_EFFECT:
				ef = new AEffect(pos);
				effects.add(ef);
				ef.start();
				break;
				
			case B_EFFECT:
				ef = new BEffect(pos);
				effects.add(ef);
				ef.start();
				break;
		}
	}
	
	public void screenDraw(Graphics2D g) {
		for (int i = 0; i < effects.size(); i++) {
			Effect effect = effects.get(i);
			if (effect.isInterrupted() ||
				!effect.isAlive()) {
				continue;
			}
			
			effect.screenDraw(g);
		}
	}
	
	public void removeEffect(Effect ef) {
		effects.remove(effects.indexOf(ef));
	}
}
