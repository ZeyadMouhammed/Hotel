package hotel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

public class LogIN extends JFrame implements ActionListener, Serializable {
    private JTextField usernameF;
    private JPasswordField passwordF;
    private JPanel Login;
    private JLabel username;
    private JLabel password;
    private JButton signUpB;
    private JButton logInB;
    private static int index;
    private static ArrayList<Guest> guests = new ArrayList();
    private Employee employee;

    LogIN() {
        setContentPane(Login);
        this.setTitle("Hotel");
        this.setSize(450, 450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ImageIcon z = new ImageIcon("H.jpg");
        this.setIconImage(z.getImage());
        setVisible(true);
        signUpB.addActionListener(this);
        logInB.addActionListener(this);
        employee = HotelApp.employee();
    }

    public static void addGuest(Guest guest) {
        guests.add(index, guest);
        index++;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signUpB) {
            new SignUP();
            this.setVisible(false);
        }

        if (e.getSource() == logInB) {

            int f = 0;
            int z = 0;

            for (int i = 0; i < guests.size(); i++) {
                if (usernameF.getText().equals(guests.get(i).getUsername()) && passwordF.getText().equals(guests.get(i).getPassword())) {
                    f = 1;
                    new HotelApp(guests.get(z));
                    this.setVisible(false);
                    break;
                }
                z++;
            }

            if (usernameF.getText().equals(employee.getUsername()) && passwordF.getText().equals(employee.getPassword())) {
                new Workers();
                this.setVisible(false);
            } else if (f == 0) {
                JOptionPane.showMessageDialog(null, "Wrong input", null, JOptionPane.WARNING_MESSAGE);
            }

        }

    }

    public static void setGuests(ArrayList<Guest> guests) {
        LogIN.guests = guests;
    }
}

