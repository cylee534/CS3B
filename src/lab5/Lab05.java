package lab5;

import java.util.Scanner;

//My helper
import myHelper.ArrayFun;
import myHelper.Asker;

public class Lab05 {
  private static final int MAX_NUMBER = 255;
  private static final int MAX_DAY = 31;
  private static String[] choiceString = ArrayFun.selectionSort(new String[]{"y", "n", "idk"});
  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    guessYourNumber(in);
  }

  //The enhance game
  public static void guessYourNumber(Scanner in)
  {
  //Entries
    int maxNumber = getNumberUpperBound(in);
	  int numberOfSet = (int) ( Math.ceil(Math.log(maxNumber) / Math.log(2)) );
    int[][] numbSets = getNumbSets(maxNumber, numberOfSet);
    
    printEntry(in, maxNumber);
    
    //...End of Entries...//

    //Body
    int bit = 0;
    for(int i = 0; i < numberOfSet ; ++i)
    { 
      //Print the Set
      printSets(numbSets, i);
      
      //Ask number in set
      if(isNumbInSet(in, numbSets[i], i, maxNumber))
      {
        bit = setBit(bit, i);
      }

      System.out.println("");
    } 
   //...End of Body...
   
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
      printSets(numbSets, i);
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

//Helper Function...

//Procedure helper (that encapsulate the main logic)...

  //@param maxNumber: the upper bound number of our numberGame
  private static boolean isNumbInSet(Scanner in, int[] numberSet, int i, int maxNumber) {
    int choiceIndex;
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

  //@param maxNumber: the upper bound number of our numberGame
  private static boolean searchForUser(Scanner in, int[] numberSet, int maxNumber) {
    int searchNumber;
    boolean numbInSet;
    searchNumber = Asker.askNumber(in, "=> I'll search you number for you. Enter your number: ", 0, maxNumber);
    numbInSet = ArrayFun.binarySearch(searchNumber, numberSet, 0, numberSet.length -1) != -1;
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

  private static int getNumberUpperBound(Scanner in) {
    return Asker.askNumber(
      in,
      String.format("=>Enter the upper bound of the number (From 1 to %d): ", MAX_NUMBER),
      1, MAX_NUMBER,
      "Invalid input! Please enter a number between 1 and " + MAX_NUMBER);
  }
  
  private static int[][] getNumbSets(int maxNumber, int numberOfSet) {
    int[][] numbSets = new int[numberOfSet][];
    for(int i = 0; i < numberOfSet ; ++i)//init each number set
    {
      numbSets[i] = commonBitGenerator(i, maxNumber);
    }
    return numbSets;
  }

  private static void printEntry(Scanner in, int maxNumber) {
    System.out.println(
      String.format("=>Think a number between %d and %d", 1, maxNumber)
    );
    System.out.println("=> then, I'll guess your number! (Press Enter to continue)");
    in.nextLine();
  }
  
  //...End of Procedure helper...//

//functional helper...//

  //set the corresponding bit
  private static int setBit(int bit, int pos) {
    bit |= (1 << pos);
    return bit;
  }

  private static void printSets(int[][] numbSets, int i) {
    System.out.println("Set # " + (i+1));
    ArrayFun.printArray(numbSets[i], 10, -1);
  }
  
  //return all the 8bits integer with its n_th bit turns ON
  //Up to number m
  private static int[] commonBitGenerator(int n, int m)
  {
    int count = 0;
    int arr[] = new int[m/2 + m%2 + 1];
    ArrayFun.initArray(arr, -1);

    for(int i = 0; i <= m ; ++i)
    {
      if((i >> n & 1) == 1)
      {
        arr[count++] = i;
      }
    }
    
    //indicating the end of the array
    arr[count] = -1;
    return arr;
  } 
  
  //...End of functional helper...//

}
