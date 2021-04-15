package manager;

import java.awt.event.MouseAdapter;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import command.AllRankButtonCommand;
import command.BackButtonCommand;
import command.ButtonCommand;
import command.DownButtonCommand;
import command.EasyButtonCommand;
import command.ExitButtonCommand;
import command.HardButtonCommand;
import command.LeftButtonCommand;
import command.QuitButtonCommand;
import command.RankButtonCommand;
import command.RightButtonCommand;
import command.StartButtonCommand;
import command.Top10RankButtonCommand;
import command.UpButtonCommand;
import command.UserRankButtonCommand;
import common.Position;
import common.Size;

public class ButtonManager {
	HashMap<String, ButtonCommand> commands = new HashMap<String, ButtonCommand>();
	
	private ButtonManager() {
		commands.put("frame_exit", new ExitButtonCommand());
		commands.put("title_scene_start", new StartButtonCommand());
		commands.put("title_scene_rank", new RankButtonCommand());
		commands.put("title_scene_quit", new QuitButtonCommand());
		commands.put("lobby_scene_left", new LeftButtonCommand());
		commands.put("lobby_scene_right", new RightButtonCommand());
		commands.put("lobby_scene_up", new UpButtonCommand());
		commands.put("lobby_scene_down", new DownButtonCommand());
		commands.put("lobby_scene_easy", new EasyButtonCommand());
		commands.put("lobby_scene_hard", new HardButtonCommand());
		commands.put("rank_scene_back", new BackButtonCommand());
		commands.put("rank_scene_all_rank", new AllRankButtonCommand());
		commands.put("rank_scene_top10_rank", new Top10RankButtonCommand());
		commands.put("rank_scene_user_rank", new UserRankButtonCommand());
		commands.put("game_scene_back", new BackButtonCommand());
		commands.put("score_scene_back", new BackButtonCommand());
	}
	
	private static ButtonManager instance = null;
	public static ButtonManager buttonManager() {
		if (instance == null) {
			instance = new ButtonManager();
		}
		
		return instance;
	}
	
	public JButton buttonCreate(int posX, int posY, int sizeX, int sizeY, ImageIcon icon, String btnName) {
		JButton button = new JButton(icon);
		button.setVisible(false);
		button.setBounds(posX, posY, sizeX, sizeY);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setFocusPainted(false);
		commands.get(btnName).setButton(button);
		button.addMouseListener(commands.get(btnName));
		return button;
	}
	
	public JButton buttonCreate(Position pos, Size size, ImageIcon icon, String btnName) {
		JButton button = new JButton(icon);
		button.setVisible(false);
		button.setBounds(pos.x, pos.y, size.width, size.height);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setFocusPainted(false);
		commands.get(btnName).setButton(button);
		button.addMouseListener(commands.get(btnName));
		return button;
	}
	
	public void addButtonEvent(JButton button, MouseAdapter adapter) { 
		button.addMouseListener(adapter);
	}
}
