package testng.annotations;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BeforeAfterSuiteDemo {

    @BeforeSuite
     void beforeSuite() {
        System.out.println("This is BeforeSuite method");
    }

    @Test
    void test3() {
        System.out.println("Test 3 Executed");
    }

    @AfterSuite
    void afterSuite() {
        System.out.println("This is AfterSuite method");
    }
}
