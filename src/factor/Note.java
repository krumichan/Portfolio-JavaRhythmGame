package factor;

import java.awt.Graphics2D;
import java.awt.Image;

import dynamic_beat.Main;
import id.IMAGE_ID;
import manager.ImageManager;

public class Note extends Thread {
	
	private Image noteBasicImage;
	private int x, y;
	private String noteType;
	private boolean proceeded = true;
	
	public String getNoteType() {
		return noteType;
	}
	
	public boolean isProceeded() {
		return proceeded;
	}
	
	public void close() {
		proceeded = false;
	}
	
	public Note(String noteType) {
		y = 580 - (1000 / Main.SLEEP_TIME * Main.NOTE_SPEED) * Main.REACH_TIME;
		
		switch(noteType) {
		case "S":
			noteBasicImage = ImageManager.imageManager().getImage(IMAGE_ID.NOTE00);
			x = 228;
			break;
			
		case "D":
			noteBasicImage = ImageManager.imageManager().getImage(IMAGE_ID.NOTE01);
			x = 332;
			break;
			
		case "F":
			noteBasicImage = ImageManager.imageManager().getImage(IMAGE_ID.NOTE00);
			x = 436;
			break;
			
		case "Space":
			noteBasicImage = ImageManager.imageManager().getImage(IMAGE_ID.NOTE_BASIC);
			x = 540;
			break;
			
		case "J":
			noteBasicImage = ImageManager.imageManager().getImage(IMAGE_ID.NOTE00);
			x = 744;
			break;
			
		case "K":
			noteBasicImage = ImageManager.imageManager().getImage(IMAGE_ID.NOTE01);
			x = 848;
			break;
			
		case "L":
			noteBasicImage = ImageManager.imageManager().getImage(IMAGE_ID.NOTE00);
			x = 952;
			break;
		}
		
		this.noteType = noteType;
	}
	
	public void screenDraw(Graphics2D g) {
		if (!noteType.equals("Space")) { 
			g.drawImage(noteBasicImage, x, y, null);
		} else {
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, x + 100, y, null);
		}
	}
	
	public void drop() {
		y += Main.NOTE_SPEED;
		if (y > 620) {
			System.out.println("Miss");
			close();
		}
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				drop();
				if (proceeded) {
					Thread.sleep(Main.SLEEP_TIME);
				} else {
					interrupt();
					break;
				}
			}
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public String judge() {
		if (y >= 613) {
			System.out.println("Late");
			close();
			return "Late";
		} else 
		if (y >= 600) {
			System.out.println("Good");
			close();
			return "Good";
		} else 
		if (y >= 587) {
			System.out.println("Great");
			close();
			return "Great";
		} else 
		if (y >= 573) {
			System.out.println("Perfect");
			close();
			return "Perfect";
		} else 
		if (y >= 565) {
			System.out.println("Great");
			close();
			return "Great";
		} else 
		if (y >= 550) {
			System.out.println("Good");
			close();
			return "Good";
		} else 
		if (y >= 530) {
			System.out.println("Early");
			close();
			return "Early";
		}
		
		return "None";
	}
	
	public int getY() {
		return y;
	}
	
	public int getX() {
		return x;
	}
}
