package tests.TranslatorTest;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class OLXTest extends BaseTest {

    @Test (invocationCount = 3, successPercentage = 50)
    public void checkTheInput(){


        basePage.open("https://www.wikipedia.org/");
        OLXPage.TextField();
        OLXPage.CheckBox();

        switchWindow();
    }
}
