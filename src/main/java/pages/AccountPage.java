package pages;

        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;

public class AccountPage extends ParentPage {
    @FindBy (xpath = ".//input[@id=\"FirstName\"]")
    protected WebElement inputFirstName;
    @FindBy (xpath = ".//input[@id=\"LastName\"]")
    protected WebElement inputLastName;
    @FindBy (xpath = ".//input[@id=\"City\"]")
    protected WebElement inputCity;
    @FindBy(xpath = ".//input[@id=\"ZipCode\"]")
    protected WebElement inputZipCode;
    @FindBy (xpath = ".//input[@id=\"Phone\"]")
    protected WebElement inputPhone;
    @FindBy (xpath = ".//input[@id=\"Address1\"]")
    protected WebElement inputAddress1;
    @FindBy (xpath = ".//input[@id=\"Address2\"]")
    protected WebElement inputAddress2;
    @FindBy (xpath = ".//button[@id=\"btnUpdateCustomer\"]")
    protected WebElement clickUpdateAccount;
    @FindBy (xpath = ".//a[@class=\"btn btn-default resetpass\"]")
    protected WebElement clickResetPassword;
    @FindBy (xpath = ".//*/p[contains(text(),'Updated successfully')]")
    protected WebElement updatedSuccessfully;
    @FindBy (xpath = ".//*[@class=\"btn-group bootstrap-select bs-select\"]")
    protected WebElement genderDropDown;

    public AccountPage(WebDriver webDriver) {
        super(webDriver, "/Account");
    }

    public void enterFirstName (String firstName){
        actionsWithOurElements.enterTextIntoElement(inputFirstName, firstName);
    }
    public void enterLastName (String lastName){
        actionsWithOurElements.enterTextIntoElement(inputLastName, lastName);
    }
    public void enterCity (String city){
        actionsWithOurElements.enterTextIntoElement(inputCity, city);
    }
    public void enterZipCode (String zipCode){
        actionsWithOurElements.enterTextIntoElement(inputZipCode, zipCode);
    }
    public void enterPhone (String phone){
        actionsWithOurElements.enterTextIntoElement(inputPhone, phone);
    }
    public void enterAddress1 (String address1){
        actionsWithOurElements.enterTextIntoElement(inputAddress1,address1);
    }
    public void enterAddress2 (String address2){
        actionsWithOurElements.enterTextIntoElement(inputAddress2,address2);
    }
    public void clickUpdateAccountButton (){
        actionsWithOurElements.clickOnElement(clickUpdateAccount);
    }
    public void clickResetPasswordButton (){
        actionsWithOurElements.clickOnElement(clickResetPassword);
    }
    public void isNotificationUpdatedSuccessfullyPresent (){
        actionsWithOurElements.isElementPresent(updatedSuccessfully);
    }
    public void selectGender (String text){
        actionsWithOurElements.selectValueInDropDown (genderDropDown, text);
    }
    public void selectGenderByValue (String value){
        actionsWithOurElements.selectValueInDropDownByValue (genderDropDown, value);
    }
}
//   .//select[@id="Gender"]
//  .//*[@class="btn-group bootstrap-select bs-select"]/button[@data-id="Gender"]
//  .//*[@class="btn-group bootstrap-select bs-select open"]/button[@data-id="Gender"]
//  .//ul//span[contains(text(),'Male')]//.. (Female)

