package HangMan;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GameMain {
    public static void main(String[] args) {

        //susikuriame zodziu sarasa, kruis pateiktas vartotojui atspeti.
        String[] initialWordList = {"varna", "stalas", "medis", "namas", "buratinas", "kompiuteris"};
        int numberOfTries = 5;

        //skacius reikalingas masyvui elementui istraukti
        int randomNumber = ThreadLocalRandom.current().nextInt(0, 5);

        String randomWord = initialWordList[randomNumber];
        int randomWordLenght = randomWord.length();
        //Susikuriame printer klases objekta
        HangManPrinter hangManPrinter = new HangManPrinter();

        //klase leidzianti konstruoti eilutes
        StringBuffer stringBuffer = new StringBuffer();

        //konstuoja ****** eilute, kuri atvaizduos uzlepta zodi
        for (int i = 0; i < randomWordLenght; i++) {
            stringBuffer.append("*"); //****** konstruojama tokia eilute

        }

        String hiddenWord = stringBuffer.toString();

        //paslepta zodi paverskime i simbliu masyva
        char[] hiddenWordSymbolArray = hiddenWord.toCharArray();
        //randm zodi irgi paverciame i simboliu masyva
        char[] randomSybmbolArray = randomWord.toCharArray();

        System.out.println("Sveiki atvyke i zaidima kartuves!");
        System.out.println();
        System.out.println("Atspekite zodi - turite 5 bandymus suklysti");
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        do {

            System.out.println("Iveskite raide: ");
            char raide = scanner.next().charAt(0);

            //patikrinkie ar random zodyje egzisuoja ivestas simbolis.
            // -1 simbolio nerado
            if (randomWord.indexOf(raide) != -1) {
                //jeigu simbolis rastas
                System.out.println("____________________");
                System.out.println("Atspejote raide! Teisinga raide - " + raide + " Spekite toliau");
                //sukame cikla per visus zodzio simbolius ir tikriname, kurie simboliai buv atspeti

                for (int i = 0; i < hiddenWordSymbolArray.length; i++) {
                    if (randomSybmbolArray[i] == raide) {
                        hiddenWordSymbolArray[i] = raide; //****** ->*a***a*
                    }
                }

                String hiddenWordSymbolArrayString = new String(hiddenWordSymbolArray);
                //jeigu nebera neastpetu simbliu, isspausdiname teksta ir nutraukiame cikla.
                if(!hiddenWordSymbolArrayString.contains("*")){
                    //jeigu zvaigzduciu nebeliko, zodis laikomas atspetu
                    System.out.println("Sveikiname atspejote zodi "+ hiddenWordSymbolArrayString);
                } else {
                    //jeigu dar yra neatspetu simboliu
                    System.out.println("Zodis, kuri turi atspeti " + hiddenWordSymbolArrayString );
                }

            } else {
                //jei raides nepavyko atspeti, kvieciame HangManPrinter klase ir spausdiname pakaruokli
                numberOfTries = hangManPrinter.invokePrinting(numberOfTries);
                if(numberOfTries > 0){
                System.out.println("Neatspejai! Bandyk dar karta");

                }
            }

        } while (numberOfTries > 0);

        System.out.println("Zaidimas baigtas");
    }
}
