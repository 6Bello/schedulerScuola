package Schedulatore;

import java.util.ArrayList;

public class Classe {
	String nomeClasse;
	ArrayList<Materia> materie = new ArrayList<Materia>();
	ArrayList<Professore> professori = new ArrayList<Professore>();
	
	Classe(String nomeClasse, String[] nomeMaterie, String[] nomeProfessori, int[] oreSettimanaliPerMateria, int[][] scansioniOrarie, String[] cognomeProfessori, int[] oreSettimanaliPerProfessore) {
		this.nomeClasse = nomeClasse;
		for(int i=0; i<nomeMaterie.length; i++) {
			setProfessore(i, nomeProfessori[i], cognomeProfessori[i], i, oreSettimanaliPerProfessore[i], scansioniOrarie[i]);
		}

		for(int i=0; i<nomeProfessori.length; i++) {
			setMateria(i, nomeMaterie[i], nomeProfessori[i], oreSettimanaliPerMateria[i], scansioniOrarie[i]);
		}
	}

	void setProfessore(int indice, String nome, String cognome, int nMaterie, int nOre, int[] scansioneOraria){
		professori.add(new Professore(nome, cognome, nMaterie, nOre, scansioneOraria));
	}
	
	void setMateria(int indice, String nome, String professore, int ore, int[] scansioneOraria) {
		//System.out.println(indice + ";" + nome + ";" + professore + ";" + ore + scansioneOraria.toString());
		materie.add(new Materia(nome, professore, ore, scansioneOraria));
	}
	

	String getProfessori() {
		String stringa ="";
		for(int i=0; i<professori.size(); i++) {
			stringa = stringa.concat(professori.get(i).getNome() + " : " + materie.get(i).getNome() + "\n");
		}
		return stringa;
	}

	String getMaterie() {
		String stringa ="";
		for(int i=0; i<materie.size(); i++) {
			stringa = stringa.concat(materie.get(i).getNome() + " : " + professori.get(i).getNome() + "\n"); 
		}
		return stringa;
	}
	
	void printScansione() {
		for(int i=0; i<materie.size(); i++) { //stampa la scansione oraria
			System.out.println(materie.get(i).nome);
			for(int j=0; j<5; j++) {
				System.out.print(materie.get(i).scansioneOraria[j]);
			}
			System.out.println();
		}
	}
}
