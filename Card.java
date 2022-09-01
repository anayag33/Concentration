package com.company;

public class Card {
   int face = 0 ;
   int suit = 0;
   boolean isFaceUp = false;

   public Card(){
   }

   public Card(int f, int s, boolean is){
       face = f;
       suit = s;
       isFaceUp = is;
   }

   public static String cardToString(Card c){
       String rv = "";//translates numbers to string
       int suit = c.suit;
       int face = c.face;
       if (suit == 1)
           rv = rv + "S";
       if (suit == 2)
           rv = rv + "H";
       if (suit == 3)
           rv = rv + "C";
       if (suit == 4)
           rv = rv + "D";
       if (face == 1)
           rv = rv + "A";
       if (face > 1 && face < 10)
           rv = rv + c.face;
       if (face == 10)
           rv = rv + "X";
       if (face == 11)
           rv = rv + "J";
       if (face == 12)
           rv = rv + "Q";
       if (face == 13)
           rv = rv + "K";
       if (face == 0 && suit == 0)//if suit/face is 0, has an empty string
           rv = " ";
       return rv;
   }//end cardToString()
}
