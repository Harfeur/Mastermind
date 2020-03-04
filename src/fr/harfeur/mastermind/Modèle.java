package fr.harfeur.mastermind;

import java.awt.Color;
import java.util.Random;
import java.util.Observable;

public class Modèle extends Observable {
	
	public static Color COULEURS[] = {Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA, Color.RED, Color.ORANGE, Color.WHITE, Color.BLACK};
	public static int N_TENTATIVES = 15;
	public static int DIFFICULTE = 7;
	enum Etat {EN_COURS, GAGNE, PERDU};
	Etat etat;
	Rangée combinaison;
	Rangée propositions[];
	int tentative;
	
	public Modèle() {
		super();
		this.propositions = new Rangée[Modèle.N_TENTATIVES];
		this.tentative = -1;
		this.nouvelleProposition();
		this.etat = Etat.EN_COURS;
		
		this.combinaison = new Rangée();
		Random r = new Random();
		for (int i = 0; i < Modèle.DIFFICULTE; i++) {
			this.combinaison.ajouter(Modèle.COULEURS[r.nextInt(Modèle.COULEURS.length)]);
		}
		System.out.println(this.combinaison);
	}
	
	public void nouvelleProposition() {
		this.tentative++;
		if (this.tentative >= Modèle.N_TENTATIVES) {
			this.etat = Etat.PERDU;
		}
		else {
			this.propositions[this.tentative] = new Rangée();
		}
	}
	
	public void ajoutCouleur(Color c) {
		if (this.etat != Etat.EN_COURS) return;
		this.propositions[this.tentative].ajouter(c);
		if (this.propositions[this.tentative].indiceJeton == Modèle.DIFFICULTE)
			this.valider();
		this.setChanged();
		this.notifyObservers(this.propositions);
	}
	
	public void valider() {
		boolean correct = this.propositions[this.tentative].vérifier(this.combinaison);
		if (correct)
			this.etat = Etat.GAGNE;
		else
			nouvelleProposition();
	}
}
