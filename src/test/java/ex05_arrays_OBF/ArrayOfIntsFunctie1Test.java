package ex05_arrays_OBF;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayOfIntsFunctie1Test {

    private final ArrayOfInts arrayOfInts = new ArrayOfInts();

    @Test
    void test1() {
        int result = arrayOfInts.functie1(new int[]{1, 2, 3, 4});
        assertEquals(10, result);
    }

    @Test
    void test2() {
        int result = arrayOfInts.functie1(new int[]{2, 7});
        assertEquals(9, result);
    }

    @Test
    void test3() {
        int result = arrayOfInts.functie1(new int[]{});
        assertEquals(0, result);
    }

    @Test
    void test4() {
        int result = arrayOfInts.functie1(null);
        assertEquals(0, result);
    }
}