package be.ephec.tesa.gui;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import be.ephec.main.Combat;
import be.ephec.main.Constantes;
import be.ephec.main.Game;
import be.ephec.main.Player;
import be.ephec.main.PlayerController;
import be.ephec.main.TriggerController;

public class InterfaceCarte extends BasicGameState {

	//
	// /!\ A REPLACER DANS main.constantes !!! + changer accesseurs !!
	//
	final static double SEUIL_COMBAT = 99; 	// Si le r�sultat du random est
	final static int MAX_FPS = 60;		// sup�rieur � 95, il y a combat.
	private AppGameContainer appGame;
	private GameContainer container;
	private Carte carte = new Carte();
	private Player player = new Player(carte, 200, 200);
	private Camera camera = new Camera(player);
	private TriggerController triggers = new TriggerController(carte, player);
	private Hud hud = new Hud();
	private Game game;
	private Music background;
	
	public InterfaceCarte(Game game) {
		this.game = game;
	}

	public void init(GameContainer container, StateBasedGame interfJeu) throws SlickException {
		/*
		 * String path = System.getProperty("user.dir");
		 * System.out.println(path);
		 */
		this.carte.init();
		this.player.init();
		this.container = container;
		PlayerController controller = new PlayerController(this.player,
				this.container);
		container.getInput().addControllerListener(controller);
		container.getInput().addKeyListener(controller);
		//background = new Music("/ressources/sounds/EyeOfTheTiger.ogg");
		//background.pause();	//Ou faire reprendre la musique ? 
		this.hud.init();
	}

	public void render(GameContainer container, StateBasedGame interfJeu, Graphics g)
			throws SlickException {
		// ATTENTION : Placer d'abord la fonction qui fait la camera sinon ca
		// marche pas! Ici place().
		this.camera.place(container, g);
		this.carte.renderBackground();
		this.player.render(g);
		this.carte.renderForeGround();
		this.hud.render(g);
	}

	public void update(GameContainer container, StateBasedGame interfJeu, int delta)
			throws SlickException {
		this.triggers.update();
		this.player.update(delta);
		this.camera.update(container);
		if (randomCombat() == true){
			interfJeu.enterState(Constantes.COMBAT, new FadeOutTransition(), new FadeInTransition());
		}
	}

	public boolean randomCombat() {
		if (this.player.isMoving() == true) {
			if ((Math.random() * 100) > SEUIL_COMBAT) {
				this.player.setMoving(false);
				return true;
			}
		}
		return false;
	}

	@Override
	public int getID() {
		return Constantes.CARTE_JEU;
	}
}