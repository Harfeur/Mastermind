package fr.harfeur.mastermind;

import java.awt.Color;

public class Rangée {
	
	Color jetons[];
	int indiceJeton;
	int noirs, blancs;
	
	public Rangée() {
		super();
		this.jetons = new Color[Modèle.DIFFICULTE];
		this.indiceJeton = 0;
		this.noirs = 0;
		this.blancs = 0;
	}

	public void ajouter(Color color) {
		if (this.indiceJeton >= Modèle.DIFFICULTE) return;
		this.jetons[this.indiceJeton] = color;
		this.indiceJeton++;
	}
	
	public boolean vérifier(Rangée correcte) {
		if (this.indiceJeton != Modèle.DIFFICULTE) return false;
		for (int i = 0; i < this.indiceJeton; i++) {
			if (this.jetons[i].equals(correcte.jetons[i]))
				this.noirs++;
		}
		this.blancs = -this.noirs;
		for (int i = 0; i < Modèle.COULEURS.length; i++) {
			int n = 0;
			int m = 0;
			for (int j = 0; i < this.indiceJeton; j++) {
				if (correcte.jetons[j].equals(Modèle.COULEURS[i])) n++; 
				if (this.jetons[j].equals(Modèle.COULEURS[i])) m++; 
			}
			if (n < m)
				this.blancs += n;
			else
				this.blancs+=m;
		}
		return this.noirs == Modèle.DIFFICULTE;
	}
	
}
