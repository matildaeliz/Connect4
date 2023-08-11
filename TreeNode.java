import java.util.Random;

public class TreeNode {

    /**
     * childs of root
     */
    TreeNode first,second,third,fourth,fifth,sixth,seventh;
    /**
     * Data for Node
     */
    String[][] data ;

    /**
     * Holds the Nodes score
     */
    int score;
    /**
     * Holds the Nodes index on the table
     */
    int index ;

    /**
     * Constructor for TreeNode takes the data and calcutes the scor for every node object.
     * @param board
     * @param index
     */
    public TreeNode(String[][] board, int index){
      this.data=board;
        this.score = calculateScore();
        this.index = index;
   this. first= null;
   this. second= null;
   this. third= null;
   this.fourth= null;
   this.fifth= null;
   this. sixth= null;
   this. seventh = null;

    }

    /**
     * Select best Node for the play. Searchs the nodes. If the index -1 which means table empty makes random move otherwise checks the nodes and takes the nodes which has higher
     * score and puts the coin that index
     * @param columsrow
     * @return
     */
    public TreeNode selectNode(int[] columsrow){
    Random math = new Random();
    TreeNode[] score = {first,second,third,fourth,fifth,sixth,seventh};
    TreeNode max ;
    max = score[math.nextInt(7)];



if(index == -1){
    int rnd = math.nextInt(7);
    return score[rnd];

}


    for (int i = 0; i <score.length ; i++) {
        if(score[i]!=null &&  (score[i].score > max.score) && columsrow[i] >=0){
            max=score[i];
        }
    }

if(max.score==0){
    int rnd = math.nextInt(7);
   while (true){

       if(columsrow[rnd]<= 0){
           rnd = math.nextInt(7);
       } else {
           break;
       }
   }



    return score[rnd];
}




return max;
}

    /**
     *
     *  Takes alternative board for each node Checks the board horizontally dioganally and vertically, and calcutes the score .
     *
     * @return
     */
    public int  calculateScore(){
        int score = 0;

    int yellow = 0;
    int red = 0;

//Horizontal Calculate

    for (int y = 0; y <7 ; y++) {
        for (int x= 5; x >= 0  ; x--) {

            if(data[x][y].equals(" Y ")){
                yellow++;
            }else if(data[x][y].equals(" R ")){
                red++;
            }


            if(red >=1 && yellow == 1){
                red = 0;
            }else if (yellow >= 1 && red == 1){
                yellow = 0;
            }

            }
        }
      if(yellow > score){
          score = yellow;
      }
//-----------------------------------------------------------
    //Vertical Calculate
     yellow = 0;
     red = 0;
    for (int x = 5; x >= 0; x--) {
        for (int y = 0; y < 7 ; y++) {
            if(data[x][y].equals(" Y ")){
                yellow++;
            }else if(data[x][y].equals(" R ")){
                red++;
            }


            if(red >=1 && yellow == 1){
                red = 0;
            }else if (yellow >= 1 && red == 1){
                yellow = 0;
            }
            if(yellow > score){
                score = yellow;
            }

        }

    }//-----------------------------------------------------------
    //diognally Calculate
    red = 0;
    yellow = 0;
    int[][] indexsfordiagonally = {
            {2,0}, {3,1}, {4,2}, {5,3}, {1,0}, {2,1}, {3,2}, {4,3}, {5,4}, {0,0}, {1,1}, {2,2}, {3,3}, {4,4}, {5,5},
            {0,1}, {1,2}, {2,3}, {3,4}, {4,5}, {5,6},{0,2},{1,3},{2,4},{3,5},{4,6},{0,3},{1,4},{2,5},{3,6},
            {3,0},{2,1},{1,2},{0,3},{4,0},{3,1},{2,2},{1,3},{0,4},{5,0},{4,1},{3,2},{2,3},{1,4},{0,5},{5,1},{4,2},{3,3},
            {2,4},{1,5},{0,6},{5,2},{4,3},{3,4},{2,5},{1,6},{5,3},{4,4},{3,5},{2,6}};
    for (int i = 0; i <indexsfordiagonally.length; i++) {

        if (i == 4 || i == 9 || i == 15 || i == 21 || i == 26 || i == 30 || i == 34 || i == 39 || i == 45 || i == 51 || i == 56) {
            red = 0;
            yellow = 0;
        }

        int x = indexsfordiagonally[i][0];
        int y = indexsfordiagonally[i][1];




            if (data[x][y].equals(" Y ")) {
                yellow++;
            } else if (data[x][y].equals(" R ")) {
                red++;
            }
            if (red >= 1 && yellow == 1) {
                red = 0;
            } else if (yellow >= 1 && red == 1) {
                yellow = 0;
            }

            if (yellow > score) {
                score = yellow;
            }

        }
        //   --------------------------------------------------------------




    return score;
}

    /**
     * gets the first child
     * @return
     */
    public TreeNode getFirst() {
return first;
    }

    /**
     * gets the second child
     * @return
     */
    public TreeNode getSecond() {
return  second;
    }
    /**
     * gets the third child
     * @return
     */
    public TreeNode getThird() {
return third;
    }
    /**
     * gets the fourth child
     * @return
     */
    public TreeNode getFourth() {
return fourth;
    }
    /**
     * gets the fifth child
     * @return
     */
    public TreeNode getFifth() {
return fifth;
    }

    /**
     * gets the sixth child
     *
     * @return
     */
    public TreeNode getSixth() {
return sixth;
    }

    /**
     * gets the seventh child
     * @return
     */
    public TreeNode getSeventh() {
return seventh;
    }
}
