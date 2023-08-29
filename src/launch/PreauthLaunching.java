package launch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.util.Properties;

public class PreauthLaunching {
    public static WebDriver driver;
    public static Properties prop;
    static {
        try {
            FileInputStream stream = new FileInputStream("C:\\Users\\karuna\\IdeaProjects\\Pre_Auth\\src\\preeauth.properties");
            prop = new Properties();
            prop.load(stream);
            String Browser = prop.getProperty("browser");
            String location = prop.getProperty("driver_location");
            if (Browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", location);
                ChromeOptions op = new ChromeOptions();
                op.addArguments("--remote-allow-origins=*");
                op.addArguments("start-maximized");
                driver = new ChromeDriver(op);
            }

        }
        catch (Exception a) {
            a.printStackTrace();
        }
    }
}