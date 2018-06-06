package moteurJeu;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.Constante;
import model.Dimension;
import model.Position;
import model.SpaceInvaders;
import model.Vaisseau;

public class ContenuFenetre extends JPanel {

	protected SpaceInvaders spaceInvaders;

	public ContenuFenetre(SpaceInvaders spaceInvaders) {
		this.spaceInvaders = spaceInvaders;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (!spaceInvaders.etreFini()) {
			g.setColor(Color.GREEN);
			g.fillRect(spaceInvaders.getVaisseau().getOrigine().abscisse(),
					spaceInvaders.getVaisseau().getOrigine().ordonnee(),
					spaceInvaders.getVaisseau().getDimension().largeur(),
					spaceInvaders.getVaisseau().getDimension().hauteur());

			g.setColor(Color.BLACK);
			g.fillRect(spaceInvaders.getEnvahisseur().getOrigine().abscisse(),
					spaceInvaders.getEnvahisseur().getOrigine().ordonnee(),
					spaceInvaders.getEnvahisseur().getDimension().largeur(),
					spaceInvaders.getEnvahisseur().getDimension().hauteur());

			if (spaceInvaders.aUnMissile()) {
				g.setColor(Color.BLUE);
				Position positionMissile = new Position(spaceInvaders.getMissile().getOrigine().abscisse(),
						spaceInvaders.getMissile().getOrigine().ordonnee());
				g.fillRect(positionMissile.getX(), positionMissile.getY(), Constante.MISSILE_LARGEUR,
						Constante.MISSILE_HAUTEUR);
			}
		}else {
			g.drawString(spaceInvaders.getMessageFinPartie(), 5, 15);
		}

	}

}
