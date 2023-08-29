package test;

import launch.PreauthLaunching;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import xpath.PreauthXPath;


import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class testing {
    public WebDriver driver;
    public Properties prop;
    PreauthLaunching la=new PreauthLaunching();


    @BeforeClass
    void before_class() {
        this.driver = la.driver;
        this.prop = la.prop;
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
        obj2.icon.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        jsExecutor.executeScript("arguments[0].click();", obj2.preauth);
        obj2.from_date.click();
        obj2.date1.click();
        obj2.date_ok1.click();
        obj2.to_date.click();
        obj2.date2.click();
        obj2.date_ok2.click();
        obj2.date_search.click();
    }
    @Test
        void validation(){
            PreauthXPath obj2 = new PreauthXPath(driver);
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            List<WebElement> rows=driver.findElements(By.xpath("//tbody/tr[@role=\"row\"]"));
            String actual_rows= String.valueOf(rows.size());
            Select d_d=new Select(obj2.droup_down);
            d_d.selectByVisibleText("10");
            String count=d_d.getFirstSelectedOption().getText();
            if (count.equals(actual_rows)) {
                System.out.println("HOLDS ROWS PER PAGE RIGHT : " + actual_rows);

            } else {
                System.out.println("HOLDS ROWS MORE THAN SPECIFIED NUMBER IN ROWS PER PAGE : " + actual_rows);
            }
        }
    }


