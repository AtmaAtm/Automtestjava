package tests.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.UUID;

public class CustomLoggers extends AbstractWebDriverEventListener {

    private static final String SCREENSHOT_LOCATION = "C:/Java/Automtestjava/build/allure-results";

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        String messageId = UUID.randomUUID().toString();
        System.out.println(messageId + " : Navigating to [" + url + "] with driver [" + driver + "]");
        takeScreenShot(messageId, driver);
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        String messageId = UUID.randomUUID().toString();
        System.out.println(messageId + " : Try to locate element using [" + by + "] and driver [" + driver + "] and element [" + element + "]");
        takeScreenShot(messageId, driver);
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        String messageId = UUID.randomUUID().toString();
        System.out.println(messageId + " : Clicking element [" + element + "] with driver [" + driver + "]");
        takeScreenShot(messageId, driver);
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        String messageId = UUID.randomUUID().toString();
        System.out.println(messageId + " : Clicked element [" + element + "] with driver [" + driver + "]");
        takeScreenShot(messageId, driver);
    }

    private void takeScreenShot(String name, WebDriver driver){
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileChannel srcChannel = new FileInputStream(src).getChannel();
            File dst = new File(SCREENSHOT_LOCATION, name + ".png");
            FileChannel dstChannel = new FileOutputStream(dst).getChannel();
            dstChannel.transferFrom(srcChannel, 0, srcChannel.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
