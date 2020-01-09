package by.bstu.unittesting.page;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightSelectionPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    private final By selectButtonLocator = By.className("rec_submit");

    private final By errorFieldLocator = By.xpath("/html/body/div[3]/div[2]/p");

    public FlightSelectionPage(WebDriver driver) {
        super(driver);
    }

    public BookingPage selectFlight() {
        WebElement selectButton = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.elementToBeClickable(selectButtonLocator));
        selectButton.click();
        logger.info("First flight selected");
        return new BookingPage(driver);
    }

    public String getErrorText() {
        WebElement errorField = new WebDriverWait(driver, SECONDS_TO_LOAD)
                .until(ExpectedConditions.visibilityOfElementLocated(errorFieldLocator));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return errorField.getText();
    }
}
