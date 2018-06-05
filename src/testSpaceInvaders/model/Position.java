package model;

public class Position {
	private int x;
	private int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int abscisse() {
		return this.x;
	}

	public int ordonnee() {
		return this.y;
	}

	public void changerAbscisse(int nouvelleAbscisse) {
        this.x = nouvelleAbscisse;
   }

   public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

public void changerOrdonnee(int nouvelleOrdonnee) {
       this.y = nouvelleOrdonnee;
   }
	
}