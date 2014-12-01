package gui;

import main.Combat;
import main.Player;
import main.PlayerController;
import main.TriggerController;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

import PPersonnages.MonstresCommuns;
import PPersonnages.MonstresElites;
import PPersonnages.Personnage;

public class WindowMap extends BasicGame {
	
	final static double SEUIL_COMBAT = 95; // Si le résultat du random est supérieur à 95, il y a combat.
	private GameContainer container;
	private Map map = new Map();
	private Player player = new Player(map, 200, 200);
	private Camera camera = new Camera(player);
	private TriggerController triggers = new TriggerController(map, player);
	private Hud hud = new Hud();
	private MonstresCommuns tabMonstres[];
	private MonstresElites tabElites[];
	
	public WindowMap() {
		super("The Epic School Adventure !");
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
				"/ressources/sounds/EyeOfTheTiger.ogg");
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
		randomCombat();
	}

	public void randomCombat(){
		if (this.player.isMoving() == true){
			if ((Math.random() * 100) > SEUIL_COMBAT){
				//lancer combat
				System.out.println("Combat");
				this.container.pause();
				this.player.setMoving(false);
				Personnage monstre = tabMonstres[(int)Math.random()];
				Combat combat = new Combat(player, monstre);
				
			}
		}	
	}
	
	public void launchMap(MonstresCommuns tabM[], MonstresElites tabE[], Personnage perso) throws SlickException{
		tabMonstres = tabM;
		tabElites = tabE;
		player.setPerso(perso);
		new AppGameContainer(this, 1366, 768, true).start();
	}
}
