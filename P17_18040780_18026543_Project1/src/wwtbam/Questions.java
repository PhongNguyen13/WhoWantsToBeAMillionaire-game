package wwtbam;

import java.io.*;
import java.util.*;

public class Questions {

    private ArrayList<String> qList;
    private String question, correctAns, ansA, ansB, ansC, ansD;

    public Questions() {
        qList = new ArrayList<String>();
        question = null;
        correctAns = null;
        ansA = null;
        ansB = null;
        ansC = null;
        ansD = null;
    }

    /**
     * Get the question from the text file
     */
    public void addQuestion() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Question.txt"));
            String line;

            Random rand = new Random();

            int num = rand.nextInt(4) + 1;
            String qNo = Integer.toString(num);

            while ((line = reader.readLine()) != null) {
                if (line.equals(qNo)) {
                    for (int i = 1; i <= 15; i++) {
                        line = reader.readLine();
                        qList.add(line);
                    }
                }
            }

            reader.close();
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found!");
        } catch (IOException e) {
            System.err.println("IO Exception");
        }
    }

    /**
     * Assign the question and answers based on the question number
     *
     * @param qNum
     */
    public void separateQuestion(int qNum) {
        String line = this.getqList().get(qNum - 1);

        String[] separate = line.split(";");

        this.question = separate[0];
        this.correctAns = separate[1];
        this.ansA = separate[2];
        this.ansB = separate[3];
        this.ansC = separate[4];
        this.ansD = separate[5];
    }

    public ArrayList<String> getqList() {
        return qList;
    }

    public void setqList(ArrayList<String> qList) {
        this.qList = qList;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAns() {
        return correctAns;
    }

    public void setCorrectAns(String correctAns) {
        this.correctAns = correctAns;
    }

    public String getAnsA() {
        return ansA;
    }

    public void setAnsA(String ansA) {
        this.ansA = ansA;
    }

    public String getAnsB() {
        return ansB;
    }

    public void setAnsB(String ansB) {
        this.ansB = ansB;
    }

    public String getAnsC() {
        return ansC;
    }

    public void setAnsC(String ansC) {
        this.ansC = ansC;
    }

    public String getAnsD() {
        return ansD;
    }

    public void setAnsD(String ansD) {
        this.ansD = ansD;
    }
}
