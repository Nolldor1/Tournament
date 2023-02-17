package player;

import java.util.HashMap;


public class Game {

    HashMap<Player, Integer> players = new HashMap<>();

    public void register(Player player) {
        players.put(player, 0);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;
        for (Player player : players.keySet()) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }
        }
        if (player1 == null) {
            throw new NotRegistredException(playerName1);
        }
        if (player2 == null) {
            throw new NotRegistredException(playerName2);
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        return 0;
    }
}

