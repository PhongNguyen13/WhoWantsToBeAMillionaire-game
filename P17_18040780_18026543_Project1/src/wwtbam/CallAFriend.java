package wwtbam;

import java.util.Random;

public class CallAFriend extends Lifeline {

    public CallAFriend(String lifeline) {
        super(lifeline);
    }

    /**
     * Call a friend to ask the answer for the question
     * 
     * @param q 
     */
    @Override
    public void generateLifeline(Questions q) {
        String cAns = q.getCorrectAns();
        Random rand = new Random();
        
        System.out.print("Your friend says: ");

        int friend = rand.nextInt(3) + 1;

        switch (friend) {
            case 1:
                System.out.println("The correct answer is " + cAns + ".");
                break;
            case 2:
                System.out.println("I am not sure... but i think the answer is " + cAns + ".");
                break;
            case 3:
                System.out.println("Sorry, I don't know the answer about this question.");
                break;
        }
    }
}