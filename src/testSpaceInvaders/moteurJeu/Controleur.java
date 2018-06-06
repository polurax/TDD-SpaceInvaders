package moteurJeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import model.Vaisseau;

/**
 * classe qui represente un controleur en lien avec un KeyListener
 * 
 * @author vthomas
 * 
 */
public class Controleur implements KeyListener {

	/**
	 * commande en cours
	 */
	private Commande commandeEnCours;
	/**
	 * commande a retourner la difference avec la commandeencours vient du fait
	 * qu'on veut memoriser une touche appuyee
	 */
	private Commande commandeARetourner;

	/**
	 * construction du controleur par defaut le controleur n'a pas de commande
	 */

	public Controleur() {
		this.commandeEnCours = new Commande();
		this.commandeARetourner = new Commande();
	}

	/**
	 * quand on demande les commandes, le controleur retourne la commande en cours
	 * 
	 * @return commande faite par le joueur
	 */
	public Commande getCommande() {
		Commande aRetourner = this.commandeARetourner;
		this.commandeARetourner = new Commande(this.commandeEnCours);
		return (aRetourner);
	}

	/**
	 * met a jour les commandes en fonctions des touches appuyees
	 */
	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {
		// si on appuie sur 'q',commande joueur est gauche
		case 81:
			this.commandeEnCours.gauche = true;
			this.commandeARetourner.gauche = true;
			break;
		// si on appuie sur 'd',commande joueur est droite
		case 68:
			this.commandeEnCours.droite = true;
			this.commandeARetourner.droite = true;
			break;
		// si on appuie sur 'z',commande joueur est haut
		case 90:
			this.commandeEnCours.haut = true;
			this.commandeARetourner.haut = true;
			break;
		// si on appuie sur 's',commande joueur est bas
		case 83:
			this.commandeEnCours.bas = true;
			this.commandeARetourner.bas = true;
			break;
		case 32:
			this.commandeEnCours.space = true;
			this.commandeARetourner.space = true;
			break;
		}
	}

	/**
	 * met a jour les commandes quand le joueur relache une touche
	 */
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case 81:
			this.commandeEnCours.gauche = false;
			break;
		case 68:
			this.commandeEnCours.droite = false;
			break;
		case 90:
			this.commandeEnCours.haut = false;
			break;
		case 83:
			this.commandeEnCours.bas = false;
			break;
		case 32:
			this.commandeEnCours.space = false;
			break;
		}

	}

	/**
	 * ne fait rien
	 */
	public void keyTyped(KeyEvent e) {

	}

}
