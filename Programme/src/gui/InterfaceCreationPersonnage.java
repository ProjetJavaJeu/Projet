package gui;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import main.Constantes;
import main.Game;

public class InterfaceCreationPersonnage extends BasicGameState implements MouseListener{
	
	private Game game;
	private Image image;
	private TextField champPseudo;
	private int choixClasse;
	private boolean confirm = false;
	private Rectangle rectangle;
	private float xRectangleConfirm;
	private float yRectangleConfirm;
	
	public InterfaceCreationPersonnage(Game game){
		this.game = game;
		choixClasse = 0;
	}

	@Override
	public void init(GameContainer container, StateBasedGame interfJeu)
			throws SlickException {
		image = new Image(Constantes.IMAGE_CREATION_PERSO);
		champPseudo = new TextField(container,container.getDefaultFont(), (container.getWidth() - 150) / 2 , (container.getHeight() / 14), 150, 40);
		champPseudo.setMaxLength(32);
		champPseudo.setText("");
		container.getInput().addMouseListener(this);
		xRectangleConfirm = (float)((container.getWidth() - Constantes.LARGEUR_BOUTON) / 2);
		yRectangleConfirm = (float)(container.getHeight() * 9 / 10);
		rectangle = new Rectangle(xRectangleConfirm, yRectangleConfirm , 150, 40);
	}

	@Override
	public void render(GameContainer container, StateBasedGame interfJeu, Graphics g)
			throws SlickException {
		g.drawImage(image, 0, 0);
		g.drawString("Pseudo ", (container.getWidth() - 300) / 2, (container.getHeight() - 40) / 11);
		champPseudo.render(container, g);
		g.draw(rectangle);
		g.drawString("Confirmer", xRectangleConfirm + 35, (float)(container.getHeight() * 11 / 12));
		g.setColor(Color.black);
		if (choixClasse == 1){
			g.drawRect(98, 113, 464, 512);
		}
		if (choixClasse == 2){
			g.drawRect(716, 113, 464, 512);
		}
	}

	@Override
	public void update(GameContainer container, StateBasedGame interfJeu, int delta)
			throws SlickException {
		if (confirm == true){
			container.getInput().removeMouseListener(this);
			interfJeu.enterState(Constantes.CARTE_JEU, new FadeOutTransition(), new FadeInTransition());
		}
	}
	
	@Override
	public int getID() {
		return Constantes.CREATION_PERSO;
	}

	@Override
	public void mouseClicked(int button, int x, int y, int clickCount) {
		//System.out.println("x = " + x + " y = " + y);
		if (x > 100 & x < 564){
			if (y > 113 & y < 680){
				game.getJoueur().setType('G');
				choixClasse = 1;
			}
		}
		else if (x > 716 & x < 1180){
			if (y > 113 & y < 680){
				game.getJoueur().setType('M');
				choixClasse = 2;
			}
		}
		
		if (x > 605 & x < 755){			//Permet de signifier qu'on a cliqué sur "Confirmer".
			if (y > 643 & y < 693){
				if ((!champPseudo.equals("")) & (choixClasse != 0)){	
					game.getJoueur().setNom(champPseudo.getText());
					confirm = true;
				}
			}
		}
	}
}