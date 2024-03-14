package Schedulatore;

import java.util.ArrayList;

public class Classe {
	String nomeClasse;
	ArrayList<Materia> materie = new ArrayList<Materia>();
	
	Classe(String nomeClasse,String[] nomeMaterie, String[] professori, int[] oreSettimanaliPerMateria, int[][] scansioniOrarie) {
		this.nomeClasse = nomeClasse;
		for(int i=0; i<nomeMaterie.length; i++) {
			setMateria(i, nomeMaterie[i], professori[i], oreSettimanaliPerMateria[i], scansioniOrarie[i]);
		}
	}
	
	void setMateria(int indice, String nome, String professore, int ore, int[] scansioneOraria) {
		//System.out.println(indice + ";" + nome + ";" + professore + ";" + ore + scansioneOraria.toString());
		materie.add(new Materia(nome, professore, ore, scansioneOraria));
	}
	
	String getMaterie() {
		String stringa ="";
		for(int i=0; i<materie.size(); i++) {
			stringa = stringa.concat(materie.get(i).getNome() + " : " + materie.get(i).getProfessore() + "\n"); 
		}
		return stringa;
	}
	
	void printScansione() {
		for(int i=0; i<materie.size(); i++) { //stampa la scnasione oraria
			System.out.println(materie.get(i).nome);
			for(int j=0; j<5; j++) {
				System.out.print(materie.get(i).scansioneOraria[j]);
			}
			System.out.println();
		}
	}
}
