
public class MyFirstJavaProgram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	/*	String str1 = "Pankaj";
		String str2 = "pankaj gupta is my name";
		
		System.out.println("Hello World");
		System.out.println(str1 +  " "  +str2);
		System.out.println(str2.length());

		int i;
		for (i =1;i<=str2.length();i++){
			System.out.println(args[i]);
		}
		
		int x = 17;
		String str3 = "london";
		x = x*2;
		Double d = Math.random();
		System.out.println(str3 + " "+ d );*/
/*		
		int x = 1;
		 while (x < 4) {
			System.out.println(x); 
			x = x+1;*/
			
		
/*		String[] wordListOne = {"my", "name", "is", "pankaj"};
		String[] wordListTwo = {"I", "Work", "in", "london"};
		
		int oneLength = wordListOne.length;
		int twoLength = wordListTwo.length;
		
		int rand1 = (int) (Math.random()*oneLength);
		int rand2 = (int) (Math.random()*twoLength);
		
		String phrase = wordListOne[rand1] + " " + wordListTwo[rand2];
		System.out.println(phrase);		*/
		
		
		int x = 0;
		int y = 0;
		
		while (x<5) {
			y = y+x;
			System.out.println(x + " " + y);
			x = x+1;
		}
		
	}
}