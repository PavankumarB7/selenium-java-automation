package web_element_handling;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handleframes {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://ui.vision/demo/webtest/frames/");
        driver.manage().window().maximize();

        // Frame 1
        WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
        driver.switchTo().frame(frame1); // passed frame as a webelement // switch to frame1
        driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Hello there!");

        driver.switchTo().defaultContent(); // go back to the page

        // Frame 2
        WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
        driver.switchTo().frame(frame2); // switch to frame2
        driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Selenium");

        driver.switchTo().defaultContent();

        // Frame 3
        WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
        driver.switchTo().frame(frame3); // switch to frame2
        driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Playwright");

        // inner iframe - part of frame 3
        driver.switchTo().frame(0);

        driver.findElement(By.xpath("//div[@id='i9']//div[@class='AB7Lab Id5V1']")).click();

        driver.switchTo().defaultContent();
    }
}
