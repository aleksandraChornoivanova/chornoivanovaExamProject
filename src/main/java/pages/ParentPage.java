package pages;

        import libs.ActionsWithOurElements;
        import org.apache.log4j.Logger;
        import org.junit.Assert;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.support.PageFactory;


public class ParentPage {

    Logger logger = Logger.getLogger(getClass());
    ActionsWithOurElements actionsWithOurElements;
    WebDriver webDriver;
    String expectedUrl;
    final String baseUrl = "https://nustay.com";

    public ParentPage(WebDriver webDriver, String pageUrl) {
        this.webDriver = webDriver;
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
        PageFactory.initElements(webDriver, this);
        this.expectedUrl = baseUrl + pageUrl;
    }
    public String getCurrentUrl(){
        return webDriver.getCurrentUrl();
    }

    public void checkIfCorrectPageIsOpened(){
        try {
            Assert.assertEquals("URL is not expected", expectedUrl, getCurrentUrl());
        }catch (Exception e){
            logger.error("Cannot get URL");
            Assert.fail("Cannot get URL");
        }
    }

}
