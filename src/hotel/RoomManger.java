package hotel;

import java.io.*;
import java.util.Scanner;

public class RoomManger {
    private static File file = new File("Room.txt");
    private static FileWriter writer;
    private static Room[] rooms;


    public static void roomWriter() throws Exception{

        writer = new FileWriter("Room.txt");

        writer.append(rooms[0].toLine()+"\n");
        writer.append(rooms[1].toLine()+"\n");
        writer.append(rooms[2].toLine()+"\n");
        writer.append(rooms[3].toLine()+"\n");
        writer.append(rooms[4].toLine()+"\n");
        writer.append(rooms[5].toLine());
        writer.close();

    }

    public static void roomReader() throws Exception{

        Scanner sc = new Scanner(file);

      if(file.length()!=0) {
          int i = 0;
          while (sc.hasNextLine()) {
              String line = sc.next();
              rooms[i].formLine(line);
              i++;
          }
          sc.close();
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
