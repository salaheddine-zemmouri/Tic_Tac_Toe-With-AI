package tictactoe.AI;

import tictactoe.Game;
import tictactoe.Player;
import java.util.Random;

interface AI extends Player {

    static int[] generateRandomCoordinates(Game G){
        int[] Coordinates = new int[2];
        char [][] B = G.getBoard();
        Random random = new Random();
        int X,Y;
        do {
            X = random.nextInt(3);
            Y = random.nextInt(3);
        }while (B[X][Y] == 'X' || B[X][Y] == 'O');
        Coordinates[0] = X;
        Coordinates[1] = Y;
        return Coordinates;
    }

}
