package wwtbam;

import java.util.Random;

public class AskTheAudience extends Lifeline {

    private int total, randNumA, randNumB, randNumC, randNumD;

    public AskTheAudience(String lifeline) {
        super(lifeline);
        this.total = 100;
        this.randNumA = 0;
        this.randNumB = 0;
        this.randNumC = 0;
        this.randNumD = 0;
    }

    /**
     * Display the percentage of audience who voted for each answer
     * 
     * @param q 
     */
    @Override
    public void generateLifeline(Questions q) {
        String cAns = q.getCorrectAns();
        Random rand = new Random();

        if (cAns.equals(q.getAnsA())) {
            randNumA = rand.nextInt(30) + 40;
            total -= randNumA;
            randNumB = rand.nextInt(total);
            total -= randNumB;
            randNumC = rand.nextInt(total);
            total -= randNumC;
            randNumD = total;
        } else if (cAns.equals(q.getAnsB())) {
            randNumB = rand.nextInt(30) + 40;
            total -= randNumB;
            randNumC = rand.nextInt(total);
            total -= randNumC;
            randNumD = rand.nextInt(total);
            total -= randNumD;
            randNumA = total;
        } else if (cAns.equals(q.getAnsC())) {
            randNumC = rand.nextInt(30) + 40;
            total -= randNumC;
            randNumD = rand.nextInt(total);
            total -= randNumD;
            randNumA = rand.nextInt(total);
            total -= randNumA;
            randNumB = total;
        } else if (cAns.equals(q.getAnsD())) {
            randNumD = rand.nextInt(30) + 40;
            total -= randNumD;
            randNumA = rand.nextInt(total);
            total -= randNumA;
            randNumB = rand.nextInt(total);
            total -= randNumB;
            randNumC = total;
        }

        System.out.println("A: " + randNumA + "%, B: " + randNumB + "%, C: " + randNumC + "%, D: " + randNumD + "%.");
    }
}