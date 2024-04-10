package Schedulatore;

public class Professore {
        String nome;
        String cognome;
        int nMaterie;
        int nOre;
        int[] scansioneOraria;

        Professore(String nome, String cognome, int nMaterie, int nOre, int[] scansioneOraria){
            this.nome=nome;
            this.cognome=cognome;
            this.nMaterie=nMaterie;
            this.nOre=nOre;
            this.scansioneOraria=scansioneOraria;
        }
        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getCognome() {
            return cognome;
        }

        public void setCognome(String cognome) {
            this.cognome = cognome;
        }

        public int getnMaterie() {
            return nMaterie;
        }

        public void setnMaterie(int nMaterie) {
            this.nMaterie = nMaterie;
        }

        public int getnOre() {
            return nOre;
        }

        public void setnOre(int nOre) {
            this.nOre = nOre;
        }
}
