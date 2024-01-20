package example.tests;

import example.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Student1Tests extends TestBase {

    static final String EMAIL = "owner@gmail.com";
    static final String PASSWORD = "123";

    @Test
    public void testAvailability() throws InterruptedException {
        //Create object of HomePage Class
        HomePage home = new HomePage(driver);
        home.clickOnLogIn();
    }
}
