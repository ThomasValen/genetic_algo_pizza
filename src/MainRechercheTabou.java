package src;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MainRechercheTabou {

    public static void main(String[] args) {
        //PRENONS N = 1
        String cheminA = "src/fichiers/a_exemple.txt";
        String cheminB = "src/fichiers/b_basique.txt";
        String cheminC = "src/fichiers/c_grossier.txt";
        String cheminD = "src/fichiers/d_difficile.txt";
        String cheminE = "src/fichiers/e_elabore.txt";
        String ecrire = "src/fichiers/soluce_e_elabore.txt";
        LectureFichier lf = new LectureFichier(args[0]);
        String cheminFichier = "Solution_"+args[0];
        int nb_gen_max = Integer.parseInt(args[1]);
        //LectureFichier lf = new LectureFichier(cheminE);
        lf.lireFichier();
        RechercheTabou rechercheTabou = new RechercheTabou(lf.getListeIngredients(),lf.getListeClients());
        System.out.println("Debut recherche tabou");
        for (int i = 0; i <= nb_gen_max; ++i){
            rechercheTabou.calculDuMeilleurVoisin();
            System.out.println("Meilleure score au stade " + i + " : " + rechercheTabou.getScoreActuel());
            System.out.println("Meilleure pizza au stade " + i + " : " + rechercheTabou.getPizzaActuel());
        }
        System.out.println(rechercheTabou.compteur);
        System.out.println(rechercheTabou.getListeTabou());
        ecrireFichier(cheminFichier, rechercheTabou);
    }
    public static void ecrireFichier(String cheminFichier, RechercheTabou rechercheTabou){
        StringBuilder contenu = new StringBuilder("" + rechercheTabou.getPizzaActuel().getIngredients().size());
        for (String ingr : rechercheTabou.getPizzaActuel().getIngredientsString()){
            contenu.append(" ").append(ingr);
        }
        try {
            FileWriter writer = new FileWriter(cheminFichier);

            writer.write(contenu.toString());

            writer.close();

            System.out.println("Le texte a été écrit avec succès dans le fichier.");
        } catch (IOException e) {
            System.out.println("Une erreur s'est produite lors de l'écriture dans le fichier : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
