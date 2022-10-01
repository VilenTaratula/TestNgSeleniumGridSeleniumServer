import org.testng.annotations.Test;
import page_object_classes.ResultPage;
import page_object_classes.RozetkaHomePage;
import page_object_classes.BasicClassTest;

import static org.testng.Assert.*;

public class CheckChangedLanguageTest extends BasicClassTest {
    @Test
    public void testCorrectPhraseOnButtonEnterToAccount() {
        ResultPage resultPage = new RozetkaHomePage(getDriver())
                .changeLanguage();
        assertEquals(resultPage.getPhrase(), resultPage.expectedPhrase);
    }
}
