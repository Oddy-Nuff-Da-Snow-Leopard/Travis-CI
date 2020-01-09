package by.bstu.unittesting.model;

import java.util.Objects;

public class Card {

    private String number;
    private String monthOfExpire;
    private String yearOfExpire;
    private String owner;
    private String cvvCode;

    public Card(String number, String monthOfExpire, String yearOfExpire, String owner, String cvvCode) {
        this.number = number;
        this.monthOfExpire = monthOfExpire;
        this.yearOfExpire = yearOfExpire;
        this.owner = owner;
        this.cvvCode = cvvCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMonthOfExpire() {
        return monthOfExpire;
    }

    public void setMonthOfExpire(String monthOfExpire) {
        this.monthOfExpire = monthOfExpire;
    }

    public String getYearOfExpire() {
        return yearOfExpire;
    }

    public void setYearOfExpire(String yearOfExpire) {
        this.yearOfExpire = yearOfExpire;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCvvCode() {
        return cvvCode;
    }

    public void setCvvCode(String cvvCode) {
        this.cvvCode = cvvCode;
    }

    @Override
    public String toString() {
        return "Card{"
                + "number='" + number + '\''
                + ", monthOfExpire='" + monthOfExpire + '\''
                + ", yearOfExpire='" + yearOfExpire + '\''
                + ", owner='" + owner + '\''
                + ", cvvCode='" + cvvCode + '\''
                + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Card card = (Card) obj;
        return Objects.equals(number, card.number)
                && Objects.equals(monthOfExpire, card.monthOfExpire)
                && Objects.equals(yearOfExpire, card.yearOfExpire)
                && Objects.equals(owner, card.owner)
                && Objects.equals(cvvCode, card.cvvCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, monthOfExpire, yearOfExpire, owner, cvvCode);
    }
}
