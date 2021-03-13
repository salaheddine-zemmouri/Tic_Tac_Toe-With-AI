package tictactoe;

import java.util.Scanner;

public class Game {

    private char[][] board;
    private final Player[] players;

    public Game(){
        // * initialize players
        players = new Player[2];
        // * initialize empty board
        board = new char[3][3];
        emptyBoard();
    }

    public char[][] getBoard() {
        return board;
    }

    private void emptyBoard(){
        for (int i = 0 ; i < 3 ; i++){
            board[i] = "___".toCharArray();
        }
    }

//    public void buildBoard() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter cells: ");
//        String str = scanner.next();
//        if(str.length() == 9) {
//            board[0] = str.substring(0, 3).toCharArray();
//            board[1] = str.substring(3, 6).toCharArray();
//            board[2] = str.substring(6, 9).toCharArray();
//        }
//    }


    private void printBoard(){
        System.out.println("---------");
        for (int i = 0; i < 3 ; i++){
            int j=0;
            System.out.println("| " + board[i][j] + " " + board[i][j+1] + " " + board[i][j+2] + " |");
        }
        System.out.println("---------");
    }
    /**
    @return -1: Game not finished
            0 : O wins
            1 : X wins
            2 : Tie
    **/

    public int getState(){
        //horizontal check
        for (int i = 0 ; i < 3 ; i++) {
            if (board[i][0] == 'X' && board[i][1] == 'X' && board[i][2] == 'X') {
                return 1;
            }
            else if (board[i][0] == 'O' && board[i][1] == 'O' && board[i][2] == 'O') {
                return 0;
            }

        }
        //vertical check
        for (int i=0;i<3;i++) {
            if (board[0][i] == 'X' && board[1][i] == 'X' && board[2][i] == 'X') {
                return 1;
            }
            else if (board[0][i] == 'O' && board[1][i] == 'O' && board[2][i] == 'O') {
                return 0;
            }
        }
        // diagonal check
        if(board[0][0]=='X' && board[1][1]=='X' && board[2][2]=='X' ){
            return 1;
        }
        else if(board[0][0]=='O' && board[1][1]=='O' && board[2][2]=='O' ){
            return 0;
        }
        // anti diagonal check
        if(board[0][2]=='X' && board[1][1]=='X' && board[2][0]=='X' ){
            return 1;
        }
        else if(board[0][2]=='O' && board[1][1]=='O' && board[2][0]=='O' ){
            return 0;
        }

        if(!hasEmptyCell()) return 2;
        else return -1;

    }

    private boolean hasEmptyCell(){
        for (int i = 0 ; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '_') {
                    return true ;
                }
            }
        }
        return false;
    }

/*
    public void setCell(int x, int y) {
        int countX = count('X');
        int countO= count('O');
        if (countX>countO) board[x-1][y-1] = 'O';
        else board[x-1][y-1] = 'X';
    }

    private int count (char mark){
        int cunt = 0 ;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == mark) cunt++;
            }
        }
        return cunt;
    }
*/


    public void play(){
        String[] type;
        boolean exit = false;
        do {
            System.out.print("type command: > ");
            Scanner scanner = new Scanner(System.in);
            type = scanner.nextLine().split(" ");
            if (type.length == 3 && type[0].equals("start")  ) {
                players[0] = Player.of(type[1]);
                players[1] = Player.of(type[2]);
                if (players[0] == null || players[1] == null) {
                    System.out.println("Bad parameters!");
                    continue;
                }
                // Game loop
                emptyBoard();
                players[0].setTool('X');
                players[1].setTool('O');
                printBoard();
                while (getState() == -1){
                    players[0].makeMove(this);
                    printBoard();
                    if(getState() != -1) break;
                    players[1].makeMove(this);
                    printBoard();
                }

                switch (getState()){
                    case 0 : System.out.println("O wins"); break;
                    case 1 : System.out.println("X wins"); break;
                    case 2 : System.out.println("Draw"); break;
                }


            }else if(type.length == 1 && type[0].equals("exit")) {
                    exit = true;
            }else {
                System.out.println("Bad parameters!");
            }
        }while (!exit);

//        players[0].setTool('X');
//        players[1].setTool('O');
//        printBoard();
//        while (getState() == -1){
//            players[0].getCoordinates(this);
//            printBoard();
//            if(getState() != -1) break;
//            players[1].getCoordinates(this);
//            printBoard();
//        }
//
//        switch (getState()){
//            case 0 : System.out.println("O wins"); break;
//            case 1 : System.out.println("X wins"); break;
//            case 2 : System.out.println("Draw"); break;
//        }
    }
}
