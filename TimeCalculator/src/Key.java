public class Key {
	
	public static void main(String[] args) {
		
		
		System.out.println(key("Hello, 1234."));
		System.out.println(key("write me. don't write me."));
		System.out.println(key("23-@#$% TEST."));
		System.out.println(key("one two three four."));
		System.out.println(key("ONE TWO THREE FOUR."));
	}

	public static String key(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '.') {
				sb.append(c);
				return sb.toString();
			}

			if (c == ' ' || Character.isUpperCase(c)) {
				sb.append(c);
			}
			if (Character.isLowerCase(c)) {
				sb.append(Character.toUpperCase(c));
			} 
		}
		return sb.toString();
	} 
}
