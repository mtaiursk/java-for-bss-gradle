package src.test.java.ru.tsystems.tfigk.qa.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import src.test.java.ru.tsystems.tfigk.qa.selenium.AbstractBaseSeleniumTest;

public class LoginTests extends AbstractBaseSeleniumTest {
    @Test
    public void testLogin(){
        webDriver.get("https://intra.t-systems.ru/Dash");
        WebElement userNameInput = webDriver.findElement(By.cssSelector("form#loginform input#UserName"));
        userNameInput.sendKeys("mtaiursk");
    }
}
