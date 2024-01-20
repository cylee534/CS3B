package lab3;

import java.util.Scanner;

public class lab3 {
  public static void main(String[] args) {
    int cardNumber;
    //if the argument is passed, use the first number as cardnumber
    if(args.length > 0)
    {
      cardNumber = Integer.parseInt(args[0]);
      System.out.println("Your card is: " + getPokerCard(cardNumber));
    }
    else
    {
    // Sample Test case, checking the edge cases
      // System.out.printf("Number%d: %30s\n", 0, getPokerCard(0));
      // System.out.printf("Number%d: %30s\n", 1, getPokerCard(1));
      // System.out.printf("Number%d: %30s\n", 13, getPokerCard(13));
      // System.out.printf("Number%d: %30s\n", 14, getPokerCard(14));
      // System.out.printf("Number%d: %30s\n", 26, getPokerCard(26));
      // System.out.printf("Number%d: %30s\n", 27, getPokerCard(27));
      // System.out.printf("Number%d: %30s\n", 39, getPokerCard(39));
      // System.out.printf("Number%d: %30s\n", 52, getPokerCard(52));
      // System.out.printf("Number%d: %30s\n", 40, getPokerCard(40));
      // System.out.printf("Number%d: %30s\n", 53, getPokerCard(53));
      
      //Using scanner to get input the card number
      Scanner input = new Scanner(System.in);
      System.out.println("Please enter a number between 1 and 52: ");
      cardNumber = input.nextInt();
      System.out.println("Your card is: " + getPokerCard(cardNumber));
      input.close();
    }
  }     

  public static String getPokerCard(int cardNumber)
  {
    
    if (cardNumber >= 1 && cardNumber <= 52)
    {
      // 1-13: Clubs, 14-26: Diamonds, 27-39: Hearts, 40-52: Spades
      int suitNo = (cardNumber - 1) / 13; // example ==> (1 to 12) / 13 = 0
      int rankNo = cardNumber % 13;     // example ==> 1 % 13 = 1 =>Ace
      String suit = "";
      String rank = "";

      //Setting the suit
      switch (suitNo) {
        case 0: suit = "Clubs"; 
                break;
        case 1: suit = "Diamonds";
                break;
        case 2: suit = "Hearts";
                break;
        case 3: suit = "Spades";
                break;
      }

      //Setting the rank
      switch (rankNo) {
        case 1: rank = "Ace";
                break;
        case 2: rank = "2";
                break;
        case 3: rank = "3";
                break;
        case 4: rank = "4";
                break;
        case 5: rank = "5";
                break;
        case 6: rank = "6";
                break;
        case 7: rank = "7";
                break;
        case 8: rank = "8";
                break;
        case 9: rank = "9";
                break;
        case 10: rank = "10";
                break;
        case 11: rank = "Jack";
                break;
        case 12: rank = "Queen";
                break;
        case 0: rank = "King";  // 13 % 13 = 0
                break;
      }
    
      return rank + " of " + suit;
    }
    else
    //The number is not between 1 and 52, so return an error message
      return "Wrong number";
  }
}
