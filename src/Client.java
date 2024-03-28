package src;

import java.util.ArrayList;

public class Client {
    public ArrayList<Ingredient> ingredientsAimer;
    public ArrayList<Ingredient> ingredientsDetester;

    public Client() {
        this.ingredientsAimer = ingredientsAimer;
        this.ingredientsDetester = ingredientsDetester;
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
    }
    public void ajouterIngrendientDetester(Ingredient ingredient){
        this.ingredientsDetester.add(ingredient);
    }
}
