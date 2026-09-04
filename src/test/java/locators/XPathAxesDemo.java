package locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathAxesDemo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        driver.manage().window().maximize();

        // 1. SELF
        WebElement self = driver.findElement(
                By.xpath("//label[contains(text(),'Textarea')]/self::label"));

        System.out.println("Self: " + self.getText());

        // 2. PARENT
        WebElement parent = driver.findElement(
                By.xpath("//textarea[@name='my-textarea']/parent::label"));

        System.out.println("Parent: " + parent.getText());

        // 3. CHILD
        List<WebElement> children = driver.findElements(
                By.xpath("//label[contains(text(),'Textarea')]/child::*"));

        System.out.println("Number of children: " + children.size());

        // 4. DESCENDANT
        List<WebElement> descendants = driver.findElements(
                By.xpath("//form/descendant::input"));

        System.out.println("Number of input descendants: " + descendants.size());

        // 5. ANCESTOR
        List<WebElement> ancestors = driver.findElements(
                By.xpath("//textarea[@name='my-textarea']/ancestor::*"));

        System.out.println("Number of ancestors: " + ancestors.size());

        // 6. FOLLOWING-SIBLING
        List<WebElement> followingSiblings = driver.findElements(
                By.xpath("//label[contains(text(),'Text input')]/following-sibling::*"));

        System.out.println("Number of following siblings: "
                + followingSiblings.size());

        // 7. PRECEDING-SIBLING
        List<WebElement> precedingSiblings = driver.findElements(
                By.xpath("//label[contains(text(),'Password')]/preceding-sibling::*"));

        System.out.println("Number of preceding siblings: "
                + precedingSiblings.size());

        // 8. FOLLOWING
        List<WebElement> following = driver.findElements(
                By.xpath("//label[contains(text(),'Text input')]/following::*"));

        System.out.println("Number of following elements: "
                + following.size());

        // 9. PRECEDING
        List<WebElement> preceding = driver.findElements(
                By.xpath("//label[contains(text(),'Password')]/preceding::*"));

        System.out.println("Number of preceding elements: "
                + preceding.size());

        driver.quit();
    }
}