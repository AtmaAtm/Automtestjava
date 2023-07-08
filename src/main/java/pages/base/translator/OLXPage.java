package pages.base.translator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base1.BasePage;

public class OLXPage extends BasePage {

    public OLXPage(WebDriver driver) {
        super(driver);
    }

    By selectTextField = By.xpath("//*[@id='searchInput']");
    By CheckBox = By.xpath("//*[@id='ca-viewsource']/a/span");
    By TextOnPage = By.xpath("//*[@title='Help:Introduction']");

    public OLXPage TextField (){
        WebElement element = driver.findElement(selectTextField);
        element.click();
        element.sendKeys("Cats", Keys.ENTER);
        return this;
    }
    public OLXPage CheckBox (){
        waitTime(driver.findElement(CheckBox));
        driver.findElement(CheckBox).click();
        driver.findElement(TextOnPage).click();
        return this;
    }
}
