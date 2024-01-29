package ex03_more_arrays;

import java.util.Arrays;

public class ArrayOfInts {

    public int[] findCommonElements(int[] arrLeft, int[] arrRight) {
        if (arrLeft == null || arrRight == null) return new int[]{};

        Integer[] arrRightIntegers = new Integer[arrRight.length];
        for (int i = 0; i < arrRight.length; i++) {
            arrRightIntegers[i] = arrRight[i];
        }
        int[] commons = new int[arrLeft.length];
        int nrOfCommons = 0;
        for (int numberLeft : arrLeft) {
            boolean found = false;
            for (int i = 0; !found && i < arrRightIntegers.length; i++) {
                if (arrRightIntegers[i] != null && numberLeft == arrRightIntegers[i]) {
                    commons[nrOfCommons++] = numberLeft;
                    arrRightIntegers[i] = null;
                    found = true;
                }
            }
        }
        return Arrays.copyOf(commons, nrOfCommons);
    }
}
