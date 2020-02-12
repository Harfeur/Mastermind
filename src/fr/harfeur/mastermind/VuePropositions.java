package fr.harfeur.mastermind;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

public class VuePropositions extends Canvas implements Observer {
	
	Rangée propositions[];
	
	public VuePropositions() {
		super();
		this.setPreferredSize(new Dimension(Modèle.DIFFICULTE*(50+5)*Vue.SCALE, Modèle.N_TENTATIVES*(50+5)*Vue.SCALE));
	}
	
	@Override
	public void paint(Graphics g) {
		int x = 10*Vue.SCALE;
		int y = 10*Vue.SCALE;
		for (Rangée rangée : propositions) {
			y += 60*Vue.SCALE;
			for (Color c : rangée.jetons) {
				x += 60*Vue.SCALE;
				if (c == null) {
					g.setColor(Color.BLACK);
					g.drawOval(x, y, 50*Vue.SCALE, 50*Vue.SCALE);
				}
			}
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		this.propositions = (Rangée[]) arg;
		this.repaint();
	}
}
