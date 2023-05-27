package hotel;

import java.io.*;

public class RoomManger {
    private static File file = new File("Room.txt");
    private static FileOutputStream writer;
    private static ObjectOutputStream writerStream;
    private static FileInputStream reader;
    private static ObjectInputStream readerStream;
    private static Room rooms[];

    public static void HotelWriter() throws Exception {

        writer = new FileOutputStream("Room.txt");
        writerStream = new ObjectOutputStream(writer);

        writerStream.writeObject(rooms);
        writerStream.flush();
        writerStream.close();

    }

    public static void HotelReader() throws Exception {

        System.out.println(file.length());

        if (file.length() != 0) {

            reader = new FileInputStream("Room.txt");
            readerStream = new ObjectInputStream(reader);

            rooms = (Room[]) readerStream.readObject();
            readerStream.close();

            System.out.println(rooms[0].getAreaRoom());

            Single.setArea(rooms[0].getAreaRoom());
            Single.setView(rooms[0].getViewRoom());
            Single.setPricePerDay(rooms[0].getPrice());

        }
    }


    public static void clear() {

        file.delete();

        file = new File("Room.txt");

    }

    public static void setRoom(Room[] rooms1){
        rooms=rooms1;
    }

}
