package testng.annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
1) Login --- @BeforeClass
2) Search --- @Test
3) Adv Search --- @Test
4) Logout --- @AfterClass
 */

public class BeforeAfterClassDemo {

    @BeforeClass
    void login() {
        System.out.println("This is login...");
    }

    @AfterClass
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
