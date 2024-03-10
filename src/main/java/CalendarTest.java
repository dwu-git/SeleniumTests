import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CalendarTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/users/chromedriver-mac-x64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise");

        String year = "2027";
        String monthNumber = "6";
        String day = "15";
        String[] expectedDate = { monthNumber, day, year };

        driver.findElement(By.xpath("//a[@class='cart-header-navlink'][1]")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        iterator.next();
        String childId = iterator.next();
        driver.switchTo().window(childId);

        driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.xpath("//button[text()='" + year + "']")).click();
        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(monthNumber) - 1).click();
        driver.findElement(By.xpath("//abbr[text()='" + day + "']")).click();

        List<WebElement> listOfElements = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
        for (int i = 0; i < listOfElements.size(); i++) {
            System.out.println(listOfElements.get(i).getAttribute("value"));
            Assert.assertEquals(listOfElements.get(i).getAttribute("value"), expectedDate[i]);
        }
        driver.quit();
    }
}
