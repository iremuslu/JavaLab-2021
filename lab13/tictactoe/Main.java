package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        Board board = new Board();

        System.out.println(board);
        while (!board.isEnded()) {

            int player = board.getCurrentPlayer();
            int row=0,col=0;
            boolean invalidRow = false;
            boolean invalidColumn = false;
            do{
                System.out.print("Player " + player + " enter row number:");
                try {
                    row = Integer.valueOf(reader.nextLine());
                    invalidRow = false;
                }catch (NumberFormatException nfe){
                    System.out.println("Invalid integer");
                    invalidRow = true;
                }

            }while (invalidRow);


            do {
                System.out.print("Player " + player + " enter column number:");
                try {
                    col = Integer.valueOf(reader.nextLine());
                    invalidColumn = false;
                }catch (NumberFormatException nfe){
                    System.out.println("Invalid integer");
                    invalidColumn = true;
                }
            }while (invalidColumn);
            try {
                board.move(row, col);
            }catch (InvalidMoveException ime){
                System.out.println(ime.getMessage());
            }

            System.out.println(board);
        }


        reader.close();
    }


}
