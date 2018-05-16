package spaceInvaders;

public class Vaisseau {
	
	private int x;
	private int y;

	public Vaisseau(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean occupeLaPosition(int x, int y) {
		return (this.x==x) && (this.y==y);
	}

	public void seDeplacerVersLaDroite() {
		this.x++;
	}

	public int abscisse() {
		return this.x;
	}

	public void seDeplacerVersLaGauche() {
		this.x--;
		
	}
}
