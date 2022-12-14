package wwtbam;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Rank {

    private HashSet<Player> players;

    public Rank() {
        players = new HashSet();
    }

    /**
     * Update the information of the player
     *
     * @param player
     */
    public void addPlayer(Player player) {
        for (Player aPlayer : players) {
            if (aPlayer.equals(player)) {
                players.remove(aPlayer);
                break;
            }
        }
        players.add(player);
    }

    /**
     * Write the rank of players to the text file
     */
    public void printRank() {
        try {
            PrintWriter output = new PrintWriter(new FileOutputStream("Ranking.txt"));

            output.println("Ranking");
            ArrayList<Player> list = new ArrayList<>(players);
            Collections.sort(list);

            int rankNum = 1;
            for (Player i : list) {
                output.println(rankNum + ". " + i.getUserName() + " $" + i.getWinning());
                rankNum++;
            }
            output.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the file out.txt." + e.getMessage());
        }
    }
}
