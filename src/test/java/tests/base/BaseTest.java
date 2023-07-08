package tests.base;

import CommonAction.CommonAction;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.translator.OLXPage;
import pages.base1.BasePage;

import java.util.Set;

public class BaseTest {

    protected WebDriver driver = CommonAction.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected OLXPage OLXPage = new OLXPage(driver);

    protected void switchWindow() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String window1 = driver.getWindowHandle();
        js.executeScript("window.open()");

        Set<String > currentWindows = driver.getWindowHandles();

        String window2 = null;
        for (String window : currentWindows){
            if (!window.equals(window1)){
                window2 = window;
                break;
            }
        }
        driver.switchTo().window(window2);
    }
    WebDriverWait wait = new WebDriverWait(driver, 10);
    protected void wait1 (){
       Alert alert =  wait.until(ExpectedConditions.alertIsPresent());
       driver.switchTo().alert();
    }
}
