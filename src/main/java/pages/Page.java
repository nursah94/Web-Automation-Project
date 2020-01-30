package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Objects;

public class Page extends TestBase {

    public Page(WebDriver driver) {
        super(driver);
    }

    private final static String inputEmail = "//input[@id='EmailLogin']";
    private final static String inputPassword = "//input[@id='Password']";
    private final static String buttonSignIn = "//button[@class='btn btn-primary btn-lg pull-right login__btn js-login-button']";
    private final static String popUpModal = "//div[@class='modal-body']";
    private final static String popUpCloseButton = "//button[@class='btn btn-primary']";
    private final static String messageRequiredFields = "//span[@id='EmailLogin-error']";
    private final static String textMyAccount = "//div[@class='header__right-col']//span[@class='user-menu__title'][contains(text(),'My Account')]";

    // Opens lolaflora.com/login
    public void goToLoginPage() {
        driver.get(Objects.requireNonNull(prop()).getProperty("loginUrl"));
    }

    // Fills email field with given email
    public void fillEmailInput(String email) {
        driver.findElement(By.xpath(inputEmail)).clear();
        driver.findElement(By.xpath(inputEmail)).sendKeys(email);
    }

    // User fills password field with given password
    public void fillPasswordInput(String password) {
        driver.findElement(By.xpath(inputPassword)).clear();
        driver.findElement(By.xpath(inputPassword)).sendKeys(password);
    }

    // User clicks sign in button
    public void clickSignInButton() {
        driver.findElement(By.xpath(buttonSignIn)).click();
    }

    // Verify that 'E-mail or password is incorrect.Please check your information and try again.' pop-up open
    public void verifyAndClosePopUp() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(popUpModal)).isDisplayed();
        driver.findElement(By.xpath(popUpCloseButton)).click();
    }

    // Checks for 'Required field.' error is displayed under the inputs
    public void checkRequiredFieldError() {
        driver.findElement(By.xpath(messageRequiredFields)).isDisplayed();
    }

    // Checks if the user successfully logged in
    public void checkMyAccountText() throws InterruptedException {
        Thread.sleep(2000);
        String text = driver.findElement(By.xpath(textMyAccount)).getText();
        Assert.assertEquals("My Account", text);
    }
}

