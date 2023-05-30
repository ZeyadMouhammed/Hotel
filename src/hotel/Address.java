package hotel;

import java.io.Serializable;
import java.util.ArrayList;

public class Address implements Serializable {

    private String city;
    private String neighborhood;
    private String streetName;
    private String buildingName;

    public Address(String city, String neighborhood, String streetName) {
        this.city = city;
        this.neighborhood=neighborhood;
        this.streetName = streetName;
    }

    public Address(String city, String neighborhood, String streetName, String buildingName) {
        this.city = city;
        this.neighborhood=neighborhood;
        this.streetName = streetName;
        this.buildingName = buildingName;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    @Override
    public String toString() {
        return  "\n"+"[ city " + city +"\n"+
                "  neighborhood " + neighborhood +"\n"+
                "  streetName " + streetName +"\n"+
                "  buildingName " + buildingName+" ]";
    }

}
