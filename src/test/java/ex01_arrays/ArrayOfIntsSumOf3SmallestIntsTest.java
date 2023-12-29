package ex01_arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ArrayOfIntsSumOf3SmallestIntsTest {
    private final ArrayOfInts arrayOfInts = new ArrayOfInts();

    @Test
    void happyflow() {
        int result = arrayOfInts.sumOf3SmallestInts(new int[]{1, 1, 1, 5, 7, 6, 4});
        assertEquals(3, result);
    }

    @Test
    void null_returns0() {
        int result = arrayOfInts.sumOf3SmallestInts(null);
        assertEquals(0, result);
    }

    @Test
    void empty_array() {
        int result = arrayOfInts.sumOf3SmallestInts(new int[]{});
        assertEquals(0, result);
    }

    @Test
    void small_array() {
        int result = arrayOfInts.sumOf3SmallestInts(new int[]{1, 1});
        assertEquals(2, result);
    }
}
