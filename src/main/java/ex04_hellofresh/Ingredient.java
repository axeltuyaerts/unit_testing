package ex04_hellofresh;

public class Ingredient {
    private final String name;
    private final String unit;
    private final String units;
    private final Integer amount;
    private final int servings;

    public Ingredient(String name, String unit, String units, Integer amount, int servings) {
        validateParameters(name, unit, units, amount, servings);
        this.name = name;
        this.unit = unit;
        this.units = units;
        this.amount = amount;
        this.servings = servings;
    }

    public static void validateParameters(String name, String unit, String units, Integer amount, int servings) {
        if (servings < 1) {
            throw new IllegalArgumentException("Servings cannot be less then 1");
        }
        if (unit == null || units == null) {
            if (name == null)
                throw new IllegalArgumentException("If unit & units are null, name cannot be null");
            if (amount != null)
                throw new IllegalArgumentException("if unit & units are null, amount must be null");
        } else {
            if (amount < 1) throw new IllegalArgumentException("amount must be 1 or higher");
            if (servings > 1 && amount != 1)
                throw new IllegalArgumentException("If servings > 1 than amount must be 1");
        }
    }
}
