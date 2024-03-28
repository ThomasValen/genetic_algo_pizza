public class Ingredient {
    private String num_ingr;
    private int nb_fois_aime;
    private int nb_fois_pas_aime;

    public Ingredient(String num_ingr) {
        this.num_ingr = num_ingr;
    }

    public String getNum_ingr() {
        return num_ingr;
    }

    public void setNum_ingr(String num_ingr) {
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
