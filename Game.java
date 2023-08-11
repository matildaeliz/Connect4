import java.util.Random;
import java.util.Scanner;

public class Game {
    /**
     * Winner of the game String
     */
    String winner ="";
    /**
     * Holds the Number of Available columns of the board
     */
    int[] columnsrow;
    /**
     * player objects
     */
   Player player ;

    /**
     * computer  objects
     */
    Computer computer;

    /**
     * Board for game it takes 6,7 dimesions
     */
    String[][] board;

    /**
     * Constructers of Game class, includes play method
     */

public Game(){
    columnsrow = new int[7];
    board = new String[6][7];
    createBoard();
    player = new Player(" R ");
    computer = new Computer(board," Y ");


play();


}

    /**
     * This Method takes first computer decision and puts the coin in the board and changes number of collumns available on the columnsrow and then
     * player makes moves and similar procces continue until the one of the player reaches the 4 point
     */
    void play(){


    boolean flag = false;
    Scanner scanner = new Scanner(System.in);



    while (!flag){

        int move = computer.makingMove(board,columnsrow);


        if(isValidMove(move)){

            board[columnsrow[move]-1][move] = computer.coin.getCoin();
            int row = columnsrow[move];
            columnsrow[move] = row-1;
            printBoard();

            if(checkFinish()){
                System.out.println("Winner is: "+ winner);
                break;
            }

        }


        int playercolumn;
        do {
            System.out.println();
            System.out.print("YOUR MOVE: ");
            System.out.println();
             playercolumn = player.makingMove(scanner.nextInt());
        } while (!isValidMove(playercolumn));



            board[columnsrow[playercolumn]-1][playercolumn] = player.coin.getCoin();
            int row = columnsrow[playercolumn];
            columnsrow[playercolumn] = row-1;
            System.out.println("YOUR MOVE:");
            printBoard();


            if(checkFinish()){
                System.out.println("Winner is: "+ winner);
                break;
            }







    }

}








    /**
     * Chekcs the board horizontally dioganally and vertically, if there are 4 combo returns true and, he method finishes the game.
     */
    public boolean checkFinish(){
        int red = 0;
        int yellow = 0;

        int full = 0;
        for (int y = 0; y <7; y++) {
            for (int x = 0; x <6 ; x++) {
                if(board[x][y] == " - "){
                    full++;
                }
            }
        }

        if(full == 0){
            System.out.println("Draw!");
            return true;
        }

        //horizontly check
     //   --------------------------------------------------------------
        for (int y = 0; y <7 ; y++) {
            for (int x= 5; x >= 0  ; x--) {
                if(red == 4 || yellow == 4){
                    if(red == 4){
                        winner = "Player";
                    } else if (yellow == 4) {
                        winner = "Computer";
                    }
                    return true;
                }

                if(board[x][y].equals(" R ")){
                 red++;
                }else if(board[x][y].equals(" Y ")){
                    yellow++;
                }
             if(red >=1 && yellow == 1){
                 red = 0;
             }else if (yellow >= 1 && red == 1){
                 yellow = 0;
             }



            }
            red = 0;
            yellow = 0;
        }
     //   --------------------------------------------------------------

        //vertically check
     //   --------------------------------------------------------------
        red = 0;
        yellow = 0;
        for (int x = 5; x >= 0; x--) {
            for (int y = 0; y < 7; y++) {


              if(board[x][y].equals(" R ")){
                  red++;
              } else if (board[x][y].equals(" Y ")) {
                  yellow++;
              }else if(board[x][y].equals(" - ")){
                  if(red >=1){
                      red = 0;
                  }
                  if(yellow>=1){
                      yellow =0;
                  }
              }
                if(red >=1 && yellow >= 1){
                    red = 0;

                }else if (yellow >= 1 && red >= 1){
                    yellow = 0;
                }


                if(red >= 4 || yellow >=  4){
                    if(red >=  4){
                        winner = "Player";
                        return true;
                    } else if (yellow >=  4) {
                        winner = "Computer";
                        return true;
                    }

                }


            }
            red = 0;
            yellow = 0;
        }

      //   --------------------------------------------------------------
        //Diagonally check
     //   --------------------------------------------------------------
        red = 0;
        yellow = 0;
        int[][] indexsfordiagonally = {
                {2,0}, {3,1}, {4,2}, {5,3}, {1,0}, {2,1}, {3,2}, {4,3}, {5,4}, {0,0}, {1,1}, {2,2}, {3,3}, {4,4}, {5,5},
                {0,1}, {1,2}, {2,3}, {3,4}, {4,5}, {5,6},{0,2},{1,3},{2,4},{3,5},{4,6},{0,3},{1,4},{2,5},{3,6},
                {3,0},{2,1},{1,2},{0,3},{4,0},{3,1},{2,2},{1,3},{0,4},{5,0},{4,1},{3,2},{2,3},{1,4},{0,5},{5,1},{4,2},{3,3},
                {2,4},{1,5},{0,6},{5,2},{4,3},{3,4},{2,5},{1,6},{5,3},{4,4},{3,5},{2,6}};
        for (int i = 0; i <indexsfordiagonally.length; i++) {

            if(i == 4 || i == 9 || i ==  15 ||i == 21 || i == 26 || i == 30 || i == 34 || i == 39 || i == 45 || i ==51|| i == 56){
                red = 0;
                yellow = 0;
            }

            int x = indexsfordiagonally[i][0];
            int y = indexsfordiagonally[i][1];


            if(board[x][y].equals(" R ")){
                red++;

            }else if(board[x][y].equals(" Y ")){
                yellow++;
            } else if(board[x][y].equals(" - ")){
                if(red >=1){
                    red = 0;
                }
                if(yellow>=1){
                    yellow =0;
                }
            }

            if(red >=1 && yellow == 1){
                red = 0;

            }else if (yellow >= 1 && red == 1){
                yellow = 0;
            }



            if(red >=  4 || yellow>=  4){
                if(red >=  4){
                    winner = "Player";
                    return true;
                } else if (yellow >=  4) {
                    winner = "Computer";
                    return true;
                }

            }




        }
        //   --------------------------------------------------------------







        return false;
}

    /**
     * Checks the board for valid move, If player plays invalid column throws a error
     * @return
     */

public boolean isValidMove(int move){

    if(move> 6 || move < 0){
        return false;
    }
return true;
}


    /**
     * Creates The Board
     */
    void createBoard(){
    for (int i = 0; i < 6; i++) {
        for (int j = 0; j < 7; j++) {

            board[i][j] = " - ";
        }
    }

    for (int i = 0; i <7 ; i++) {
        columnsrow[i]=6;
    }
}





    /**
     * Prints the board
     */
    public  void printBoard(){
        System.out.println("");
        for (int j = 0; j < 7; j++) {
            System.out.print(" "+j + " ");
        }
        System.out.println(" ");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
}


}
