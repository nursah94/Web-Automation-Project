package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.util.Properties;

public class TestBase {

    private static Properties prop;
    protected WebDriver driver;

    private static String propertiesFilePath = System.getProperty("user.dir") + "/src/main/java/config/config.properties";

    public TestBase(WebDriver driver) {
        this.driver = driver;
    }

    public static Properties prop() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(propertiesFilePath);
            prop.load(ip);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    }
}
