package by.bstu.unittesting.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import by.bstu.unittesting.model.Passport;
import by.bstu.unittesting.model.User;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BookingPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    private static final String REGEX = "\\.";

    private final By emailInputLocator = By.id("email");

    @FindBy(id = "pass")
    private WebElement passwordInput;

    private final By loginButtonLocator = By.className("js-booking-login-form-btn");

    private final By genderLabelLocator = By.className("js-gender-tab-0");

    @FindBy(id = "lastname_0")
    private WebElement surnameInput;

    @FindBy(id = "firstname_0")
    private WebElement nameInput;

    @FindBy(id = "birthday_day_0")
    private WebElement dayOfBirthInput;

    @FindBy(id = "birthday_month_0")
    private WebElement monthOfBirthInput;

    @FindBy(id = "birthday_year_0")
    private WebElement yearOfBirthInput;

    @FindBy(id = "docnum_0")
    private WebElement passportDataInput;

    @FindBy(id = "doc_expire_date_day_0")
    private WebElement dayOfPassportExpireInput;

    @FindBy(id = "doc_expire_date_month_0")
    private WebElement monthOfPassportExpireInput;

    @FindBy(id = "doc_expire_date_year_0")
    private WebElement yearOfPassportExpireInput;

    private final By bookTicketButtonLocator = By.className("js-pre-book-button");

    private final By errorFieldLocator = By.cssSelector("samp.error");

    public BookingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public BookingPage login(User user) {
        WebElement emailInput = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.presenceOfElementLocated(emailInputLocator));
        emailInput.sendKeys(user.getEmail() + "\n");
        driver.manage().timeouts().implicitlyWait(SECONDS_TO_WAIT, TimeUnit.SECONDS);
        passwordInput.sendKeys(user.getPassword());
        WebElement loginButton = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.elementToBeClickable(loginButtonLocator));
        loginButton.click();
        logger.info("User with email [" + user.getEmail() + "] logged in");
        return this;
    }

    public BookingPage selectGender() {
        WebElement genderLabel = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.elementToBeClickable(genderLabelLocator));
        genderLabel.click();
        logger.info("Male gender selected");
        return this;
    }

    public BookingPage fillInUserInformation(User user) {
        surnameInput.sendKeys(user.getSurname());
        nameInput.sendKeys(user.getName());

        String[] birthDateParts = user.getBirthdate().split(REGEX);
        dayOfBirthInput.sendKeys(birthDateParts[0]);
        monthOfBirthInput.sendKeys(birthDateParts[1]);
        yearOfBirthInput.sendKeys(birthDateParts[2]);
        logger.info("User information filled");
        return this;
    }

    public BookingPage fillInPassportData(Passport passportData) {
        passportDataInput.sendKeys(passportData.getSeriesAndNumber());

        String[] expireDateParts = passportData.getExpiryDate().split(REGEX);
        dayOfPassportExpireInput.sendKeys(expireDateParts[0]);
        monthOfPassportExpireInput.sendKeys(expireDateParts[1]);
        yearOfPassportExpireInput.sendKeys(expireDateParts[2]);
        logger.info("Password data filled");
        return this;
    }

    public BookingPage clickBookTicketButton() {
        WebElement bookTicketButton = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.elementToBeClickable(bookTicketButtonLocator));
        bookTicketButton.click();
        logger.info("Book ticket button clicked");
        return this;
    }

    public String getErrorText() {
        WebElement errorField = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.presenceOfElementLocated(errorFieldLocator));
        return errorField.getText();
    }
}
