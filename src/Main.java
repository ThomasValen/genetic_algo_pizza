package src;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Main {
    private static LectureFichier lf ;

    public static void main(String[] args) {
        lf = new LectureFichier(args[0]);
        lf.lireFichier();
        System.out.println(lf);
        ArrayList<Pizza> gen = new_gen();
        System.out.println("INIT RANDOM GEN");
        print_generation(0,gen);
        String cheminFichier = "Solution_"+args[0];

        int nb_gen_max = Integer.parseInt(args[1]);
        for (int i=1; i<nb_gen_max+1; i++) {
            gen = croisement(gen);
            gen = mutation(gen);
            print_generation(i,gen);
            print_bestScoreGen(i,gen);
        }
        StringBuilder contenu = new StringBuilder("" + gen.get(0).getIngredients().size());
        for (String ingr : gen.get(0).getIngredientsString()){
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
    public static ArrayList<Pizza> new_gen(){
        ArrayList<Ingredient> liste_ingredients = lf.getListeIngredients();
        ArrayList<Pizza> res = new ArrayList<>();
        for(int i =0;i<100;i++){
            int nb_ingr_pizza = (int)(Math.random() * liste_ingredients.size());
            Pizza p = new Pizza();
            for(int j =0;j<nb_ingr_pizza;j++){
                int random_ingr = (int)(Math.random() * liste_ingredients.size());
                if(!p.getIngredientsString().contains(liste_ingredients.get(random_ingr).getNom())) {
                    p.addIngredient(liste_ingredients.get(random_ingr));
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
        for(int i =0;i<100;i=i+1){
            int coupure1 = (int)(Math.random() * list_pizza.get(0).getNb_ingr());
            int coupure2 = (int)(Math.random() * list_pizza.get(i).getNb_ingr());
            Pizza p1 = new Pizza();
            Pizza p2 = new Pizza();
            for(int e = 0;e<coupure1;e++){
                if(!p1.getIngredientsString().contains(list_pizza.get(0).getIngredients().get(e).getNom())) {
                    p1.addIngredient(list_pizza.get(0).getIngredients().get(e));
                }
            }
            for(int e = 0;e<coupure2;e++){
                if(!p2.getIngredientsString().contains(list_pizza.get(i).getIngredients().get(e).getNom())) {
                    p2.addIngredient(list_pizza.get(i).getIngredients().get(e));
                }
            }
            for(int e =coupure1;e<list_pizza.get(0).getNb_ingr();e++){
                if(!p2.getIngredientsString().contains(list_pizza.get(0).getIngredients().get(e).getNom())) {
                    p2.addIngredient(list_pizza.get(0).getIngredients().get(e));
                }
            }
            for(int e =coupure2;e<list_pizza.get(i).getNb_ingr();e++){
                if(!p1.getIngredientsString().contains(list_pizza.get(i).getIngredients().get(e).getNom())) {
                    p1.addIngredient(list_pizza.get(i).getIngredients().get(e));
                }
            }
            p1.evaluer_score(lf.getListeClients());
            p2.evaluer_score(lf.getListeClients());
            //if(p1.getScore()>list_pizza.get(0).getScore() || p2.getScore()>list_pizza.get(0).getScore())
                if(p1.getScore()>p2.getScore())
                    combinaison.add(p1);
                else
                    combinaison.add(p2);
            //else
                //combinaison.add(list_pizza.get(0));
        }
        sortPizzasByScore(combinaison);
        return combinaison;
    }

    public static ArrayList<Pizza> mutation(ArrayList<Pizza> pizzas){
        Random random = new Random();
        ArrayList<Pizza> combinaison = new ArrayList<>();
        for(int i =0;i<100;i++){
            Pizza p = new Pizza();
            p.setIngredients(pizzas.get(i).getIngredients());
            p.setIngredientsString(pizzas.get(i).getIngredientsString());
            int randomNumber = random.nextInt(100);

            if (randomNumber >= 0 && randomNumber < 3) {
                //Supprimer un ingrédient
                if(pizzas.get(i).getNb_ingr()!=0) {
                    int randomSupprimer = random.nextInt(pizzas.get(i).getNb_ingr());
                    p.removeIngredient(randomSupprimer);
                }
            } else if (randomNumber >= 3 && randomNumber < 6) {
                //ajouter un ingrédient
                ArrayList<Ingredient> listTemporaire = new ArrayList<>();
                ArrayList<String> listTemporaireString = new ArrayList<>();
                ajouterIngredient(p,listTemporaire,listTemporaireString);
                if(!listTemporaire.isEmpty()) {
                    int randomAjouter = random.nextInt(listTemporaire.size());
                    p.addIngredient(listTemporaire.get(randomAjouter));
                }
            } else if (randomNumber >= 6 && randomNumber < 9) {
                //remplacer un ingrédient
                if (pizzas.get(i).getNb_ingr() != 0) {
                    int randomSupprimer = random.nextInt(pizzas.get(i).getNb_ingr());
                    ArrayList<Ingredient> listTemporaire = new ArrayList<>();
                    ArrayList<String> listTemporaireString = new ArrayList<>();
                    p.removeIngredient(randomSupprimer);
                    ajouterIngredient(p, listTemporaire, listTemporaireString);
                    int randomAjouter = random.nextInt(listTemporaire.size());
                    p.addIngredient(listTemporaire.get(randomAjouter));
                }
            }
            p.evaluer_score(lf.getListeClients());
            if (p.getScore()>pizzas.get(i).getScore())
                combinaison.add(p);
            else
                combinaison.add(pizzas.get(i));
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
            System.out.println("score : "+gen.get(i).getScore()+ "   nombre d'ingrédients : "+gen.get(i).getIngredients().size());
        }
        System.out.println();
    }

    public static void print_bestScoreGen(int num_gen , ArrayList<Pizza> gen){
        System.out.println("NUMERO GEN : "+num_gen);
        System.out.println("score : "+gen.get(0).getScore()+"\n");
    }

}
