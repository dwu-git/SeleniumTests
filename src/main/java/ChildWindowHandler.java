import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class ChildWindowHandler {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/users/chromedriver-mac-x64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise");

        driver.findElement(By.cssSelector(".blinkingText")).click();

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        String parentId = iterator.next();
        String childId = iterator.next();

        driver.switchTo().window(childId);
        System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
        String email = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];

        driver.switchTo().window(parentId);
        driver.findElement(By.id("username")).sendKeys(email);
    }
}
