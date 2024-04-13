package src;

import java.util.ArrayList;

public class Pizza {
    private int score;

    private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
    private ArrayList<String> ingredientsString = new ArrayList<String>();

    public Pizza() {

    }
    public void removeIngredient(int pos){
        ingredientsString.remove(pos);
        ingredients.remove(pos);
    }
    public int getNb_ingr(){
        return this.ingredients.size();
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void addIngredient(Ingredient i){
        this.ingredients.add(i);
        this.ingredientsString.add(i.getNom());
    }


    public void evaluer_score(ArrayList<Client> clients){
        this.score = 0;
        for (Client client : clients){
            boolean nextClient = false;
            for (String ingredient : ingredientsString) {
                if (client.getIngredientsDetesterString().contains(ingredient)){
                    nextClient = true;
                    break;
                }
            }
            if(!nextClient) {
                int compteur = 0;
                for (String ingredient : client.getIngredientsAimerString()) {
                    if (ingredientsString.contains(ingredient)) {
                        compteur++;
                    }
                }
                if (compteur >= client.getIngredientsAimerString().size())
                    score++;
            }
        }
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Pizza{" + ingredientsString + '}';
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public ArrayList<String> getIngredientsString() {
        return ingredientsString;
    }

    public void setIngredientsString(ArrayList<String> ingredientsString) {
        this.ingredientsString = ingredientsString;
    }
}
