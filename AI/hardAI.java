package tictactoe.AI;

import tictactoe.Game;
import tictactoe.Player;

import java.util.ArrayList;


public class hardAI implements Player {

    char AITool ;

    public void setTool(char tool) {
        this.AITool = tool;
    }

    @Override
    public void makeMove(Game G) {
        System.out.println("Making move level \"hard\"");
        int[] move = bestMove(G);
        char[][] B = G.getBoard();
        B[move[0]][move[1]] = AITool ;
    }

    private int[] bestMove(Game G){
        int[] move = new int[2];
        char[][] Board = G.getBoard();
        int bestScore = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Board[i][j] == '_'){
                    Board[i][j] = AITool;
                    int score = minimax(G, false);
                    Board[i][j] = '_';
                    if (score > bestScore){
                        bestScore = score;
                        move = new int[]{i,j};
                    }
                }
            }
        }
        return move;
    }

    private int minimax(Game G, boolean isMaximizing){
        char humanTool = (AITool=='X')?'O':'X';
        if(isWinning(G,AITool)){
            return 1;
        }else if (isWinning(G,humanTool)){
            return -1;
        }else if (G.getState()==2){
            return 0;
        }
        char[][] Board = G.getBoard();
        int bestScore;
        if (isMaximizing){
            bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (Board[i][j] == '_'){
                        Board[i][j] = AITool;
                        int score = minimax(G, false);
                        Board[i][j] = '_';
                        bestScore = Math.max(score,bestScore);
                    }
                }
            }
        }
        else {
            bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (Board[i][j] == '_'){
                        Board[i][j] = humanTool;
                        int score = minimax(G, true);
                        Board[i][j] = '_';
                        bestScore = Math.min(score,bestScore);
                    }
                }
            }
        }
        return bestScore;
    }
    private boolean isWinning(Game G , char tool) {
        return (G.getState() == 1 && tool == 'X') || (G.getState() == 0 && tool == 'O');
    }

}
