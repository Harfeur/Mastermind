package fr.harfeur.mastermind;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Contrôleur implements ActionListener{
	
	Modèle modèle;

	public Contrôleur(Modèle modèle) {
		super();
		this.modèle = modèle;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Button b = (Button) e.getSource();
		modèle.ajoutCouleur(b.getBackground());
	}

}
