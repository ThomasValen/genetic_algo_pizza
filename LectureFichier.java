import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LectureFichier {
    private String nomFichier;
    private int nombreClients;
    private ArrayList<Ingredient> listeIngredients;
    private ArrayList<Client> listeClients;
    public LectureFichier(String nomFichier) {
        this.nomFichier = nomFichier;
        listeIngredients = new ArrayList<>();
        listeClients = new ArrayList<>();
    }

    public void lireFichier(){
        try (BufferedReader br = new BufferedReader(new FileReader("fichiers/"+nomFichier))) {
            String premiereLigne = br.readLine();
            if (premiereLigne != null) {
                nombreClients = Integer.parseInt(premiereLigne.trim());
                System.out.println("La première valeur du fichier est : " + nombreClients);
            }
            String ligne;
            // Lecture des clients
            for (int i = 0; i < nombreClients; i++) {
                // Lecture des ingrédients aimés par le client
                ligne = br.readLine();
                Client client = new Client();
                int nombreIngredientsAimer = Integer.parseInt(ligne.split(" ")[0]);
                String[] ingredientsAimer = ligne.substring(ligne.indexOf(" ") + 1).split(" ");
                for (int j = 0; j < nombreIngredientsAimer; j++) {
                    for (Ingredient ig : listeIngredients){
                        if(ig.getNom().equals(ingredientsAimer[j])){
                            ig.plus1Aimer();
                            client.ajouterIngrendientAimer(ig);
                        } else {
                            Ingredient ingredient = new Ingredient(ingredientsAimer[j]);
                            client.ajouterIngrendientAimer(ingredient);
                        }
                    }
                }

                // Lecture des ingrédients détestés par le client
                ligne = br.readLine();
                int nombreIngredientsDetester = Integer.parseInt(ligne.split(" ")[0]);
                String[] ingredientsDetester = ligne.substring(ligne.indexOf(" ") + 1).split(" ");
                for (int j = 0; j < nombreIngredientsDetester; j++) {
                    for (Ingredient ig : listeIngredients){
                        if(ig.getNom().equals(ingredientsDetester[j])){
                            ig.plus1Aimer();
                            client.ajouterIngrendientAimer(ig);
                        } else {
                            Ingredient ingredient = new Ingredient(ingredientsDetester[j]);
                            client.ajouterIngrendientDetester(ingredient);
                        }
                    }
                }
                listeClients.add(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
