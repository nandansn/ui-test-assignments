package pages_code;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class pages {

    public static WebDriver driver;

    public pages(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@name=\"username\"]")
    public WebElement username;
    @FindBy(xpath = "//input[@type=\"password\"]")
    public WebElement password;
    @FindBy(xpath = "//button[@id=\"btnValid\"]")
    public WebElement login;
    @FindBy(xpath = "//a[@class=\"brand-logo nav-toggle\"]")
    public WebElement icon;
    @FindBy(xpath = "(//span[contains(text(),\"Merchant\")])[1]")
    public WebElement merchant;
    @FindBy(xpath = "(//span[contains(text(),\"Merchant Summary\")])[1]")
    public WebElement summary;
    @FindBy(xpath = "//input[@id=\"from\"]")
    public WebElement calender_1;
    @FindBy(xpath = "//button[@data-day=\"1\"]")
    public WebElement from_date;
    @FindBy(xpath = "//input[@class=\"datepicker\"]")
    public WebElement calender_2;
    @FindBy(xpath = "(//button[@data-day=\"15\"])[2]")
    public WebElement to_date;
    @FindBy(xpath = "(//button[contains(text(),\"Ok\")])[1]")
    public WebElement ok_1;
    @FindBy(xpath = "(//button[contains(text(),\"Ok\")])[2]")
    public WebElement ok_2;
    @FindBy(xpath = "//button[contains(text(),\"search\")]")
    public WebElement search;
    @FindBy(xpath = "//select[@name=\"data_list_table_length\"]")
    public WebElement dropdown;
    @FindBy(xpath = "(//span[contains(text(),\"FPX\")])[1]")
    public WebElement Fpx_main;
    @FindBy(xpath = "(//span[contains(text(),\"FPX\")])[3]")
    public WebElement fpx_summary;





}
