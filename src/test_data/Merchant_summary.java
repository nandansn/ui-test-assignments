package test_data;
import browser_launch.launch;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages_code.pages;
import java.time.Duration;
import java.util.List;
import java.util.Properties;


public class Merchant_summary {

    public WebDriver driver;
    public Properties prop;
    launch obj1 = new launch();

    @BeforeClass
    void before_class() {
        this.driver = obj1.driver;
        this.prop = obj1.prop;
    }

    @Test(priority = 1)
    void login_valid() {
        pages obj2 = new pages(driver);
        driver.get("https://portal.gomobi.io/MobiversaAdmin/");
        String Uname = prop.getProperty("uname");
        obj2.username.sendKeys(Uname);
        String Pass = prop.getProperty("pass");
        obj2.password.sendKeys(Pass);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", obj2.login);
    }

    @Test(priority = 3)
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

    @Test(priority = 2)
    void merchant_summary() {
        pages obj2 = new pages(driver);
        obj2.icon.click();
        obj2.merchant.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        obj2.summary.click();
    }

    @Test(priority = 4)
    void rows_validation() {
        pages obj2 = new pages(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0, 800);");
        List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr[@role=\"row\"]"));
        String actual_rows = String.valueOf(rows.size());
        Select dd = new Select(obj2.dropdown);
        dd.selectByVisibleText("10");
        String count = dd.getFirstSelectedOption().getText();
        //int selectedCount = Integer.parseInt(count);
        if (count.equals(actual_rows)) {
            System.out.println("HOLDS ROWS PER PAGE RIGHT : " + actual_rows);

        } else {
            System.out.println("HOLDS ROWS MORE THAN SPECIFIED NUMBER IN ROWS PER PAGE : " + actual_rows);
        }
    }
}


