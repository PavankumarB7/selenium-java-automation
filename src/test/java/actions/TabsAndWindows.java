package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TabsAndWindows {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://demowebshop.tricentis.com/");

        // Selenium 4.x - opens a new tab
        // driver.switchTo().newWindow(WindowType.TAB);

        // Selenium 4.x - opens a new browser window
        driver.switchTo().newWindow(WindowType.WINDOW);

        driver.get("https://orangehrm.com");
    }
}
