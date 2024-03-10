import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FrameTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/users/chromedriver-mac-x64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable");
        driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).build().perform();

        driver.switchTo().defaultContent();
        driver.navigate().refresh();

        driver.findElement(By.xpath("//a[text()='Accordion']")).sendKeys(Keys.chord(Keys.COMMAND, Keys.ENTER));
    }
}
