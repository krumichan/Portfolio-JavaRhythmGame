package manager;

import java.util.HashMap;

import factor.Music;
import id.MUSIC_ID;

public final class MusicManager {
	HashMap<MUSIC_ID, Music> music = new HashMap<MUSIC_ID, Music>();
	
	private MusicManager() {
		music.put(MUSIC_ID.INTRO_MUSIC,
				new Music("IntroMusic.mp3", true));
		music.put(MUSIC_ID.GAME_CLEAR_MUSIC,
				new Music("Game Clear.mp3", true));
		music.put(MUSIC_ID.GAME_OVER_MUSIC,
				new Music("Game Over.mp3", true));
		music.put(MUSIC_ID.BUTTON_ENTERED_MUSIC, 
				new Music("buttonEnteredMusic.mp3", false));
		music.put(MUSIC_ID.BUTTON_PRESSED_MUSIC, 
				new Music("buttonPressedMusic.mp3", false));
		music.put(MUSIC_ID.JOAKIM_KARUD_MIGHTY_LOVE, 
				new Music("Joakim Karud - Mighty Love.mp3", false));
		music.put(MUSIC_ID.MIGHTY_LOVE_SELECTED,
				new Music("Mighty Love Selected.mp3", true));
		music.put(MUSIC_ID.JOAKIM_KARUD_WILD_FLOWER,
				new Music("Joakim Karud - Wild Flower.mp3", false));
		music.put(MUSIC_ID.WILD_FLOWER_SELECTED, 
				new Music("Wild Flower Selected.mp3", true));
		music.put(MUSIC_ID.BENSOUND_ENERGY, 
				new Music("Bensound - Energy.mp3", false));
		music.put(MUSIC_ID.ENERGY_SELECTED, 
				new Music("Energy Selected.mp3", true));
		music.put(MUSIC_ID.DRUM_SMALL_1, 
				new Music("drumSmall1.mp3", false));
		music.put(MUSIC_ID.DRUM_SMALL_2, 
				new Music("drumSmall2.mp3", false));
		music.put(MUSIC_ID.DRUM_SMALL_3, 
				new Music("drumSmall3.mp3", false));
		music.put(MUSIC_ID.DRUM_BIG_1, 
				new Music("drumBig1.mp3", false));
		music.put(MUSIC_ID.DRUM_BIG_2, 
				new Music("drumBig2.mp3", false));
		music.put(MUSIC_ID.DRUM_BIG_3, 
				new Music("drumBig3.mp3", false));
	}
	
	private static MusicManager instance = null;
	public static MusicManager musicManager() {
		if (instance == null) {
			instance = new MusicManager();
		}
		
		return instance;
	}
	
	public Music getMusic(MUSIC_ID id, boolean looping) {
		music.remove(id);
		String name = "";
		switch(id) {
		case INTRO_MUSIC: 				name = "IntroMusic.mp3"; 				 break;
		case GAME_CLEAR_MUSIC:			name = "Game Clear.mp3";				 break;
		case GAME_OVER_MUSIC:			name = "Game Over.mp3";					 break;
		case BUTTON_ENTERED_MUSIC: 		name = "buttonEnteredMusic.mp3";		 break;
		case BUTTON_PRESSED_MUSIC: 		name = "buttonPressedMusic.mp3"; 		 break;
		case BENSOUND_ENERGY: 			name = "Bensound - Energy.mp3"; 		 break;
		case ENERGY_SELECTED: 			name = "Energy Selected.mp3"; 			 break;
		case JOAKIM_KARUD_MIGHTY_LOVE: 	name = "Joakim Karud - Mighty Love.mp3"; break;
		case JOAKIM_KARUD_WILD_FLOWER: 	name = "Joakim Karud - Wild Flower.mp3"; break;
		case MIGHTY_LOVE_SELECTED: 		name = "Mighty Love Selected.mp3"; 		 break;
		case WILD_FLOWER_SELECTED: 		name = "Wild Flower Selected.mp3"; 		 break;
		case DRUM_BIG_1: 				name = "drumBig1.mp3"; 					 break;
		case DRUM_BIG_2: 				name = "drumBig2.mp3"; 					 break;
		case DRUM_BIG_3: 				name = "drumBig3.mp3"; 					 break;
		case DRUM_SMALL_1: 				name = "drumSmall1.mp3"; 				 break;
		case DRUM_SMALL_2: 				name = "drumSmall2.mp3"; 				 break;
		case DRUM_SMALL_3: 				name = "drumSmall3.mp3"; 				 break;
		}
		music.put(id, new Music(name, looping));
		return music.get(id);
	}
	
	public Music getMusic(MUSIC_ID id) {
		music.remove(id);
		String name = "";
		boolean looping = false;
		switch(id) {
		case INTRO_MUSIC: name = "IntroMusic.mp3"; looping = true; break;
		case GAME_CLEAR_MUSIC: name = "Game Clear.mp3"; looping = true; break;
		case GAME_OVER_MUSIC: name = "Game Over.mp3"; looping = true; break;
		case BUTTON_ENTERED_MUSIC: name = "buttonEnteredMusic.mp3"; looping = false; break;
		case BUTTON_PRESSED_MUSIC: name = "buttonPressedMusic.mp3"; looping = false; break;
		case BENSOUND_ENERGY: name = "Bensound - Energy.mp3"; looping = false; break;
		case ENERGY_SELECTED: name = "Energy Selected.mp3"; looping = true; break;
		case JOAKIM_KARUD_MIGHTY_LOVE: name = "Joakim Karud - Mighty Love.mp3"; looping = false; break;
		case JOAKIM_KARUD_WILD_FLOWER: name = "Joakim Karud - Wild Flower.mp3"; looping = false; break;
		case MIGHTY_LOVE_SELECTED: name = "Mighty Love Selected.mp3"; looping = true; break;
		case WILD_FLOWER_SELECTED: name = "Wild Flower Selected.mp3"; looping = true; break;
		case DRUM_BIG_1: name = "drumBig1.mp3"; looping = false; break;
		case DRUM_BIG_2: name = "drumBig2.mp3"; looping = false; break;
		case DRUM_BIG_3: name = "drumBig3.mp3"; looping = false; break;
		case DRUM_SMALL_1: name = "drumSmall1.mp3"; looping = false; break;
		case DRUM_SMALL_2: name = "drumSmall2.mp3"; looping = false; break;
		case DRUM_SMALL_3: name = "drumSmall3.mp3"; looping = false; break;
		}
		music.put(id, new Music(name, looping));
		return music.get(id);
	}
}
