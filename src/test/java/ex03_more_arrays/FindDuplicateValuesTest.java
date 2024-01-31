package ex03_more_arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class FindDuplicateValuesTest {

    ArrayOfInts arrayOfInts = new ArrayOfInts();

    @Test
    void emptyArray() {
        int[] result = arrayOfInts.findDuplicateValues(new int[]{});
        int[] expected = new int[]{};
        assertArrayEquals(expected, result);
    }

    @Test
    void contains1int() {
        int[] result = arrayOfInts.findDuplicateValues(new int[]{1});
        int[] expected = new int[]{};
        assertArrayEquals(expected, result);
    }

    @Test
    void contains2int() {
        int[] result = arrayOfInts.findDuplicateValues(new int[]{1,2});
        int[] expected = new int[]{};
        assertArrayEquals(expected, result);
    }

    @Test
    void contains1duplicate() {
        int[] result = arrayOfInts.findDuplicateValues(new int[]{1,1});
        int[] expected = new int[]{1};
        assertArrayEquals(expected,result);
    }

    @Test
    void contains2duplicates() {
        int[] result = arrayOfInts.findDuplicateValues(new int[]{1,1,2,2});
        int[] expected = new int[]{1,2};
        assertArrayEquals(expected,result);
    }

    @Test
    void contains3duplicatesandint() {
        int[] result = arrayOfInts.findDuplicateValues(new int[]{1,1,2,2,5,5,7,8,4,9});
        int[] expected = new int[]{1,2,5};
        assertArrayEquals(expected,result);
    }

    @Test
    void contains3Equalint() {
        int[] result = arrayOfInts.findDuplicateValues(new int[]{1,1,1});
        int[] expected = new int[]{1};
        assertArrayEquals(expected,result);
    }

    @Test
    void nullArray() {
        int[] result = arrayOfInts.findDuplicateValues(null);
        int[] expected = new int[]{};
        assertArrayEquals(expected,result);
    }
}
