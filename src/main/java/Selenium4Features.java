import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class Selenium4Features {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "/users/chromedriver-mac-x64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice");

        WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));
        System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());

        WebElement dateOfBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
        driver.findElement(with(By.tagName("input")).below(dateOfBirth)).click(); // Submit button

        WebElement iceCreamText = driver.findElement(By.cssSelector(".form-check-label"));
        driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamText)).click(); //Ice cream checkbox

        //New tab
        driver.switchTo().newWindow(WindowType.TAB);
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        String parentID = iterator.next();
        String childId = iterator.next();

        driver.switchTo().window(childId);
        driver.get("https://rahulshettyacademy.com");
        String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
        driver.switchTo().window(parentID);

        WebElement name =  driver.findElement(By.cssSelector("[name='name']"));
        name.sendKeys(courseName);
        //WebElement Screenshot
        File file = name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("./logo.png"));

        //Width & Height
        System.out.println(name.getRect().getDimension().getWidth());
        System.out.println(name.getRect().getDimension().getHeight());

        driver.quit();
    }
}
