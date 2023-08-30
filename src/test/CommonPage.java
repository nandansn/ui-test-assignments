package test;

import launch.PreauthLaunching;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import xpath.PreauthXPath;

import java.time.Duration;
import java.util.Properties;

public class CommonPage {
    public WebDriver driver;
    public Properties prop;
    PreauthLaunching obj = new PreauthLaunching();

    @BeforeClass
    void before_class() {
        this.driver = obj.driver;
        this.prop = obj.prop;
    }

    @Test
    void login_valid() {
        PreauthXPath obj2 = new PreauthXPath(driver);
        driver.get("https://portal.gomobi.io/MobiversaAdmin/");
        String Uname = prop.getProperty("uname");
        obj2.username.sendKeys(Uname);
        String Pass = prop.getProperty("pass");
        obj2.password.sendKeys(Pass);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", obj2.login);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }
    @Test
    void date_picker(){
        PreauthXPath obj2 = new PreauthXPath(driver);
        obj2.from_date.click();
        obj2.date1.click();
        obj2.date_ok1.click();
        obj2.to_date.click();
        obj2.date2.click();
        obj2.date_ok2.click();
        obj2.date_search.click();
    }
}
