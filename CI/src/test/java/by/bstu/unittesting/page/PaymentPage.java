package by.bstu.unittesting.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import by.bstu.unittesting.model.Card;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PaymentPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    private static final String REGEX = "-";

    private final By cardNumberInput1Locator = By.id("post_card_number_1");

    @FindBy(id = "post_card_number_2")
    private WebElement cardNumberInput2;

    @FindBy(id = "post_card_number_3")
    private WebElement cardNumberInput3;

    @FindBy(id = "post_card_number_4")
    private WebElement cardNumberInput4;

    @FindBy(id = "post_month")
    private WebElement monthOfCardExpireInput;

    @FindBy(id = "post_year")
    private WebElement yearOfCardExpireInput;

    @FindBy(id = "post_owner")
    private WebElement ownerInput;

    @FindBy(id = "post_cvv")
    private WebElement cvvCodeInput;

    private final By payButtonLocator = By.id("make_payment");

    private final By errorFieldLocator
            = By.cssSelector("div.errors:nth-child(4) > span:nth-child(1)");

    public PaymentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public PaymentPage fillInCardInformation(Card card) {
        String[] cardNumberParts = card.getNumber().split(REGEX);
        WebElement cardNumberInput1 = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.presenceOfElementLocated(cardNumberInput1Locator));
        cardNumberInput1.sendKeys(cardNumberParts[0]);
        cardNumberInput2.sendKeys(cardNumberParts[1]);
        cardNumberInput3.sendKeys(cardNumberParts[2]);
        cardNumberInput4.sendKeys(cardNumberParts[3]);

        monthOfCardExpireInput.sendKeys(card.getMonthOfExpire());
        yearOfCardExpireInput.sendKeys(card.getYearOfExpire());
        ownerInput.sendKeys(card.getOwner());
        cvvCodeInput.sendKeys(card.getCvvCode());
        logger.info("Card information filled");
        return this;
    }

    public PaymentPage clickPayButton() {
        WebElement payButton = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.elementToBeClickable(payButtonLocator));
        payButton.click();
        logger.info("Pay button clicked");
        return this;
    }

    public String getErrorText() {
        WebElement errorField = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.presenceOfElementLocated(errorFieldLocator));
        return errorField.getText();
    }
}
