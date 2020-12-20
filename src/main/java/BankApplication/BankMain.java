package BankApplication;

public class BankMain {
    public static void main(String[] args) {
        Creditcard creditcard = new Creditcard(1234, "Ignas");
        BankAccount bankAccount = new BankAccount("Ignas", "4");
        bankAccount.showMenu(creditcard);
    }
}
