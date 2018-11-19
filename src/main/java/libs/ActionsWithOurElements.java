package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger;

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
    }

    public void enterTextIntoElement (WebElement webElement, String text){
        try{
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputted into element");
        }catch (Exception e){
            printErrorStopTest();
        }
    }

    public void clickOnElement (WebElement webElement){
        try{
            webElement.click();
            logger.info("Element was clicked");
        }catch (Exception e){
            printErrorStopTest();
        }
    }

    private void printErrorStopTest() {
        logger.error("Cannot work with element");
        Assert.fail("Cannot work with element");
    }

    public boolean isElementPresent(WebElement webElement) {
        try{
            return webElement.isDisplayed() && webElement.isEnabled();

        }catch (Exception e){
            return false;
        }
    }

    public void selectValueInDropDown(WebElement webElement, String text) {
        try{
            Select select = new Select(webElement);
            select.selectByVisibleText(text);
        }catch (Exception e){
            printErrorStopTest();
        }
    }
    public void selectValueInDropDownByValue (WebElement webElement, String value) {
        try{
            Select select = new Select(webElement);
            select.selectByValue(value);
        }catch (Exception e){
            printErrorStopTest();
        }
    }
}
