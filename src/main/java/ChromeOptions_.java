import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ChromeOptions_ {
    public static void main(String[] args) {
       ChromeOptions options = new ChromeOptions();

        Proxy proxy = new Proxy();
        proxy.setHttpProxy("3234.324.234");
        options.setCapability("proxy", proxy);

        options.addExtensions();

        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", "/directory/path");
        options.setExperimentalOption("prefs", prefs);

        options.setAcceptInsecureCerts(true);

        System.setProperty("webdriver.chrome.driver", "/users/chromedriver-mac-x64/chromedriver");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://expired.badssl.com");

        System.out.println(driver.getTitle());
    }
}
