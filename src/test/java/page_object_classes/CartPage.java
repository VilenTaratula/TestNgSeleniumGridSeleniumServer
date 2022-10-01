package page_object_classes;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class CartPage extends RozetkaHomePage {
    @FindBy(xpath = "//button[contains(@class,'header__button ng-star-inserted header__button--active')]")
    private WebElement logoCart;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage clickOnCartLogo() {
        new WebDriverWait(driver, Duration.of(30, ChronoUnit.SECONDS)).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        new WebDriverWait(getDriver(), Duration.of(15, ChronoUnit.SECONDS))
                .until(ExpectedConditions
                        .elementToBeClickable(logoCart))
                .click();
        return this;
    }

    public CartPage refresh() {
        getDriver().navigate().refresh();
        return this;
    }

    public String getText() {
        return findElementByXpath
                ("//a[@class='button button_size_large button_color_green cart-receipt__submit ng-star-inserted']")
                .getText();
    }

}
