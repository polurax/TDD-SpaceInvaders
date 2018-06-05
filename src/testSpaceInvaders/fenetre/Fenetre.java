package fenetre;

import java.awt.Dimension;
import javax.swing.JFrame;
import model.Constante;
import model.SpaceInvaders;
import model.Vaisseau;

public class Fenetre extends JFrame{
	private Controleur listener;
	private ContenuFenetre contenu;
	
	public Fenetre(SpaceInvaders spaceInvaders){
		this.setSize(new Dimension(Constante.ESPACEJEU_LARGEUR+15,Constante.ESPACEJEU_HAUTEUR));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Space Invaders");
		this.contenu=new ContenuFenetre(spaceInvaders);
		this.setContentPane(this.contenu);
		this.listener=new Controleur();
		this.addKeyListener(this.listener);
		this.setVisible(true);
	}

	public Controleur getListener() {
		return listener;
	}

	public ContenuFenetre getContenu() {
		return contenu;
	}

}
