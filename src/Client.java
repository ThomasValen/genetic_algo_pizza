package src;

import java.util.ArrayList;

public class Client {
    private ArrayList<Ingredient> ingredientsAimer;
    private ArrayList<String> ingredientsAimerString;
    private ArrayList<String> ingredientsDetesterString;
    private ArrayList<Ingredient> ingredientsDetester;

    public Client() {
        this.ingredientsAimer = new ArrayList<>();
        this.ingredientsDetester = new ArrayList<>();
        this.ingredientsDetesterString = new ArrayList<>();
        this.ingredientsAimerString = new ArrayList<>();
    }

    public ArrayList<Ingredient> getIngredientsAimer() {
        return ingredientsAimer;
    }

    public void setIngredientsAimer(ArrayList<Ingredient> ingredientsAimer) {
        this.ingredientsAimer = ingredientsAimer;
    }

    public ArrayList<Ingredient> getIngredientsDetester() {
        return ingredientsDetester;
    }

    public void setIngredientsDetester(ArrayList<Ingredient> ingredientsDetester) {
        this.ingredientsDetester = ingredientsDetester;
    }
    public void ajouterIngrendientAimer(Ingredient ingredient){
        this.ingredientsAimer.add(ingredient);
    }    public void ajouterIngrendientAimerString(String ingredient){
        this.ingredientsAimerString.add(ingredient);
    }
    public void ajouterIngrendientDetester(Ingredient ingredient){
        this.ingredientsDetester.add(ingredient);
    }    public void ajouterIngrendientDetesterString(String ingredient){
        this.ingredientsDetesterString.add(ingredient);
    }

    @Override
    public String toString() {
        return "Client{" +
                "ingredientsAimer=" + ingredientsAimer +
                ", ingredientsDetester=" + ingredientsDetester +
                '}';
    }

    public ArrayList<String> getIngredientsAimerString() {
        return ingredientsAimerString;
    }

    public ArrayList<String> getIngredientsDetesterString() {
        return ingredientsDetesterString;
    }
}
