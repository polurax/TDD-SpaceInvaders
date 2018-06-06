package spaceInvaders;

import model.Constante;
import model.Dimension;
import model.Direction;
import model.SpaceInvaders;
import moteurJeu.Controleur;
import moteurJeu.Fenetre;

public class Main {

	public static void main(String[] args) {
		
		SpaceInvaders spaceInvaders = new SpaceInvaders(Constante.ESPACEJEU_LARGEUR,Constante.ESPACEJEU_HAUTEUR);
		spaceInvaders.initialiserJeu();
		
		Fenetre fenetre=new Fenetre(spaceInvaders);
		while(!spaceInvaders.etreFini()) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(fenetre.getListener().getCommande().droite) {
				spaceInvaders.deplacerVaisseauVersLaDroite();
			}
			if(fenetre.getListener().getCommande().gauche) {
				spaceInvaders.deplacerVaisseauVersLaGauche();
			}
			if(fenetre.getListener().getCommande().space && !spaceInvaders.aUnMissile()) {
				spaceInvaders.tirerUnMissile(new Dimension(Constante.MISSILE_LARGEUR, Constante.MISSILE_HAUTEUR), Constante.MISSILE_VITESSE);
			}
			if(spaceInvaders.aUnMissile()) {
				spaceInvaders.deplacerMissile();
			}
			if(spaceInvaders.getEnvahisseur()!=null) {
				spaceInvaders.deplacerEnvahisseur();
			}
			fenetre.getContenu().repaint();
		}
		fenetre.getContenu().repaint();
	}
}
