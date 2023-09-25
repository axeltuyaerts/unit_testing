package ex02_product_description_OPL;

import java.util.Locale;

public class Product {
    public static final String WHOLE_NUMBER = "%.0f%%";
    public static final String NON_WHOLE_NUMBER = "%.1f%%";
    public static final String CL = "CL";
    public static final String DOT = " • ";

    private String name;
    private Integer size;
    private Double percentage;

    public Product(String name, Integer size, Double percentage) {
        this.name = name;
        this.size = size;
        this.percentage = percentage;
    }

    public String productDescription() {
        if (size == null && percentage == null) return "";
        String result = DOT;
        if (size != null) {
            result += size + CL;
        }
        if (percentage != null) {
            String format = isWholeNumber() ? WHOLE_NUMBER : NON_WHOLE_NUMBER;
            if (size != null) result += " ";
            result += String.format(Locale.ROOT, format, percentage);
        }
        return result;
    }

    private boolean isWholeNumber() {
        return percentage % 1 == 0;
    }
}
