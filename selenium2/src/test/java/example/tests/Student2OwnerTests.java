package example.tests;

import example.pages.AvailabilityTestPages.OwnerAccommodationsPage;
import example.pages.HomePage;
import example.pages.LogInPage;
import example.pages.ReservationTestPages.OwnerReservationsPage;
import org.testng.annotations.Test;

public class Student2OwnerTests extends TestBase {

    static final String EMAIL = "owner@gmail.com";
    static final String PASSWORD = "123";

    private static String PAGE_URL="http://localhost:4200";


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

        ownerAccommodationsPage.clickReservationRequests();

        OwnerReservationsPage ownerReservationsPage = new OwnerReservationsPage(driver);

//        WebDriverWait wait = new WebDriverWait(driver, 10);
        ownerReservationsPage.clickDenyButton();







//        Thread.sleep(5000);


    }



}
