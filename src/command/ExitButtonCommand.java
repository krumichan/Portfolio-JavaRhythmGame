package command;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import factor.Music;
import id.IMAGE_ID;
import id.MUSIC_ID;
import manager.ImageManager;
import manager.MusicManager;

public class ExitButtonCommand extends ButtonCommand {

	@Override
	public void entered(MouseEvent e) {
		button.setIcon(ImageManager.imageManager().getImageIcon(IMAGE_ID.EXIT_BUTTON_ENTERED));
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		Music buttonEnteredMusic = MusicManager.musicManager().getMusic(MUSIC_ID.BUTTON_ENTERED_MUSIC);
		buttonEnteredMusic.start();
	}

	@Override
	public void exited(MouseEvent e) {
		button.setIcon(ImageManager.imageManager().getImageIcon(IMAGE_ID.EXIT_BUTTON_BASIC));
		button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	@Override
	public void pressed(MouseEvent e) {
		Music buttonPressedMusic = MusicManager.musicManager().getMusic(MUSIC_ID.BUTTON_PRESSED_MUSIC);
		buttonPressedMusic.start();
		try {
			Thread.sleep(1000);	// 게임 종료시 소리를 재생하고 끄기 위함
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.exit(0);
	}

}