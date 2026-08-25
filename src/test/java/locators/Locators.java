package locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://naveenautomationlabs.com/opencart/");
        driver.manage().window().maximize();

        // name
        driver.findElement(By.name("search")).sendKeys("Mac");

        // id
        boolean logoDisplaystatus = driver.findElement(By.id("logo")).isDisplayed();
        System.out.println(logoDisplaystatus);

        // linktext
        driver.findElement(By.linkText("Tablets")).click();

        // partialLinkText
        // driver.findElement(By.partialLinkText("Tab")).click();

        // classname
        List<WebElement> headerLinks = driver.findElements(By.className("list-inline-item"));
        System.out.println("Total number of header links: " + headerLinks.size());

        // tagname
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total number of links: " + links.size());

        List<WebElement> images = driver.findElements(By.tagName("img"));
        System.out.println("Total number of header links: " + images.size());
    }
}
