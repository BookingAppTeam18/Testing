package example.pages.AvailabilityTestPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OwnerAccommodationsPage {
    private WebDriver driver;


    @FindBy(css = ".column .card")
    private WebElement firstAccommodation;

    @FindBy(css = ".edit-button button:nth-child(2)")
    private WebElement editAvailabilityButton;



    public OwnerAccommodationsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void clickAccommodationAvailability() {
        // Proverite da li je prvi accommodation pronađen
        if (firstAccommodation != null) {
            // Kliknite na dugme "Edit Availability" unutar prve kartice accommodation-a
            if (editAvailabilityButton != null) {
                // Koristite WebDriverWait za čekanje da dugme postane vidljivo i kliknite na njega
                WebDriverWait wait = new WebDriverWait(driver, 10);
                wait.until(ExpectedConditions.visibilityOf(editAvailabilityButton));
                editAvailabilityButton.click();

                System.out.println("Kliknuto na dugme 'Edit Availability' za prvi accommodation.");
            } else {
                System.out.println("Dugme 'Edit Availability' nije pronađeno za prvi accommodation.");
            }
        } else {
            System.out.println("Prvi accommodation nije pronađen.");
        }
    }
}
