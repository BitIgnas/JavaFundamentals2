package BankApplication;

import netscape.javascript.JSUtil;
import sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class BankAccount {

    public int balance;
    public int previousTransaction;
    public String customerName;
    public String customerId;

    public BankAccount(String customerName, String customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }

    public void deposit(int amountToDeposit) {
        //business logic goes here
        if (amountToDeposit > 0) {
            balance = balance + amountToDeposit; //balance += amountToDeposit
            previousTransaction = balance;
        } else {
            System.out.println("Negalima ivesti neigiamos sumos");
        }
    }

    public void withdraw(int amountToWithdraw) {
        //ideti checka, kuris tikrintu suma.
        balance = balance - amountToWithdraw;
        previousTransaction = -amountToWithdraw;
    }

    //parodyk paskutini atlikta veiksma
    public void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Buvo ivesta pinigu suma " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Buvo isimta pinigu suma " + previousTransaction);
        } else {
            System.out.println("Jokiu veiksmu nebuvo atlika.");
        }
    }

    public void showMenu(Creditcard creditcard) {

        boolean isCreditCardValid = checkCardDetails(creditcard);

        if (isCreditCardValid) {

            char option = 'p';
            Scanner scanner = new Scanner(System.in);
            System.out.println("Sveiki prisijungia " + customerName);
            System.out.println("Jusu vartotojo ID: " + customerId);
            System.out.println();
            System.out.println("a. Saskaitos likutis");
            System.out.println("b. Prideti pinigu");
            System.out.println("d. Paskutinis veiksmas");
            System.out.println("e. Iseiti is programos");

            do {
                //atliekame veiksma viena karta
                System.out.println("=========================");
                System.out.println("Pasirinkite norima operacija");
                System.out.println("=========================");
                option = scanner.next().charAt(0);

                switch (option) {
                    case 'a':
                        System.out.println("=========================");
                        System.out.println("Jusu saskaitos likutis - " + balance);
                        System.out.println("=========================");
                        break;

                    case 'b':
                        System.out.println("=========================");
                        System.out.println("Iveskite pinigu suma, kuria norite prideti");
                        System.out.println("=========================");
                        int amountToDeposit = scanner.nextInt();
                        deposit(amountToDeposit);
                        System.out.println("Prideta suma: " + amountToDeposit);
                        break;

                    case 'c':
                        System.out.println("=========================");
                        System.out.println("Iveskite pinigu suma, kuria norite isimti");
                        System.out.println("=========================");
                        int amountToWithdraw = scanner.nextInt();
                        withdraw(amountToWithdraw);
                        break;

                    case'd':
                        System.out.println("=========================");
                        System.out.println("Jusu paskutinis atliktas veiksmas: ");
                        if(previousTransaction > 0){
                            System.out.println("Buvo prideta " + previousTransaction);
                        } else {
                            System.out.println("Buvo isimta pinigu " + previousTransaction);
                        }
                        System.out.println("=========================");
                        break;

                    case 'e':
                        System.out.println("Aciu, kad naudojates musu paslaugomis");
                        break;


                    default:
                        System.out.println("Neteisinga pasirinkta operacija");

                }
            } while (option != 'e'); //kol si salyg ayra tenkinama


        } else {
            System.out.println("Atmesta");
        }
    }

    //sukurti atskira klase korteliu validavimui
    private boolean checkCardDetails(Creditcard creditcard) {
        System.out.println("Iveskite PIN koda: ");
        Scanner scanner = new Scanner(System.in);
        int pin = scanner.nextInt();

        if (pin == creditcard.cardPin) {
            return true;
        } else {
            return false;
        }

        //return pin == creditCard.cardPin; kitas variantas
    }
}
