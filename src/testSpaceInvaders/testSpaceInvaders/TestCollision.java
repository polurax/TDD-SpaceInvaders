package testSpaceInvaders;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Collision;
import model.Dimension;
import model.Position;
import model.SpaceInvaders;

public class TestCollision {

	@Test
	public void test_DetecterCollisionMissileEtEnvahisseur_CollisionFrontale() {
	
		SpaceInvaders spaceinvaders = new SpaceInvaders(15, 10);
		Collision collision = new Collision();
		spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(7,2),new Position(4,9), 1);
		spaceinvaders.positionnerUnNouvelEnvahisseur(new Dimension(1,1),new Position(7,5), 1);
		spaceinvaders.tirerUnMissile(new Dimension(3,3),1);
		spaceinvaders.deplacerMissile();
	    assertEquals(true,collision.detecterCollision(spaceinvaders.getMissile(),spaceinvaders.getEnvahisseur()));
	}
	
	@Test
	public void test_DetecterCollisionMissileEtEnvahisseur_CollisionSurLaGauche() {
	
		SpaceInvaders spaceinvaders = new SpaceInvaders(15, 10);
		Collision collision = new Collision();
		spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(7,2),new Position(4,9), 1);
		spaceinvaders.positionnerUnNouvelEnvahisseur(new Dimension(1,1),new Position(6,5), 1);
		
		spaceinvaders.deplacerEnvahisseur();
		spaceinvaders.tirerUnMissile(new Dimension(3,3),1);
		spaceinvaders.deplacerMissile();
		spaceinvaders.deplacerEnvahisseur();
		
	    assertEquals(true,collision.detecterCollision(spaceinvaders.getMissile(),spaceinvaders.getEnvahisseur()));
	}
	
	@Test
	public void test_DetecterCollisionMissileEtEnvahisseur_CollisionSurLaDroite() {
	
		SpaceInvaders spaceinvaders = new SpaceInvaders(15, 10);
		Collision collision = new Collision();
		spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(7,2),new Position(4,9), 1);
		spaceinvaders.positionnerUnNouvelEnvahisseur(new Dimension(1,1),new Position(9,5), 1);
		
		spaceinvaders.tirerUnMissile(new Dimension(3,3),1);
		spaceinvaders.deplacerMissile();
		spaceinvaders.deplacerEnvahisseur();
	    assertEquals(true,collision.detecterCollision(spaceinvaders.getMissile(),spaceinvaders.getEnvahisseur()));
	}
	
	
	@Test
	public void test_DetecterCollisionVaisseauEtEnvahisseur_CollisionSurLaGauche() {
	
		SpaceInvaders spaceinvaders = new SpaceInvaders(15, 10);
		Collision collision = new Collision();
		spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(7,2),new Position(4,9), 1);
		spaceinvaders.positionnerUnNouvelEnvahisseur(new Dimension(1,1),new Position(3,9), 1);

		spaceinvaders.deplacerVaisseauVersLaGauche();
		
	    assertEquals(true,collision.detecterCollision(spaceinvaders.getVaisseau(),spaceinvaders.getEnvahisseur()));
	}
	
	
	@Test
	public void test_DetecterCollisionVaisseauEtEnvahisseur_CollisionSurLaDroite() {
	
		SpaceInvaders spaceinvaders = new SpaceInvaders(15, 10);
		Collision collision = new Collision();
		spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(7,2),new Position(4,9), 1);
		spaceinvaders.positionnerUnNouvelEnvahisseur(new Dimension(1,1),new Position(12,9), 1);

		spaceinvaders.deplacerVaisseauVersLaDroite();
		
	    assertEquals(true,collision.detecterCollision(spaceinvaders.getVaisseau(),spaceinvaders.getEnvahisseur()));
	}
	
	
	@Test
	public void test_DetecterCollisionVaisseauEtEnvahisseur_CollisionFrontale() {
	
		SpaceInvaders spaceinvaders = new SpaceInvaders(15, 10);
		Collision collision = new Collision();
		spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(7,2),new Position(4,9), 1);
		spaceinvaders.positionnerUnNouvelEnvahisseur(new Dimension(1,1),new Position(7,8), 1);

		spaceinvaders.deplacerEnvahisseur();
		spaceinvaders.deplacerEnvahisseur();
		spaceinvaders.deplacerEnvahisseur();
		
	    assertEquals(true,collision.detecterCollision(spaceinvaders.getVaisseau(),spaceinvaders.getEnvahisseur()));
	}
	
}
