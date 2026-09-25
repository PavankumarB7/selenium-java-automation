package advanced_features;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();

        // 1) Normal Alert with OK button
        // driver.findElement(By.xpath("//button[normalize-space()='Click for JS
        // Alert']")).click();

        // Alert myAlert = driver.switchTo().alert();
        // System.out.println(myAlert.getText());
        // myAlert.accept();

        // 2) Confirmation Alert with OK & Cancel buttons
        // driver.findElement(By.xpath("//button[normalize-space()='Click for JS
        // Confirm']")).click();

        // driver.switchTo().alert().accept(); // close alert using OK button
        // driver.switchTo().alert().dismiss(); // close alert using Cancel button

        // 3) Prompt Alert - Input box
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();

        Alert myPromptAlert = driver.switchTo().alert();

        myPromptAlert.sendKeys("Welcome");
        myPromptAlert.accept();

    }
}
