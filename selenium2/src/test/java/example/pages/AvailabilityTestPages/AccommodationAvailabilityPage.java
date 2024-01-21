package example.pages.AvailabilityTestPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccommodationAvailabilityPage {
    private WebDriver driver;


    // Vaš postojeći kod...

    @FindBy(id = "mat-date-range-input") // Id atribut za unos datuma
    private WebElement dateRangeInput;


    @FindBy(xpath = "//input[@matstartdate]")
    private WebElement startDateInput;

    @FindBy(xpath = "//input[@matenddate]")
    private WebElement endDateInput;

    @FindBy(css = "button.add-location-icon") // CSS selektor za dugme dodavanja lokacije
    private WebElement addLocationButton;

    @FindBy(xpath = "//input[@formcontrolname='amount']")
    private WebElement priceInput;

    @FindBy(xpath = "//button[contains(text(), 'Add')]")
    private WebElement addButton;
    public AccommodationAvailabilityPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void addAvailability(String startDate, String endDate, String price, boolean isPerNight) {
        // Unos datuma
        startDateInput.sendKeys(startDate);
        endDateInput.sendKeys(endDate);
        priceInput.sendKeys(price);
        addButton.click();
        // Ovdje unesite kôd za popunjavanje i potvrdu forme sa željenim podacima
    }

    public void removeAvailability() {

        driver.navigate().refresh();

        WebElement firstRow = driver.findElement(By.xpath("//table[@mat-table]/tbody/tr[1]"));



        WebElement deleteCell = firstRow.findElement(By.cssSelector("td.mat-column-Remove"));

        WebElement deleteButton = deleteCell.findElement(By.cssSelector(".button-in-table"));

        deleteButton.click();
        // Implementirajte logiku za uklanjanje dostupnosti
        // Prvo pronađite redak tablice koji odgovara datim datumima, a zatim kliknite na dugme uklanjanja
    }

    public void editAvailabilityPrice(String newPrice) {

        WebElement firstRow = driver.findElement(By.xpath("//table[@mat-table]/tbody/tr[1]"));

        WebElement priceCell = firstRow.findElement(By.cssSelector("td.mat-column-Price"));

        WebElement editButton = priceCell.findElement(By.cssSelector(".button-in-table"));

        editButton.click();

        WebElement priceInput = driver.findElement(By.cssSelector("td.mat-column-Price input.mat-mdc-input-element"));

// Unesi novu vrednost u input polje
        priceInput.clear();
        priceInput.sendKeys(newPrice);

        WebElement okayButton = driver.findElement(By.cssSelector("td.mat-column-Price button"));

        okayButton.click();
        // Implementirajte logiku za uređivanje cijene dostupnosti
        // Prvo pronađite redak tablice koji odgovara datim datumima, a zatim kliknite na dugme uređivanja
        // Popunite formu s novom cijenom i potvrdite promjene
    }
}
