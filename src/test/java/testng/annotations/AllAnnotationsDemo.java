
package testng.annotations;

import org.testng.annotations.*;

public class AllAnnotationsDemo {

    @BeforeSuite
    void beforeSuite() {
        System.out.println("This is BeforeSuite method");
    }

    @BeforeTest
    void beforeTest() {
        System.out.println("This is BeforeTest method");
    }

    @BeforeClass
    void beforeClass() {
        System.out.println("This is before class...");
    }

    @BeforeMethod
    void beforeMethod() {
        System.out.println("This is before method...");
    }

    @Test
    void test1() {
        System.out.println("Test 1 Executed.....");
    }

    @Test
    void test2() {
        System.out.println("Test 2 Executed.....");
    }

    @AfterMethod
    void afterMethod() {
        System.out.println("This is after method...");
    }

    @AfterClass
    void afterClass() {
        System.out.println("This is after class...");
    }

    @AfterTest
    void afterTest() {
        System.out.println("This is AfterTest method");
    }

    @AfterSuite
    void afterSuite() {
        System.out.println("This is AfterSuite method");
    }
}