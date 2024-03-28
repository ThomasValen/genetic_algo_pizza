package src;

import java.util.ArrayList;

public class Pizza {
    private int score;

    private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();

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

    public Pizza croisement(Pizza p){
        int coupure1 = (int)(Math.random() * getNb_ingr());
        return null;
    }

    public void evaluer_score(ArrayList<Client> clients){

    }

    public int getScore() {
        return score;
    }
}
