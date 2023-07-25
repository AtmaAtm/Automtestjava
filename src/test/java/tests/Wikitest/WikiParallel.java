package tests.Wikitest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tests.base.CustomListeners;
import tests.base.CustomLoggers;

import java.util.concurrent.TimeUnit;


public class WikiParallel {

    public static WebDriver driver;

   @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
       EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
       eventFiringWebDriver.register(new CustomLoggers());
       driver = eventFiringWebDriver;
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.wikipedia.org/");
    }

    @Test (priority = 1)
    public void logoTest(){
       By logo = By.xpath("//*[@class='central-textlogo__image sprite svg-Wikipedia_wordmark']");
        WebElement logoImage = driver.findElement(logo);
        Assert.assertTrue(logoImage.isDisplayed());
    }

    @Test (priority = 2)
    public void selectLanguageArrow(){
       By languageArrow = By.xpath("//*[@id=\"searchLanguage\"]");
       driver.findElement(languageArrow).click();
       By bulgarianLanguage = By.xpath("//*[@id=\"searchLanguage\"]//option[@value=\"bg\"]");
       driver.findElement(bulgarianLanguage).click();
    }

    @AfterClass
    public void teardown(){
       driver.quit();
    }

}
