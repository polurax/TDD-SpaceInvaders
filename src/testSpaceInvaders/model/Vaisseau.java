package model;

import utils.MissileException;

public class Vaisseau extends Sprite{

    public Vaisseau(Dimension dimension, Position positionOrigine, int vitesse) {
    	super(dimension, positionOrigine, vitesse);
    }

    public Missile tirerUnMissile(Dimension dimensionMissile, int vitesseMissile){
		
    	if(dimensionMissile.largeur>this.largeur()) {
    		throw new MissileException("Le missile est plus large que le vaisseau");
    	}else if(dimensionMissile.hauteur>this.ordonneeLaPlusEnBas()) {
    		throw new MissileException("Le missile est plus haut que le vaisseau");
    	}
    	
		Position positionOrigineMissile = calculerLaPositionDeTirDuMissile(dimensionMissile);

		return new Missile(dimensionMissile, positionOrigineMissile, vitesseMissile);
	}

	private Position calculerLaPositionDeTirDuMissile(Dimension dimensionMissile) {
		int abscisseMilieuVaisseau = this.abscisseLaPlusAGauche() + (this.largeur() / 2);
		int abscisseOrigineMissile = abscisseMilieuVaisseau - (dimensionMissile.largeur() / 2);

		int ordonneeeOrigineMissile = this.ordonneeLaPlusEnHaut() - 1;
		Position positionOrigineMissile = new Position(abscisseOrigineMissile, ordonneeeOrigineMissile);
		return positionOrigineMissile;
	}
	
}
