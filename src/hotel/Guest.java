package hotel;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class Guest extends Person implements Payment {

    private ArrayList<Room> rooms = new ArrayList();
    private ArrayList<String> transactions = new ArrayList();
    private double wallet;

    public Guest (String name, String ID, Address address, String brithDate, int gender, String username, String password) {
        super(name, ID, address, brithDate, gender, username, password);
    }

    public void booking(Room room) {
      rooms.add(room);
    }

    public void cancelBooking(Room room) {
      rooms.remove(room);
    }

    public String RoomsNumber() {
        String a = "";

        if (rooms.size() == 1) return "" + rooms.get(0).getRoomNo();

        else if(rooms.size()>1) {
            for (int i = 0; i < rooms.size() - 1; i++) {
                a += rooms.get(i).getRoomNo() + ", ";
                int last = rooms.size()-1;
                return "[ " + a + rooms.get(last).getRoomNo() + " ]";
            }
        }
        return "no booked rooms";
    }

    public boolean checkBooking(Room room){

        for(int i=0;i<rooms.size();i++){
            if(rooms.get(i).getRoomNo()==room.roomNo) return true;
        }
        return false;
    }

    public void addTOBalance ( double money){
        wallet += money;
        String line = "money of value "+money+" is deposited "+ new Date();
        transactions.add(line);
    }

    @Override
    public void withdraw(double money) {
        wallet -= money;
        String line = "money of value "+money+" is withdraw "+ new Date();
        transactions.add(line);
    }
    @Override
    public double getBalance() {
        return wallet;
    }

    public String transactions(){
        if(transactions.size()>=1) {
            String a = " ";
            for (int i = 0; i < transactions.size(); i++) {
                a += transactions.get(i) + "\n" + " ";
            }
            return a;
        }
        return "No transactions";
        }

    @Override
    public String toString() {
        return
                "  name " + name +
                        "\n  ID " + ID +
                        "\n  address " + address +
                        "\n  brithDate  " + brithDate +
                        "\n  gender " + gender +
                        "\n  username  " + username +
                        "\n  password " + password +
                        "\n  rooms " + RoomsNumber() +
                        "\n\n  wallet " + wallet+
                        "\n\n transactions \n" + transactions();
    }

}
