package example.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class HomePage {
    private WebDriver driver;



    @FindBy(xpath = "//button[text()='LOG IN']")
    private WebElement logInButton;

    @FindBy(css = "button.location-icon")
    private WebElement ownerAccommodations;

    @FindBy(css = "mat-form-field input")
    private WebElement searchInput;

    @FindBy(css = "button.filter-icon")
    private WebElement filterButton;

    @FindBy(css = "button.filter-confirm")
    private WebElement confirmFilters;

    @FindBy(css = "input.slide-price-left")
    private WebElement priceSlider;

    @FindBy(css = ".number-of-guests mat-form-field input")
    private WebElement numberOfGuestsFilter;

    @FindBy(css = "input.date-of-start")
    private WebElement startDate;

    @FindBy(css = "input.date-of-end")
    private WebElement endDate;

    @FindBy(id = "cards")
    private WebElement cardsContainer;

    @FindBy(xpath="//button[text()='Reservations']")
    private WebElement reservationsButton;


    public HomePage(WebDriver driver){
        this.driver=driver;

        PageFactory.initElements(driver, this);
    }

    public void clickOnLogIn(){
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(logInButton)).click();
    }

    public void clickOnOwnerAccommodations(){
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(ownerAccommodations)).click();

    }

    public void performSearchGood() {
//        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys("kuce");
        searchInput.sendKeys(Keys.ENTER);
    }

    public void peroformSearchBad(){
        searchInput.clear();
        searchInput.sendKeys("qwe");
        searchInput.sendKeys(Keys.ENTER);
    }

    public void clickOnFilterButton(){
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(filterButton)).click();

    }

    public void editNumberOfGuests(String number) {
        numberOfGuestsFilter.clear();
        numberOfGuestsFilter.sendKeys(number);
        numberOfGuestsFilter.sendKeys(Keys.ENTER);
    }

    public void confirmFilters(){
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(confirmFilters)).click();

    }

    public void performSlidingPrice(){
        Actions actions = new Actions(driver);

        // Kalkulacija vrednosti koju želite postaviti na slajderu (u ovom slučaju 500)
        int desiredValue = 150;

        // Dobavljanje širine slajdera
        int sliderWidth = priceSlider.getSize().getWidth();

        // Izračunavanje x-offseta za postavljanje vrednosti
        double xOffset = sliderWidth * ((double) desiredValue / 1000);

        // Pomeranje do određenog x-offseta koristeći Actions
        actions.clickAndHold(priceSlider).moveByOffset((int) xOffset, 0).release().perform();

    }

    public void enterStartAndEndDates() throws InterruptedException {
        String start = "01/15/2024";
        String end = "01/20/2024";

        Actions actions = new Actions(driver);

        actions.moveToElement(startDate).click().perform();
        // Simulirajte kombinaciju tastera za brisanje teksta
        actions.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).sendKeys(Keys.BACK_SPACE).perform();

        // Selektujte end datum
        actions.moveToElement(endDate).click().perform();
        actions.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).sendKeys(Keys.BACK_SPACE).perform();


        startDate.sendKeys(start);
        endDate.sendKeys(end);
    }

    public void performSelectingType(){
        WebElement matSelectElement = driver.findElement(By.className("types"));

        // Otvorite mat-select
        matSelectElement.click();

        // Sačekajte da se pojavi opcija "Apartment"
        By optionLocator = By.xpath("//mat-option/span[contains(text(), 'Apartment')]");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement optionApartment = wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));

        // Kliknite na željenu opciju
        optionApartment.click();
    }

    public void performSelectingLocation(){
        WebElement matSelectElement = driver.findElement(By.className("lokacijice"));

        // Otvorite mat-select
        matSelectElement.click();

        // Sačekajte da se pojavi opcija "Apartment"
        By optionLocator = By.xpath("//mat-option/span[contains(text(), 'Novi Sad')]");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement optionApartment = wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));

        // Kliknite na željenu opciju
        optionApartment.click();
    }

    public void performSelectingBenefit(){
        WebElement benefiteDiv = driver.findElement(By.id("iconTest"));

        WebElement innerDiv = benefiteDiv.findElement(By.tagName("div"));


        List<WebElement> childrenElements = innerDiv.findElements(By.xpath("./*"));

        childrenElements.get(0).click();

    }

    public List<String> getCards() {
        // Pronađi roditeljski element "cards"
//        WebElement cardsContainer = driver.findElement(By.id("cards"));

        // Pronađi sve elemente s klasom "card" unutar "cards" kontejnera
        List<WebElement> cardElements = cardsContainer.findElements(By.className("card"));

        // Sada možete izvesti radnje s pronađenim elementima
        List<String> names = new ArrayList<String>();
        for (WebElement cardElement : cardElements) {
            // Radnje s pojedinim cardElement
            WebElement h4Element = cardElement.findElement(By.tagName("h4"));
            String accommodationName = h4Element.getText();
            System.out.println("Ime smještaja: " + accommodationName);
            names.add(accommodationName);
        }
        return names;
    }

    public WebElement getSearchInput() {
        return searchInput;
    }

    public WebElement getFilterButton(){
        return filterButton;
    }

    public WebElement cardsVisible(){
        return cardsContainer;
    }

    public void clickOnReservations(){
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(reservationsButton)).click();

    }



}
