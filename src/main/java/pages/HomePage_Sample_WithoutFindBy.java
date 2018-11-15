package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage_Sample_WithoutFindBy extends ParentPage{


    public HomePage_Sample_WithoutFindBy(WebDriver webDriver) {
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
        WebElement inputLogIn = webDriver.findElement(By.xpath(".//*[@class=\"wizard-page sign-in\"]//input[@id=\"email\"]"));
        actionsWithOurElements.enterTextIntoElement(inputLogIn, login);
    }

    public void enterPassword (String password){
        WebElement inputPassword = webDriver.findElement(By.xpath(".//*[@class=\"wizard-page sign-in\"]//input[@type=\"password\"]"));
        actionsWithOurElements.enterTextIntoElement(inputPassword, password);
    }

    public void clickSignInButton (){
        WebElement clickSignIn = webDriver.findElement(By.xpath(".//button[@onclick=\"SignupService.Signin();\"]"));
        actionsWithOurElements.clickOnElement(clickSignIn);
    }
    public void clickContinueButton (){
        WebElement clickContinue = webDriver.findElement(By.xpath(".//*[@class=\"wizard-page sign-in\"]//button[@id=\"btnContinue\"]"));
        actionsWithOurElements.clickOnElement(clickContinue);
    }
}


