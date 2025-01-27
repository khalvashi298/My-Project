
package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("web driver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
       driver.get(ConfigReader.get("url"));
        driver.manage().window().maximize(); //damatebuli
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();


    }
}
