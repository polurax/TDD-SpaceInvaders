package model;

public class Envahisseur extends Sprite{

	private String deplacementEffectue = ""; 
	
	public Envahisseur(Dimension dimension, Position origine, int vitesse) {
		super(dimension, origine, vitesse);
		// TODO Auto-generated constructor stub
	}

	public String getDeplacementEffectue() {
		return deplacementEffectue;
	}

	public void setDeplacementEffectue(String deplacementEffectue) {
		this.deplacementEffectue = deplacementEffectue;
	}

}
