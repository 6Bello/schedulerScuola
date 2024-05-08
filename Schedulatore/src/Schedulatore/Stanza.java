package Schedulatore;

public class Stanza {
    String materia;
    int piano;
    String numAula;

    public Stanza(String materia, int piano, String numAula){
        this.materia=materia;
        this.piano=piano;
        this.numAula=numAula;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getPiano() {
        return piano;
    }

    public void setPiano(int piano) {
        this.piano = piano;
    }

    public String getNumAula() {
        return numAula;
    }

    public void setNumAula(String numAula) {
        this.numAula = numAula;
    }
    
}
