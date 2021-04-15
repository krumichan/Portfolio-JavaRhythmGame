package factor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import common.Data;
import common.Position;
import id.EFFECT_ID;
import id.IMAGE_ID;
import id.MUSIC_ID;
import id.SCENE_ID;
import manager.BeatManager;
import manager.EffectManager;
import manager.ImageManager;
import manager.MusicManager;
import manager.SceneManager;

public class Game extends Thread {
	private Image noteRouteLineImage;
	private Image judgementLineImage;
	private Image gameInfoImage;
	private Image blueFlareImage;
	private Image judgeImage;
	
	private Image noteRouteSImage;
	private Image noteRouteDImage;
	private Image noteRouteFImage;
	private Image noteRouteSpace1Image;
	private Image noteRouteSpace2Image;
	private Image noteRouteJImage;
	private Image noteRouteKImage;
	private Image noteRouteLImage;
	private Image keyPadSImage;
	private Image keyPadDImage;
	private Image keyPadFImage;
	private Image keyPadSpace1Image;
	private Image keyPadSpace2Image;
	private Image keyPadJImage;
	private Image keyPadKImage;
	private Image keyPadLImage;
	
	public String titleName;
	private String difficulty;
	private MUSIC_ID musicTitle;
	private Music gameMusic;
	
	private Data data;
	
	private final int INDEX_SCORE = 0;
	private final int INDEX_COMBO = 1;
	private final int INDEX_MAX_COMBO = 2;
	private final int INDEX_LIFE = 3;
	
	ArrayList<Note> noteList = new ArrayList<Note>();
	
	private String scoreToString;
	private int score;
	
	private String comboToString;
	private int combo;
	private int maxCombo;
	
	private String lifeToString;
	private int life;
	
