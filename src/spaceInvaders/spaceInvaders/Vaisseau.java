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
	     if ((this.x<=x) && (x<=this.x+this.largeur-1)) 
		      if ( (this.y-this.hauteur+1<=y) && (y<=this.y))
			  return true;
		
	     return false;
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
