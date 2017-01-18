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
      int random = left;
      for (int i = 0; i < temp.length; i++) {
         arr[random++] = temp[i];
      }
   }

   public static void quickSort(int[] arr, int n) {
       
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
   
   }
   
   private static int splitList(int[] arr, int left, int right) {
  
   }
   
   private static int findMin(int[] arr, int start) {
      int minIndex = start;

      for (int i = start; i < arr.length; i++) {
         if (arr[i] < arr[minIndex]) {
            minIndex = i;
         }
      }
      return minIndex;
   }
}
