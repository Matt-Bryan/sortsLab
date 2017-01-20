public class Sorts {
   public static void selectionSort(int[] arr, int n) {
      int temp, minIndex;

      for (int i = 0; i < n; i++) {
         minIndex = findMin(arr, i);
         temp = arr[i];
         arr[i] = arr[minIndex];
         arr[minIndex] = temp;
      }
   }

   public static void mergeSort(int[] arr, int n) {
      mergeSort(arr, 0, n - 1);
   }

   private static void mergeSort(int[] arr, int first, int last) {
      if (first < last) {
         int middle = (first + last) / 2;
         mergeSort(arr, first, middle);
         mergeSort(arr, middle + 1, last);
         mergeSortedHalves(arr, first, middle, last);
      }
   }

   private static void mergeSortedHalves(int[] arr, int left, int middle, int right) {
      int[] temp = new int[right - left + 1];
      int index1 = left;
      int index2 = middle + 1;
      int tempIndex = 0;

      while (index1 < middle + 1 && index2 < right + 1) {
         if (arr[index1] < arr[index2]) {
            temp[tempIndex] = arr[index1];
            index1++;
         }
         else {
            temp[tempIndex] = arr[index2];
            index2++;
         }
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
   }

   public static void quickSort(int[] arr, int n) {
      quickSort(arr, 0, n - 1);
   }
   
   private static void quickSort(int[] arr, int first, int last) {
      if (first < last) {
         setPivotToEnd(arr, first, last);
         int pivotIndex = splitList(arr, first, last);
         quickSort(arr, first, pivotIndex - 1);
         quickSort(arr, pivotIndex + 1, last);
      } 
   }
   
   private static void setPivotToEnd(int[] arr, int left, int right) {
      int center = (left + right) / 2;
      int[] order = findMinOfThree(arr[left], arr[center], arr[right]);

      arr[left] = order[0];
      arr[center] = order[1];
      arr[right] = order[2];

   }
   
   private static int splitList(int[] arr, int left, int right) {
	  int indexL = left;
	  int indexR = right - 1;
	  int pivot = right;
	  
	  while (indexL <= indexR) {
		  while (arr[indexL] < arr[pivot])
			  indexL++;
		  while (arr[indexR] > arr[pivot] && indexR >= indexL)
			  indexR--;
		  if (indexL <= indexR) {
			  swap(arr, indexL, indexR);
			  indexL++;
			  indexR--;
		  }
	  }
	  swap(arr, indexL, pivot);
	  
	  return indexL;
   }
   
   private static int findMin(int[] arr, int start) {
      int minIndex = start;

      for (int i = start + 1; i < arr.length; i++) {
         if (arr[i] < arr[minIndex]) {
            minIndex = i;
         }
      }
      return minIndex;
   }

   private static int[] findMinOfThree(int a, int b, int c) {
      int[] result = new int[3];

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
               result[0] = c;
               result[1] = a;
               result[2] = b;
            }
         }
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
         }
      }

      return result;
   }
   
   private static void swap(int[] arr, int first, int second) {
	   int temp = arr[first];
	   arr[first] = arr[second];
	   arr[second] = temp;
   }
}
