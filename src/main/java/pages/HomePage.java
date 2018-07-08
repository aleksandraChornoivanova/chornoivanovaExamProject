package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends ParentPage{


    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPage () {
        try {
            webDriver.get("https://nustay.com/");
            logger.info("Home Page was opened");
        }catch (Exception e){
            logger.error("Cannot open HomePage");
            Assert.fail("Cannot open HomePage");
        }
    }

    public void enterLogIn (String login){
        WebElement inputLogIn = webDriver.findElement(By.xpath(".//button[@onclick=\"SignupService.Signin();\"]"));
        actionsWithOurElements.enterTextIntoElement(inputLogIn, login);
    }
}
