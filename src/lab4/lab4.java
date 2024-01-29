package lab4;

import java.util.Scanner;

public class Lab4 {
  private static String ERROR_MESSAGE = "Base or Number is not valid";
  public static void main(String[] args) {
    calculateTuitionCost(10_000f, 0.05f);
    calculateTuitionCost(20_000f, .1f);
    calculateTuitionCost(99_999f, .2f);

    additionalAlgorithm(5, "0XF23B5", "0X6789A"); //base 16
    additionalAlgorithm(3, "0345", "0723"); //base 8
    additionalAlgorithm(13, "0b0000110100100", "0b1101100111001"); //base 2
    additionalAlgorithm(13, "0b0000110100100", "011101100111001"); //base 2
  }

//print the tuition cost
  public static void calculateTuitionCost(double annualTuitionCost, double interestRate)
  {
    double[] result = getTuitionCost(annualTuitionCost, interestRate);
    System.out.println("The cost of tuition in 10 years is " + result[0]);
    System.out.println("The cost of tuition in 10 years for 4 years is " + result[1]);
  }

//Get the tuition cost
  public static double[] getTuitionCost(double annualTuitionCost, double interestRate)
  {
    //Using double to increase the accuracy
    double oneYearCost_inTenYears = annualTuitionCost;
    double fourYearCost_inTenYears = annualTuitionCost;
    //Calculate the cost of tuition in 10 years
    for(int i = 0; i < 13; ++i)
    { 
      if(i < 4 && i > 0)
      {
        //It would add the cost at the begining of the first four year
        fourYearCost_inTenYears += annualTuitionCost;
      }
      
      if(i < 10)
      {
        oneYearCost_inTenYears *= (1 + interestRate);
        fourYearCost_inTenYears*= (1 + interestRate);
      }
      else
      { 
        //When it is at 10 year
        //The 4th year tuition cost is compounded for 7years, it need to compound for 3 more years
        fourYearCost_inTenYears*= (1 + interestRate);
      }
    }

    double[] ret = {oneYearCost_inTenYears, fourYearCost_inTenYears};
    return ret;
  }
  
//print the result of addition
  public static int additionalAlgorithm(int numberOfDigit, String numberA, String numberB)
  {
    String result = getAdditionAlgorithm(numberOfDigit, numberA, numberB);

    if(result.equals(ERROR_MESSAGE))
    {
      System.out.println(result);
      return -1;
    }
    else
    {
      System.out.println("The result of addition is " + result);
      return 0;
    }
  }

//Get the result of addition
  public static String getAdditionAlgorithm(int numberOfDigit, String numberA, String numberB)
  {
    //Validate the input
    int baseA = identifyBase(numberA);
    int baseB = identifyBase(numberB);
    boolean baseIsValid = baseA == baseB && baseA != -1; //tow number have the same base + valid prefix for bases 
    
    int base = baseA;

    //Process the string
    if(baseIsValid && base != 10) 
    {
      //Remove the prefix of the number if the base is not 10
      switch (base) {
        case 8: //Octal, i.e. numA = 07231 , and after numA = 7231
          numberA = numberA.substring(1);
          numberB = numberB.substring(1);
          break;
        case 2:
        case 16:
          numberA = numberA.substring(2);
          numberB = numberB.substring(2);
          break;
      }
    }

    boolean stringIsValid = numberA.length() == numberOfDigit && numberB.length() == numberOfDigit;
    
    //Everything is valid
    if(baseIsValid && stringIsValid)
    {
      return theAlgorithm(base, numberOfDigit, numberA, numberB);
    }
    else 
    {
      return ERROR_MESSAGE;
    }
  }

//Helper
  private static String theAlgorithm(int base, int numberOfDigit, String numberA, String numberB) {
    //return the sum of two numbers in the given base
    char intToDigit[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
    String result = "";
    int carry = 0;
    int digitA;
    int digitB;
    int sum;

    //i : starting the first place of the number; when i = 0, it is the last place of the number
    for(int i = numberOfDigit - 1; i >= 0; --i)
    {
      //Get the integer value of the digit
      digitA = parseInt(numberA.charAt(i));
      digitB = parseInt(numberB.charAt(i));
      sum = digitA + digitB + carry;

      if(sum >=  base)
      {
        
        carry = 1;
        sum -= base;
      }
      else
      {
        carry = 0;
      }

      //append the value to the front of the result
      result = intToDigit[sum] + result;
    }

    if(carry == 1)
    {
      result = "1" + result;
    }
    
    return result;
  }

  private static int parseInt(char c) {
    //parse the char to int with different Bases
    int  digitToInt[] = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
    if(Character.isLetter(c))
    {
      return digitToInt[c - 'A' + 10];
    }
    else
    {
      return digitToInt[c - '0'];
    }
  }

  private static int parseInt(String s, int base) {
    //parse the string to int with different Bases
    int total = 0;
    total = parseInt(s.charAt(s.length() - 1));
    for(int i = s.length() - 2; i >= 0; --i)
    {
      total += total * base + parseInt(s.charAt(i));
    }

    return total;
  }
  
  private static int identifyBase(String number)
  {
    //Check the prefix of the number
    String prefix = number.substring(0,2).toLowerCase();

    if(prefix.equals("0x"))           return 16;
    else if(prefix.equals("0b"))      return 2;
    else if(prefix.charAt(0) == '0')  return 8;
    else if(Character.isDigit(number.charAt(0)) && Character.isDigit(1)) return 10; //Check the first two char are numbers
    else return -1; //Invalid base
  }


}
