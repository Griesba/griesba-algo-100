public class Main {

	public static void main(String[] args) {

		
		QuickSort<String> qs = new QuickSort<>(String[].class, 10);
		
		String[] array = new String[]{"b", "c", "e", "r"};
		
		qs.quicksort(array, 0, 3);
		
		for(int i=0; i<4; i++) {
			System.out.println(array[i]);
		}
	}
}