package tests.TranslatorTest;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import tests.base.dataProviderMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class testoncons {

    public static WebDriver driver;
    public static WebElement element;

  @BeforeClass
   public void setDriver () {
       System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
       driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
       driver.manage().window().maximize();
       driver.get("https://www.wikipedia.org/");
   }
//   @Parameters ("titleForCat")
//   @Test
//   public void testLogo (@Optional("Cat") String titleForCat){
//      By input1 = By.xpath("//*[@class='central-textlogo__image sprite svg-Wikipedia_wordmark']");
//      WebElement logo = driver.findElement(input1);
//      Assert.assertTrue(logo.isDisplayed(), "Logo is not found");
//      String title = driver.getTitle();
//      Assert.assertEquals(title, "Wikipedia", "Title is not the same");
//      By input2 = By.xpath("//*[@id='searchInput']");
//      driver.findElement(input2).sendKeys(titleForCat, Keys.ENTER);
//      String titleCat = driver.findElement(By.xpath("//*[@class='mw-page-title-main']")).getText();
//      Assert.assertEquals(titleCat, "Cat", "Not similar");
//
//   }

   @DataProvider(name = "CatProvider")
    public Object[][] getData(){
      return new Object[][]{
              {"Cat"},
              {"Dog"}
      };
   }
   @Test (dataProvider = "CatProvider")
   public void checkInput(String input){
       By input2 = By.xpath("//*[@id='searchInput']");
       driver.findElement(input2).sendKeys(input, Keys.ENTER);
       driver.findElement(By.xpath("//*[@class='mw-logo-wordmark']")).click();
       By element1  = By.xpath("//*[@id='p-search']");
       WebElement element2 = driver.findElement(element1);
       WebDriverWait wait = new WebDriverWait(driver, 10);
       wait.until(ExpectedConditions.visibilityOf(element2));


   }


}
