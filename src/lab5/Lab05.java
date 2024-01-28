package lab5;

import java.util.Scanner;

import lab5.ArrayFun;

public class Lab05 {
  private static final int MAX_NUMBER = 256;
  
  public static void main(String[] args)
  {
    guessYourNumber(new Scanner(System.in));
  }

  public static void guessYourNumber(Scanner in)
  {
  //Entries
    
    //called in the body


    int[][] numbSets = new int[8][];
    for(int i = 0; i < 8; ++i)
    {
      numbSets[i] = commonBitGenerator(i, MAX_NUMBER);
    }
    
    System.out.println(
      String.format("=>Think of a number between %d and %d", 1, MAX_NUMBER)
    );
    //...End of Entries...//

    //Body
    int bit = 0;
    for(int i = 0; i < 8; ++i)
    { 

      //Print the Set
      printSet(numbSets, i);
      
      //Ask number in set
      if(isNumbInSet(in, numbSets[i], i))
      {
        bit = setBit(bit, i);
      }

      System.out.println("");
    } 
   //...End of Body...
   
    //Print Result
    if(bit == 0) bit = 256;

    System.out.println(String.format("%50s %d","Your number is", bit));
  }

  private static boolean isNumbInSet(Scanner in, int[] numberSet, int i) {
    int choiceIndex;
    int searchNumber;
    String choiceString[] = {"idk", "n", "y"};
    String inPrompt = String.format("=> Can you see your number in set %d?"+ "(Y/N/IDK): ", i+1);
    String choice;
    boolean numbInSet;
    
    //Get input (Y/N/IDK)
    choiceIndex = askTarget(in, inPrompt, choiceString);
    choice = choiceString[choiceIndex];

    
    if(choice == "y")
    {
      numbInSet = true;
    }
    else if(choice == "idk")
    {
      searchNumber = askNumber(in, "=> I'll search you number for you. Enter your number: ");
      numbInSet = ArrayFun.binarySearch(searchNumber, numberSet, 0, numberSet.length) != -1;
    }
    else
    {
      numbInSet = false;
    }

    return numbInSet;
  }

  private static int setBit(int bit, int pos) {
    bit |= (1 << pos);
    return bit;
  }

  private static void printSet(int[][] numbSets, int i) {
    System.out.println("Set # " + (i+1));
    ArrayFun.printArray(numbSets[i], 10);
  }
  
  //Print all the 8bits integer with its n_th bit == 1
  //Up to number m
  //Each line contains at most 8 numbers
  
  private static int[] commonBitGenerator(int n, int m)
  {
    int count = 0;
    int arr[] = new int[m/2 + m%2];
    ArrayFun.initArray(arr, -1);

    for(int i = 0; i <= m ; ++i)
    {
      if((i >> n & 1) == 1)
      {
        arr[count++] = i;
      }
    }
    
    return arr;
  } 

  //Ask user input with prompt...
  //Always return a valid input
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
        System.out.println("->Invalid input");
        continue;
      }
    
    }
    
    return isYes;
  }
    //return index of target
  private static int askTarget (Scanner input, String prompt, String[] target)
  {
    boolean done = false;
    int targetIndex = -1;

    while(!done)
    {
      System.out.print("\n" + prompt);
      String inputStr = input.next();
      inputStr = inputStr.toLowerCase();
      targetIndex = ArrayFun.binarySearch(inputStr, target, 0, target.length);
      if(targetIndex != -1)
      {
        done = true;
      }
      else
      {
        System.out.println("->Invalid input");
      }
    
    }
    
    return targetIndex;
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
  
}
