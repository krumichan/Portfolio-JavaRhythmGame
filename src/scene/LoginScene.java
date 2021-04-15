package scene;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import common.Data;
import database.AccountEntity;
import dynamic_beat.Main;
import database.AccountDAO;
import factor.Music;
import id.IMAGE_ID;
import id.MUSIC_ID;
import id.SCENE_ID;
import manager.ImageManager;
import manager.MusicManager;
import manager.SceneManager;

public class LoginScene extends Scene {
	// Metadata
	private Image background;
	
	// Login
	private JLabel IDLabel;
	private JLabel PWLabel;
	private JLabel loginTitleLabel;
	
	private JTextField IDField;
	private JPasswordField PWField;
	
	private JButton createAccount;
	private JButton login;
	
	private JPanel loginPanel;
	private JPanel loginButtonPanel;
	
	// Create Account
	private JLabel createIDLabel;
	private JLabel createPWLabel;
	private JLabel createDuplicationPWLabel;
	private JLabel createTitleLabel;
	
	private JTextField accountIDField;
	private JPasswordField accountPWField;
	private JPasswordField accountDuplicationPWField;
	
	private JButton duplication;
	private JButton create;
	private JButton cancel;
	
	private JPanel accountPanel;
	private JPanel accountButtonPanel;
	
	private boolean isChecked = false; // Check duplication
	
	public LoginScene(JFrame frame) {
		super(frame);
		create();
	}
	
	public LoginScene(JFrame frame, boolean already) {
		super(frame);
		already();
	}

	public LoginScene(JFrame frame, Data data) {
		super(frame);
		this.data = data;
		create();
	}
	
	public LoginScene(JFrame frame, Data data, boolean already) {
		super(frame);
		this.data = data;
		already();
	}
	
	@Override
	public void create() {
		background = ImageManager.imageManager().getImage(IMAGE_ID.LOGIN_BACKGROUND);
		
		createLoginVisible();
		createAccountVisible();
		
		setLoginVisible(true);
		setAccountVisible(false);

	}
	
	@Override
	public void already() {
		background = ImageManager.imageManager().getImage(IMAGE_ID.LOGIN_BACKGROUND);
		
		createLoginVisible();
		createAccountVisible();
		
		setLoginVisible(false);
		setAccountVisible(false);
	}
	
	@Override
	public void load() {
		setLoginVisible(true);
		setAccountVisible(false);
		
	}
	
	@Override
	public void load(Data data) {
		this.data = data;
		load();
	}
	
	@Override
	public void close() {
		setLoginVisible(false);
		setAccountVisible(false);
		
	}
	
	public void login() {
		String id = IDField.getText();
		String pw = new String(PWField.getPassword());
		
		AccountDAO dao = new AccountDAO();
		AccountEntity account = dao.login(id, pw);
		
		if (account != null) {
			Main.LOGIN_ID = id;
			SceneManager.sceneManager().load(SCENE_ID.TITLE);
			
		} else {
			JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 잘못 입력하셨습니다!");
			PWField.setText("");
			
		}
		
	}

