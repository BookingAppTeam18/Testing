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
    private WebElement getUsernameField() {
        return driver.findElement(By.name("email"));
    }

    private WebElement getPasswordField() {
        return driver.findElement(By.name("password"));
    }

    private WebElement getlogInButton() {
        return driver.findElement(By.xpath("//button[text()='Login']"));
    }

    public LogInPage(WebDriver driver, String email, String password){
        this.driver = driver;
        this.email = email;
        this.password = password;
        PageFactory.initElements(driver, this);
    }

    public void LogIn(){
        getUsernameField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getlogInButton().click();
    }
}
