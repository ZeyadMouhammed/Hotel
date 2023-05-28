package hotel;

import java.io.Serializable;

public abstract class Room implements Serializable  {

    protected Boolean booked = false;
    protected int roomNo;
    protected static int NumOfRooms;
    protected Lock lock;
    protected int numberOfDays;

    public static int getNumOfRooms() {
        return NumOfRooms;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setPassword(int password) {
        lock.setPassword(password);
    }

    public int getLockPassword() {
        return lock.getPassword();
    }

    public void setLock(String card, int password) {
        lock.setCard(card);
        lock.setPassword(password);
    }

    public Boolean getBooked() {
        return booked;
    }

    public Lock getLock() {
        return lock;
    }

    public String Booked() {
        if (booked == true) return "yes";
        else return "no";
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public abstract void formLine(String line);

    public abstract String toLine();

    public abstract int getAreaRoom();
    public abstract String getViewRoom();
    public abstract int getNumberOfBedsRoom();
    public abstract int getPrice();
    public abstract String toString();
}


