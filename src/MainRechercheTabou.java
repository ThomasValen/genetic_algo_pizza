package src;

import java.util.ArrayList;

public class MainRechercheTabou {

    public static void main(String[] args) {
        //PRENONS N = 1
        String cheminA = "src/fichiers/a_exemple.txt";
        String cheminB = "src/fichiers/b_basique.txt";
        String cheminC = "src/fichiers/c_grossier.txt";
        String cheminD = "src/fichiers/d_difficile.txt";
        //LectureFichier lf = new LectureFichier(args[0]);
        LectureFichier lf = new LectureFichier(cheminD);
        lf.lireFichier();
        RechercheTabou rechercheTabou = new RechercheTabou(lf.getListeIngredients(),lf.getListeClients());
        System.out.println("Debut recherche tabou");
        for (int i = 0; i< 100; ++i){
            rechercheTabou.calculDuMeilleurVoisin();
            System.out.println("Meilleure score au stade " + i + " : " + rechercheTabou.getScoreActuel());
            System.out.println("Meilleure pizza au stade " + i + " : " + rechercheTabou.getPizzaActuel());
        }
        System.out.println(rechercheTabou.compteur);
        System.out.println(rechercheTabou.getListeTabou());
    }
}
