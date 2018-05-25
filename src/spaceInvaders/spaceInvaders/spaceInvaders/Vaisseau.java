package spaceInvaders.spaceInvaders;

public class Vaisseau {
	
	private Position origine;
	private int largeur;
	private int hauteur;
	

	public Vaisseau(int largeur, int hauteur) {
		this(largeur, hauteur, 0, 0);
	}
	
	public Vaisseau(int largeur, int hauteur, int x, int y) {
		this.origine = new Position(x,y);
		this.largeur=largeur;
		this.hauteur=hauteur;
	}
	
	public boolean occupeLaPosition(int x, int y) {
	     return(estAbscisseCouverte(x) && estOrdonneeCouverte(y));
    }

	public boolean estOrdonneeCouverte(int y) {
		return (ordonneeLaPlusEnHaut()<=y) && (y<=ordonneeLaPlusEnBas());
	}

	public int ordonneeLaPlusEnBas() {
		return this.origine.ordonnee();
	}

	public int ordonneeLaPlusEnHaut() {
		return ordonneeLaPlusEnBas()-this.hauteur+1;
	}

	public boolean estAbscisseCouverte(int x) {
		return (abscisseLaPlusAGauche()<=x) && (x<=abscisseLaPlusADroite());
	}

	public int abscisseLaPlusADroite() {
		return this.origine.abscisse()+this.largeur-1;
	}

	public void seDeplacerVersLaDroite() {
		this.origine.changerAbscisse(this.origine.abscisse()+1);
	}

	public int abscisseLaPlusAGauche() {
		return this.origine.abscisse();
	}

	public void seDeplacerVersLaGauche() {
		this.origine.changerAbscisse(this.origine.abscisse()-1);;
		
	}

	public void positionner(int x, int y) {
		this.origine.changerAbscisse(x);
		this.origine.changerOrdonnee(y);
	}
}
