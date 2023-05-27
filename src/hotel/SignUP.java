package hotel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

public class SignUP extends JFrame implements ActionListener, Serializable {
    private JPanel signup;
    private JTextField nameField;
    private JTextField IDField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel password;
    private JTextField brithDateField;
    private JButton signUpButton;
    private JButton logInButton;
    private JComboBox genderBox;
    private JTextField cityFiled;
    private JTextField buildingFiled;
    private JTextField neighborFiled;
    private JTextField streetFiled;
    private static ArrayList<Guest> guests = new ArrayList();
    private int index;

    SignUP() {
        setContentPane(signup);
        this.setTitle("Hotel");
        this.setSize(750, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ImageIcon z = new ImageIcon("H.png");
        this.setIconImage(z.getImage());
        setVisible(true);
        signUpButton.addActionListener(this);
        logInButton.addActionListener(this);
        genderBox.addItem("Male");
        genderBox.addItem("Female");
        genderBox.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == signUpButton) {

            if (guests.size() == 0) {
                Address address = new Address(cityFiled.getText(), neighborFiled.getText(), streetFiled.getText(), buildingFiled.getText());
                Guest guest = new Guest(nameField.getText(), IDField.getText(), address, brithDateField.getText(), genderBox.getSelectedIndex(), usernameField.getText(), passwordField.getText());
                guests.add(index, guest);
                LogIN.addGuest(guest);
                new HotelApp(guest);
                index++;
                this.setVisible(false);

            } else {

                if (checkUsername(usernameField.getText())) {
                    Address address = new Address(cityFiled.getText(), neighborFiled.getText(), streetFiled.getText(), buildingFiled.getText());
                    Guest guest = new Guest(nameField.getText(), IDField.getText(), address, brithDateField.getText(), genderBox.getSelectedIndex(), usernameField.getText(), passwordField.getText());
                    guests.add(index, guest);
                    LogIN.addGuest(guest);
                    new HotelApp(guest);
                    index++;
                    this.setVisible(false);
                }

            }

            try {
                SignUpLogInManger.SignUpWriter();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        }


        if (e.getSource() == logInButton) {
            new LogIN();
            this.setVisible(false);
        }

    }

    public static boolean checkUsername(String username) {
        int f = 0;
        for (int i = 0; i < guests.size(); i++) {
            if (username.equals(guests.get(i).getUsername())) {
                f = 1;
            }
        }
        if (f == 1) {
            JOptionPane.showMessageDialog(null, "Username is taken please change your username");
            return false;
        }
        return true;
    }

    public static ArrayList<Guest> getGuests() {
        return guests;
    }

    public static void setGuests(ArrayList<Guest> guests) {
        SignUP.guests = guests;
    }
}
