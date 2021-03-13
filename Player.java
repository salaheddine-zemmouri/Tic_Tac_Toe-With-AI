package tictactoe;

import tictactoe.AI.easyAI;
import tictactoe.AI.mediumAI;
import tictactoe.AI.hardAI;
import tictactoe.User.Human;

 public interface Player {
    static Player of(String type){
        switch (type){
            case "user" : return new Human();
            case "easy" : return new easyAI();
            case "medium" : return new mediumAI();
            case "hard" : return new hardAI();
            default: return null;
        }
    }
    void makeMove(Game G);
    void setTool(char x);
 }
