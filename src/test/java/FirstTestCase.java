/*
    Login    - testautomation@demo.com
    Password - automation123
 */

/*
  Test Case 
  --------
 1) Launch browser(chrome)
 2) Open URL  https://naveenautomationlabs.com/opencart/
 3) Validate title should be "Your Store"
 4) Close browser

 */

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class FirstTestCase {

    public static void main(String[] args) {

        // 1) Launch browser (chrome)

        // ChromeDriver driver = new ChromeDriver();
        WebDriver driver = new ChromeDriver();

        // 2) Open URL

        driver.get("https://naveenautomationlabs.com/opencart/");

        // 3) Validate title should be "Your Store"

        String act_title = driver.getTitle();

        if (act_title.equals("Your Store")) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

        // 4) Close browser

        driver.close();
        // driver.quit();

    }
}