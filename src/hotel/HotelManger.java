package hotel;

import java.io.*;

public class HotelManger implements Serializable {

    private static Hotel hotel;
    private static File file = new File("Hotel.txt");
    private static FileOutputStream writer;
    private static ObjectOutputStream writerStream;
    private static FileInputStream reader;
    private static ObjectInputStream readerStream;


    public static void setHotel(Hotel hotel1){
        hotel =hotel1;
    }

    public static Hotel getHotel() {
        return hotel;
    }

    public static void HotelWriter() throws Exception {

        writer = new FileOutputStream("Hotel.txt");
        writerStream = new ObjectOutputStream(writer);

        writerStream.writeObject(hotel);
        writerStream.flush();
        writerStream.close();

    }

    public static void HotelReader() throws Exception {

        if (file.length() != 0) {

            reader = new FileInputStream("Hotel.txt");
            readerStream = new ObjectInputStream(reader);

            hotel = (Hotel) readerStream.readObject();
            readerStream.close();

        }
    }

    public static Room[] floor(){
        return hotel.getHotel()[0];
    }

    public static void clear() {

        file.delete();

        file = new File("Hotel.txt");

    }

}
