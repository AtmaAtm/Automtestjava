package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();

        driver.get("https://google.com");

        By input = By.xpath("//*[@id='W0wltc']/div");
        By input1 = By.xpath("//*[@id='APjFqb']");
        By input2 = By.xpath("//*[@id='Odp5De']/div/div[1]/div/div[1]/block-component/div/div[1]/div/div/div/div/div[1]/div/div/div/div/div[1]/div/span/span");
        WebElement element  = driver.findElement(input);
        element.click();

        element = driver.findElement(input1);
        element.sendKeys("cats", Keys.ENTER);
        element.submit();
        element = driver.findElement(input2);






    }
}