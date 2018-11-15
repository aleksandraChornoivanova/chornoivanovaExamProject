package pages;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage{
    @FindBy (xpath = ".//*[@class=\"wizard-page sign-in\"]//input[@id=\"email\"]")
    private WebElement inputLogIn;

    @FindBy (xpath = ".//*[@class=\"wizard-page sign-in\"]//input[@type=\"password\"]")
    private WebElement inputPassword;

    @FindBy (xpath = ".//button[@onclick=\"SignupService.Signin();\"]")
    private WebElement clickSignIn;

    @FindBy (xpath = ".//*[@class=\"wizard-page sign-in\"]//button[@id=\"btnContinue\"]")
    private WebElement clickContinue;


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
        actionsWithOurElements.enterTextIntoElement(inputLogIn, login);
    }

    public void enterPassword (String password){
       actionsWithOurElements.enterTextIntoElement(inputPassword, password);
    }

    public void clickSignInButton (){
       actionsWithOurElements.clickOnElement(clickSignIn);
    }
    public void clickContinueButton (){
        actionsWithOurElements.clickOnElement(clickContinue);
    }
}


