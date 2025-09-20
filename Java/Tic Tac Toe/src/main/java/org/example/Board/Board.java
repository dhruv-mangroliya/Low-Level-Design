package org.example.Board;

import lombok.Getter;
import lombok.Setter;
import org.example.Board.Spot.Spot;
import org.example.Enum.Status;
import org.example.Player.Player;

import java.util.*;

@Setter @Getter
public class Board {
    private List<List<Spot>> spots = new ArrayList<>();
    private Map<Integer, Spot> spotMapping = new HashMap<Integer, Spot>();
    public static volatile Board instance;
    private char currPlayer;
    private Status status;

    public Board(){
        int index = 1;
        for (int i = 0; i < 3; i++) {
            List<Spot> row = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                Spot s = new Spot();
                row.add(s);
                spotMapping.put(index, s);
                index++;
            }
            spots.add(row); // add row to spots
        }
        this.status = Status.ONGOING;
    }

    public static synchronized Board getInstance(){
        if(instance == null){
            instance = new Board();
        }
        return instance;
    }

    public void setFirstPlayer(Player p){
        this.currPlayer = p.getType();
    }

    public void makeMove(Player player, Integer location){
        //make sure no consecutive moves.
        if(player.getType() != this.currPlayer){
            System.out.println("This is unvalid move. It is not your turn for player : "+ ((currPlayer == 'O') ?'X':'O'));
            return;
        }
        // make sure no player is there.
        if(spotMapping.get(location).getPlayer() != null){
            System.out.println("This is unvalid move. This location is already occupied.");
            return;
        }
        if(calculateResult() != Status.ONGOING){
            System.out.println("Game is over. Have a good day!!!");
            checkStatus();
            return;
        }
        //make move
        Spot targetSpot = spotMapping.get(location);
        targetSpot.setPlayer(player);
        this.setStatus(calculateResult());
        if(this.checkStatus() != Status.ONGOING){
            System.out.println("Game is over. Have a good day!!!");
            checkStatus();
        }
        //set last player
        this.currPlayer = (player.getType() == 'O')? 'X' : 'O';
        return;
    }
    private Status calculateResult() {
        int index = 0;
        boolean drawPossible = true;
        Vector<Character> players = new Vector<>();

        for (List<Spot> row : spots) {
            for (Spot s : row) {
                if (s.getPlayer() != null) {
                    players.add(s.getPlayer().getType()); // X or O
                } else {
                    players.add('N'); // Empty spot
                    drawPossible = false;
                }
                index++;
            }
        }

        int[][] winPatterns = {
                {0, 1, 2}, // Row 1
                {3, 4, 5}, // Row 2
                {6, 7, 8}, // Row 3
                {0, 3, 6}, // Col 1
                {1, 4, 7}, // Col 2
                {2, 5, 8}, // Col 3
                {0, 4, 8}, // Diagonal
                {2, 4, 6}  // Diagonal
        };

        for (int[] pattern : winPatterns) {
            char a = players.get(pattern[0]);
            char b = players.get(pattern[1]);
            char c = players.get(pattern[2]);

            if (a != 'N' && a == b && b == c) {
                return (a=='O') ? Status.PLAYER_O_WON : Status.PLAYER_X_WON;  // one player won
            }
        }

        if (!drawPossible) {
            return Status.ONGOING;
        }

        return Status.DRAW;
    }

    public Status checkStatus(){
        System.out.println(this.getStatus().toString());
        return this.getStatus();
    }

    public void showBoard(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                Player p = spotMapping.get(3*i+j+1).getPlayer();
                char notation = (p != null) ? p.getType() : '-';
                System.out.print(notation);
            }
            System.out.println();
        }
        return;
    }
}
