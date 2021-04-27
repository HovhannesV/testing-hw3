package base;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;

import java.io.IOException;
import com.google.common.io.Files;
import utils.EventReporter;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected EventFiringWebDriver webDriver;
    static {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
    }
    private String screenshotDir = "/tmp/failed_screens-" + this.getClass().getName();
    @BeforeClass
    public void setupScreenshotDir() throws Exception {
        File directory = new File(screenshotDir);
        if (!directory.exists()){
            directory.mkdir();
        }
        FileUtils.cleanDirectory(directory);
    }

    @BeforeMethod
    public void setupChromeDriver() {
        webDriver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        webDriver.register(new EventReporter());
        webDriver.get("https://imdb.com/");
    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus())
        {
            TakesScreenshot camera = (TakesScreenshot)webDriver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                String screenshotPath = screenshotDir + "/" + result.getName() + ".png";
                System.out.println("Saving to failed screenshot to " + screenshotPath);
                Files.move(screenshot, new File(screenshotPath));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        clearUp();
    }


    public void clearUp() {
        webDriver.quit();
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        return options;
    }
}
