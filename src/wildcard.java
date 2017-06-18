
public class wildcard {
	
	public static void main (String[] args) {
		processor("?01010101?", "");
		
	}
	
	public static void processor (String input, String soFar) {
		if (input.length() == 0 && soFar.length() > 0) {
			System.out.println(soFar);
		}
		if (input.length() > 0) {
			if (input.charAt(input.length() - 1) == '?') {
				processor(input.substring(0, input.length() - 1), 1 + soFar);
				processor(input.substring(0, input.length() - 1), 0 + soFar);
			} else if (input.charAt(input.length() - 1) == '1' || input.charAt(input.length() - 1) == '0') {
				processor(input.substring(0, input.length() - 1), input.charAt(input.length() - 1) + soFar);
			}
		}
	}

}
