package testng.annotations;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BeforeAfterTestDemo {

    @BeforeTest
    void beforeTest() {
        System.out.println("This is BeforeTest method");
    }

    @Test
    void test1() {
        System.out.println("Test 1 Executed");
    }

    @Test
    void test2() {
        System.out.println("Test 2 Executed");
    }

    @AfterTest
    void afterTest() {
        System.out.println("This is AfterTest method");
    }
}
