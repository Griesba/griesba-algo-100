public class QuickSort <T> {
	
	private T[] array;
	private int N;
	
	public QuickSort(T[] array, int N){
		this.array = new T[N];
		this.N = N;
	}

	public int choiceOfPivotWithMedianOfThree (T[] array, int lo, int hi) {
		// https://en.wikipedia.org/wiki/Quicksort#Choice_of_pivot
		int pivot = (lo + hi)/2;
		if(array[lo] > array[pivot]) {
			swap(array, lo, pivot);
		}
		if (array[lo] > array[hi] ) {
			swap(array, lo, hi);
		}
		if (array[pivot] > array[hi]) {
			swap(array, pivot, hi);
		}
	}
	
	public  void swap(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public  void quicksort(T[] array, int lo, int hi) {
		if( lo < hi) {
			int pivot = partition(array, lo, hi);
			quicksort(array, lo, pivot);
			quicksort(array, pivot + 1, hi);
		}
	}
	
	public  void partition (T [] array, int lo, int hi) {
		int pivot = choiceOfPivotWithMedianOfThree(array, lo, hi);
		int i = lo;
		int j = hi;
		while(true) {
			while(array[i]< pivot) {
				i++;
			}
			while(array[j > pivot]) {
				j--;
			}
			if (i >= j) {
				return j;
			}
			swap(array, i, j);
		}
		
	}	

}