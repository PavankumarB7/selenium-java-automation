package assignmnets;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationalCommandsAssignmnet {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com");
        driver.manage().window().maximize();

        WebElement searchBox = driver.findElement(By.id("Wikipedia1_wikipedia-search-input"));
        searchBox.sendKeys("Selenium");

        WebElement searchButton = driver.findElement(By.className("wikipedia-search-button"));
        searchButton.click();

        List<WebElement> links = driver.findElements(By.cssSelector("#Wikipedia1_wikipedia-search-results a"));

        System.out.println("Total search result links: " + links.size());

        for (WebElement link : links) {
            link.click();
        }

        Set<String> windowIDs = driver.getWindowHandles();

        for (String winID : windowIDs) {
            String title = driver.switchTo().window(winID).getTitle();
            System.out.println(title);

            if (title.equals("Selenium (software) - Wikipedia")) {
                driver.close();
            }
        }

        driver.quit();

    }
}
