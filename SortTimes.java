import java.util.Random;

public class SortTimes {
	public static void main(String[] args) {
		Random rand = new Random();
		int[] selectSort, mergeSort, quickSort;
		
                System.out.println("Running Times of three sorting algorithms:\n");

		for (int n = 5000; n <= 160000; n*=2) {
			selectSort = new int[n];
			mergeSort = new int[n];
			quickSort = new int[n];
			
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < n; j++) {
					int num = rand.nextInt();
					selectSort[j] = num;
					mergeSort[j] = num;
					quickSort[j] = num;
				}
				long selectBefore = System.nanoTime();
				Sorts.selectionSort(selectSort, n);
				long selectAfter = (System.nanoTime() - selectBefore) / 1000000;
				long mergeBefore = System.nanoTime();
				Sorts.mergeSort(mergeSort, n);
				long mergeAfter = (System.nanoTime() - mergeBefore) / 1000000;
				long quickBefore = System.nanoTime();
				Sorts.quickSort(quickSort, n);
				long quickAfter = (System.nanoTime() - quickBefore) / 1000000;
				
				System.out.println("N = " + n + ": T_ss = " + selectAfter + ", T_ms = " + mergeAfter + ", T_qs = " + quickAfter);
			}
                        System.out.println();
		}
                System.out.println("End of Output\n");
	}
}
