package ex04_hellofresh_OPL;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private final String name;
    private final int amountForRecipe;

    private final List<Ingredient> ingredients = new ArrayList<>();
    private final List<String> lines = new ArrayList<>();

    public Recipe(String name, int amountForRecipe) {
        this.name = name;
        this.amountForRecipe = amountForRecipe;
    }

    public Recipe(String name) {
        this.name = name;
        this.amountForRecipe = 1;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public String getRecipeText(int nbrOfPersons) {
        StringBuilder result = new StringBuilder(String.format("%s voor %d %s\n", name, nbrOfPersons, nbrOfPersons > 1 ? "personen":"persoon"));

        for (Ingredient ingredient : ingredients) {
            result.append(ingredient.getText(nbrOfPersons / amountForRecipe) + "\n");
        }

        if (!lines.isEmpty()) result.append("\n");
        
        for (String line : lines) {
            result.append(line + "\n");
        }

        return result.toString();
    }

    public void addRecipeLine(String line) {
        lines.add(line);
    }
}
