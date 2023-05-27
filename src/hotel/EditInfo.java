package hotel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditInfo extends JFrame implements ActionListener {
    private JLabel Title;
    private JTextField IDF;
    private JTextField nameF;
    private JTextField brithF;
    private JTextField cityF;
    private JTextField streetFiled;
    private JTextField usernameF;
    private JTextField passwordF;
    private JTextField neighborhoodFiled;
    private JTextField BuildingF;
    private JTextArea textArea1;
    private JButton applyButton;
    private JButton backButton;
    private JComboBox genderBox;
    private JPanel EditInfo;
    private Guest guest;

    public EditInfo(Guest guest) {
        setContentPane(EditInfo);
        this.guest = guest;
        this.setTitle("Hotel");
        this.setSize(750, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ImageIcon z = new ImageIcon("H.jpg");
        this.setIconImage(z.getImage());
        setVisible(true);
        textArea1.setText("\n\n\n" + guest.toString());
        textArea1.setEditable(false);
        nameF.setText(guest.getName());
        IDF.setText(guest.getID());
        brithF.setText(guest.getBrithDate());
        cityF.setText(guest.getCity());
        streetFiled.setText(guest.getBuildingName());
        usernameF.setText(guest.getUsername());
        passwordF.setText(guest.getPassword());
        genderBox.addItem("Male");
        genderBox.addItem("Female");
        genderBox.getSelectedIndex();
        neighborhoodFiled.setText(guest.getStreetName());
        BuildingF.setText(String.valueOf(guest.getBuildingName()));
        genderBox.addActionListener(this);
        applyButton.addActionListener(this);
        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == applyButton) {
            guest.setName(nameF.getText());
            guest.setID(IDF.getText());
            guest.setBrithDate(brithF.getText());

            if (guest.getUsername().equals(usernameF.getText())) {
                guest.setUsername(usernameF.getText());
            } else if (SignUP.checkUsername(usernameF.getText())) {
                guest.setUsername(usernameF.getText());
            }
            guest.setPassword(passwordF.getText());
            guest.setGender(genderBox.getSelectedIndex());
            guest.setCity(cityF.getText());
            guest.setNeighborhood(neighborhoodFiled.getText());
            guest.setStreetName(streetFiled.getText());
            guest.setBuildingName(BuildingF.getText());
            textArea1.setText("\n\n\n" + guest.toString());

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

        if (e.getSource() == backButton) {
            new HotelApp(guest);
            this.setVisible(false);
        }

    }

}
