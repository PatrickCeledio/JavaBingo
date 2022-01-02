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
    static String drawNumber() {
        int chance2 = rand.nextInt(5);

        switch (chance2) {
            case 0:
                int lowB = 1;
                int highB = 10;
                int resultNumB = rand.nextInt(highB - lowB) + lowB;
                return String.valueOf(resultNumB);
            case 1:
                int lowI = 11;
                int highI = 20;
                int resultNumI = rand.nextInt(highI - lowI) + lowI;
                return String.valueOf(resultNumI);
            case 2:
                int lowN = 21;
                int highN = 30;
                int resultNumN = rand.nextInt(highN - lowN) + lowN;
                return String.valueOf(resultNumN);
            case 3:
                int lowG = 31;
                int highG = 40;
                int resultNumG = rand.nextInt(highG - lowG) + lowG;
                return String.valueOf(resultNumG);
            case 4:
                int lowO = 41;
                int highO = 50;
                int resultNumO = rand.nextInt(highO - lowO) + lowO;
                return String.valueOf(resultNumO);
            default:
                System.out.println(chance2);
                return "How did you get here?";
        }
    }

    static String[] drawBingoCard() {
        String[] bingoCard = new String[20];

        for (int i = 0; i < bingoCard.length; i++) {
            bingoCard[i] = drawNumber();
        }


//        System.out.println("unsorted bingoCard: " + Arrays.toString(bingoCard));
        boolean sorted = false;
        while (!sorted) {
            for (int i = 0; i < bingoCard.length; i++) {
                for (int j = i + 1; j < bingoCard.length; j++) {
                    if (bingoCard[i].equals(bingoCard[j])) {
//                      System.out.println("Duplicates found: " + bingoCard[i] + " and " + bingoCard[j]);
                        String newCombo = drawNumber();

                        while ((bingoCard[0].equals(newCombo) || bingoCard[1].equals(newCombo) || bingoCard[2].equals(newCombo) ||
                               bingoCard[3].equals(newCombo) || bingoCard[4].equals(newCombo) || bingoCard[5].equals(newCombo) ||
                                bingoCard[6].equals(newCombo) || bingoCard[7].equals(newCombo) || bingoCard[8].equals(newCombo) ||
                                bingoCard[9].equals(newCombo) || bingoCard[10].equals(newCombo) || bingoCard[11].equals(newCombo) ||
                                bingoCard[12].equals(newCombo) || bingoCard[13].equals(newCombo) || bingoCard[14].equals(newCombo) ||
                                bingoCard[15].equals(newCombo) || bingoCard[16].equals(newCombo) || bingoCard[17].equals(newCombo) ||
                                bingoCard[18].equals(newCombo) || bingoCard[19].equals(newCombo))){
                            //System.out.println("newCombo " + newCombo);
                            newCombo = drawNumber();
                        }

                        bingoCard[j] = newCombo;
//                        System.out.println("New entry: " + bingoCard[i] + " and " + bingoCard[j]);
                        sorted = false;
                    } else {
//                        System.out.println("No match.");
                        sorted = false;
                    }
                }
            }
            sorted = true;
        }

//        System.out.println("sorted bingoCard: " + Arrays.toString(bingoCard));

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


    static void bingoGame(String[] userBingoCard, HashMap<String, String> userBingoCardMap, char drawnLetter, String drawnNumber) {

        // Print Bingo Number
        System.out.println("");

        //System.out.println("New Bingo Number: " + chance);
        //System.out.println(Arrays.toString(bingoCard) + " -- length: " + bingoCard.length);
        //System.out.println(chance);

        System.out.println(userBingoCardMap.get(userBingoCard[0]));
        System.out.println(userBingoCardMap.get(userBingoCard[1]));
        System.out.println(userBingoCardMap.get(userBingoCard[2]));
        System.out.println(userBingoCardMap.get(userBingoCard[3]));
        System.out.println(userBingoCardMap.get(userBingoCard[4]));
        System.out.println(userBingoCardMap.values());
        System.out.println(Arrays.toString(userBingoCard));
        switch(drawnLetter){
            case 'B':
                System.out.println("Drawn letter is : " + drawnLetter);
                System.out.println("B");
                for (int i = 0; i< userBingoCard.length; i++) {
                    if (userBingoCard[i] == drawnNumber)
                }
                break;
            case 'I':

                System.out.println("Drawn letter is : " + drawnLetter);
                System.out.println("I");
                break;
            case 'N':

                System.out.println("Drawn letter is : " + drawnLetter);
                System.out.println("N");
                break;
            case 'G':

                System.out.println("Drawn letter is : " + drawnLetter);
                System.out.println("G");
                break;
            case 'O':

                System.out.println("Drawn letter is : " + drawnLetter);
                System.out.println("O");
                break;

        }
    }

    static HashMap<String, String> bingoCardToMap (String[] bingoCard){
        HashMap<String, String> bingoCardMap = new HashMap<>();
        bingoCardMap.put(bingoCard[0], "B");
        bingoCardMap.put(bingoCard[5], "B");
        bingoCardMap.put(bingoCard[10], "B");
        bingoCardMap.put(bingoCard[15], "B");
        bingoCardMap.put(bingoCard[1], "I");
        bingoCardMap.put(bingoCard[6], "I");
        bingoCardMap.put(bingoCard[11], "I");
        bingoCardMap.put(bingoCard[16], "I");
        bingoCardMap.put(bingoCard[2], "N");
        bingoCardMap.put(bingoCard[7], "N");
        bingoCardMap.put(bingoCard[12], "N");
        bingoCardMap.put(bingoCard[17], "N");
        bingoCardMap.put(bingoCard[3], "G");
        bingoCardMap.put(bingoCard[8], "G");
        bingoCardMap.put(bingoCard[13], "G");
        bingoCardMap.put(bingoCard[18], "G");
        bingoCardMap.put(bingoCard[4], "O");
        bingoCardMap.put(bingoCard[9], "O");
        bingoCardMap.put(bingoCard[14], "O");
        bingoCardMap.put(bingoCard[19], "O");

        return bingoCardMap;
    }

    static void play() {
        clearConsole();
        System.out.println("Play");

        // Generate and save bingo card
        final String[] userBingoCard = drawBingoCard();
        System.out.println("Bingo card numbers: " + Arrays.toString(userBingoCard));

        // Show bingo card to user
        printBingoCard(userBingoCard);
        boolean gameFinished = false;

        while (!gameFinished) {
            System.out.println("\n1. Check for matching number\n2. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    // Generate and save bingo letter
                    String bingo = "BINGO";
                    char drawnLetter = bingo.charAt(rand.nextInt(5));

                    // Generate and save bingo number
                    String drawnNumber = drawNumber();

                    // Print bingo card
                    printBingoCard(userBingoCard);

                    HashMap<String, String> userBingoCardMap = bingoCardToMap(userBingoCard);
                    System.out.println("Map of bingo card: " + userBingoCardMap);

                    System.out.println("Checking for matching number: " + drawnLetter + drawnNumber);

                    // Initiate search for matching bingo number from bingo card
                    bingoGame(userBingoCard, userBingoCardMap, drawnLetter, drawnNumber);
                    break;
                case 2:
                    System.out.println("Thanks for playing!");
                    menuPrompt();
                    break;
                default:
                    System.out.printf("How did you get here?");
                    break;
            }

        }

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
