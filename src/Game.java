import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Game {

      int dimension;
      Board board;
     List<Player> players;
      Player winner;
      int currentPlayerIndex;
      Dice dice;
       int numberOfConsecutiveTurn;


      public Game() {
           this.dimension = 10;
           board=new Board(dimension,10,6);
           players=new ArrayList<Player>();
           players.addFirst(new Player("Player1",0));
           players.addFirst(new Player("Player2",0));
           dice=new Dice(1);
           currentPlayerIndex=0;
          numberOfConsecutiveTurn=0;
      }

      public void startGame()
      {
            while(winner==null)
            {
               //whose turn it is
               Player player=players.get(currentPlayerIndex);
               System.out.println("Player "+player.getName()+" turn is "+"player current Position is "+player.getPos());

               //roll the dice
                int diceValue= dice.rollDice();
                System.out.println("Dice value: "+diceValue);
                int playerNewPos=calculateFinalPos(player.getPos()+diceValue);

                //winning logic
                if(playerNewPos==dimension*dimension-1)
                {
                    winner=player;
                    System.out.println("Player "+player.getName()+" won the game");
                }

                if(playerNewPos<dimension*dimension-1)
                {
                    player.setPos(playerNewPos);
                }


                //next turn
                if(diceValue==6)
                {
                     if(numberOfConsecutiveTurn==2)
                     {
                          currentPlayerIndex=(currentPlayerIndex+1)%players.size();
                     }

                     numberOfConsecutiveTurn++;
                }
                else
                {
                    currentPlayerIndex=(currentPlayerIndex+1)%players.size();
                }

            }
      }



      public int calculateFinalPos(int pos)
      {

          if(pos>dimension*dimension-1)
               return pos;

            Cell cell=board.getCell(pos);

            if(cell.getJump()!=null){
                Jump jump=cell.getJump();

                if(jump.startingIndex>jump.endingIndex)
                {
                    System.out.println("Snake encountered going to " +jump.endingIndex);

                }
                else
                {
                    System.out.println("Ladder encountered going to " +jump.endingIndex);
                }
                pos=jump.endingIndex;
            }

            return pos;
      }
}
