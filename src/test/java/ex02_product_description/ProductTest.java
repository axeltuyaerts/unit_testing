package ex02_product_description;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProductTest {
    @Test
    void allNull() {
        Product p = new Product("empty", null, null);
        String result = p.productDescription();
        assertEquals("", result);
    }

    @Test
    void percentageNull() {
        Product p = new Product("empty", 20, null);
        String result = p.productDescription();
        assertEquals(" • 20CL", result);
    }

    @Test
    void sizeNull_percentage() {
        Product p = new Product("empty", null, 8.0);
        String result = p.productDescription();
        assertEquals(" • 8%", result);
    }

    @Test
    void sizeNull_percentage_decimal() {
        Product p = new Product("empty", null, 8.5);
        String result = p.productDescription();
        assertEquals(" • 8.5%", result);
    }

    @Test
    void sizeNull_percentage_TooMuchDecimals() {
        Product p = new Product("empty", null, 8.333);
        String result = p.productDescription();
        assertEquals(" • 8.3%", result);
    }

    @Test
    void allSet() {
        Product p = new Product("empty", 20, 8.5);
        String result = p.productDescription();
        assertEquals(" • 20CL 8.5%", result);
    }

}
