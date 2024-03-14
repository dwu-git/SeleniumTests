import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class PaginationAndSorting {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/users/chromedriver-mac-x64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.xpath("//tr/th[1]")).click();
        List<WebElement> webElements = driver.findElements(By.xpath("//tr/td[1]"));
        List<String> originalList = webElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        List<String> sortedList = originalList.stream()
                .sorted()
                .collect(Collectors.toList());

        Assert.assertEquals(sortedList, originalList);

        List<String> price;
        do {
            List<WebElement> webElementsRows = driver.findElements(By.xpath("//tr/td[1]"));
            price = webElementsRows.stream()
                    .filter(webElement -> webElement.getText().contains("Rice"))
                    .map(PaginationAndSorting::getPrice)
                    .collect(Collectors.toList());

            price.forEach(System.out::println);

            if (price.isEmpty())
                driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
        }
        while (price.isEmpty());
    }

    private static String getPrice(WebElement webElement) {
        return webElement.findElement(By.xpath("following-sibling::td[1]")).getText();
    }
}
