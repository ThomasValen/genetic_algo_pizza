package src;

import java.util.ArrayList;

public class MainRechercheTabou {

    public static void main(String[] args) {
        String chemin = "src/fichiers/e_elabore.txt";
        //LectureFichier lf = new LectureFichier(args[0]);
        LectureFichier lf = new LectureFichier(chemin);
        lf.lireFichier();
        RechercheTabou rechercheTabou = new RechercheTabou();
        System.out.println("INIT RANDOM GEN");
    }
}
