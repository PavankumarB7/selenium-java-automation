package web_element_handling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropDown {

        public static void main(String[] args) {

                WebDriver driver = new ChromeDriver();

                driver.get("https://www.syntaxprojects.com/no-select-tag-dropdown-demo-homework.php");
                driver.manage().window().maximize();

                // driver.findElement(By.xpath("//div[@id='favorite_hobbies']")).click();

                // 1) Select single option from dropdown
                /*
                 * driver.findElement(By.xpath(
                 * "//ul[@class='dropdown-menu multi-dropdown-menu']//li[normalize-space()='Traveling']"
                 * ))
                 * .click();
                 * 
                 * String selectedValue =
                 * driver.findElement(By.xpath("//div[@id='favorite_hobbies']")).getText();
                 * 
                 * System.out.println("Selected value: " + selectedValue);
                 */

                // 2) Capture all options in dropdown & size
                List<WebElement> options = driver
                                .findElements(By.xpath("//ul[contains(@class, 'multi-dropdown-menu')]//li"));

                System.out.println("Number of options: " + options.size());

                // 3) Printing options from dropdown
                /*
                 * for (WebElement op : options) {
                 * System.out.println(op.getText());
                 * }
                 */

                // 4) Select multiple options in a dropdown
                String[] targetOptions = { "Traveling", "Gardening" };

                for (String targetOption : targetOptions) {

                        // open dropdown
                        driver.findElement(By.xpath("//div[@id='favorite_hobbies']")).click();

                        // Find the option
                        WebElement option = driver.findElement(
                                        By.xpath("//ul[contains(@class, 'multi-dropdown-menu')]//li[normalize-space()='"
                                                        + targetOption + "']"));

                        option.click();

                        System.out.println("Selected option: " + targetOption);
                }

        }
}
