import java.util.Random;

public class Board {
    int dimension;
    Cell[][] board;
    int numberOfSnake;
    int numberOfLadder;

    public Board(int dimension, int numberOfSnake, int numberOfLadder) {
        this.dimension = dimension;
        this.numberOfSnake = numberOfSnake;
        this.numberOfLadder = numberOfLadder;
        board = new Cell[dimension][dimension];
        for(int x = 0; x < dimension; x++)
            for(int y = 0; y < dimension; y++)
                board[x][y] = new Cell();

        initializeBoard(numberOfLadder,numberOfSnake);
    }

    public void initializeBoard(int numberOfLadder, int numberOfSnake) {
        Random random = new Random();
         while (numberOfSnake > 0) {

             int snakeHead=random.nextInt(0,dimension*dimension-1);
             int snakeEnd=random.nextInt(0,dimension*dimension-1);
             if(snakeHead<snakeEnd){
                 continue;
             }

             Jump jump=new Jump(snakeHead,snakeEnd);
             Cell cell=getCell(snakeHead);
             cell.setJump(jump);
             numberOfSnake--;
         }

         while (numberOfLadder > 0) {
             int ladderHead=random.nextInt(0,dimension*dimension-1);
             int ladderEnd=random.nextInt(0,dimension*dimension-1);
             if(ladderEnd<ladderHead){
                 continue;
             }
             Jump jump=new Jump(ladderHead,ladderEnd);
             Cell cell=getCell(ladderHead);
             cell.setJump(jump);
             numberOfLadder--;
         }
    }

    public Cell getCell(int snakeHead){

          int row=snakeHead/dimension;
          int col=snakeHead%dimension;

          return board[row][col];
    }
}
