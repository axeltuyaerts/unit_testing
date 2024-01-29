package ex03_more_arrays_OPL;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayOfIntObjects {
    public Integer[] findDuplicateValues(Integer[] arrayOfInts) {
        if (arrayOfInts == null) return new Integer[]{};

        HashMap<Integer, Integer> count = new HashMap<>();
        for (Integer number : arrayOfInts) {
            if (number != null) {
                Integer value = count.get(number);
                count.put(number, value == null ? 1 : value + 1);
            }
        }
        Integer[] duplicates = new Integer[arrayOfInts.length];
        int nrOfDuplicates = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() > 1) duplicates[nrOfDuplicates++] = entry.getKey();
        }
        return Arrays.copyOf(duplicates, nrOfDuplicates);
    }

    public Integer[] findCommonElements(Integer[] arrLeft, Integer[] arrRight) {
        if (arrLeft == null || arrRight == null) return new Integer[]{};

        Integer[] arrRightIntegers = new Integer[arrRight.length];
        for (int i = 0; i < arrRight.length; i++) {
            arrRightIntegers[i] = arrRight[i];
        }
        Integer[] commons = new Integer[arrLeft.length];
        int nrOfCommons = 0;
        for (Integer numberLeft : arrLeft) {
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
