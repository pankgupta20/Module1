import java.util.Scanner;

public class ReverseString {

  public static void main(String[] args) 	
  {
	  int num;
	  @SuppressWarnings("resource")
	Scanner in = new Scanner(System.in);
	  System.out.println("Enter the number");
	  num = in.nextInt();
	  
	  for(int i=1;i<=num;i++){
		  for (int j=1;j<=i;j++){
			  System.out.print(" "+i+" ");
		  }
		  
		  System.out.println("\n");
	  }
	  
  }  
}

