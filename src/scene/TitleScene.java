package scene;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import command.QuitButtonCommand;
import command.StartButtonCommand;
import common.Data;
import common.Position;
import common.Size;
import factor.Music;
import id.IMAGE_ID;
import id.MUSIC_ID;
import id.SCENE_ID;
import manager.ButtonManager;
import manager.ImageManager;
import manager.MusicManager;
import manager.SceneManager;

public class TitleScene extends Scene {
	private Image background;
	private Image title;
	private JButton btnStart;
	private JButton btnRank;
	private JButton btnQuit;
	private Music music;
	
	public TitleScene(JFrame frame) {
		super(frame);
		create();
	}
	
	public TitleScene(JFrame frame, boolean already) {
		super(frame);
		already();
	}
	
	public TitleScene(JFrame frame, Data data) {
		super(frame);
		this.data = data;
		create();
	}
	
	public TitleScene(JFrame frame, Data data, boolean already) {
		super(frame);
		this.data = data;
		already();
	}

	@Override
	public void create() {
		background = ImageManager.imageManager().getImage(IMAGE_ID.INTRO_BACKGROUND);
		title = ImageManager.imageManager().getImage(IMAGE_ID.GAME_TITLE);
		music = MusicManager.musicManager().getMusic(MUSIC_ID.INTRO_MUSIC, true);
		music.start();
		
		btnStart = ButtonManager.buttonManager().buttonCreate(
				new Position(40, 325)
				,new Size(444, 100)
				,ImageManager.imageManager().getImageIcon(IMAGE_ID.START_BUTTON_BASIC)
				,"title_scene_start");
		ButtonManager.buttonManager().addButtonEvent(btnStart, new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				SceneManager.sceneManager().load(SCENE_ID.MAIN);
			}
		});
		
		btnRank = ButtonManager.buttonManager().buttonCreate(
				new Position(40, 450)
				,new Size(444, 100)
				,ImageManager.imageManager().getImageIcon(IMAGE_ID.RANK_BUTTON_BASIC)
				,"title_scene_rank");
		
		btnQuit = ButtonManager.buttonManager().buttonCreate(
				new Position(40, 575)
				,new Size(444, 100)
				,ImageManager.imageManager().getImageIcon(IMAGE_ID.QUIT_BUTTON_BASIC)
				,"title_scene_quit");
		
		setVisible(true);
		frame.add(btnStart);
		frame.add(btnRank);
		frame.add(btnQuit);
	}
	
	@Override
	public void already() {
		background = ImageManager.imageManager().getImage(IMAGE_ID.INTRO_BACKGROUND);
		title = ImageManager.imageManager().getImage(IMAGE_ID.GAME_TITLE);
		music = MusicManager.musicManager().getMusic(MUSIC_ID.INTRO_MUSIC, true);
		
		btnStart = ButtonManager.buttonManager().buttonCreate(
				new Position(40, 325)
				,new Size(444, 100)
				,ImageManager.imageManager().getImageIcon(IMAGE_ID.START_BUTTON_BASIC)
				,"title_scene_start");
		ButtonManager.buttonManager().addButtonEvent(btnStart, new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				SceneManager.sceneManager().load(SCENE_ID.MAIN);
			}
		});
		
		btnRank = ButtonManager.buttonManager().buttonCreate(
				new Position(40, 450)
				,new Size(444, 100)
				,ImageManager.imageManager().getImageIcon(IMAGE_ID.RANK_BUTTON_BASIC)
				,"title_scene_rank");
		ButtonManager.buttonManager().addButtonEvent(btnRank, new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				SceneManager.sceneManager().load(SCENE_ID.RANK);
			}
		});
		
		btnQuit = ButtonManager.buttonManager().buttonCreate(
				new Position(40, 575)
				,new Size(444, 100)
				,ImageManager.imageManager().getImageIcon(IMAGE_ID.QUIT_BUTTON_BASIC)
				,"title_scene_quit");
		
		setVisible(false);
		frame.add(btnStart);
		frame.add(btnRank);
		frame.add(btnQuit);
	}

	@Override
	public void load() {
		music = MusicManager.musicManager().getMusic(MUSIC_ID.INTRO_MUSIC, true);
		music.start();
		setVisible(true);
		
	}
	
	@Override
	public void load(Data data) {
		this.data = data;
		load();
	}
	
	public void setVisible(boolean _visible) {
		btnStart.setVisible(_visible);
		btnRank.setVisible(_visible);
		btnQuit.setVisible(_visible);
	}
	
	@Override
	public void close() {
		if (music != null) {
			music.close();
		}
		setVisible(false);
	}

	@Override
	public void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null);
		g.drawImage(title, 620, 100, null);
		super.screenDraw(g);
	}
}
