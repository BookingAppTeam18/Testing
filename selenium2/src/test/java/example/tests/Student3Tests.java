package example.tests;

import example.pages.HomePage;
import example.pages.LogInPage;
import org.testng.annotations.Test;

public class Student3Tests extends TestBase{

    static final String EMAIL = "guest@gmail.com";
    static final String PASSWORD = "123";
    private static String PAGE_URL = "http://localhost:4200";

    @Test
    public void testSearchAndFilter() {
        driver.get(PAGE_URL);

        HomePage home = new HomePage(driver);
        home.clickOnLogIn();

        LogInPage logInPage = new LogInPage(driver, EMAIL, PASSWORD);
        logInPage.LogIn();

        HomePage homePage = new HomePage(driver);
    }
}
