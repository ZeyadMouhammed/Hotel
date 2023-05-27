package hotel;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Address hotelAddress = new Address("Alexandria","","");

        Hotel hotel = new Hotel(hotelAddress);

        Employee employee = new Employee("xxx","xx",hotelAddress,"zz",0,"Workers","123");

        hotel.addEmployee(employee);

        HotelManger.setHotel(hotel);
        HotelManger.HotelReader();

        RoomManger.setRoom(HotelManger.floor());
        HotelApp.setHotel(HotelManger.getHotel());
        Workers.setHotel(HotelManger.getHotel());

        RoomManger.HotelReader();
        SignUpLogInManger.SignUpReader();
        new LogIN();

        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        if(x==1) {
            RoomManger.HotelReader();
        }



    }
}
