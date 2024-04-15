package src;

import java.util.ArrayList;

public class RechercheTabou {
    private ArrayList<Pizza> listeTabou;
    private Pizza pizzaActuel;
    private int scoreActuel;
    private ArrayList<Ingredient> ingredients;
    private ArrayList<Client> clients;
    public RechercheTabou(ArrayList<Ingredient> ingredients,ArrayList<Client> clients) {
        listeTabou = new ArrayList<>();
        pizzaActuel = new Pizza();
        this.clients = clients;
        this.ingredients = ingredients;
        pizzaActuel.evaluer_score(clients);
        scoreActuel = pizzaActuel.getScore();
        System.out.println("SCORE DEBUT = " + scoreActuel);
    }
    public void calculDuMeilleurVoisin(){
        int scoreTemp = 0;
        int scoreBest = scoreActuel;
        Pizza temp = pizzaActuel;
        Pizza best = pizzaActuel;
        for (Ingredient ingredient : ingredients){
            temp.addIngredient(ingredient);
            temp.evaluer_score(clients);
            scoreTemp = temp.getScore();
            System.out.println(temp + " score : " + scoreTemp);
            if (scoreTemp > scoreBest){
                System.out.println("COUCOU");
                scoreBest = scoreTemp;
                best = temp;
            }
            temp.removeIngredient(ingredient);
        }
        pizzaActuel = best;
        scoreActuel = scoreBest;
        this.listeTabou.add(pizzaActuel);
    }

    public int getScoreActuel() {
        return scoreActuel;
    }

    public void setScoreActuel(int scoreActuel) {
        this.scoreActuel = scoreActuel;
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
