package lab5;

import java.util.Scanner;

import myHelper.ArrayFun;
//My helper
import myHelper.Asker;

public class Lab05 {
  private static final int MAX_NUMBER = 256;
  private static final int MAX_DAY = 31;

  public static void main(String[] args)
  {
	  Scanner in = new Scanner(System.in);
    guessBirthday(in);
    guessYourNumber(in);
  }

  //The enhance game
  public static void guessYourNumber(Scanner in)
  {
  //Entries
	int numberOfSet = 8;
    int[][] numbSets = new int[numberOfSet ][];
    for(int i = 0; i < numberOfSet ; ++i)//init each number set
    {
      numbSets[i] = commonBitGenerator(i, MAX_NUMBER);
    }
    
    System.out.println(
      String.format("=>Think of a number between %d and %d", 1, MAX_NUMBER)
    );
    //...End of Entries...//

    //Body
    int bit = 0;
    for(int i = 0; i < numberOfSet ; ++i)
    { 

      //Print the Set
      printSet(numbSets, i);
      
      //Ask number in set
      if(isNumbInSet(in, numbSets[i], i, MAX_NUMBER))
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

  //Guess day of birth
  public static void guessBirthday(Scanner in)
  {
  //Entries
	//init each number set
	int numberOfSet = 5;
    int[][] numbSets = new int[numberOfSet][];
    for(int i = 0; i < numberOfSet; ++i)
    {
      numbSets[i] = commonBitGenerator(i, MAX_DAY);
    }
    
    System.out.println(
      String.format("=>I'll guess you day of birth!")
    );
    //...End of Entries...//

    //Body
    int bit = 0;
    for(int i = 0; i < numberOfSet; ++i)
    { 

      //Print the Set
      printSet(numbSets, i);
      
      //Ask user number in set
      if(isNumbInSet(in, numbSets[i], i, MAX_DAY))
      {
        bit = setBit(bit, i);
      }

      System.out.println("");
    } 
   //...End of Body...
  
    //Print Result
    if(bit != 0) 
      System.out.println(String.format("%50s %d","Your birthday is at ", bit));
    else 
      System.out.println(String.format("%50s","I can't guess your birthday!"));
  }

//Helper Function....
  //asking the user do they see the number in set
  private static boolean isNumbInSet(Scanner in, int[] numberSet, int i, int maxNumber) {
    int choiceIndex;
    int searchNumber;
    String choiceString[] = {"idk", "n", "y"};
    String inPrompt = String.format("=> Can you see your number in set %d?"+ "(Y/N/IDK): ", i+1);
    String choice;
    boolean numbInSet;
    
    //Get input (Y/N/IDK)
    choiceIndex = Asker.askTarget(in, inPrompt, choiceString);
    choice = choiceString[choiceIndex];

    
    if(choice == "y")
    {
      numbInSet = true;
    }
    else if(choice == "idk") //Search num for  user
    {
      numbInSet = searchForUser(in, numberSet, maxNumber);
    }
    else
    {
      numbInSet = false;
    }

    return numbInSet;
  }

  private static boolean searchForUser(Scanner in, int[] numberSet, int maxNumber) {
    int searchNumber;
    boolean numbInSet;
    searchNumber = Asker.askNumber(in, "=> I'll search you number for you. Enter your number: ", 0, maxNumber);
    numbInSet = ArrayFun.binarySearch(searchNumber, numberSet, 0, numberSet.length) != -1;
    if(numbInSet)
    {
      System.out.println("=> I found your number in the set!");
    }
    else
    {
      System.out.println("=> I can't find your number in the set!");
    }
    
    return numbInSet;
  }

  //set the corresponding bit
  private static int setBit(int bit, int pos) {
    bit |= (1 << pos);
    return bit;
  }

  //Print the i th set in the 2d-array
  private static void printSet(int[][] numbSets, int i) {
    System.out.println("Set # " + (i+1));
    ArrayFun.printArray(numbSets[i], 10);
  }
  
//return all the 8bits integer with its n_th bit turns ON
//Up to number m
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
  
}
