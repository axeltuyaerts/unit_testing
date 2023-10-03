package ex07_product_description_OBF;

import java.util.Locale;

public class Product {
    private Integer size;
    private Double percentage;

    public Product(Integer size, Double percentage) {
        this.size = size;
        this.percentage = percentage;
    }

    public String productDescription() {
        if (size == null && percentage == null) return "";

        String result = " • ";

        if (size != null) {
            result += (int) (double) size + "CL";
            if (percentage != null) {
                result += " ";
            }
        }

        if (percentage != null) {
            result += formatPercentage();
        }
        return result;
    }

    private String formatPercentage() {
        String format;
        if (percentage % 1 > 0) {
            format = "%.1f%%";
        } else {
            format = "%.0f%%";
        }
        return String.format(Locale.ROOT, format, percentage);
    }
}
