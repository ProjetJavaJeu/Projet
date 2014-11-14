package main;

import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.tiled.TiledMap;

public class WindowGame extends BasicGame {
	private GameContainer container;
	private TiledMap map;
	private float x = 300, y = 300; // Coordonnées du joueur.
	private float xCamera = x, yCamera = y; // Coordonnées de la caméra qui va
											// suivre le joueur.
	private int direction = 0; // Détermine la direction (Nord = 0, Ouest = 1,
								// Sud = 2, Est = 3).
	private boolean moving = false; // Détermine si le personnage peut bouger ou
									// non.
	private Animation[] animations = new Animation[8];

	public WindowGame() {
		super("Lesson 1 :: WindowGame");
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		/*
		 * String path = System.getProperty("user.dir");
		 * System.out.println(path);
		 */// Les deux lignes en commentaires permettent de récupérer le fichier
			// courant lorsque java lance le programme.
		this.container = container; // Le répertoire courant ici est le dossier
									// Programme.
		this.map = new TiledMap("/src/main/ressources/map/exemple.tmx");
		SpriteSheet spriteSheet = new SpriteSheet(
				"/src/main/ressources/sprites/humanTalk.png", 64, 64);
		this.animations[0] = loadAnimation(spriteSheet, 0, 1, 0); // Les huit
																	// lignes
																	// ici
																	// définissent
																	// les
																	// images
																	// utilisées
																	// pour les
																	// animations
																	// de
		this.animations[1] = loadAnimation(spriteSheet, 0, 1, 1); // mouvements
																	// du
																	// personnage.
		this.animations[2] = loadAnimation(spriteSheet, 0, 1, 2);
		this.animations[3] = loadAnimation(spriteSheet, 0, 1, 3);
		this.animations[4] = loadAnimation(spriteSheet, 1, 9, 0);
		this.animations[5] = loadAnimation(spriteSheet, 1, 9, 1);
		this.animations[6] = loadAnimation(spriteSheet, 1, 9, 2);
		this.animations[7] = loadAnimation(spriteSheet, 1, 9, 3);
	}

	private Animation loadAnimation(SpriteSheet spriteSheet, int startX,
			int endX, int y) { // Cette méthode met image par image le mouvement
								// dans un tableau.
		Animation animation = new Animation();
		for (int x = startX; x < endX; x++) {
			animation.addFrame(spriteSheet.getSprite(x, y), 100);
		}
		return animation;
	}

	@Override
	public void render(GameContainer container, Graphics g)
			throws SlickException {
		g.translate(container.getWidth() / 2 - (int) this.xCamera,
				container.getHeight() / 2 - (int) this.yCamera);
		// Le g.translate va jouer le rôle de la caméra : elle va se centrer sur
		// le personnage. ATTENTION : A placer en premier dans render() sinon ca
		// marche pas!
		this.map.render(0, 0);
		g.setColor(new Color(0, 0, 0, .5f));// setColor et fillOval vont
											// permettre de placer une ombre
											// sous le joueur.
		g.fillOval(x - 16, y - 8, 32, 16);
		g.drawAnimation(animations[direction + (moving ? 4 : 0)], x - 32,
				y - 60); // moving ? 4: 1 => 1 définit la direction du
							// personnage. 0 vers le haut, 1 vers la gauche,
							// 2 vers le bas et 3 vers la droite. Pas encore
							// compris à à quoi servait le 4.

	}

	@Override
	public void keyReleased(int key, char c) {
		if (Input.KEY_ESCAPE == key) {
			container.exit();
		}
		switch (key) {
		case Input.KEY_UP:
			this.direction = 0;
			this.moving = true;
			break;
		case Input.KEY_LEFT:
			this.direction = 1;
			this.moving = true;
			break;
		case Input.KEY_DOWN:
			this.direction = 2;
			this.moving = true;
			break;
		case Input.KEY_RIGHT:
			this.direction = 3;
			this.moving = true;
			break;
		}
	}

	
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
	    if (this.moving) {
	        float futurX = getFuturX(delta);
	        float futurY = getFuturY(delta);
	        boolean collision = isCollision(futurX, futurY);
	        if (collision) {
	            this.moving = false;
	        } else {
	            this.x = futurX;
	            this.y = futurY;
	        }
	    }
		int w = container.getWidth() / 4;
		if (this.x > this.xCamera + w)
			this.xCamera = this.x - w;
		if (this.x < this.xCamera - w)
			this.xCamera = this.x + w;
		int h = container.getHeight() / 4;
		if (this.y > this.yCamera + h)
			this.yCamera = this.y - h;
		if (this.y < this.yCamera - h)
			this.yCamera = this.y + h;
	}

	private boolean isCollision(float x, float y) {
	    int tileW = this.map.getTileWidth();
	    int tileH = this.map.getTileHeight();
	    int logicLayer = this.map.getLayerIndex("logic");
	    Image tile = this.map.getTileImage((int) x / tileW, (int) y / tileH, logicLayer);
	    boolean collision = tile != null;
	    if (collision) {
	        Color color = tile.getColor((int) x % tileW, (int) y % tileH);
	        collision = color.getAlpha() > 0;
	    }
	    return collision;
	}

	private float getFuturX(int delta) {
	    float futurX = this.x;
	    switch (this.direction) {
	    case 1: futurX = this.x - .1f * delta; break;
	    case 3: futurX = this.x + .1f * delta; break;
	    }
	    return futurX;
	}

	private float getFuturY(int delta) {
	    float futurY = this.y;
	    switch (this.direction) {
	    case 0: futurY = this.y - .1f * delta; break;
	    case 2: futurY = this.y + .1f * delta; break;
	    }
	    return futurY;
	}

	public static void main(String[] args) throws SlickException {
		new AppGameContainer(new WindowGame(), 1366, 768, false).start();
	}

}
