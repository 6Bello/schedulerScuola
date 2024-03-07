package Schedulatore;

public class Main {

	public static void main(String[] args) {
		String [] materie = new String[]{"italiano","inglese","matematica","scienze e geografia","fisica","chimica","diritto","TI","sta","TTRG","ed. fisica","religione","tutor"};
		int [] orario= new int[]{5,3,4,3,3,3,2,3,0,3,2,1,1};
		String [] professori = new String[]{"italiano","inglese","matematica","scienze e geografia","fisica","chimica","diritto","TI","sta","TTRG","ed. fisica","religione","tutor"};
		int [][] scansioniOrarie = new int[materie.length][5];
		for(int i=0; i<materie.length; i++) {
			for(int j=0; j<orario[i]; j++) {
				if(j>4) {
					j%=5;
					scansioniOrarie[i][j]++;
				}else {
					scansioniOrarie[i][j] = 1;					
				}
			}
		}
		Classe classe = new Classe("1M", materie, professori, orario, scansioniOrarie);
		System.out.println(classe.getMaterie());
	}

}
