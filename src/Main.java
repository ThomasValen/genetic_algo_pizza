package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    private static LectureFichier lf = new LectureFichier("");

    public static void main(String[] args) {

        ArrayList<Pizza> last_gen = new_gen();

        int nb_gen_max = 1000;
        for (int i=0; i<nb_gen_max; i++) {

        }

    }
    public static ArrayList<Pizza> new_gen(){
        ArrayList<Ingredient> liste_ingredients = lf.getListeIngredients();
        ArrayList<Pizza> res = new ArrayList<>();
        for(int i =0;i<200;i++){
            int nb_ingr_pizza = (int)(Math.random() * liste_ingredients.size());
            Pizza p = new Pizza();
            for(int j =0;j<nb_ingr_pizza;j++){
                int random_ingr = (int)(Math.random() * liste_ingredients.size());
                p.addIngredient(liste_ingredients.get(random_ingr));
            }
            p.evaluer_score(lf.getListeClients());
            res.add(p);
        }
        sortPizzasByScore(res);
        return res;
    }

    public static ArrayList<Pizza> croisement(ArrayList<Pizza> ancienne, ArrayList<Pizza> nouvelle){
        ArrayList<Pizza> combinaison = new ArrayList<>();
        for(int i =0;i<200;i++){

        }
        return null;
    }

    public static void sortPizzasByScore(ArrayList<Pizza> pizzas) {
        Collections.sort(pizzas, new Comparator<Pizza>() {
            @Override
            public int compare(Pizza pizza1, Pizza pizza2) {
                // Trie par score décroissant
                return Integer.compare(pizza2.getScore(), pizza1.getScore());
            }
        });
    }
}
