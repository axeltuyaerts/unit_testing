package ex01_arrays_OPL;

import ex01_arrays.ArrayOfInts;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayOfInts3SmallestIntsTest {

    @Test
    void sumOf3SmallestInts_happyflow() {
        ArrayOfInts arrayOfInts = new ArrayOfInts();
        int sumOf3SmallestInts = arrayOfInts.sumOf3SmallestInts(new int[]{1, 2, 3, 4});

        assertEquals(6, sumOf3SmallestInts);
    }

    @Test
    void sumOf3SmallestInts_null_returns0() {
        ArrayOfInts arrayOfInts = new ArrayOfInts();
        int sumOf3SmallestInts = arrayOfInts.sumOf3SmallestInts(null);

        assertEquals(0, sumOf3SmallestInts);
    }

    @Test
    void sumOf3SmallestInts_emptyArray_returns0() {
        ArrayOfInts arrayOfInts = new ArrayOfInts();
        int sumOf3SmallestInts = arrayOfInts.sumOf3SmallestInts(new int[] {});

        assertEquals(0, sumOf3SmallestInts);
    }

    @Test
    void sumOf3SmallestInts_smallArray_returnsSum() {
        ArrayOfInts arrayOfInts = new ArrayOfInts();
        int sumOf3SmallestInts = arrayOfInts.sumOf3SmallestInts(new int[] {5, 6});

        assertEquals(11, sumOf3SmallestInts);
    }

}