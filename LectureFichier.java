import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LectureFichier {
    private String nomFichier;
    private int nombreIngredients;
    private ArrayList<Ingredient> listeIngredients;
    public LectureFichier(String nomFichier) {
        this.nomFichier = nomFichier;
        listeIngredients = new ArrayList<>();
    }

    public void lireFichier(){
        try (BufferedReader br = new BufferedReader(new FileReader("fichiers/"+nomFichier))) {
            String premiereLigne = br.readLine();
            if (premiereLigne != null) {
                nombreIngredients = Integer.parseInt(premiereLigne.trim());
                System.out.println("La première valeur du fichier est : " + nombreIngredients);
            }
            String ligne;
            while ((ligne = br.readLine()) != null) {
                System.out.println(ligne);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Ingredient> getListeIngredients() {
        return listeIngredients;
    }
}
