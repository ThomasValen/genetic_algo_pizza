package src;

public class MainRecuitSimuler {

    public static void main(String[] args) {
        String chemin = "src/fichiers/e_elabore.txt";
        //LectureFichier lf = new LectureFichier(args[0]);
        LectureFichier lf = new LectureFichier(chemin);
        lf.lireFichier();
        RecuitSimuler recuitSimuler = new RecuitSimuler();

    }
}
