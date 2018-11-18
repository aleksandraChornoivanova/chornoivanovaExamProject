package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
}
