package hotel;

import java.io.*;
import java.util.ArrayList;

public class SignUpLogInManger implements Serializable {

    private static File file = new File("SignUpLogin.txt");
    private static FileOutputStream writer;
    private static ObjectOutputStream writerStream;
    private static FileInputStream reader;
    private static ObjectInputStream readerStream;

    public static void SignUpWriter() throws Exception {

        writer = new FileOutputStream("SignUpLogin.txt");
        writerStream = new ObjectOutputStream(writer);

        writerStream.writeObject(SignUP.getGuests());
        writerStream.flush();
        writerStream.close();

    }

    public static void SignUpReader() throws Exception {

        System.out.println(file.length());

        if (file.length() != 0) {

            ArrayList<Guest> guests = new ArrayList<Guest>();

            reader = new FileInputStream("SignUpLogin.txt");
            readerStream = new ObjectInputStream(reader);

            guests = (ArrayList<Guest>) readerStream.readObject();
            readerStream.close();

            SignUP.setGuests(guests);
            LogIN.setGuests(guests);
        }
    }


    public static void clear() {

    file.delete();

    file = new File("SignUpLogin.txt");

    }

}


