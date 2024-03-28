package src;

import java.util.ArrayList;

public class Pizza {
    private int score;

    private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
    private ArrayList<String> ingredientsString = new ArrayList<String>();

    public Pizza() {

    }

    public int getNb_ingr(){
        return this.ingredients.size();
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void addIngredient(Ingredient i){
        this.ingredients.add(i);
    }
    public void addIngredientString(String i){
        this.ingredientsString.add(i);
    }

    public void evaluer_score(ArrayList<Client> clients){
        for (Client client : clients){
            for (String ingredient : ingredientsString) {
                if (client.getIngredientsDetesterString().contains(ingredient)){
                    break;
                }
            }
            int compteur = 0;
            for (String ingredient : client.getIngredientsAimerString()){
                if (ingredientsString.contains(ingredient)){
                    compteur++;
                }
            }
            if(compteur>= client.getIngredientsAimerString().size())
                score++;
        }
    }

    public int getScore() {
        return score;
    }
}
