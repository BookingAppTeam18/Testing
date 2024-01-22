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
    @FindBy(id = "button-approve")
    private WebElement approveButton;

    @FindBy(id = "button-deny")
    private WebElement denyButton;

    public OwnerReservationsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void clickDenyButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table.mat-mdc-table")));

        // Pronađi tabelu
        WebElement table = driver.findElement(By.cssSelector("table.mat-mdc-table"));

        // Sačekaj da se redovi u tabeli učitaju, ako je potrebno
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("tr.mat-mdc-row"), 0));

        // Pronađi sve redove u tabeli
        List<WebElement> rows = table.findElements(By.cssSelector("tr.mat-mdc-row"));

        // Iteriraj kroz redove i radite šta vam je potrebno
//        for (WebElement row : rows) {
//            // Radite sa svakim redom
//            System.out.println(row.getText()); // Primer: ispis teksta iz svakog reda
//        }

      denyButton.click();

    }


}
