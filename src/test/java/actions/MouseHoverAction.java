package actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverAction {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://neoscript.in/");
        driver.manage().window().maximize();

        WebElement services = driver.findElement(By.xpath("//a[normalize-space()='Services']"));

        Actions act = new Actions(driver);

        // Mouse hover
        act.moveToElement(services).perform();

        WebElement productEngineering = driver.findElement(By.xpath("//span[normalize-space()='Product Engineering']"));

        System.out.println("Product Engineering text: " + productEngineering.getText());

        act.moveToElement(services).moveToElement(productEngineering).click().build().perform();

    }
}
