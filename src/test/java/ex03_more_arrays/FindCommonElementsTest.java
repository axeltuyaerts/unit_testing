package ex03_more_arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FindCommonElementsTest {

    private ArrayOfInts arrayOfInts = new ArrayOfInts();

    @Test
    void allNull() {
        int[] result = arrayOfInts.findCommonElements(new int[]{}, new int[]{});
        int[] expected = new int[]{};
        assertArrayEquals(expected, result);
    }

    @Test
    void noEquals() {
        int[] result = arrayOfInts.findCommonElements(new int[]{1, 3}, new int[]{2, 4});
        int[] expected = new int[]{};
        assertArrayEquals(expected, result);
    }

    @Test
    void found1Equal() {
        int[] result = arrayOfInts.findCommonElements(new int[]{1, 3}, new int[]{1, 2, 4});
        int[] expected = new int[]{1};
        assertArrayEquals(expected, result);
    }

    @Test
    void found2Equal() {
        int[] result = arrayOfInts.findCommonElements(new int[]{1, 2, 3}, new int[]{1, 2, 4});
        int[] expected = new int[]{1, 2};
        assertArrayEquals(expected, result);
    }


    @Test
    void foundSameNumberTwice() {
        int[] result = arrayOfInts.findCommonElements(new int[]{1, 1, 3}, new int[]{1, 1, 4});
        int[] expected = new int[]{1, 1};
        assertArrayEquals(expected, result);
    }

    @Test
    void foundSameNumberOnceLeft() {
        int[] result = arrayOfInts.findCommonElements(new int[]{1, 3}, new int[]{1, 1, 4});
        int[] expected = new int[]{1};
        assertArrayEquals(expected, result);
    }

    @Test
    void foundSameNumberOnceRight() {
        int[] result = arrayOfInts.findCommonElements(new int[]{1, 1, 3}, new int[]{4, 1});
        int[] expected = new int[]{1};
        assertArrayEquals(expected, result);
    }


}
