import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Menu {
    protected Scanner input = new Scanner(System.in);
    protected String select;

    public void run() throws InterruptedException, IOException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        printOptionsMenu();
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        if (select.equals("1")) {
            printDifficultySelection();
        } else if (select.equals("2")) {
            printOptionsMenu();
            tutorial();
        } else {
            System.out.println("See you again!");
            System.exit(0);
        }
        Map map = new Map();
        map.createMap(assignDifficult(select));
    }

    /**
     * Print out the screen all the options that user can pick and take input from
     * user keyboard
     */
    public void printOptionsMenu() {
        select = " ";
        System.out.println("1. Start game\n" +
                "2. Help/Tutorial\n" +
                "3. Exit\nPlease type only number from 1 to 3:");
        takeInputMenu();
        while (select.equals("2")) {
            if (select.equals("2")) {
                tutorial();
            }
        }
    }

    /**
     * This method is only specific for take input in the menu section because it
     * can only validate input
     * from 1 to 3
     */
    private void takeInputMenu() {
        System.out.print("> ");
        select = input.nextLine();
        while (!validInput(select)) {
            System.out.println("Invalid input, please try again:");
            System.out.print("> ");
            select = input.nextLine();
        }
    }

    /**
     * Validate user input incase user type in something incorrect
     * 
     * @param select - String that user type in
     * @return true if user input is correct, false otherwise.
     */
    private boolean validInput(String select) {
        return Pattern.matches("[1-3]", select);
    }

    /**
     * This method will print 3 difficulty selections and take user input after
     * printing
     */
    private void printDifficultySelection() {
        System.out.println("1. Easy(3x3)\n" +
                "2. Medium(4x4)\n" +
                "3. Hard(5x5)\nType number from 1 to 3 to make selection:");
        takeInputMenu();
        while (select.equals("2") || select.equals("3")) {
            System.out.println("Medium and Hard difficulty is not supported yet, stay tuned.Please select other options");
            takeInputMenu();
        }
    }

    /**
     * This method print the tutorial and take user input after print tutorial.
     */
    private void tutorial() {
        System.out.println();
        for (int i = 0; i < 80; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.println("Your objective is to reach the final room\n" +
                "Please only type 'up', 'down', 'left', 'right' to move\n" +
                "To pickup an object, type 'take + object's name.' For example: take *\n" +
                "To use an object, type 'use + object's name.' For example: use *");
        System.out.println("Type any letter to continue or type any number to make selection:");
        for (int i = 0; i < 80; i++) {
            System.out.print("-");
        }
        System.out.println();
        takeInputMenu();
    }

    /**
     * Assign the level as player selected
     * 
     * @param select - String (1)-easy (2)-medium (3)-hard
     * @return level that has been selected
     */
    public Level assignDifficult(String select) {
        Level level = null;
        if (select.equals("1"))
            level = Level.EASY;
        else if (select.equals("2"))
            level = Level.MEDIUM;
        else if (select.equals("3"))
            level = Level.HARD;
        return level;
    }
}
