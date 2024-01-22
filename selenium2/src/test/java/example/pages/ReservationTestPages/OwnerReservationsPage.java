package example.pages.ReservationTestPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OwnerReservationsPage {
    private WebDriver driver;

//    @FindBy(id = "button-deny")
//    private WebElement denyButton;

    public OwnerReservationsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickDenyButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Sačekaj da se redovi u tabeli učitaju, ako je potrebno
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("tr.mat-mdc-row"), 0));
        WebElement denyButton;
        try {
            // Pokušaj pronaći dugme "Deny"
            denyButton = driver.findElement(By.id("button-deny"));

            // Ako dugme "Deny" postoji, rezervacija je u statusu "CREATED"
            System.out.println("Reservation is in status CREATED, deny button found");


            if(denyButton.isDisplayed()){
                denyButton.click();

                // Sačekaj da se ikona "denied" prikaže nakon klika na dugme "Deny"
                WebElement deniedButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("denied")));

                // Proveri da li je ikona "denied" vidljiva
                boolean isDeniedIconVisible = deniedButton.isDisplayed();
                if(isDeniedIconVisible){
                    System.out.println("Reservation successfully denied");
                }

                else{
                    System.out.println("Reservation not denied");
                }
            }

        } catch (org.openqa.selenium.NoSuchElementException e) {
                // Ako dugme "Deny" nije pronađeno, rezervacija nije u statusu "CREATED"
                System.out.println("Reservation is not in status CREATED, deny button not found");
            }

//        else{
//            System.out.println("Button deny not found");
//        }

    }
    public void clickDenyButtonForFirstRow() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

// Sačekaj da se redovi u tabeli učitaju, ako je potrebno
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("tr.mat-mdc-row"), 0));

// Pronađi sve redove u tabeli
        List<WebElement> rows = driver.findElements(By.cssSelector("tr.mat-mdc-row"));

// Ako postoji barem jedan red
        if (!rows.isEmpty()) {
            // Pronađi prvi red
            WebElement firstRow = rows.get(0);

            // Pokušaj pronaći dugme "Deny" unutar prvog reda
            try {
                WebElement denyButton = firstRow.findElement(By.id("button-deny"));

                // Ako dugme "Deny" postoji, rezervacija je u statusu "CREATED"
                System.out.println("Reservation is in status CREATED, deny button found");

                if (denyButton.isDisplayed()) {
                    denyButton.click();

                    // Sačekaj da se ikona "denied" prikaže nakon klika na dugme "Deny"
                    WebElement deniedButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("denied")));

                    // Proveri da li je ikona "denied" vidljiva
                    boolean isDeniedIconVisible = deniedButton.isDisplayed();
                    if (isDeniedIconVisible) {
                        System.out.println("Reservation successfully denied");
                    } else {
                        System.out.println("Reservation not denied");
                    }
                }

            } catch (org.openqa.selenium.NoSuchElementException e) {
                // Ako dugme "Deny" nije pronađeno, rezervacija nije u statusu "CREATED"
                System.out.println("Reservation is not in status CREATED, deny button not found in the first row");
            }
        } else {
            // Ako nema redova, tabela je prazna
            System.out.println("Table is empty");
        }
    }
}
