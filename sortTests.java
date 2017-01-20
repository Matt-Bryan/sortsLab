public class sortTests {
   public static void main(String[] args) {
      int[] selectArr = {4,7,2,8,1,6,9,8};

      Sorts.selectionSort(selectArr, selectArr.length);
      for (int i = 0; i < selectArr.length; i++) {
         System.out.println(selectArr[i]);
      }

      int[] mergeArray = {3, 3, 4, 5, 16, 7, 1, 36, 26, 75, -1};
      Sorts.mergeSort(mergeArray, mergeArray.length);
      for (int i = 0; i < mergeArray.length; i++) {
         System.out.println(mergeArray[i]);
      }

      int[] quickArray = {2, 6, 7, 0, -1, 4, 8, 8};
      Sorts.quickSort(quickArray, quickArray.length);

      for (int i = 0; i < quickArray.length; i++) {
         System.out.println(quickArray[i]);
      }
   }
}
