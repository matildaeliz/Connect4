public class Player {
    /**
     * Coin Object for player  used for Coin color
     */
 Coin coin;

 public Player(String coincolor){
     coin=new Coin(coincolor);
 }

    /**
     * Methods makes a move to board
     * @param column
     * @return
     */
    public int makingMove(int column){

        return column;
    }

}
