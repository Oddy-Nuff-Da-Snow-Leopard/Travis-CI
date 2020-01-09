package by.bstu.unittesting.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import by.bstu.unittesting.model.Route;
import by.bstu.unittesting.model.User;
import static by.bstu.unittesting.page.AbstractPage.SECONDS_TO_WAIT;
import java.util.concurrent.TimeUnit;

public class MainPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    private static final String PAGE_URL = "https://avia.bilet.by/";

    private final By oneWayLabelLocator = By.className("flight-complexity__label");

    @FindBy(id = "from_name")
    private WebElement originInput;

    private final By originListLocator = By.id("ui-id-1");

    @FindBy(id = "to_name")
    private WebElement destinationInput;

    private final By destinationListLocator = By.id("ui-id-2");

    @FindBy(id = "departure_date")
    private WebElement departureDateInput;

    private final By searchButtonLocator = By.className("search_button");

    private final By errorFieldLocator = By.cssSelector("samp.error");

    @FindBy(className = "do-login")
    private WebElement signInLabel;

    @FindBy(id = "email_login")
    private WebElement emailInput;

    @FindBy(id = "pass_login")
    private WebElement passwordInput;

    private final By signInButtonLocator = By.cssSelector("sform-submit");

    private final By logoutLabelLocator = By.cssSelector("logout");

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public MainPage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Main page opened");
        return this;
    }

    public MainPage selectOnewayRadioButton() {
        WebElement oneWayLabel = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.elementToBeClickable(oneWayLabelLocator));
        oneWayLabel.click();
        logger.info("One way radio button selected");
        return this;
    }

    public MainPage clearOriginAndDestinationFields() {
        originInput.clear();
        destinationInput.clear();
        logger.info("Origin and destination fields cleared");
        return this;
    }

    public MainPage signInUser(User user) {
        signInLabel.click();
        logger.info("Sign in label clicked");
        emailInput.sendKeys(user.getEmail());
        logger.info("Email entered");
        passwordInput.sendKeys(user.getPassword());
        logger.info("Password entered");
        WebElement signInButton = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.presenceOfElementLocated(signInButtonLocator));
        signInButton.click();
        logger.info("Sign in button clicked");
        return this;
    }

    public boolean isLogoutButtonExist() {
        return driver.findElement(logoutLabelLocator).isDisplayed();
    }

    public MainPage fillInRouteInformation(Route route) {
        fillInOrigin(route);
        fillInDestination(route);
        departureDateInput.click();
        departureDateInput.click();
        driver.findElement(By.linkText(route.getDepartureDay())).click();
        logger.info("Route information filled");
        return this;
    }

    public MainPage fillInOrigin(Route route) {
        originInput.sendKeys(route.getOrigin());
        WebElement originList = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.visibilityOfElementLocated(originListLocator));
        originList.click();
        logger.info("Origin field filled");
        return this;
    }

    public MainPage fillInDestination(Route route) {
        destinationInput.sendKeys(route.getDestination());
        WebElement destinationList = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.visibilityOfElementLocated(destinationListLocator));
        destinationList.click();
        logger.info("Destination field filled");
        return this;
    }

    public boolean isDateOnCalendarClickable(Route route) {
        return driver.findElement(By.linkText(route.getDepartureDay())).isSelected();
    }

    public FlightSelectionPage clickSearchButton() {
        WebElement searchButton = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.elementToBeClickable(searchButtonLocator));
        searchButton.click();
        logger.info("Search button clicked");
        return new FlightSelectionPage(driver);
    }

    public MainPage clickSearchButtonWithoutGoingToNextPage() {
        WebElement searchButton = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.elementToBeClickable(searchButtonLocator));
        searchButton.click();
        searchButton.click();
        logger.info("Search button clicked");
        return this;
    }

    public String getErrorText() {
        WebElement errorField = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.presenceOfElementLocated(errorFieldLocator));
        return errorField.getText();
    }
}
