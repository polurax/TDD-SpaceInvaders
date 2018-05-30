package spaceInvaders;

import utils.DebordementEspaceJeuException;
import utils.HorsEspaceJeuException;

public class SpaceInvaders {

	private static final int BORDURE_GAUCHE = 0;
	private static final char MARQUE_FIN_DE_LIGNE = '\n';
	private static final char MARQUE_VIDE = '.';
	private static final char MARQUE_VAISSEAU = 'V';

	private int longueur;
	private int hauteur;
	private Vaisseau vaisseau;

	public SpaceInvaders(int longueur, int hauteur) {
		this.longueur = longueur;
		this.hauteur = hauteur;
	}

	public char recupererMarqueDeLaPosition(int x, int y) {
		char marque;
		if (this.aUnVaisseauQuiOccupeLaPosition(x, y)) {
			marque = MARQUE_VAISSEAU;
		} else {
			marque = MARQUE_VIDE;
		}
		return marque;
	}

	public boolean aUnVaisseauQuiOccupeLaPosition(int x, int y) {
		return this.aUnVaisseau() && this.vaisseau.occupeLaPosition(x, y);
	}

	public boolean aUnVaisseau() {
		return this.vaisseau != null;
	}

	public boolean estDansEspaceJeu(int x, int y) {
		return x < this.longueur && x >= 0 && y < this.hauteur && y >= 0;
	}

	public String recupererEspaceJeuDansChaineASCII() {
		StringBuilder espaceDeJeu = new StringBuilder();

		for (int y = 0; y < hauteur; y++) {
			for (int x = 0; x < longueur; x++) {
				espaceDeJeu.append(recupererMarqueDeLaPosition(x, y));
			}
			espaceDeJeu.append(MARQUE_FIN_DE_LIGNE);
		}
		return espaceDeJeu.toString();
	}

	public void deplacerVaisseauVersLaDroite() {
		if (vaisseau.abscisseLaPlusADroite() < (longueur - 1)) {
			vaisseau.seDeplacerVersLaDroite();
			if (!estDansEspaceJeu(vaisseau.abscisseLaPlusADroite(), vaisseau.ordonneeLaPlusEnHaut())) {
				vaisseau.positionner(longueur - vaisseau.largeur(), vaisseau.ordonneeLaPlusEnHaut());
			}
		}
	}

	private boolean abscisseLaPlusADroite() {
		return this.vaisseau.abscisseLaPlusADroite() < longueur - 1;
	}

	public void deplacerVaisseauVersLaGauche() {
		if (abscisseLaPlusAGauche()) {
			this.vaisseau.seDeplacerVersLaGauche();
		}
	}

	private boolean abscisseLaPlusAGauche() {
		return vaisseau.abscisseLaPlusAGauche() > BORDURE_GAUCHE;
	}

	public void positionnerUnNouveauVaisseau(Dimension dimension, Position position, int vitesse) {

		int x = position.abscisse();
		int y = position.ordonnee();

		if (!estDansEspaceJeu(x, y))
			throw new HorsEspaceJeuException("La position du vaisseau est en dehors de l'espace jeu");

		int longueurVaisseau = dimension.largeur();
		int hauteurVaisseau = dimension.hauteur();

		if (!estDansEspaceJeu(x + longueurVaisseau - 1, y))
			throw new DebordementEspaceJeuException(
					"Le vaisseau déborde de l'espace jeu vers la droite à cause de sa longueur");
		if (!estDansEspaceJeu(x, y - hauteurVaisseau + 1))
			throw new DebordementEspaceJeuException(
					"Le vaisseau déborde de l'espace jeu vers le bas à cause de sa hauteur");

		vaisseau = new Vaisseau(dimension,position,vitesse);
	}

}
