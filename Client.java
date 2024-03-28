import java.util.ArrayList;

public class Client {
    public ArrayList<Ingredient> ingredientsAimer;
    public ArrayList<Ingredient> ingredientsDetester;

    public Client(ArrayList<Ingredient> ingredientsAimer, ArrayList<Ingredient> ingredientsDetester) {
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

}
