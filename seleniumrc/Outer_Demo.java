/*
public class Outer_Demo {
	int num;

	private class Inner_Demo {
		public void print() {
			System.out.println("This is my inner class");
		}
	}

	void display_inner() {
		Inner_Demo inner = new Inner_Demo();
		inner.print();

	}

	public static class My_Class {
		public static void main(String args[]) {
			Outer_Demo outer = new Outer_Demo();
			outer.display_inner();
		}
	}
}*/

/*public class Outer_Demo {
	
	void my_method(){
	int num=175;
	
	class methodinner_demo{
		public void print(){
			System.out.println("This is the method inner class: "+ num);
		}
	}
	
	methodinner_demo inner = new methodinner_demo();
	inner.print();
	}
	
	public static void main(String args[]){
		Outer_Demo outer = new Outer_Demo();
		outer.my_method();
	}
		
}*/


public class Outer_Demo {
	static class inner_demo{
		public static void main(){
			System.out.println("This is my static class");
		}
	}
	
	public static void main(String args[]){
		@SuppressWarnings("unused")
		Outer_Demo.inner_demo inner = new Outer_Demo.inner_demo();
		inner_demo.main();
	}
	
}

