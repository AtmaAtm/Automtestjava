package tests;
/* "1. Открыть страницу rozetka.com (окно должно быть в полный экран)
2. Ввести в поиске ""iPhone"" и нажать кнопку поиска
3. Дождаться загрузки страницы и забрать со страницы текст ""Мобильные телефоны Apple"" (слева сверху)
4. Перейти на начальную страницу
5. В поле поиска ввести текст, полученный в шаге 3 и снова нажать кнопку поиска
6. В конце теста окно браузера должно быть автоматически закрыто

Все елементы нужно искать по xPath"

 */

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class test7 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://rozetka.com.ua/ua/");


        By input = By.xpath("/html/body/app-root/div/div/rz-header/rz-main-header/header/div/div/div/form/div/div/input");
        By input1 = By.xpath("/html/body/app-root/div/div/rz-category/div/main/div[1]/div/h1");
        By input2 = By.xpath("/html/body/app-root/div/div/rz-header/rz-main-header/header/div/div/a/picture/img");
        WebElement element = driver.findElement(input);
        element.click();
        element.sendKeys("iPhone", Keys.ENTER);
        element = driver.findElement(input1);
        String textFromRozetka = element.getText();
        element = driver.findElement(input2);
        element.click();
        element = driver.findElement(input);
        element.click();
        element.sendKeys(textFromRozetka, Keys.ENTER);
        driver.close();



    }
}