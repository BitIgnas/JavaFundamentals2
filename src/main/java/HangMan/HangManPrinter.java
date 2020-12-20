package HangMan;

public class HangManPrinter {

    public int invokePrinting(int bandymai) {
        if (bandymai == 5) {
            firstMistake();
        } else if (bandymai == 4) {
            secondMistake();
        } else if (bandymai == 3) {
            thirdMistake();
        } else if (bandymai == 2) {
            fourthMistake();
        } else if (bandymai == 1) {
            fifthMistake();
        }
        bandymai = bandymai - 1;
        return bandymai;
    }
    private void firstMistake() {
        System.out.println("KLAIDA!");
        System.out.println("____________");
        System.out.println("      |     ");
        System.out.println("      O     ");
        System.out.println();
    }
    private void secondMistake() {
        System.out.println("KLAIDA!");
        System.out.println("____________");
        System.out.println("      |     ");
        System.out.println("      O     ");
        System.out.println("      |     ");
        System.out.println();
    }
    private void thirdMistake() {
        System.out.println("KLAIDA!");
        System.out.println("____________");
        System.out.println("      |     ");
        System.out.println("      O     ");
        System.out.println("     /|     ");
        System.out.println();
    }
    private void fourthMistake() {
        System.out.println("KLAIDA!");
        System.out.println("____________");
        System.out.println("      |     ");
        System.out.println("      O     ");
        System.out.println("     /|\\   ");
        System.out.println();
    }
    private void fifthMistake() {
        System.out.println("KLAIDA!");
        System.out.println("____________");
        System.out.println("      |     ");
        System.out.println("      O     ");
        System.out.println("     /|\\   ");
        System.out.println("     /\\    ");
        System.out.println();
    }
}
