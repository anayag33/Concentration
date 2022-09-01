package com.company;

public class Main {

   public static void main(String[] args) {
       Card[][] a = new Card[7][8];//new array
       int s = 1;
       int f = 1;
       for (int r = 0; r<7; r++){//fills array using for loop and counters
           for (int c = 0; c<8; c++){
               a[r][c] = new Card(f, s, false);
               if (f == 13 && f!= 5){
                   f = 1;
                   s = s + 1;//increases suit
               }
               else {
                   f = f + 1;//increases face
                   if(s == 5)
                       a[r][c] = new Card(0, 0, false);//no card fro last 4 spots
               }
               System.out.println(Card.cardToString(a[r][c]));
           }
       }
       printBoardFaceUp(a);
       Concentration.play();//plays the game
   }//end main()
}
