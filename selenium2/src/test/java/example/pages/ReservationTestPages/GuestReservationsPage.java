package example.pages.ReservationTestPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GuestReservationsPage {
    private WebDriver driver;

    public GuestReservationsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickCancelButtonForSecondRow() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

// Sačekaj da se redovi u tabeli učitaju, ako je potrebno
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("tr.mat-mdc-row"), 0));

// Pronađi sve redove u tabeli
        List<WebElement> rows = driver.findElements(By.cssSelector("tr.mat-mdc-row"));

// Ako postoji barem jedan red
        if (!rows.isEmpty()) {
            // Pronađi prvi red
            WebElement firstRow = rows.get(1);

            // Proveri da li je ikona "denied" vidljiva na početku
            try {
                WebElement deniedIconAtStart = firstRow.findElement(By.id("denied"));
                if (deniedIconAtStart.isDisplayed()) {
                    // Ako je ikona "denied" vidljiva, rezervacija je već odbijena na početku
                    System.out.println("Reservation is already denied at the beginning");
                    return;
                }
            } catch (org.openqa.selenium.NoSuchElementException e) {
                // Ako ikona "denied" nije pronađena, nastavi izvršavanje koda
            }


            // Nastavi s ostatkom koda za proveru "approved" i odbijanje rezervacije
            // Pronađi dugme "deny-button" unutar prvog reda
            WebElement denyButton = firstRow.findElement(By.id("button-deny"));

            // Klikni na dugme "deny-button"
            denyButton.click();

            // Sačekaj da se ikone "approved" i "denied" pojave nakon klika na dugme "Deny"
            WebElement deniedIconAfterDeny = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("denied")));


            if (deniedIconAfterDeny.isDisplayed()) {
                System.out.println("Reservation successfully cancelled");
            } else {
                System.out.println("Reservation not cancelled");
            }
        } else {
            // Ako nema redova, tabela je prazna
            System.out.println("Table is empty");
        }
    }
    }
