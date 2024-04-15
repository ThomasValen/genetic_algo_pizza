package src;

import java.util.ArrayList;

public class RechercheTabou {
    private ArrayList<Mouvement> listeTabou;
    private Pizza pizzaActuel;
    int compteur = 0;
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
        Mouvement mouvement = new Mouvement();
        int scoreTemp = 0;
        int scoreBest = scoreActuel;
        Pizza temp = new Pizza(pizzaActuel);
        Pizza best = new Pizza(pizzaActuel);
        for (Ingredient ingredient : ingredients){
            //Ajouter un ingrédient
            if(!temp.getIngredients().contains(ingredient)) {
                temp.addIngredient(ingredient);
                if (!listeTabou.contains(new Mouvement("ajouter",ingredient))) {
                    compteur++;
                    temp.evaluer_score(clients);
                    scoreTemp = temp.getScore();
                    if (scoreTemp >= scoreBest) {
                        //System.out.println("COUCOU");
                        scoreBest = scoreTemp;
                        best.setIngredients(new ArrayList<>(temp.getIngredients()));
                        best.setIngredientsString(new ArrayList<>(temp.getIngredientsString()));
                        best.setScore(temp.getScore());
                        mouvement.setIngredient(ingredient);
                        mouvement.setAction("ajouter");
                    }
                    temp.removeIngredient(ingredient);
                }
            }
            //Supprimer un ingrédient
            if(temp.getIngredients().contains(ingredient)) {
                temp.removeIngredient(ingredient);
                if (!listeTabou.contains(new Mouvement("supprimer",ingredient))) {
                    compteur++;
                    temp.evaluer_score(clients);
                    scoreTemp = temp.getScore();
                    if (scoreTemp >= scoreBest) {
                        //System.out.println("COUCOU");
                        scoreBest = scoreTemp;
                        best.setIngredients(new ArrayList<>(temp.getIngredients()));
                        best.setIngredientsString(new ArrayList<>(temp.getIngredientsString()));
                        best.setScore(temp.getScore());
                        mouvement.setIngredient(ingredient);
                        mouvement.setAction("supprimer");
                    }
                    temp.addIngredient(ingredient);
                }
            }
        }
        //System.out.println("LOOK AT ME " + best.getIngredientsString() + best.getIngredients());
        pizzaActuel = best;
        scoreActuel = scoreBest;
        if(!listeTabou.contains(mouvement) && mouvement.getAction() !=null)
            this.listeTabou.add(mouvement);

    }

    public int getCompteur() {
        return compteur;
    }

    public int getScoreActuel() {
        return scoreActuel;
    }

    public void setScoreActuel(int scoreActuel) {
        this.scoreActuel = scoreActuel;
    }

    public void ajouterTabou(Mouvement m){
        listeTabou.add(m);
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

    public void setListeTabou(ArrayList<Mouvement> listeTabou) {
        this.listeTabou = listeTabou;
    }

    public ArrayList<Mouvement> getListeTabou() {
        return listeTabou;
    }
}
