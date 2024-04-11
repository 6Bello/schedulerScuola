package Schedulatore;

public class MateriaLab extends Materia{
    Stanza[] stanze;

    public MateriaLab(Stanza[] stanze, String nome, String professore, int ore, int[] scansioneOraria){
        super(nome, professore, ore, scansioneOraria);
        this.stanze = stanze;
    }

    public Stanza[] getStanze() {
        return stanze;
    }

    public void setStanze(Stanza[] stanze) {
        this.stanze = stanze;
    }

}
