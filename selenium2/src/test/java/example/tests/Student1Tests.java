package example.tests;

import example.pages.HomePage;
import example.pages.LogInPage;
import org.testng.annotations.Test;

public class Student1Tests extends TestBase {

    static final String EMAIL = "owner@gmail.com";
    static final String PASSWORD = "123";

    @Test
    public void testAvailability() throws InterruptedException {
        //Create object of HomePage Class
        HomePage home = new HomePage(driver);
        home.clickOnLogIn();

        LogInPage logInPage = new LogInPage(driver,EMAIL,PASSWORD);
        logInPage.LogIn();
        Thread.sleep(5000);

    }
}
