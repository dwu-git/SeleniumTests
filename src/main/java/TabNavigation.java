import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TabNavigation {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/users/chromedriver-mac-x64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.manage().window().maximize();
        driver.navigate().to("https://rahulshettyacademy.com");
        driver.navigate().back();
        driver.navigate().forward();
    }
}
