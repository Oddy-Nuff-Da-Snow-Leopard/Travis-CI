package by.bstu.unittesting.service;

import by.bstu.unittesting.model.Passport;

public class PassportCreator {

    public static final String TESTDATA_PASSPORT_SERIES_AND_NUMBER = "testdata.passport.seriesAndNumber";
    public static final String TESTDATA_PASSPORT_EXPIRE_DATE = "testdata.passport.expiryDate";

    public static Passport createPassportWithAllFieldsFromProperty() {
        return new Passport(TestDataReader.getTestData(TESTDATA_PASSPORT_SERIES_AND_NUMBER),
                TestDataReader.getTestData(TESTDATA_PASSPORT_EXPIRE_DATE));
    }

    public static Passport createEmptyPassport() {
        return new Passport("", "");
    }
}
