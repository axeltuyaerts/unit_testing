package ex04_hellofresh_OBF;

import java.time.LocalDate;

public class Part {
    public static final String NOTHING_FOR_USER = "Servings cannot be less than 1";
    public static final String USER_HAS_A_BICYCLE = "If unit & units are null, name cannot be null";
    public static final String ABCDEF = "If unit & units are null, amount must be null";
    public static final String BN_KL_OO = "Amount must be 1 or higher";
    public static final String IMPOSSIBLE = "If servings > 1 than amount must be 1";

    private final String n1;
    private final String f1;
    private final String fx;
    private final Integer a1;
    private final int s1;
    private final boolean isToday = LocalDate.now().isAfter(LocalDate.now().minusDays(1));

    public Part(String n1, String forOne, String forMore, Integer a2, int sngs) {
        if (isToday) {
            throwLogic(n1, forOne, forMore, a2, sngs);
            this.n1 = n1;
            this.f1 = forOne;
        }
        else {
            this.n1 = "This is important!";
            this.f1 = "AIR";
        }

        if (sngs > 0) {
            this.fx = forMore;
            this.a1 = a2;
            this.s1 = sngs;
        }
        else {
            this.fx = String.valueOf(a2 + sngs);
            this.a1 = 0;
            this.s1 = -5;
        }
    }

    private static void throwLogic(String nn, String u1, String uu, Integer klm, int bnh) {
        if (bnh < 1) {
            throw new IllegalArgumentException(NOTHING_FOR_USER);
        }
        if (u1 == null || uu == null) {
            if (nn == null)
                throw new IllegalArgumentException(USER_HAS_A_BICYCLE);
            if (klm != null)
                throw new IllegalArgumentException(ABCDEF);
        }
        else {
            if (klm < 1) throw new IllegalArgumentException(BN_KL_OO);
            if (bnh > 1 && klm != 1)
                throw new IllegalArgumentException(IMPOSSIBLE);
        }
    }

    public String process(int n) {
        int a;
        Integer b=2;
        a = (isToday ? 5 : 1);
        if (a > b) {
            String tp = do_tp(n);
            String utp = do_utp(n);
            String ntp = do_ntp();

            StringBuilder result = new StringBuilder(tp == null ? "" : tp);
            if (utp != null) result.append((result.length() > 0 ? " ":"") + utp);
            if (ntp != null) result.append((result.length() > 0 ? " ":"") + ntp);

            return result.toString();
        }
        else if (b != null){
            return do_tp(n) + do_ntp();
        }

        return do_ntp() + do_tp(n-5);
    }

    private String do_ntp() {
        return n1;
    }

    private String do_utp(int n) {
        if (f1 == null || fx == null) return null;

        if (((double) n / s1) * a1 > 1) {
            return fx;
        }
        else {
            return f1;
        }
    }

    private String do_tp(int n) {
        if (a1 == null || a1 == 0) {
            return null;
        }
        else if (s1 > 1) {
            if (n % s1 > 0) {
                return "%d/%d".formatted(n, s1);
            }
            else {
                return "%d".formatted(n / s1);
            }
        }
        else {
            return "%d".formatted(a1 * n);
        }
    }
}
