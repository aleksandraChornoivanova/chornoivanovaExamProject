package signInTests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignIn {
   WebDriver webDriver =  new ChromeDriver();

    @Test

    public void validSignIn (){
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        webDriver.get("https://nustay.com/");
        webDriver.quit();
    }
}
