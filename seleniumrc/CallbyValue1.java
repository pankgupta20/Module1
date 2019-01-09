
public class CallbyValue1 {
	int data = 50;

	void change(CallbyValue1 cv1) {
		cv1.data = cv1.data + 50;
	}

	public static void main(String[] args) {
		CallbyValue1 cv1 = new CallbyValue1();
		System.out.println(cv1.data);

		cv1.change(cv1);

		System.out.println(cv1.data);

	}

}
