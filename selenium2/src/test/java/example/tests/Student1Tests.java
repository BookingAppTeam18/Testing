package example.tests;

import example.pages.AvailabilityTestPages.AccommodationAvailabilityPage;
import example.pages.AvailabilityTestPages.OwnerAccommodationsPage;
import example.pages.HomePage;
import example.pages.LogInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student1Tests extends TestBase {

    static final String EMAIL = "owner@gmail.com";
    static final String PASSWORD = "123";

    private static String PAGE_URL="http://localhost:4200";

    private  String startDate = "01/25/2024";
    private  String endDate = "01/31/2024";
    private  String price = "1000";
    private  String newPrice = "2000";


    @Test
    public void testAvailability() throws InterruptedException {
        driver.get(PAGE_URL);
        //Create object of HomePage Class
        HomePage home = new HomePage(driver);
        home.clickOnLogIn();

        LogInPage logInPage = new LogInPage(driver,EMAIL,PASSWORD);
        logInPage.LogIn();

        HomePage homePage = new HomePage(driver);

        homePage.clickOnOwnerAccommodations();
        OwnerAccommodationsPage ownerAccommodationsPage = new OwnerAccommodationsPage(driver);

        ownerAccommodationsPage.clickAccommodationAvailability();

        AccommodationAvailabilityPage accommodationAvailabilityPage = new AccommodationAvailabilityPage(driver);


        accommodationAvailabilityPage.addAvailability(startDate,endDate,price,false);
        checkAddedPrice(startDate,endDate,price);

        accommodationAvailabilityPage.editAvailabilityPrice(newPrice);
        checkAddedPrice(startDate,endDate,newPrice);


        accommodationAvailabilityPage.removeAvailability();
        checkIfEmpty();

        Thread.sleep(5000);


    }

    private void checkIfEmpty() {
        // Sačekaj da se tabela učita (očekujte da se pojavi nakon dodavanja)
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mat-mdc-table")));

        List<WebElement> rows = driver.findElements(By.xpath("//table[@mat-table]/tbody/tr"));

        Assert.assertEquals(rows.size(),0, "Cena se ne poklapa");

    }

    private void checkAddedPrice(String expectedStartDate, String expectedEndDate, String expectedPrice) {
        // Sačekaj da se tabela učita (očekujte da se pojavi nakon dodavanja)
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mat-mdc-table")));

// Pronađi red u tabeli
        WebElement firstRow = driver.findElement(By.xpath("//table[@mat-table]/tbody/tr[1]"));

// Izdvoj podatke iz prvog reda
        String startDate = firstRow.findElement(By.cssSelector("td.mat-column-Start-Date")).getText().trim();
        String endDate = firstRow.findElement(By.cssSelector("td.mat-column-End-Date")).getText().trim();
        String priceCellText = firstRow.findElement(By.cssSelector("td.mat-column-Price")).getText();


        // Koristi regex za izdvajanje broja iz teksta
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(priceCellText);
        matcher.find();  // Pronađi prvi broj
        String extractedPrice = matcher.group();


        Assert.assertEquals(startDate, expectedStartDate, "Start Date se ne poklapa");
        Assert.assertEquals(endDate, expectedEndDate, "End Date se ne poklapa");
        Assert.assertEquals(extractedPrice, expectedPrice, "Cena se ne poklapa");

    }
}
