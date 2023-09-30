package ex11_strings_OPL;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StringFunctionsSwitchCharactersTest {
    StringFunctions stringFunctions = new StringFunctions();

    @Test
    void switchCharacters_originalIsNull_returnsNull() {
        assertNull(stringFunctions.switchCharacters(null, 'a', 'b'));
    }

    @Test
    void switchCharacters_originalIsEmpty_returnsEmpty() {
        assertEquals(stringFunctions.switchCharacters("", 'a', 'b'), "");
    }

    @Test
    void switchCharacters_originalDoesNotContainCharacter1_returnsOriginal() {
        assertEquals(stringFunctions.switchCharacters("ABCDE", '.', 'B'), "ABCDE");
    }

    @Test
    void switchCharacters_originalDoesNotContainCharacter2_returnsOriginal() {
        assertEquals(stringFunctions.switchCharacters("ABCDE", 'A', '?'), "ABCDE");
    }

    @Test
    void switchCharacters_character1HasDifferentCasing_returnsOriginal() {
        assertEquals(stringFunctions.switchCharacters("ABCDE", 'a', 'B'), "ABCDE");
    }

    @Test
    void switchCharacters_character2HasDifferentCasing_returnsOriginal() {
        assertEquals(stringFunctions.switchCharacters("ABCDE", 'A', 'b'), "ABCDE");
    }

    @Test
    void switchCharacters_bothCharactersHaveSameCasing_returnsSwitched() {
        assertEquals(stringFunctions.switchCharacters("ABCDE", 'A', 'D'), "DBCAE");
    }

    @Test
    void switchCharacters_sameCasingMultipleOccurrences_returnsSwitched() {
        assertEquals(stringFunctions.switchCharacters("AANHANGWAGEN", 'A', 'W'), "WWNHWNGAWGEN");
    }

    @Test
    void switchCharacters_nonAlphabet_returnsSwitched() {
        assertEquals(stringFunctions.switchCharacters("a.f?m//z-_?.I5h.g", 'I', '.'), "aIf?m//z-_?I.5hIg");
    }
}
