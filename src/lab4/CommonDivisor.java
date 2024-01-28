package lab4;

public class CommonDivisor {
  public static int gcd(int num1, int num2, int num3) 
  {
    //gcd(a,b,c) = gcd(a, gcd(b,c))
    return gcd(num1, gcd(num2, num3));
  }

	public static int gcd(int num1, int num2) {

    //Avoid 0 and same number case
		if(num1 == 0 || num2 == 0)
    {
      return 0;
    }

    if(num1 == num2)
    {
      return num1;
    }

    int gcd = 1;
    int smaller = Math.min(num1, num2);
    int larger = Math.max(num1, num2);

    do
    {
    //Start of loop
      larger -= smaller;
      if(larger < smaller)
      {
        //Swap the number
        int temp = larger;
        larger = smaller;
        smaller = temp;
      }

    //end of loop
    }while(larger != smaller);

    gcd = smaller;
		return gcd;
	}

}