	public Game(String titleName, String difficulty, MUSIC_ID musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		this.score = 0;
		this.maxCombo = 0;
		this.combo = 0;
		this.life = 20;
		
		noteRouteLineImage = ImageManager.imageManager().getImage(IMAGE_ID.NOTE_ROUTE_LINE);
		judgementLineImage = ImageManager.imageManager().getImage(IMAGE_ID.JUDGEMENT_LINE);
		gameInfoImage = ImageManager.imageManager().getImage(IMAGE_ID.GAME_INFO);
		
		noteRouteSImage = ImageManager.imageManager().getImage(IMAGE_ID.NOTE_ROUTE);
		noteRouteDImage = ImageManager.imageManager().getImage(IMAGE_ID.NOTE_ROUTE);
		noteRouteFImage = ImageManager.imageManager().getImage(IMAGE_ID.NOTE_ROUTE);
		noteRouteSpace1Image = ImageManager.imageManager().getImage(IMAGE_ID.NOTE_ROUTE);
		noteRouteSpace2Image = ImageManager.imageManager().getImage(IMAGE_ID.NOTE_ROUTE);
		noteRouteJImage = ImageManager.imageManager().getImage(IMAGE_ID.NOTE_ROUTE);
		noteRouteKImage = ImageManager.imageManager().getImage(IMAGE_ID.NOTE_ROUTE);
		noteRouteLImage = ImageManager.imageManager().getImage(IMAGE_ID.NOTE_ROUTE);

		keyPadSImage = ImageManager.imageManager().getImage(IMAGE_ID.KEY_PAD_BASIC);
		keyPadDImage = ImageManager.imageManager().getImage(IMAGE_ID.KEY_PAD_BASIC);
		keyPadFImage = ImageManager.imageManager().getImage(IMAGE_ID.KEY_PAD_BASIC);
		keyPadSpace1Image = ImageManager.imageManager().getImage(IMAGE_ID.KEY_PAD_BASIC);
		keyPadSpace2Image = ImageManager.imageManager().getImage(IMAGE_ID.KEY_PAD_BASIC);
		keyPadJImage = ImageManager.imageManager().getImage(IMAGE_ID.KEY_PAD_BASIC);
		keyPadKImage = ImageManager.imageManager().getImage(IMAGE_ID.KEY_PAD_BASIC);
		keyPadLImage = ImageManager.imageManager().getImage(IMAGE_ID.KEY_PAD_BASIC);
		
		data = new Data();
		data.iData = new int[4]; // index(0) : score, index(1) : combo, index(2) : maxCombo, index(3) : life
		data.iData[0] = this.score;
		data.iData[1] = this.combo;
		data.iData[2] = this.maxCombo;
		data.iData[3] = this.life;
		
		gameMusic = MusicManager.musicManager().getMusic(this.musicTitle, true);
	}
	
	
	private void correctScore(int score) {		
		if ((this.score += score) < 0) {
			this.score = 0;
		}
		
		data.iData[INDEX_SCORE] = this.score;
	}
	
	
	private void correctCombo(boolean isMissed) {
		this.combo = (isMissed == true ? 0 : combo + 1);
		
		if (this.maxCombo < this.combo) {
			this.maxCombo = this.combo;
		}
		
		data.iData[INDEX_MAX_COMBO] = this.maxCombo;
		data.iData[INDEX_COMBO] = this.combo;
	}
	
	
	private void correctLife(int life) {
		int tmpLife = this.life + life;
		if (tmpLife <= 0) {
			this.life = 0;
		} else
		if (tmpLife >= 20) {
			this.life = 20;
		} else {
			this.life += life;
		}
		
		data.iData[INDEX_LIFE] = this.life;
		if (this.life <= 0) {
			data.strData = new String[1];
			data.strData[0] = titleName;
			SceneManager.sceneManager().createAndLoad(SCENE_ID.SCORE, data);
		}
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(noteRouteSImage, 228, 30, null);
		g.drawImage(noteRouteDImage, 332, 30, null);
		g.drawImage(noteRouteFImage, 436, 30, null);
		g.drawImage(noteRouteSpace1Image, 540, 30, null);
		g.drawImage(noteRouteSpace2Image, 640, 30, null);
		g.drawImage(noteRouteJImage, 744, 30, null);
		g.drawImage(noteRouteKImage, 848, 30, null);
		g.drawImage(noteRouteLImage, 952, 30, null);
		g.drawImage(noteRouteLineImage, 224, 30, null);
		g.drawImage(noteRouteLineImage, 328, 30, null);
		g.drawImage(noteRouteLineImage, 432, 30, null);
		g.drawImage(noteRouteLineImage, 536, 30, null);
		g.drawImage(noteRouteLineImage, 740, 30, null);
		g.drawImage(noteRouteLineImage, 844, 30, null);
		g.drawImage(noteRouteLineImage, 948, 30, null);
		g.drawImage(noteRouteLineImage, 1052, 30, null);
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0, 580, null);
		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if (note.getY() > 620) {
				correctScore(-50);
				correctCombo(true);
				correctLife(-1);
				judgeImage = ImageManager.imageManager().getImage(IMAGE_ID.JUDGE_MISS);
			}
			if (!note.isProceeded()) {
				noteList.remove(i--);
			} else {
				note.screenDraw(g);
			}
		}
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(titleName, 20,  702);
		g.drawString(difficulty, 1190, 702);
		g.setFont(new Font("Arial", Font.PLAIN, 26));
		g.setColor(Color.DARK_GRAY);
		g.drawString("S", 270,  609);
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("Space Bar", 580, 609);
		g.drawString("J",  784,  609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		g.setFont(new Font("Elephant", Font.BOLD, 30));
		scoreToString = String.format("%06d", score);
		g.drawString(scoreToString, 565, 702);
		comboToString = String.format("%04d", combo);
		g.drawString(comboToString, 850, 702);
		lifeToString = String.format("%02d", life);
		g.drawString(lifeToString, 1000, 702);
		g.drawImage(blueFlareImage, 240, 400, null);
		g.drawImage(judgeImage, 460, 420, null);
		g.drawImage(keyPadSImage, 228, 580, null);
		g.drawImage(keyPadDImage, 332, 580, null);
		g.drawImage(keyPadFImage, 436, 580, null);
		g.drawImage(keyPadSpace1Image, 540, 580, null);
		g.drawImage(keyPadSpace2Image, 640, 580, null);
		g.drawImage(keyPadJImage, 744, 580, null);
		g.drawImage(keyPadKImage, 848, 580, null);
		g.drawImage(keyPadLImage, 952, 580, null);
		
		EffectManager.effectManager().screenDraw(g);
	}
	
	public void pressS() {
		judge("S");
		noteRouteSImage = ImageManager.imageManager().getImage(IMAGE_ID.NOTE_ROUTE_PRESSED);
		keyPadSImage = ImageManager.imageManager().getImage(IMAGE_ID.KEY_PAD_PRESSED);
		MusicManager.musicManager().getMusic(MUSIC_ID.DRUM_SMALL_1, false).start();
	}
	
	public void releaseS() {
		noteRouteSImage = ImageManager.imageManager().getImage(IMAGE_ID.NOTE_ROUTE);
		keyPadSImage = ImageManager.imageManager().getImage(IMAGE_ID.KEY_PAD_BASIC);
	}
	
	public void pressD() {
		judge("D");
		noteRouteDImage = ImageManager.imageManager().getImage(IMAGE_ID.NOTE_ROUTE_PRESSED);
		keyPadDImage = ImageManager.imageManager().getImage(IMAGE_ID.KEY_PAD_PRESSED);
		MusicManager.musicManager().getMusic(MUSIC_ID.DRUM_SMALL_1, false).start();
	}
	
	public void releaseD() {
		noteRouteDImage = ImageManager.imageManager().getImage(IMAGE_ID.NOTE_ROUTE);
		keyPadDImage = ImageManager.imageManager().getImage(IMAGE_ID.KEY_PAD_BASIC);
	}
	
	public void pressF() {
		judge("F");
		noteRouteFImage = ImageManager.imageManager().getImage(IMAGE_ID.NOTE_ROUTE_PRESSED);
		keyPadFImage = ImageManager.imageManager().getImage(IMAGE_ID.KEY_PAD_PRESSED);
		MusicManager.musicManager().getMusic(MUSIC_ID.DRUM_SMALL_1, false).start();
	}
	
	public void releaseF() {
		noteRouteFImage = ImageManager.imageManager().getImage(IMAGE_ID.NOTE_ROUTE);
		keyPadFImage = ImageManager.imageManager().getImage(IMAGE_ID.KEY_PAD_BASIC);
	}
	
	public void pressSpace() {
		judge("Space");
		noteRouteSpace1Image = ImageManager.imageManager().getImage(IMAGE_ID.NOTE_ROUTE_PRESSED);
		noteRouteSpace2Image = ImageManager.imageManager().getImage(IMAGE_ID.NOTE_ROUTE_PRESSED);
		keyPadSpace1Image = ImageManager.imageManager().getImage(IMAGE_ID.KEY_PAD_PRESSED);
		keyPadSpace2Image = ImageManager.imageManager().getImage(IMAGE_ID.KEY_PAD_PRESSED);
		MusicManager.musicManager().getMusic(MUSIC_ID.DRUM_BIG_1, false).start();
	}
	
	public void releaseSpace() {
		noteRouteSpace1Image = ImageManager.imageManager().getImage(IMAGE_ID.NOTE_ROUTE);
		noteRouteSpace2Image = ImageManager.imageManager().getImage(IMAGE_ID.NOTE_ROUTE);
		keyPadSpace1Image = ImageManager.imageManager().getImage(IMAGE_ID.KEY_PAD_BASIC);
		keyPadSpace2Image = ImageManager.imageManager().getImage(IMAGE_ID.KEY_PAD_BASIC);
	}
	
	public void pressJ() {
		judge("J");
		noteRouteJImage = ImageManager.imageManager().getImage(IMAGE_ID.NOTE_ROUTE_PRESSED);
		keyPadJImage = ImageManager.imageManager().getImage(IMAGE_ID.KEY_PAD_PRESSED);
		MusicManager.musicManager().getMusic(MUSIC_ID.DRUM_SMALL_1, false).start();
	}
	
	public void releaseJ() {
		noteRouteJImage = ImageManager.imageManager().getImage(IMAGE_ID.NOTE_ROUTE);
		keyPadJImage = ImageManager.imageManager().getImage(IMAGE_ID.KEY_PAD_BASIC);
	}
	
	public void pressK() {
		judge("K");
		noteRouteKImage = ImageManager.imageManager().getImage(IMAGE_ID.NOTE_ROUTE_PRESSED);
		keyPadKImage = ImageManager.imageManager().getImage(IMAGE_ID.KEY_PAD_PRESSED);
		MusicManager.musicManager().getMusic(MUSIC_ID.DRUM_SMALL_1, false).start();
	}
	
	public void releaseK() {
		noteRouteKImage = ImageManager.imageManager().getImage(IMAGE_ID.NOTE_ROUTE);
		keyPadKImage = ImageManager.imageManager().getImage(IMAGE_ID.KEY_PAD_BASIC);
	}
	
	public void pressL() {
		judge("L");
		noteRouteLImage = ImageManager.imageManager().getImage(IMAGE_ID.NOTE_ROUTE_PRESSED);
		keyPadLImage = ImageManager.imageManager().getImage(IMAGE_ID.KEY_PAD_PRESSED);
		MusicManager.musicManager().getMusic(MUSIC_ID.DRUM_SMALL_1, false).start();
	}
	
	public void releaseL() {
		noteRouteLImage = ImageManager.imageManager().getImage(IMAGE_ID.NOTE_ROUTE);
		keyPadLImage = ImageManager.imageManager().getImage(IMAGE_ID.KEY_PAD_BASIC);
	}
	
	@Override
	public void run() {
		dropNotes(this.titleName);
	}
	
	public void close() {
		gameMusic.close();
		Thread.currentThread().interrupt();
		for (Note note : noteList) {
			if (note.isProceeded()) {
				note.close();
			}
		}
	}
	
	public void dropNotes(String titleName) {
		Beat[] beats = BeatManager.beatManager().getBeats(titleName, difficulty);
		gameMusic.start();
		
		int i = 0;
		while (i < beats.length && !isInterrupted()) {
			boolean dropped = false;
			
			if (beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			
			if (!dropped) {
				try {
					sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		boolean finish = false;
		while (!finish) {
			for (Note note : noteList) { 
				if (!note.isProceeded() || 
					!note.isInterrupted()) {
					finish = true;
					break;
				}
				
				if (finish) {
					break;
				}
			}
		}
		
		try {
			sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		data.strData = new String[1];
		data.strData[0] = titleName;
		SceneManager.sceneManager().load(SCENE_ID.SCORE, data);
		data = null;
	}
	
	public void judge(String input) {
		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if (input.equals(note.getNoteType())) {
				final String judge = note.judge();
				createTouchEffect(note, judge);
				calculateScore(judge);
				calculateCombo(judge);
				calculateLife(judge);
				judgeEvent(judge);
				break;
			}
		}
	}
	
	public void judgeEvent(String judge) {
		IMAGE_ID id = IMAGE_ID.NONE;
		switch(judge) {
		case "Late": 	id = IMAGE_ID.JUDGE_LATE; 		break;
		case "Good": 	id = IMAGE_ID.JUDGE_GOOD; 		break;
		case "Great": 	id = IMAGE_ID.JUDGE_GREAT; 		break;
		case "Perfect": id = IMAGE_ID.JUDGE_PERFECT; 	break;
		case "Early": 	id = IMAGE_ID.JUDGE_EALRY;		break;
		}
		
		if (!id.equals(IMAGE_ID.NONE)) {
			blueFlareImage = ImageManager.imageManager().getImage(IMAGE_ID.BLUE_FLARE);
			judgeImage = ImageManager.imageManager().getImage(id);
		}
	}
	
	public void calculateScore(String judge) {
		switch(judge) {
		case "Late": correctScore(-25); break;
		case "Good": correctScore(25 * (int)(1 + this.combo * 0.1)); break;
		case "Great": correctScore(50 * (int)(1 + this.combo * 0.1)); break;
		case "Perfect": correctScore(100 * (int)(1 + this.combo * 0.1)); break;
		case "Early": correctScore(-25); break;
		}
	}
	
	public void calculateCombo(String judge) {
		switch(judge) {
		case "Late": correctCombo(true); break;
		case "Good": correctCombo(false); break;
		case "Great": correctCombo(false); break;
		case "Perfect": correctCombo(false); break;
		case "Early": correctCombo(true); break;
		}
	}
	
	public void calculateLife(String judge) {
		switch(judge) {
		case "Late": correctLife(-1); break;
		case "Good": correctLife(0); break;
		case "Great": correctLife(+1); break;
		case "Perfect": correctLife(+2); break;
		case "Early": correctLife(-1); break;
		}
	}
	
	public void createTouchEffect(Note note, String judge) {
		if (judge == "Perfect" ||
			judge == "Great" ||
			judge == "Good") {
			EffectManager.effectManager().createEffect(
					EFFECT_ID.B_EFFECT
					,new Position(note.getX(), 580));
		}
			
	}
}
