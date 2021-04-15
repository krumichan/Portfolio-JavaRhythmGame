package scene;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import common.Data;
import common.Position;
import common.Size;
import factor.Game;
import id.IMAGE_ID;
import id.SCENE_ID;
import listener.CustomKeyListener;
import manager.ButtonManager;
import manager.ImageManager;
import manager.SceneManager;

public class GameScene extends Scene {
	private JButton btnBack;
	private Image background;
	public Game game;

	public GameScene(JFrame frame) {
		super(frame);
		create();
	}
	
	public GameScene(JFrame frame, boolean already) {
		super(frame);
		already();
	}
	
	public GameScene(JFrame frame, Data data) {
		super(frame);
		this.data = data;
		create();
	}
	
	public GameScene(JFrame frame, Data data, boolean already) {
		super(frame);
		this.data = data;
		already();
	}

	@Override
	public void create() {
		background = ImageManager.imageManager().getImage(data.imageId[0]);
		game = new Game(data.strData[0], data.strData[1], data.musicId[0]);
		frame.addKeyListener(new CustomKeyListener(game));
		frame.setFocusable(true);
		
		btnBack = ButtonManager.buttonManager().buttonCreate(
				new Position(20, 50)
				,new Size(60, 60)
				,ImageManager.imageManager().getImageIcon(IMAGE_ID.BACK_BUTTON_BASIC)
				,"game_scene_back");
		ButtonManager.buttonManager().addButtonEvent(btnBack, new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				backMain();
			}
		});
		btnBack.setVisible(true);
		frame.add(btnBack);
		
		game.start();
	}
	
	@Override
	public void already() {
		btnBack = ButtonManager.buttonManager().buttonCreate(
				new Position(20, 50)
				,new Size(60, 60)
				,ImageManager.imageManager().getImageIcon(IMAGE_ID.BACK_BUTTON_BASIC)
				,"game_scene_back");
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
		background = ImageManager.imageManager().getImage(data.imageId[0]);
		setButtonVisible(true);
		game = new Game(data.strData[0], data.strData[1], data.musicId[0]);
		frame.addKeyListener(new CustomKeyListener(game));
		frame.setFocusable(true);
		
		game.start();
	}
	
	@Override
	public void load(Data data) {
		this.data = data;
		load();
	}
	
	@Override
	public void close() {
		for (java.awt.event.KeyListener kl : frame.getKeyListeners()) {
			frame.removeKeyListener(kl);
		}
		
		setButtonVisible(false);
		game.close();
	}
	
	public void setButtonVisible(boolean _visible) {
		btnBack.setVisible(_visible);
	}

	public void backMain() {
		SceneManager.sceneManager().load(SCENE_ID.MAIN);
	}
	
	@Override
	public void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null);
		game.screenDraw(g);
		super.screenDraw(g);
	}
}
