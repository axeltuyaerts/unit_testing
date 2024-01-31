package ex04_hellofresh;

import java.lang.reflect.Modifier;

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

    public String getText(int nrOfPortions) {
        String amountToPrint = constructAmountToPrint(nrOfPortions);
        String unitToPrint = constructUnitToPrint(nrOfPortions);
        String nameToPrint = constructNameToPrint();

        StringBuilder result = new StringBuilder(amountToPrint == null ? "" : amountToPrint);
        if (unitToPrint != null) result.append((result.length() > 0 ? " " : "") + unitToPrint);
        if (nameToPrint != null) result.append((result.length() > 0 ? " " : "") + nameToPrint);
        return result.toString();
    }

    private String constructNameToPrint() {
        return name;
    }

    private String constructUnitToPrint(int nrOfPortions) {
        if (unit == null || units == null) return null;

        if (((double) nrOfPortions / servings) * amount > 1) {
            return units;
        } else {
            return unit;
        }
    }

    private String constructAmountToPrint(int nrOfPortions) {
        if (amount == null || amount == 0) {
            return null;
        } else if (servings > 1) {
            if (nrOfPortions % servings > 0) {
                return "%d/%d".formatted(nrOfPortions, servings);
            } else {
                return "%d".formatted(nrOfPortions / servings);
            }
        } else {
            return "%d".formatted(amount * nrOfPortions);
        }
    }
}
