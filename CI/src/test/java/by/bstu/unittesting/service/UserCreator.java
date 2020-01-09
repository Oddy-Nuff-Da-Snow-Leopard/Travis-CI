package by.bstu.unittesting.service;

import by.bstu.unittesting.model.User;

public class UserCreator {

    public static final String TESTDATA_USER_EMAIL = "testdata.user.email";
    public static final String TESTDATA_USER_PASSWORD = "testdata.user.password";
    public static final String TESTDATA_USER_SURNAME = "testdata.user.surname";
    public static final String TESTDATA_USER_NAME = "testdata.user.name";
    public static final String TESTDATA_USER_BIRTHDATE = "testdata.user.birthDate";

    public static User createUserWithAllFieldsFromProperty() {
        return new User(TestDataReader.getTestData(TESTDATA_USER_EMAIL),
                TestDataReader.getTestData(TESTDATA_USER_PASSWORD),
                TestDataReader.getTestData(TESTDATA_USER_SURNAME),
                TestDataReader.getTestData(TESTDATA_USER_NAME),
                TestDataReader.getTestData(TESTDATA_USER_BIRTHDATE));
    }
}
