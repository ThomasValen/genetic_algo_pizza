package src;

public class Ingredient {
    private String nom;
    private int nb_fois_aime;
    private int nb_fois_pas_aime;

    public Ingredient(String nom) {
        this.nom = nom;
        this.nb_fois_aime = 0;
        this.nb_fois_pas_aime = 0 ;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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
    public void plus1Aimer(){
        this.nb_fois_aime++;
    }
    public void plus1Detester(){
        this.nb_fois_pas_aime++;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "nom='" + nom + '\'' +
                ", nb_fois_aime=" + nb_fois_aime +
                ", nb_fois_pas_aime=" + nb_fois_pas_aime +
                '}';
    }
}
