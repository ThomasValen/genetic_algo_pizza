package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

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
        print_generation(0,gen);
        int nb_gen_max = 15;
        for (int i=1; i<nb_gen_max+1; i++) {
            gen = croisement(gen);
            //gen = mutation(gen);
            print_generation(i,gen);
            //print_bestScoreGen(i,gen);
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
                if(!p.getIngredientsString().contains(liste_ingredients.get(random_ingr).getNom())) {
                    p.addIngredient(liste_ingredients.get(random_ingr));
                    p.addIngredientString(liste_ingredients.get(random_ingr).getNom());
                }
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
                if(!p1.getIngredientsString().contains(list_pizza.get(i).getIngredients().get(e).getNom())) {
                    p1.addIngredient(list_pizza.get(i).getIngredients().get(e));
                    p1.addIngredientString(list_pizza.get(i).getIngredients().get(e).getNom());
                }
            }
            for(int e = 0;e<coupure2;e++){
                if(!p2.getIngredientsString().contains(list_pizza.get(i+1).getIngredients().get(e).getNom())) {
                    p2.addIngredient(list_pizza.get(i + 1).getIngredients().get(e));
                    p2.addIngredientString(list_pizza.get(i + 1).getIngredients().get(e).getNom());
                }
            }
            for(int e =coupure1;e<list_pizza.get(i).getNb_ingr();e++){
                if(!p2.getIngredientsString().contains(list_pizza.get(i).getIngredients().get(e).getNom())) {
                    p2.addIngredient(list_pizza.get(i).getIngredients().get(e));
                    p2.addIngredientString(list_pizza.get(i).getIngredients().get(e).getNom());
                }
            }
            for(int e =coupure2;e<list_pizza.get(i+1).getNb_ingr();e++){
                if(!p1.getIngredientsString().contains(list_pizza.get(i+1).getIngredients().get(e).getNom())) {
                    p1.addIngredient(list_pizza.get(i + 1).getIngredients().get(e));
                    p1.addIngredientString(list_pizza.get(i + 1).getIngredients().get(e).getNom());
                }
            }
            p1.evaluer_score(lf.getListeClients());
            p2.evaluer_score(lf.getListeClients());
            combinaison.add(p1);
            combinaison.add(p2);
        }
        sortPizzasByScore(combinaison);
        //print_generation(-2,combinaison);
        return combinaison;
    }

    public static ArrayList<Pizza> mutation(ArrayList<Pizza> pizzas){
        Random random = new Random();
        ArrayList<Pizza> combinaison = new ArrayList<>();
        for(int i =0;i<200-2;i=i+2){
            Pizza p = new Pizza();
            p.setIngredients(pizzas.get(i).getIngredients());
            p.setIngredientsString(pizzas.get(i).getIngredientsString());
            int randomNumber = random.nextInt(100);

            if (randomNumber >= 0 && randomNumber < 3) {
                //Supprimer un ingrédient
                int randomSupprimer = random.nextInt(pizzas.get(i).getNb_ingr());
                p.getIngredients().remove(randomSupprimer);
                p.getIngredientsString().remove(randomSupprimer);
            } else if (randomNumber >= 3 && randomNumber < 6) {
                //ajouter un ingrédient
                ArrayList<Ingredient> listTemporaire = new ArrayList<>();
                ArrayList<String> listTemporaireString = new ArrayList<>();
                ajouterIngredient(p,listTemporaire,listTemporaireString);
                int randomAjouter = random.nextInt(listTemporaire.size());
                p.addIngredientString(listTemporaireString.get(randomAjouter));
                p.addIngredient(listTemporaire.get(randomAjouter));
            } else if (randomNumber >= 6 && randomNumber < 9) {
                //remplacer un ingrédient
                int randomSupprimer = random.nextInt(pizzas.get(i).getNb_ingr());
                ArrayList<Ingredient> listTemporaire = new ArrayList<>();
                ArrayList<String> listTemporaireString = new ArrayList<>();
                p.getIngredients().remove(randomSupprimer);
                ajouterIngredient(p,listTemporaire,listTemporaireString);
                int randomAjouter = random.nextInt(listTemporaire.size());
                p.addIngredientString(listTemporaireString.get(randomAjouter));
                p.addIngredient(listTemporaire.get(randomAjouter));
            }
            combinaison.add(p);
        }
        sortPizzasByScore(combinaison);
        return combinaison;
    }
    public static void ajouterIngredient(Pizza p, ArrayList<Ingredient> listTemporaire, ArrayList<String> listTemporaireString){
        for (Ingredient ingredient : lf.getListeIngredients()){
            if (!p.getIngredientsString().contains(ingredient.getNom())){
                listTemporaire.add(ingredient);
                listTemporaireString.add(ingredient.getNom());
            }
        }
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

    public static void print_bestScoreGen(int num_gen , ArrayList<Pizza> gen){
        System.out.println("NUMERO GEN : "+num_gen);
        System.out.println("score : "+gen.get(0).getScore()+"\n");
    }

}