	public void createLoginVisible() {
		loginPanel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				g.drawImage(ImageManager.imageManager().getImage(IMAGE_ID.ACCOUNT_BACKGROUND), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		loginPanel.setLayout(new GridLayout(7, 3, 5, 5));
		loginPanel.setBackground(new Color(0, 0, 0, 0));
		loginPanel.setBounds(80, 80, 399, 222);
		loginPanel.setPreferredSize(new Dimension(399, 222));
		
		loginButtonPanel = new JPanel();
		loginButtonPanel.setLayout(new GridLayout(1, 2, 5, 5));
		loginButtonPanel.setBackground(new Color(0, 0, 0, 0));
		loginButtonPanel.setBounds(130, 240, 299, 30);
		
		login = new JButton("로그인");
		login.setFont(new Font("아이럽우유", Font.BOLD, 20));
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				login.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = MusicManager.musicManager().getMusic(MUSIC_ID.BUTTON_ENTERED_MUSIC);
				buttonEnteredMusic.start();
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				login.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = MusicManager.musicManager().getMusic(MUSIC_ID.BUTTON_PRESSED_MUSIC);
				buttonPressedMusic.start();
				login();
				
			}
		});
		
		
		createAccount = new JButton("회원가입");
		createAccount.setFont(new Font("아이럽우유", Font.BOLD, 20));
		createAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				createAccount.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music mouseEnteredMusic = MusicManager.musicManager().getMusic(MUSIC_ID.BUTTON_ENTERED_MUSIC);
				mouseEnteredMusic.start();
			
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				createAccount.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				Music mousePressedMusic = MusicManager.musicManager().getMusic(MUSIC_ID.BUTTON_PRESSED_MUSIC);
				mousePressedMusic.start();
				setLoginVisible(false);
				setAccountVisible(true);
				
			}
		});

		loginTitleLabel = new JLabel("로그인");
		loginTitleLabel.setFont(new Font("아이럽우유", Font.BOLD, 30));
		loginTitleLabel.setForeground(Color.WHITE);
		loginTitleLabel.setHorizontalAlignment(JLabel.CENTER);
		
		IDLabel = new JLabel("ID : ");
		IDLabel.setFont(new Font("아이럽우유", Font.BOLD, 20));
		IDLabel.setForeground(Color.WHITE);
		
		IDField = new JTextField(20);
		
		PWLabel = new JLabel("PW : ");
		PWLabel.setFont(new Font("아이럽우유", Font.BOLD, 20));
		PWLabel.setForeground(Color.WHITE);
		
		PWField = new JPasswordField(20);
		PWField.setEchoChar('*');
		
		JComponent[] components = {
				new JLabel(), loginTitleLabel, new JLabel()
				,new JLabel(), new JLabel(), new JLabel()
				,IDLabel, IDField, new JLabel()
				,PWLabel, PWField, new JLabel()
				,new JLabel(), new JLabel(), new JLabel()
		};
		
		for (JComponent c : components) {
			loginPanel.add(c);
		}	

		loginButtonPanel.add(login);
		loginButtonPanel.add(createAccount);
		
		setLoginVisible(true);
		
		frame.add(loginButtonPanel);
		frame.add(loginPanel);
		
	}
	
	public void setLoginVisible(boolean _visible) {
		IDLabel.setVisible(_visible);
		PWLabel.setVisible(_visible);
		loginTitleLabel.setVisible(_visible);
		
		IDField.setVisible(_visible);
		IDField.setText("");
		
		PWField.setVisible(_visible);
		PWField.setText("");
		
		createAccount.setVisible(_visible);
		login.setVisible(_visible);
		
		loginPanel.setVisible(_visible);
		loginButtonPanel.setVisible(_visible);
		
	}
	
	public boolean createAccount() {
		boolean result = false;
		
		AccountEntity account = new AccountEntity();
		account.setId(accountIDField.getText());
		account.setPw(new String(accountPWField.getPassword()));
		if (account.getId().isEmpty() ||
			account.getPw().isEmpty()) {
			JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 전부 입력해주세요!");
			
			return false;
		}
		
		if (!new String(accountPWField.getPassword()).equals(
		    new String(accountDuplicationPWField.getPassword()))) {
			JOptionPane.showMessageDialog(null, "비밀번호와 확인 비밀번호가 같지 않습니다!");
			accountPWField.setText("");
			accountDuplicationPWField.setText("");
			
			return false;
			
		}
		
		AccountDAO dao = new AccountDAO();
		if (!isChecked) {
			JOptionPane.showMessageDialog(null, "아이디 중복 체크를 해주세요!!");
			
			result = false;
		} else {
			if (dao.insert(account)) {
				JOptionPane.showMessageDialog(null, "가입이 완료되었습니다!");
				result = true;
				
			} else {
				JOptionPane.showMessageDialog(null, "가입 도중 오류가 발생했습니다. 잠시 후에 다시 시도 해주세요.");				
				result = false;
			}
			
		}
		
		return result;
		
	}
	
	public void createAccountVisible() {
		accountPanel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				g.drawImage(ImageManager.imageManager().getImage(IMAGE_ID.ACCOUNT_BACKGROUND), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		accountPanel.setLayout(new GridLayout(7, 3, 5, 5));
		accountPanel.setBackground(new Color(0, 0, 0, 0));
		accountPanel.setBounds(80, 80, 399, 222);
		accountPanel.setPreferredSize(new Dimension(399, 222));
		
		accountButtonPanel = new JPanel();
		accountButtonPanel.setLayout(new GridLayout(1, 2, 5, 5));
		accountButtonPanel.setBackground(new Color(0, 0, 0, 0));
		accountButtonPanel.setBounds(130, 240, 299, 30);
		
		createIDLabel = new JLabel(" ID : ");
		createIDLabel.setFont(new Font("아이럽우유", Font.BOLD, 20));
		createIDLabel.setForeground(Color.WHITE);
		
		createPWLabel = new JLabel(" PW : ");
		createPWLabel.setFont(new Font("아이럽우유", Font.BOLD, 20));
		createPWLabel.setForeground(Color.WHITE);
		
		createTitleLabel = new JLabel("회원가입");
		createTitleLabel.setFont(new Font("아이럽우유", Font.BOLD, 30));
		createTitleLabel.setForeground(Color.WHITE);
		createTitleLabel.setHorizontalAlignment(JLabel.CENTER);
		
		createDuplicationPWLabel = new JLabel(" PW 확인 : ");
		createDuplicationPWLabel.setFont(new Font("아이럽우유", Font.BOLD, 20));
		createDuplicationPWLabel.setForeground(Color.WHITE);
		
		accountIDField = new JTextField(20);
		accountIDField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void changedUpdate(DocumentEvent e) {
				isChecked = false;
			}
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				isChecked = false;
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				isChecked = false;
			}
			
		});
		accountPWField = new JPasswordField(20);
		accountPWField.setEchoChar('*');
		accountDuplicationPWField = new JPasswordField(20);
		accountDuplicationPWField.setEchoChar('*');
		
		duplication = new JButton("중복확인");
		duplication.setFont(new Font("아이럽우유", Font.BOLD, 20));
		duplication.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				duplication.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = MusicManager.musicManager().getMusic(MUSIC_ID.BUTTON_ENTERED_MUSIC);
				buttonEnteredMusic.start();
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				duplication.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				Music mousePressedMusic = MusicManager.musicManager().getMusic(MUSIC_ID.BUTTON_PRESSED_MUSIC);
				mousePressedMusic.start();
				checkDuplication();
				
			}
		});
		
		create = new JButton("계정생성");
		create.setFont(new Font("아이럽우유", Font.BOLD, 20));
		create.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				duplication.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = MusicManager.musicManager().getMusic(MUSIC_ID.BUTTON_ENTERED_MUSIC);
				buttonEnteredMusic.start();
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				duplication.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				Music mousePressedMusic = MusicManager.musicManager().getMusic(MUSIC_ID.BUTTON_PRESSED_MUSIC);
				mousePressedMusic.start();
				if (createAccount()) {
					setLoginVisible(true);
					setAccountVisible(false);
				}
				
			}
		});
		
		cancel = new JButton("취소");
		cancel.setFont(new Font("아이럽우유", Font.BOLD, 20));
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				duplication.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = MusicManager.musicManager().getMusic(MUSIC_ID.BUTTON_ENTERED_MUSIC);
				buttonEnteredMusic.start();
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				duplication.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				Music mousePressedMusic = MusicManager.musicManager().getMusic(MUSIC_ID.BUTTON_PRESSED_MUSIC);
				mousePressedMusic.start();
				setLoginVisible(true);
				setAccountVisible(false);
				
			}
		});
		
		JComponent[] components = {
			new JLabel(), createTitleLabel, new JLabel()
			,new JLabel(), new JLabel(), new JLabel()
			,createIDLabel, accountIDField, duplication
			,createPWLabel, accountPWField, new JLabel()
			,createDuplicationPWLabel, accountDuplicationPWField, new JLabel()
		};
		
		for (JComponent c : components) {
			accountPanel.add(c);
		}
		accountButtonPanel.add(create);
		accountButtonPanel.add(cancel);
		
		frame.add(accountButtonPanel);
		frame.add(accountPanel);
		
	}

	public void checkDuplication() {
		String id = accountIDField.getText();
		if (id.isEmpty()) {
			JOptionPane.showMessageDialog(null, "아이디를 입력해주세요!");
			return;
		}
		
		AccountDAO dao = new AccountDAO();
		
		if (dao.duplication(id)) {
			JOptionPane.showMessageDialog(null, "이미 존재하는 ID입니다!");
			accountIDField.setText("");
			
		} else {
			JOptionPane.showMessageDialog(null, "사용할 수 있는 ID입니다!");
			isChecked = true;
			
		}
		
	}
	
	public void setAccountVisible(boolean _visible) {
		createIDLabel.setVisible(_visible);
		createPWLabel.setVisible(_visible);
		createDuplicationPWLabel.setVisible(_visible);
		
		accountIDField.setVisible(_visible);
		accountIDField.setText("");
		accountPWField.setVisible(_visible);
		accountPWField.setText("");
		accountDuplicationPWField.setVisible(_visible);
		accountDuplicationPWField.setText("");
		
		duplication.setVisible(_visible);
		create.setVisible(_visible);
		cancel.setVisible(_visible);
		
		accountPanel.setVisible(_visible);
		accountButtonPanel.setVisible(_visible);
		
		isChecked = false;
	}
	
	@Override
	public void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null);
		super.screenDraw(g);
	}
}
