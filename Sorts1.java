public class Sorts1 {
   public static int selectionSort(int[] arr, int n) {
      int temp, minIndex, comps = 0;

      for (int i = 0; i < n; i++) {
         minIndex = i;
         for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[minIndex]) {
               minIndex = j;
            }
            comps++;
         }
         temp = arr[i];
         arr[i] = arr[minIndex];
         arr[minIndex] = temp;
      }
      return comps;
   }
   
   // private static int findMin(int[] arr, int start) {
   //    int minIndex = start;

   //    for (int i = start + 1; i < arr.length; i++) {
   //       if (arr[i] < arr[minIndex]) {
   //          minIndex = i;
   //       }
   //    }
   //    return minIndex;
   // }

   public static int mergeSort(int[] arr, int n) {
      return mergeSort(arr, 0, n - 1);
   }

   private static int mergeSort(int[] arr, int first, int last) {
      int comps = 0;

      if (first < last) {
         int middle = (first + last) / 2;
         comps += mergeSort(arr, first, middle);
         comps += mergeSort(arr, middle + 1, last);
         comps += mergeSortedHalves(arr, first, middle, last);
      }
      return comps;
   }

   private static int mergeSortedHalves(int[] arr, int left, int middle, int right) {
      int[] temp = new int[right - left + 1];
      int index1 = left;
      int index2 = middle + 1;
      int tempIndex = 0;
      int comps = 0;

      while (index1 < middle + 1 && index2 < right + 1) {
         if (arr[index1] < arr[index2]) {
            temp[tempIndex] = arr[index1];
            index1++;
         }
         else {
            temp[tempIndex] = arr[index2];
            index2++;
         }
         comps++;
         tempIndex++;
      }
      if (index1 == middle + 1) {
         for (; index2 < right + 1; index2++) {
            temp[tempIndex++] = arr[index2];
         }
      }
      else {
         for (; index1 < middle + 1; index1++) {
            temp[tempIndex++] = arr[index1];
         }
      }
      for (int i = 0; i < temp.length; i++) {
         arr[left++] = temp[i];
      }
      return comps;
   }

   public static int quickSort(int[] arr, int n) {
      return quickSort(arr, 0, n - 1);
   }
   
   private static int quickSort(int[] arr, int first, int last) {
      int comps = 0;
      int[] splitListResult;

      if (first < last) {
         comps += setPivotToEnd(arr, first, last);
         splitListResult = splitList(arr, first, last);
         comps += splitListResult[1];
         comps += quickSort(arr, first, splitListResult[0] - 1);
         comps += quickSort(arr, splitListResult[0] + 1, last);
      }
      return comps;
   }
   
   private static int setPivotToEnd(int[] arr, int left, int right) {
      int center = (left + right) / 2;
      int[] order = findMinOfThree(arr[left], arr[center], arr[right]);

      arr[left] = order[0];
      arr[center] = order[1];
      arr[right] = order[2];

      return order[3];
   }
   
   private static int[] splitList(int[] arr, int left, int right) {
	  int indexL = left;
	  int indexR = right - 1;
	  int pivot = right;
     int comps = 0;
     int[] result = new int[2];
	  
	  while (indexL <= indexR) {
		  while (arr[indexL] < arr[pivot]) {
			  indexL++;
           comps++;
         }
         comps++;
		  while (arr[indexR] > arr[pivot] && indexR >= indexL) {
			  indexR--;
           comps++;
         }
         comps++;
		  if (indexL <= indexR) {
			  swap(arr, indexL, indexR);
			  indexL++;
			  indexR--;
		  }
	  }
	  swap(arr, indexL, pivot);
     result[0] = indexL;
     result[1] = comps;
	  
	  return result;
   }

   private static int[] findMinOfThree(int a, int b, int c) {
      int[] result = new int[4];
      result[3] = 0;

      if (a < b) {
         if (b < c) {
            result[0] = a;
            result[1] = b;
            result[2] = c;
         }
         else {
            if (a < c) {
               result[0] = a;
               result[1] = c;
               result[2] = b;
            }
            else {
               result[3]++;
               result[0] = c;
               result[1] = a;
               result[2] = b;
            }
            result[3]++;
         }
         result[3]++;
      }
      else {
         if (a < c) {
            result[0] = b;
            result[1] = a;
            result[2] = c;
         }
         else {
            if (b < c) {
               result[0] = b;
               result[1] = c;
               result[2] = a;
            }
            else {
               result[0] = c;
               result[1] = b;
               result[2] = a;
            }
            result[3]++;
         }
         result[3]++;
      }
      result[3]++;

      return result;
   }
   
   private static void swap(int[] arr, int first, int second) {
	   int temp = arr[first];
	   arr[first] = arr[second];
	   arr[second] = temp;
   }
}
