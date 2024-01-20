package example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage {

    private WebDriver driver;


    private String email = "owner@gmail.com";
    private String password = "123";

    public LogInPage(WebDriver driver, String email, String password){
        this.driver = driver;
        this.email = email;
        this.password = password;
        PageFactory.initElements(driver, this);
    }
}
