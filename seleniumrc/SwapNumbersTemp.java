import java.util.Scanner;

public class SwapNumbersTemp{


	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the Ist Number:");
		int num1 = scan.nextInt();
		
		@SuppressWarnings("resource")
		Scanner scan1 = new Scanner(System.in);
		System.out.println("Enter the 2nd Number:");
		int num2 = scan1.nextInt();
		
			System.out.println("Before Swap:");
			System.out.println("Num1:" + num1);
			System.out.println("Num2:" + num2);
			
			int temp = num1;
				num1 = num2;
				num2 = temp;
			
			System.out.println("After Swap:");
			System.out.println("Num1:" + num1);
			System.out.println("Num2:" + num2);
	}
				
}