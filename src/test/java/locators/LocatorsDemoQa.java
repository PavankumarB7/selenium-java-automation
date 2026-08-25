package locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemoQa {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        // DemoQA Practice Form
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();

        // id
        driver.findElement(By.id("firstName")).sendKeys("Pavan");

        // name
        driver.findElement(By.name("gender")).click();

        // className
        List<WebElement> elements = driver.findElements(By.className("form-control"));

        System.out.println("Total elements with class 'form-control': " +
                elements.size());

        // tagName
        List<WebElement> inputs = driver.findElements(By.tagName("input"));

        System.out.println("Total number of input elements: " + inputs.size());

        // Link Text
        driver.get("https://demoqa.com/links");

        driver.findElement(By.linkText("Home")).click();

        driver.quit();
    }
}