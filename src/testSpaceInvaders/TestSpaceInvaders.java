package testSpaceInvaders;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import spaceInvaders.SpaceInvaders;

public class TestSpaceInvaders {

	@Test
	public void test_AuDebut_JeuSpaceInvaderEstVide() {
		SpaceInvaders spaceinvaders = new SpaceInvaders(15, 10);
		assertEquals("" + "...............\n" 
						+ "...............\n" 
						+ "...............\n" 
						+ "...............\n"
						+ "...............\n" 
						+ "...............\n" 
						+ "...............\n" 
						+ "...............\n"
						+ "...............\n" 
						+ "...............\n", spaceinvaders.toString());
	}
	
	@Test
	public void test_unNouveauVaisseauEstCorrectementPositionneDansEspaceJeu() {
		SpaceInvaders spaceinvaders = new SpaceInvaders(15, 10);
		spaceinvaders.positionnerUnNouveauVaisseau(7,9);
		assertEquals("" + 
		"...............\n" + 
		"...............\n" +
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		"...............\n" + 
		".......V.......\n" , spaceinvaders.toString());
	}

}
