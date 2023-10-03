package ex05_arrays_OBF;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayOfIntsFunctie1Test {

    private final ArrayOfInts arrayOfInts = new ArrayOfInts();

    @Test
    void sumOfInts_happyflow() {
        int result = arrayOfInts.sumOfInts(new int[]{1, 2, 3, 4});
        assertEquals(10, result);
    }

    @Test
    void sumOfInts_onlyTwo() {
        int result = arrayOfInts.sumOfInts(new int[]{2, 7});
        assertEquals(9, result);
    }

    @Test
    void sumOfInts_emptyArray() {
        int result = arrayOfInts.sumOfInts(new int[]{});
        assertEquals(0, result);
    }

    @Test
    void sumOfInts_nullArray() {
        int result = arrayOfInts.sumOfInts(null);
        assertEquals(0, result);
    }
}