package ex03_more_arrays_OPL;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FindCommonElementsObjectTest {
    ArrayOfIntObjects arrayOfInts = new ArrayOfIntObjects();

    @Test
    void arraysEmpty() {
        Integer[] result = arrayOfInts.findCommonElements(new Integer[]{}, new Integer[]{});
        Integer[] expected = new Integer[]{};
        assertArrayEquals(expected, result);
    }

    @Test
    void noEquals() {
        Integer[] result = arrayOfInts.findCommonElements(new Integer[]{1, 2}, new Integer[]{3, 4});
        Integer[] expected = new Integer[]{};
        assertArrayEquals(expected, result);
    }

    @Test
    void found1Equal() {
        Integer[] result = arrayOfInts.findCommonElements(new Integer[]{1, 2}, new Integer[]{3, 1, 4});
        Integer[] expected = new Integer[]{1};
        assertArrayEquals(expected, result);
    }

    @Test
    void found1EqualIgnoringNull() {
        Integer[] result = arrayOfInts.findCommonElements(new Integer[]{1, 2, null}, new Integer[]{3, null, 1, 4});
        Integer[] expected = new Integer[]{1};
        assertArrayEquals(expected, result);
    }

    @Test
    void found2Equals() {
        Integer[] result = arrayOfInts.findCommonElements(new Integer[]{1, 2, 3}, new Integer[]{3, 1, 4});
        Integer[] expected = new Integer[]{1, 3};
        assertArrayEquals(expected, result);
    }

    @Test
    void foundSameNumberTwice() {
        Integer[] result = arrayOfInts.findCommonElements(new Integer[]{1, 1, 3}, new Integer[]{4, 1, 1});
        Integer[] expected = new Integer[]{1, 1};
        assertArrayEquals(expected, result);
    }

    @Test
    void foundSameNumberOnceRight() {
        Integer[] result = arrayOfInts.findCommonElements(new Integer[]{1, 1, 3}, new Integer[]{4, 1});
        Integer[] expected = new Integer[]{1};
        assertArrayEquals(expected, result);
    }

    @Test
    void foundSameNumberOnceLeft() {
        Integer[] result = arrayOfInts.findCommonElements(new Integer[]{1, 3}, new Integer[]{4, 1, 1});
        Integer[] expected = new Integer[]{1};
        assertArrayEquals(expected, result);
    }

    @Test
    void leftNull() {
        Integer[] result = arrayOfInts.findCommonElements(null, new Integer[]{4, 1, 1});
        Integer[] expected = new Integer[]{};
        assertArrayEquals(expected, result);
    }

    @Test
    void rightNull() {
        Integer[] result = arrayOfInts.findCommonElements(new Integer[]{4, 1, 1}, null);
        Integer[] expected = new Integer[]{};
        assertArrayEquals(expected, result);
    }

}

