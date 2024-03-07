package Schedulatore;

public class Orario {
	String orario[][] = new String[5][6];
	
	void setOra(String materia,int giorno, int ora) {
		orario[giorno][ora] = materia;
	}
	String[][] getOrario() {
		return orario;
	}
	void printOrario(){
		for(int i=0; i<5; i++) {
			for(int j=0; j<6; j++) {
				System.out.println(orario[i][j] + "|");
			}
			System.out.println("\n");
		}	
	}
}
