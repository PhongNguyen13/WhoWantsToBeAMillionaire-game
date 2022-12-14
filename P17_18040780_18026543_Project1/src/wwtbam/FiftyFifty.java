package wwtbam;

import java.util.Random;

public class FiftyFifty extends Lifeline {

    public FiftyFifty(String lifeline) {
        super(lifeline);
    }

    /**
     * Remove two incorrect answers
     *
     * @param q
     */
    @Override
    public void generateLifeline(Questions q) {
        String cAns = q.getCorrectAns();
        Random rand = new Random();

        int randAns = rand.nextInt(3) + 1;

        if (cAns.equals(q.getAnsA())) {
            switch (randAns) {
                case 1:
                    q.setAnsC("");
                    q.setAnsD("");
                    break;
                case 2:
                    q.setAnsB("");
                    q.setAnsD("");
                    break;
                case 3:
                    q.setAnsB("");
                    q.setAnsC("");
                    break;
            }
        } else if (cAns.equals(q.getAnsB())) {
            switch (randAns) {
                case 1:
                    q.setAnsC("");
                    q.setAnsD("");
                    break;
                case 2:
                    q.setAnsA("");
                    q.setAnsD("");
                    break;
                case 3:
                    q.setAnsA("");
                    q.setAnsC("");
                    break;
            }
        } else if (cAns.equals(q.getAnsC())) {
            switch (randAns) {
                case 1:
                    q.setAnsB("");
                    q.setAnsD("");
                    break;
                case 2:
                    q.setAnsA("");
                    q.setAnsD("");
                    break;
                case 3:
                    q.setAnsA("");
                    q.setAnsB("");
                    break;
            }
        } else if (cAns.equals(q.getAnsD())) {
            switch (randAns) {
                case 1:
                    q.setAnsB("");
                    q.setAnsC("");
                    break;
                case 2:
                    q.setAnsA("");
                    q.setAnsC("");
                    break;
                case 3:
                    q.setAnsA("");
                    q.setAnsB("");
                    break;
            }
        }

        System.out.println("Two incorrect answers are eliminated.");

    }
}
