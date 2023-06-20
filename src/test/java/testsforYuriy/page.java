package testsforYuriy;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class page {

    public WebDriver driver;

    public page(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    By input = By.xpath("//*[@name='search']");
    By input1 = By.xpath("//*[@class='catalog-heading ng-star-inserted']");
    By input2 = By.xpath("//*[@alt='Rozetka Logo']");


    public void searchField() {

        driver.get("https://rozetka.com.ua/ua/");
        driver.findElement(input).click();
        driver.findElement(input).sendKeys("iPhone", Keys.ENTER);
    }


    public void locateText() {
//      WebDriverWait wait = new WebDriverWait(driver, 10);
//      wait.until(ExpectedConditions.visibilityOf((WebElement) input1));

        String getText1 = driver.findElement(input1).getText();
        driver.findElement(input2).click();
        driver.findElement(input).click();
        driver.findElement(input).sendKeys(getText1, Keys.ENTER);

   }
    public void endTest() {
        driver.quit();
    }
}
