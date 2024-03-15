package Schedulatore;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		String [] materie = new String[]{"italiano","inglese","matematica","scienze e geografia","fisica","chimica","diritto","TI","sta","TTRG","ed. fisica","religione","tutor"};
		int [] orario = new int[]{6,3,4,3,2,2,2,2,1,2,1,1,1};
		String [] professori = new String[]{"italiano","inglese","matematica","scienze e geografia","fisica","chimica","diritto","TI","sta","TTRG","ed. fisica","religione","tutor"};
		int [][] scansioniOrarie = new int[materie.length][5];
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
		int [][] scansioniOrarie2 = copyMatrix(scansioniOrarie);
		Classe classe = new Classe("1M", materie, professori, orario, scansioniOrarie.clone());
		Classe classe2 = new Classe("1N", materie, professori, orario, scansioniOrarie2 );
		//System.out.println(classe.getMaterie());
		
		//for per mettere all'interno dell'orario le materie
		String[][] orarioSettimanale1M = newOrario(classe); 
		
		System.out.println("orario creato");
		
		orarioSettimanale1M = mescolaOrario(orarioSettimanale1M);
		
		String[][] orarioSettimanale1N = newOrario(classe2, orarioSettimanale1M);

		/*for(int i=0; i<6; i++) {
			for(int j=0; j<5; j++) {
				System.out.print("|" + orarioSettimanale1M[j][i]);
				for(int k=0; k<20-orarioSettimanale1M[j][i].length(); k++) {
					System.out.print(" ");
				}
			}
			System.out.println("|");
		}
		
		for(int i=0; i<6; i++) {
			for(int j=0; j<5; j++) {
				System.out.print("|" + orarioSettimanale1N[j][i]);
				for(int k=0; k<20-orarioSettimanale1N[j][i].length(); k++) {
					System.out.print(" ");
				}
			}
			System.out.println("|");
		}

		for(int i=0; i<6; i++){
			for(int j=0; j<5; j++){
				if(orarioSettimanale1M[j][i] == orarioSettimanale1N[j][i]) {
					System.out.println("errore");
				}
			}
		}*/

		//scrivere l'output degli orari su un unico file html con un orario sopra l'altro e con un colore diverso per ogni classe

		try {
			FileWriter writer = new FileWriter("orari.html");
			
			writer.write("<html>\n");
			writer.write("<head>\n");
			writer.write("<style>\n");
			writer.write(".italiano {background-color: #FF0000;}\n");
			writer.write(".inglese {background-color: #00FF00;}\n");
			writer.write(".matematica {background-color: #8084f8;}\n");
			writer.write(".scienze {background-color: #FFFF00;}\n");
			writer.write(".fisica {background-color: #00FFFF;}\n");
			writer.write(".chimica {background-color: #FF00FF;}\n");
			writer.write(".diritto {background-color: #FF8000;}\n");
			writer.write(".TI {background-color: #FF0080;}\n");
			writer.write(".sta {background-color: #80FF00;}\n");
			writer.write(".TTRG {background-color: #00FF80;}\n");
			writer.write(".edfisica {background-color: #0080FF;}\n");
			writer.write(".religione {background-color: #8000FF;}\n");
			writer.write(".tutor {background-color: #FF8080;}\n");
			writer.write("</style>\n");
			writer.write("</head>\n");
			writer.write("<body>\n");
			
			writer.write("<table>\n");
			writer.write("<tr>\n");
			writer.write("<th>Orario Classe 1M</th>\n");
			
			for (int i = 0; i < 6; i++) {
				writer.write("<tr>\n");
				for (int j = 0; j < 5; j++) {
					writer.write("<td class=\"" + orarioSettimanale1M[j][i] + "\">" + orarioSettimanale1M[j][i] + "</td>\n");
				}
			}
			writer.write("</tr>\n");
			writer.write("<th>Orario Classe 1N</th>\n");
			for (int i = 0; i < 6; i++) {
				writer.write("<tr>\n");
				for (int j = 0; j < 5; j++) {
					writer.write("<td class=\"" + orarioSettimanale1N[j][i] + "\">" + orarioSettimanale1N[j][i] + "</td>\n");
				}
			}
			writer.write("</tr>\n");

			writer.write("</table>\n");
			
			writer.write("</body>\n");
			writer.write("</html>\n");
			
			writer.close();
			
			System.out.println("File orari.html created successfully.");
		} catch (IOException e) {
			System.out.println("An error occurred while writing the file.");
			e.printStackTrace();
		}


			
	}

	static String [][] newOrario(Classe classe){
		String[][] orarioSettimanale = new String [5][6];
		int indiceMateriaAttuale=0;
		for(int i=0; i<5; i++) { //for per girare i giorni
			int j = -1; //variabile per girare le ore all'interno di un giorno
			indiceMateriaAttuale=0;
			while (j<5) {
				for(int k=0; k<classe.materie.get(indiceMateriaAttuale).scansioneOraria.length; k++) {
					//classe.printScansione(scansioniOrarie, materie, orario);
					if(classe.materie.get(indiceMateriaAttuale).scansioneOraria[k] < 6-j && classe.materie.get(indiceMateriaAttuale).scansioneOraria[k] != 0) {
						for(int y=0; y<classe.materie.get(indiceMateriaAttuale).scansioneOraria[k]; y++) {
							j++;
							orarioSettimanale[i][j] = classe.materie.get(indiceMateriaAttuale).nome;
							//System.out.println(classe.materie.get(indiceMateriaAttuale).scansioneOraria[k]);
							//System.out.println("giorno: " + (i+1) + " ora: " + (j+1) + " materia: " + orarioSettimanale[i][j]);
						}
						classe.materie.get(indiceMateriaAttuale).scansioneOraria[k] = 0;
						if(classe.materie.get(indiceMateriaAttuale).oreTerminate()) {
							classe.materie.remove(indiceMateriaAttuale);
						}
						if(indiceMateriaAttuale >= classe.materie.size()-1) {
							indiceMateriaAttuale = 0;
						}else indiceMateriaAttuale++;
						break;
					}else if(classe.materie.get(indiceMateriaAttuale).scansioneOraria[k] != 0) { //se la materia deve avere per esempio 2 ore consecutive ma siamo all'ultima ora si prova con la matereia dopo
						k=0;
						int indiceMateriaDopo = indiceMateriaAttuale+1;
						if(indiceMateriaDopo > classe.materie.size()-1) indiceMateriaDopo = 0;
						Materia materiaDiAppoggio = classe.materie.get(indiceMateriaAttuale);
						//System.out.println("materia non disponibile");
						classe.materie.set(indiceMateriaAttuale, classe.materie.get(indiceMateriaDopo));
						classe.materie.set(indiceMateriaDopo, materiaDiAppoggio);							
					}
				}
			}
		}
		return orarioSettimanale;
	}
	
	static String [][] newOrario(Classe classe, String[][] orarioSettimanaleParallelo){
		String[][] orarioSettimanale = new String [5][6];
		int indiceMateriaAttuale=0;
		for(int i=0; i<5; i++) { //for per girare i giorni
			indiceMateriaAttuale=0;
			int j = -1; //variabile per girare le ore all'interno di un giorno
			while (j<5) {
					if(classe.materie.get(indiceMateriaAttuale).scansioneOraria[0] <  6-j && classe.materie.get(indiceMateriaAttuale).scansioneOraria[0] != 0) {  
						if(classe.materie.get(indiceMateriaAttuale).nome == orarioSettimanaleParallelo[i][j+1]) {
							indiceMateriaAttuale = newIndiceMateria(indiceMateriaAttuale, i, j+1, classe, orarioSettimanale);
						}
						for(int y=0; y<classe.materie.get(indiceMateriaAttuale).scansioneOraria[0]; y++) {
							j++;
							orarioSettimanale[i][j] = classe.materie.get(indiceMateriaAttuale).nome;
							//System.out.println("giorno: " + (i+1) + " ora: " + (j+1) + " materia: " + orarioSettimanale[i][j]);
						}
						classe.materie.get(indiceMateriaAttuale).scansioneOraria[0] = 0;
						//funzione per scalare le scansioni orarie pere uella materia
						for(int z=0; z<classe.materie.get(indiceMateriaAttuale).scansioneOraria.length-1; z++) {
							classe.materie.get(indiceMateriaAttuale).scansioneOraria[z] = classe.materie.get(indiceMateriaAttuale).scansioneOraria[z+1];
							//classe.printScansione();
						}
						classe.materie.get(indiceMateriaAttuale).scansioneOraria[classe.materie.get(indiceMateriaAttuale).scansioneOraria.length-1] = 0;
						if(classe.materie.get(indiceMateriaAttuale).oreTerminate()) {
							classe.materie.remove(indiceMateriaAttuale);
						}
						indiceMateriaAttuale = newIndiceMateria(indiceMateriaAttuale, i, j+1, classe, orarioSettimanale);
						//System.out.println("materia attuale:" + classe.materie.get(indiceMateriaAttuale).nome);
					}
			}
		}
		return orarioSettimanale;
	}

	public static int newIndiceMateria(int indiceMateriaVecchia, int giorno, int ora, Classe classe, String[][] orarioSettimanale) {
		//classe.printScansione();
		if(classe.materie.size() == 0) return 0;
		int indiceMateriaAttuale = 0;
		for(int z=4-giorno; z>=0; z--) {
			boolean materiaTrovata = false;
			boolean[] indiciUtilizzati = new boolean[classe.materie.size()];
			for(int i=0; i<classe.materie.size(); i++) {
				indiciUtilizzati[i] = false;
			}
			if(indiceMateriaVecchia!=classe.materie.size())	indiciUtilizzati[indiceMateriaVecchia] = true;	
			 for(int x=0; x<classe.materie.size(); x++){
				 int materieProvate = 0;
				 while(indiciUtilizzati[indiceMateriaAttuale] == true && materieProvate<classe.materie.size()) {
					 indiceMateriaAttuale = (int) (Math.random() * classe.materie.size());	
					 //System.out.println("materia prova ad entrare: " + classe.materie.get(indiceMateriaAttuale).nome);
					 materieProvate++;
				 }
				 for(int y=0; y<ora; y++){ //se la materia è già presente durante il giorno si salta
					if(classe.materie.get(indiceMateriaAttuale).nome == orarioSettimanale[giorno][y]) {
						indiciUtilizzati[indiceMateriaAttuale] = true;
						System.out.println("materia: " + classe.materie.get(indiceMateriaAttuale).nome);
						break;
					}
				}
				if (indiciUtilizzati[indiceMateriaAttuale] == false) {
					if(classe.materie.get(indiceMateriaAttuale).scansioneOraria[z] != 0) { //se la materia è disponibile durante il giorno si prende
						return indiceMateriaAttuale;
					}else indiciUtilizzati[indiceMateriaAttuale] = true;						
				}
			}
		}
		return 0;
	}

	public static int[][] copyMatrix(int[][] original) { //funzione per copiare una matrice
        int[][] copy = new int[original.length][original[0].length];
        
        for (int i = 0; i < original.length; i++) {
            System.arraycopy(original[i], 0, copy[i], 0, original[i].length);
        }
        
        return copy;
    }
	
	public static String[][] mescolaOrario(String[][] orario){
		for(int i=1; i<5; i++) {
			for(int j=0; j<6; j++) {
				int primaMateria = (int) (Math.random() * 6);
				int secondaMateria = (int) (Math.random() * 6);
				String stringaAppoggio = orario[i][secondaMateria];
				orario[i][secondaMateria] = orario[i][primaMateria];
				orario[i][primaMateria] = stringaAppoggio;
 			}
		}
		return orario;
	}
}
