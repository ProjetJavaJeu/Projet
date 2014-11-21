package main;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

public class WindowMap extends BasicGame {
	private GameContainer container;
	private Map map = new Map();
	private Player player = new Player(map);
	private Camera camera = new Camera(player);
	private TriggerController triggers = new TriggerController(map, player);
	private Hud hud = new Hud();
	public WindowMap() {
		super("Try It !");
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		/*
		 * String path = System.getProperty("user.dir");
		 * System.out.println(path);
		 */
		this.map.init();
		this.player.init();
		this.container = container;
		PlayerController controller = new PlayerController(this.player, this.container);
		container.getInput().addControllerListener(controller);
		container.getInput().addKeyListener(controller);

		Music background = new Music(
				"/src/main/ressources/sounds/EyeOfTheTiger.ogg");
		background.loop();
		
		this.hud.init();
	}

	@Override
	public void render(GameContainer container, Graphics g)
			throws SlickException {
		// ATTENTION : Placer d'abord la fonction qui fait la camera sinon ca
		// marche pas! Ici place().
		this.camera.place(container, g);
		this.map.renderBackground();
		this.player.render(g);
		this.map.renderForeGround();
		this.hud.render(g);
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		this.triggers.update();
		this.player.update(delta);
		this.camera.update(container);

	}

}
