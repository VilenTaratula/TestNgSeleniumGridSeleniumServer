import org.testng.annotations.*;
import page_object_classes.*;
import static org.testng.Assert.assertEquals;


public class CorrectUrlTest extends BasicClassTest {

    @Test
    public void testLogoCorrectUrl() {
        RozetkaHomePage rozetkaHomePage = new RozetkaHomePage(getDriver())
                .clickOnLogoHomePage()
                .clickLogoOnResultPage()
                .refresh();
        assertEquals(rozetkaHomePage.getUrl(), rozetkaHomePage.expectedHomePageUrl);
    }


}
