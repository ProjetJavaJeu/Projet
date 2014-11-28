package main;

import gui.Map;

import org.newdawn.slick.SlickException;

public class TriggerController {
	private Map map;
	private Player player;

	public TriggerController(Map map, Player player) {
		this.map = map;
		this.player = player;
	}
	
	public void update() throws SlickException {
		for (int objectID = 0; objectID < this.map.getObjectCount(); objectID++) {
			if (isInTrigger(objectID)) {
				String type = this.map.getObjectType(objectID);
				if ("teleport".equals(this.map.getObjectType(objectID))) {
					teleport(objectID);
				} else if ("changemap".equals(type)) {
					changeMap(objectID);
				}
			}
		}
	}
	
	private boolean isInTrigger(int id) {
		return this.player.getX() > map.getObjectX(id)
				&& this.player.getX() < map.getObjectX(id)
						+ map.getObjectWidth(id)
				&& this.player.getY() > map.getObjectY(id)
				&& this.player.getY() < map.getObjectY(id)
						+ map.getObjectHeight(id);
	}

	private void teleport(int id) {
		this.player.setX(Float.parseFloat(this.map.getObjectProperty(id,
				"dest-x", Float.toString(this.player.getX()))));
		this.player.setY(Float.parseFloat(this.map.getObjectProperty(id,
				"dest-y", Float.toString(this.player.getY()))));
	}
	
	private void changeMap(int objectID) throws SlickException {
		teleport(objectID);
		String newMap = this.map.getObjectProperty(objectID, "dest-map",
				"undefined");
		if (!"undefined".equals(newMap)) {
			this.map.changeMap("/src/main/ressources/map/" + newMap);
		}
	}
}
