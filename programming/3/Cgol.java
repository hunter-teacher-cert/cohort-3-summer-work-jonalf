
import java.io.*;
import java.util.*;

/**
 * Conway's Game of Life by Team AreWeSentientYet?
 * First Last
 * collaborators: First Last, First Last
 */

/**
   The Rules of Life:
   Survivals:
   * A living cell with 2 or 3 living neighbours will survive for the next generation.
   Deaths:
   * Each cell with >3 neighbours will die from overpopulation.
   * Every cell with <2 neighbours will die from isolation.
   Births:
   * Each dead cell adjacent to exactly 3 living neighbours is a birth cell. It will come alive next generation.
   NOTA BENE:  All births and deaths occur simultaneously. Together, they constitute a single generation.
*/

public class Cgol
{

  //create, initialize, and return  empty board (all cells dead)
  public static char[][] createNewBoard( int rows, int cols )
  {
    char[][] board = new char[rows][cols];
    for (int r=0; r < board.length; r++) {
      for (int c=0; c < board[r].length; c++) {
        board[r][c] = ' ';
      }
    }
    return board;
  }//createNewBoard


  //print the board to the terminal
  public static void printBoard( char[][] board )
  {
    String s = "";
   for (int r=0; r < board.length; r++) {
      for (int c=0; c < board[r].length; c++) {
        s+= board[r][c];
      }
     s+= "\n";
    }
    System.out.println(s);
  }//printBoard


  //set cell (r,c) to val
  public static void setCell( char[][] board, int r, int c, char val )
  {
    board[r][c] = val;
  }


  //return number of living neigbours of board[r][c]
  public static int countNeighbours( char[][] board, int r, int c )
  {
    int liveNeighbors = 0;
    for (int nr = -1; nr <= 1; nr++) {
      int nrow = r + nr;
      if (nrow < 0) {
        nrow = board.length-1;
      }
      else if (nrow > board.length-1) {
        nrow = 0;
      }
      for (int nc = -1; nc <= 1; nc++) {
        int ncol = c + nc;
        if (ncol < 0) {
          ncol = board[nrow].length-1;
        }
        else if (ncol > board[nrow].length-1) {
          ncol = 0;
        }
        if ( (ncol != c || nrow != r) && board[nrow][ncol] == 'X')  {
          liveNeighbors++;
        }
      }//neighbor cols
    }//neighbor rows
    
    return liveNeighbors;
  }//countNeighbours


  /**
     precond: given a board and a cell
     postcond: return next generation cell state based on CGOL rules
     (alive 'X', dead ' ')
  */
  public static char getNextGenCell( char[][] board,int r, int c )
  {
    char nextGen = 0;
    char thisCell = board[r][c];
    int liveNeighbors = countNeighbours(board, r, c);
    if (thisCell == ' ' && liveNeighbors == 3) {
      nextGen = 'X';
    }//birth
    else if (thisCell == 'X' && liveNeighbors < 2) {
      nextGen = ' ';
    }//boredom
    else if (thisCell == 'X' && liveNeighbors > 3) {
      nextGen = ' ';
    }
    else {
      nextGen = thisCell;
    }
    return nextGen;
  }


  //generate and return a new board representing next generation
  public static char[][] generateNextBoard( char[][] board )
  {
    char[][] nextGen = new char[board.length][board[0].length];
    for (int r=0; r < board.length; r++) {
      for (int c=0; c < board[r].length; c++) {
        nextGen[r][c] = getNextGenCell(board, r, c);
      }
    } 
    return nextGen;
  }


  public static void main( String[] args )
  {
  
    char[][] board;
    board = createNewBoard(25,25);
    printBoard(board);
    System.out.println("--------------------------");
    //breathe life into some cells:
    setCell(board, 0, 0, 'X');
    setCell(board, 0, 1, 'X');
    setCell(board, 1, 0, 'X');
    printBoard(board);
    int neighbors = countNeighbours(board, 0, 0);
    char n = getNextGenCell(board, 0, 0);
    System.out.println("cell 0 0 count: " + neighbors + " next: [" + n + "]");
    neighbors = countNeighbours(board, 1, 1);
    n = getNextGenCell(board, 1, 1);
    System.out.println("cell 1 1 count: " + neighbors + " next: [" + n + "]");
    neighbors = countNeighbours(board, 2, 0);
    n = getNextGenCell(board, 2, 0);
    System.out.println("cell 2 0 count: " + neighbors + " next: [" + n + "]");
    // TASK:
    // Once your initial version is running,
    // try out different starting configurations of living cells...
    // (Feel free to comment out the above three lines.)
    System.out.println("Gen X:");
    printBoard(board);
    System.out.println("--------------------------\n\n");
    board = generateNextBoard(board);
    System.out.println("Gen X+1:");
    printBoard(board);
    System.out.println("--------------------------\n\n");
    board = generateNextBoard(board);
    System.out.println("Gen X+2:");
    printBoard(board);
    System.out.println("--------------------------\n\n");
    board = generateNextBoard(board);
    System.out.println("Gen X+3:");
    printBoard(board);
    System.out.println("--------------------------\n\n");
  }//end main()

}//end class