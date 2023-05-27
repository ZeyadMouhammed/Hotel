package hotel;

import java.io.Serializable;
import java.util.Random;

public class Lock implements Serializable {

    private static final String Code="1060";
    private static final String End="ZMS";
    private int Password;
    private String Card;

    public Lock(){
        Password=MakePassword();
        Card=MakeCard();
    }

    private int MakePassword(){
        Random rn = new Random();
        int x = rn.nextInt(10000);
        return x;
    }

    private String MakeCard(){
        String c =Code+getPassword()+End;
        return c;
    }


    public void setPassword(int password) {
        Password = password;
    }

    public void setCard(String card) {
        Card = card;
    }

    public String getCard() {
        return Card;
    }

    public int getPassword() {
        return Password;
    }

    @Override
    public String toString() {
        return "[ Password " + Password + " Card "+ Card +" ] " ;
    }


}
