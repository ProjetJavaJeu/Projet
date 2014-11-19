package main;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Hud {

	  private Image playerbars;
	  private static final int P_BAR_X = 30;
	  private static final int P_BAR_Y = 30;
	  public void init() throws SlickException {
	    this.playerbars = new Image("/src/main/ressources/map/HUD/playerBar.png");
	  }
	  
	  public void render(Graphics g) {
	    g.resetTransform();
	    g.drawImage(this.playerbars, P_BAR_X, P_BAR_Y);
	  }
	  
	  
}
