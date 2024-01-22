package example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;



    @FindBy(xpath = "//button[text()='LOG IN']")
    private WebElement logInButton;

    @FindBy(css = "button.location-icon")
    private WebElement ownerAccommodations;

    @FindBy(css = "mat-form-field.search-input input")
    private WebElement searchInput;

    public HomePage(WebDriver driver){
        this.driver=driver;

        PageFactory.initElements(driver, this);
    }

    public void clickOnLogIn(){
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(logInButton)).click();
    }

    public void clickOnOwnerAccommodations(){
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(ownerAccommodations)).click();

    }

    public void performSearch() {
        searchInput.click();
        searchInput.sendKeys("Da");
    }
}
