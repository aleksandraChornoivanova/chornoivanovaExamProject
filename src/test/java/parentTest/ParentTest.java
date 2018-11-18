package parentTest;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AccountPage;
import pages.HomePage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {
    Logger logger = Logger.getLogger(getClass());
    WebDriver webDriver;
   protected HomePage homePage;
   protected AccountPage accountPage;

    @Before
    public void setUp (){
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        homePage = new HomePage(webDriver);
        accountPage = new AccountPage(webDriver);
    }

    @After

    public void tearDown (){
        webDriver.quit();
    }

    protected void checkAcceptanceCriteria (String message, boolean actual, boolean expected){
        if (!(actual == expected)){
            logger.error("Acceptance Criteria failed: " + message);
        }
        Assert.assertEquals(message, expected, actual);

    }
}
