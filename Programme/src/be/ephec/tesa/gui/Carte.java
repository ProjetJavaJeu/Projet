package be.ephec.tesa.gui;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class Carte {
	private TiledMap tiledMap;
	 public void init() throws SlickException {
		 this.tiledMap = new TiledMap("/ressources/map/exemple-collision2.tmx");
	 }
	 
	 public int getObjectCount() {	// Getters / Setters redéfini (On met 0 pour le premier paramètre).
		    return this.tiledMap.getObjectCount(0);
		  }
		  public String getObjectType(int objectID) {
		    return this.tiledMap.getObjectType(0, objectID);
		  }
		  public float getObjectX(int objectID) {
		    return this.tiledMap.getObjectX(0, objectID);
		  }
		  public float getObjectY(int objectID) {
		    return this.tiledMap.getObjectY(0, objectID);
		  }
		  public float getObjectWidth(int objectID) {
		    return this.tiledMap.getObjectWidth(0, objectID);
		  }
		  public float getObjectHeight(int objectID) {
		    return this.tiledMap.getObjectHeight(0, objectID);
		  }
		  public String getObjectProperty(int objectID, String propertyName, String def) {
		    return this.tiledMap.getObjectProperty(0, objectID, propertyName, def);
		  }
		  
		  public void changeMap(String file) throws SlickException {
			    this.tiledMap = new TiledMap(file);
			  }
		  
	 public void renderBackground(){ //Ce qui est affiché en arrière plan.
		 this.tiledMap.render(0, 0, 0);
		 this.tiledMap.render(0, 0, 1);
		 this.tiledMap.render(0, 0, 2);
		 this.tiledMap.render(0, 0, 4);
		 this.tiledMap.render(0, 0, 5);
	 }
	 
	 public void renderForeGround(){ //Ce qui est affiché à l'avant plan (devant le personnage).
		//PAS FINIIII OU DELETTEEE !??????
	 }
	 
	 public boolean isCollision(float x, float y) {
		    int tileW = this.tiledMap.getTileWidth();
		    int tileH = this.tiledMap.getTileHeight();
		    int logicLayer = this.tiledMap.getLayerIndex("logic");
		    Image tile = this.tiledMap.getTileImage((int) x / tileW, (int) y / tileH, logicLayer);
		    boolean collision = tile != null;
		    if (collision) {
		        Color color = tile.getColor((int) x % tileW, (int) y % tileH);
		        collision = color.getAlpha() > 0;
		    }
		    return collision;
		}
}
