
public class  Minnumber {

	public static void main(String[] args) {
		int a = 6;
		int b = 11;
		int c = minFunction(a,b);
		System.out.println("Minimum number is :" + c);
		
		double d = 4.5;
		double e = 5.7;
		double f = minFunction(d,e);
		System.out.println("Minimum nuslember is :" + f);

	}
	
	public static int minFunction(int n1, int n2) {
		int min;
		if (n1>n2)
			min = n2;
		else
			min = n1;	
		
		return min;
		
	}

	public static double minFunction(double n1, double n2) {
		double min;
		if (n1>n2)
			min = n2;
		else
			min = n1;	
		
		return min;
	
	}
	
}


