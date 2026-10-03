package assignmnets;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdownAssignmnet {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
        driver.manage().window().maximize();

        WebElement selectDropdown = driver.findElement(By.xpath("//select[@id='country-list']"));
        Select drpCountry = new Select(selectDropdown);

        // 1) count total number of options
        List<WebElement> options = drpCountry.getOptions();
        System.out.println("No. of Options in a country dropdown: " + options.size());

        System.out.println("--------------------------");

        // 2) print all the options
        for (WebElement option : options) {
            System.out.println(option.getText());
        }

        System.out.println("--------------------------");

        // 3) select one option
        drpCountry.selectByVisibleText("China");
        System.out.println("Selected Option : " + drpCountry.getFirstSelectedOption().getText());
    }
}
