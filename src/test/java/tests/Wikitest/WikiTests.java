package tests.Wikitest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.base.ConfigsWikiTests;

import java.util.concurrent.TimeUnit;

public class WikiTests {

    public static ConfigsWikiTests ConfigsWikiTests;
    public static WebDriver driver;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        ConfigsWikiTests = new ConfigsWikiTests(driver);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.wikipedia.org/");
    }

    @Test (priority = 1)
    public void testSearchField(){
        ConfigsWikiTests.searchField("Ukraine");

    }

    @Test (priority = 2)
    public void testFlagPresence(){
        ConfigsWikiTests.verifyFlag();
    }

    @Test (priority = 3)
    public void newInputInSearch(){
        ConfigsWikiTests.newInputOdesa();
    }

    @Test (priority = 4)
    public void newTitleIstanbul (){
        ConfigsWikiTests.setTwinTowns();
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}


