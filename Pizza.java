import java.util.ArrayList;

public class Pizza {

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

}
