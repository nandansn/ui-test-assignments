package test_data;
import browser_launch.launch;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import pages_code.pages;
import java.util.Properties;

public class Common {
    public WebDriver driver;
    public Properties prop;
    launch obj1 = new launch();

    @BeforeClass
    void before_class() {
        this.driver = obj1.driver;
        this.prop = obj1.prop;
    }

    void login_valid() {
        WebDriver driver = this.driver;
        Properties prop = this.prop;
        pages obj2 = new pages(driver);
        driver.get("https://portal.gomobi.io/MobiversaAdmin/");
        String Uname = prop.getProperty("uname");
        obj2.username.sendKeys(Uname);
        String Pass = prop.getProperty("pass");
        obj2.password.sendKeys(Pass);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", obj2.login);
    }
    void calendar() {
        pages obj2 = new pages(driver);
        obj2.calender_1.click();
        obj2.from_date.click();
        obj2.ok_1.click();
        obj2.calender_2.click();
        obj2.to_date.click();
        obj2.ok_2.click();
        obj2.search.click();
    }
}
