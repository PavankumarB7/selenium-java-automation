package actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropAction {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(
                "https://naepdev.github.io/NAEP-Style-Guide/ux/demos/response-type-matching/matching-no-groups-full.html");
        driver.manage().window().maximize();

        Actions act = new Actions(driver);

        // drag and drop1
        WebElement object1 = driver.findElement(By.xpath("//p[normalize-space()='Object 1']"));
        WebElement target1 = driver.findElement(
                By.xpath("(//div[contains(@class,'match-drop-target')])[1]"));

        act.dragAndDrop(object1, target1).perform();

        // drag and drop2
        WebElement object2 = driver.findElement(By.xpath("//p[normalize-space()='Object 2']"));
        WebElement target2 = driver.findElement(
                By.xpath("//div[contains(@class,'tall')]//div[contains(@class,'match-drop-target')]"));

        act.dragAndDrop(object2, target2).perform();

    }
}
