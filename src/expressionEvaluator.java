
public class expressionEvaluator {

	public static void main(String[] args) {
//		int a = interpreter("2+2*5+2*2");
//		System.out.println(a);
		
		expEval("222", 24, 1);
	}
	
	public static void expEval(String input, Integer target, Integer spot) {
		if (interpreter(input) == target) {
			System.out.println(input);
		}
		for (int i = spot; i < input.length(); i++) {
			//System.out.println(input.substring(0,i) + " ? " + input.substring(i, input.length()));
			expEval(input.substring(0,i) + "*" + input.substring(i, input.length()), target, spot+2);
			expEval(input.substring(0,i) + "+" + input.substring(i, input.length()), target, spot+2);
			spot++;
		}
	}
	
	public static int interpreter(String input) {
//		if(input.length() == 0) {
//			return 0;
//		}
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == '+') {
				return interpreter(input.substring(0, i)) + interpreter(input.substring(i + 1, input.length()));
			}
		}
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == '*') {
				return Integer.parseInt(input.substring(0, i)) * interpreter(input.substring(i + 1, input.length()));
			}
			if(i == input.length() - 1) {
				return Integer.parseInt(input);
			}
		}
		return -1; //my terrible error message
	}
}
