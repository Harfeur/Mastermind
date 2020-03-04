package fr.harfeur.mastermind;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("serial")
public class VuePropositions extends Canvas implements Observer {
	
	Rangée propositions[];
	
	public VuePropositions() {
		super();
		this.setPreferredSize(new Dimension((int) (Vue.SCALE * (60*Modèle.DIFFICULTE + 24 + Math.ceil(Modèle.DIFFICULTE/2)*28)), Vue.SCALE * (60*Modèle.N_TENTATIVES + 10)));
		this.propositions = new Rangée[Modèle.N_TENTATIVES];
//		this.propositions[0] = new Rangée();
//		this.propositions[0].ajouter(Color.YELLOW);
//		this.propositions[0].ajouter(Color.BLUE);
//		this.propositions[0].ajouter(Color.GREEN);
//		this.propositions[0].ajouter(Color.RED);
//		this.propositions[0].noirs = 2;
//		this.propositions[0].blancs = 1;
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, (int) (Vue.SCALE * (60*Modèle.DIFFICULTE + 24 + Math.ceil(Modèle.DIFFICULTE/2)*28)), Vue.SCALE * (60*Modèle.N_TENTATIVES + 10));
		int x = 10*Vue.SCALE;
		int y = 10*Vue.SCALE;
		g.setColor(Color.BLACK);
		
		for (int i = 0; i < Modèle.N_TENTATIVES; ++i) {
			
			Rangée rangée = this.propositions[i];
			x = 10*Vue.SCALE;
			
			for (int j = 0; j < Modèle.DIFFICULTE; ++j) {
				if (rangée != null && rangée.jetons[j] != null) {
					g.setColor(rangée.jetons[j]);
					g.fillOval(x, y, 50*Vue.SCALE, 50*Vue.SCALE);
				}
				g.setColor(Color.BLACK);
				g.drawOval(x, y, 50*Vue.SCALE, 50*Vue.SCALE);
				x += 60*Vue.SCALE;
			}
			
			x += 10*Vue.SCALE;
			int cpt = 0;
			
			for (int i0 = 0; i0 < Math.ceil(Modèle.DIFFICULTE/2); i0++) {
				for (int j0 = 0; j0 < 2; j0++) {
					if (cpt >= Modèle.DIFFICULTE) break;
					if (rangée != null && rangée.noirs - cpt > 0) {
						g.setColor(Color.BLACK);
						g.fillOval(x, y, 22*Vue.SCALE, 22*Vue.SCALE);
					} else if (rangée != null &&rangée.blancs + rangée.noirs - cpt > 0) {
						g.setColor(Color.WHITE);
						g.fillOval(x, y, 22*Vue.SCALE, 22*Vue.SCALE);
					}
					g.setColor(Color.BLACK);
					g.drawOval(x, y, 22*Vue.SCALE, 22*Vue.SCALE);
					y += 28*Vue.SCALE;
					cpt++;
				}
				y -= 56*Vue.SCALE;
				x += 28*Vue.SCALE;
			}
			
			y += 60*Vue.SCALE;
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		this.propositions = (Rangée[]) arg;
		this.repaint();
	}
}
