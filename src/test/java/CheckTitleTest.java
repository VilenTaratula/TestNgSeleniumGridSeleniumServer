import org.testng.annotations.Test;
import page_object_classes.ResultPage;
import page_object_classes.RozetkaHomePage;
import page_object_classes.BasicClassTest;

import static org.testng.Assert.assertEquals;


public class CheckTitleTest extends BasicClassTest {
    @Test
    public void testTitle() {
        ResultPage resultPage = new RozetkaHomePage(getDriver())
                .clickOnComputerLink();
        assertEquals(resultPage.getTitle(), resultPage.expectedTitle);

    }
}
