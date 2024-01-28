package lab4;

import java.util.Scanner;

public class GuessingNumber
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    System.out.println("Guessing Number");
    int digit = 0;

    game(input);
    
    input.close();
  }
  
  public static void game(Scanner input)
  {
    System.out.println(":Guessing Number Game:");
    int digit = 0;
    int tries = 10;
    boolean isContinue = true;
    //Validate the input

    while(isContinue)
    {
      tries = buyTry(input, tries);
      digit = getDigit(input);
      tries = guessingNumber(digit, input, tries);
      isContinue = askYesNo(input, "Do you want to Continue?");
    }      
  }
  
  private static int guessingNumber(int digit, Scanner input, int tries)
  {   
  //Entries
    System.out.println("");
    System.out.println(String.format("Guess a number between 0 and %d", (int)(Math.pow(10,digit)-1)));
    System.out.println("");

    if(tries == 0)
    {
      System.out.println("You have no more tries left, come back after you buy more tries");
      return tries;
    }
    
    int guess = -1;
    int count = 0;
    int number = (int)(Math.random() * Math.pow(10,digit));
    int lastLargerGuess = Integer.MAX_VALUE;
    int lastSamllerGuess = -1;
    boolean isCorrect = false;

    //Body
    while(!isCorrect && tries > 0)
    {
      System.out.println("");
      
      System.out.println("Number of tries left: " + tries);
      System.out.println("Last larger guess: " + lastLargerGuess);
      System.out.println("Last smaller guess: " + lastSamllerGuess);
      System.out.print(String.format("%d# Enter your guesses", count));
      
      //Get the input
      guess = askNumber(input, "");

    //Hints the user to guess a higher or lower number
      if(guess > number)
      {
        if(guess < lastLargerGuess)  lastLargerGuess = guess;
        System.out.println("->Too high");
      }
      else if(guess < number)
      {
        if (guess > lastSamllerGuess) lastSamllerGuess = guess;
        System.out.println("->Too low");
      }
      else
      {
        System.out.println("->Correct");
        isCorrect = true;
      }
      
      tries--;
      count++;
    }
  //EndofBody


    System.out.println("");
    System.out.println("Your Last guess is: " + guess);
    System.out.println("The number is: " + number);
    System.out.println("Number of guesses: " + count);
    System.out.println("Number of tries left: " + tries);
    return tries;
  }
  
  
  private static int buyTry(Scanner input, int tries)
  {
    
    System.out.println("Remaining tries: " + tries);
    boolean isYes = askYesNo(input,"Do you want to buy more tries?");
    if(isYes)
    {
      tries += askNumber(input,"How many tries do you want to buy?");
      System.out.println("Remaining tries: " + tries);
    }
    return tries;
  }
  private static int getDigit(Scanner input)
  {
    int digit = 0;
    boolean done = false;

    while(!done)
    {
      digit = askNumber(input,"Enter a whole number between 1 and 9");
      done = digit >= 1 || digit <= 9;
    }
    return digit;
  }
  
  
  private static int askNumber(Scanner input, String prompt)
  {
    int number = 0;
    boolean done = false;
    while(!done)
    {
      System.out.print(prompt + ": ");
      try 
      {
        number = input.nextInt();
      }
      catch(Exception e)
      {
        System.out.println("->Invalid input");
        input.next();
        continue;
      }
      done = true;
    }
    return number;
  }
  
  private static boolean askYesNo(Scanner input, String prompt)
  {
    boolean done = false;
    boolean isYes = false;
    while(!done)
    {
      System.out.print(prompt + " (y/n):");
      String strContinue = input.next();
      if(strContinue.equals("y"))
      {
        isYes = true;
        done = true;
      }
      else if(strContinue.equals("n"))
      {
        isYes = false;
        done = true;
      }
      else
      {
        System.out.println("->Invalid input");
        continue;
      }
    }
    
    return isYes;
  }

}