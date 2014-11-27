package main;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.Graphics;

import PPersonnages.Personnage;

public class Player {
	private float x;
	private float y;
	private int direction = 0;
	private boolean moving = false;
	private Animation[] animations = new Animation[8];
	private Map map;
	private char type;
	Personnage perso;

	// private boolean onStair = false; //si nécessité de rajouter des
	// escaliers.

	public Player(Map map, float x, float y) {
		this.map = map;
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		if ((x < 0) | (x > 1280)){
			this.x = x;
		}
		else{
			System.out.println("Coordonnée X incorrecte !");
		}
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		if ((y < 0) | (y > 1280)){
			this.y = y;
		}
		else{
			System.out.println("Coordonnée Y incorrecte !");
		}
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}
	/*
	public boolean isOnStair() {
		return onStair;
	}

	public void setOnStair(boolean onStair) {
		this.onStair = onStair;
	}
	*/
	
	public void init() throws SlickException {
		SpriteSheet spriteSheet = new SpriteSheet(
				"/src/main/ressources/sprites/baldricWalk.png", 64, 64);
		this.animations[0] = loadAnimation(spriteSheet, 0, 1, 0);
		this.animations[1] = loadAnimation(spriteSheet, 0, 1, 1);
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

	public void render(Graphics g) throws SlickException {
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

	public void update(int delta) throws SlickException {
		if (this.moving) {
			float futurX = getFuturX(delta);
			float futurY = getFuturY(delta);
			boolean collision = this.map.isCollision(futurX, futurY);
			if (collision) {
				this.moving = false;
			} else {
				this.x = futurX;
				this.y = futurY;
			}
		}
	}

	private float getFuturX(int delta) {
		float futurX = this.x;
		switch (this.direction) {
		case 1:
			futurX = this.x - .1f * delta;
			break;
		case 3:
			futurX = this.x + .1f * delta;
			break;
		}
		return futurX;
	}

	private float getFuturY(int delta) {
		float futurY = this.y;
		switch (this.direction) {
		case 0:
			futurY = this.y - .1f * delta;
			break;
		case 2:
			futurY = this.y + .1f * delta;
			break;
		}
		return futurY;
	}

}
