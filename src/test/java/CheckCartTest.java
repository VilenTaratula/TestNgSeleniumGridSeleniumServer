import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page_object_classes.CartPage;
import page_object_classes.ResultPage;
import page_object_classes.RozetkaHomePage;
import page_object_classes.BasicClassTest;

import static org.testng.Assert.assertEquals;

public class CheckCartTest extends BasicClassTest {
    @Test
    @Parameters({"browser"})
    public void testCart(String browser) {
        CartPage cartPage = new RozetkaHomePage(getDriver())
                .clickOnComputerLink()
                .clickOnLaptopLink()
                .clickOnLaptop(browser)
                .addLaptopToCart(browser)
                .refresh()
                .clickOnCartLogo();
        assertEquals(cartPage.getText(), "Оформити замовлення");
    }
}
