package page_object_classes;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class BasicClassTest {
    protected WebDriver driver;

    @BeforeMethod
    @Parameters({"browser"})

    public void setUp(String browser) throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setBrowserName(browser);
        driver = new RemoteWebDriver(new URL("http://localhost:4444/"), dc);
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("https://rozetka.com.ua/ua/");
    }

    @AfterMethod
    public void setDown() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

}
