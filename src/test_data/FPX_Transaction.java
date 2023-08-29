package test_data;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages_code.pages;
import java.util.List;
import java.util.Properties;

public class FPX_Transaction extends Merchant_summary {
    @Test(priority = 1)
    void access()
    {
        WebDriver driver = this.driver;
        Properties prop = this.prop;
        login_valid();
    }
    @Test(priority = 2)
    void fpx()
    {
        pages obj2 = new pages(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", obj2.Fpx_main);
        jsExecutor.executeScript("arguments[0].click();", obj2.fpx_summary);
        calendar();

    }
    @Test(priority = 3)
    void rows_validation_1()
    {
        pages obj2 = new pages(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0, 800);");
        List<WebElement> rows = driver.findElements(By.xpath("//tbody[@id=\"prodReportTable\"]/tr"));
        String actual_rows = String.valueOf(rows.size());
        String count ="20";
        if (count.equals(actual_rows)) {
            System.out.println("NO OF ROWS PRESENT MATCHES WITH DEFAULT NO OF ROWS : " + actual_rows);

        } else {
            System.out.println("MORE NO OF ROWS PRESENT IS HIGHER THAN SPECIFIED : " + actual_rows);
        }

    }

}
