package web_element_handling;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleDynamicPaginationTable {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://practice.softwaretestingmentor.com");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[@id='nav-pagination-table']")).click();

        // Showing 1–5 of 50
        String text = driver.findElement(By.xpath("//span[@id='pag-info']")).getText();

        String totalItemsStr = text.substring(text.indexOf("of ") + 3).trim();
        int totalItems = Integer.parseInt(totalItemsStr);

        // 1) Calculate the total pages
        int itemsPerpage = 5;
        int totalPages = (int) Math.ceil((double) totalItems / itemsPerpage);

        System.out.println("total items found: " + totalItems);
        System.out.println("total pages to click through: " + totalPages);

        System.out.println("----------------------------------------");
        // Print table header
        System.out.println("ID" + "\t" + "Product Name" + "\t" + "Price");
        System.out.println("----------------------------------------");

        // 2) The Page Rotation Loop
        for (int i = 1; i <= totalPages; i++) {
            System.out.println("Processing page " + i);

            // reading data from the page
            List<WebElement> rows = driver.findElements(By.xpath("//table[@id='pagination-table']//tbody//tr"));
            int rowCount = rows.size();

            System.out.println("Rows Count: " + rowCount);

            for (int r = 1; r <= rowCount; r++) {
                String id = driver.findElement(By.xpath("//table[@id='pagination-table']//tbody//tr[" + r + "]//td[1]"))
                        .getText();
                String productName = driver
                        .findElement(By.xpath("//table[@id='pagination-table']//tbody//tr[" + r + "]//td[2]"))
                        .getText();
                String price = driver
                        .findElement(By.xpath("//table[@id='pagination-table']//tbody//tr[" + r + "]//td[4]"))
                        .getText();

                System.out.println(id + "\t" + productName + "\t" + price);
            }

            if (i < totalPages) {
                driver.findElement(By.id("pag-next")).click();
            }
        }

    }
}
