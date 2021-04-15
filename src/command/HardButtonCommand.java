package command;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import factor.Music;
import id.IMAGE_ID;
import id.MUSIC_ID;
import manager.ImageManager;
import manager.MusicManager;

public class HardButtonCommand extends ButtonCommand {

	@Override
	public void entered(MouseEvent e) {
		button.setIcon(ImageManager.imageManager().getImageIcon(IMAGE_ID.HARD_BUTTON_ENTERED));
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		Music buttonEnteredMusic = MusicManager.musicManager().getMusic(MUSIC_ID.BUTTON_ENTERED_MUSIC);
		buttonEnteredMusic.start();
	}

	@Override
	public void exited(MouseEvent e) {
		button.setIcon(ImageManager.imageManager().getImageIcon(IMAGE_ID.HARD_BUTTON_BASIC));
		button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	@Override
	public void pressed(MouseEvent e) {
		Music buttonPressedMusic = MusicManager.musicManager().getMusic(MUSIC_ID.BUTTON_PRESSED_MUSIC);
		buttonPressedMusic.start();
	}

}
