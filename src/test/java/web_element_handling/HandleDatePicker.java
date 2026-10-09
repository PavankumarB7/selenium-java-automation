package web_element_handling;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleDatePicker {

    // selecting future date
    static void selectFutureDate(WebDriver driver, String year, String month, String date) {

        while (true) {

            // actual data
            String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            if (currentMonth.equals(month) && currentYear.equals(year)) {
                break;
            }

            // Next arrow button
            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();

        }

        List<WebElement> allDates = driver
                .findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));

        for (WebElement dt : allDates) {
            if (dt.getText().equals(date)) {
                dt.click();
                break;
            }
        }
    }

    // selecting past date
    static void selectPastDate(WebDriver driver, String year, String month, String date) {

        while (true) {

            // actual data
            String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            if (currentMonth.equals(month) && currentYear.equals(year)) {
                break;
            }

            // previous arrow button
            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();

        }

        List<WebElement> allDates = driver
                .findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));

        for (WebElement dt : allDates) {
            if (dt.getText().equals(date)) {
                dt.click();
                break;
            }
        }
    }

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();

        // Switch to frame
        driver.switchTo().frame(0);

        // Method 1 - using sendKeys()
        // driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("10/07/2026");

        // Method 2 - using the date picker

        // expected data
        String year = "2027";
        String month = "October";
        String date = "15";

        driver.findElement(By.xpath("//input[@id='datepicker']")).click(); // opens date picker

        selectFutureDate(driver, year, month, date);
        // selectPastDate(driver, year, month, date);

    }
}
