package ex00_testsetup_OPL;

import org.junit.jupiter.api.*;

public class TestSetupDemo {
    int counter = 0;

    @BeforeAll
    static void beforeAll() {
        System.out.println("BEFORE ALL");
    }

    @BeforeEach
    void beforeEach() {
        counter++;
        System.out.println("BEFORE EACH: " + counter);
    }

    @Test
    void eenTest() {
        counter++;
        System.out.println("IN DE TEST: " + counter);
    }

    @Test
    void eenAndereTest() {
        counter++;
        System.out.println("IN DE TWEEDE TEST: " + counter);
    }

    @AfterEach
    void afterEach() {
        counter++;
        System.out.println("AFTER EACH: " + counter);
    }

    @AfterAll
    static void afterAll() {
        System.out.println("AFTER ALL");
    }
}
