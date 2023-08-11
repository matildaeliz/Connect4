public class Computer {
    /**
     * Coin Object for computer used for Coin color
     */
    public Coin coin;

    /**
     * tree of computer
     */
    Tree tree;

    /**
     * Constructer for Computer creates the Root and Coin node
     * @param board
     * @param coincolor
     */

    public Computer(String[][] board, String coincolor) {
        tree = new Tree(new TreeNode(board, -1));
        coin = new Coin(coincolor);
    }

    /**
     * makes move for computer
     *
     * @return
     */
    public int makingMove(String[][] board, int[] columnsrow) {
        insertDataToChild(board, columnsrow);
        int move = tree.selectColumn(columnsrow).index;

        return move;

    }


    /**
     * 
     * inserts data to root's child. Every child has alternative board
     */

    void insertDataToChild(String[][] board, int[] columnsrow) {
        int i = 0;
        String[][] tmpboard = board;


        while (i < 7) {
            if (columnsrow[i] > 0) {

                tmpboard[columnsrow[i]-1][i] = " Y ";
                tree.insertchild(new TreeNode(tmpboard, i));
                tmpboard[columnsrow[i]-1][i] = " - ";



            }

            i++;
        }


    }
}
