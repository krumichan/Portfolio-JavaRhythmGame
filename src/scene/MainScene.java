package scene;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import common.Data;
import common.Position;
import common.Size;
import dynamic_beat.Main;
import factor.Music;
import factor.Track;
import id.IMAGE_ID;
import id.MUSIC_ID;
import id.SCENE_ID;
import manager.ButtonManager;
import manager.ImageManager;
import manager.MusicManager;
import manager.SceneManager;

public class MainScene extends Scene {
	private JButton btnLeft;
	private JButton btnRight;
	private JButton btnEasy;
	private JButton btnHard;
	private int nowSelected;
	
	private ArrayList<Track> trackList;
	
	private Music selectedMusic;
	
	private Image background; 
	private Image titleImage;
	private Image selectedImage;
	private Image speedBackground;
	
	private Image[] speeds;
	private int speedNumberRange;
	private int speedStartNumber;
	
	public MainScene(JFrame frame) {
		super(frame);
		create();
	}
	
	public MainScene(JFrame frame, boolean already) {
		super(frame);
		already();
	}
	
	public MainScene(JFrame frame, Data data) {
		super(frame);
		this.data = data;
		create();
	}
	
	public MainScene(JFrame frame, Data data, boolean already) {
		super(frame);
		this.data = data;
		already();
	}
	

