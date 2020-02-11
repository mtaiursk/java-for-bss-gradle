package src.test.java.ru.tsystems.tfigk.qa.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

import static java.util.concurrent.TimeUnit.SECONDS;

public abstract class AbstractBaseSeleniumTest {
    protected WebDriver webDriver;

    private static final URL HUB_URL;

    static {
        try {
            HUB_URL = new URL("http://localhost:4444/wd/hub/");
        } catch (MalformedURLException e) {
            throw new RuntimeException("Incorrect Selenium Hub URL", e);
        }
    }
    @BeforeMethod
    public void initWebDriver(){
        webDriver =  new RemoteWebDriver(HUB_URL, new ChromeOptions());
    }

    @AfterMethod
    public void closeWebDriver(){
        if (webDriver != null){
            webDriver.quit();
        }
    }
    protected void pause() {
        try {
            Thread.sleep(SECONDS.toMillis(5));
        } catch (InterruptedException e) {

        }
    }
}
