package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

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


    public void lireFichier() {
        try (BufferedReader br = new BufferedReader(new FileReader(nomFichier))) {
            String ligne;
            // Lecture du nombre de clients
            ligne = br.readLine();
            if (ligne != null) {
                nombreClients = Integer.parseInt(ligne.trim());
                System.out.println("Nombre de clients : " + nombreClients);
            }
            // Lecture des clients
            for (int i = 0; i < nombreClients; i++) {
                // Lecture des ingrédients aimés par le client
                ligne = br.readLine();
                Client client = new Client();
                int nombreIngredientsAimer = Integer.parseInt(ligne.split(" ")[0]);
                String[] ingredientsAimer = ligne.substring(ligne.indexOf(" ") + 1).split(" ");
                for (int j = 0; j < nombreIngredientsAimer; j++) {
                    Iterator<Ingredient> iterator = listeIngredients.iterator();
                    boolean ingredientExiste = false;
                    while (iterator.hasNext()) {
                        Ingredient ig = iterator.next();
                        if (ig.getNom().equals(ingredientsAimer[j])) {
                            ig.plus1Aimer();
                            client.ajouterIngrendientAimer(ig);
                            ingredientExiste = true;
                            break;
                        }
                    }
                    if (!ingredientExiste) {
                        Ingredient ingredient = new Ingredient(ingredientsAimer[j]);
                        ingredient.plus1Aimer();
                        listeIngredients.add(ingredient);
                        client.ajouterIngrendientAimer(ingredient);
                    }
                }

                // Lecture des ingrédients détestés par le client
                ligne = br.readLine();
                int nombreIngredientsDetester = Integer.parseInt(ligne.split(" ")[0]);
                String[] ingredientsDetester = ligne.substring(ligne.indexOf(" ") + 1).split(" ");
                for (int j = 0; j < nombreIngredientsDetester; j++) {
                    Iterator<Ingredient> iterator = listeIngredients.iterator();
                    boolean ingredientExiste = false;
                    while (iterator.hasNext()) {
                        Ingredient ig = iterator.next();
                        if (ig.getNom().equals(ingredientsDetester[j])) {
                            ig.plus1Detester();
                            client.ajouterIngrendientDetester(ig);
                            ingredientExiste = true;
                            break;
                        }
                    }
                    if (!ingredientExiste) {
                        Ingredient ingredient = new Ingredient(ingredientsDetester[j]);
                        ingredient.plus1Detester();
                        listeIngredients.add(ingredient);
                        client.ajouterIngrendientDetester(ingredient);
                    }
                }
                listeClients.add(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Ingredient> getListeIngredients() {
        return listeIngredients;
    }

    public String getNomFichier() {
        return nomFichier;
    }

    public int getNombreClients() {
        return nombreClients;
    }

    public ArrayList<Client> getListeClients() {
        return listeClients;
    }

    @Override
    public String toString() {
        return "LectureFichier{" +
                "nomFichier='" + nomFichier + '\'' +
                ", nombreClients=" + nombreClients +
                ", listeIngredients=" + listeIngredients +
                //", listeClients=" + listeClients +
                '}';
    }
}
