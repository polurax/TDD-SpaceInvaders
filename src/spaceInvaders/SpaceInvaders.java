package spaceInvaders;

public class SpaceInvaders {

	private int longueur;
    private int hauteur;

    public SpaceInvaders(int longueur, int hauteur) {
	   private this.longueur = longueur;
	   private this.hauteur = hauteur;
	   private Vaisseau vaisseau;
   }
    
    @Override
	public String toString() {
		StringBuilder espaceDeJeu = new StringBuilder();
		for (int i = 0; i < hauteur; i++) {
			for (int j = 0; j < longueur; j++) {
				if (vaisseau.occupeLaPosition(x, y))
				     espaceDeJeu.append('V');
				else
					espaceDeJeu.append('.');
			}
			espaceDeJeu.append('\n');
		}
		return espaceDeJeu.toString();
	}
    
    public void positionnerUnNouveauVaisseau(int x, int y) {
        this.vaisseau = new Vaisseau(x, y);
	}
}
