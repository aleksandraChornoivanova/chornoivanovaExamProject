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
        checkAcceptanceCriteria("Favourites tab is not present", homePage.isFavouritesPresent(),true);
        checkAcceptanceCriteria("User menu is not present", homePage.isUserMenuPresent(),true);

    }

    @Test
    public void invalidSignIn(){
        homePage.userSignIn("ac@nustay.com", "111122");
        checkAcceptanceCriteria("Favourites tab should not be present", homePage.isFavouritesPresent(),false);
        checkAcceptanceCriteria("User menu should not be present", homePage.isUserMenuPresent(),false);
    }
}
