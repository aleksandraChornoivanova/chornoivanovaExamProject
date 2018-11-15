package signInTests;

        import org.junit.Test;
        import parentTest.ParentTest;

public class SignInTestWithPageObject extends ParentTest {
    @Test
    public void validSignIn() {
        homePage.openPage();
        homePage.clickSignInButton();
        homePage.enterLogIn("ac@nustay.com");
        homePage.enterPassword("111111");
        homePage.clickContinueButton();

    }
}
