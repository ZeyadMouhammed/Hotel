package hotel;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Address hotelAddress = new Address("Alexandria","","");

        Hotel hotel = new Hotel("Hotel",hotelAddress);

        Employee employee = new Employee("xxx","xx",hotelAddress,"zz",0,"Workers","123");

        hotel.addEmployee(employee);

        HotelManger.setHotel(hotel);
        HotelManger.HotelReader();

        RoomManger.setRoom(HotelManger.floor());
        RoomManger.roomReader();
        HotelApp.setHotel(HotelManger.getHotel());
        Workers.setHotel(HotelManger.getHotel());


        SignUpLogInManger.SignUpReader();
        new LogIN();

    }
}
