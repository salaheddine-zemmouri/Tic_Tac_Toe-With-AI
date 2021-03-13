package tictactoe.AI;

import tictactoe.Game;


public class mediumAI implements AI {
    private char tool;
    public void setTool(char tool) {
        this.tool = tool;
    }
    public void makeMove(Game G){
        System.out.println("Making move level \"medium\"");
        char[][] B = G.getBoard();
        char humanTool = (tool=='X')?'O':'X';

        int toolCount;
        int humanToolCount ;
        int a=0,b=0;
        //horizontal check
        for (int i = 0 ; i < 3 ; i++) {
            toolCount = 0;
            humanToolCount = 0;
            for (int j = 0 ; j < 3 ; j++) {
                if (B[i][j] == tool) toolCount++;
                else if (B[i][j] == humanTool) humanToolCount++;
                else if (B[i][j] == '_'){
                    a = i;
                    b = j;
                }
            }
            if (toolCount== 2 && B[a][b] == '_') {
                B[a][b] = tool;
                return;
            }
            if (humanToolCount== 2 && B[a][b] == '_') {
                B[a][b] = tool;
                return;
            }

        }
        //vertical check
        a=0;b=0;
        for (int i = 0 ; i < 3 ; i++) {
            toolCount = 0;
            humanToolCount = 0;
            for (int j = 0 ; j < 3 ; j++) {
                if (B[j][i] == tool) toolCount++;
                else if (B[j][i] == humanTool) humanToolCount++;
                else if (B[j][i] == '_'){
                    a = j;
                    b = i;
                }
            }
            if (toolCount == 2 && B[a][b] == '_')  {
                B[a][b] = tool;
                return;
            }
            if (humanToolCount== 2 && B[a][b] == '_')  {
                B[a][b] = tool;
                return;
            }

        }
        // diagonal check
        a=0;
        toolCount = 0;
        humanToolCount = 0;
        for (int i = 0 ; i < 3 ; i++) {
            if (B[i][i] == tool) toolCount++;
            else if (B[i][i] == humanTool) humanToolCount++;
            else if (B[i][i] == '_'){
                a = i;
            }
            if (toolCount == 2 && B[a][a] == '_')  {
                B[a][a] = tool;
                return;
            }
            if (humanToolCount == 2 && B[a][a] == '_')  {
                B[a][a] = tool;
                return;
            }

        }
        // antidiagonal check
        a=0;
        toolCount = 0;
        humanToolCount = 0;
        for (int i = 0 ; i < 3 ; i++) {
            if (B[i][2-i] == tool) toolCount++;
            else if (B[i][2-i] == humanTool) humanToolCount++;
            else if (B[i][2-i] == '_'){
                a = i;
            }
            if (toolCount== 2 && B[a][2-a] == '_') {
                B[a][2-a] = tool;
                return;
            }
            if (humanToolCount== 2 && B[a][2-a] == '_') {
                B[a][2-a] = tool;
                return;
            }

        }
        // if program make it to this point
        // it means that it had no other choice but to make a random move
        int[] Coordinates = AI.generateRandomCoordinates(G);
        int X = Coordinates[0] , Y = Coordinates[1];
        B[X][Y] = tool;
    }
}
