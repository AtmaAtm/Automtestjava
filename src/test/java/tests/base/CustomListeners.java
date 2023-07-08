package tests.base;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static tests.Wikitest.WikiParallel.driver;

public class CustomListeners implements ITestListener {


    @Override
        public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
        }
//public void takeScreenshot (String screen, WebDriver driver){
//    File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);





    @Override
    public void onTestFailure(ITestResult result) {
        Allure.getLifecycle().addAttachment("screenshot", "image/png", "png",
                ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));

    }
}



