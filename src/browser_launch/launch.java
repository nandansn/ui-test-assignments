package browser_launch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

public class launch {
    public static WebDriver driver;
    public static Properties prop;
    static{
        try {
            String fileName = "add.properties";
            URL resourceUrl = launch.class.getClassLoader().getResource(fileName);
            String filePath = resourceUrl.getPath();
            FileInputStream stream = new FileInputStream(filePath);
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
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
