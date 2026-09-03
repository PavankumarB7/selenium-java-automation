package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathDemo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        driver.manage().window().maximize();

        // Relative Xpath with single attribute
        driver.findElement(By.xpath("//input[@name='my-text']")).sendKeys("Pavan");

        // Relative Xpath with multiple attributes
        driver.findElement(By.xpath("//input[@name='my-text'][@type='text']")).sendKeys("Kumar");

        // Relative Xpath with 'and' operator
        driver.findElement(By.xpath("//input[@name='my-text' and @type='text']")).sendKeys("pavan");

        // Relative Xpath with 'or' operator
        driver.findElement(By.xpath("//input[@name='my-text' or @type='text']")).sendKeys("kumar");

        // Xpath with text() - inner text
        boolean displayStatus = driver.findElement(By.xpath("//h1[text()='Web form']")).isDisplayed();
        System.out.println(displayStatus);

        // capture text value of element
        String value = driver.findElement(By.xpath("//h1[text()='Web form']")).getText();
        System.out.println(value);

        // xpath with contains()
        driver.findElement(By.xpath("//input[contains(@name,'word')]")).sendKeys("kumar");

        // xpath with starts-with()
        driver.findElement(By.xpath("//input[starts-with(@name, 'my-pass')]")).sendKeys("Kumar");

        // Chained xpath
        driver.findElement(By.xpath("//label[contains(text(),'Textarea')]/textarea")).sendKeys("Fill the Details...");

    }
}
