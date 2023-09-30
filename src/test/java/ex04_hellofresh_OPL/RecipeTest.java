package ex04_hellofresh_OPL;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecipeTest {
    private Recipe recipe;

    @BeforeEach
    void setup() {
        recipe = new Recipe("Appeltaart");
        recipe.addIngredient(new Ingredient(null, "appel", "appels", 1, 1));
        recipe.addIngredient(new Ingredient("bloem", "gram", "gram", 100, 1));
        recipe.addIngredient(new Ingredient("boter", "gram", "gram", 50, 1));
        recipe.addIngredient(new Ingredient(null, "vanillestok", "vanillestokken", 1, 2));
    }

    @Test
    void getRecipeText_AmountIs1For1Person() {
        String result = recipe.getRecipeText(1);

        assertEquals(
                """
                        Appeltaart voor 1 persoon
                        1 appel
                        100 gram bloem
                        50 gram boter
                        1/2 vanillestok
                        """,
                result
        );
    }

    @Test
    void getRecipeText_AmountIs1For4Persons() {
        String result = recipe.getRecipeText(4);

        assertEquals(
                """
                        Appeltaart voor 4 personen
                        4 appels
                        400 gram bloem
                        200 gram boter
                        2 vanillestokken
                        """,
                result
        );
    }

    @Test
    void getRecipeText_AmountIs2For4Persons() {
        Recipe recipe = new Recipe("Appeltaart", 2);

        recipe.addIngredient(new Ingredient(null, "appel", "appels", 1, 1));
        recipe.addIngredient(new Ingredient("bloem", "gram", "gram", 100, 1));
        recipe.addIngredient(new Ingredient("boter", "gram", "gram", 50, 1));
        recipe.addIngredient(new Ingredient(null, "vanillestok", "vanillestokken", 1, 2));

        String result = recipe.getRecipeText(4);

        assertEquals(
                """
                        Appeltaart voor 4 personen
                        2 appels
                        200 gram bloem
                        100 gram boter
                        1 vanillestok
                        """,
                result
        );
    }


    @Test
    void getRecipeText_IncludesInstructions() {
        recipe.addRecipeLine("Instructie Lijn 1");
        recipe.addRecipeLine("Instructie Lijn 2");
        String result = recipe.getRecipeText(4);

        assertEquals(
                """
                        Appeltaart voor 4 personen
                        4 appels
                        400 gram bloem
                        200 gram boter
                        2 vanillestokken
                        
                        Instructie Lijn 1
                        Instructie Lijn 2
                        """,
                result
        );
    }

}