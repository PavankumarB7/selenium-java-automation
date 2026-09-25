package assignmnets;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxAssignment {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        List<WebElement> checkboxes = driver
                .findElements(By.xpath("//table[@id='productTable']//input[@type='checkbox']"));

        for (WebElement checkbox : checkboxes) {
            checkbox.click();
        }
    }
}
