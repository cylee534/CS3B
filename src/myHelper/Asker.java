package myHelper;

import java.util.Scanner;

public class Asker {
  public static String INVALID_INPUT = "<Invalid input>";
  //Ask user input with prompt...
  //would not stop until user input a valid input
  //@return Always return a valid input 
  private static boolean askYesNo(Scanner input, String prompt)
  {
    boolean done = false;
    boolean isYes = false;
    while(!done)
    {
      System.out.print("\n" + prompt + " (y/n):");
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
    
  //return index of target
  public static int askTarget(Scanner input, String prompt, String... targets)
  {
    boolean done = false;
    int targetIndex = -1;

    while(!done)
    {
      System.out.print("\n" + prompt);
      String inputStr = input.next();
      inputStr = inputStr.toLowerCase();
      targetIndex = ArrayFun.binarySearch(inputStr, targets, 0, targets.length -1);
      
      if(targetIndex >= 0)
      {
        done = true;
      }
      else
      {
        System.out.println(INVALID_INPUT);
      }
    
    }
    
    return targetIndex;
  }

  public static int askNumber(Scanner input, String prompt)
  {
    return askNumber(input, prompt, 0, Integer.MAX_VALUE);
  }
  
  public static int askNumber(Scanner input, String prompt, int RangeStart, int RangeEnd)
  {
    return askNumber(input, prompt, RangeStart, RangeEnd, INVALID_INPUT);
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
        if(number < RangeStart || number > RangeEnd)
        {
          System.out.println(errorPrompt);
          continue;
        }
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
