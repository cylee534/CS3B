package lab4;

public class lab4 {
 
  public static void main(String[] args) {
    calculateTuitionCost(10_000f, 0.05f);
    additionalAlgorithm(16, 5, "F23B5", "6789A");
  }

  public static void calculateTuitionCost(float annualTuitionCost, float interestRate)
  {
    float oneYearCost_inTenYears = annualTuitionCost;
    float fourYearCost_inTenYears = annualTuitionCost;
    for(int i = 0; i < 10; ++i)
    { 
      if(i < 4 && i > 0)
      {
        fourYearCost_inTenYears += annualTuitionCost;
      }
      oneYearCost_inTenYears *= (1 + interestRate);
      fourYearCost_inTenYears *= (1 + interestRate);
    }

    System.out.println("The cost of tuition in 10 years is " + oneYearCost_inTenYears);
    System.out.println("The cost of tuition in 10 years for 4 years is " + fourYearCost_inTenYears);
  }


  //A wrapper function for the actual algorithm
  //base is between 2 and 16, numberA and numberB are valid numbers in the given base
  //print the sum of two numbers in the given base and in base 10
  public static int additionalAlgorithm(int base, int numberOfDigit, String numberA, String numberB)
  {
    //Check if base is valid, and the number is valid
    boolean baseIsValid = base <= 16 && base >= 2;
    boolean stringIsValid = numberA.length() == numberOfDigit && numberB.length() == numberOfDigit;
    
    if(baseIsValid && stringIsValid)
    {
      //The actual algorithm
      String result = theAlgorithm(base, numberOfDigit, numberA, numberB);

      //Print the result
      System.out.printf("(Base %d) %s + %s = %s\n", base, numberA, numberB, result);
      System.out.printf("(Base 10) %d + %d = %d",
        Integer.parseInt(numberA,base),
        Integer.parseInt(numberB,base),
        Integer.parseInt(result,base));

      return 0;
    }
    else
    {
      System.out.println("Base or Number is not valid");
      return -1;
    }
  }

  //return the sum of two numbers in the given base
  private static String theAlgorithm(int base, int numberOfDigit, String numberA, String numberB) {
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

  //parse the char to int, base upto 16
  private static int parseInt(char c) {
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
}
