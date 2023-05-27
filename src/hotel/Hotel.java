package hotel;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Hotel implements Payment, Serializable{
    private Room hotel[][] =
            {{new Single(), new Double(), new Triple(), new Quad(), new Suite(), new RoyalSuite()},
            {new Single(), new Double(), new Triple(), new Quad(), new Suite(), new RoyalSuite()},
            {new Single(), new Double(), new Triple(), new Quad(), new Suite(), new RoyalSuite()},
            {new Single(), new Double(), new Triple(), new Quad(), new Suite(), new RoyalSuite()},
            {new Single(), new Double(), new Triple(), new Quad(), new Suite(), new RoyalSuite()},
            {new Single(), new Double(), new Triple(), new Quad(), new Suite(), new RoyalSuite()},
            {new Single(), new Double(), new Triple(), new Quad(), new Suite(), new RoyalSuite()},
            {new Single(), new Double(), new Triple(), new Quad(), new Suite(), new RoyalSuite()},
            {new Single(), new Double(), new Triple(), new Quad(), new Suite(), new RoyalSuite()},
            {new Single(), new Double(), new Triple(), new Quad(), new Suite(), new RoyalSuite()}};
    private  Address address;
    private  ArrayList<Guest> guests = new ArrayList();
    private  double balance;
    private ArrayList<String> transactions = new ArrayList();
    private Employee employee;

    public Hotel(Address address) {
        this.address = address;
    }

    public  void booking(int f, int r) {
        if (hotel[f][r].booked == false) {
            hotel[f][r].booked = true;
            JOptionPane.showMessageDialog(null, "Booking is Done for Room " + hotel[f][r].getRoomNo() + "\n Room Password " + hotel[f][r].getLockPassword(), null, JOptionPane.INFORMATION_MESSAGE);
        }
        else JOptionPane.showMessageDialog(null, "Room is already booked", null, JOptionPane.INFORMATION_MESSAGE);
    }

    public  void cancelBooking(int f, int r) {
        if (hotel[f][r].booked == true) {
            hotel[f][r].booked = false;
            JOptionPane.showMessageDialog(null, "Booking is canceled for Room " + hotel[f][r].getRoomNo(), null, JOptionPane.INFORMATION_MESSAGE);
        }
    }


    public void addEmployee(Employee employee){
        this.employee=employee;
    }

    public Employee getEmployee(){
        return employee;
    }

    public  void addGuest(Guest guest) {
        guests.add(guest);
    }

    @Override
    public void addTOBalance ( double money){
        balance += money;
        String line = "money of value "+money+" is deposited "+ new Date();
        transactions.add(line);
    }

    @Override
    public void withdraw(double money) {
     balance -= money;
     String line = "money of value "+money+" is withdraw "+ new Date();
     transactions.add(line);
    }

    @Override
    public double getBalance() {
        return balance;
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

    public  int getFloors() {
        return hotel.length;
    }

    public  int floorLength() {
        return hotel[0].length;
    }

    public  Room getRoom(int floor, int room) {
        return hotel[floor][room];
    }

    public  String getRoomDate(int roomNumber) {
        for (int i = 0; i < hotel.length; i++) {
            for (int j = 0; j < hotel[0].length; j++) {
                if (roomNumber == hotel[i][j].roomNo) {
                    return ""+ hotel[i][j];
                }
            }
        }
        return "not found";
    }

    public int roomsNumber(){
        int bookedRooms=0;
        for(int i=0;i<hotel.length;i++){
            for (int j=0;j<hotel[0].length;j++){
                if(hotel[i][j].getBooked()==true) bookedRooms++;
            }
        }
        return Room.getNumOfRooms()-bookedRooms;
    }

    public Room[][] getHotel() {
        return hotel;
    }

    public void setHotel(Room[][] hotel) {
        this.hotel = hotel;
    }
}
