package ex03_more_arrays_OPL;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FindDuplicateValuesObjectTest {
    ArrayOfIntObjects arrayOfInts = new ArrayOfIntObjects();

    @Test
    void emptyArray() {
        Integer[] result = arrayOfInts.findDuplicateValues(new Integer[]{});
        Integer[] expected = new Integer[]{};
        assertArrayEquals(expected, result);
    }

    @Test
    void contains1Int() {
        Integer[] result = arrayOfInts.findDuplicateValues(new Integer[]{1});
        Integer[] expected = new Integer[]{};
        assertArrayEquals(expected, result);
    }

    @Test
    void contains2EqualInts() {
        Integer[] result = arrayOfInts.findDuplicateValues(new Integer[]{2, 2});
        Integer[] expected = new Integer[]{2};
        assertArrayEquals(expected, result);
    }

    @Test
    void contains2EqualIntsAndSomethingElse() {
        Integer[] result = arrayOfInts.findDuplicateValues(new Integer[]{2, 1, 2, 5});
        Integer[] expected = new Integer[]{2};
        assertArrayEquals(expected, result);
    }

    @Test
    void contains2EqualIntsAndSomethingElse_IgnoringNulls() {
        Integer[] result = arrayOfInts.findDuplicateValues(new Integer[]{2, null, 1, 2, 5, null});
        Integer[] expected = new Integer[]{2};
        assertArrayEquals(expected, result);
    }

    @Test
    void containsOnlyDifferentInts() {
        Integer[] result = arrayOfInts.findDuplicateValues(new Integer[]{3, 4, 5, 6});
        Integer[] expected = new Integer[]{};
        assertArrayEquals(expected, result);
    }

    @Test
    void contains3EqualsInts() {
        Integer[] result = arrayOfInts.findDuplicateValues(new Integer[]{5, 5, 5});
        Integer[] expected = new Integer[]{5};
        assertArrayEquals(expected, result);
    }

    @Test
    void contains5EqualsIntsAndSomethingElse() {
        Integer[] result = arrayOfInts.findDuplicateValues(new Integer[]{1, 3, 6, 4, 6, 6, 8, 6, 9, 6, 7});
        Integer[] expected = new Integer[]{6};
        assertArrayEquals(expected, result);
    }

    @Test
    void contains2DifferentDuplicates() {
        Integer[] result = arrayOfInts.findDuplicateValues(new Integer[]{1, 2, 1, 2, 3, 2});
        Integer[] expected = new Integer[]{1,2};
        assertArrayEquals(expected, result);
    }

    @Test
    void nullArray() {
        Integer[] result = arrayOfInts.findDuplicateValues(null);
        Integer[] expected = new Integer[]{};
        assertArrayEquals(expected, result);
    }


}
