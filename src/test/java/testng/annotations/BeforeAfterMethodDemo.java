package testng.annotations;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
1) Login -- @BeforeMethod
2) Search --- @Test
3) Logout --- @AfterMethod
4) Login
5) Adv Search --- @Test
6) Logout
 */

public class BeforeAfterMethodDemo {

    @BeforeMethod
    void login() {
        System.out.println("This is login...");
    }

    @AfterMethod
    void logout() {
        System.out.println("This is logout...");
    }

    @Test(priority=1)
    void search() {
        System.out.println("this is search.....");
    }

    @Test(priority=2)
    void advancedSearch() {
        System.out.println("this is advanced search.....");
    }
}
