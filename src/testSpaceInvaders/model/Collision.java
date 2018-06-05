package model;

public class Collision {

	public boolean detecterCollision(Sprite sprite1, Sprite sprite2) {

		return isSpriteSuperposes(sprite1, sprite2);

	}

	private boolean isSpriteSuperposes(Sprite sprite1, Sprite sprite2) {
		return sprite1.ordonneeLaPlusEnHaut() <= sprite2.ordonneeLaPlusEnBas()
				&& sprite1.ordonneeLaPlusEnBas() >= sprite2.ordonneeLaPlusEnHaut()
				&& sprite1.abscisseLaPlusAGauche() >= sprite2.abscisseLaPlusAGauche()
				&& sprite1.abscisseLaPlusADroite() <= sprite2.abscisseLaPlusADroite();
	}
}
