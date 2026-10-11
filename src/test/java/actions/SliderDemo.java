package actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderDemo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
        driver.manage().window().maximize();

        Actions act = new Actions(driver);

        // Min slider
        WebElement min_slider = driver.findElement(By.xpath("(//span[contains(@class,'ui-slider-handle')])[1]"));
        System.out.println("Default location of min _slider: " + min_slider.getLocation()); // 59, 250 =(x, y)
        act.dragAndDropBy(min_slider, 100, 0).perform();
        System.out.println("Location of the min_slider after moving: " + min_slider.getLocation()); // 158, 250

        // Max slider
        WebElement max_slider = driver.findElement(By.xpath("(//span[contains(@class,'ui-slider-handle')])[2]"));
        System.out.println("Default location of max_slider: " + max_slider.getLocation()); // 613, 250
        act.dragAndDropBy(max_slider, -100, 0).perform();
        System.out.println("Location of the max_slider after moving: " + max_slider.getLocation()); // 513, 250
    }
}
