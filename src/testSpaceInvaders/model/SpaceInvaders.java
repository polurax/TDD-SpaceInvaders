package model;


import moteurJeu.Commande;
import moteurJeu.Jeu;
import utils.DebordementEspaceJeuException;
import utils.HorsEspaceJeuException;
import utils.MissileException;

public class SpaceInvaders implements Jeu{

	private static final int BORDURE_GAUCHE = 0;
	private static final char MARQUE_FIN_DE_LIGNE = '\n';
	private static final char MARQUE_VIDE = '.';
	private static final char MARQUE_VAISSEAU = 'V';

	private int largeur;
	private int hauteur;
	private Vaisseau vaisseau;
	private Missile missile;

	public SpaceInvaders(int largeur, int hauteur) {
		this.largeur = largeur;
		this.hauteur = hauteur;
	}

	private char recupererMarqueDeLaPosition(int x, int y) {
		char marque;
		if (this.aUnVaisseauQuiOccupeLaPosition(x, y))
			marque = Constante.MARQUE_VAISSEAU;
		else if (this.aUnMissileQuiOccupeLaPosition(x, y))
				marque = Constante.MARQUE_MISSILE;
		else marque = Constante.MARQUE_VIDE;
		return marque;
	}

	public boolean aUnVaisseauQuiOccupeLaPosition(int x, int y) {
		return this.aUnVaisseau() && this.vaisseau.occupeLaPosition(x, y);
	}

	public boolean aUnVaisseau() {
		return this.vaisseau != null;
	}

	public boolean estDansEspaceJeu(int x, int y) {
		return x < this.largeur && x >= 0 && y < this.hauteur && y >= 0;
	}

	public String recupererEspaceJeuDansChaineASCII() {
		StringBuilder espaceDeJeu = new StringBuilder();

		for (int y = 0; y < hauteur; y++) {
			for (int x = 0; x < largeur; x++) {
				espaceDeJeu.append(recupererMarqueDeLaPosition(x, y));
			}
			espaceDeJeu.append(MARQUE_FIN_DE_LIGNE);
		}
		return espaceDeJeu.toString();
	}

	public void deplacerVaisseauVersLaDroite() {
		if (this.abscisseLaPlusADroite()) {
			vaisseau.deplacerHorizontalementVers(Direction.DROITE);
			if (!estDansEspaceJeu(vaisseau.abscisseLaPlusADroite(), vaisseau.ordonneeLaPlusEnHaut())) {
				vaisseau.positionner(this.largeur - vaisseau.largeur(), vaisseau.ordonneeLaPlusEnHaut()+1);
			}
		}
	}

	private boolean abscisseLaPlusADroite() {
		return this.vaisseau.abscisseLaPlusADroite() < largeur -1;
	}

	public void deplacerVaisseauVersLaGauche() {
		if (0 < vaisseau.abscisseLaPlusAGauche())
			vaisseau.deplacerHorizontalementVers(Direction.GAUCHE);
		if (!estDansEspaceJeu(vaisseau.abscisseLaPlusAGauche(), vaisseau.ordonneeLaPlusEnHaut())) {
			vaisseau.positionner(0, vaisseau.ordonneeLaPlusEnHaut()+1);
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

	public void initialiserJeu() {
		Position positionVaisseau = new Position(this.largeur/2,this.hauteur-1);
		Dimension dimensionVaisseau = new Dimension(Constante.VAISSEAU_LARGEUR, Constante.VAISSEAU_HAUTEUR);
		positionnerUnNouveauVaisseau(dimensionVaisseau, positionVaisseau, Constante.VAISSEAU_VITESSE);
	 }
	
	
	public void evoluer(Commande commandeUser) {

		if(commandeUser.gauche){
			this.deplacerVaisseauVersLaGauche();
		}else if(commandeUser.droite){
			this.deplacerVaisseauVersLaDroite();
		}
		
	}

	public boolean etreFini() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean aUnMissileQuiOccupeLaPosition(int x, int y) {
		return this.aUnMissile() && this.missile.occupeLaPosition(x, y);
	}

	public boolean aUnMissile() {
		return this.missile != null;
	}

	public void tirerUnMissile(Dimension dimension, int vitesse) {
		if ((vaisseau.hauteur()+ dimension.hauteur()) > this.hauteur )
			   throw new MissileException("Pas assez de hauteur libre entre le vaisseau et le haut de l'espace jeu pour tirer le missile");
							
		   this.missile = this.vaisseau.tirerUnMissile(dimension,vitesse);
		
	}

	public void deplacerMissile() {
		if(this.missile.ordonneeLaPlusEnBas()>1) {
			this.missile.deplacerVerticalementVers(Direction.HAUT);
		}else {
			this.missile = null;
		}
	}
	
	

}
