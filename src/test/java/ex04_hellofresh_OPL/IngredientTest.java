package ex04_hellofresh_OPL;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IngredientTest {

    @Test
    void getText_singular() {
        Ingredient ingredient = new Ingredient("suiker", "lepel", "lepels", 1, 1);

        assertEquals("1 lepel suiker", ingredient.getText(1));
    }

    @Test
    void getText_multiplePortions_usesPluralUnits() {
        Ingredient ingredient = new Ingredient("suiker", "lepel", "lepels", 1, 1);

        assertEquals("2 lepels suiker", ingredient.getText(2));
    }

    @Test
    void getText_AmountIs2_usesPluralUnits() {
        Ingredient ingredient = new Ingredient("suiker", "lepel", "lepels", 2, 1);

        assertEquals("2 lepels suiker", ingredient.getText(1));
    }

    @Test
    void getText_UnitsAreEqual() {
        Ingredient ingredient = new Ingredient("bloem", "gram", "gram", 20, 1);

        assertEquals("40 gram bloem", ingredient.getText(2));
    }

    @Test
    void getText_AmountIs0_usesNameWithoutAmountOrUnit() {
        Ingredient ingredient = new Ingredient("zout naar smaak", null, null, null, 1);

        assertEquals("zout naar smaak", ingredient.getText(10));
    }

    @Test
    void getText_nameIsNullAmountIs1_usesUnit() {
        Ingredient ingredient = new Ingredient(null, "ei", "eieren", 1, 1);

        assertEquals("1 ei", ingredient.getText(1));
    }

    @Test
    void getText_nameIsNullAmountIs3_usesPluralUnit() {
        Ingredient ingredient = new Ingredient(null, "ei", "eieren", 1, 1);

        assertEquals("3 eieren", ingredient.getText(3));
    }

    @Test
    void getText_AmountIs1ServingIs2_usesSingularUnitWithFraction() {
        Ingredient ingredient = new Ingredient(null, "courgette", "courgettes", 1, 2);

        assertEquals("1/2 courgette", ingredient.getText(1));
    }

    @Test
    void getText_AmountIs1ServingIs2PortionsIs3_usesSingularUnitWithFraction() {
        Ingredient ingredient = new Ingredient(null, "courgette", "courgettes", 1, 2);

        assertEquals("3/2 courgettes", ingredient.getText(3));
    }

    @Test
    void getText_AmountIs1ServingIs2PortionsIs2_usesSingularUnitWithoutFraction() {
        Ingredient ingredient = new Ingredient(null, "courgette", "courgettes", 1, 2);

        assertEquals("1 courgette", ingredient.getText(2));
    }

    @Test
    void getText_AmountIs1ServingIs2PortionsIs4_usesPluralUnitWithoutFraction() {
        Ingredient ingredient = new Ingredient(null, "courgette", "courgettes", 1, 2);

        assertEquals("2 courgettes", ingredient.getText(4));
    }

    @Test
    void getText_AllParametersAreNull_ThrowsValidationError() {
        assertThrows(IllegalArgumentException.class, () ->
                new Ingredient(null, null, null, null, 2));
    }

    @Test
    void getText_AmountIsMoreThan1ServingIsMoreThan1_ThrowsValidationError() {
        assertThrows(IllegalArgumentException.class, () ->
                new Ingredient(null, "", "", 2, 2));
    }

    @Test
    void getText_AmountIsLessThan1_ThrowsValidationError() {
        assertThrows(IllegalArgumentException.class, () ->
                new Ingredient(null, "", "", 0, 2));
    }

    @Test
    void getText_ServingIsLessThan1_ThrowsValidationError() {
        assertThrows(IllegalArgumentException.class, () ->
                new Ingredient(null, "", "", 1, 0));
    }

    @Test
    void getText_UnitsAreNullAmountIsNotNull_ThrowsValidationError() {
        assertThrows(IllegalArgumentException.class, () ->
                new Ingredient(null, null, null, 1, 0));
    }
}