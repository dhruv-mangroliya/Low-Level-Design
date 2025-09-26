package org.example.Game;

import org.example.Board.Board;
import org.example.Enum.Status;
import org.example.Player.Player;
import org.example.Player.PlayerFactory;

import java.util.Scanner;

public class TTTGame implements Game{
    @Override
    public void play(){
        Board board = Board.getInstance();
        PlayerFactory playerFactory = new PlayerFactory();

        Player p1 = playerFactory.createPlayer('O', "Alice");
        Player p2 = playerFactory.createPlayer('X', "Bob");

        board.setFirstPlayer(p1);
        Player p = p1;
        do{
            Scanner sc = new Scanner(System.in);
            System.out.println("This is the turn of player : "+ board.getCurrPlayer());
            System.out.println("Please enter your next move");
            while(true){
                int location = sc.nextInt();
                boolean success = board.makeMove(p, location);
                if(success) break;
            }
            if(p.getType() == p1.getType()){
                p=p2 ;
            }else{
                p=p1 ;
            }
            board.showBoard();
        }while(board.checkStatus() == Status.ONGOING);
        System.out.println("Game is over.... And the result is........");
        System.out.println(board.getStatus());
    }
}
