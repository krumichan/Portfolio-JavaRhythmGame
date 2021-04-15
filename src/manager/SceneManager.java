package manager;

import java.util.HashMap;

import javax.swing.JFrame;

import common.Data;
import id.SCENE_ID;
import scene.GameScene;
import scene.LoginScene;
import scene.MainScene;
import scene.RankScene;
import scene.Scene;
import scene.ScoreScene;
import scene.TitleScene;

public final class SceneManager {
	private static SceneManager instance;
	public static SceneManager sceneManager() { 
		if (instance == null) {
			instance = new SceneManager();
		}
		
		return instance;
	}
	
	HashMap<SCENE_ID, Scene> scenes = new HashMap<SCENE_ID, Scene>();
	private SCENE_ID id = SCENE_ID.LOGIN;
	private JFrame frame;
	
	private SceneManager() { }
	
	public void create(JFrame frame) {
		this.frame = frame;
		
		// Create default scene and Load default scene
		add(SCENE_ID.LOGIN, new LoginScene(frame));
	}
	
	public void already(JFrame frame) {
		this.frame = frame;
		
		add(SCENE_ID.LOGIN, new LoginScene(frame, true));
		add(SCENE_ID.TITLE, new TitleScene(frame, true));
		add(SCENE_ID.RANK, new RankScene(frame, true));
		add(SCENE_ID.MAIN, new MainScene(frame, true));
		add(SCENE_ID.GAME, new GameScene(frame, true));
		add(SCENE_ID.SCORE, new ScoreScene(frame, true));
		
		load(SCENE_ID.LOGIN);
	}
	
	/** 
	 * 새로운 Scene을 Scene List에 추가합니다.
	 * 
	 * @author 임종선
	 * @param id - 해당 Scene에 대한 enum 값을 받습니다.
	 * @param s - 만들어진 Scene이 이곳에 들어가게 됩니다.
	 * */
	public void add(SCENE_ID id, Scene s) {
		scenes.put(id, s);
	}
	
	/** 
	 * 기존의 Scene을 불러옵니다.
	 * 불러오기 위해서는 이전에 반드시 생성되어 있는 Scene이어야 하며,
	 * Scene List에 담겨져 있어야 합니다.
	 * 
	 * @param id - 해당 Scene에 대한 enum 값을 받습니다.
	 */
	public void createAndLoad(SCENE_ID id) {
		scenes.get(this.id).close();
		this.id = id;
		
		switch(id) {
		case TITLE:
			if (!scenes.containsKey(SCENE_ID.TITLE)) {
				add(SCENE_ID.TITLE, new TitleScene(frame));
				return;
			} else {
				break;
			}
			
		case RANK:
			if (!scenes.containsKey(SCENE_ID.RANK)) {
				add(SCENE_ID.RANK, new RankScene(frame));
				return;
			} else {
				break;
			}
			
		case MAIN:
			if (!scenes.containsKey(SCENE_ID.MAIN)) {
				add(SCENE_ID.MAIN, new MainScene(frame));
				return;
			} else {
				break;
			}
			
		case GAME:
			if (!scenes.containsKey(SCENE_ID.GAME)) {
				add(SCENE_ID.GAME, new GameScene(frame));
				return;
			} else {
				break;
			}
			
		case SCORE:
			if (!scenes.containsKey(SCENE_ID.SCORE)) {
				add(SCENE_ID.SCORE, new ScoreScene(frame));
				return;
			} else {
				break;
			}
		}
		
		scenes.get(id).load();
	}
	
	/**
	 * 기존의 Scene을 불러옵니다.
	 * 불러오기 위해서는 이전에 반드시 생성되어 있는 Scene이어야 하며,
	 * Scene List에 담겨져 있어야 합니다.
	 * 
	 * @param id - 해당 Scene에 대한 enum 값을 받습니다.
	 * @param data - 불러올 Scene에 보낼 데이터입니다.
	 */
	public void createAndLoad(SCENE_ID id, Data data) {
		scenes.get(this.id).close();
		this.id = id;
		
		switch(id) {
		case TITLE:
			if (!scenes.containsKey(SCENE_ID.TITLE)) {
				add(SCENE_ID.TITLE, new TitleScene(frame, data));
				return;
			} else {
				break;
			}
			
		case RANK:
			if (!scenes.containsKey(SCENE_ID.RANK)) {
				add(SCENE_ID.RANK, new RankScene(frame, data));
				return;
			} else {
				break;
			}
			
		case MAIN:
			if (!scenes.containsKey(SCENE_ID.MAIN)) {
				add(SCENE_ID.MAIN, new MainScene(frame, data));
				return;
			} else {
				break;
			}
			
		case GAME:
			if (!scenes.containsKey(SCENE_ID.GAME)) {
				add(SCENE_ID.GAME, new GameScene(frame, data));
				return;
			} else {
				break;
			}
			
		case SCORE:
			if (!scenes.containsKey(SCENE_ID.SCORE)) {
				add(SCENE_ID.SCORE, new ScoreScene(frame, data));
				return;
			} else {
				break;
			}	
		}
		
		scenes.get(id).load(data);	
	}
	
	public void load(SCENE_ID id) {
		scenes.get(this.id).close();
		this.id = id;
		scenes.get(id).load();
	}
	
	public void load(SCENE_ID id, Data data) {
		if (id.equals(this.id)) {
			return;
		}
		scenes.get(this.id).close();
		this.id = id;
		scenes.get(id).load(data);
	}
	
	/**
	 * 현재 활성화되어 있는 Scene을 불러옵니다.
	 * 
	 * @return 현재 Scene의 값을 반환합니다.
	 */
	public Scene nowScene() { 
		return scenes.get(id);
	}
}
