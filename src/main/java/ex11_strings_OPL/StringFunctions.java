package ex11_strings_OPL;

import java.util.Locale;

public class StringFunctions {
    public boolean containsAllCharacters(String reference, String tobeFound) {
        if (reference == null || tobeFound == null) return false;

        String toBeFoundUpper = tobeFound.toUpperCase(Locale.ROOT);
        String referenceUpper = reference.toUpperCase(Locale.ROOT);

        for (char c: toBeFoundUpper.toCharArray()) {
            if (!referenceUpper.contains("" + c)) return false;
        }

        return true;
    }

    public String switchCharacters(String original, char character1, char character2) {
        if (original == null) return null;

        if (original.indexOf(character1) < 0) return original;
        if (original.indexOf(character2) < 0) return original;

        String result = "";

        for (char c: original.toCharArray()) {
            if (c == character1)
                result += character2;
            else if (c == character2)
                result += character1;
            else
                result += c;
        }

        return result;
    }

    private static char toUpper(char character1) {
        return ("" + character1).toUpperCase(Locale.ROOT).charAt(0);
    }
}
