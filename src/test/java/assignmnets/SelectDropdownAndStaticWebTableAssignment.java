package assignmnets;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdownAndStaticWebTableAssignment {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://blazedemo.com/");
        driver.manage().window().maximize();

        // Select departure city
        WebElement departureCityElement = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select departureCity = new Select(departureCityElement);
        departureCity.selectByValue("Portland");

        // Select destination city
        WebElement destinationCityElement = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select destinationCity = new Select(destinationCityElement);
        destinationCity.selectByValue("Berlin");

        // Clicking find flights button
        driver.findElement(By.xpath("//input[@value='Find Flights']")).click();

        // Count flight rows inside tbody
        int rows = driver.findElements(By.xpath("//table[@class='table']/tbody//tr")).size();
        System.out.println("Total flight rows: " + rows); // 5 rows

        String[] prices = new String[rows];

        // Read and collect prices from each row into the array
        for (int r = 1; r <= rows; r++) {
            String price = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[" + r + "]/td[6]")).getText();
            System.out.println(price);
            prices[r - 1] = price;
        }

        Arrays.sort(prices);
        System.out.println(Arrays.toString(prices));

        String lowestPrice = prices[0];

        // Find and select the flight with the lowest price
        for (int r = 1; r <= rows; r++) {
            String price = driver.findElement(
                    By.xpath("//table[@class='table']/tbody/tr[" + r + "]/td[6]")).getText();

            if (price.equals(lowestPrice)) {
                driver.findElement(
                        By.xpath("//table[@class='table']/tbody/tr[" + r + "]/td[1]")).click();
                break;
            }
        }

        // Fill passenger details

        driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("Jane");
        driver.findElement(By.xpath("//input[@id='address']")).sendKeys("742 Evergreen Terrace");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Whitefield");
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Berlin");
        driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("97477");
        driver.findElement(By.xpath("//input[@id='creditCardNumber']")).sendKeys("4111111111111111");
        driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("Jane Doe");
        driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();

        // Verify purchase confirmation message
        String actualMessage = driver.findElement(By.xpath("//h1")).getText();

        String expectedMessage = "Thank you for your purchase today!";

        if (actualMessage.equals(expectedMessage)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }

    }
}
