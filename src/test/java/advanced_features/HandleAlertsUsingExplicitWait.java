package advanced_features;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Handle alerts without using switchTo().alert()
// By using explicit wait

public class HandleAlertsUsingExplicitWait {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10)); // explicit wait declaration

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();

        Alert myAlert = myWait.until(ExpectedConditions.alertIsPresent()); // capture alert

        System.out.println(myAlert.getText());
        myAlert.accept();

    }
}
