package midterm;

import java.util.Scanner;

public class Asker_Midterm {
  public static String INVALID_INPUT = "->Invalid input: please re-enter again";
  //Ask user input with prompt...
  //would not stop until user input a valid input
  //@return Always return a valid input 
  public static boolean askYesNo(Scanner input, String prompt)
  {
    boolean done = false;
    boolean isYes = false;
    while(!done)
    {
      System.out.print(prompt + " (y/n):");
      String inputStr = input.next();
      inputStr = inputStr.toLowerCase();

      if(inputStr.compareToIgnoreCase("y") == 0)
      {
        isYes = true;
        done = true;
      }
      else if(inputStr.compareToIgnoreCase("n") == 0)
      {
        isYes = false;
        done = true;
      }
      else
      {
        System.out.println(INVALID_INPUT);
        continue;
      }
    
    }
    
    return isYes;
  }
  
  public static String askTargetString(Scanner in, String prompt,  String[] targetStrings)
  {
    String inputStr = "";
    boolean done = false;
    while(!done)
    {
      System.out.print(prompt);
      inputStr = in.next();
      for(String str : targetStrings)
      {
        if(inputStr.compareToIgnoreCase(str) == 0)
        {
          done = true;
          break;
        }
      }

      if(!done)
      {
        System.out.println(INVALID_INPUT);
      }
    }
    return inputStr;
  }
  
  //Range = [RangeStart, RangeEnd] (inclusive)
  public static int askNumber(Scanner input, String prompt , int RangeStart, int RangeEnd)
  {
    int number = 0;
    boolean done = false;
    while(!done)
    {
      System.out.print(prompt);
      try 
      {
        number = input.nextInt();
        if(number < RangeStart || number > RangeEnd)
        {
          System.out.println(INVALID_INPUT);
          continue;
        }

      }
      catch(Exception e)
      {
        System.out.println(INVALID_INPUT);
        input.next();
        continue;
      }
      
      done = true;
    }
    return number;
  }

  public static int askNumber(Scanner input, String prompt, int RangeStart, int RangeEnd, String errorPrompt)
  {
    int number = 0;
    boolean done = false;
    while(!done)
    {
      System.out.print(prompt);
      try 
      {
        number = input.nextInt();
      }
      catch(Exception e)
      {
        System.out.println(errorPrompt);
        input.next();
        continue;
      }
      
      done = true;
    }
    return number;
  }

}
