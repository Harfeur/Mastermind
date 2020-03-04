package fr.harfeur.mastermind;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Panel;

@SuppressWarnings("serial")
public class VueClavier extends Panel {
	
	public VueClavier(Contrôleur c) {
		super();
		int taille = (int) (Vue.SCALE*(60 * Modèle.DIFFICULTE + 28 * Math.ceil(Modèle.DIFFICULTE/2)));
		for (int i = 0; i < Modèle.COULEURS.length; i++) {
			Button b = new Button();
			b.setName(Modèle.COULEURS[i].toString());
			b.setPreferredSize(new Dimension(taille/Modèle.COULEURS.length, taille/Modèle.COULEURS.length));
			b.setBackground(Modèle.COULEURS[i]);
			b.addActionListener(c);
			this.add(b);
		}
		
	}
	
}
