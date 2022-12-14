package wwtbam;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameMenu {

    private Scanner scan;
    private Prize prize;
    private String username;
    private boolean state;
    private String input;

    public GameMenu() {
        scan = new Scanner(System.in);
        prize = new Prize();
        username = null;
        state = false;
        input = null;
    }

    /**
     * Display the game menu
     */
    public void displayMenu() {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("|                                                                           |");
        System.out.println("|                                                             15 $1000000   |");
        System.out.println("|                                                             14 $500000    |");
        System.out.println("|                                                             13 $250000    |");
        System.out.println("|                      WHO WANTS TO BE A                      12 $125000    |");
        System.out.println("|                                                             11 $64000     |");
        System.out.println("|                          ___                   __   ___     10 $32000     |");
        System.out.println("|   |\\  /| | |    |    |  /   \\  |\\  |   /\\   | |__) |         9 $16000     |");
        System.out.println("|   | \\/ | | |    |    | |     | | \\ |  /__\\  | |\\   |---      8 $8000      |");
        System.out.println("|   |    | | |___ |___ |  \\___/  |  \\| /    \\ | | \\  |___      7 $4000      |");
        System.out.println("|                                                              6 $2000      |");
        System.out.println("|                                                              5 $1000      |");
        System.out.println("|                                                              4 $500       |");
        System.out.println("|                                                              3 $300       |");
        System.out.println("|                                                              2 $200       |");
        System.out.println("|                                                              1 $100       |");
        System.out.println("|                                                                           |");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println();
    }

    /**
     * Get the username
     *
     * @param player
     */
    public void askUserName(Player player) {
        System.out.print("Please enter username: ");
        username = scan.next();
        player.setUserName(username);
        System.out.println("Hello " + player + ". Let's Play!\n");
    }

    /**
     * Check if the player wants to play or quit the game
     *
     * @return true if they wants to play otherwise false
     */
    public boolean checkState() {
        state = false;

        while (!state) {
            try {
                System.out.println("1. Play");
                System.out.println("2. Quit");

                input = scan.next();
                System.out.println();
                if (Integer.parseInt(input) == GameState.PLAY.getValue()) {
                    System.out.println("START GAME");
                    state = true;
                } else if (Integer.parseInt(input) == GameState.QUIT.getValue()) {
                    System.out.println("QUIT GAME");
                    break;
                } else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Please enter again.");
            }
        }
        return state;
    }
}
