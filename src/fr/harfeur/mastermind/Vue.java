package fr.harfeur.mastermind;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Vue extends Frame {
	
	public static int SCALE = 1;
	
	public Vue() {
		
		Modèle modèle = new Modèle();
		
		VueClavier vueClavier = new VueClavier();
		VuePropositions vuePropositions = new VuePropositions();

		LayoutManager layout = new BorderLayout();
		this.setLayout(layout);

		this.add(vueClavier, BorderLayout.SOUTH);
		this.add(vuePropositions, BorderLayout.NORTH);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		modèle.premierAffichage();
		
		this.pack();
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Vue();
	}
}
