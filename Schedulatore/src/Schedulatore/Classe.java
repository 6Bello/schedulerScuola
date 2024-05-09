package Schedulatore;

import java.util.ArrayList;

public class Classe {
	String nomeClasse;
	ArrayList<Materia> materie = new ArrayList<Materia>();
	ArrayList<String> cfProfessori = new ArrayList<String>();
	
	Classe(String nomeClasse, String[] nomeMaterie, int[] oreSettimanaliPerMateria, int[][] scansioniOrarie, String[] cfProfessori, int[] oreSettimanaliPerProfessore) {
		this.nomeClasse = nomeClasse;
		/*for(int i=0; i<nomeMaterie.length; i++) {
			setProfessore(i, nomecfProfessori[i], cognomecfProfessori[i], i, oreSettimanaliPerProfessore[i], scansioniOrarie[i]);
		}*/

		for(int i=0; i<cfProfessori.length; i++) {
			setMateria(i, nomeMaterie[i], cfProfessori[i], oreSettimanaliPerMateria[i], scansioniOrarie[i]);
		}
	}

	/*void setProfessore(int indice, String nome, String cognome, int nMaterie, int nOre, int[] scansioneOraria, String cf){
		cfProfessori.add(new Professore(nome, cognome, nMaterie, nOre, scansioneOraria, cf));
	}*/
	
	void setMateria(int indice, String nome, String professore, int ore, int[] scansioneOraria) {
		//System.out.println(indice + ";" + nome + ";" + professore + ";" + ore + scansioneOraria.toString());
		materie.add(new Materia(nome, professore, ore, scansioneOraria));
	}
	

	String getcfProfessori() {
		String stringa ="";
		for(int i=0; i<cfProfessori.size(); i++) {
			stringa = stringa.concat(cfProfessori.get(i));
		}
		return stringa;
	}

	String getMaterie() {
		String stringa ="";
		for(int i=0; i<materie.size(); i++) {
			stringa = stringa.concat(materie.get(i).getNome() + " : " + cfProfessori.get(i) + "\n"); 
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
