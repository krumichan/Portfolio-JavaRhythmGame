package dynamic_beat;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import common.Position;
import common.Size;
import id.IMAGE_ID;
import manager.BeatManager;
import manager.ButtonManager;
import manager.EffectManager;
import manager.ImageManager;
import manager.MusicManager;
import manager.SceneManager;

public class DynamicBeat extends JFrame {

	private JLabel menuBar = new JLabel(ImageManager.imageManager().getImageIcon(IMAGE_ID.MENU_BAR));

	private JButton exitButton;
	
	private int mouseX, mouseY;
	
	public DynamicBeat() {
		setUndecorated(true);
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);							// 사용자가 임의로 사이즈를 변경할 수 없다.
		setLocationRelativeTo(null);					// 화면의 중앙에 뜨게 만든다.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 게임 종료시 모든 동작을 끝낸다.
		setVisible(true);								// 화면을 보이게 띄운다. ( default : false )
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);								// button, label을 제 위치에 꽂히개 만든다.
		
		BeatManager.beatManager();
		ButtonManager.buttonManager();
		EffectManager.effectManager();
		ImageManager.imageManager();
		MusicManager.musicManager();
		SceneManager.sceneManager();
		
		SceneManager.sceneManager().already(this);
	
		exitButton = ButtonManager.buttonManager().buttonCreate(
				new Position(1245, 1)
				,new Size(30, 30)
				,ImageManager.imageManager().getImageIcon(IMAGE_ID.EXIT_BUTTON_BASIC)
				,"frame_exit");
		exitButton.setVisible(true);
		add(exitButton);

		menuBar.setBounds(0, 0, 1280, 30);				// 위치 설정
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {		// menu bar를 누르고 drag 했을 경우에 대한 처리
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);									// JFrame에 menuBar 추가
	}
	
	public void paint(Graphics g) {
		if (SceneManager.sceneManager().nowScene() == null) return;
		
		SceneManager.sceneManager().nowScene().paint(g);
	}
	
	public void screenDraw(Graphics2D g) {
		if (SceneManager.sceneManager().nowScene() == null) return;
		
		SceneManager.sceneManager().nowScene().screenDraw(g);
	}
}