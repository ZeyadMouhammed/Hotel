package hotel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelApp extends JFrame implements ActionListener {
    private JButton cancelBookingB;
    private JButton bookB;
    private JButton signUpB;
    private JComboBox floorBox;
    private JComboBox roomBox;
    private JLabel hotel;
    private JPanel HotelApp;
    private JLabel floorLabel;
    private JTextArea textArea;
    private JLabel roomLabel;
    private JButton editInfoButton;
    private JButton logInB;
    private JPanel panel2;
    private JTextArea textRoom2;
    private JTextArea textRoom1;
    private JTextField roomNumber;
    private JButton addToWalletButton;
    private JTextField numberOfRooms;
    private Guest guest;

    private static Hotel Hotel;

    public HotelApp(Guest guest) {
        this.guest = guest;
        setContentPane(HotelApp);
        this.setTitle("Hotel");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setSize(750, 750);
        ImageIcon z = new ImageIcon("H.jpg");
        this.setIconImage(z.getImage());
        setVisible(true);
        floorBox.addItem("Floor 1");
        floorBox.addItem("Floor 2");
        floorBox.addItem("Floor 3");
        floorBox.addItem("Floor 4");
        floorBox.addItem("Floor 5");
        floorBox.addItem("Floor 6");
        floorBox.addItem("Floor 7");
        floorBox.addItem("Floor 8");
        floorBox.addItem("Floor 9");
        floorBox.addItem("Floor 10");
        roomBox.addItem("Single");
        roomBox.addItem("Double");
        roomBox.addItem("Triple");
        roomBox.addItem("Quad");
        roomBox.addItem("Suite");
        roomBox.addItem("RoyalSuite");
        signUpB.addActionListener(this);
        logInB.addActionListener(this);
        bookB.addActionListener(this);
        cancelBookingB.addActionListener(this);
        editInfoButton.addActionListener(this);
        addToWalletButton.addActionListener(this);
        textRoom1.setEditable(false);
        textRoom2.setEditable(false);
        textRoom1.setText(half1());
        textRoom2.setText(half2());
        roomNumber.setEditable(false);
        roomNumber.setText(" Available rooms " + String.valueOf(Hotel.roomsNumber()));
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signUpB) {
            new SignUP();
            this.setVisible(false);
        }
        if (e.getSource() == logInB) {
            new LogIN();
            this.setVisible(false);
        }
        if (e.getSource() == bookB) {
            if (Hotel.getRoom(floorBox.getSelectedIndex(), roomBox.getSelectedIndex()).booked == false) {
                Hotel.getRoom(floorBox.getSelectedIndex(), roomBox.getSelectedIndex()).setNumberOfRentedDays(Integer.valueOf(JOptionPane.showInputDialog("enter number of days")));
                double price = Hotel.getRoom(floorBox.getSelectedIndex(), roomBox.getSelectedIndex()).getPrice() * Hotel.getRoom(floorBox.getSelectedIndex(), roomBox.getSelectedIndex()).getNumberOfRentedDays();
                if (guest.getBalance() >= price) {
                    guest.withdraw(price);
                    Hotel.addTOBalance(price);
                    Hotel.booking(floorBox.getSelectedIndex(), roomBox.getSelectedIndex());
                    guest.booking(Hotel.getRoom(floorBox.getSelectedIndex(), roomBox.getSelectedIndex()));
                    roomNumber.setText(" Available rooms " + String.valueOf(Hotel.roomsNumber()));
                    Hotel.addGuest(guest);
                } else {
                    JOptionPane.showMessageDialog(null, "not enough money in your wallet");
                    Hotel.getRoom(floorBox.getSelectedIndex(), roomBox.getSelectedIndex()).setNumberOfRentedDays(0);
                }
            } else JOptionPane.showMessageDialog(null, "Room is already booked", null, JOptionPane.INFORMATION_MESSAGE);


            HotelManger.clear();
            try {
                HotelManger.HotelWriter();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

            SignUpLogInManger.clear();
            try {
                SignUpLogInManger.SignUpWriter();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }


        }
        if (e.getSource() == cancelBookingB) {
            if(Hotel.getRoom(floorBox.getSelectedIndex(), roomBox.getSelectedIndex()).getBooked()) {
                if (guest.checkBooking(Hotel.getRoom(floorBox.getSelectedIndex(), roomBox.getSelectedIndex()))) {
                    double price = Hotel.getRoom(floorBox.getSelectedIndex(), roomBox.getSelectedIndex()).getPrice() * Hotel.getRoom(floorBox.getSelectedIndex(), roomBox.getSelectedIndex()).getNumberOfRentedDays();
                    Hotel.cancelBooking(floorBox.getSelectedIndex(), roomBox.getSelectedIndex());
                    Hotel.withdraw(price);
                    guest.cancelBooking(Hotel.getRoom(floorBox.getSelectedIndex(), roomBox.getSelectedIndex()));
                    guest.addTOBalance(price);
                    roomNumber.setText(" Available rooms " + String.valueOf(Hotel.roomsNumber()));
                    HotelManger.clear();
                } else JOptionPane.showMessageDialog(null, "you did not book this room");
            } else JOptionPane.showMessageDialog(null, "Room is not booked");
            HotelManger.clear();
            try {
                HotelManger.HotelWriter();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

            SignUpLogInManger.clear();
            try {
                SignUpLogInManger.SignUpWriter();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        }
        if (e.getSource() == editInfoButton) {
            new EditInfo(guest);
            this.setVisible(false);
        }

        if (e.getSource() == addToWalletButton) {
            int a = Integer.valueOf(JOptionPane.showInputDialog("enter the amount of money you want to add"));
            guest.addTOBalance(a);

            SignUpLogInManger.clear();
            try {
                SignUpLogInManger.SignUpWriter();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

            HotelManger.clear();
            try {
                HotelManger.HotelWriter();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        }

    }

    public static String half1() {
        return "\n" + Single.display() + "\n\n" +
                Double.display() + "\n\n" +
                Triple.display() + "\n";
    }

    public static String half2() {
        return "\n" + Quad.display() + "\n\n" +
                Suite.display() + "\n\n" +
                RoyalSuite.display() + "\n";
    }

    public static void setHotel(Hotel hotel) {
        Hotel = hotel;
    }

    public static Employee employee() {
        return Hotel.getEmployee();
    }

}
