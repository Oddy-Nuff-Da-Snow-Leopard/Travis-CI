package by.bstu.unittesting.service;

import by.bstu.unittesting.model.Route;

import java.util.Calendar;

public class RouteCreator {

    private static final String YESTERDAY_DAY_OF_MONTH
            = Integer.toString(Calendar.getInstance().get(Calendar.DAY_OF_MONTH) - 1);

    public static final String TESTDATA_ROUTE_ORIGIN = "testdata.route.origin";
    public static final String TESTDATA_ROUTE_DESTINATION = "testdata.route.destination";
    public static final String TESTDATA_ROUTE_DEPARTURE_DAY = "testdata.route.departureDay";

    public static Route createRouteWithAllFieldsFromProperty() {
        return new Route(TestDataReader.getTestData(TESTDATA_ROUTE_ORIGIN),
                TestDataReader.getTestData(TESTDATA_ROUTE_DESTINATION),
                TestDataReader.getTestData(TESTDATA_ROUTE_DEPARTURE_DAY));
    }

    public static Route createRouteWithOnlyOriginFieldFromProperty() {
        return new Route(TestDataReader.getTestData(TESTDATA_ROUTE_ORIGIN), "", "");
    }

    public static Route createRouteWithOnlyDestinationFieldFromProperty() {
        return new Route("", TestDataReader.getTestData(TESTDATA_ROUTE_DESTINATION), "");
    }

    public static Route createRouteWithoutDepartureDateFieldFromProperty() {
        return new Route(TestDataReader.getTestData(TESTDATA_ROUTE_ORIGIN),
                TestDataReader.getTestData(TESTDATA_ROUTE_DESTINATION), "");
    }

    public static Route createRouteWithAllFieldsAndWithSameOriginAndDestinationFromProperty() {
        return new Route(TestDataReader.getTestData(TESTDATA_ROUTE_ORIGIN),
                TestDataReader.getTestData(TESTDATA_ROUTE_ORIGIN),
                TestDataReader.getTestData(TESTDATA_ROUTE_DEPARTURE_DAY));
    }

    public static Route createRouteWithAllFieldsWithDepartureDayYesterdayFromProperty() {
        return new Route(TestDataReader.getTestData(TESTDATA_ROUTE_ORIGIN),
                TestDataReader.getTestData(TESTDATA_ROUTE_DESTINATION),
                YESTERDAY_DAY_OF_MONTH);
    }

}
