package wwtbam;

public class Prize {

    private int prize;

    public Prize() {
        prize = 0;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int questionNum) {
        switch (questionNum) {
            case 1:
                prize = 100;
                break;
            case 2:
                prize = 200;
                break;
            case 3:
                prize = 300;
                break;
            case 4:
                prize = 500;
                break;
            case 5:
                prize = 1000;
                break;
            case 6:
                prize = 2000;
                break;
            case 7:
                prize = 4000;
                break;
            case 8:
                prize = 8000;
                break;
            case 9:
                prize = 16000;
                break;
            case 10:
                prize = 32000;
                break;
            case 11:
                prize = 64000;
                break;
            case 12:
                prize = 125000;
                break;
            case 13:
                prize = 250000;
                break;
            case 14:
                prize = 500000;
                break;
            case 15:
                prize = 1000000;
                break;
        }
    }

    /**
     * Calculate the total prize of the player
     *
     * @param questionNum
     * @return the total prize
     */
    public int checkPrize(int questionNum) {
        int finalPrize = 0;

        if ((questionNum >= 1) && (questionNum <= 5)) {
            finalPrize = 0;
        } else if ((questionNum > 5) && (questionNum <= 10)) {
            finalPrize = 1000;
        } else if ((questionNum > 10) && (questionNum <= 15)) {
            finalPrize = 32000;
        }

        return finalPrize;
    }
}
