import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelIntroduction   {
    public static void main( String[] args ) {
        System.setProperty("webdriver.chrome.driver", "/users/chromedriver-mac-x64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice");

        // Get the page source
        String pageSource = driver.getPageSource();

        // Print or use the page source as needed
        System.out.println(pageSource);

        // Close the browser
        driver.quit();
    }
}
