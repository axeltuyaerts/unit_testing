package ex11_strings_OPL;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringFunctionsContainsAllCharactersTest {

    private StringFunctions stringFunctions = new StringFunctions();

    @Test
    void containsAllCharacters_NullReference_returnsFalse() {
        assertFalse(stringFunctions.containsAllCharacters(null, "GHIJK"));
    }

    @Test
    void containsAllCharacters_NullToBeFound_returnsFalse() {
        assertFalse(stringFunctions.containsAllCharacters("ABCDE", null));
    }

    @Test
    void containsAllCharacters_AllNull_returnsFalse() {
        assertFalse(stringFunctions.containsAllCharacters(null, null));
    }

    @Test
    void containsAllCharacters_emptyReference_returnsFalse() {
        assertFalse(stringFunctions.containsAllCharacters("", "ABC"));
    }

    @Test
    void containsAllCharacters_emptyToBeFound_returnsTrue() {
        assertTrue(stringFunctions.containsAllCharacters("ABC", ""));
    }

    @Test
    void containsAllCharacters_containsNone_returnsFalse() {
        assertFalse(stringFunctions.containsAllCharacters("ABCDE", "GHIJK"));
    }

    @Test
    void containsAllCharacters_containsSome_returnsFalse() {
        assertFalse(stringFunctions.containsAllCharacters("ABCDE", "ABCDF"));
    }

    @Test
    void containsAllCharacters_containsAll_returnsTrue() {
        assertTrue(stringFunctions.containsAllCharacters("ABCDE", "ABCD"));
    }

    @Test
    void containsAllCharacters_containsAllInDifferentCasing_returnsTrue() {
        assertTrue(stringFunctions.containsAllCharacters("ABCDE", "aBcD"));
    }

    @Test
    void containsAllCharacters_containsAllIncludingNonAlphabeticalChars_returnsTrue() {
        assertTrue(stringFunctions.containsAllCharacters("*$dGe6?.\")J4K", "j$\".*"));
    }

    @Test
    void containsAllCharacters_containsAllInDifferentOrder_returnsTrue() {
        assertTrue(stringFunctions.containsAllCharacters("Very Long Sentence", "nrVe"));
    }

    @Test
    void containsAllCharacters_containsMore_returnsFalse() {
        assertFalse(stringFunctions.containsAllCharacters("ABCDE", "ABCDEF"));
    }

}
