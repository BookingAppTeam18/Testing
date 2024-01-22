package example.tests;

import example.pages.HomePage;
import example.pages.LogInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Student3Tests extends TestBase{

    static final String EMAIL = "guest@gmail.com";
    static final String PASSWORD = "123";
    private static final String PAGE_URL = "http://localhost:4200";

    @Test
    public void testSearchAndFilter() throws InterruptedException {
        driver.get(PAGE_URL);

        WebDriverWait wait = new WebDriverWait(driver, 10);

        HomePage home = new HomePage(driver);
        home.clickOnLogIn();

        LogInPage logInPage = new LogInPage(driver, EMAIL, PASSWORD);
        logInPage.LogIn();



        HomePage homePage = new HomePage(driver);
//        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOf(homePage.cardsVisible()));
        wait.until(ExpectedConditions.visibilityOf(homePage.getSearchInput()));


        //Provera za search
        homePage.performSearchGood();
        wait.until(ExpectedConditions.visibilityOf(homePage.cardsVisible()));
        checkPassesGoodSearch(homePage);
//        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOf(homePage.getSearchInput()));

        //Provera za search kad treba da ne vrati nista
        homePage.peroformSearchBad();
        checkPassesBadSearch(homePage);

        //refres da bi vratili sve accommodatione
        driver.navigate().refresh();
//        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOf(homePage.cardsVisible()));
        wait.until(ExpectedConditions.visibilityOf(homePage.getFilterButton()));

        //Provera za filtere
        homePage.clickOnFilterButton();
        homePage.editNumberOfGuests("6");
        homePage.performSlidingPrice();
        homePage.enterStartAndEndDates();
        homePage.performSelectingType();
        homePage.performSelectingLocation();
        homePage.performSelectingBenefit();
        homePage.confirmFilters();
        wait.until(ExpectedConditions.visibilityOf(homePage.cardsVisible()));
        checForFilters(homePage);
    }

    public void checkPassesGoodSearch(HomePage homePage){
        List<String> expected = new ArrayList<>();
        expected.add("Apartmani za kuce");
        List<String> actual = homePage.getCards();
        assertEquals(actual, expected);
    }

    public void checkPassesBadSearch(HomePage homePage){
        List<String> expected = new ArrayList<>();
        List<String> actual = homePage.getCards();
        assertEquals(actual, expected);
    }

    public void checForFilters(HomePage homePage){
        List<String> expected = new ArrayList<>();
        expected.add("Apartman 3");
        List<String> actual = homePage.getCards();
        assertEquals(actual, expected);
    }
}
