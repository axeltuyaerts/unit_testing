package ex05_arrays_OBF;

public class ArrayOfInts {

    public int functie1(int[] a) {
        int nr;
        int getal = 0;
        boolean doIt = false;

        if (a != null) {
            nr = a.length;
            doIt = true;
        } else {
            nr = 0;
        }

        for (int j = 0; j < nr; j++) {
            if (doIt) {
                int i = a[j];
                getal += i;
            }
        }
        return getal;
    }

    public int functie2(int[] nr) {
        int nrs;
        int getal = 0;
        boolean ok = false;

        if (nr != null) {
            nrs = nr.length;
            ok = true;
        } else {
            nrs = 0;
        }
        int[] even = new int[nrs];
        int evenLength = 0;
        for (int j = 0; j < nrs; j++) {
            if (ok) {
                int i = nr[j];
                if (i % 2 == 0) {
                    getal += i;
                }
            }
        }

        for (int j = 0; j < nrs; j++) {
            if (nr[j] % 2 == 0) {
                even[j] = nr[j];
            } else {
                even[j] = 0;
            }
        }
        return getal;
    }

}
