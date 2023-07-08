package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import tests.config;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        config driver1 = new config();
        WebDriver driver = driver1.configs();


        driver.get("https://tproger.ru/articles/sposoby-ozhidanija-v-java-i-selenium/");

        By input = By.xpath("//*[@class='logo-tproger__image']");

        WebElement element  = driver.findElement(input);
        System.out.println(element.getAttribute("baseURI"));








    }
}