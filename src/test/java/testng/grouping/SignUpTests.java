package testng.grouping;

import org.testng.annotations.Test;

public class SignUpTests {

    @Test(priority = 1, groups = {"regression"})
    void signUpByEmail() {
        System.out.println("##This is signup by email##");
    }

    @Test(priority = 2, groups = {"regression"})
    void signUpByFacebook() {
        System.out.println("##This is signup by facebook##");
    }

    @Test(priority = 3, groups = {"regression"})
    void signUpByTwitter() {
        System.out.println("##This is signup by twitter##");
    }
}
