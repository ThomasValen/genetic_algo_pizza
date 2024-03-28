package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    private static LectureFichier lf = new LectureFichier("src/fichiers/d_difficile.txt");

    public static void main(String[] args) {
        lf.lireFichier();
        System.out.println(lf);
        /*Pizza pizza= new Pizza();
        pizza.addIngredientString("ingredient319");
        pizza.addIngredientString("ingredient79");
        pizza.addIngredientString("ingredient9");
        pizza.evaluer_score(lf.getListeClients());
        System.out.println(pizza.getScore());*/
        ArrayList<Pizza> gen = new_gen();
        System.out.println("INIT RANDOM GEN");
        print_generation(-1,gen);
        int nb_gen_max = 2;
        for (int i=0; i<nb_gen_max; i++) {
            gen = croisement(gen);
            //gen = mutation(gen);
            print_generation(i,gen);
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
                p.addIngredientString(liste_ingredients.get(random_ingr).getNom());
            }
            p.evaluer_score(lf.getListeClients());
            res.add(p);
        }
        sortPizzasByScore(res);
        return res;
    }


    public static ArrayList<Pizza> croisement(ArrayList<Pizza> list_pizza){
        ArrayList<Pizza> combinaison = new ArrayList<>();
        for(int i =0;i<200-2;i=i+2){
            int coupure1 = (int)(Math.random() * list_pizza.get(i).getNb_ingr());
            int coupure2 = (int)(Math.random() * list_pizza.get(i+1).getNb_ingr());
            Pizza p1 = new Pizza();
            Pizza p2 = new Pizza();
            for(int e = 0;e<coupure1;e++){
                p1.addIngredient(list_pizza.get(i).getIngredients().get(e));
            }
            for(int e = 0;e<coupure2;e++){
                p2.addIngredient(list_pizza.get(i+1).getIngredients().get(e));
            }
            for(int e =coupure1;e<list_pizza.get(i).getNb_ingr();e++){
                p2.addIngredient(list_pizza.get(i).getIngredients().get(e));
            }
            for(int e =coupure2;e<list_pizza.get(i+1).getNb_ingr();e++){
                p1.addIngredient(list_pizza.get(i+1).getIngredients().get(e));
            }
            p1.evaluer_score(lf.getListeClients());
            p2.evaluer_score(lf.getListeClients());
            combinaison.add(p1);
            combinaison.add(p2);
        }
        sortPizzasByScore(combinaison);
        print_generation(-2,combinaison);
        return combinaison;
    }

    public static ArrayList<Pizza> mutation(ArrayList<Pizza> pizzas){
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

    public static void print_generation(int num_gen , ArrayList<Pizza> gen){
        System.out.println("NUMERO GEN : "+num_gen+"\n");
        for(int i=0;i<gen.size();i++){
            System.out.println("score : "+gen.get(i).getScore()+ "   ingredients : "+gen.get(i).toString());
        }
        System.out.println("");
    }
}
