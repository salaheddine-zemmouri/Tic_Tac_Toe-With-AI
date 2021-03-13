package tictactoe.AI;
import tictactoe.Game;


public class easyAI implements AI {

    private char tool ;

    public void setTool(char tool) {
        this.tool = tool;
    }

    public void makeMove(Game G) {
        System.out.println("Making move level \"easy\"");
        char[][] B = G.getBoard();
        int[] Coordinates = AI.generateRandomCoordinates(G);
        int X = Coordinates[0] , Y = Coordinates[1];
        B[X][Y] = tool;
    }
}
