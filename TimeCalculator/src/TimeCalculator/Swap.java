package TimeCalculator;

public class Swap {
	
	public static void main(String[] args){
		System.out.println(swapString("abcdefg"));
		System.out.println(swapString("abc"));
	}
	
	public static String swapString(String s) {
	     if (s.length() < 2)
	          return s;
	     else
	          return ""+ s.charAt(1) + s.charAt(0) + swapString(s.substring(2));
	}

	private static String swap(char A, char B) {
		// TODO Auto-generated method stub
		return ""+ B + A;
	}
	
	
}
