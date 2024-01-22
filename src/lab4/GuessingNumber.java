package lab4;

import java.util.Scanner;

public class GuessingNumber
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    System.out.println("Guessing Number");
    int digit = 0;
    while(true)
    {
      System.out.print("Enter the number of digits: ");
      try
      {
        digit = input.nextInt();
        break;
      }
      catch(Exception e)
      {
        System.out.println("Invalid input");
        System.out.println("");
        input.next();
        continue;
      }
      
    }

    guessingNumber(digit, input);
    input.close();
  }

  public static void guessingNumber(int digit, Scanner input)
  { 
    //Validate the input
    if(digit < 1 || digit > 9)
    {
      System.out.println("Invalid digit");
      System.out.println("GoodBye");
      return;
    }

    //Entries
    System.out.println("");
    System.out.println(String.format("Guess a number between 0 and %d", (int)(Math.pow(10,digit)-1)));
    System.out.println("");


    int guess = 0;
    int count = 0;
    int number = (int)(Math.random() * Math.pow(10,digit));
    
    //Body
    while(guess != number)
    {
      try 
      {
        //Get and check the input is valid
        System.out.print(String.format("%d# Enter your guesses: ", count));
        guess = input.nextInt();
      }
      catch(Exception e)
      {
        //if the input is not valid, ask for input again
        System.out.println("Invalid input");
        System.out.println("");
        input.next();
        continue;
      }


      //Hints the user to guess higher or lower
      if(guess > number)
      {
        System.out.println("Too high");
      }
      else if(guess < number)
      {
        System.out.println("Too low");
      }
      else
      {
        System.out.println("Correct");
      }

      System.out.println("");
      count++;
    }

    input.close();
    System.out.println("Number of guesses: " + count);
  }

}