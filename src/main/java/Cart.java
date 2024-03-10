import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Cart {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/users/chromedriver-mac-x64/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/seleniumPractise");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        for (int i =0; i < products.size(); i++) {
            String name = products.get(i).getText();
            if (name.contains("Cucumber")) {
                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
                break;
            }
        }
        driver.findElement(By.xpath("//img[@alt='Cart']")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector(".promoBtn")).click();

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
        System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());
    }
}
