package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage extends TestBase {

    private final static String textMyAccount = "//div[@class='header__right-col']//span[@class='user-menu__title'][contains(text(),'My Account')]";

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    // Checks if the user successfully logged in
    public void checkMyAccountText() throws InterruptedException {
        Thread.sleep(2000);
        String text = driver.findElement(By.xpath(textMyAccount)).getText();
        Assert.assertEquals("My Account", text);
    }

    public void checkPopUpOnHomePage() {
        try {
            driver.findElement(By.xpath("//span[@class='icon-close']")).click();
        } catch (NoSuchElementException ignored) {
        }
    }

}
