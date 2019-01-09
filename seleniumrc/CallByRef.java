
public class CallByRef {
		
	int a;
	int b;
	//private static CallByRef cf;
	
	public static void main(String[] args) {
		CallByRef cf = new CallByRef();
		cf.a = 10;
		cf.b = 20;
		
		cf.swap(cf);
		System.out.println("---------------------");
		cf.sum(cf);
		
	}

	public void swap(CallByRef t){
		int c = a+b;
		System.out.println(c);	
		System.out.println("---------------------");
		int p = t.a;
		System.out.println(p);
	}
	
	public void sum(CallByRef cf){
		int z = cf.b;
		System.out.println(z);
	}
	
	
}
