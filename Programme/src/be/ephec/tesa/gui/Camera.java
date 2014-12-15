package be.ephec.tesa.gui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import be.ephec.main.Player;

public class Camera {
	private Player player;
	private float xCamera, yCamera;

	public Camera(Player player) {
		this.player = player;
		this.xCamera = player.getX();
		this.yCamera = player.getY();
	}

	public void place(GameContainer container, Graphics g) {
		g.translate(container.getWidth() / 2 - (int) this.xCamera,
				container.getHeight() / 2 - (int) this.yCamera);
	}
	
	public void update(GameContainer container){
		int w = container.getWidth() / 4;
		if (this.player.getX() > this.xCamera + w)
			this.xCamera = this.player.getX() - w;
		if (this.player.getX() < this.xCamera - w)
			this.xCamera = this.player.getX() + w;
		int h = container.getHeight() / 4;
		if (this.player.getY() > this.yCamera + h)
			this.yCamera = this.player.getY() - h;
		if (this.player.getY() < this.yCamera - h)
			this.yCamera = this.player.getY() + h;
	}
}
