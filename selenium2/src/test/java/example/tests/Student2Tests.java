package example.tests;

import example.pages.AvailabilityTestPages.OwnerAccommodationsPage;
import example.pages.HomePage;
import example.pages.LogInPage;
import example.pages.ReservationTestPages.GuestReservationsPage;
import example.pages.ReservationTestPages.OwnerReservationsPage;
import org.testng.annotations.Test;

public class Student2Tests extends TestBase {

    static final String OWNER_EMAIL = "owner@gmail.com";
    static final String GUEST_EMAIL="guest@gmail.com";
    static final String PASSWORD = "123";

    private static String PAGE_URL="http://localhost:4200";


    @Test
    public void testOwnerDenyReservation() throws InterruptedException {
        driver.get(PAGE_URL);
        //Create object of HomePage Class
        HomePage home = new HomePage(driver);
        home.clickOnLogIn();

        LogInPage logInPage = new LogInPage(driver,OWNER_EMAIL,PASSWORD);
        logInPage.LogIn();

        HomePage homePage = new HomePage(driver);

        homePage.clickOnOwnerAccommodations();
        OwnerAccommodationsPage ownerAccommodationsPage = new OwnerAccommodationsPage(driver);

        ownerAccommodationsPage.clickReservationRequests();

        OwnerReservationsPage ownerReservationsPage = new OwnerReservationsPage(driver);

//        ownerReservationsPage.clickDenyButton();
        ownerReservationsPage.clickDenyButtonForFirstRow();

    }

    @Test
    public void testGuestDenyReservation() throws InterruptedException {
        driver.get(PAGE_URL);
        //Create object of HomePage Class
        HomePage home = new HomePage(driver);
        home.clickOnLogIn();

        LogInPage logInPage = new LogInPage(driver, GUEST_EMAIL, PASSWORD);
        logInPage.LogIn();

        HomePage homePage = new HomePage(driver);

        homePage.clickOnReservations();
        
        GuestReservationsPage guestReservationsPage = new GuestReservationsPage(driver);
        guestReservationsPage.clickCancelButtonForSecondRow();
    }


}
