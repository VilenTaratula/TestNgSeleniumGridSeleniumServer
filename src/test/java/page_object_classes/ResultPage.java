package page_object_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class ResultPage extends BasicPage {
    private String logoImage = "//img[@alt='Rozetka Logo']";
    public String expectedPhrase = "Войдите в личный кабинет";
    String laptopLenovoXpath = "//a[contains(@title,'Ноутбук Lenovo V14 G2 ITL (Intel i3-1115G4/8/128F/int/W10Pro) Black')]";
    @FindBy(xpath = "//a[contains(@title,'Ноутбук Lenovo V14 G2 ITL (Intel i3-1115G4/8/128F/int/W10Pro) Black')]")
    private WebElement laptopLenovo;
    private String addLaptopToCartXpath = "//button[contains(@class,'buy-button button button--with-icon button--green button--medium ng-star-inserted')]";
    public String expectedTitle = "Інтернет-магазин ROZETKA™: офіційний сайт найпопулярнішого онлайн-гіпермаркету в Україні";


    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public RozetkaHomePage clickLogoOnResultPage() {
        findElementByXpath(logoImage).click();
        return new RozetkaHomePage(getDriver());
    }

    public ResultPage clickOnLaptopLink() {
        findElementByXpath("//a[@title='Ноутбуки'][contains(text(),'Ноутбуки')]").click();
        return this;
    }

    @Parameters({"browser"})
    public ResultPage clickOnLaptop(String browser) {
        if (browser.equals("opera")) {
            getDriver().navigate().refresh();
            WebElement webElement = laptopLenovo;
            webElement.click();
        } else {
            WebElement webElement = findElementByXpath(laptopLenovoXpath);
            webElement.click();
        }
        return this;
    }

    @Parameters({"browser"})
    public CartPage addLaptopToCart(String browser) {
        if (browser.equals("opera")) {
            WebElement unfocusedWebElement1 = new WebDriverWait(getDriver(), Duration.of(15, ChronoUnit.SECONDS))
                    .until(ExpectedConditions.presenceOfElementLocated(By
                            .xpath("//div//h1[contains(@class,'product__title')]")));
            unfocusedWebElement1.click();
            WebElement buttonBuywebElement = new WebDriverWait(getDriver(), Duration.of(15, ChronoUnit.SECONDS))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addLaptopToCartXpath)));
            buttonBuywebElement.click();
        } else {
            Actions actions = new Actions(getDriver());
            actions.pause(2000)
                    .moveToElement(findElementByXpath(addLaptopToCartXpath)).pause(2000).click().perform();

        }
        return new CartPage(getDriver());
    }

    public String getTitle() {
        return getDriver().getTitle();
    }

    public String getPhrase() {
        WebElement webElement = findElementByXpath("//button[contains(text(),'Войдите в личный кабинет')]");
        return webElement.getText();

    }

}
