package scene;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import common.Data;
import common.Position;
import common.Size;
import database.AccountDAO;
import database.ScoreDAO;
import database.ScoreEntity;
import id.IMAGE_ID;
import id.SCENE_ID;
import manager.ButtonManager;
import manager.ImageManager;
import manager.SceneManager;

public class RankScene extends Scene {
	private JButton btnAllRank = null;
	private JButton btnTop10Rank = null;
	private JButton btnUserRank = null;
	private	JButton btnBack	= null;
	private JTextField fieldUserId = null;
	
	private Image background;
	
	private JPanel panel = null;
	private JTextArea scores = null;
	private JScrollPane scroll = null;
	
	private ArrayList<ScoreEntity> scoreList;
		
	public RankScene(JFrame frame) {
		super(frame);
		create();
	}
	
	public RankScene(JFrame frame, boolean already) {
		super(frame);
		already();
	}

	public RankScene(JFrame frame, Data data) {
		super(frame);
		this.data = data;
		create();
	}
	
	public RankScene(JFrame frame, Data data, boolean already) {
		super(frame);
		this.data = data;
		already();
	}

	@Override
	public void create() {
		background = ImageManager.imageManager().getImage(IMAGE_ID.RANK_BACKGROUND);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(90, 300, 1100, 400);
		panel.setOpaque(false);
		
		fieldUserId = new JTextField(20);
		fieldUserId.setBounds(1000, 200, 180, 30);
		
		btnAllRank = ButtonManager.buttonManager().buttonCreate(
				new Position(550, 240)
				,new Size(200, 50)
				,ImageManager.imageManager().getImageIcon(IMAGE_ID.ALL_RANK_BUTTON_BASIC)
				,"rank_scene_all_rank");
		ButtonManager.buttonManager().addButtonEvent(btnAllRank, new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				getAllRank();
			}
		});
		
		btnTop10Rank = ButtonManager.buttonManager().buttonCreate(
				new Position(770, 240)
				,new Size(200, 50)
				,ImageManager.imageManager().getImageIcon(IMAGE_ID.TOP10_RANK_BUTTON_BASIC)
				,"rank_scene_top10_rank");
		ButtonManager.buttonManager().addButtonEvent(btnTop10Rank, new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				getTop10Rank();
			}
		});
		
		btnUserRank = ButtonManager.buttonManager().buttonCreate(
				new Position(990, 240)
				,new Size(200, 50)
				,ImageManager.imageManager().getImageIcon(IMAGE_ID.USER_RANK_BUTTON_BASIC)
				,"rank_scene_user_rank");
		ButtonManager.buttonManager().addButtonEvent(btnUserRank, new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String id = fieldUserId.getText();
				if (id.isEmpty()) {
					JOptionPane.showMessageDialog(null, "아이디를 입력해주세요!!");
					return;
				}
				
				AccountDAO dao = new AccountDAO();
				if (!dao.duplication(id)) {
					JOptionPane.showMessageDialog(null, "존재하지 않는 아이디입니다!!");
					return;
				}
				
				getUserRank(id);
			}
		});
		
		btnBack = ButtonManager.buttonManager().buttonCreate(
				new Position(20, 50)
				,new Size(60, 60)
				,ImageManager.imageManager().getImageIcon(IMAGE_ID.BACK_BUTTON_BASIC)
				,"rank_scene_back");
		ButtonManager.buttonManager().addButtonEvent(btnBack,  new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				back();
			}
		});
		
		scores = new JTextArea() {
			{ setOpaque(false); }
			public void paintComponent(Graphics g) {
				Image img = ImageManager.imageManager().getImage(IMAGE_ID.RANK_PANEL_BACKGROUND);
				g.drawImage(img, 0, 0, null);
				super.paintComponent(g);
			}
		};
		scores.setEditable(false);
		scores.setBounds(0, 0, 1100, 400);
		scroll = new JScrollPane(scores, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(0, 0, 1100, 400);
		scroll.getViewport().setBackground(new Color(0x00000000, true));
		scroll.setOpaque(false);
		
		panel.add(scroll);
		frame.add(fieldUserId);
		frame.add(btnAllRank);
		frame.add(btnTop10Rank);
		frame.add(btnUserRank);
		frame.add(btnBack);
		frame.add(panel);
		
		setVisible(true);
	}

	@Override
	public void already() {
		background = ImageManager.imageManager().getImage(IMAGE_ID.RANK_BACKGROUND);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(90, 300, 1100, 400);
		panel.setOpaque(false);
		
		fieldUserId = new JTextField(20);
		fieldUserId.setBounds(1000, 200, 180, 30);
		
		btnAllRank = ButtonManager.buttonManager().buttonCreate(
				new Position(550, 240)
				,new Size(200, 50)
				,ImageManager.imageManager().getImageIcon(IMAGE_ID.ALL_RANK_BUTTON_BASIC)
				,"rank_scene_all_rank");
		ButtonManager.buttonManager().addButtonEvent(btnAllRank, new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				getAllRank();
			}
		});
		
		btnTop10Rank = ButtonManager.buttonManager().buttonCreate(
				new Position(770, 240)
				,new Size(200, 50)
				,ImageManager.imageManager().getImageIcon(IMAGE_ID.TOP10_RANK_BUTTON_BASIC)
				,"rank_scene_top10_rank");
		ButtonManager.buttonManager().addButtonEvent(btnTop10Rank, new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				getTop10Rank();
			}
		});
		
		btnUserRank = ButtonManager.buttonManager().buttonCreate(
				new Position(990, 240)
				,new Size(200, 50)
				,ImageManager.imageManager().getImageIcon(IMAGE_ID.USER_RANK_BUTTON_BASIC)
				,"rank_scene_user_rank");
		ButtonManager.buttonManager().addButtonEvent(btnUserRank, new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String id = fieldUserId.getText();
				if (id.isEmpty()) {
					JOptionPane.showMessageDialog(null, "아이디를 입력해주세요!!");
					return;
				}
				
				AccountDAO dao = new AccountDAO();
				if (!dao.duplication(id)) {
					JOptionPane.showMessageDialog(null, "존재하지 않는 아이디입니다!!");
					return;
				}
				
				getUserRank(id);
			}
		});
		
		btnBack = ButtonManager.buttonManager().buttonCreate(
				new Position(20, 50)
				,new Size(60, 60)
				,ImageManager.imageManager().getImageIcon(IMAGE_ID.BACK_BUTTON_BASIC)
				,"rank_scene_back");
		ButtonManager.buttonManager().addButtonEvent(btnBack,  new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				back();
			}
		});
		
		scores = new JTextArea();
		scores.setOpaque(false);
		scores.setEditable(false);
		scores.setBounds(0, 0, 1100, 400);
		scores.setFont(new Font("아이럽우유", Font.BOLD, 40));
		scroll = new JScrollPane(scores, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(0, 0, 1100, 400);
		scroll.getViewport().setBackground(new Color(0x00000000, true));
		scroll.setOpaque(false);

		panel.add(scroll);
		frame.add(fieldUserId);
		frame.add(btnAllRank);
		frame.add(btnTop10Rank);
		frame.add(btnUserRank);
		frame.add(btnBack);
		frame.add(panel);
		
		setVisible(false);
	}

	@Override
	public void load() {
		setVisible(true);
	}

	@Override
	public void load(Data data) {
		this.data = data;
		load();
	}

	@Override
	public void close() {
		setVisible(false);
	}
	
	private void back() {
		SceneManager.sceneManager().createAndLoad(SCENE_ID.TITLE);
	}
	
	private void getAllRank() {
		ScoreDAO dao = new ScoreDAO();
		scoreList = dao.selectAll();
		
		if (scores.getLineCount() != 0) {
			scores.setText("");
		}
		
		for(ScoreEntity score : scoreList) {
			scores.append(score.getId() + "\t" + score.getScore() + "\t" + score.getSongTitle() + "\n");
		}
	}
	
	private void getTop10Rank() {
		if (scores.getLineCount() != 0) {
			scores.setText("");
		}
		
		if (scoreList != null &&
			scoreList.size() != 0) {
			for (int i = 0; i < 10; i++) {
				ScoreEntity score = scoreList.get(i);
				if (score == null) {
					break;
				}
				scores.append(score.getId() + "\t" + score.getScore() + "\t" + score.getSongTitle() + "\n");
			}
		}
	}
	
	private void getUserRank(String id) {
		ScoreDAO dao = new ScoreDAO();
		scoreList = dao.select(id);
		
		if (scores.getLineCount() != 0) {
			scores.setText("");
		}
		
		for(ScoreEntity score : scoreList) {
			scores.append(score.getId() + "\t" + score.getScore() + "\t" + score.getSongTitle() + "\n");
		}
	}
	
	public void setVisible(boolean _visible) {
		btnAllRank.setVisible(_visible);
		btnTop10Rank.setVisible(_visible);
		btnUserRank.setVisible(_visible);
		btnBack.setVisible(_visible);
		fieldUserId.setVisible(_visible);
		panel.setVisible(_visible);
		scores.setVisible(_visible);
		scroll.setVisible(_visible);
	}
	
	@Override
	public void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null);
		super.screenDraw(g);
	}
}
