package fr.harfeur.mastermind;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Panel;

public class VueClavier extends Panel {
	
	public VueClavier() {
		super();
		for (int i = 0; i < Modèle.COULEURS.length; i++) {
			Button b = new Button();
			b.setPreferredSize(new Dimension(50*Vue.SCALE, 50*Vue.SCALE));
			b.setBackground(Modèle.COULEURS[i]);
			this.add(b);
		}
		
	}
	
}
