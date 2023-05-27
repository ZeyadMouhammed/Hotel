package hotel;

import java.io.Serializable;

public class Quad extends Room implements Serializable {

    private static int Area;
    private static String View;
    private static int pricePerDay;
    private static final int NumberOfBeds = 4;
    private static int roomID=4;

    public Quad() {
        NumOfRooms++;
        Area=85;
        View="garden";
        pricePerDay=250;
        roomID +=10;
        roomNo= roomID;
        lock = new Lock();
    }

    public Quad(int area,String view,int price) {
        NumOfRooms++;
        Area=area;
        View=view;
        pricePerDay=price;
        roomID +=10;
        roomNo= roomID;
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


    public static int getModelID() {
        return roomID;
    }


    public static String display() {
        return  " Quad " +
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
        return  " Quad " +
                "\n Area " + Area +
                "\n PricePerDay " + pricePerDay +
                "\n View " + View +
                "\n NumberOfBeds " + NumberOfBeds +
                "\n Room Number " + getRoomNo() +
                "\n Room Lock " + getLock() +
                "\n Booked " + Booked();
    }
}
