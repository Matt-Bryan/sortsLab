import java.util.Random;

public class SortCounts {
	public static void main(String[] args) {
		Random rand = new Random();
		long selectCount = 0, mergeCount = 0, quickCount = 0;
		int[] selectSort, mergeSort, quickSort;
		
                System.out.println("Average number of element-comparisons in three sorting algorithms:\n");

		for (int n = 100; n <= 12800; n*=2) {
			selectSort = new int[n];
			mergeSort = new int[n];
			quickSort = new int[n];
			
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < n; j++) {
					int num = rand.nextInt();
					selectSort[j] = num;
					mergeSort[j] = num;
					quickSort[j] = num;
				}
				selectCount += Sorts1.selectionSort(selectSort, n);
				mergeCount += Sorts1.mergeSort(mergeSort, n);
				quickCount += Sorts1.quickSort(quickSort, n);				
			}
			System.out.println("N = " + n + ": C_ss = " + (selectCount / 100) + ", C_ms = " + (mergeCount / 100) + ", C_qs = " + (quickCount / 100));
                        selectCount = mergeCount = quickCount = 0;
		}
		System.out.println("\nEnd of output\n");
	}
}
