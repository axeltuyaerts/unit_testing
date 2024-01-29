package ex01_arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ArrayOfIntsSumOf3SmallestIntsTest {
    private final ArrayOfInts arrayOfInts = new ArrayOfInts();

    @Test
    void happyflow() {
        int result = arrayOfInts.sumOf3SmallestInts(new int[]{1, 2, 3});
        assertEquals(6, result);
    }

    @Test
    void smallArray(){
        int result = arrayOfInts.sumOf3SmallestInts(new int[] {1,2});
        assertEquals(3,result);
    }

    @Test
    void returnNull() {
        int result = arrayOfInts.sumOf3SmallestInts(null);
        assertEquals(0, result);
    }

    @Test
    void emptyArray(){
        int result = arrayOfInts.sumOf3SmallestInts(new int[]{});
        assertEquals(0,result);
    }
}
