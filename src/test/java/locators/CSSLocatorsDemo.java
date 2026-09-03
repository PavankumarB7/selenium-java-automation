package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSLocatorsDemo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/locators_tests/locators.html");
        driver.manage().window().maximize();

        // Tag + ID
        driver.findElement(By.cssSelector("input#fname")).clear();
        driver.findElement(By.cssSelector("input#fname")).sendKeys("Rock");

        // Tag + Class
        driver.findElement(By.cssSelector("input#fname")).clear();
        driver.findElement(By.cssSelector("input.information")).sendKeys("Jack");

        // Tag + Attribute
        driver.findElement(By.cssSelector("input#lname")).clear();
        driver.findElement(By.cssSelector("input[placeholder='lname']")).sendKeys("Lee");

        // Tag + Class + Attribute
        driver.findElement(By.cssSelector("input.information[name='lname']")).clear();
        driver.findElement(By.cssSelector("input.information[name='lname']")).sendKeys("Dara");

    }
}
