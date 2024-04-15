package src;

public class Mouvement {
    private String action;
    private Ingredient ingredient;

    public Mouvement() {
    }

    public Mouvement(String action, Ingredient ingredient) {
        this.action = action;
        this.ingredient = ingredient;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public String toString() {
        return "Mouvement{" +
                "action='" + action + '\'' +
                ", ingredient=" + ingredient +
                '}';
    }
}
