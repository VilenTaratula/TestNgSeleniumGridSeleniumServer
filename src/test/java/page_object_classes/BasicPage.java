package page_object_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class BasicPage {

    protected   WebDriver driver;

    public  WebDriver getDriver() {
        return driver;
    }

    public BasicPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(getDriver(), this);
    }
    public WebElement findElementByXpath(String xpath) {
        return (new WebDriverWait(getDriver(), Duration.of(15, ChronoUnit.SECONDS)))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }
}
