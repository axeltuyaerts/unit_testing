package ex05_arrays_OBF;

public class ArrayOfInts {

    public int sumOfInts(int[] arrayOfInts) {
        if (arrayOfInts == null) return 0;

        int getal = 0;

        for (int i : arrayOfInts) {
            getal += i;
        }
        return getal;
    }

    public int sumOfEven(int[] arrayOfInts) {
        if (arrayOfInts == null) return 0;

        int getal = 0;

        for (int i : arrayOfInts) {
            if (i % 2 == 0) {
                getal += i;
            }
        }

        return getal;
    }

}
