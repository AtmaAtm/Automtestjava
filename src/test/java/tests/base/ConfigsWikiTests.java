package tests.base;

import com.beust.jcommander.Parameter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ConfigsWikiTests {
    public WebDriver driver;

    public ConfigsWikiTests(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    By infoInput = By.xpath("//*[@name='search']");
    By flag = By.xpath("//*[@title=\"Flag of Ukraine\"]//img[@alt=\"Flag of Ukraine\"]");
    By cityOdesa = By.xpath("//*[@style=\"text-align:left;\"]//a[@href=\"/wiki/Odesa\"]");
    By newInfoInput = By.xpath("//*[@title=\"Search Wikipedia [alt-shift-f]\" and @name=\"search\"]");
    By twinTowns = By.xpath("//*[@href=\"/wiki/Turkey\"]//..//..//../a[@href=\"/wiki/Istanbul\"]");
    By titleIstanbul = By.xpath("//*[@class=\"mw-page-title-main\"]");


    @Parameters ("word")
    public void searchField (@Optional("Ukraine") String word){
        driver.findElement(infoInput).click();
        driver.findElement(infoInput).sendKeys(word, Keys.ENTER);
    }

    public void verifyFlag (){
       WebElement flag1 = driver.findElement(flag);
        Assert.assertTrue(flag1.isDisplayed(), "Flag is not displayed");
    }

    public void newInputOdesa(){
        String city = driver.findElement(cityOdesa).getText();
        Assert.assertEquals(city, "Odesa", "City is not Odesa");
        driver.findElement(newInfoInput).click();
        driver.findElement(newInfoInput).sendKeys("Odesa", Keys.ENTER);
    }

    public void setTwinTowns(){
        driver.findElement(twinTowns).click();
        String title = driver.findElement(titleIstanbul).getText();
        Assert.assertEquals(title, "Istanbul");
    }


}
