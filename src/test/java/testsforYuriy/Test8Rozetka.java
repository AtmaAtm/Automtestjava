package testsforYuriy;
//"Переписать Test 7 под следующий вид:
//        - Вынести шаги теста (начиная с открытия страницы) в @Test (junit)
//- Вынести все что находится до @Test в @BeforeClass (junit)
//- Вынести все xPath в отдельный класс page и заменить все xPath в тесте на работу с page обьектом
//        - Закрытие WebDriver должно быть всегда, вне зависимости от того failed тест или passed"

import CommonAction.CommonAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;
import testsforYuriy.page;

public class Test8Rozetka {

    public static page page;
    public static WebDriver driver;

    @BeforeClass
    public void activitiesBefore() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        page = new page(driver);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/ua/");

    }

    @Test
    public void searchField() {
        page.searchField();
        page.locateText();

    }

    @AfterClass(alwaysRun = true)
    public void end() {
        page.endTest();
    }

}








