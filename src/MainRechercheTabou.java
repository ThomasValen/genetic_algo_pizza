package src;

import java.util.ArrayList;

public class MainRechercheTabou {

    public static void main(String[] args) {
        //PRENONS N = 1
        String chemin = "src/fichiers/a_exemple.txt";
        //LectureFichier lf = new LectureFichier(args[0]);
        LectureFichier lf = new LectureFichier(chemin);
        lf.lireFichier();
        RechercheTabou rechercheTabou = new RechercheTabou();
        System.out.println("Debut recherche tabou");
        ArrayList<Ingredient> listIngredients = lf.getListeIngredients();
        System.out.println(listIngredients);
        for (int i = 0; i< 10; ++i){
            rechercheTabou.calculDuMeilleurVoisin(listIngredients,lf.getListeClients());
            System.out.println("Meilleure score au stade "+ i + " : "+ rechercheTabou.getScoreActuel());
            System.out.println(rechercheTabou.getPizzaActuel());
        }
    }
}
