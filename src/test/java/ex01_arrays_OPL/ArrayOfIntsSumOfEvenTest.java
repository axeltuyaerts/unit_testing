package ex01_arrays_OPL;

import ex01_arrays.ArrayOfInts;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayOfIntsSumOfEvenTest {

    @Test
    void sumOfEven_happyflow() {
        ArrayOfInts arrayOfInts = new ArrayOfInts();
        int sumOfEven = arrayOfInts.sumOfEven(new int[]{3, 4, 5, 6, 7});
        assertEquals(10, sumOfEven);
    }

    @Test
    void sumOfEven_paranoia() {
        ArrayOfInts arrayOfInts = new ArrayOfInts();
        int sumOfEven = arrayOfInts.sumOfEven(new int[]{4});
        assertEquals(4, sumOfEven);
    }

    @Test
    void sumOfEven_null_returns0() {
        ArrayOfInts arrayOfInts = new ArrayOfInts();
        int sumOfEven = arrayOfInts.sumOfEven(null);
        assertEquals(0, sumOfEven);
    }

    @Test
    void sumOfEven_empty_returns0() {
        ArrayOfInts arrayOfInts = new ArrayOfInts();
        int sumOfEven = arrayOfInts.sumOfEven(new int[]{});
        assertEquals(0, sumOfEven);
    }

    @Test
    void sumOfEven_allUneven_returns0() {
        ArrayOfInts arrayOfInts = new ArrayOfInts();
        int sumOfEven = arrayOfInts.sumOfEven(new int[]{3, 5, 7, 9});
        assertEquals(0, sumOfEven);
    }
}