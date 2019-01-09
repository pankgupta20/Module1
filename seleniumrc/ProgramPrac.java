import java.util.Arrays;

public class ProgramPrac {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		int size = arr.length;
		int n = 2;
		int temp;

		for (int i = 0; i < n; i++) {
			temp = arr[0];

			for (int j = 0; j < size - 1; j++) {
				arr[j] = arr[j + 1];
			}
			arr[size - 1] = temp;
		}

		System.out.println(Arrays.toString(arr));
	}
}
