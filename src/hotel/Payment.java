package hotel;

public interface Payment {

     void addTOBalance(double money);

     void withdraw(double money);

     double getBalance();

     String transactions();

}
