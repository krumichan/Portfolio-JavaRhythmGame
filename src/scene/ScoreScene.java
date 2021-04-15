package scene;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import common.Data;
import common.Position;
import common.Size;
import database.ScoreDAO;
import database.ScoreEntity;
import dynamic_beat.Main;
import factor.Music;
import id.IMAGE_ID;
import id.MUSIC_ID;
import id.SCENE_ID;
import manager.ButtonManager;
import manager.ImageManager;
import manager.MusicManager;
import manager.SceneManager;

public class ScoreScene extends Scene {
	private JButton btnBack;
	
	private Image background;
	private Image scoreBackground;
	private Music music;
	
	public ScoreScene(JFrame frame) {
		super(frame);
		create();
	}
	
	public ScoreScene(JFrame frame, boolean already) {
		super(frame);
		already();
	}
	
	public ScoreScene(JFrame frame, Data data) {
		super(frame);
		this.data = data;
		create();
	}
	
	public ScoreScene(JFrame frame, Data data, boolean already) {
		super(frame);
		this.data = data;
		already();
	}
	
	@Override
	public void create() {
		if (data.iData[3] == 0) {
			background = ImageManager.imageManager().getImage(IMAGE_ID.GAME_OVER_BACKGROUND);
			music = MusicManager.musicManager().getMusic(MUSIC_ID.GAME_OVER_MUSIC, true);
		} else {
			background = ImageManager.imageManager().getImage(IMAGE_ID.GAME_CLEAR_BACKGROUND);
			music = MusicManager.musicManager().getMusic(MUSIC_ID.GAME_CLEAR_MUSIC, true);
		}
		scoreBackground = ImageManager.imageManager().getImage(IMAGE_ID.SCORE_BACKGROUND);
		
		music.start();
		
		btnBack = ButtonManager.buttonManager().buttonCreate(
				new Position(20, 50)
				,new Size(60, 60)
				,ImageManager.imageManager().getImageIcon(IMAGE_ID.BACK_BUTTON_BASIC)
				,"score_scene_back");
		ButtonManager.buttonManager().addButtonEvent(btnBack, new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				backMain();
			}
		});
		btnBack.setVisible(true);
		frame.add(btnBack);
	}
	
	@Override
	public void already() {
		btnBack = ButtonManager.buttonManager().buttonCreate(
				new Position(20, 50)
				,new Size(60, 60)
				,ImageManager.imageManager().getImageIcon(IMAGE_ID.BACK_BUTTON_BASIC)
				,"score_scene_back");
		ButtonManager.buttonManager().addButtonEvent(btnBack, new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				backMain();
			}
		});
		btnBack.setVisible(false);
		frame.add(btnBack);
	}
	
	@Override
	public void load() {
		if (data.iData[3] == 0) {
			background = ImageManager.imageManager().getImage(IMAGE_ID.GAME_OVER_BACKGROUND);
			music = MusicManager.musicManager().getMusic(MUSIC_ID.GAME_OVER_MUSIC, true);
		} else {
			background = ImageManager.imageManager().getImage(IMAGE_ID.GAME_CLEAR_BACKGROUND);
			music = MusicManager.musicManager().getMusic(MUSIC_ID.GAME_CLEAR_MUSIC, true);
		}
		scoreBackground = ImageManager.imageManager().getImage(IMAGE_ID.SCORE_BACKGROUND);
		
		music.start();
		
		ScoreEntity score = new ScoreEntity();
		score.setId(Main.LOGIN_ID);
		score.setScore(data.iData[0]);
		score.setSongTitle(data.strData[0]);
		
		ScoreDAO dao = new ScoreDAO();
		dao.insert(score);
		
		setVisible(true);
	}
	
	@Override 
	public void load(Data data) {
		this.data = data;
		load();
	}
	
	@Override
	public void close() {
		music.close();
		setVisible(false);
	}
	
	public void setVisible(boolean _visible) {
		btnBack.setVisible(_visible);
	}
	
	public void backMain() {
		SceneManager.sceneManager().load(SCENE_ID.MAIN);
	}
	
	@Override
	public void screenDraw(Graphics2D g) { 
		g.drawImage(background, 0, 0, null);
		g.drawImage(scoreBackground, 0, 0, null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString("score : ", 20, 200);
		g.drawString("max combo : ", 20, 400);
		g.drawString("life : ", 20, 600);
		g.drawString(String.format("%06d", data.iData[0]), 300, 200);
		g.drawString(String.format("%04d", data.iData[2]), 300, 400);
		g.drawString(String.format("%02d", data.iData[3]), 300, 600);
		super.screenDraw(g);
	}
}
