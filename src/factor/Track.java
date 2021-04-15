package factor;

import id.IMAGE_ID;
import id.MUSIC_ID;

public class Track {
	
	private IMAGE_ID titleImage; 	// 제목 부분 이미지
	private IMAGE_ID startImage; 	// 게임 선택 창 표지 이미지
	private IMAGE_ID gameImage; 	// 해당 곡을 실행했을 때 표지 이미지
	private MUSIC_ID startMusic;	// 게임 선택 창 음악 
	private MUSIC_ID gameMusic; 	// 해당 곡을 실행했을 때 음악
	private String 	 titleName;		// 곡 제목
	
	public Track(IMAGE_ID titleImage, IMAGE_ID startImage, IMAGE_ID gameImage, MUSIC_ID startMusic, MUSIC_ID gameMusic, String titleName) {
		super();
		this.titleImage = titleImage;
		this.startImage = startImage;
		this.gameImage = gameImage;
		this.startMusic = startMusic;
		this.gameMusic = gameMusic;
		this.titleName = titleName;
	}

	public IMAGE_ID getTitleImage() {
		return titleImage;
	}

	public void setTitleImage(IMAGE_ID titleImage) {
		this.titleImage = titleImage;
	}

	public IMAGE_ID getStartImage() {
		return startImage;
	}

	public void setStartImage(IMAGE_ID startImage) {
		this.startImage = startImage;
	}

	public IMAGE_ID getGameImage() {
		return gameImage;
	}

	public void setGameImage(IMAGE_ID gameImage) {
		this.gameImage = gameImage;
	}

	public MUSIC_ID getStartMusic() {
		return startMusic;
	}

	public void setStartMusic(MUSIC_ID startMusic) {
		this.startMusic = startMusic;
	}

	public MUSIC_ID getGameMusic() {
		return gameMusic;
	}

	public void setGameMusic(MUSIC_ID gameMusic) {
		this.gameMusic = gameMusic;
	}

	public String getTitleName() {
		return titleName;
	}
	
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
}
