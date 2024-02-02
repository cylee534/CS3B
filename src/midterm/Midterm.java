package midterm;

import java.util.Scanner;

import midterm.Asker_Midterm;

public class Midterm {
  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String[][] data = getReaderData(in);
    if(data != null)
    {
    //Age Group
      System.out.println("");
      int[] ageGroup = getAgeGroup(data);
      System.out.println("Age group: <20: " + ageGroup[0] 
      + "\n 20-29: " + ageGroup[1] 
      + "\n 30-39: " + ageGroup[2] 
      + "\n 40-49: " + ageGroup[3] 
      + "\n >=50: " + ageGroup[4]);

    //Gender Age Group
      System.out.println("");
      int[] genderAgeGroup = getGenderAgeGroup(data);
      String[] fm = {"F", "M"};
      for(int i = 0; i < 2; i++)
      {
        System.out.println("Age Group("  + fm[i] + ")" );
        System.out.println(" <20: " + genderAgeGroup[0 + i] 
          + "\n 20-29: " + genderAgeGroup[2 + i] 
          + "\n 30-39: " + genderAgeGroup[4 + i] 
          + "\n 40-49: " + genderAgeGroup[6 + i] 
          + "\n >=50: " + genderAgeGroup[8 + i]);
      }
    
    //Income Group
      System.out.println("");
      int[] incomeGroup = getIncomeGroup(data);
      System.out.println("Income group: <30K: " + incomeGroup[0]
      + "\n 30-49.999K: " + incomeGroup[1]
      + "\n 50,000-69.999K: " + incomeGroup[2]
      + "\n >=70K: " + incomeGroup[3]);

      System.out.println("");
      System.out.println("End of report.");
    }
    else
      System.out.println("No data to record. Exiting...");
  }
  

  //@ return: Data array ; ID|Age|Gender|Marital|AnnualIncome 
  public static String[][] getReaderData(Scanner in)
  {
    final int MAX = 1000;
    int n = 0;
    String[][] data;
    
    //Init data array
    n = Asker_Midterm.askNumber(in, "How many reader record you have today?: ", 0, MAX);
    if(n == 0)
      return null;
    
    data = new String[n + 1][5];
    int count = 0;
    boolean done = false;
    boolean disable_askDone = false;
    while(!done)
    {
      System.out.println("\nRecord# " + (count + 1) + ":");
      data[count][0] = Integer.toString(count + 1);
      data[count][1] = getAge(in);
      data[count][2] = getGender(in);
      data[count][3] = getMarital(in);
      data[count][4] = getIncome(in);
      count++;
      if(count == n)
        done = true;
      else
        if(!disable_askDone)
          done = !Asker_Midterm.askYesNo(in, "Do you want to enter another record?");
    }
    
    data[count][0] = "-1";
    return data;
  }

  
  public static String getAge(Scanner in)
  {
    String age = Integer.toString(Asker_Midterm.askNumber(in, "Enter age: ", 0, 120));
    return age;
  }

  public static String getGender(Scanner in)
  {
    String gender = Asker_Midterm.askTargetString(in, "Enter gender (M/F) :", new String[]{"M","F"});
    return gender;
  }

  public static String getMarital(Scanner in)
  {
    String marital = Asker_Midterm.askTargetString(in, "Enter marital status(S/M) :", new String[]{"S", "M"});
    return marital;
  }

  public static String getIncome(Scanner in)
  { 
    String income = Integer.toString(Asker_Midterm.askNumber(in, "Enter annual income: ", 0,100_000_000));
    return income;
  }


  //@ return: Age group array; [<20|  20-29| 30-39| 40-49| >=50]
  public static int[] getAgeGroup(String[][] data)
  {
    int[] group = new int[5];
    boolean done =  false;
    int count = 0;
    while(!done)
    {
      int age = Integer.parseInt(data[count][1]);
      if(age < 20)
        group[0]++;
      else if(age >= 20 && age <= 29)
        group[1]++;
      else if(age >= 30 && age <= 39)
        group[2]++;
      else if(age >= 40 && age <= 49)
        group[3]++;
      else
        group[4]++;

      count++;
      done = data[count][0].compareTo("-1") == 0 ? true : false;
    }
    return group;
  }

  //@ return: Age group array; [<20M | <20F| 20-29M | 20-29F|...| >=50F| >=50]
  public static int[] getGenderAgeGroup(String[][]data)
  {
    int[] group = new int[10];
    int count = 0;
    boolean done =  false;
    while(!done)
    {
      int age = Integer.parseInt(data[count][1]);
      if(age < 20)
      {
        if(data[count][2].compareTo("M") == 0)
          group[0]++;
        else
          group[1]++;

      }
      else if(age >= 20 && age <= 29)
      {
        if(data[count][2].compareTo("M") == 0)
          group[2]++;
        else
          group[3]++;
      }
      else if(age >= 30 && age <= 39)
      {
        if(data[count][2].compareTo("M") == 0)
          group[4]++;
        else
          group[5]++;
      }
      else if(age >= 40 && age <= 49)
      {
        if(data[count][2].compareTo("M") == 0)
          group[6]++;
        else
          group[7]++;
      }
      else
      {
        if(data[count][2].compareTo("M") == 0)
          group[8]++;
        else
          group[9]++;
      }
      count++;
      done = data[count][0].compareTo("-1") == 0 ? true : false;
    }

    return group;
  }

  //@ return: Annual income group array; [<30K|  30-49.999K| 50,000-69.999K| >=70K]
  public static int[] getIncomeGroup(String[][] data)
  {
    int[] group = new int[4];
    boolean done =  false;
    int count = 0;
    while(!done)
    {
      int income = Integer.parseInt(data[count][4]);
      if(income < 30_000)
        group[0]++;
      else if(income >= 30_000 && income <= 49_999)
        group[1]++;
      else if(income >= 50_000 && income <= 69_999)
        group[2]++;
      else
        group[3]++;

      count++;
      done = data[count][0].compareTo("-1") == 0 ? true : false;
    }

    return group;
  }
}
