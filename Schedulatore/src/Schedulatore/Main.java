package Schedulatore;

public class Main {

	public static void main(String[] args) {
		String [] materie = new String[]{"italiano","inglese","matematica","scienze e geografia","fisica","chimica","diritto","TI","sta","TTRG","ed. fisica","religione","tutor"};
		int [] orario = new int[]{6,3,4,3,2,2,2,2,1,2,1,1,1};
		String [] professori = new String[]{"italiano","inglese","matematica","scienze e geografia","fisica","chimica","diritto","TI","sta","TTRG","ed. fisica","religione","tutor"};
		int [][] scansioniOrarie = new int[materie.length][5];
		Classe classe = new Classe("1M", materie, professori, orario, scansioniOrarie);
		System.out.println(classe.getMaterie());
		//questo for serve a mettere nella scansione oraria di ogni materia il numero di ore per ogni volta che sarà nella classe es:
		//it:  2|1|1|1|1|
		//mat: 1|1|1|1|
		for(int i=0; i<materie.length; i++) {
			for(int j=0; j<orario[i]; j++) {
				if(j>4) {
					scansioniOrarie[i][j%5]++;
				}else {
					scansioniOrarie[i][j] = 1;					
				}
			}
		}
		classe.printScansione(scansioniOrarie, materie, orario);
		
		
		
		//for per mettere all'interno dell'orario le materie
		String[][] orarioSettimanale = new String [5][6];
		int indiceMateriaAttuale=0;
		for(int i=0; i<5; i++) { //for per girare i giorni
			for(int j=-1; j<5; j=j) { //variabile per girare le ore all'interno di un giorno
			//System.out.println("cambio ora");
				for(int k=0; k<classe.materie.get(indiceMateriaAttuale).scansioneOraria.length; k++) {
					//classe.printScansione(scansioniOrarie, materie, orario);
					if(classe.materie.get(indiceMateriaAttuale).scansioneOraria[k] < 6-j && classe.materie.get(indiceMateriaAttuale).scansioneOraria[k] != 0) {
						for(int y=0; y<classe.materie.get(indiceMateriaAttuale).scansioneOraria[k]; y++) {
							j++;
							orarioSettimanale[i][j] = classe.materie.get(indiceMateriaAttuale).nome;
							//System.out.println(classe.materie.get(indiceMateriaAttuale).scansioneOraria[k]);
							System.out.println("giorno: " + (i+1) + " ora: " + (j+1) + " materia: " + orarioSettimanale[i][j]);
						}
						classe.materie.get(indiceMateriaAttuale).scansioneOraria[k] = 0;
						if(classe.materie.get(indiceMateriaAttuale).oreTerminate()) {
							classe.materie.remove(indiceMateriaAttuale);
						}
						if(indiceMateriaAttuale >= classe.materie.size()-1) {
							System.out.println("ritorno prima materia");
							indiceMateriaAttuale = 0;
						}else indiceMateriaAttuale++;
						classe.printScansione(scansioniOrarie, materie, orario);
						break;
					}else if(classe.materie.get(indiceMateriaAttuale).scansioneOraria[k] != 0) { //se la materia deve avere per esempio 2 ore consecutive ma siamo all'ultima ora si prova con la matereia dopo
						k=0;
						int indiceMateriaDopo = indiceMateriaAttuale+1;
						if(indiceMateriaDopo > classe.materie.size()-1) indiceMateriaDopo = 0;
						Materia materiaDiAppoggio = classe.materie.get(indiceMateriaAttuale);
						System.out.println("materia non disponibile");
						classe.materie.set(indiceMateriaAttuale, classe.materie.get(indiceMateriaDopo));
						classe.materie.set(indiceMateriaDopo, materiaDiAppoggio);							
					}
				}
			}
		}

		for(int i=0; i<6; i++) {
			for(int j=0; j<5; j++) {
				System.out.print("|" + orarioSettimanale[j][i] + "|");
			}
			System.out.println("");
		}
	}

}
