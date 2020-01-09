package by.bstu.unittesting.test;

import by.bstu.unittesting.model.Card;
import by.bstu.unittesting.model.Passport;
import by.bstu.unittesting.model.Route;
import by.bstu.unittesting.model.User;

import by.bstu.unittesting.page.BookingPage;
import by.bstu.unittesting.page.MainPage;
import by.bstu.unittesting.page.RuleConfirmationPage;

import by.bstu.unittesting.service.CardCreator;
import by.bstu.unittesting.service.PassportCreator;
import by.bstu.unittesting.service.RouteCreator;
import by.bstu.unittesting.service.UserCreator;

import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class AviaBiletWebTest extends GeneralConfig {

    private static final String MAIN_PAGE_ERROR_TEXT = "Это поле необходимо заполнить";
    private static final String FLIGHT_PAGE_ERROR_TEXT
            = "Не найдены варианты перелёта, соответствующие вашим критериям";
    private static final String BOOKING_PAGE_ERROR_TEXT = "Это поле необходимо заполнить";
    private static final String PAYMENT_PAGE_ERROR_TEXT = "Введите корректные данные.";

    @Test(description = "CASE 1")
    public void testSearchingWithoutOriginCity() {
        Route testRoute = RouteCreator.createRouteWithOnlyDestinationFieldFromProperty();
        String errorText = new MainPage(driver).openPage()
                .selectOnewayRadioButton()
                .clearOriginAndDestinationFields()
                .fillInDestination(testRoute)
                .clickSearchButtonWithoutGoingToNextPage()
                .getErrorText();
        assertThat(errorText, is(equalTo(MAIN_PAGE_ERROR_TEXT)));
    }
    
    @Test(description = "CASE 2")
    public void testSearchingWithoutDestinationCity() {
        Route testRoute = RouteCreator.createRouteWithOnlyOriginFieldFromProperty();
        String errorText = new MainPage(driver).openPage()
                .selectOnewayRadioButton()
                .clearOriginAndDestinationFields()
                .fillInOrigin(testRoute)
                .clickSearchButtonWithoutGoingToNextPage()
                .getErrorText();
        assertThat(errorText, is(equalTo(MAIN_PAGE_ERROR_TEXT)));
    }
    
    @Test(description = "CASE 3")
    public void testSearchingWithoutDepartureDate() {
        Route testRoute = RouteCreator.createRouteWithoutDepartureDateFieldFromProperty();
        String errorText = new MainPage(driver).openPage()
                .selectOnewayRadioButton()
                .clearOriginAndDestinationFields()
                .fillInOrigin(testRoute)
                .fillInDestination(testRoute)
                .clickSearchButtonWithoutGoingToNextPage()
                .getErrorText();
        assertThat(errorText, is(equalTo(MAIN_PAGE_ERROR_TEXT)));
    }

    @Test(description = "CASE 4")
    public void testSearchingWithSameOriginAndDestinationCity() {
        Route testRoute = RouteCreator.createRouteWithAllFieldsAndWithSameOriginAndDestinationFromProperty();
        String errorText = new MainPage(driver).openPage()
                .selectOnewayRadioButton()
                .clearOriginAndDestinationFields()
                .fillInRouteInformation(testRoute)
                .clickSearchButton()
                .getErrorText();
        assertThat(errorText, is(equalTo(FLIGHT_PAGE_ERROR_TEXT)));
    }
    
    @Test(description = "CASE 5")
    public void testSearchingWithDepartureDayYesterday() {
        Route testRoute = RouteCreator.createRouteWithAllFieldsWithDepartureDayYesterdayFromProperty();
        MainPage mainPage = new MainPage(driver).openPage()
                .selectOnewayRadioButton()
                .clearOriginAndDestinationFields()
                .fillInRouteInformation(testRoute);
        assertFalse(mainPage.isDateOnCalendarClickable(testRoute));
    }

    @Test(description = "CASE 6")
    public void testBookingTicketWithoutIndicatingUserInformation() {
        Route testRoute = RouteCreator.createRouteWithAllFieldsFromProperty();
        Passport testPassport = PassportCreator.createPassportWithAllFieldsFromProperty();

        String errorText = new MainPage(driver).openPage()
                .selectOnewayRadioButton()
                .clearOriginAndDestinationFields()
                .fillInRouteInformation(testRoute)
                .clickSearchButton()
                .selectFlight()
                .selectGender()
                .fillInPassportData(testPassport)
                .clickBookTicketButton()
                .getErrorText();

        assertThat(errorText, is(equalTo(BOOKING_PAGE_ERROR_TEXT)));
    }

    @Test(description = "CASE 7")
    public void testBookingTicketWithoutUserLogging() {
        Route testRoute = RouteCreator.createRouteWithAllFieldsFromProperty();
        User testUser = UserCreator.createUserWithAllFieldsFromProperty();
        Passport testPassport = PassportCreator.createPassportWithAllFieldsFromProperty();

        String errorText = new MainPage(driver).openPage()
                .selectOnewayRadioButton()
                .clearOriginAndDestinationFields()
                .fillInRouteInformation(testRoute)
                .clickSearchButton()
                .selectFlight()
                .selectGender()
                .fillInUserInformation(testUser)
                .fillInPassportData(testPassport)
                .clickBookTicketButton()
                .getErrorText();

        assertThat(errorText, is(equalTo(BOOKING_PAGE_ERROR_TEXT)));
    }

    @Test(description = "CASE 8")
    public void testBookingTicketWithoutIndicatingPassportData() {
        Route testRoute = RouteCreator.createRouteWithAllFieldsFromProperty();
        User testUser = UserCreator.createUserWithAllFieldsFromProperty();

        String errorText = new MainPage(driver).openPage()
                .selectOnewayRadioButton()
                .clearOriginAndDestinationFields()
                .fillInRouteInformation(testRoute)
                .clickSearchButton()
                .selectFlight()
                .login(testUser)
                .selectGender()
                .fillInUserInformation(testUser)
                .clickBookTicketButton()
                .getErrorText();

        assertThat(errorText, is(equalTo(BOOKING_PAGE_ERROR_TEXT)));
    }
    
//    @Test(description = "CASE 9")
//    public void testSignInUser() {
//        User testUser = UserCreator.createUserWithAllFieldsFromProperty();
//        MainPage mainPage = new MainPage(driver).openPage().signInUser(testUser);
//        assertTrue(mainPage.isLogoutButtonExist());
//    }

    @Test(description = "CASE 10")
    public void testEnteringWrongCardNumberWhenPaying() {

        Route testRoute = RouteCreator.createRouteWithAllFieldsFromProperty();
        User testUser = UserCreator.createUserWithAllFieldsFromProperty();
        Passport testPassport = PassportCreator.createPassportWithAllFieldsFromProperty();
        Card testCard = CardCreator.createCardWithAllFieldsFromProperty();

        BookingPage bookingPage = new MainPage(driver).openPage()
                .selectOnewayRadioButton()
                .clearOriginAndDestinationFields()
                .fillInRouteInformation(testRoute)
                .clickSearchButton()
                .selectFlight()
                .login(testUser)
                .selectGender()
                .fillInUserInformation(testUser)
                .fillInPassportData(testPassport)
                .clickBookTicketButton();

        String errorText = new RuleConfirmationPage(driver)
                .confirmRules()
                .clickPayButton()
                .fillInCardInformation(testCard)
                .clickPayButton()
                .getErrorText();

        assertThat(errorText, is(equalTo(PAYMENT_PAGE_ERROR_TEXT)));
    }
}
