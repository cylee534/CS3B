package lab5;

public class ArrayFun {
  public static void main(String[] args)
  {
    int[] array = {1,2,3,4,5,6,7,8,9,10};
    int key = 10;
    int index = linearSearch(key, array);
    System.out.println("Linear Search: " + index);
  
    index = binarySearch(key, array, 0, array.length);
    System.out.println("Binary Search: " + index);
  
    // Test cases for binarySearch
    int[] testArray = {1, 3, 5, 7, 9, 11, 13, 15};
    int testKey = 7;
  
    // Test case 1: Key is present in the array
    int testIndex = binarySearch(testKey, testArray, 0, testArray.length);
    System.out.println("Binary Search Test Case 1: " + testIndex); // Expected output: 3
  
    // Test case 2: Key is not present in the array
    testKey = 8;
    testIndex = binarySearch(testKey, testArray, 0, testArray.length);
    System.out.println("Binary Search Test Case 2: " + testIndex); // Expected output: -1
  
    // Test case 3: Key is the first element of the array
    testKey = 1;
    testIndex = binarySearch(testKey, testArray, 0, testArray.length);
    System.out.println("Binary Search Test Case 3: " + testIndex); // Expected output: 0
  
    // Test case 4: Key is the last element of the array
    testKey = 15;
    testIndex = binarySearch(testKey, testArray, 0, testArray.length);
    System.out.println("Binary Search Test Case 4: " + testIndex); // Expected output: 7
  
    // Test case 5: Key is greater than all elements in the array
    testKey = 20;
    testIndex = binarySearch(testKey, testArray, 0, testArray.length);
    System.out.println("Binary Search Test Case 5: " + testIndex); // Expected output: -1
  
    // Test case 6: Key is smaller than all elements in the array
    testKey = -5;
    testIndex = binarySearch(testKey, testArray, 0, testArray.length);
    System.out.println("Binary Search Test Case 6: " + testIndex); // Expected output: -1
    

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
    int index = -1;
    int mid = start;
    int midKey;

    while(start < end)
    {
      mid = start + (end - start)/2;
      midKey = array[mid];
      if(key > midKey)
      {
        start = mid + 1;
      }
      else if(key < midKey)
      {
        end = mid - 1;
      }
      else return mid;
    }

    return -start - 1;
  }

  public static int binarySearch(String key, String[] array, int start, int end)
  {
    int index = -1;
    int mid = start;
    String midKey = null;

    while(start < end)
    {
      mid = start + (end - start)/2;
      midKey = array[mid];

      if(key.compareToIgnoreCase(midKey) > 0)
      {
        start = mid + 1;
      }
      else if(key.compareToIgnoreCase(midKey) < 0)
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

}
