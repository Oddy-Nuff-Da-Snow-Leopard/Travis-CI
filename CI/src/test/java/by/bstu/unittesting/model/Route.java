package by.bstu.unittesting.model;

import java.util.Objects;

public class Route {

    private String origin;
    private String destination;
    private String departureDay;

    public Route(String origin, String destination, String departureDay) {
        this.origin = origin;
        this.destination = destination;
        this.departureDay = departureDay;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureDay() {
        return departureDay;
    }

    public void setDepartureDay(String departureDay) {
        this.departureDay = departureDay;
    }

    @Override
    public String toString() {
        return "Route{"
                + "origin='" + origin + '\''
                + ", destination='" + destination + '\''
                + ", departureDay='" + departureDay + '\''
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
        Route route = (Route) obj;
        return Objects.equals(origin, route.origin)
                && Objects.equals(destination, route.destination)
                && Objects.equals(departureDay, route.departureDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(origin, destination, departureDay);
    }
}
