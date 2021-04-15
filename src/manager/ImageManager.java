package manager;

import java.awt.Image;
import java.util.HashMap;

import javax.swing.ImageIcon;

import dynamic_beat.Main;
import id.IMAGE_ID;

public final class ImageManager {
	HashMap<IMAGE_ID, ImageIcon> images = new HashMap<IMAGE_ID, ImageIcon>();
	
	private ImageManager() { 
		images.put(IMAGE_ID.LOGIN_BACKGROUND, 
				new ImageIcon(Main.class.getResource("../images/Login Scene Image.jpg")));
		images.put(IMAGE_ID.INTRO_BACKGROUND,
				new ImageIcon(Main.class.getResource("../images/IntroBackground.jpg")));
		images.put(IMAGE_ID.ACCOUNT_BACKGROUND, 
				new ImageIcon(Main.class.getResource("../images/accountBackground.png")));
		images.put(IMAGE_ID.RANK_BACKGROUND,
				new ImageIcon(Main.class.getResource("../images/rankBackground.jpg")));
		images.put(IMAGE_ID.RANK_PANEL_BACKGROUND,
				new ImageIcon(Main.class.getResource("../images/rankPanelBackground.png")));
		images.put(IMAGE_ID.MAIN_BACKGROUND, 
				new ImageIcon(Main.class.getResource("../images/MainBackground.jpg")));
		images.put(IMAGE_ID.GAME_CLEAR_BACKGROUND,
				new ImageIcon(Main.class.getResource("../images/gameClearBackground.jpg")));
		images.put(IMAGE_ID.GAME_OVER_BACKGROUND,
				new ImageIcon(Main.class.getResource("../images/gameOverBackground.png")));
		images.put(IMAGE_ID.SCORE_BACKGROUND, 
				new ImageIcon(Main.class.getResource("../images/scorePanelBackground.png")));
		images.put(IMAGE_ID.GAME_TITLE,
				new ImageIcon(Main.class.getResource("../images/gameTitle.png")));
		images.put(IMAGE_ID.SPEED_BACKGROUND,
				new ImageIcon(Main.class.getResource("../images/speedBackground.png")));
		images.put(IMAGE_ID.NOTE_BASIC,
				new ImageIcon(Main.class.getResource("../images/noteBasic.png")));
		images.put(IMAGE_ID.NOTE00,
				new ImageIcon(Main.class.getResource("../images/note00.png")));
		images.put(IMAGE_ID.NOTE01,
				new ImageIcon(Main.class.getResource("../images/note01.png")));
		images.put(IMAGE_ID.NOTE_ROUTE_LINE, 
				new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")));
		images.put(IMAGE_ID.JUDGEMENT_LINE, 
				new ImageIcon(Main.class.getResource("../images/judgementLine.png")));
		images.put(IMAGE_ID.GAME_INFO,
				new ImageIcon(Main.class.getResource("../images/gameInfo.png")));
		images.put(IMAGE_ID.NOTE_ROUTE,
				new ImageIcon(Main.class.getResource("../images/noteRoute.png")));
		images.put(IMAGE_ID.NOTE_ROUTE_PRESSED,
				new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")));
		images.put(IMAGE_ID.KEY_PAD_BASIC,
				new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")));
		images.put(IMAGE_ID.KEY_PAD_PRESSED,
				new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")));
		images.put(IMAGE_ID.BLUE_FLARE,
				new ImageIcon(Main.class.getResource("../images/blueFlare.png")));
		images.put(IMAGE_ID.JUDGE_MISS,
				new ImageIcon(Main.class.getResource("../images/judgeMiss.png")));
		images.put(IMAGE_ID.JUDGE_LATE,
				new ImageIcon(Main.class.getResource("../images/judgeLate.png")));
		images.put(IMAGE_ID.JUDGE_GOOD,
				new ImageIcon(Main.class.getResource("../images/judgeGood.png")));
		images.put(IMAGE_ID.JUDGE_GREAT,
				new ImageIcon(Main.class.getResource("../images/judgeGreat.png")));
		images.put(IMAGE_ID.JUDGE_PERFECT,
				new ImageIcon(Main.class.getResource("../images/judgePerfect.png")));
		images.put(IMAGE_ID.JUDGE_EALRY,
				new ImageIcon(Main.class.getResource("../images/judgeEarly.png")));
		images.put(IMAGE_ID.EXIT_BUTTON_ENTERED,
				new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png")));
		images.put(IMAGE_ID.EXIT_BUTTON_BASIC, 
				new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png")));
		images.put(IMAGE_ID.START_BUTTON_ENTERED, 
				new ImageIcon(Main.class.getResource("../images/startButtonEntered.png")));
		images.put(IMAGE_ID.START_BUTTON_BASIC, 
				new ImageIcon(Main.class.getResource("../images/startButtonBasic.png")));
		images.put(IMAGE_ID.RANK_BUTTON_ENTERED,
				new ImageIcon(Main.class.getResource("../images/rankButtonEntered.png")));
		images.put(IMAGE_ID.RANK_BUTTON_BASIC,
				new ImageIcon(Main.class.getResource("../images/rankButtonBasic.png")));
		images.put(IMAGE_ID.QUIT_BUTTON_ENTERED, 
				new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png")));
		images.put(IMAGE_ID.QUIT_BUTTON_BASIC,
				new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png")));
		images.put(IMAGE_ID.LEFT_BUTTON_ENTERED, 
				new ImageIcon(Main.class.getResource("../images/leftButtonEntered.png")));
		images.put(IMAGE_ID.LEFT_BUTTON_BASIC, 
				new ImageIcon(Main.class.getResource("../images/leftButtonBasic.png")));
		images.put(IMAGE_ID.RIGHT_BUTTON_ENTERED,
				new ImageIcon(Main.class.getResource("../images/rightButtonEntered.png")));
		images.put(IMAGE_ID.RIGHT_BUTTON_BASIC, 
				new ImageIcon(Main.class.getResource("../images/rightButtonBasic.png")));
		images.put(IMAGE_ID.EASY_BUTTON_ENTERED, 
				new ImageIcon(Main.class.getResource("../images/easyButtonEntered.png")));
		images.put(IMAGE_ID.EASY_BUTTON_BASIC, 
				new ImageIcon(Main.class.getResource("../images/easyButtonBasic.png")));
		images.put(IMAGE_ID.HARD_BUTTON_ENTERED, 
				new ImageIcon(Main.class.getResource("../images/hardButtonEntered.png")));
		images.put(IMAGE_ID.HARD_BUTTON_BASIC, 
				new ImageIcon(Main.class.getResource("../images/hardButtonBasic.png")));
		images.put(IMAGE_ID.BACK_BUTTON_ENTERED, 
				new ImageIcon(Main.class.getResource("../images/backButtonEntered.png")));
		images.put(IMAGE_ID.BACK_BUTTON_BASIC, 
				new ImageIcon(Main.class.getResource("../images/backButtonBasic.png")));
		images.put(IMAGE_ID.UP_BUTTON_BASIC,
				new ImageIcon(Main.class.getResource("../images/upButtonBasic.png")));
		images.put(IMAGE_ID.UP_BUTTON_ENTERED,
				new ImageIcon(Main.class.getResource("../images/upButtonEntered.png")));
		images.put(IMAGE_ID.DOWN_BUTTON_BASIC,
				new ImageIcon(Main.class.getResource("../images/downButtonBasic.png")));
		images.put(IMAGE_ID.DOWN_BUTTON_ENTERED,
				new ImageIcon(Main.class.getResource("../images/downButtonEntered.png")));
		images.put(IMAGE_ID.ALL_RANK_BUTTON_ENTERED,
				new ImageIcon(Main.class.getResource("../images/allRankButtonEntered.png")));
		images.put(IMAGE_ID.ALL_RANK_BUTTON_BASIC,
				new ImageIcon(Main.class.getResource("../images/allRankButtonBasic.png")));
		images.put(IMAGE_ID.TOP10_RANK_BUTTON_ENTERED,
				new ImageIcon(Main.class.getResource("../images/top10RankButtonEntered.png")));
		images.put(IMAGE_ID.TOP10_RANK_BUTTON_BASIC,
				new ImageIcon(Main.class.getResource("../images/top10RankButtonBasic.png")));
		images.put(IMAGE_ID.USER_RANK_BUTTON_ENTERED,
				new ImageIcon(Main.class.getResource("../images/userRankButtonEntered.png")));
		images.put(IMAGE_ID.USER_RANK_BUTTON_BASIC,
				new ImageIcon(Main.class.getResource("../images/userRankButtonBasic.png")));
		images.put(IMAGE_ID.MENU_BAR, 
				new ImageIcon(Main.class.getResource("../images/menuBar.png")));
		images.put(IMAGE_ID.MIGHTY_LOVE_TITLE_IMAGE, 
				new ImageIcon(Main.class.getResource("../images/Mighty Love Title Image.png")));
		images.put(IMAGE_ID.MIGHTY_LOVE_START_IMAGE, 
				new ImageIcon(Main.class.getResource("../images/Mighty Love Start Image.png")));
		images.put(IMAGE_ID.MIGHTY_LOVE_GAME_IMAGE,
				new ImageIcon(Main.class.getResource("../images/Mighty Love Game Image.jpg")));
		images.put(IMAGE_ID.WILD_FLOWER_TITLE_IMAGE,
				new ImageIcon(Main.class.getResource("../images/Wild Flower Title Image.png")));
		images.put(IMAGE_ID.WILD_FLOWER_START_IMAGE,
				new ImageIcon(Main.class.getResource("../images/Wild Flower Start Image.png")));
		images.put(IMAGE_ID.WILD_FLOWER_GAME_IMAGE, 
				new ImageIcon(Main.class.getResource("../images/Wild Flower Game Image.jpg")));
		images.put(IMAGE_ID.ENERGY_TITLE_IMAGE, 
				new ImageIcon(Main.class.getResource("../images/Energy Title Image.png")));
		images.put(IMAGE_ID.ENERGY_START_IMAGE,
				new ImageIcon(Main.class.getResource("../images/Energy Start Image.png")));
		images.put(IMAGE_ID.ENERGY_GAME_IMAGE, 
				new ImageIcon(Main.class.getResource("../images/Energy Game Image.jpg")));
	}
	
	private static ImageManager instance = null;
	public  static ImageManager imageManager() {
		if (instance == null) {
			instance = new ImageManager();
		}
		
		return instance;
	}
	
	public ImageIcon getImageIcon(IMAGE_ID id) {
		return images.get(id);
	}
	
	public Image getImage(IMAGE_ID id) {
		return images.get(id).getImage();
	}
}