	@Override
	public void create() {
		trackList = new ArrayList<Track>();
		trackList.add(new Track(IMAGE_ID.MIGHTY_LOVE_TITLE_IMAGE, IMAGE_ID.MIGHTY_LOVE_START_IMAGE,
				IMAGE_ID.MIGHTY_LOVE_GAME_IMAGE, MUSIC_ID.MIGHTY_LOVE_SELECTED, MUSIC_ID.JOAKIM_KARUD_MIGHTY_LOVE, "Joakim Karud - Mighty Love"));
		trackList.add(new Track(IMAGE_ID.WILD_FLOWER_TITLE_IMAGE, IMAGE_ID.WILD_FLOWER_START_IMAGE,
				IMAGE_ID.WILD_FLOWER_GAME_IMAGE, MUSIC_ID.WILD_FLOWER_SELECTED, MUSIC_ID.JOAKIM_KARUD_WILD_FLOWER, "Joakim Karud - Wild Flower"));
		trackList.add(new Track(IMAGE_ID.ENERGY_TITLE_IMAGE, IMAGE_ID.ENERGY_START_IMAGE,
				IMAGE_ID.ENERGY_GAME_IMAGE, MUSIC_ID.ENERGY_SELECTED, MUSIC_ID.BENSOUND_ENERGY, "Bensound - Energy"));
		
		background = ImageManager.imageManager().getImage(IMAGE_ID.MAIN_BACKGROUND);
		speedBackground = ImageManager.imageManager().getImage(IMAGE_ID.SPEED_BACKGROUND);
		speedStartNumber = 3;
		speedNumberRange = 8;
		speeds = new Image[speedNumberRange];
		for (int i = 0; i < speedNumberRange; i++) {
			speeds[i] = new ImageIcon(Main.class.getResource("../animation images/speed/speed_x" + (speedStartNumber + i) + ".png")).getImage();
		}	
		nowSelected = 0;
		
		btnLeft = ButtonManager.buttonManager().buttonCreate(
				new Position(140, 310)
				,new Size(60, 60)
				,ImageManager.imageManager().getImageIcon(IMAGE_ID.LEFT_BUTTON_BASIC)
				,"lobby_scene_left");
		ButtonManager.buttonManager().addButtonEvent(btnLeft, new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				selectLeft();
			}
		});
		btnLeft.setVisible(true);
		frame.add(btnLeft);
		
		btnRight = ButtonManager.buttonManager().buttonCreate(
				new Position(1080, 310)
				,new Size(60, 60)
				,ImageManager.imageManager().getImageIcon(IMAGE_ID.RIGHT_BUTTON_BASIC)
				,"lobby_scene_right");
		ButtonManager.buttonManager().addButtonEvent(btnRight, new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				selectRight();
			}
		});
		btnRight.setVisible(true);
		frame.add(btnRight);
		
		btnEasy = ButtonManager.buttonManager().buttonCreate(
				new Position(375, 580)
				,new Size(250, 67)
				,ImageManager.imageManager().getImageIcon(IMAGE_ID.EASY_BUTTON_BASIC)
				,"lobby_scene_easy");
		ButtonManager.buttonManager().addButtonEvent(btnEasy, new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				gameStart(nowSelected, "Easy");
			}
		});
		btnEasy.setVisible(true);
		frame.add(btnEasy);
		
		btnHard = ButtonManager.buttonManager().buttonCreate(
				new Position(655, 580)
				,new Size(250, 67)
				,ImageManager.imageManager().getImageIcon(IMAGE_ID.HARD_BUTTON_BASIC)
				,"lobby_scene_hard");
		ButtonManager.buttonManager().addButtonEvent(btnHard, new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				gameStart(nowSelected, "Hard");
			}
		});
		btnHard.setVisible(true);
		frame.add(btnHard);
	}

	@Override
	public void already() {
		trackList = new ArrayList<Track>();
		trackList.add(new Track(IMAGE_ID.MIGHTY_LOVE_TITLE_IMAGE, IMAGE_ID.MIGHTY_LOVE_START_IMAGE,
				IMAGE_ID.MIGHTY_LOVE_GAME_IMAGE, MUSIC_ID.MIGHTY_LOVE_SELECTED, MUSIC_ID.JOAKIM_KARUD_MIGHTY_LOVE, "Joakim Karud - Mighty Love"));
		trackList.add(new Track(IMAGE_ID.WILD_FLOWER_TITLE_IMAGE, IMAGE_ID.WILD_FLOWER_START_IMAGE,
				IMAGE_ID.WILD_FLOWER_GAME_IMAGE, MUSIC_ID.WILD_FLOWER_SELECTED, MUSIC_ID.JOAKIM_KARUD_WILD_FLOWER, "Joakim Karud - Wild Flower"));
		trackList.add(new Track(IMAGE_ID.ENERGY_TITLE_IMAGE, IMAGE_ID.ENERGY_START_IMAGE,
				IMAGE_ID.ENERGY_GAME_IMAGE, MUSIC_ID.ENERGY_SELECTED, MUSIC_ID.BENSOUND_ENERGY, "Bensound - Energy"));
		
		background = ImageManager.imageManager().getImage(IMAGE_ID.MAIN_BACKGROUND);
		speedBackground = ImageManager.imageManager().getImage(IMAGE_ID.SPEED_BACKGROUND);
		speedStartNumber = 3;
		speedNumberRange = 8;
		speeds = new Image[speedNumberRange];
		for (int i = 0; i < speedNumberRange; i++) {
			speeds[i] = new ImageIcon(Main.class.getResource("../animation images/speed/speed_x" + (speedStartNumber + i) + ".png")).getImage();
		}	
		nowSelected = 0;
		
		btnLeft = ButtonManager.buttonManager().buttonCreate(
				new Position(140, 310)
				,new Size(60, 60)
				,ImageManager.imageManager().getImageIcon(IMAGE_ID.LEFT_BUTTON_BASIC)
				,"lobby_scene_left");
		ButtonManager.buttonManager().addButtonEvent(btnLeft, new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				selectLeft();
			}
		});
		btnLeft.setVisible(false);
		frame.add(btnLeft);
		
		btnRight = ButtonManager.buttonManager().buttonCreate(
				new Position(1080, 310)
				,new Size(60, 60)
				,ImageManager.imageManager().getImageIcon(IMAGE_ID.RIGHT_BUTTON_BASIC)
				,"lobby_scene_right");
		ButtonManager.buttonManager().addButtonEvent(btnRight, new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				selectRight();
			}
		});
		btnRight.setVisible(false);
		frame.add(btnRight);
		
		btnEasy = ButtonManager.buttonManager().buttonCreate(
				new Position(375, 580)
				,new Size(250, 67)
				,ImageManager.imageManager().getImageIcon(IMAGE_ID.EASY_BUTTON_BASIC)
				,"lobby_scene_easy");
		ButtonManager.buttonManager().addButtonEvent(btnEasy, new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				gameStart(nowSelected, "Easy");
			}
		});
		btnEasy.setVisible(false);
		frame.add(btnEasy);
		
		btnHard = ButtonManager.buttonManager().buttonCreate(
				new Position(655, 580)
				,new Size(250, 67)
				,ImageManager.imageManager().getImageIcon(IMAGE_ID.HARD_BUTTON_BASIC)
				,"lobby_scene_hard");
		ButtonManager.buttonManager().addButtonEvent(btnHard, new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				gameStart(nowSelected, "Hard");
			}
		});
		btnHard.setVisible(false);
		frame.add(btnHard);
	}
	
	@Override
	public void load() {
		setButtonVisible(true);
		selectTrack(nowSelected);
		frame.requestFocus();
		
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
				case KeyEvent.VK_PAGE_UP: {
					pressPageUp();
					break;
				}
				case KeyEvent.VK_PAGE_DOWN: {
					pressPageDown();
					break;
				}
				}
			}
		});
	}
	
	@Override
	public void load(Data data) {
		this.data = data;
		load();
	}
	
	@Override
	public void close() {
		setButtonVisible(false);
		
		for (KeyListener k1 : frame.getKeyListeners()) {
			frame.removeKeyListener(k1);
		}
	}
	
	public void setButtonVisible(boolean _visible) {
		btnLeft.setVisible(_visible);
		btnRight.setVisible(_visible);
		btnEasy.setVisible(_visible);
		btnHard.setVisible(_visible);
	}

	private void selectLeft() {
		nowSelected = (nowSelected == 0 ? trackList.size() - 1 : nowSelected - 1);
		selectTrack(nowSelected);
		frame.requestFocus();
	}
	
	private void selectRight() {
		nowSelected = (nowSelected == trackList.size() - 1 ? 0 : nowSelected + 1);
		selectTrack(nowSelected);
		frame.requestFocus();
	}

	private void pressPageUp() {
		if (Main.NOTE_SPEED < 10) {
			Main.NOTE_SPEED++;
		}
	}
	
	private void pressPageDown() {
		if (Main.NOTE_SPEED > 3) {
			Main.NOTE_SPEED--;
		}
	}
	
	public void selectTrack(int nowSelected) {
		if (selectedMusic != null) {
			selectedMusic.close();
		}
		titleImage = ImageManager.imageManager().getImage(trackList.get(nowSelected).getTitleImage());
		selectedImage = ImageManager.imageManager().getImage(trackList.get(nowSelected).getStartImage());
		selectedMusic = MusicManager.musicManager().getMusic(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();
	}
	
	@Override
	public void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null);
		g.drawImage(selectedImage, 340, 100, null);
		g.drawImage(titleImage, 340, 70, null);
		g.drawImage(speedBackground, 50, 530, null);
		g.drawImage(speeds[Main.NOTE_SPEED - speedStartNumber], 75, 570, null);
		super.screenDraw(g);
	}
	
	public void gameStart(int nowSeleted, String difficulty) {
		if (selectedMusic != null) {
			selectedMusic.close();
		}

		Data data = new Data();
		data.iData = new int[] { nowSelected };
		data.strData = new String[] { trackList.get(nowSelected).getTitleName(), difficulty };
		data.imageId = new IMAGE_ID[] { trackList.get(nowSelected).getGameImage() };
		data.musicId = new MUSIC_ID[] { trackList.get(nowSelected).getGameMusic() };
		SceneManager.sceneManager().load(SCENE_ID.GAME, data);
	}
}
