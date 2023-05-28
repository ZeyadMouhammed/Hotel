package hotel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Workers extends JFrame implements ActionListener {
    private JComboBox roomBox;
    private JTextField areaFiled;
    private JTextField dayFiled;
    private JPanel workers;
    private JLabel RS;
    private JTextField viewFiled;
    private JTextField bedFiled;
    private JLabel pricePerDayLabel;
    private JLabel areaLabel;
    private JLabel RoomLabel;
    private JTextField roomNumberFiled;
    private JTextArea textArea;
    private JTextField passwordFiled;
    private JTextField cardFiled;
    private JButton apply1;
    private JButton ok;
    private JButton apply2;
    private JButton backButton;
    private JTextField balanceField;
    private JTextArea textArea1;
    private int a = -1;
    private int b = -1;

    private static Hotel hotel;

    public Workers() {

        setContentPane(workers);
        this.setTitle("Hotel Workers");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setSize(750, 750);
        ImageIcon z = new ImageIcon("H.jpg");
        this.setIconImage(z.getImage());
        setVisible(true);
        roomBox.addItem("Single");
        roomBox.addItem("Double");
        roomBox.addItem("Triple");
        roomBox.addItem("Quad");
        roomBox.addItem("Suite");
        roomBox.addItem("RoyalSuite");
        textArea.setEditable(false);
        textArea.setText("\nenter room number please then press ok");
        ok.addActionListener(this);
        apply1.addActionListener(this);
        apply2.addActionListener(this);
        roomBox.addActionListener(this);
        backButton.addActionListener(this);
        balanceField.setText(String.valueOf("Balance " + hotel.getBalance()));
        textArea1.setText(hotel.transactions());

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == roomBox) {
            if (roomBox.getSelectedIndex() == 0) {
                areaFiled.setText(String.valueOf(Single.getArea()));
                viewFiled.setText(Single.getView());
                dayFiled.setText(String.valueOf(Single.getPricePerDay()));
                bedFiled.setEditable(false);
                bedFiled.setText(String.valueOf(Single.getNumberOfBeds()));
            } else if (roomBox.getSelectedIndex() == 1) {
                areaFiled.setText(String.valueOf(Double.getArea()));
                viewFiled.setText(Double.getView());
                dayFiled.setText(String.valueOf(Double.getPricePerDay()));
                bedFiled.setEditable(false);
                bedFiled.setText(String.valueOf(Double.getNumberOfBeds()));
            } else if (roomBox.getSelectedIndex() == 2) {
                areaFiled.setText(String.valueOf(Triple.getArea()));
                viewFiled.setText(Triple.getView());
                dayFiled.setText(String.valueOf(Triple.getPricePerDay()));
                bedFiled.setEditable(false);
                bedFiled.setText(String.valueOf(Triple.getNumberOfBeds()));
            } else if (roomBox.getSelectedIndex() == 3) {
                areaFiled.setText(String.valueOf(Quad.getArea()));
                viewFiled.setText(Quad.getView());
                dayFiled.setText(String.valueOf(Quad.getPricePerDay()));
                bedFiled.setEditable(false);
                bedFiled.setText(String.valueOf(Quad.getNumberOfBeds()));
            } else if (roomBox.getSelectedIndex() == 4) {
                areaFiled.setText(String.valueOf(Suite.getArea()));
                viewFiled.setText(Suite.getView());
                dayFiled.setText(String.valueOf(Suite.getPricePerDay()));
                bedFiled.setEditable(true);
                bedFiled.setText(String.valueOf(Suite.getNumberOfBeds()));
            } else if (roomBox.getSelectedIndex() == 5) {
                areaFiled.setText(String.valueOf(RoyalSuite.getArea()));
                viewFiled.setText(RoyalSuite.getView());
                dayFiled.setText(String.valueOf(RoyalSuite.getPricePerDay()));
                bedFiled.setEditable(true);
                bedFiled.setText(String.valueOf(RoyalSuite.getNumberOfBeds()));
            }
        }

        if (e.getSource() == apply1) {
            if (roomBox.getSelectedIndex() == 0) {
                Single.setArea(Integer.valueOf(areaFiled.getText()));
                Single.setView(viewFiled.getText());
                Single.setPricePerDay(Integer.valueOf(dayFiled.getText()));
            } else if (roomBox.getSelectedIndex() == 1) {
                Double.setArea(Integer.valueOf(areaFiled.getText()));
                Double.setView(viewFiled.getText());
                Double.setPricePerDay(Integer.valueOf(dayFiled.getText()));
            } else if (roomBox.getSelectedIndex() == 2) {
                Triple.setArea(Integer.valueOf(areaFiled.getText()));
                Triple.setView(viewFiled.getText());
                Triple.setPricePerDay(Integer.valueOf(dayFiled.getText()));
            } else if (roomBox.getSelectedIndex() == 3) {
                Quad.setArea(Integer.valueOf(areaFiled.getText()));
                Quad.setView(viewFiled.getText());
                Quad.setPricePerDay(Integer.valueOf(dayFiled.getText()));
            } else if (roomBox.getSelectedIndex() == 4) {
                Suite.setArea(Integer.valueOf(areaFiled.getText()));
                Suite.setView(viewFiled.getText());
                Suite.setPricePerDay(Integer.valueOf(dayFiled.getText()));
                Suite.setNumberOfBeds(Integer.valueOf(bedFiled.getText()));
            } else if (roomBox.getSelectedIndex() == 5) {
                RoyalSuite.setArea(Integer.valueOf(areaFiled.getText()));
                RoyalSuite.setView(viewFiled.getText());
                RoyalSuite.setPricePerDay(Integer.valueOf(dayFiled.getText()));
                RoyalSuite.setNumberOfBeds(Integer.valueOf(bedFiled.getText()));
            }

            try {
                RoomManger.roomWriter();
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

        if (e.getSource() == ok) {
            int f = 0;
            for (int i = 0; i < hotel.getFloors(); i++) {
                for (int j = 0; j < hotel.floorLength(); j++) {
                    if (roomNumberFiled.getText().equals(String.valueOf(hotel.getRoom(i, j).getRoomNo()))) {
                        textArea.setText("\n" + hotel.getRoom(i, j).toString());
                        f = 1;
                        a = i;
                        b = j;
                        break;
                    }
                }
            }

            if (f == 0) textArea.setText("\nRoom number is wrong re_enter a number");

            if (a != -1) {
                passwordFiled.setText(String.valueOf(hotel.getRoom(a, b).getLockPassword()));
                cardFiled.setText(String.valueOf(hotel.getRoom(a, b).getLock().getCard()));
            }
        }

        if (e.getSource() == apply2) {
            if (a != -1) hotel.getRoom(a, b).setLock(cardFiled.getText(), Integer.valueOf(passwordFiled.getText()));

            try {
                RoomManger.roomWriter();
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




        if (e.getSource() == backButton) {
            new LogIN();
            this.setVisible(false);
        }

    }

    public static void setHotel(Hotel hotel) {
        Workers.hotel = hotel;
    }

}
