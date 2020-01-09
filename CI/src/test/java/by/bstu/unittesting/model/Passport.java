package by.bstu.unittesting.model;

import java.util.Objects;

public class Passport {

    private String seriesAndNumber;
    private String expiryDate;

    public Passport(String seriesAndNumber, String expiryDate) {
        this.seriesAndNumber = seriesAndNumber;
        this.expiryDate = expiryDate;
    }

    public String getSeriesAndNumber() {
        return seriesAndNumber;
    }

    public void setSeriesAndNumber(String seriesAndNumber) {
        this.seriesAndNumber = seriesAndNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "Passport{"
                + "seriesAndNumber='" + seriesAndNumber + '\''
                + ", expiryDate='" + expiryDate + '\''
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
        Passport passport = (Passport) obj;
        return Objects.equals(seriesAndNumber, passport.seriesAndNumber)
                && Objects.equals(expiryDate, passport.expiryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seriesAndNumber, expiryDate);
    }
}
