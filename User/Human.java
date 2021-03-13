package tictactoe.User;

import tictactoe.Game;
import tictactoe.Player;

import java.util.Scanner;

public class Human implements Player {

    private char tool ;

    public void setTool(char tool) {
        this.tool = tool;
    }

    public void makeMove(Game G) {
        char[][] B = G.getBoard();
        Scanner scan = new Scanner(System.in);
        // char[] player={'X','O'};
        boolean wrongInput = true, isNumeric = false;
        int X = -1,Y = -1;
        while (wrongInput) {
            System.out.print("Enter the coordinates: > ");

            if (!scan.hasNextInt()) {
                scan.nextLine();
                System.out.println("You should enter numbers!");
                continue;
            }

            if (scan.hasNextInt()) {
                X = scan.nextInt();
                Y = scan.nextInt();
            } else {
                scan.nextLine();
                System.out.println("You should enter numbers!");
                continue;
            }

            if (X > 3 || X < 1 || Y > 3 || Y < 1) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else if (B[X-1][Y-1] != '_') {
                System.out.println("This cell is occupied! Choose another one!");
            }else
                wrongInput = false ;
        }
        B[X-1][Y-1] = tool;
    }

}
