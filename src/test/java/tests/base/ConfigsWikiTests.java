package tests.base;

import com.beust.jcommander.Parameter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
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


    @Parameters ("word")
    public void searchField (@Optional("Ukraine") String word){
        driver.findElement(infoInput).click();
        driver.findElement(infoInput).sendKeys(word, Keys.ENTER);
    }
}
