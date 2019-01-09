
public class MyClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myclass1 t1 = new myclass1(10);
		myclass1 t2 = new myclass1(20);

		System.out.println("myclass T1:" + t1.x + "class T2:" + t2.x);
	}

}


 class myclass1  {
	int x;
	
	myclass1(int i){
		x = i;
	}
}