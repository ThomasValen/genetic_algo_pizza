public class Ingredient {
    private int num_ingr;
    private int nb_fois_aime;
    private int nb_fois_pas_aime;

    public Ingredient(int num_ingr) {
        this.num_ingr = num_ingr;
    }

    public int getNum_ingr() {
        return num_ingr;
    }

    public void setNum_ingr(int num_ingr) {
        this.num_ingr = num_ingr;
    }

    public int getNb_fois_aime() {
        return nb_fois_aime;
    }

    public void setNb_fois_aime(int nb_fois_aime) {
        this.nb_fois_aime = nb_fois_aime;
    }

    public int getNb_fois_pas_aime() {
        return nb_fois_pas_aime;
    }

    public void setNb_fois_pas_aime(int nb_fois_pas_aime) {
        this.nb_fois_pas_aime = nb_fois_pas_aime;
    }
}
