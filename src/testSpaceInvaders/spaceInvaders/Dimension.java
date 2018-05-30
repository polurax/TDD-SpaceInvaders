package spaceInvaders;

public class Dimension {
	int largeur;
	int hauteur;

	public Dimension(int largeur, int hauteur) {
		this.largeur = largeur;
		this.hauteur = hauteur;
	}

	public int largeur() {
		return this.largeur;
	}

	public int hauteur() {
		return this.hauteur;
	}

}