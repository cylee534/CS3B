package myHelper;

public class ArrayFun {
  public static void main(String[] args)
  {

    // Test cases for binarySearch
    int[] testArray = {1, 3, 5, 7, 9, 11, 13, 15};
    printArray(testArray);

    // Test case 1: Key is present in the array
    int testKey = 7;
    int testIndex = binarySearch(testKey, testArray, 0, testArray.length) - 1;
    System.out.println("Binary Search Test Case 1: testKey " + testKey + " index: " + testIndex); // Expected output: 3
  
    // Test case 2: Key is not present in the array
    testKey = 8;
    testIndex = binarySearch(testKey, testArray, 0, testArray.length - 1);
    System.out.println("Binary Search Test Case 2: testKey " + testKey + " index: " + testIndex); // Expected output: -1
  
    // Test case 3: Key is the first element of the array
    testKey = 1;
    testIndex = binarySearch(testKey, testArray, 0, testArray.length - 1);
    System.out.println("Binary Search Test Case 3: testKey " + testKey + " index: " + testIndex); // Expected output: 0
  
    // Test case 4: Key is the last element of the array
    testKey = 15;
    testIndex = binarySearch(testKey, testArray, 0, testArray.length - 1);
    System.out.println("Binary Search Test Case 4: testKey " + testKey + " index: " + testIndex); // Expected output: 7
  
    // Test case 5: Key is greater than all elements in the array
    testKey = 20;
    testIndex = binarySearch(testKey, testArray, 0, testArray.length - 1);
    System.out.println("Binary Search Test Case 5: testKey " + testKey + " index: " + testIndex); // Expected output: -1
  
    // Test case 6: Key is smaller than all elements in the array
    testKey = -5;
    testIndex = binarySearch(testKey, testArray, 0, testArray.length - 1);
    System.out.println("Binary Search Test Case 6: testKey " + testKey + " index: " + testIndex); // Expected output: -1
    

  }

  public static String[] selectionSort(String[] arr)
  {
    for(int i = 0; i < arr.length; i++)
    {
      int larger = i;
      for(int j = i + 1; j < arr.length; j++)
      {
        //if current element is bigger than the larger element
        if(arr[larger].compareToIgnoreCase(arr[j]) > 0)
        {
          larger = j;
        }
      }

      if(larger != i)
      {
        String temp = arr[i];
        arr[i] = arr[larger];
        arr[larger] = temp;
      }
    }
    return arr;
  }

  public static int linearSearch(int key, int[] array)
  {
    int index = -1;

    for(int i = 0; i < array.length; ++i)
    {
      if(array[i] == key)
      {
        index = i;
        break;
      } 
    }
    return index;
  }

  public static int binarySearch(int key, int[] array, int start, int end)
  {
    int mid = start;
    while(start <= end)
    {
      mid = (start + end)/2;
      if(key == array[mid])
        return mid;
      else if(key < array[mid])
        end = mid - 1;
      else 
        start = mid + 1;
    }
    return -start - 1;
  }

  public static int binarySearch(String key, String[] array, int start, int end)
  {
    int mid = start;

    while(start <= end)
    {
      mid = start + (end - start)/2;
      if(key.compareToIgnoreCase(array[mid]) > 0)
      {
        start = mid + 1;
      }
      else if(key.compareToIgnoreCase(array[mid]) < 0)
      {
        end = mid - 1;
      }
      else return mid;
    }

    return -start - 1;  
  }

  public static void initArray(int[] arr, int value)
  {
    for( int i = 0; i < arr.length; ++i)
      arr[i] = value;
  }

  public static void printArray(int[] array, int maxNumperLine, int sentinal)
  {
    int count = 0;
    if(maxNumperLine <= 0) maxNumperLine = array.length;

    for(int i = 0; i < array.length; ++i)
    {
      if(array[i] == sentinal) break;
      
      String num = String.format("%4d ", array[i]);
      System.out.print(num);
      if (count == maxNumperLine)
      {
        System.out.println();
        count = 0;
      }
      else ++count;
    }
    System.out.println("");
  }
  
  public static void printArray(int[] array, int maxNumperLine)
  {
    int count = 0;
    if(maxNumperLine <= 0) maxNumperLine = array.length;

    for(int i = 0; i < array.length; ++i)
    {
      System.out.print(array[i] + " ");
      if (count == maxNumperLine)
      {
        System.out.println();
        count = 0;
      }
      else ++count;
    }
    System.out.println("");
  }
  
  public static void printArray(int[] array)
  {
    printArray(array, array.length);
  }

}
