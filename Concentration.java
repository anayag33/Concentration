package com.company;

import java.util.Scanner;

public class Concentration {
    
  public static void printBoard(Card[][] c){
       System.out.println("\t1\t2\t3\t4\t5\t6\t7\t8");//labels columns
       int counter = 0;//counters lets us use space until 52 (no last 4 spaces)
       for (int i = 0; i<7; i++){
           String value = (i+1) + "";//labels rows
           for (int j = 0; j<8; j++){
               if (counter < 52) {
                   if (c[i][j].isFaceUp == true)
                       value = value + "\t" + Card.cardToString(c[i][j]);//prints a tab and the card string
                   if (c[i][j].isFaceUp == false)
                       value = value + "\t" + "??";//prints question mark (hidden)
               }
               counter = counter + 1;
           }
           System.out.println(value);//prints line of values each time
       }

  }//end printBoard()
  
  public static Card[][] printBoardFaceUp(Card[][] c){
   System.out.println("\t1\t2\t3\t4\t5\t6\t7\t8");//labels columns
   int counter = 0;
   for (int i = 0; i<c.length; i++){
       String value = (i+1) + "";//labels rows
       for (int j = 0; j<c.length + 1; j++) {
           if (counter < 52) {
               value = value + "\t" + Card.cardToString(c[i][j]);//prints tab and card value
               counter = counter + 1;
           }
           else if (counter > 52){
               c[i][j] = new Card(0, 0, false);//ignores last 4 empty spaces
           }
       }
       System.out.println(value);//prints line of values each time
   }
   return c;
}//end printBoardFaceUp()

}
