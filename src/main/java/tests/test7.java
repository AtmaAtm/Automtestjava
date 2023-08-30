package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class test7 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        driver.get("https://rozetka.com.ua/ua/");



        By input = By.xpath("//*[@name='search']");
        By input1 = By.xpath("//*[@class='catalog-heading ng-star-inserted']");
        By input2 = By.xpath("//*[@alt='Rozetka Logo']");

        WebElement element = driver.findElement(input);
        element.click();
        element.sendKeys("iPhone", Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver,10);

        element = driver.findElement(input1);
        String textFromRozetka = element.getText();
        WebDriverWait wait1 = new WebDriverWait(driver,10);
        element = driver.findElement(input2);
        element.click();
        element = driver.findElement(input);
        element.click();
        element.sendKeys(textFromRozetka, Keys.ENTER);
        driver.close();

    }
}