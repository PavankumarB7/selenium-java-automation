package advanced_features;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleauthenticatedPopup {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        // driver.get("https://the-internet.herokuapp.com/basic_auth");

        // Syntax - https://username:password@the-internet.herokuapp.com/basic_auth

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

    }
}
