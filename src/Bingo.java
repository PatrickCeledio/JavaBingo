import java.util.*;

public class Bingo {
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    static void menuPrompt() {
        System.out.println("Welcome to Bingo\nPlease select an option.\nOptions:\n1. Play\n2. Rules\n3. Credits\n4. Debug");
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
            case 4:
                menuPrompt();
                break;
            default:
                System.out.println("Please enter a number between 1-3 according to your desired selection.");
                menuPrompt();
                break;
        }
    }

    // Return bingo number. e.g. "B10", "G25", etc..
    static String drawCombo() {
        int chance2 = rand.nextInt(5);

        switch(chance2){
            case 0:
                int lowB = 1;
                int highB = 10;
                int resultNumB = rand.nextInt(highB - lowB) + lowB;
                return "B" + String.valueOf(resultNumB);
            case 1:
                int lowI = 11;
                int highI = 20;
                int resultNumI = rand.nextInt(highI - lowI) + lowI;
                return "I" + String.valueOf(resultNumI);
            case 2:
                int lowN = 21;
                int highN = 30;
                int resultNumN = rand.nextInt(highN - lowN) + lowN;
                return "N" + String.valueOf(resultNumN);
            case 3:
                int lowG = 31;
                int highG = 40;
                int resultNumG = rand.nextInt(highG - lowG) + lowG;
                return "G" + String.valueOf(resultNumG);
            case 4:
                int lowO = 41;
                int highO = 50;
                int resultNumO = rand.nextInt(highO - lowO) + lowO;
                return "O" + String.valueOf(resultNumO);
            default:
                System.out.println(chance2);
                return "How did you get here?";
        }
    }

    static String[] drawBingoCard() {
        String[] bingoCard = new String[20];

        for (int i = 0; i < 20; i++) {
            bingoCard[i] = drawCombo();
        }

        return bingoCard;
    }

    static void printBingoCard(String[] bingoCard) {
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

    static void bingoGame (String[] bingoCard, String chance) {

        // Print Bingo Number
        System.out.println("");

        printBingoCard(bingoCard);
        //System.out.println("New Bingo Number: " + chance);
        //System.out.println(Arrays.toString(bingoCard) + " -- length: " + bingoCard.length);
        //System.out.println(chance);

        for (int i=0; i<bingoCard.length; i++){
            // Debug purposes
            // System.out.println("Comparing: " + chance + " and " + bingoCard[i]);
            if (chance.equals(bingoCard[i])){
                System.out.println("Match!");
                System.out.println("WIN: " + chance + " and " + bingoCard[i]);
                bingoCard[i] = "(X)";
            }else{
                //System.out.println("No match.");
            }
        }
    }

    static void play() {
        clearConsole();
        System.out.println("Play");

        // Generate and save bingo card
        final String[] userBingoCard = drawBingoCard();

        // Show bingo card to user
        printBingoCard(userBingoCard);

        boolean gameFinished = false;
        while(!gameFinished){
            System.out.println("1. Check for matching number\n2. Exit");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Check for matching number");
                    // Generate and save bingo number
                    String drawnChance = drawCombo();

                    // Initiate search for matching bingo number from bingo card
                    bingoGame(userBingoCard, drawnChance);
                    break;
                case 2:
                    System.out.println("Exit.");
                    break;
                default:
                    System.out.printf("How did you get here?");
                    break;
            }

        }


        // Generate and save bingo number
        String drawnChance = drawCombo();

        // Initiate search for matching bingo number from bingo card
        bingoGame(userBingoCard, drawnChance);

        // Print Bingo Card
        printBingoCard(userBingoCard);
        System.out.println("Draw new bingo number");



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
