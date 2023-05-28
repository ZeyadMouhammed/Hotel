package hotel;

import java.io.Serializable;

public class Double extends Room implements Serializable {

    private static int Area;
    private static String View;
    private static int pricePerDay;
    private static final int NumberOfBeds = 2;
    private static int roomID =2;

    public Double() {
        NumOfRooms++;
        Area=55;
        View="garden";
        pricePerDay=150;
        roomID +=10;
        roomNo= roomID;
        lock = new Lock();
    }

    public Double(int area,String view,int price) {
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

    @Override
    public  String toLine() {
        return Area+";"+pricePerDay+";"+View+";"+NumberOfBeds;
    }
    @Override
    public void formLine(String line) {

        String[] splits = line.split(";");
        int area = Integer.valueOf(splits[0]);
        int price = Integer.valueOf(splits[1]);
        String view = splits[2];
        int numberOfBeds = Integer.valueOf(splits[3]);

        Double.setArea(area);
        Double.setPricePerDay(price);
        Double.setView(view);

    }

    public static String display() {
        return  " Double " +
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
        return  " Double " +
                "\n Area " + Area +
                "\n PricePerDay " + pricePerDay +
                "\n View " + View +
                "\n NumberOfBeds " + NumberOfBeds +
                "\n Room Number " + getRoomNo() +
                "\n Room Lock " + getLock() +
                "\n Booked " + Booked();
    }



}
