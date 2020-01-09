package by.bstu.unittesting.service;

import by.bstu.unittesting.model.Card;

public class CardCreator {

    public static final String TESTDATA_CARD_NUMBER = "testdata.card.number";
    public static final String TESTDATA_CARD_MONTH_OF_EXPIRE = "testdata.card.monthOfExpire";
    public static final String TESTDATA_CARD_YEAR_OF_EXPIRE = "testdata.card.yearOfExpire";
    public static final String TESTDATA_CARD_OWNER = "testdata.card.owner";
    public static final String TESTDATA_CARD_CVV_CODE = "testdata.card.cvvCode";

    public static Card createCardWithAllFieldsFromProperty() {
        return new Card(TestDataReader.getTestData(TESTDATA_CARD_NUMBER),
                TestDataReader.getTestData(TESTDATA_CARD_MONTH_OF_EXPIRE),
                TestDataReader.getTestData(TESTDATA_CARD_YEAR_OF_EXPIRE),
                TestDataReader.getTestData(TESTDATA_CARD_OWNER),
                TestDataReader.getTestData(TESTDATA_CARD_CVV_CODE));
    }
}
