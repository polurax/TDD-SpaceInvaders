package spaceInvaders;

public class Vaisseau {
	
	private int x;
	private int y;
	private int largeur;
	private int hauteur;
	

	public Vaisseau(int largeur, int hauteur) {
		this(largeur, hauteur, 0, 0);
	}
	
	public Vaisseau(int largeur, int hauteur, int x, int y) {
		this.x = x;
		this.y = y;
		this.largeur=largeur;
		this.hauteur=hauteur;
	}
	
	public boolean occupeLaPosition(int x, int y) {
	     return(estAbscisseCouverte(x) && estOrdonneeCouverte(y));
    }

	private boolean estOrdonneeCouverte(int y) {
		return (ordonneeLaPlusEnHaut()<=y) && (y<=ordonneeLaPlusEnBas());
	}

	private int ordonneeLaPlusEnBas() {
		return this.y;
	}

	private int ordonneeLaPlusEnHaut() {
		return ordonneeLaPlusEnBas()-this.hauteur+1;
	}

	private boolean estAbscisseCouverte(int x) {
		return (abscisseLaPlusAGauche()<=x) && (x<=abscisseLaPlusADroite());
	}

	private int abscisseLaPlusADroite() {
		return this.x+this.largeur-1;
	}

	public void seDeplacerVersLaDroite() {
		this.x++;
	}

	public int abscisseLaPlusAGauche() {
		return this.x;
	}

	public void seDeplacerVersLaGauche() {
		this.x--;
		
	}

	public void positionner(int x, int y) {
		this.x=x;
		this.y=y;
	}
}
