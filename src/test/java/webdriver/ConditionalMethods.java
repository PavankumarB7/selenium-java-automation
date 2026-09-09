package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethods {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        // isDisplayed()
        WebElement logo = driver.findElement(By.xpath("//img[@class='wikipedia-icon']"));
        System.out.println("Display Status of Logo: " + logo.isDisplayed());

        // isEnabled()
        boolean input = driver.findElement(By.xpath("//input[@id='name']")).isEnabled();
        System.out.println("Enable Input: " + input);

        // isSelected()
        WebElement male_rd = driver.findElement(By.xpath("//input[@id='male']"));
        WebElement female_rd = driver.findElement(By.xpath("//input[@id='female']"));

        System.out.println("Before selection.............");
        System.out.println(male_rd.isSelected()); // false
        System.out.println(female_rd.isSelected()); // false

        System.out.println("After selecting male........");
        male_rd.click();

        System.out.println(male_rd.isSelected()); // true
        System.out.println(female_rd.isSelected()); // false

    }
}
