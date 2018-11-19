package updateAccountTests;

        import org.junit.Test;
        import parentTest.ParentTest;

public class UpdateAccount extends ParentTest {
    @Test
    public void UpdateUserInfo(){
        homePage.userSignIn("ac@nustay.com","111111");
        homePage.checkFavouritesIsPresent();
        homePage.checkUserMenuIsPresent();
        homePage.checkIfCorrectPageIsOpened();
        homePage.clickUserMenu();
        homePage.clickYourProfileLink();
        accountPage.checkIfCorrectPageIsOpened();
        accountPage.enterFirstName("SashaTest");

        accountPage.selectGender("Male");
//        accountPage.clickUpdateAccountButton();
//        accountPage.isNotificationUpdatedSuccessfullyPresent();
    }

}
