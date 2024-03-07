package Schedulatore;

public class Materia {
	String nome;
	String professore;
	int ore;
	int[] scansioneOraria;
	
	Materia(String nome, String professore, int ore, int[] scansioneOraria) {
		this.nome = nome;
		this.professore = professore;
		this.ore = ore;
		this.scansioneOraria = scansioneOraria;
	}
	
	boolean oreTerminate() {
		boolean oreTerminate = true;
		for(int i=0; i<5; i++) {
			if(scansioneOraria[i]>0) oreTerminate = false;
		}
		return oreTerminate;
	}
	String getNome() {
		return nome;
	}
	String getProfessore() {
		return professore;
	}
	int getOre() {
		return ore;
	}
	int[] getScansioneOraria() {
		return scansioneOraria;
	}	
}
