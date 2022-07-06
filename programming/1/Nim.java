/**
 * Game of Nim by Team BossCoders
 * First Last
 * collaborators: First Last, First Last
 */

import java.io.*;
import java.util.*;

public class Nim 
{

  public static void main( String[] args ) 
{

    int stones = 12;
    int stonesTaken;

    Scanner input = new Scanner(System.in);
    Random rand = new Random();

    //loop until game ends
    while ( stones > 0 ) {
      //prompt for user input : num of stones
      System.out.print("Enter # of stones to take (1-3): ");
      stonesTaken = input.nextInt();

      if (stonesTaken >= 1 && stonesTaken <= 3) {
        //calculate number of stones remaining, print
        stones-= stonesTaken;
        System.out.println("Stones left: " + stones);
        //check for win
        if (stones <= 0) {
          System.out.println("You win!");
        }//win!
        //machine turn
        else {
          stonesTaken = rand.nextInt(3) + 1;

          //calculate number of stones remaining, print
          stones-= stonesTaken;
          System.out.println("Stones left: " + stones);
          //check for win
          if (stones <= 0) {
            System.out.println("Computer wins!");
          }//computer wins
        }//computer move
      }//correct move
    }


  }


}