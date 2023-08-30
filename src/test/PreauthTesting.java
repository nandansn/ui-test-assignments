package test;

import launch.PreauthLaunching;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import xpath.PreauthXPath;


import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class PreauthTesting extends CommonPage {



    @Test
    void login_valid_preauth() {
        WebDriver driver=this.driver;
        Properties prop=this.prop;
        login_valid();
    }
    @Test
    void process(){
        PreauthXPath obj2 = new PreauthXPath(driver);
        obj2.icon.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", obj2.preauth);
        date_picker();
        List<WebElement> rows=driver.findElements(By.xpath("//tbody/tr[@role=\"row\"]"));
        String actual_rows= String.valueOf(rows.size());

        Select d_d=new Select(obj2.droup_down);
        d_d.selectByVisibleText("10");
        String count=d_d.getFirstSelectedOption().getText();


        if (actual_rows.equals(count)){
            System.out.println("HOLDS ROWS PER PAGE RIGHT : " + actual_rows);
        }
        else {
            System.out.println("HOLDS ROWS MORE THAN SPECIFIED NUMBER IN ROWS PER PAGE : " + actual_rows);
        }
    }
}


