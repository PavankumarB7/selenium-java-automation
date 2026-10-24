package testng.assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardVsSoftAssertions {

    //@Test
    void test_hardAssertions() {

        System.out.println("testign....");
        System.out.println("testign....");

        Assert.assertEquals(1,2); // hard assertion

        System.out.println("testing..........");
        System.out.println("testing..........");
    }

    @Test
    void test_softAssertions() {

        System.out.println("testign....");
        System.out.println("testign....");

        SoftAssert sa = new SoftAssert();
        sa.assertEquals(1,2); // soft assertion

        System.out.println("testing..........");
        System.out.println("testing..........");

        sa.assertAll();
    }
}
