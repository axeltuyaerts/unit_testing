package ex01_arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOfIntsSumOfEvenTest {
    private final ArrayOfInts arrayOfInts = new ArrayOfInts();

    @Test
    void happyflow() {
        int result = arrayOfInts.sumOfEven(new int[]{3, 4, 5, 6, 7});
        assertEquals(10, result);
    }

    @Test
    void paranoia() {
        int result = arrayOfInts.sumOfEven(new int[]{4});
        assertEquals(4, result);
    }

    @Test
    void emptyarray() {
        int result = arrayOfInts.sumOfEven(new int[]{});
        assertEquals(0, result);
    }

    @Test
    void nullarray() {
        int result = arrayOfInts.sumOfEven(null);
        assertEquals(0, result);
    }

    @Test
    void allUneven() {
        int result = arrayOfInts.sumOfEven(new int[] {1,3,5,7,9});
        assertEquals(0,result);
    }
}
