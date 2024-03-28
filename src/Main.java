package src;

import java.util.ArrayList;

public class Main {
    private static LectureFichier lf = new LectureFichier("src/fichiers/d_difficile.txt");

    public static void main(String[] args) {
        lf.lireFichier();
        System.out.println(lf);
        /*ArrayList<Pizza> last_gen = new_gen();

        int nb_gen_max = 1000;
        for (int i=0; i<nb_gen_max; i++) {

        }*/

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
            res.add(p);
        }
        return res;
    }


}
