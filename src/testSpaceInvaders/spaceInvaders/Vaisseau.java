package spaceInvaders;

public class Vaisseau {
	
	private Position origine;
	private Dimension dimension;
	private int vitesse;
	

	public Vaisseau(int longueur, int hauteur) {
	    this(longueur, hauteur, 0, 0);
    }

    public Vaisseau(int longueur, int hauteur, int x, int y) {
	    this(new Dimension(longueur, hauteur), new Position(x, y),1);
    }

    public Vaisseau(Dimension dimension, Position positionOrigine, int vitesse) {
	    this.dimension = dimension;
	    this.origine = positionOrigine;
	    this.vitesse = vitesse;
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
		return ordonneeLaPlusEnBas()-this.dimension.hauteur+1;
	}

	public boolean estAbscisseCouverte(int x) {
		return (abscisseLaPlusAGauche()<=x) && (x<=abscisseLaPlusADroite());
	}

	public int abscisseLaPlusADroite() {
		return this.origine.abscisse()+this.dimension.largeur-1;
	}

	public void seDeplacerVersLaDroite() {
		this.origine.changerAbscisse(this.origine.abscisse()+this.vitesse);
	}

	public int abscisseLaPlusAGauche() {
		return this.origine.abscisse();
	}

	public void seDeplacerVersLaGauche() {
		this.origine.changerAbscisse(this.origine.abscisse()-this.vitesse);
		
	}

	public void positionner(int x, int y) {
		this.origine.changerAbscisse(x);
		this.origine.changerOrdonnee(y);
	}
	
	public int largeur(){
		return this.dimension.largeur;
	}
	
}
