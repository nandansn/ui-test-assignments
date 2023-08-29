package test_data;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages_code.pages;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class Merchant_summary extends Common{

    @Test(priority = 1)
    void common_access()
    {
        WebDriver driver = this.driver;
        Properties prop = this.prop;
        login_valid();
    }

    @Test(priority = 2)
    void merchant_summary() {
        pages obj2 = new pages(driver);
        obj2.icon.click();
        obj2.merchant.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        obj2.summary.click();
        calendar();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0, 800);");
        List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr[@role=\"row\"]"));
        String actual_rows = String.valueOf(rows.size());
        //int select_rows = Integer.parseInt(actual_rows);

        Select dd = new Select(obj2.dropdown);
        dd.selectByVisibleText("10");
        String count = dd.getFirstSelectedOption().getText();
        //int select_count = Integer.parseInt(count);

        if(actual_rows.equals(count))
        {
            System.out.println("HOLDS ROWS PER PAGE LESSER THAN OR EQUAL TO  : " + actual_rows);
        }
       /* else {
            System.out.println("HOLDS ROWS MORE THAN SPECIFIED NUMBER IN ROWS PER PAGE : " + actual_rows);
        }
       */
    }

}


