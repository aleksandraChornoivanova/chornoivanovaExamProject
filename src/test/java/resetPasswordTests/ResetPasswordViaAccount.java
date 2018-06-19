package resetPasswordTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ResetPasswordViaAccount {
    WebDriver webDriver;

    @Before
    public void setUp() {
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
    }

    @Test

    public void resetPassViaAccount() {
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        webDriver.get("https://nustay.com/");
        webDriver.findElement(By.xpath(".//button[@id=\"agreeCookiesBtn\"]")).click();
        webDriver.findElement(By.xpath(".//button[@onclick=\"SignupService.Signin();\"]")).click();
        webDriver.findElement(By.xpath(".//*[@class=\"wizard-page sign-in\"]//input[@id=\"email\"]")).sendKeys("ac@nustay.com");
        webDriver.findElement(By.xpath(".//*[@class=\"wizard-page sign-in\"]//input[@type=\"password\"]")).sendKeys("111111");
        webDriver.findElement(By.xpath(".//*[@class=\"wizard-page sign-in\"]//button[@id=\"btnContinue\"]")).click();

        webDriver.findElement(By.xpath(".//button[@class=\"user\"]")).click();
        webDriver.findElement(By.xpath(".//div[@class=\"dropdown user-menu open\"]//a[@href=\"/Account\"]")).click();
        webDriver.findElement(By.xpath(".//div[@class=\"actions text-center\"]//a[@class=\"btn btn-default resetpass\"]")).click();
        webDriver.findElement(By.xpath(".//input[@id=\"OldPassword\"]")).sendKeys("111111");
        webDriver.findElement(By.xpath(".//input[@id=\"NewPassword\"]")).sendKeys("121212");
        webDriver.findElement(By.xpath(".//input[@id=\"RetypedNewPassword\"]")).sendKeys("121212");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDriver.findElement(By.xpath(".//button[@id=\"btnChangePasswordSubmit\"]")).click();
        Assert.assertTrue("Alert password is changed successfully is present",
                isAlertPresent());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDriver.findElement(By.xpath(".//button[@class=\"user\"]")).click();
        webDriver.findElement(By.xpath(".//div[@class=\"dropdown user-menu open\"]//a[@href=\"/account/logout\"]")).click();
        webDriver.findElement(By.xpath(".//button[@onclick=\"SignupService.Signin();\"]")).click();
        webDriver.findElement(By.xpath(".//*[@class=\"wizard-page sign-in\"]//input[@id=\"email\"]")).sendKeys("ac@nustay.com");
        webDriver.findElement(By.xpath(".//*[@class=\"wizard-page sign-in\"]//input[@type=\"password\"]")).sendKeys("121212");
        webDriver.findElement(By.xpath(".//*[@class=\"wizard-page sign-in\"]//button[@id=\"btnContinue\"]")).click();

        Assert.assertTrue("Favourites tab is not present",
                isFavouritesPresent());
        Assert.assertTrue("User menu is not present",
                isUserMenuPresent());

    }

    @After

    public void tearDown() {

        webDriver.findElement(By.xpath(".//button[@class=\"user\"]")).click();
        webDriver.findElement(By.xpath(".//div[@class=\"dropdown user-menu open\"]//a[@href=\"/Account\"]")).click();
        webDriver.findElement(By.xpath(".//a[@class=\"btn btn-default resetpass\"]")).click();
        webDriver.findElement(By.xpath(".//input[@id=\"OldPassword\"]")).sendKeys("121212");
        webDriver.findElement(By.xpath(".//input[@id=\"NewPassword\"]")).sendKeys("111111");
        webDriver.findElement(By.xpath(".//input[@id=\"RetypedNewPassword\"]")).sendKeys("111111");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDriver.findElement(By.xpath(".//button[@id=\"btnChangePasswordSubmit\"]")).click();
        Assert.assertTrue("Alert password is changed successfully is present",
                isAlertPresent());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDriver.findElement(By.xpath(".//button[@class=\"user\"]")).click();
        webDriver.findElement(By.xpath(".//div[@class=\"dropdown user-menu open\"]//a[@href=\"/account/logout\"]")).click();
        webDriver.quit();
    }

    //created private methods for catching any exceptions like element was not found and return false in this case
    private boolean isAlertPresent() {
        try {
            return webDriver.findElement(By.xpath(".//div[@class=\"noty_bar noty_type_alert\"]//p")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
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
