package page_object_classes;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class RozetkaHomePage extends BasicPage {


    public String expectedHomePageUrl = "https://rozetka.com.ua/ua/";
    String goToComputerPage = "//a[@class='menu-categories__link'][contains(text(),'Ноутбуки та комп’ютери')]";

    public RozetkaHomePage(WebDriver driver) {
        super(driver);
    }

    public String getUrl() {
        return getDriver().getCurrentUrl();
    }

    public RozetkaHomePage refresh() {
        getDriver().navigate().refresh();
        return this;
    }

    public ResultPage clickOnComputerLink() {
        findElementByXpath(goToComputerPage).click();
        return new ResultPage(getDriver());
    }

    public ResultPage clickOnLogoHomePage() {
        String logoImageXpath = "//img[@alt='Rozetka Logo']";
        findElementByXpath(logoImageXpath).click();
        return new ResultPage(getDriver());
    }

    public ResultPage changeLanguage() {
        String changeLanguageXpath = "//li[@class='lang__item lang-header__item ng-star-inserted']/a[@class='lang__link ng-star-inserted']";
        findElementByXpath(changeLanguageXpath).click();
        return new ResultPage(getDriver());
    }


}
