import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdateDropDown {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/users/chromedriver-mac-x64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise");

        System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

        driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("//div[@id='divpaxinfo']")).getText());
        for (int i = 0; i < 4; i++)
            driver.findElement(By.id("hrefIncAdt")).click();

        driver.findElement(By.id("btnclosepaxoption")).click();
        System.out.println(driver.findElement(By.xpath("//div[@id='divpaxinfo']")).getText());
    }
}
