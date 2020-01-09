package by.bstu.unittesting.page;

import static by.bstu.unittesting.page.AbstractPage.SECONDS_TO_LOAD;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RuleConfirmationPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    private final By confirmLabelLocator = By.className("confirm-btn_wrapper");
    private final By payButtonLocator = By.className("js-book-button");

    public RuleConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public RuleConfirmationPage confirmRules() {
        WebElement confirmLabel = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.elementToBeClickable(confirmLabelLocator));
        confirmLabel.click();
        logger.info("Rules confirmed");
        return this;
    }

    public PaymentPage clickPayButton() {
        WebElement payButton = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.elementToBeClickable(payButtonLocator));
        payButton.click();
        logger.info("Pay button clicked");
        return new PaymentPage(driver);
    }
}
