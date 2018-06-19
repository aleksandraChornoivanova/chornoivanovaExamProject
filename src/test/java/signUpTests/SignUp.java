package signUpTests;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class SignUp {
    WebDriver webDriver;
    @Before
    public void setUp (){
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
    }

    @Test

    public void validSignUp (){
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        webDriver.get("https://nustay.com/");
        webDriver.findElement(By.xpath(".//button[@onclick=\"SignupService.Signup();\"]")).click();
        webDriver.findElement(By.xpath(".//div[@class=\"wizard-page sign-up\"]//input[@type=\"email\"]")).sendKeys("examproject@ukr.net");
        webDriver.findElement(By.xpath(".//div[@class=\"wizard-page sign-up\"]//button[@id=\"btnContinue\"]")).click();
        webDriver.findElement(By.xpath(".//*[@class=\"wizard-page email-sign-up\"]//input[@placeholder=\"Your password\"]")).sendKeys("111111");
        webDriver.findElement(By.xpath(".//*[@class=\"wizard-page email-sign-up\"]//input[@placeholder=\"Confirm password\"]")).sendKeys("111111");
        webDriver.findElement(By.xpath(".//*[@class=\"wizard-page email-sign-up\"]//input[@id=\"cbTerms\"]")).click();
        webDriver.findElement(By.xpath(".//*[@class=\"wizard-page email-sign-up\"]//button[@id=\"btnContinue\"]")).click();
        webDriver.findElement(By.xpath(".//*[@class=\"wizard-page welcome\"]//button[@class=\"btn btn-primary\"]")).click();
        //check if favourites and user menu are present
        Assert.assertTrue("Favourites tab is not present",
                isFavouritesPresent());
        Assert.assertTrue("User menu is not present",
                isUserMenuPresent());
    }

    @After
    public void tearDown (){
//        webDriver.quit();
    }

    //created private methods for catching any exceptions like element was not found and return false in this case
    private boolean isFavouritesPresent (){
        try {
            return webDriver.findElement(By.xpath(".//a[@class=\"menu__item menu__item--favorites\"]")).isDisplayed();
        }catch (Exception e ){
            return false;
        }
    }

    private boolean isUserMenuPresent (){
        try {
            return webDriver.findElement(By.xpath(".//button[@class=\"user\"]")).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
}

// не нажимается чекбокс

