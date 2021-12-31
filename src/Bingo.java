import java.util.*;

public class Bingo {
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    static void menuPrompt() {
        System.out.println("Welcome to Bingo\nPlease select an option.\nOptions:\n1. Play\n2. Rules\n3. Credits");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                play();
                menuPrompt();
                break;
            case 2:
                rules();
                menuPrompt();
                break;
            case 3:
                credits();
                menuPrompt();
                break;
            default:
                System.out.println("Please enter a number between 1-3 according to your desired selection.");
                menuPrompt();
                break;
        }
    }

    static String drawCombo() {
        String bingo = "BINGO";
        char resultLetter = bingo.charAt(rand.nextInt(5));

        int low = 1;
        int high = 50;
        int resultNum = rand.nextInt(high - low) + low;

        String chance = resultLetter + String.valueOf(resultNum);
        System.out.println("Computer drew: " + chance);

        return chance;
    }

    static String[] drawBingoCard() {
        String bingo = "BINGO";
        char resultLetter = bingo.charAt(rand.nextInt(5));

        int low = 1;
        int high = 50;
        int resultNum = rand.nextInt(high - low) + low;

        String[] bingoCard = new String[20];

        for (int i = 0; i < 20; i++) {
            Integer number = rand.nextInt((high - low) + low);
            char letter = bingo.charAt(rand.nextInt(5));
            String combo = letter + String.valueOf(number);
            bingoCard[i] = combo;
        }

        return bingoCard;
    }

    static void printBingoCard(String[] bingoCard) {
        System.out.println();
        System.out.println("| \tB\t | \tI\t | \tN\t | \tG\t | \tO\t |\t");
        System.out.println("-------------------------------------------");
        System.out.println("| \t" + bingoCard[0] + "\t | \t"
                + bingoCard[1] + "\t | \t"
                + bingoCard[2] + "\t | \t"
                + bingoCard[3] + "\t | \t"
                + bingoCard[4] + "\t |\t");
        System.out.println("-------------------------------------------");
        System.out.println("| \t" + bingoCard[5] + "\t | \t"
                + bingoCard[6] + "\t | \t"
                + bingoCard[7] + "\t | \t"
                + bingoCard[8] + "\t | \t"
                + bingoCard[9] + "\t |\t");
        System.out.println("-------------------------------------------");
        System.out.println("| \t" + bingoCard[10] + "\t | \t"
                + bingoCard[11] + "\t | \t"
                + bingoCard[12] + "\t | \t"
                + bingoCard[13] + "\t | \t"
                + bingoCard[14] + "\t |\t");
        System.out.println("-------------------------------------------");
        System.out.println("| \t" + bingoCard[15] + "\t | \t"
                + bingoCard[16] + "\t | \t"
                + bingoCard[17] + "\t | \t"
                + bingoCard[18] + "\t | \t"
                + bingoCard[19] + "\t |\t");
    }

    static void play() {
        clearConsole();
        System.out.println("Play");

        // Generate and save bingo card
        final String[] userBingoCard = drawBingoCard();

        // Generate and save bingo number
        String drawnChance = drawCombo();

        printBingoCard(userBingoCard);

//        while(true){
//            if ()
//        }

    }

    static void rules() {
        clearConsole();
        System.out.println("Rules");
    }

    static void credits() {
        clearConsole();
        System.out.println("Credits");
    }

    static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }

        } catch (final Exception e) {
            System.out.println("Could not clear console.\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        menuPrompt();
    }
}
