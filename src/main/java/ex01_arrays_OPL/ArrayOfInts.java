package ex01_arrays_OPL;

import java.util.Arrays;

public class ArrayOfInts {
    public int sumOfInts(int[] arrayOfInts) {
        if (arrayOfInts == null) return 0;
        int sum = 0;
        for (int i : arrayOfInts)
            sum += i;
        return sum;
    }

    public int sumOf3SmallestInts(int[] arrayOfInts) {
        if (arrayOfInts == null) return 0;
        int[] copy = Arrays.copyOf(arrayOfInts, arrayOfInts.length);
        Arrays.sort(copy);
        return sumOfInts(Arrays.copyOf(copy, 3));
    }

    public int sumOfEven(int[] arrayOfInts) {
        if (arrayOfInts == null) return 0;
        int[] even = new int[arrayOfInts.length];
        int evenLength = 0;
        for (int i : arrayOfInts)
            if (i % 2 == 0) even[evenLength++] = i;
        return sumOfInts(even);
    }

    public int sumOfXLargest(int[] arrayOfInts, int x) {
        if (arrayOfInts == null || arrayOfInts.length == 0) return 0;
        if (x == 0) return 0;

        int[] copy = Arrays.copyOf(arrayOfInts, arrayOfInts.length);
        Arrays.sort(copy);

        int from = x > arrayOfInts.length ? 0 : arrayOfInts.length - x;
        return sumOfInts(Arrays.copyOfRange(copy, from, arrayOfInts.length));
    }

    public static void main(String[] args) {
        ArrayOfInts ex1 = new ArrayOfInts();
        int result = ex1.sumOfInts(new int[]{1, 2, 3, 4});
        System.out.println(result);
    }

    public int countMostPopularNumber(int[] arrayOfInts) {
        if (arrayOfInts == null || arrayOfInts.length == 0) return 0;
        int[] copy = Arrays.copyOf(arrayOfInts, arrayOfInts.length);
        Arrays.sort(copy);

        int count = 1;
        int maxcount = 1;
        int lastValue = copy[0];
        for (int i=1; i<copy.length; i++) {
            if (copy[i] == lastValue) {
                count++;
            }
            else {
                if (count > maxcount) maxcount = count;
                count = 1;
                lastValue = copy[i];
            }
        }

        if (count > maxcount) maxcount = count;
        return maxcount;

    }
}
