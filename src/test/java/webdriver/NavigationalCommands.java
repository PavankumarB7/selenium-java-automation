package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationalCommands {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://selenium.dev");
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Back
        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());

        // Forward
        driver.navigate().forward();
        System.out.println(driver.getCurrentUrl());

        // Refresh
        driver.navigate().refresh();

    }
}
