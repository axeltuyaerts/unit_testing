package ex05_arrays_OBF;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayOfIntsFunctie2Test {

    private final ArrayOfInts arrayOfInts = new ArrayOfInts();

    @Test
    void sumOfEven_happy() {
        int result = arrayOfInts.sumOfEven(new int[]{2, 4});
        assertEquals(6, result);
    }

    @Test
    void sumOfEven_otherHappy() {
        int result = arrayOfInts.sumOfEven(new int[]{1, 2, 7, 6});
        assertEquals(8, result);
    }

    @Test
    void sumOfEven_noEvenNumbers() {
        int result = arrayOfInts.sumOfEven(new int[]{7, 1, 3});
        assertEquals(0, result);
    }

    @Test
    void sumOfEvent_emptyArray() {
        int result = arrayOfInts.sumOfEven(new int[]{});
        assertEquals(0, result);
    }

    @Test
    void sumOfEven_parametersIsNull() {
        int result = arrayOfInts.sumOfEven(null);
        assertEquals(0, result);
    }

}