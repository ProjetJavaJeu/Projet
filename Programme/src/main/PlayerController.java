package main;

import org.newdawn.slick.ControllerListener;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;

public class PlayerController implements KeyListener, ControllerListener {
	private Player player;
	private GameContainer container;
	public PlayerController(Player player, GameContainer container) {
		this.player = player;
		this.container = container;
		
	}

	@Override
	public void setInput(Input input) {
	}

	@Override
	public boolean isAcceptingInput() {
		return true;
	}

	@Override
	public void inputEnded() {
	}

	@Override
	public void inputStarted() {
	}

	@Override
	public void keyPressed(int key, char c) {
		if (key == Input.KEY_ESCAPE){
			this.container.exit();
		}
		switch (key) {
		case Input.KEY_UP:
			this.player.setDirection(0);
			this.player.setMoving(true);
			break;
		case Input.KEY_LEFT:
			this.player.setDirection(1);
			this.player.setMoving(true);
			break;
		case Input.KEY_DOWN:
			this.player.setDirection(2);
			this.player.setMoving(true);
			break;
		case Input.KEY_RIGHT:
			this.player.setDirection(3);
			this.player.setMoving(true);
			break;
		}
	}

	@Override
	public void keyReleased(int key, char c) {
		this.player.setMoving(false);
	}

	@Override
	public void controllerLeftPressed(int controller) {
		this.player.setDirection(1);
		this.player.setMoving(true);
	}

	@Override
	public void controllerLeftReleased(int controller) {
		this.player.setMoving(false);
	}

	@Override
	public void controllerRightPressed(int controller) {
		this.player.setDirection(3);
		this.player.setMoving(true);
	}

	@Override
	public void controllerRightReleased(int controller) {
		this.player.setMoving(false);
	}

	@Override
	public void controllerUpPressed(int controller) {
		this.player.setDirection(0);
		this.player.setMoving(true);
	}

	@Override
	public void controllerUpReleased(int controller) {
		this.player.setMoving(false);
	}

	@Override
	public void controllerDownPressed(int controller) {
		this.player.setDirection(2);
		this.player.setMoving(true);
	}

	@Override
	public void controllerDownReleased(int controller) {
		this.player.setMoving(false);
	}

	@Override
	public void controllerButtonPressed(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void controllerButtonReleased(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

}
