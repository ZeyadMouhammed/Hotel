package hotel;

import java.io.Serializable;

public class Suite extends Room implements Serializable {

    private static int Area;
    private static String View;
    private static int pricePerDay;
    private static int NumberOfBeds;
    private static int roomID = 5;

    public Suite() {
        NumOfRooms++;
        Area = 65;
        View = "bay";
        pricePerDay = 200;
        NumberOfBeds = 1;
        roomID += 10;
        roomNo = roomID;
        lock = new Lock();
    }

    public Suite(int area, String view, int price) {
        NumOfRooms++;
        Area = area;
        View = view;
        pricePerDay = price;
        NumberOfBeds = 1;
        roomID += 10;
        roomNo = roomID;
        lock = new Lock();
    }

    public Suite(int area, String view, int price, int numberOfBeds) {
        NumOfRooms++;
        Area = area;
        View = view;
        pricePerDay = price;
        NumberOfBeds = numberOfBeds;
        roomID += 10;
        roomNo = roomID;
        lock = new Lock();
    }

    public static int getArea() {
        return Area;
    }

    public static void setArea(int area) {
        Area = area;
    }

    public static String getView() {
        return View;
    }

    public static void setView(String view) {
        View = view;
    }

    public static int getPricePerDay() {
        return pricePerDay;
    }

    public static void setPricePerDay(int price) {
        pricePerDay = price;
    }

    public static int getNumberOfBeds() {
        return NumberOfBeds;
    }

    public static void setNumberOfBeds(int numberOfBeds) {
        NumberOfBeds = numberOfBeds;
    }

    public static int getModelID() {
        return roomID;
    }


    public static String display() {
        return " Suite " +
                "\n Area " + Area +
                "\n PricePerDay " + pricePerDay +
                "\n View " + View +
                "\n NumberOfBeds " + NumberOfBeds;
    }

    @Override
    public int getAreaRoom() {
        return Area;
    }

    @Override
    public String getViewRoom() {
        return View;
    }

    @Override
    public int getNumberOfBedsRoom() {
        return NumberOfBeds;
    }

    @Override
    public int getPrice() {
        return pricePerDay;
    }

    @Override
    public String toString() {
        return " Suite " +
                "\n Area " + Area +
                "\n PricePerDay " + pricePerDay +
                "\n View " + View +
                "\n NumberOfBeds " + NumberOfBeds +
                "\n Room Number " + getRoomNo() +
                "\n Room Lock " + getLock() +
                "\n Booked " + Booked();
    }
}
