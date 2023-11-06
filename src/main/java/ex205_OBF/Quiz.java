package ex205_OBF;

/**
 * You can assume this:
 * correctSolutions is never null
 * answers is never null
 * correctionSolutions always has the same amount of elements as answers
 * nrOfSeconds is never completely equal for the 3 candidates
 */
public class Quiz {
    private final int[] good;
    private final String yes;
    String name = null;
    Integer test = null;
    Integer test2 = null;

    public Quiz(int[] correctSolutions, String mol) {
        this.good = correctSolutions;
        this.yes = mol;
    }

    public void answers(String candidate, int[] answers, int nrOfSeconds) {
        boolean result = true;
        int found = 0;
        int j = good.length;
        int length = 0;
        String temp = null;
        if (!candidate.equals(yes)) {
            if (test == null) {
                for (int i = 0; i < j; i++) {
                    if (good[i] != answers[i]) {
                        length = length + 1;
                    } else
                        found++;
                }
                name = candidate;
                test = found;
                test2 = nrOfSeconds;
            } else {
                for (int i = 0; i < j; i++) {
                    if (answers[i] == good[i]) {
                        found++;
                    }
                }
                if (found <= test) {
                    if (test == found) {
                        if ((nrOfSeconds < test2)) {
                            temp = candidate;
                            test = found;
                            test2 = nrOfSeconds;
                        } else result = false;
                    } else {
                        result = false;
                    }
                }
            }
            if (result) {
                temp = candidate;
                test = found;
                test2 = nrOfSeconds;
            }
        } else {
            result = false;
            temp = candidate;
        }
        if (result )
            name = candidate;
        else if (temp != null)
            name = temp;

    }

    public String winner() {
        return name;
    }
}
