package ciceksepeti.web.test;

import base.TestBase;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.Page;

import java.util.Objects;

public class TestCases extends BaseTest {

    // Case: Successfully sign-in")
    @Test(priority = 4)
    public void successSignIn() throws InterruptedException {
        Page page = new Page(driver,wait);
        HomePage homePage = new HomePage(driver,wait);
        page.goToLoginPage();
        page.fillEmailInput(Objects.requireNonNull(TestBase.prop()).getProperty("email"));
        page.fillPasswordInput(Objects.requireNonNull(TestBase.prop()).getProperty("password"));
        page.clickSignInButton();
        homePage.checkPopUpOnHomePage();
        homePage.checkMyAccountText();
    }

    // Case: Unsuccessfully sign-in with incorrect password")
    @Test(priority = 3)
    public void unSuccessfullySignIn() throws InterruptedException {
        Page page = new Page(driver,wait);
        page.goToLoginPage();
        page.fillEmailInput(Objects.requireNonNull(TestBase.prop()).getProperty("email"));
        page.fillPasswordInput(Objects.requireNonNull(TestBase.prop()).getProperty("inCorrect"));
        page.clickSignInButton();
        page.verifyAndClosePopUp();
    }

    // Case: The user must enter a valid email address.")
    @Test(priority = 2)
    public void signInWithInvalidEmail() throws InterruptedException {
        Page page = new Page(driver,wait);
        page.goToLoginPage();
        page.fillEmailInput(Objects.requireNonNull(TestBase.prop()).getProperty("invalidEmail"));
        page.fillPasswordInput(Objects.requireNonNull(TestBase.prop()).getProperty("password"));
        page.clickSignInButton();
        page.verifyAndClosePopUp();
    }

    // Case: if the user does not fill in the required fields 'Required field.' is displayed under the e-mail and password fields")
    @Test(priority = 1)
    public void unSuccessfullySignInBlankFields() {
        Page page = new Page(driver,wait);
        page.goToLoginPage();
        page.clickSignInButton();
        page.checkRequiredFieldError();
    }
}
