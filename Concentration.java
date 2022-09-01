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
    
    public static Card[][] createRandomDeck(Card[][] a){
        Card [] b = new Card [52];//new 1D array
        int c = 0;
        for (int i = 0; i<7; i++){//traverses 2D array
            for (int j = 0; j<8; j++){
                if (c<52) {
                    b[c] = a[i][j];//assigns 2D array values to one giant 1D array
                    c = c + 1;//increases counter
                }
            }
        }
        int randomIndex = 0;
        Card storage = new Card(0, 0, false);//empty card variable for storage
        for(int i = 0; i < 52; i++) {
            randomIndex = (int) (Math.random() * 52);//casting picks random int 0-51
            storage = b[i];//swaps values
            b[i] = b[randomIndex];
            b[randomIndex] = storage;
        }

        Card [][] w = new Card[7][8];//new 2D array
        int counter = 0;
        for (int i = 0; i<7; i++) {
            for (int j = 0; j < 8; j++) {
                if (counter < 52) {
                    w[i][j] = b[counter];//assigns 1D array values to new 2D array
                    counter = counter + 1;
                }
                else if (counter > 52)
                    w[i][j] = new Card(0, 0, false);//last 4 cards are blank
            }
        }
        return w;
    }//end createRandomDeck()

    
    public static Card[][] createRandomBoard(Card[][] c){
        System.out.println("\t1\t2\t3\t4\t5\t6\t7\t8");//labels columns
        int counter = 0;
        for (int i = 0; i<7; i++){
            String value = (i+1) + "";//labels rows
            for (int j = 0; j<8; j++){
                if (counter < 52) {
                    if (c[i][j].isFaceUp == true)
                        value = value + "\t" + Card.cardToString(c[i][j]);//prints card value
                    if (c[i][j].isFaceUp == false)
                        value = value + "\t" + "??";//prints ?? (it is hidden)
                }
                counter = counter + 1;//increases counter
            }
            System.out.println(value);//prints line of values each time
        }
        return c;
    }//end createRandomBoard()

    
    public static void play(){
        Card[][] a = new Card[7][8];//new 2D card array
        int s = 1;
        int f = 1;
        for (int r = 0; r<7; r++){
            for (int c = 0; c<8; c++){
                a[r][c] = new Card(f, s, false);//fills array with normal cards in order
                if (f == 13 && f!= 5){
                    f = 1;
                    s = s + 1;
                }
                else {
                    f = f + 1;
                    if(s == 5)
                        a[r][c] = new Card(0, 0, false);//last 4 spaces are blank
                }
                System.out.println(Card.cardToString(a[r][c]));
            }
        }
        printBoardFaceUp(a);
        Card[][] x = createRandomDeck(a);//creates new array with randomized cards
        printBoardFaceUp(x);
        createRandomBoard(x);//creates board using new array

        int Counter1 = 0;
        int Counter2 = 0;
        System.out.println("Welcome to Memory!");
        System.out.println("Decide who is going to be Player 1 and Player 2.");

        while (Counter1 < 52) {//will continue until all cards are collected
            System.out.println("Player 1, which two cards would you like to flip over?");
            System.out.println("(Enter answer as 'row1column1 row2column2'...ex. '34-17')");
            Scanner userInput = new Scanner(System.in);//user input
            String response1 = "";
            response1 = userInput.next();

            String str1 = "";
            String str2 = "";
            int one = 0;
            int two = 0;
            str1 = response1.substring(0, 2);//separates first value
            str2 = response1.substring(3);//separates second value
            one = Integer.parseInt(str1);//converts to integer
            two = Integer.parseInt(str2);//converts to integer

            int m = (one/10) -1;//isolates 1st row value
            int n = (one%10) -1;//isolates 1st column value
            int o = (two/10) -1;//isolates 2nd row value
            int p = (two%10) -1;//isolates 2nd column value

            x[m][n].isFaceUp = true;//changes chosen values to face up
            x[o][p].isFaceUp = true;
            printBoard(x);//prints same board

            if (x[m][n].face == x[o][p].face){//is face is equal, cards will disappear+counter will increase
                Counter1 = Counter1 + 1;
                x[m][n] = new Card (0, 0, true);
                x[o][p] = new Card (0, 0, true);
                System.out.println("You got a match!");
            }
            else{
                x[m][n].isFaceUp = false;//if not a match, both face up values will be false
                x[o][p].isFaceUp = false;
                System.out.println("No match :(");
                System.out.println("");
            }
            printBoard(x);
            //player 2s turn
            System.out.println("Player 2, which two cards would you like to flip over?");
            System.out.println("(Enter answer as 'row1column1 row2column2'...ex. '34-17')");

            userInput = new Scanner(System.in);
            String response2 = "";
            response2 = userInput.next();

            str1 = response2.substring(0, 2);//separates first value
            str2 = response2.substring(3);//separates second value
            one = Integer.parseInt(str1);//converts to integer
            two = Integer.parseInt(str2);//converts to integer
            x[m][n].isFaceUp = true;//changes chosen values to face up
            x[o][p].isFaceUp = true;
            printBoard(a);

            if (x[m][n].face == x[o][p].face){//is face is equal, cards will disappear+counter will increase
                Counter2 = Counter2 + 1;
                x[m][n] = new Card (0, 0, true);
                x[o][p] = new Card (0, 0, true);
                System.out.println("You got a match!");
            }
            else{
                x[m][n].isFaceUp = false;//if not a match, both face up values will be false
                x[o][p].isFaceUp = false;
                System.out.println("No match :(");
            }
            printBoard(x);
        }
    }//end play()

}
