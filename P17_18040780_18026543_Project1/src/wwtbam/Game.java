package wwtbam;

import java.util.*;

public class Game {

    private Questions question;
    private GameMenu menu;
    private Player player;
    private Prize prize;
    private Rank rank;
    private Scanner scan;
    private ArrayList<String> lifeline;
    private String userAns, cAns, userInput;
    private boolean start, play, result;
    private int qNum, money;

    public Game() {
        menu = new GameMenu();
        prize = new Prize();
        rank = new Rank();
        scan = new Scanner(System.in);
        start = false;
        play = false;
        userAns = null;
        cAns = null;
        userInput = null;
        money = 0;
    }

    /**
     * Start the game if the player wants to play 
     * Stop if the player quits the game
     */
    public void startGame() {
        System.out.println("Welcome to Who Wants to Be a Milionaire");

        play = menu.checkState();

        if (play == true) {
            menu.displayMenu();
            start = true;
        }

        while (start) {
            question = new Questions();
            lifeline = new ArrayList<String>();
            player = new Player();
            result = false;
            qNum = 1;
            menu.askUserName(player);

            question.addQuestion();
            lifeline.add("50/50");
            lifeline.add("Ask the Audience");
            lifeline.add("Call a Friend");

            playGame();

            System.out.println("Do you want to restart the game?");
            start = menu.checkState();

            if (start) {
                menu.displayMenu();
                play = start;
            }
            rank.addPlayer(player);
        }
        rank.printRank();
    }

    /**
     * Get the user input and check the answer
     */
    public void playGame() {
        while ((play == true) && (qNum <= 15)) {
            question.separateQuestion(qNum);
            System.out.println("------------------------------   Question " + qNum + "   ------------------------------");
            while (!result) {
                displayQuestion(question);

                cAns = question.getCorrectAns();
                userInput = scan.next();
                System.out.println();

                if (userInput.equalsIgnoreCase("A")) {
                    userAns = question.getAnsA();
                    checkAnswer(userAns);
                    break;
                } else if (userInput.equalsIgnoreCase("B")) {
                    userAns = question.getAnsB();
                    checkAnswer(userAns);
                    break;
                } else if (userInput.equalsIgnoreCase("C")) {
                    userAns = question.getAnsC();
                    checkAnswer(userAns);
                    break;
                } else if (userInput.equalsIgnoreCase("D")) {
                    userAns = question.getAnsD();
                    checkAnswer(userAns);
                    break;
                } else if (userInput.equalsIgnoreCase("E")) {
                    checkLifeline();
                } else {
                    System.out.println("Invalid answer! Please answer again.\n");
                }
            }
        }
    }

    /**
     * Display question, answers and lifeline option
     *
     * @param q
     */
    public void displayQuestion(Questions q) {
        System.out.println(q.getQuestion());
        System.out.println("A. " + q.getAnsA());
        System.out.println("B. " + q.getAnsB());
        System.out.println("C. " + q.getAnsC());
        System.out.println("D. " + q.getAnsD() + "\n");
        System.out.println("If you want to use the lifelines, press E");
    }

    /**
     * Display the result of the answer and prize
     *
     * @param userAns
     */
    public void checkAnswer(String userAns) {
        if (userAns.equalsIgnoreCase(cAns)) {
            if (qNum == 15) {
                prize.setPrize(qNum);
                money = prize.getPrize();
                player.setWinning(money);
                System.out.println("CONGRATULATIONS!!!! You win!!");
                System.out.println("Your total winning is $" + player.getWinning() + ".\n");
                play = false;
            } else {
                System.out.println("Your answer is correct!!");
                prize.setPrize(qNum);
                money = prize.getPrize();
                System.out.println("You get $" + money + ".\n");
                qNum++;
            }
        } else {
            System.out.println("You lose!!");
            System.out.println("The correct answer is " + cAns + ".");
            money = prize.checkPrize(qNum);
            player.setWinning(money);
            System.out.println("Your total winning is $" + player.getWinning() + ".\n");

            qNum = 1;
            result = false;
            play = false;
        }
    }

    /**
     * Generate the lifeline which is selected by the player
     * Remove used lifeline.
     */
    public void checkLifeline() {
        if (lifeline.isEmpty()) {
            System.out.println("No available lifelines!\n");
        }

        while (!lifeline.isEmpty()) {
            for (int j = 0; j < lifeline.size(); j++) {
                System.out.println((j + 1) + ". " + lifeline.get(j));
            }

            try {
                String userChoice = scan.next();
                String userLifeline = lifeline.get(Integer.parseInt(userChoice) - 1);
                System.out.println();

                if (userLifeline.equals("50/50")) {
                    Lifeline l1 = new FiftyFifty(userLifeline);
                    System.out.println(l1);
                    l1.generateLifeline(question);
                } else if (userLifeline.equals("Ask the Audience")) {
                    Lifeline l2 = new AskTheAudience(userLifeline);
                    System.out.println(l2);
                    l2.generateLifeline(question);
                } else if (userLifeline.equals("Call a Friend")) {
                    Lifeline l3 = new CallAFriend(userLifeline);
                    System.out.println(l3);
                    l3.generateLifeline(question);
                }
                System.out.println();

                lifeline.remove(Integer.parseInt(userChoice) - 1);
                break;
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("\nPlease enter again.\n");
            }
        }
    }
}
