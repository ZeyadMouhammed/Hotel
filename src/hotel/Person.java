package hotel;

import java.io.*;
import java.util.ArrayList;

public  class Person implements Serializable {

    protected String name;
    protected String ID;
    protected Address address;
    protected String brithDate;
    protected Guest.Gender gender;
    protected String username;
    protected String password;
    private ObjectInputStream reader;

    public Person(String name, String ID, Address address, String brithDate, int gender, String username, String password) {
        this.name = name;
        this.ID = ID;
        this.address = address;
        this.brithDate = brithDate;
        setGender(gender);
        this.username = username;
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getBrithDate() {
        return brithDate;
    }

    public void setBrithDate(String brithDate) {
        this.brithDate = brithDate;
    }

    public Gender getGender() {
        return gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return address.getCity();
    }

    public void setCity(String city) {
        address.setCity(city);
    }

    public void getNeighborhood() {
        address.getNeighborhood();
    }

    public void setNeighborhood(String neighborhood) {
        address.setNeighborhood(neighborhood);
    }

    public String getStreetName() {
        return address.getStreetName();
    }

    public void setStreetName(String streetName) {
        address.setStreetName(streetName);
    }

    public String getBuildingName() {
        return address.getBuildingName();
    }

    public void setBuildingName(String buildingName) {
        address.setBuildingName(buildingName);
    }

    enum Gender {
        Male, Female;
    }

    public void setGender(int n) {
        if (n == 0) gender = Guest.Gender.Male;
        else gender = Guest.Gender.Female;
    }

}
