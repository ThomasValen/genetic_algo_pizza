package src;

import java.util.ArrayList;

public class RechercheTabou {
    private ArrayList<Pizza> listeTabou;
    private Pizza pizzaActuel;
    public RechercheTabou() {
        listeTabou = new ArrayList<>();
        pizzaActuel = new Pizza();
    }
    public void ajouterTabou(Pizza p){
        listeTabou.add(p);
    }
    public void ajouterIngredient(Ingredient ingredient){
        this.pizzaActuel.addIngredient(ingredient);
    }
    public Pizza getPizzaActuel() {
        return pizzaActuel;
    }

    public void setPizzaActuel(Pizza pizzaActuel) {
        this.pizzaActuel = pizzaActuel;
    }

    public void setListeTabou(ArrayList<Pizza> listeTabou) {
        this.listeTabou = listeTabou;
    }

    public ArrayList<Pizza> getListeTabou() {
        return listeTabou;
    }
}
