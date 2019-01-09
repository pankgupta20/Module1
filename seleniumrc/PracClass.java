
public class PracClass {

	public static void main(String[] args) {

		int num = 2;
		int flag = 0;
		System.out.println("Prime number list in first 100 are: ");
		while (num <= 100) {
			for (int i = 1; i < num; i++) {
				if (num % i == 0) {
					flag = 1;
					break;
				}

				if (flag == 0) {
					System.out.print(num + ",");
				}
				num++;
			}
		}

	}

}
